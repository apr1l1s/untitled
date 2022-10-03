//минимальную цифру кратную трём
fun main(){
    while(true) println(readLine()?.mapNotNull{ it.digitToIntOrNull() }?.filter{it%3==0}?.minOrNull())
}