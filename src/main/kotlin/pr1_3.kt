
fun main(){
    //Найдите последний символ в первом самом коротком слове в строке
    //с четным числом символов (в строке указываются только слова,
    //разделенные одним или несколькими пробелами).

    //Без сплита
    val str = readLine()
    if (str==null){
       println("Cтрока пустая")
    }else{
        var count=0
        var minimum = str.length
        var answer=' '
        for(i in str.indices){
            if (str[i]!=' '){
                count++
            }else{
                if (count!=0)
                    if (count < minimum && count%2==0) {
                        answer = str[i-count]
                        minimum=count
                    }
                count=0
            }

        }
        if (count<minimum && count%2==0){
            answer = str[str.length-count]
        }
        println(answer)
    }
}