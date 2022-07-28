package lanit.ipr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    protected static WebDriver driver = null;

    public static WebDriver getInstance() {
        System.out.println("called getInstance");
        if (driver == null) {
            System.out.println("driver was null and being created");
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        System.out.println("returning instance of a driver" + driver.hashCode());
        return driver;
    }

    private DriverSingleton() {
    }

}
