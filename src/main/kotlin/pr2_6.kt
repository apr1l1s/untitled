//Создайте функцию, которая по данным двум функциям с параметром
//типа Int и результатами типа Int? возвращает новую функцию – ми-
//нимум данных. Если результат хотя бы одной из исходных функций
//– null, то и результат возвращаемой функции – null.


fun parentFunction(f1:(Int)->Int?,f2:(Int)->Int?):( Int)->(Int?) {
    return {
        if (f1(it) != null && f2(it) != null){
            if (f1(it)!! <f2(it)!!) f1(it) else f2(it)
        } else null
    }
}

fun main(){
    val f = parentFunction({it*it}, {if (it*it != 4) null else 4})
    println(f(2))
}