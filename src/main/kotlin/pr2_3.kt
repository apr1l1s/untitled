//Функции, созданные в задании No1, модифицируйте таким образом, что
//бы условие, по которому происходит отбор, можно было передавать как аргумент
//(один из аргументов функции должен быть lambda со значением по
//умолчанию – условием, что указано было в вашем варианте).
fun myCustomFunction(n: Int, f:(Int)->(Boolean)={it==it}):Int{
    var num = n
    var buff:Int
    var answer=0
    while (num != 0){
        buff = num % 10
        if (f(buff)){
            answer=buff
        }
        num/= 10
    }
    return answer
}

tailrec fun myCustomTailFunction(n:Int, f:(Int)->(Boolean), answer:Int = 0):Int =
    if (n==0) answer
    else if (f(n%10)) myCustomTailFunction(n/10,f,n%10)
    else myCustomTailFunction(n/10,f, answer)

fun lambdaFunction(n:Int)=(n%3!=0)
fun main(){
    var num = readLine()?.toIntOrNull()
    if (num !=null) {
        println(myCustomFunction(num, ::lambdaFunction))
        println(myCustomTailFunction(num, ::lambdaFunction))
    }
}