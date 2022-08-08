package lanit.ipr.UI;

import lanit.ipr.actions.Asserts;
import lanit.ipr.actions.buttons.Buttons;
import lanit.ipr.actions.textForms.TextForms;


import java.io.File;

import static io.qameta.allure.Allure.step;

public class PhotoTestUI {

    private static final String PHOTO_PATH = "src/test/resources/3365__45_big.jpg.webp";

    public static void photoStepUI() {
        getPhotoPage();
        createPrivateAlbum();
        addPhotoToAlbum();
        setPhotoAsCover();
        commentPhoto();
        likePhoto();
        getPhotoPage();
        createPublicAlbum();
        movePhotoToSecondAlbum();
        deleteFirstAlbum();
    }

    protected static void deleteFirstAlbum() {
        step("Удаление первого альбома", () -> {
            Buttons.clickByText("Редактировать альбом");
            Buttons.clickById("album_delete_action");
            Buttons.clickByClassButton("FlatButton FlatButton--primary FlatButton--size-m");
            Asserts.displayedByText("Фотографии");
        });
    }

    protected static void movePhotoToSecondAlbum() {
        step("Перемещение фотографии между альбомами", () -> {
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
    }

    protected static void createPublicAlbum() {
        step("Создание публичного альбома", () -> {
            Buttons.clickByTextLike("Создать альбом");
            TextForms.sendkeysById("new_album_title", "АТ альбом 2");
            Buttons.clickById("privacy_edit_album0");
            Buttons.clickByText("Все пользователи");
            Buttons.clickByClassButton("FlatButton FlatButton--primary FlatButton--size-m");
            Asserts.displayedById("photos_upload_area");
        });
    }

    protected static void likePhoto() {
        step("Установка отметки на фотографии", () -> {
            Buttons.clickByClass("like_button_icon");
            Buttons.clickByClass("pv_close_btn");
            Asserts.displayedByText("Фотографии");
        });
    }

    protected static void commentPhoto() {
        step("Комментирование фотографии", () -> {
            TextForms.sendkeysByClass("reply_field submit_post_field", "АТ комментарий фото");
            Buttons.clickByTextLike("Отправить");
            Asserts.displayedByClass("like_button_icon");
        });
    }

    protected static void setPhotoAsCover() {
        step("Установка фотографии обложкой альбома", () -> {
            Buttons.clickByClass("photos_photo_edit_row_thumb ");
            Buttons.clickByClass("pv_actions_more");
            Buttons.clickById("pv_more_act_as_title");
            Asserts.displayedByText("Фотография установлена обложкой альбома");
        });
    }

    protected static void addPhotoToAlbum() {
        step("Добавление фотографии в альбом", () -> {
            Asserts.displayedByText("Редактировать альбом");
            File file = new File(PHOTO_PATH);
            TextForms.sendkeysById("photos_upload_input", file.getAbsolutePath());
            Asserts.displayedByText("Добавьте описание...");
        });
    }

    protected static void createPrivateAlbum() {
        step("Создание приватного альбома", () -> {
            Buttons.clickByTextLike("Создать альбом");
            TextForms.sendkeysById("new_album_title", "АТ альбом 1");
            Buttons.clickById("privacy_edit_album0");
            Buttons.clickByText("Только я");
            Buttons.clickByClassButton("FlatButton FlatButton--primary FlatButton--size-m");
            Asserts.displayedById("photos_upload_area");
        });
    }

    protected static void getPhotoPage() {
        step("Переход на страницу c фотографиями", () -> {
            Buttons.clickByText("Фотографии");
            Asserts.displayedByTextLike("Создать альбом");
        });
    }
}
