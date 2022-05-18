package lanit.ipr.UI;

import lanit.ipr.DriverTest;
import lanit.ipr.elements.Asserts;
import lanit.ipr.elements.buttons.Buttons;

public class CleanTestUI extends DriverTest {

    public static void CleanStepUI() {
        try {
            Buttons.clickByText("Моя страница");
            Buttons.clickByClass("page_avatar_img");
            Buttons.clickById("pv_delete");
            Buttons.clickByClass("pv_close_btn");
            Buttons.clickById("profile_edit_act");
            Buttons.clickByIdPrevious("pedit_status");
            Buttons.clickByText("Не выбрано");
            Buttons.clickByTextLike("Сохранить");
            Asserts.displayedByTextLike("Изменения сохранены");
            Buttons.clickById("ui_rmenu_contacts");
            Buttons.clickByIdPrevious("pedit_country");
            Buttons.clickByTitle("Не выбрана");
            Buttons.clickByTextLike("Сохранить");
        } catch (Exception e) {
        }try {
            Buttons.clickByText("Мессенджер");
            Buttons.clickByText("А нет, лучше в группу");
            Buttons.deleteConversation();
            Buttons.clickByTextLike("Очистить историю сообщений");
            Buttons.clickByClass("FlatButton FlatButton--primary FlatButton--size-m");
        } catch (Exception e) {
        }try {
            Buttons.clickByText("Сообщества");
            Buttons.clickByText("АТ группа");
            Buttons.clickById("page_actions_btn");
            Buttons.clickByText("Выйти из группы");
            Buttons.clickByText("Выйти из группы");
        } catch (Exception e) {
        }try {
            Buttons.clickByText("Фотографии");
            Buttons.clickByTextLikeDiv("АТ альбом 2");
            Buttons.clickByText("Редактировать альбом");
            Buttons.clickById("album_delete_action");
            Buttons.clickByClassButton("FlatButton FlatButton--primary FlatButton--size-m");
        } catch (Exception e) {
        }finally {
            driver.quit();
        }
        /*driver.findElement(By.xpath("//*[text()=\"Моя страница\"]")).click();
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
        driver.findElement(By.xpath("//span[text()=\"Мессенджер\"]")).click();*/
    }
}
