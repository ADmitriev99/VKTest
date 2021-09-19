package org.example.UI;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static io.qameta.allure.Allure.step;
import static org.example.UI.CleanTestUI.CleanStepUI;
import static org.example.UI.LoginTestUI.LoginStepUI;
import static org.example.UI.DiscussionTestUI.DiscussionStepUI;
import static org.example.UI.MessageTestUI.MessageStepUI;
import static org.example.UI.PhotoTestUI.PhotoStepUI;
import static org.example.UI.ProfileEditTestUI.ProfileEditStepUI;

@Epic("UI test")
@Feature("UI test")
@DisplayName("UI Test on VK.com")
public class UITest {
    @Tag("UI test")
    @Story("UI test")
    @Description("UI test on VK.com")
    public static void UITest() {
        System.setProperty("webdriver.chrome.driver", "A:\\Documents\\JAVA\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        step("Вход в VK.com", ()->{LoginStepUI(driver);});
        step("Редактирование профиля",()->{ProfileEditStepUI(driver);});
        step("Работа с беседой", ()->{MessageStepUI(driver);});
        step("Работа с обсуждениями", ()->{DiscussionStepUI(driver);});
        step("Работа с фотографиями", ()->{PhotoStepUI(driver);});
        step("Приведение в исходное состояние", ()->{CleanStepUI(driver);});
    }
}
