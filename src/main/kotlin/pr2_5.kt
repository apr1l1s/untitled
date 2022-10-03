//Создайте функцию, которая реализует алгоритм второго задания первой
//практической работы, в которую все числа, слова или пары (в зависимости
//от варианта) передаются в аргументах функции. Например: f(123,25,222);
//f("dfd "dd "ddd"); d (Pair(2,3),Pair(3,5),Pair(4,1)).


//Убрать сплит
fun varargFunction(vararg arr:String):Int?{
    var count = 0
    for(word in arr){
        loop@for (i in word.indices){
            for(j in i+1 until word.length){
                if (word[i] == word[j]) {
                    count++
                    break@loop
                }
            }
        }
    }
    return if (count != 0) count else null
}

fun main() {
    var l2 = listOf(1,2,3)
    //В строке указано несколько неотрицательных целых чисел, разделен-
    //ных пробелами (по одному пробелу между числами). Какое количе-
    //ство чисел удовлетворяет условию наличия повторяющихся цифр?
    val str = readLine()
    if (str==null){
        println("Ошибка, введена пустая строка")
    } else {
        //123 1213 323231 12123
        var buff = ""
        var i=0
        var arr:Array<String> = emptyArray()
        for(ch in str){
            if (ch != ' ' && ch != '\t'){
                buff+=ch
            }else{
                //println(buff)
                arr+=buff
                i++
                buff=""
            }
        }
        arr+=buff
        println(varargFunction(*arr))
    }
}