package ui

import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestMainTest{

    private val driver = WebDriverManager.chromedriver().setup()

    @Test
    fun openAmazon() {
        driver.get("https://www.onesell.co.kr/")
    }

    @AfterAll
    fun closeBrowser() {
        driver.close()
    }

}