
class MyList<T:Any>(private val list: MutableList<T> = mutableListOf<T>()){
//fun insert (el: T,n: Int): Bool вставляет элемент на позицию n
//(нумерация идет с единицы) с начала списка;
    fun<T> insert(el: T, n:Int):Boolean{
        return true
    }
//fun delete (count: Int,n: Int): Bool удаляет count элементов
// начиная с позиции n
    fun delete(count:Int,n:Int):Boolean{
        return true
    }
//fun print(count: Int,n: Int): Unit печатает count элементов списка,
//начиная с позиции n
    fun print(count:Int, n:Int):Unit{
    }
}
fun main(){
    val list = MyList<Int>()
    list.insert(1,1)
    list.print(1,1)
    list.delete(1,1)
}

