package ui.common

class TestInfo {

    companion object{
        var CHROME_DRIVER_PATH = "${System.getProperty("user.dir")}/src/test/resources/chromedriver"
        const val WEBDRIVER_HTTP_FACTORY = "jdk-http-client"
        const val TEST_URL = "https://dev1.onesell.co.kr/"
        const val LOGIN_ID = "admin6"
        const val PASSWORD = "onesell1!"
        const val SEARCH_KEYWORD = "가방"

    }
}