package ui

import io.github.bonigarcia.wdm.WebDriverManager
import io.qameta.allure.Description
import io.qameta.allure.Step
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.RegisterExtension
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.util.logging.Level
import java.util.logging.Logger


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestMainTest{

    init {
        System.setProperty("webdriver.chrome.driver", TestInfo.CHROME_DRIVER_PATH)
        System.setProperty("webdriver.http.factory", TestInfo.WEBDRIVER_HTTP_FACTORY);
        WebDriverManager.chromedriver().setup()
    }

    companion object {
        private val LOGGER = Logger.getLogger(TestMainTest::class.java.name)


        @JvmStatic
        @Step("Step -> {2}")
        fun findElementAndAction(chromedriver:ChromeDriver, xPath:String, name:String ,action:ActionEnum,inputText:String?): Any? {
            LOGGER.log(Level.INFO,"Action Start [ $name ] ")

            var resultValue:Any? = null
            when (action) {
                ActionEnum.CLICK -> chromedriver.findElement(By.xpath(xPath)).click()
                ActionEnum.INPUT -> chromedriver.findElement(By.xpath(xPath)).sendKeys(inputText)
                ActionEnum.GET_TEXT -> resultValue = chromedriver.findElement(By.xpath(xPath)).text
                ActionEnum.IS_NOT_EMPTY_CLICK -> {
                    val findElements = chromedriver.findElements(By.xpath(xPath))
                    if (findElements.isNotEmpty()) {
                        findElements[0].click()
                    }
                }
                ActionEnum.SIZE_FOUND_ELEMENT -> {
                    val findElements = chromedriver.findElements(By.xpath(xPath))
                    resultValue = findElements.size
                }
            }

            Thread.sleep(1000)
            return resultValue
        }
    }

        private val driver = ChromeDriver(ChromeOptions()
            .addArguments("--headless")
            .addArguments("--disable-mobile-emulation")
            .addArguments("--window-size=1920,1080")
        )

//    private val driver = ChromeDriver()

    @JvmField
    @RegisterExtension
    val screenshotOnError = ScreenshotOnError(driver)

    @BeforeEach
    fun setUp() {
        LOGGER.log(Level.INFO, "Initializing logging...")
    }


    @Test
    @DisplayName("위탁상품 조회")
    @Description("로그인 -> 위탁 관리 -> 위탁상품 조회")
    fun consignmentImport() {


        driver.get(TestInfo.TEST_URL)

        driver.manage().window().maximize()

        // 로그인 페이지 이동
        findElementAndAction(driver,XpathInfo.NAVIGATE_LOGIN_PAGE, "NAVIGATE_LOGIN_PAGE", ActionEnum.CLICK,null)

        // 로그인 id 입력
        findElementAndAction(driver,XpathInfo.INPUT_LOGIN_ID, "INPUT_LOGIN_ID", ActionEnum.INPUT, TestInfo.LOGIN_ID)

        // 로그인 password 입력
        findElementAndAction(driver,XpathInfo.INPUT_LOGIN_PASSWORD, "INPUT_LOGIN_PASSWORD", ActionEnum.INPUT, TestInfo.PASSWORD)

        // 로그인 버튼 클릭
        findElementAndAction(driver,XpathInfo.CLICK_LOGIN_BUTTION, "CLICK_LOGIN_BUTTION", ActionEnum.CLICK, null)

        // 공지사항 확인 및 닫기
        Thread.sleep(5000)
        findElementAndAction(driver,XpathInfo.CLICK_NOTICE_MODAL,"CLICK_NOTICE_MODAL", ActionEnum.IS_NOT_EMPTY_CLICK,null)

        // 위탁 관리
        findElementAndAction(driver,XpathInfo.NAVIGATE_CONSIGNMENT,"NAVIGATE_CONSIGNMENT", ActionEnum.CLICK,null)

        // 위탁 상품 가져오기
        findElementAndAction(driver,XpathInfo.NAVIGATE_CONSIGNMENT_SEARCH,"NAVIGATE_CONSIGNMENT_SEARCH", ActionEnum.CLICK, null)

        // 도매매 클릭
        Thread.sleep(3000)
        findElementAndAction(driver,XpathInfo.CLICK_CONSIGNMENT_SEARCH_DOMEME,"CLICK_CONSIGNMENT_SEARCH_DOMEME", ActionEnum.CLICK,null)

        // 검색 조건 선택
        findElementAndAction(driver,XpathInfo.CLICK_CONSIGNMENT_SEARCH_TYPE,"CLICK_CONSIGNMENT_SEARCH_TYPE", ActionEnum.CLICK,null)

        // 상품명 클릭
        Thread.sleep(2000)
        findElementAndAction(driver,XpathInfo.CLICK_CONSIGNMENT_SEARCH_TYPE_PRODUCT_NAME,"CLICK_CONSIGNMENT_SEARCH_TYPE_PRODUCT_NAME", ActionEnum.CLICK,null)

        // 검색어 입력
        findElementAndAction(driver,XpathInfo.INPUT_CONSIGNMENT_SEARCH_PRODUCT_NAME,"INPUT_CONSIGNMENT_SEARCH_PRODUCT_NAME", ActionEnum.INPUT,TestInfo.SEARCH_KEYWORD)

        // 검색 클릭
        findElementAndAction(driver,XpathInfo.CLICK_CONSIGNMENT_SEARCH_BUTTON,"CLICK_CONSIGNMENT_SEARCH_BUTTON", ActionEnum.CLICK,null)

        // total count
        Thread.sleep(10000)
        val totalCount = findElementAndAction(driver,XpathInfo.GET_TEXT_CONSIGNMENT_SEARCH_RESULT_COUNT,"GET_TEXT_CONSIGNMENT_SEARCH_RESULT_COUNT", ActionEnum.GET_TEXT,null)

        // 검색 결과
        LOGGER.log(Level.INFO, "검색 조회 결과 : $totalCount")

        // 펼치기 버튼
        findElementAndAction(
            driver,
            XpathInfo.CLICK_CONSIGNMENT_SEARCH_MORE_LIST_BOTTON,
            "CLICK_CONSIGNMENT_SEARCH_MORE_LIST_BOTTON",
            ActionEnum.IS_NOT_EMPTY_CLICK,
            null
        )

        // 리스트 결과 상세보기 클릭
        if (Integer.parseInt(totalCount.toString().replace(",", "")) > 0) {
            var count = 0
            var isRepeat = true

            while (isRepeat) {
                ++count
                val foundCount =
                    findElementAndAction(
                        driver
                        , XpathInfo.ROW_CONSIGNMENT_SEARCH_LIST_PRODUCT_NAME.replace("#count#",count.toString())
                        , "ROW_CONSIGNMENT_SEARCH_LIST_PRODUCT_NAME"
                        , ActionEnum.SIZE_FOUND_ELEMENT, null)

                if (1 == foundCount) {
                    // 위탁 상품 번호 추출
                    val productNo =
                        findElementAndAction(driver
                            , XpathInfo.ROW_CONSIGNMENT_SEARCH_LIST_PRODUCT_NO.replace("#count#",count.toString())
                            , "ROW_CONSIGNMENT_SEARCH_LIST_PRODUCT_NO"
                            , ActionEnum.GET_TEXT, null)

                    LOGGER.log(Level.INFO, "상품 번호 : $productNo")

                    // 위탁 상품 상세보기
                    findElementAndAction(
                        driver
                        , XpathInfo.ROW_CONSIGNMENT_SEARCH_LIST_PRODUCT_NAME.replace("#count#",count.toString())
                        , "ROW_CONSIGNMENT_SEARCH_LIST_PRODUCT_NAME"
                        , ActionEnum.CLICK, null
                    )

                    // 모달 닫기
                    Thread.sleep(3000)
                    findElementAndAction(
                        driver
                        , XpathInfo.CLICK_CONSIGNMENT_SEARCH_DETAIL_CLOSE
                        , "CLICK_CONSIGNMENT_SEARCH_DETAIL_CLOSE"
                        , ActionEnum.CLICK, null
                    )
                } else {
                    isRepeat = false

                }
            } //end while

        }
    }

    @AfterAll
    fun teardown() {
        LOGGER.log(Level.INFO, "Closing logging...")
//        driver.close()
    }

}