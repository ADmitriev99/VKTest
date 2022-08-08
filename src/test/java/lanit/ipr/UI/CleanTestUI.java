package lanit.ipr.UI;

import lanit.ipr.actions.Asserts;
import lanit.ipr.actions.buttons.Buttons;
import org.openqa.selenium.WebDriver;

import static lanit.ipr.DriverSingleton.getInstance;

public class CleanTestUI {

    private static WebDriver driver = getInstance();

    public static void cleanStepUI() {
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
        }
        try {
            Buttons.clickByText("Мессенджер");
            Buttons.clickByText("А нет, лучше в группу");
            Buttons.deleteConversation();
            Buttons.clickByTextLike("Очистить историю сообщений");
            Buttons.clickByClass("FlatButton FlatButton--primary FlatButton--size-m");
        } catch (Exception e) {
        }
        try {
            Buttons.clickByText("Сообщества");
            Buttons.clickByText("АТ группа");
            Buttons.clickById("page_actions_btn");
            Buttons.clickByText("Выйти из группы");
            Buttons.clickByText("Выйти из группы");
        } catch (Exception e) {
        }
        try {
            Buttons.clickByText("Фотографии");
            Buttons.clickByTextLikeDiv("АТ альбом 2");
            Buttons.clickByText("Редактировать альбом");
            Buttons.clickById("album_delete_action");
            Buttons.clickByClassButton("FlatButton FlatButton--primary FlatButton--size-m");
        } catch (Exception e) {
        } finally {
            driver.quit();
        }
    }
}
