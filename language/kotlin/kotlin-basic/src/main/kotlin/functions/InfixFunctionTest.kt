package functions

// 멤버 함수와 하나의 매개변수를 가진 확장 함수는 중위 함수로 변환할 수 있습니다.
fun main() {
    infix fun Int.testtimes(str:String) = str.repeat(this)
    println(2 testtimes "Bye")

    val pair = "Ferrari" to "Katrina"
    println(pair)

    infix fun String.onto(other:String) = Pair(this, other)
    val myPair = "McLaren" onto "Lucas"
    println(myPair)

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    val tom = Person("Tom")

    sophia likes claudia
    sophia likes tom

    println(sophia.likedPeple.get(0).name)
    println(sophia.likedPeple.get(1).name)

}

class Person(val name:String) {
    val likedPeple = mutableListOf<Person>()
    infix fun likes(other:Person) {
        likedPeple.add(other)
    }
}
