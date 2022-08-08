package lanit.ipr;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    protected static WebDriver driver = null;
    private static final Logger LOG = LogManager.getLogger(DriverSingleton.class.getSimpleName());

    public static WebDriver getInstance() {
        LOG.info("called driver getInstance");
        if (driver == null) {
            LOG.info("driver was null and being created");
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        LOG.info("returning instance of a driver\"" + driver.hashCode());
        return driver;
    }

    private DriverSingleton() {
    }

}
