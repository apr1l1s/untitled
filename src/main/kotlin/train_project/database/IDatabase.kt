package train_project.database

interface IDatabase<T> {
    fun add(item:T): Boolean
    fun del(index:Int): Boolean
    fun replace(index:Int,item:T): Boolean
    fun search(vararg predicates: (T)->Boolean):List<T>
    val data:List<T>
}