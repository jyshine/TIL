fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    val path = System.getProperty("user.dir")
    val chromeDriverPath = "${System.getProperty("user.dir")}/src/test/resources/chromedriver"
    var kotlinVersion: KotlinVersion = KotlinVersion.CURRENT

    println("${kotlinVersion.major}.${kotlinVersion.minor}.${kotlinVersion.patch}")

    println("dir path = $path ")
    println("dir chromeDriverPath = $chromeDriverPath ")
}