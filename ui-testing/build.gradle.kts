plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // selenium
    implementation("org.seleniumhq.selenium:selenium-java:4.8.1")
    // SLF4J
    implementation("org.slf4j:slf4j-api:2.0.6")
    // Logback 라이브러리 추가
    implementation("ch.qos.logback:logback-classic:1.2.3")
    // SLF4J 로깅 프로바이더 추가
    implementation("org.slf4j:slf4j-log4j12:1.7.32")
    // webdriver
    testImplementation("io.github.bonigarcia:webdrivermanager:5.3.2")

    implementation("com.google.guava:guava:31.1-jre")

    testImplementation(kotlin("test"))
    testImplementation("org.slf4j:slf4j-simple:2.0.6")
}

tasks.test {
//    System.setProperty("webdriver.chrome.driver", "/Users/sjy/Downloads/chromedriver_mac_arm64/chromedriver");
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}