package functions

// Default Parameter Values and Named Arguments
fun main() {
    printMessage("hello")
    printMessageWithPrefix("hello", "Log")
    printMessageWithPrefix("Hello")
    printMessageWithPrefix(prefix = "Log", message = "Hello")
    println(sum(1, 2))
    println(multiply(2,4))
}

fun multiply(x: Int,y: Int) = x*y

fun sum(x: Int, y: Int):Int {
    return x + y
}

fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

fun printMessage(s: String):Unit {
    println(s)
}


