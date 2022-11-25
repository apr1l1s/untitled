fun main() {
    //В строке указано несколько неотрицательных целых чисел, разделен-
    //ных пробелами (по одному пробелу между числами). Какое количе-
    //ство чисел удовлетворяет условию наличия повторяющихся цифр

    val str = readLine()
    if (str==null){
        println("Ошибка, введена пустая строка")
    } else {
        //123 1213 323231 12123
        var boolarr = Array(10){false}
        var count=0
        var answer=0
        for(i in str.indices){
            val ch=str[i]
            if (ch != ' ' ){
                if (!boolarr[ch.digitToInt()]) boolarr[ch.digitToInt()] = true
                else{
                    count++
                }
            }else{
                if (count!=0){
                    answer++
                }
                count=0
            }
        }
        if (count!=0){
            answer++
        }
        if (answer != 0) println(answer) else println("Таких чисел нет")
    }
}