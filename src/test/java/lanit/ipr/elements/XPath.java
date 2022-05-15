package lanit.ipr.elements;

import org.openqa.selenium.By;

public class XPath {

    public static By byText(String text){
        return By.xpath("//*[text()='" + text + "']");
    }

    public static By byTextButton(String text){
        return By.xpath("//Button[text()='" + text + "']");
    }

    public static By divByText(String text){
        return By.xpath("//div[text()='" + text + "']");
    }

    public static By byTextLikeDiv(String text){
        return By.xpath("//div[contains(text(),'" + text + "')]");
    }

    public static By byTextLike(String text){
        return By.xpath("//*[contains(text(),'" + text + "')]");
    }

    public static By byAriaLabel(String arialabel){
        return By.xpath("//*[@aria-label='" + arialabel + "']");
    }

    public static By byName(String name){
        return By.xpath("//*[@Name='" + name + "']");
    }

    public static By byId(String id){
        return By.xpath("//*[@id='" + id + "']");
    }

    public static By byXPath(String xpath){
        return By.xpath(xpath);
    }

    public static By byIdPrevious(String id){
        return By.xpath("//*[@id='" + id + "']/..");
    }

    public static By byClass(String clas){
        return By.xpath("//*[@class='" + clas + "']");
    }

    public static By byClassButton(String clas){
        return By.xpath("//button[@class='" + clas + "']");
    }
}
