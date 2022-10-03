package train_project.database
import train_project.train.Train

class Database:IDatabase<Train>{
    //Данные
    private val _data = mutableListOf<Train>()
    override val data: List<Train>
        get() = _data.toList()
    //Функции работы с бд
    //Добавление
    override fun add(item: Train): Boolean = _data.add(item)
    //Удаление
    override fun del(index: Int): Boolean =
        if(index in _data.indices){
            _data.removeAt(index)
            true
        } else false
    //Замена
    override fun replace(index: Int, item: Train): Boolean =
        if (index in _data.indices){
            _data[index]=item
            true
        }else false
    //Поиск с фильторм
    override fun search(vararg predicates: (Train) -> Boolean): List<Train> =
        _data.filter{i-> (predicates.all{it(i)})}
}