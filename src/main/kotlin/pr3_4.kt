//С клавиатуры вводиться несколько целых значений через пробел. Найдите
//Побитовый штрих Шеффера предпоследней цифры всех чисел (операции выполняются справа налево)

fun main() {
    println(
        readLine()?.split(' ')?.filter{
            it.isNotEmpty()
        }?.mapNotNull {
            val buff = it.toInt()
            if ((buff > 0 && it.length>1) || (buff<0 && it.length>2)){
               buff%100/10
            } else null
        }?.reduceRightOrNull{sum,element -> (sum and element).inv()}
    )
}

