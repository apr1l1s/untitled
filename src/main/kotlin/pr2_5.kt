//Создайте функцию, которая реализует алгоритм второго задания первой
//практической работы, в которую все числа, слова или пары (в зависимости
//от варианта) передаются в аргументах функции. Например: f(123,25,222);
//f("dfd "dd "ddd"); d (Pair(2,3),Pair(3,5),Pair(4,1)).

//Надо было поменять алгоритм, чтобы он был как из 1.2
fun varargFunction(vararg arr:String):Int?{
    var count = 0
    if (arr.isEmpty()) return null
    var booleanarr = Array(10) {false}
    for (i in arr.indices){
        loop@for (j in arr[i]){
            if (booleanarr[j.digitToInt()]) {
                count++
                break@loop
            }
            else booleanarr[j.digitToInt()] = true
        }
        booleanarr = Array(10) {false}
    }
    return count
}

fun main() {
    //В строке указано несколько неотрицательных целых чисел, разделен-
    //ных пробелами (по одному пробелу между числами). Какое количе-
    //ство чисел удовлетворяет условию наличия повторяющихся цифр?
    val list = arrayOf("112","23","22","12","123","00")
    println(varargFunction(*list))
}