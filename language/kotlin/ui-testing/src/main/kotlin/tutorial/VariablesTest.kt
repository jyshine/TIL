package tutorial

fun main() {
    /**
     * "val" 변수는 값이 변경되지 않기 때문에 컴파일러가 변수를 상수로 인식하고,
     * 상수 풀(constant pool)에 저장합니다.
     *
     * 이렇게 하면 변수에 대한 메모리 할당을 줄일 수 있으므로,
     * 일반적으로 "val" 변수를 사용하는 것이 성능면에서 이점이 있습니다.
     *
     * "var" 변수는 값이 변경될 수 있으므로,
     * 상수 풀에 저장하지 않습니다.
     *
     * 대신, 컴파일러는 변수를 스택 메모리에 할당하고, 필요에 따라 메모리를 동적으로 할당하게 됩니다.
     */

    // kotlin에서는 val 또는 val 키워드 사용하여 변수 선언

    // val 초기화한 후 변경 할 수 없는 읽기 전용 변수
    val name: String = "John"
    val name2 = "John2"
//    name = "Jun" Val cannot be reassigned
    println(name)
    println(name2)

    // var는 값을 초기화한 후 변경할 수 있는 가변 변수를 선언
    var age: Int = 25
    age = 34
    println(age)

    // nullable 변수를 "?" 기호를 사용
    var age2: Int? = null
    println(age2)
    age2 = 1
    println(age2)
    val length = name?.length // Safe call operator
    println(length)



}