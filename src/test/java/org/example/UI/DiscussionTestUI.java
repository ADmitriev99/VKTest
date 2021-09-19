package org.example.UI;

import com.sun.istack.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DiscussionTestUI {
    public static void DiscussionStepUI(@NotNull WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[text()=\"Сообщества\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Создать сообщество\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Группа по интересам\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"groups_create_box_title\"]")).sendKeys("АТ группа");
        driver.findElement(By.xpath("//*[@class=\"selector_input\"]/../..//*[contains(@id, \"dropdown\")]")).click();
        driver.findElement(By.xpath("//*[text()=\"Программное обеспечение\"]")).click();
        driver.findElement(By.xpath("//button[text()=\"Создать сообщество\"]")).click();
        try {
            if (driver.findElement(By.xpath("//*[text()=\"Максим  Василенко\"]")).isDisplayed())
            {
                driver.findElement(By.xpath("//*[text()=\"Сообщества\"]")).click();
                driver.findElement(By.xpath("//*[text()=\"АТ группа\"]")).click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[text()=\"Добавить обсуждение\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bnt_title\"]")).sendKeys("АТ заголовок");
        driver.findElement(By.xpath("//*[@id=\"bnt_text\"]")).sendKeys("АТ текст");
        driver.findElement(By.xpath("//*[text()=\"Создать тему\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Редактировать тему\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"checkbox _bet_fixed\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Сохранить\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class=\"reply_field_wrap _emoji_field_wrap\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"reply_field submit_post_field\"]")).sendKeys("АТ комментарий 1");
        driver.findElement(By.xpath("//*[text()=\"Отправить\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class=\"reply_field_wrap _emoji_field_wrap\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"reply_field submit_post_field\"]")).sendKeys("АТ комментарий 2");
        driver.findElement(By.xpath("//*[text()=\"Отправить\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class=\"reply_field_wrap _emoji_field_wrap\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"reply_field submit_post_field\"]")).sendKeys("АТ комментарий 3");
        driver.findElement(By.xpath("//*[text()=\"Отправить\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"bp_edit4\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bpe_text\"]")).sendKeys(" edit");
        driver.findElement(By.xpath("//*[text()=\"Сохранить\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bp_delete3\"]")).click();
    }
}
