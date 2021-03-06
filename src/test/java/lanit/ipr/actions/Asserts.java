package lanit.ipr.actions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static lanit.ipr.DriverSingleton.getInstance;

public class Asserts {

    protected static WebDriver driver = getInstance();

    @Step("Проверить отображение элемента с id {id}")
    public static void displayedById(String id) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(XPath.byId(id)));
    }

    @Step("Проверить отображение элемента с class {clas}")
    public static void displayedByClass(String clas) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(XPath.byClass(clas)));
    }

    @Step("Проверить отображение элемента с текстом {text}")
    public static void displayedByText(String text) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(XPath.byText(text)));
    }

    @Step("Проверить отображение элемента div с текстом {text}")
    public static void divDisplayedByText(String text) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(XPath.divByText(text)));
    }

    @Step("Проверить отображение элемента с текстом {text}")
    public static void displayedByTextLike(String text) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(XPath.byTextLike(text)));
    }

    @Step("Проверить отображение элемента с тегом {arialabel}")
    public static void displayedByAriaLabel(String arialabel) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(XPath.byAriaLabel(arialabel)));
    }
}
