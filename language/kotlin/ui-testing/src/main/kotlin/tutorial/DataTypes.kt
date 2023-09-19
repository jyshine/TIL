package tutorial

fun main() {
    val myNum = 5             // Int
    val myDoubleNum = 5.99    // Double
    val myLetter = 'D'        // Char
    val myBoolean = true      // Boolean
    val myText = "Hello"      // String

    val myByte: Byte = 100
    println(myByte)

    val myShort: Short = 5000
    println(myShort)

    val myLong: Long = 15000000000L
    println(myLong)

    val myNum1 = 2147483647  // Int
    println(myNum1)
    val myNum2 = 2147483648  // Long
    println(myNum2)

    val myNum3: Float = 35E3F // Float is only six or seven decimal digits
    val myNum4: Double = 12E4 // Double variables have a precision of about 15 digits
    println(myNum3)
    println(myNum4)

    val myGrade: Char = 'B'
    println(myGrade)

    /**
     * toByte(), toShort(), toInt(), toLong(), toFloat(), toDouble() or toChar()
     */
}