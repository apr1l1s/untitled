//Найдите последний символ в первом самом коротком слове в строке
    //с четным числом символов (в строке указываются только слова,
    //разделенные одним или несколькими пробелами).

fun main(){
    while(true)println(readLine()?.split(' ')?.filter {
        it.length % 2 == 0 && it != ""
    }?.let{
        val buff = it.filter {
            g -> g.length == it.minOf {i -> i.length }
        }
        if (buff.isNotEmpty()) buff[0][buff[0].length-1] else null
    })
}