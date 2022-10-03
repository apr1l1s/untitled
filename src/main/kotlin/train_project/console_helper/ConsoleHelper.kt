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
        if (stringOfTrain.isNullOrEmpty()) println("Ошибка, пустая строка")
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
    private fun show(){
        println("Сортировку по какому столбцу?")
        val columnSortedBy = readLine()
        if(columnSortedBy == null){
            println("Вы ввели пустую строку")
            show()
        }else{
            database.search({ it.station.isNotEmpty() }).sortedBy{
                when(columnSortedBy){
                    "Вокзал"->it.station
                    "Номер"->it.number
                    else->it.station
                }
            }.forEach {println(it.toString())}
            start()
        }
    }
    fun start(){
        val command = readLine()
        if (command.isNullOrEmpty()){
            println("Ошибка ввода:\nВы ввели пустую строку")
            start()
        }else{
            when(command){
                "Просмотр"->show()
                "Добавление"->add()
                "Удаление"->del()
            }
        }
    }
}