import java.util.Scanner

interface Storage {
    fun show()
    fun add()
}

class Archive : Storage {
    private val notes: MutableMap<String, String> = mutableMapOf()
    override fun show() {
        if (notes.isEmpty()) {
            println("Нет доступных заметок!")
            return
        }
        println("Выберите заметку:")
        for(i in notes) println(i.key)
        val name: String = Scanner(System.`in`).nextLine()
        if (notes.contains(name)) println(notes[name])
        else println("Такой заметки нет")
    }

    override fun add() {
        println("Введите название заметки:")
        val name: String = Scanner(System.`in`).nextLine()
        if(notes.contains(name)) {
            println("Такая заметка уже есть!")
            return
        }
        if (name == "") {
            println("Пустой ввод!")
            return
        }
        println("Введите текст заметки:")
        val note = Scanner(System.`in`).nextLine()
        notes[name] = note
        println("Заметка $name добавлена в архив")
    }
}

class Archives : Storage {
    private val archives: MutableMap<String ,Archive> = mutableMapOf()
    override fun show() {
        if (archives.isEmpty()) {
            println("Нет доступных архивов!")
            return
        }
        println("Выберите архив:")
        for(i in archives) println(i.key)
        val name: String = Scanner(System.`in`).nextLine()
        if (archives.contains(name)) archives[name]?.let { screen(it) }
        else println("Такого архива нет")
    }
    override fun add() {
        println("Введите название архива:")
        val name: String = Scanner(System.`in`).nextLine()
        if (name == "") {
            println("Пустой ввод!")
            return
        }
        if(!archives.contains(name)) archives[name] = Archive()
        else println("Такой архив уже есть!")
    }
}
