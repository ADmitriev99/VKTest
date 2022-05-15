package lanit.ipr.UI;

import lanit.ipr.DriverTest;
import org.openqa.selenium.By;

public class CleanTestUI extends DriverTest {
    public static void CleanStepUI() {
        driver.findElement(By.xpath("//*[text()=\"Моя страница\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"page_avatar_img\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pv_delete\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"pv_close_btn\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"profile_edit_act\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pedit_status\"]/..")).click();
        driver.findElement(By.xpath("//*[text()=\"Не выбрано\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Сохранить\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ui_rmenu_contacts\"]")).click();
        try {
            if (driver.findElement(By.xpath("//*[text()=\"Продолжить\"]")).isDisplayed()) {
                driver.findElement(By.xpath("//*[text()=\"Продолжить\"]")).click();
            }
        }
        catch (Exception e){
        }
        driver.findElement(By.xpath("//*[@id=\"pedit_country\"]/..")).click();
        driver.findElement(By.xpath("//li[text()=\"Не выбрана\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Сохранить\"]")).click();
        driver.findElement(By.xpath("//*[@id='ui_rmenu_interests']")).click();
        try {
            if (driver.findElement(By.xpath("//*[text()=\"Продолжить\"]")).isDisplayed()) {
                driver.findElement(By.xpath("//*[text()=\"Продолжить\"]")).click();
            }
        }
        catch (Exception e){
        }
        driver.findElement(By.xpath("//span[text()=\"Мессенджер\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Ну очень важная беседа\"]")).click();
        driver.findElement(By.xpath("//div[@class=\"nim-peer  nim-peer_smaller\"]")).click();
        driver.findElement(By.xpath("//button[text()=\"Выйти из беседы\"]")).click();
        driver.findElement(By.xpath("//button[@class=\"flat_button\"]")).click();

        driver.findElement(By.xpath("//*[@title=\"АТ альбом 2\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Редактировать альбом\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"album_delete_action\"]")).click();
        driver.findElement(By.xpath("//button[text()=\"Удалить\"]")).click();

        driver.findElement(By.xpath("//*[text()=\"Сообщества\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"АТ группа\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"page_actions_btn\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Выйти из группы\"]")).click();
        driver.findElement(By.xpath("//button[text()=\"Выйти из группы\"]")).click();
    }
}
