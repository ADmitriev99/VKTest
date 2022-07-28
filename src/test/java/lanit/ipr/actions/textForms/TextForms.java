package lanit.ipr.actions.textForms;

import io.qameta.allure.Step;
import lanit.ipr.actions.XPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static lanit.ipr.DriverSingleton.getInstance;

public class TextForms {

    private static WebDriver driver = getInstance();

    @Step("Передать данные {value} в поле с тегом {name}")
    public static void sendkeysByName(String name, String value) {
        driver.findElement(XPath.byName(name)).sendKeys(value);
    }

    @Step("Передать данные {value} в поле с тегом {id}")
    public static void sendkeysById(String id, String value) {
        driver.findElement(XPath.byId(id)).sendKeys(value);
    }

    @Step("Передать данные {value} в поле с тегом {id} и нажать Enter")
    public static void sendkeysByIdEnter(String id, String value) {
        driver.findElement(XPath.byId(id)).sendKeys(value, Keys.ENTER);
    }

    @Step("Нажать стрелку вверх в поле с тегом {id}")
    public static void sendkeysByIdArrowUp(String id) {
        driver.findElement(XPath.byId(id)).sendKeys(Keys.ARROW_UP);
    }

    @Step("Заменить текст в поле с тегом {id} на {value}")
    public static void editMessage(String id, String value) {
        driver.findElement(XPath.byId(id)).sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE, value);
    }

    @Step("Передать данные {value} в поле с текстом {text}")
    public static void sendkeysByText(String text, String value) {
        driver.findElement(XPath.byText(text)).sendKeys(value);
    }

    @Step("Передать данные {value} в поле с текстом {text} и нажать Enter")
    public static void sendkeysByTextEnter(String text, String value) {
        driver.findElement(XPath.byText(text)).sendKeys(value, Keys.ENTER);
    }

    @Step("Передать данные {value} в поле с тегом {clas}")
    public static void sendkeysByClass(String clas, String value) {
        driver.findElement(XPath.byClass(clas)).sendKeys(value);
    }
}
