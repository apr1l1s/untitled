//По совершенному числу найдите его номер в последовательности всех
//совершенных чисел, расположенных в порядке возрастания (не ис-
//пользуйте факты, которые вы не можете доказать самостоятельно)

fun main() {
    val n = 8128
    val sqn = generateSequence(1){it+1}.filter{x->
        generateSequence(1){it+1}
            .take(x-1)
            .filter{x%it==0}
            .toList().sum()==x
    }
    println(sqn.indexOfFirst { it == n }+1)
}