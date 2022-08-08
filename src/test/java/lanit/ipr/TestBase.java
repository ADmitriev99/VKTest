package lanit.ipr;

import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static lanit.ipr.DriverSingleton.getInstance;
import static lanit.ipr.UI.CleanTestUI.cleanStepUI;

public class TestBase {

    protected static WebDriver driver = getInstance();

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] attachScreenshot(String attachName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] attachPageSource() {
        return driver.getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @BeforeAll
    public static void beforeHook() {
        addListener("AllureSelenium", new AllureSelenide().screenshots(true).savePageSource(true));
        driver.get("https://vk.com/");
    }

    @AfterEach
    public void afterEach() {
        attachAsText("Последняя страница перед закрытием теста", driver.getCurrentUrl());
        attachScreenshot("Last screenshot");
        attachPageSource();
        cleanStepUI();
        driver.quit();
    }
}
