fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    val path = System.getProperty("user.dir")
    val chromeDriverPath = "${System.getProperty("user.dir")}/src/test/resources/chromedriver"


    println("dir path = $path ")
    println("dir chromeDriverPath = $chromeDriverPath ")

    var testInt = 0

    println(++testInt)
    println(++testInt)
    println(++testInt)
    println(++testInt)

    println(testInt)
}