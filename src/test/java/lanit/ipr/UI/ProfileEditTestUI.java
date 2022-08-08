package lanit.ipr.UI;

import lanit.ipr.actions.Asserts;
import lanit.ipr.actions.buttons.Buttons;
import lanit.ipr.actions.textForms.TextForms;

import java.io.File;

import static io.qameta.allure.Allure.step;

public class ProfileEditTestUI {

    private static final String PHOTO_PATH = "./src/test/resources/P_20190812_163931.jpg";

    public static void profileEditStepUI() {
        getPersonalPage();
        uploadCoverPhoto();
        editPersonalData();
        editContactInformation();
    }

    protected static void editContactInformation() {
        step("Изменение контактной информации", () -> {
            Buttons.clickById("ui_rmenu_contacts");
            Buttons.clickByIdPrevious("pedit_country");
            Buttons.clickByText("Россия");
            Buttons.clickByIdPrevious("pedit_city");
            Buttons.clickByText("Москва");
            Buttons.clickByTextLike("Сохранить");
            Asserts.displayedByText("Новые данные будут отражены на вашей странице.");
        });
    }

    protected static void editPersonalData() {
        step("Изменение информации о себе", () -> {
            Buttons.clickById("profile_edit_act");
            Buttons.clickByIdPrevious("pedit_status");
            Buttons.clickByText("Не женат");
            Buttons.clickByTextLike("Сохранить");
            Asserts.displayedByText("Новые данные будут отражены на вашей странице.");
        });
    }

    protected static void uploadCoverPhoto() {
        step("Загрузка фотографии на Аватар", () -> {
            Buttons.clickById("page_avatar");
            File file = new File(PHOTO_PATH);
            TextForms.sendkeysByClass("OwnerAvatarEditor__formInput", file.getAbsolutePath());
            Buttons.clickByText("Сохранить и продолжить");
            Buttons.clickByText("Сохранить изменения");
            Buttons.clickByText("Опубликовать запись");
            Buttons.clickByText("Продолжить");
        });
    }

    protected static void getPersonalPage() {
        step("Переход на личную страницу", () -> {
            Buttons.clickByText("Моя страница");
            Asserts.displayedByText("Максим  Василенко");
        });
    }
}
