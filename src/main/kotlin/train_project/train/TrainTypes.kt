package train_project.train

enum class TrainTypes{
    Express,Standard,Sputnik;
    companion object {
        fun parseTrainTypes(s:String): TrainTypes {
            return when(s.trim().uppercase()){
                "EXPRESS","1"-> Express
                "STANDARD","2"-> Standard
                "SPUTNIK","3"-> Sputnik
                else-> Standard
            }
        }
    }
}