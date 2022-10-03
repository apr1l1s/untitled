//В программе, сделанной в задании No1, вынесите проверяемое условие в
//отдельную single-expression функцию.
fun mySingleFunction(buff:Int) = buff % 3 == 0

fun main(){
    var num = readLine()?.toIntOrNull()
    var buff:Int
    var minimum = 10
    if (num != null){
        while (num != 0){
            buff = num % 10
            if ( mySingleFunction(buff) && buff < minimum)
                minimum = buff
            num/= 10
        }
        if (minimum != 10) println(minimum)
        else println("В данном числе нет цифры кратной тройке")
    }

}
