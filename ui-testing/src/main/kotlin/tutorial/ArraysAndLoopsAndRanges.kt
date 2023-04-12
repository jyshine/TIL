package tutorial

fun main() {
    // array
    val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
    cars[0] = "Opel"
    println(cars[0])

    // while , break, continue
    var i = 0
    while (i < 5) {
        println(i)
        i++
        if (i == 3) {
            break
        }
    }

    i = 0
    do {
        println(i)
        i++
        if (i == 2) {
            i++
            continue
        }
    }
    while (i < 5)

    // for loop
    val cars2 = arrayOf("Volvo", "BMW", "Ford", "Mazda")
    for (x in cars2) {
        println(x)
    }

    // ranges
    for (nums in 5..15) {
        if (nums == 10) {
            continue
        }
        println(nums)
    }
}