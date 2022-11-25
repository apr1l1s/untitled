//Создайте функцию, которая по данным двум функциям с параметром
//типа T и результатами типа Int? возвращает новую функцию – минимум данных.
//Если результат хотя бы одной из исходных функций –
//null, то и результат возвращаемой функции – null. Здесь T – любой
//тип.
fun <T> cmpT(f1:(T)->Int?,f2:(T)->Int?):(T)->Int? {
    return {
        val a1 = f1(it)
        val a2 = f2(it)
        if (a1 == null || a2 == null) {
            null
        } else {
            if (a1 < a2) a1 else a2
        }
    }
}
fun gg(it:Int):Int{
    return it*2
}

fun main(){
    val func = cmpT<Int>({it*2},{it*-3})
    println(func(-2))
}