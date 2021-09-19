package org.example.UI;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CleanTestUI {
    public static void CleanStepUI(@NotNull WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@title=\"АТ альбом 2\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Редактировать альбом\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"album_delete_action\"]")).click();
        driver.findElement(By.xpath("//button[text()=\"Удалить\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Сообщества\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"АТ группа\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"page_actions_btn\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Выйти из группы\"]")).click();
        driver.findElement(By.xpath("//button[text()=\"Выйти из группы\"]")).click();
        driver.findElement(By.xpath("//span[text()=\"Мессенджер\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Ну очень важная беседа\"]")).click();
        Thread.sleep(100);
        driver.findElement(By.xpath("//div[@class=\"nim-peer  nim-peer_smaller\"]")).click();
        driver.findElement(By.xpath("//button[text()=\"Выйти из беседы\"]")).click();
        driver.findElement(By.xpath("//button[@class=\"flat_button\"]")).click();
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
        driver.findElement(By.xpath("//*[@id='pedit_interests_activities']")).clear();
        driver.findElement(By.xpath("//*[@id='pedit_interests_interests']")).clear();
        driver.findElement(By.xpath("//*[@id='pedit_interests_music']")).clear();
        driver.findElement(By.xpath("//*[@id='pedit_interests_movies']")).clear();
        driver.findElement(By.xpath("//*[@id='pedit_interests_tv']")).clear();
        driver.findElement(By.xpath("//*[@id='pedit_interests_books']")).clear();
        driver.findElement(By.xpath("//*[@id='pedit_interests_games']")).clear();
        driver.findElement(By.xpath("//*[@id='pedit_interests_quotes']")).clear();
        driver.findElement(By.xpath("//*[@id='pedit_interests_about']")).clear();
        driver.findElement(By.xpath("//*[text()=\"Сохранить\"]")).click();
        driver.findElement(By.xpath("//*[@id='ui_rmenu_education']")).click();
        try {
            if (driver.findElement(By.xpath("//*[text()=\"Продолжить\"]")).isDisplayed()) {
                driver.findElement(By.xpath("//*[text()=\"Продолжить\"]")).click();
            }
        }
        catch (Exception e){
        }
        driver.findElement(By.xpath("//*[@class=\"pedit_del_icon _del_icon pedit_school_row_delete\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Сохранить\"]")).click();
        driver.findElement(By.xpath("//*[@href=\"/edit?act=higher_education\"]")).click();
        try {
            if (driver.findElement(By.xpath("//*[text()=\"Продолжить\"]")).isDisplayed()) {
                driver.findElement(By.xpath("//*[text()=\"Продолжить\"]")).click();
            }
        }
        catch (Exception e){
        }
        driver.findElement(By.xpath("//div[contains(@id, \"u_university\")]//div[2]//div[contains(@id, \"container\")]")).click();
        driver.findElement(By.xpath("//li[text()=\"Не выбран\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Сохранить\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ui_rmenu_military\"]")).click();
        try {
            if (driver.findElement(By.xpath("//*[text()=\"Продолжить\"]")).isDisplayed()) {
                driver.findElement(By.xpath("//*[text()=\"Продолжить\"]")).click();
            }
        }
        catch (Exception e){
        }
        driver.findElement(By.xpath("//*[@class=\"pedit_del_icon _del_icon pedit_mil_row_delete\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Сохранить\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ui_rmenu_career\"]")).click();
        try {
            if (driver.findElement(By.xpath("//*[text()=\"Продолжить\"]")).isDisplayed()) {
                driver.findElement(By.xpath("//*[text()=\"Продолжить\"]")).click();
            }
        }
        catch (Exception e){
        }
        driver.findElement(By.xpath("//*[@class=\"pedit_del_icon _del_icon pedit_career_item_delete\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Сохранить\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ui_rmenu_personal\"]")).click();
        try {
            if (driver.findElement(By.xpath("//*[text()=\"Продолжить\"]")).isDisplayed()) {
                driver.findElement(By.xpath("//*[text()=\"Продолжить\"]")).click();
            }
        }
        catch (Exception e){
        }
        driver.findElement(By.xpath("//*[@id=\"pedit_political\"]/../input[@type=\"text\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Не выбраны\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pedit_life\"]/../input[@type=\"text\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Не указано\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pedit_people\"]/../input[@type=\"text\"]")).click();
        driver.findElement(By.xpath("//*[@title=\"Ум и креативность\"]/../li")).click();
        driver.findElement(By.xpath("//*[@id=\"pedit_smoking\"]/../input[@type=\"text\"]")).click();
        driver.findElement(By.xpath("//*[@title=\"Негативное\"]/../li")).click();
        driver.findElement(By.xpath("//*[@id=\"pedit_alcohol\"]/../input[@type=\"text\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"selector_container dropdown_container big limited_height selector_focused\"]//*[text()=\"Не указано\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pedit_inspired_by\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"pedit_religion\"]/../input[@type=\"text\"]")).clear();
        driver.findElement(By.xpath("//*[text()=\"Сохранить\"]")).click();
        try {
            if (driver.findElement(By.xpath("//*[text()=\"Продолжить\"]")).isDisplayed()) {
                driver.findElement(By.xpath("//*[text()=\"Продолжить\"]")).click();
            }
        }
        catch (Exception e){
        }
        driver.quit();
    }
}
