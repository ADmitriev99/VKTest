package org.example.UI;

import com.sun.istack.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MessageTestUI {
    public static void MessageStepUI(@NotNull WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[text()=\"Мессенджер\"]")).click();
        driver.findElement(By.xpath("//*[@aria-label=\"Новая беседа\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"im_dialogs_creation_name\"]")).sendKeys("АТ беседа");
        driver.findElement(By.xpath("//*[text()=\"Создать беседу\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"im-page--aside-photo\"]")).click();
        driver.findElement(By.cssSelector(".EditableLabel__text")).click();
        driver.findElement(By.cssSelector(".Textarea")).click();
        driver.findElement(By.cssSelector(".Textarea")).sendKeys(Keys.SHIFT,Keys.HOME,Keys.DELETE,"Ну очень важная беседа");
        driver.findElement(By.cssSelector(".EditableLabel__save")).click();
        driver.findElement(By.xpath("//*[text()=\"Добавить участников\"]")).click();
        driver.findElement(By.xpath("//*[@data-id=\"671826444\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Добавить собеседника\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"PopupHeader__closeBtn\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"im_editable0\"]")).sendKeys("Это очень важная беседа, выходить!",Keys.ENTER);
        Thread.sleep(100);
        driver.findElement(By.xpath("//*[@id=\"im_editable0\"]")).sendKeys(Keys.ARROW_UP);
        driver.findElement(By.xpath("//*[@id=\"im_editable0\"]")).sendKeys(Keys.SHIFT,Keys.HOME,Keys.DELETE,"Это очень важная беседа, НЕ выходить!");
        driver.findElement(By.xpath("//button[@aria-label=\"Редактировать\"]")).click();
        Thread.sleep(100);
        while (!driver.findElement(By.xpath("//*[text()=\"Переслать\"]")).isDisplayed()) {
            driver.findElement(By.xpath("//div[contains(text(),\"Это очень важная беседа\")]/..")).click();
        }
        driver.findElement(By.xpath("//*[@aria-label=\"Закрепить сообщение\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"im_editable0\"]")).sendKeys("А нет, лучше в группу",Keys.ENTER);
    }
}
