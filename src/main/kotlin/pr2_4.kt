//В задании No3 первой практической работы реализуйте следующее: выделите
//основной алгоритм в отдельную функцию, куда в качестве аргумента
//передавайте lambda, имеющую смысл – способ сравнения двух чисел;
//изменяя данную lambda, пользователь вашей функции должен иметь возможность
//получить информацию либо о самых длинных, либо о самых коротких словах.
//Аналогичным образом передавайте в вашу функцию lambda,
//которая будет определять условие отбора слов.


//надо было добавить вторую лямбу для проверки слов
fun lambdaFunc(str:String, f1:(Int,Int)->(Boolean),f2:(Int)->(Boolean)):Char{
    var count=0
    var minimum = str.length
    var answer = ' '
    for (i in str.indices) {
        if (str[i] !=' '){
            count++
        }else{
            if (f1(minimum,count) && f2(count)) {
                answer = str[i-count]
                minimum = count
                count = 0
            }
        }
    }
    if (minimum>count && count%2==0) {
        answer = str[str.length - count]
    }
    return answer
}


fun main(){
    //Найдите последний символ в первом самом коротком слове в строке
    //с четным числом символов (в строке указываются только слова,
    //разделенные одним или несколькими пробелами).
    val str = readLine()
    if (str==null){
        println("Cтрока пустая")
    }else{
        println(lambdaFunc(str, { n1, n2 -> n1 > n2 }, {n->n%2==0}))
    }
}