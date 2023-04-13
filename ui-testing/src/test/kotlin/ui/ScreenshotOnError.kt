package ui

import io.qameta.allure.Allure
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestWatcher
import org.openqa.selenium.OutputType
import org.openqa.selenium.remote.RemoteWebDriver
import java.io.ByteArrayInputStream

class ScreenshotOnError(private val driver: RemoteWebDriver) : TestWatcher {

    override fun testFailed(context: ExtensionContext, throwable: Throwable) {
        Allure.addAttachment(context.displayName, ByteArrayInputStream(driver.getScreenshotAs(OutputType.BYTES)))
    }
}