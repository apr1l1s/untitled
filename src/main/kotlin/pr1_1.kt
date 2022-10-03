fun main(){
    //минимальную цифру, кратную трем
    var num = readLine()?.toIntOrNull()
    var buff:Int
    var minimum = 10
    if (num!=null){
        while (num != 0){
            buff = num % 10
            if (buff % 3 == 0 && buff < minimum){
                minimum = buff
            }
            num/= 10
        }
        if (minimum != 10) println(minimum)
        else println("В данном числе нет цифры кратной тройке")
    }else println("Неверный формат")
}