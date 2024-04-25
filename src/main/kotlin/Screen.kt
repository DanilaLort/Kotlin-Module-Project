import java.util.Scanner

fun screen(value: Storage) {
    val type: String = if (value is Archives) "архив" else "заметку"
    while (true) {
        println("Введите команду:")
        println("0 - добавить $type\n1 - посмотреть $type\n2 - выход")
        when (val command: String = Scanner(System.`in`).nextLine()) {
            "0" -> value.add()
            "1" -> value.show()
            "2" -> break
            else -> {
                if (command == "") println("Пустой ввод!")
                else if (command.matches(Regex("\\d+"))) println("Такой команды нет!")
                else println("Вы ввели не число!")
            }
        }
    }
}
