package org.example.UI;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PhotoTestUI {
    public static void PhotoStepUI(@NotNull WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[text()=\"Фотографии\"]")).click();
        driver.findElement(By.xpath("//*[contains(text(),\"Создать альбом\")]")).click();
        driver.findElement(By.xpath("//*[@id=\"new_album_title\"]")).sendKeys("АТ альбом 1");
        driver.findElement(By.xpath("//*[@id=\"privacy_edit_album0\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Только я\"]")).click();
        driver.findElement(By.xpath("//button[text()=\"Создать альбом\"]")).click();
        while (!driver.findElement(By.xpath("//*[text()=\"Редактировать альбом\"]")).isDisplayed()){
            Thread.sleep(100);
        }
        driver.findElement(By.xpath("//*[@id=\"photos_upload_input\"]")).sendKeys("C:\\Users\\shdmi\\Downloads\\Telegram Desktop\\3365__45_big.jpg.webp");
        driver.findElement(By.xpath("//*[@class=\"photos_photo_edit_row_thumb \"]")).click();
        driver.findElement(By.xpath("//*[@class=\"pv_actions_more\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pv_more_act_as_title\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"reply_field submit_post_field\"]")).sendKeys("АТ комментарий фото");
        driver.findElement(By.xpath("//*[@class=\"flat_button addpost_button\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"like_btn like _like   empty\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"pv_close_btn\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Фотографии\"]")).click();
        driver.findElement(By.xpath("//*[contains(text(),\"Создать альбом\")]")).click();
        driver.findElement(By.xpath("//*[@id=\"new_album_title\"]")).sendKeys("АТ альбом 2");
        driver.findElement(By.xpath("//*[@id=\"privacy_edit_album0\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Все пользователи\"]")).click();
        driver.findElement(By.xpath("//button[text()=\"Создать альбом\"]")).click();
        while (!driver.findElement(By.xpath("//*[text()=\"Редактировать альбом\"]")).isDisplayed()){
            Thread.sleep(100);
        }
        driver.findElement(By.xpath("//*[text()=\"Мои фотографии\"]")).click();
        driver.findElement(By.xpath("//*[@title=\"АТ альбом 1\"]")).click();
        driver.findElement(By.xpath("//*[@aria-label=\"Фотография\"]")).click();
        while (!driver.findElement(By.xpath("//*[text()=\"АТ комментарий фото\"]")).isDisplayed()){
            Thread.sleep(100);
        }
        driver.findElement(By.xpath("//*[@class=\"pv_actions_more\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pv_more_act_move_to\"]")).click();
        driver.findElement(By.xpath("//*[@title=\"АТ альбом 2\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"pv_close_btn\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Редактировать альбом\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"album_delete_action\"]")).click();
        driver.findElement(By.xpath("//button[text()=\"Удалить\"]")).click();
    }
}
