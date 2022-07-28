package lanit.ipr.actions.buttons;

import io.qameta.allure.Step;
import lanit.ipr.actions.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static lanit.ipr.DriverSingleton.getInstance;

public class Buttons {

    private static WebDriver driver = getInstance();

    @Step("Нажать элемент с надписью {text}")
    public static void clickByText(String text) {
        driver.findElement(XPath.byText(text)).click();
    }

    @Step("Нажать элемент с надписью {text}")
    public static void clickByTextButton(String text) {
        driver.findElement(XPath.byTextButton(text)).click();
    }

    @Step("Нажать элемент с надписью {text}")
    public static void clickByTextLike(String text) {
        driver.findElement(XPath.byTextLike(text)).click();
    }

    @Step("Нажать элемент с надписью {text}")
    public static void clickByTextLikeDiv(String text) {
        driver.findElement(XPath.byTextLikeDiv(text)).click();
    }

    @Step("Нажать элемент с Xpath {text}")
    public static void clickByXPath(String text) {
        driver.findElement(XPath.byXPath(text)).click();
    }

    @Step("Нажать элемент с тегом {clas}")
    public static void clickByClass(String clas) {
        driver.findElement(XPath.byClass(clas)).click();
    }

    @Step("Нажать элемент с тегом {clas}")
    public static void clickByClassButton(String clas) {
        driver.findElement(XPath.byClassButton(clas)).click();
    }

    @Step("Нажать кнопку \" Войти\"")
    public static void login() {
        driver.findElement(By.xpath("//*[@id='index_login']//following-sibling::*[contains(text(),'Войти')]")).click();
    }

    public static void deleteConversation() {
        Actions builder = new Actions(driver);
        WebElement myElement = driver.findElement(By.xpath("//div[@class=\"im-page--header-more im-page--header-menu-button _im_dialog_action_wrapper\"]/div/div"));
        builder.moveToElement(myElement).build().perform();
    }

    @Step("Нажать элемент с тегом {name}")
    public static void clickByName(String name) {
        driver.findElement(XPath.byName(name)).click();
    }

    @Step("Нажать элемент с тегом {arialabel}")
    public static void clickByAriaLabel(String arialabel) {
        driver.findElement(XPath.byAriaLabel(arialabel)).click();
    }

    @Step("Нажать элемент с тегом {id}")
    public static void clickById(String id) {
        driver.findElement(XPath.byId(id)).click();
    }

    @Step("Нажать элемент, предшествующий элементу с тегом {id}")
    public static void clickByIdPrevious(String id) {
        driver.findElement(XPath.byIdPrevious(id)).click();
    }

    @Step("Навести мышку на элемент с тегом {clas}")
    public static void mouseOnClass(String clas) {
        Actions builder = new Actions(driver);
        WebElement myElement = driver.findElement(XPath.byClass(clas));
        builder.moveToElement(myElement).build().perform();
    }

    @Step("Нажать элемент с тегом {title}")
    public static void clickByTitle(String title) {
        driver.findElement(XPath.byTitle(title)).click();
    }
}
