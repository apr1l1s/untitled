//С клавиатуры вводится информация о студентах: фамилия, имя, оцен-
//ки. Выведите на экран информацию о трех лучших студентах по сред-
//нему баллу. В случае, если у нескольких студентов средний балл сов-
//падает, то выведите большее число студентов (пока не будут выведе-
//ны все студенты или не будут полностью исчерпаны студенты с тремя
//лучшими баллами). Вывод надо осуществлять в порядке убывания
//среднего балла, а для одинаковых средних баллов – в алфавитном
//порядке по фамилии и имени.

fun main() {
    // Cафронов Александр Дмитриевич 5 2 3 4 5 4 5 4
    val list = mutableListOf<Pair<List<String>,Float>>()
    do{
        val buff = readLine()
        if (buff != null) {
            if (buff.isNotEmpty()){
                val student = buff.split(" ")
                val fio = listOf(student[0],student[1],student[2])
                val marks = student.subList(3,student.size)
                val avg = marks.sumOf { it.toInt() } / marks.size.toFloat()
                list.add(Pair(fio,avg))
                val universalComparator = Comparator{i1:Pair<List<String>,Float>,i2:Pair<List<String>,Float> ->
                    if (i1.second > i2.second) -1 else
                        if (i1.second < i2.second) 1 else
                            if (i1.first[0] > i2.first[0]) 1 else
                                if (i1.first[0] < i2.first[0]) -1 else
                                    if (i1.first[1] > i2.first[1]) 1 else
                                        if (i1.first[1] < i2.first[1]) -1 else 0

                }
                list.sortWith(universalComparator)
                println(list)
            }
        }
    }while(buff!="")
    //Нужно получить топ 3 средних балла и вывести студентов этих баллов
    val keys=list.groupBy{it.second}.keys.filterIndexed{index, _ -> index<3}
    list.filter{it.second in keys}.forEach{println(it.first.toString())}
}