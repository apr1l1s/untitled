package train_project.train


data class Train(
    override var station: String,
    override var number: String,
    override var countOfWagons: Number,
    override var types: TrainTypes
):ITrain{
    override fun toString():String{
        return "$station $number $countOfWagons $types"
    }
}