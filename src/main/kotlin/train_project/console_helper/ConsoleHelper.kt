package train_project.console_helper

object ConsoleHelper{
    fun start(){
        val command = readLine()
        if (command!=null){
            println(command.trim().split(' ')[0])
        }
    }
}