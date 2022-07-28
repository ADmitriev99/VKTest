package lanit.ipr.UI;

import lanit.ipr.actions.Asserts;
import lanit.ipr.actions.buttons.Buttons;
import lanit.ipr.actions.textForms.TextForms;

import static io.qameta.allure.Allure.step;

public class ProfileEditTestUI {

    public static void ProfileEditStepUI() {
        step("Переход на личную страницу", () -> {
            Buttons.clickByText("Моя страница");
            Asserts.displayedByText("Максим  Василенко");
        });
        step("Загрузка фотографии на Аватар", () -> {
            Buttons.clickById("page_avatar");
            TextForms.sendkeysByClass("OwnerAvatarEditor__formInput", "A:\\Documents\\JAVA\\VKTest\\src\\test\\resources\\P_20190812_163931.jpg");
            Buttons.clickByText("Сохранить и продолжить");
            Buttons.clickByText("Сохранить изменения");
            Buttons.clickByText("Опубликовать запись");
            Buttons.clickByText("Продолжить");
        });
        step("Изменение информации о себе", () -> {
            Buttons.clickById("profile_edit_act");
            Buttons.clickByIdPrevious("pedit_status");
            Buttons.clickByText("Не женат");
            Buttons.clickByTextLike("Сохранить");
            Asserts.displayedByText("Новые данные будут отражены на вашей странице.");
        });
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
}
