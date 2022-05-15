package lanit.ipr;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static lanit.ipr.UI.CleanTestUI.CleanStepUI;

public class TestBase extends DriverTest {

    @BeforeAll
    public static void beforeHook(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://vk.com/");
    }

    @AfterAll
    public static void afterHook(){
        CleanStepUI();
        driver.quit();
    }
}
