//Измените программу, сделанную в задании No1 практической работы No1:
//основной алгоритм вынесите в функцию. Опишите функцию несколькими
//способами:
//1. как обычную функцию;
//2. как tailrec-функцию.
fun myFunction(n: Int):Int{
    var num = n
    var buff:Int
    var minimum = 10
    while (num != 0){
        buff = num % 10
        if (buff % 3 == 0 && buff < minimum){
            minimum = buff
        }
        num/= 10
    }
    if (minimum != 10) println(minimum)
    else println("В данном числе нет цифры кратной тройке")
    return minimum
}
tailrec fun myTailFunction(n:Int, answer:Int = 10):Int =
    if (n==0) answer
    else if (n%10 %3 == 0 && n%10 < answer) myTailFunction(n=n/10,answer=n%10)
    else myTailFunction(n/10, answer)


fun main(){
    var num = readLine()?.toIntOrNull()
    if (num !=null) {
        println(myFunction(num))
        println(myTailFunction(num))
    }
}