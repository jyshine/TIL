package ui

import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.RegisterExtension
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestMainTest{

    init {
        System.setProperty("webdriver.chrome.driver", TestInfo.CHROME_DRIVER_PATH)
        System.setProperty("webdriver.http.factory", TestInfo.WEBDRIVER_HTTP_FACTORY);
        WebDriverManager.chromedriver().setup()
    }

    companion object {
        @JvmStatic
        fun findElementAndAction(chromedriver:ChromeDriver, xPath:String,action:ActionEnum,inputText:String?) {
            val findElement = chromedriver.findElement(By.xpath(xPath))

            when (action) {
                ActionEnum.CLICK -> findElement.click()
                ActionEnum.INPUT -> findElement.sendKeys(inputText)
                ActionEnum.GET_TEXT -> findElement.text

            }
        }
    }
//    private val driver = ChromeDriver(ChromeOptions().addArguments("--headless"))
    private val driver = ChromeDriver(ChromeOptions())

    @JvmField
    @RegisterExtension
    val screenshotOnError = ScreenshotOnError(driver)

    @BeforeEach
    fun setUp() {
    }


    @Test
    fun consignmentImport() {


        driver.get(TestInfo.TEST_URL)

        driver.manage().window().maximize()

        // 로그인 페이지 이동
//        val loginButton = driver.findElement(By.xpath(XpathInfo.NAVIGATE_LOGIN_PAGE))
//        loginButton.click()
        findElementAndAction(driver,XpathInfo.NAVIGATE_LOGIN_PAGE, ActionEnum.CLICK,null)

        // 로그인 id 입력
//        val idInput = driver.findElement(By.xpath(XpathInfo.INPUT_LOGIN_ID))
//        idInput.sendKeys(TestInfo.LOGIN_ID)
        findElementAndAction(driver,XpathInfo.INPUT_LOGIN_ID, ActionEnum.INPUT, TestInfo.LOGIN_ID)

        // 로그인 password 입력
        val passwordInput = driver.findElement(By.xpath(XpathInfo.INPUT_LOGIN_PASSWORD))
        passwordInput.sendKeys(TestInfo.PASSWORD)

        // 로그인 버튼 클릭
        val login = driver.findElement(By.xpath(XpathInfo.CLICK_LOGIN_BUTTION))
        login.click()

        // 공지사항 확인 및 닫기
        Thread.sleep(5000)
        val noticeModelElements = driver.findElements(By.xpath(XpathInfo.CLICK_NOTICE_MODAL))
        if(noticeModelElements.isNotEmpty()) {
            noticeModelElements[0].click()
            println("noticeModelElements isNotEmpty true")
        } else {
            println("noticeModelElements isNotEmpty false")
        }

        // 위탁 관리
        driver.findElement(By.xpath(XpathInfo.NAVIGATE_CONSIGNMENT)).click()
        // 위탁 상품 가져오기
        driver.findElement(By.xpath(XpathInfo.NAVIGATE_CONSIGNMENT_SEARCH)).click()
        Thread.sleep(3000)
        // 도매매 클릭
        driver.findElement(By.xpath(XpathInfo.CLICK_CONSIGNMENT_SEARCH_DOMEME)).click()
        // 검색 조건 선택
        driver.findElement(By.xpath(XpathInfo.CLICK_CONSIGNMENT_SEARCH_TYPE)).click()
        Thread.sleep(2000)
        // 상품명 클릭
        driver.findElement(By.xpath(XpathInfo.CLICK_CONSIGNMENT_SEARCH_TYPE_PRODUCT_NAME)).click()
        // 검색어 입력
        driver.findElement(By.xpath(XpathInfo.INPUT_CONSIGNMENT_SEARCH_PRODUCT_NAME)).sendKeys(TestInfo.SEARCH_KEYWORD)
        // 검색 클릭
        driver.findElement(By.xpath(XpathInfo.CLICK_CONSIGNMENT_SEARCH_BUTTION)).click()
        Thread.sleep(10000)
        // total count
        val totalCount = driver.findElement(By.xpath(XpathInfo.GET_TEXT_CONSIGNMENT_SEARCH_RESULT_COUNT)).text
        println("검색 조회 결과 : $totalCount")


    }

    @AfterAll
    fun closeBrowser() {
//        driver.close()
    }

}