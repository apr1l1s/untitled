package train_project.console_helper
import train_project.database.Database
import train_project.train.Train
import train_project.train.TrainTypes

object ConsoleHelper{
    private val database = Database()
    private fun del(){
        val deletedIndex = readLine()?.toInt()
        if (deletedIndex != null && deletedIndex in database.data.indices){
            database.del(deletedIndex)
            println("Успешно!")
            start()
        } else {
            println("Вы ввели неверный индекс")
            del()
        }
    }
    private fun add(){
        val stringOfTrain = readLine()?.trim()?.split(' ')
        if (stringOfTrain.isNullOrEmpty() || stringOfTrain.size != 4) {
            println("Ошибка, пустая строка")
        }
        else{
            val addedTrain = Train(
                station = stringOfTrain[0],
                number = stringOfTrain[1],
                countOfWagons = stringOfTrain[2].toInt(),
                types = TrainTypes.parseTrainTypes(stringOfTrain[3])
            )
            database.add(addedTrain)
            println("Успешно!")
        }
        start()
    }
    private fun edit(){
        //По индексу вводить новую инфу
        println("Введите индекс заменяемого элемента")
        val editedIndex = readLine()?.toInt()
        if (editedIndex != null && editedIndex in database.data.indices){
            //Ввести новый элемент
            println("Введите новый элемент")
            val stringOfTrain = readLine()?.trim()?.split(' ')
            if (stringOfTrain.isNullOrEmpty() || stringOfTrain.size != 4 ) {
                println("Ошибка, пустая строка")
                edit()
            }
            else {
                val addedTrain = Train(
                    station = stringOfTrain[0],
                    number = stringOfTrain[1],
                    countOfWagons = stringOfTrain[2].toInt(),
                    types = TrainTypes.parseTrainTypes(stringOfTrain[3])
                )
                database.replace(editedIndex, addedTrain)
                println("Успешно!")
                start()
            }
        } else {
            println("Вы ввели неверный индекс")
            edit()
        }
    }
    private fun search(){
        //Решить вопрос с индексацией
        println("Поиск по какому столбцу?")
        val columnSearchedBy = readLine()
        if(columnSearchedBy == null){
            println("Вы ввели пустую строку")
            show()
        }else{
            val rowSearchedBy = readLine()
            if (rowSearchedBy != null)
            database.search({
                when(columnSearchedBy){
                    "Вокзал"->it.station.contains(rowSearchedBy)
                    "Номер"->it.number.contains("")
                    else->true
                }
            }).forEachIndexed {
                    index,it ->
                println("$index"+it.toString())
            }
            start()
        }
    }
    private fun show(){
        println("Сортировку по какому столбцу?")
        val columnSortedBy = readLine()
        if(columnSortedBy == null){
            println("Вы ввели пустую строку")
            show()
        }else{
            database.search({true}).sortedBy{
                when(columnSortedBy){
                    "Вокзал"->it.station
                    "Номер"->it.number
                    else->it.station
                }
            }.forEachIndexed {
                    index,it ->
                println("$index"+it.toString())
            }
            start()
        }
    }
    private fun exit(){
        println("Завершение работы...")
    }
    fun start(){
        val command = readLine()
        if (command.isNullOrEmpty()){
            println("Ошибка ввода:\nВы ввели пустую строку")
            start()
        }else{
            when(command){
                "Просмотр"->show()
                "Поиск"->search()
                "Добавление"->add()
                "Редактирование"->edit()
                "Удаление"->del()
                "Выход"->exit()
                else->{
                    println("Неизвестная команда")
                    start()
                }
            }
        }
    }
}