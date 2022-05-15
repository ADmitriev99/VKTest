package lanit.ipr.UI;

import lanit.ipr.DriverTest;
import lanit.ipr.elements.Asserts;
import lanit.ipr.elements.buttons.Buttons;
import lanit.ipr.elements.textForms.TextForms;
import org.openqa.selenium.By;

import java.io.File;

import static io.qameta.allure.Allure.step;

public class PhotoTestUI extends DriverTest {
    private static By photos = By.xpath("//*[text()=\"Фотографии\"]");
    private static By createAlbum = By.xpath("//*[contains(text(),\"Создать альбом\")]");
    private static By albumName = By.xpath("//*[@id=\"new_album_title\"]");
    private static By albumPrivacyType = By.xpath("//*[@id=\"privacy_edit_album0\"]");
    private static By albumPrivacyMe = By.xpath("//*[text()=\"Только я\"]");
    private static By albumPrivacyEveryone = By.xpath("//*[text()=\"Все пользователи\"]");
    private static By createAlbumButton = By.xpath("//button[text()=\"Создать альбом\"]");
    private static By uploadPhoto = By.xpath("//*[@id=\"photos_upload_input\"]");
    private static By myPhotos = By.xpath("//*[text()=\"Мои фотографии\"]");
    private static By editAlbum = By.xpath("//*[text()=\"Редактировать альбом\"]");
    private static By editPhoto = By.xpath("//*[@class=\"photos_photo_edit_row_thumb \"]");
    private static By actionsPhoto = By.xpath("//*[@class=\"pv_actions_more\"]");
    private static By setPhotoAsTitle = By.xpath("//*[@id=\"pv_more_act_as_title\"]");
    private static By commentPhoto = By.xpath("//*[@class=\"reply_field submit_post_field\"]");
    private static By addCommentPhoto = By.xpath("//*[@class=\"flat_button addpost_button\"]");
    private static By likePhoto = By.xpath("//*[@class=\"like_btn like _like   empty\"]");
    private static By closePhoto = By.xpath("//*[@class=\"pv_close_btn\"]");
    private static By firstAlbum = By.xpath("//*[@title=\"АТ альбом 1\"]");
    private static By photo = By.xpath("//*[@aria-label=\"Фотография\"]");
    private static By commentText = By.xpath("//*[text()=\"АТ комментарий фото\"]");
    private static By movePhoto = By.xpath("//*[@id=\"pv_more_act_move_to\"]");
    private static By secondAlbum = By.xpath("//*[@title=\"АТ альбом 2\"]");
    private static By deleteAlbum = By.xpath("//*[@id=\"album_delete_action\"]");
    private static By deleteButton = By.xpath("//button[text()=\"Удалить\"]");
    public static void PhotoStepUI() {
        step("Переход на страницу c фотографиями",()-> {
            Buttons.clickByText("Фотографии");
            Asserts.displayedByTextLike("Создать альбом");
        });
        step("Создание приватного альбома",()-> {
            Buttons.clickByTextLike("Создать альбом");
            TextForms.sendkeysById("new_album_title","АТ альбом 1" );
            Buttons.clickById("privacy_edit_album0");
            Buttons.clickByText("Только я");
            Buttons.clickByClassButton("FlatButton FlatButton--primary FlatButton--size-m");
            Asserts.displayedById("photos_upload_area");
        });
        step("Добавление фотографии в альбом",()-> {
            Asserts.displayedByText("Редактировать альбом");
            File file = new File("src/test/resources/3365__45_big.jpg.webp");
            TextForms.sendkeysById("photos_upload_input", file.getAbsolutePath());
            Asserts.displayedByText("Добавьте описание...");
        });
        step("Установка фотографии обложкой альбома",()-> {
            Buttons.clickByClass("photos_photo_edit_row_thumb ");
            Buttons.clickByClass("pv_actions_more");
            Buttons.clickById("pv_more_act_as_title");
            Asserts.displayedByText("Фотография установлена обложкой альбома");
        });
        step("Комментирование фотографии",()-> {
            TextForms.sendkeysByClass("reply_field submit_post_field", "АТ комментарий фото");
            Buttons.clickByTextLike("Отправить");
            Asserts.displayedByClass("like_button_icon");
        });
        step("Установка отметки на фотографии",()-> {
            Buttons.clickByClass("like_button_icon");
            Buttons.clickByClass("pv_close_btn");
            Asserts.displayedByText("Фотографии");
        });
        step("Переход на страницу c фотографиями",()-> {
            Buttons.clickByText("Фотографии");
            Asserts.displayedByTextLike("Создать альбом");
        });
        step("Создание публичного альбома",()-> {
            Buttons.clickByTextLike("Создать альбом");
            TextForms.sendkeysById("new_album_title","АТ альбом 2" );
            Buttons.clickById("privacy_edit_album0");
            Buttons.clickByText("Все пользователи");
            Buttons.clickByClassButton("FlatButton FlatButton--primary FlatButton--size-m");
            Asserts.displayedById("photos_upload_area");
        });
        step("Перемещение фотографии между альбомами",()-> {
            Asserts.displayedByText("Редактировать альбом");
            Buttons.clickByText("Мои фотографии");
            Buttons.clickByTextLikeDiv("АТ альбом 1");
            Buttons.clickByAriaLabel("Фотография");
            Asserts.displayedByText("АТ комментарий фото");
            Buttons.clickByClass("pv_actions_more");
            Buttons.clickById("pv_more_act_move_to");
            Buttons.clickByTextLikeDiv("АТ альбом 2");
            Buttons.clickByClass("pv_close_btn");
            Asserts.displayedByText("Фотографии");
        });
        step("Удаление первого альбома",()-> {
            Buttons.clickByText("Редактировать альбом");
            Buttons.clickById("album_delete_action");
            Buttons.clickByClassButton("FlatButton FlatButton--primary FlatButton--size-m");
            Asserts.displayedByText("Фотографии");
        });

    }
}
