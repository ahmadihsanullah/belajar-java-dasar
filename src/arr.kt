import kotlin.Array

class Arr {
    var names: Array<String> = arrayOf("a", "b", "c", "d", "e")

    fun main() {
        names.reverse()
        for (i in names) {
            // Lakukan sesuatu dengan nilai i di sini
            println(i)
        }
    }
}

fun main() {
    val myArr = Arr()
    myArr.main()
}
