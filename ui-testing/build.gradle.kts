plugins {
    kotlin("jvm") version "1.8.0"
    application
    id("io.qameta.allure") version "2.9.6"
    id("io.qameta.allure-report") version "2.9.6"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

//    implementation("org.seleniumhq.selenium:selenium-java:4.8.0")
    // SLF4J
    implementation("org.slf4j:slf4j-api:2.0.6")
    // Logback 라이브러리 추가
    implementation("ch.qos.logback:logback-classic:1.2.3")
    // SLF4J 로깅 프로바이더 추가
    implementation("org.slf4j:slf4j-log4j12:1.7.32")
    // webdriver
    testImplementation("io.github.bonigarcia:webdrivermanager:5.3.2")

    implementation("com.google.guava:guava:31.1-jre")
    // selenium
    testImplementation("org.seleniumhq.selenium:selenium-java:4.8.1")
    testImplementation("org.seleniumhq.selenium:selenium-http-jdk-client:4.8.1")
    testImplementation(kotlin("test"))
    testImplementation("org.slf4j:slf4j-simple:2.0.6")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}
