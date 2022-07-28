package lanit.ipr.API;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static lanit.ipr.API.AlbumAPI.AlbumStep;
import static lanit.ipr.API.CleanAPI.CleanStepAPI;
import static lanit.ipr.API.GroupAPI.GroupStepAPI;
import static lanit.ipr.API.MessageAPI.MessageStepAPI;
import static lanit.ipr.API.PhotoAPI.PhotoEditStepAPI;
import static lanit.ipr.API.ProfileAPI.ProfileEditStepAPI;

@Epic("API test")
@Feature("API test")
@DisplayName("API Test on VK.com")
public class APITest {

    @Test
    @Tag("API test")
    @Story("API test")
    @Description("API test on VK.com")
    public void APITest() {
        step("Редактирование главной фотографии", () -> {
            PhotoEditStepAPI();
        });
        step("Редактирование данных профиля", () -> {
            ProfileEditStepAPI();
        });
        step("Работа с беседой", () -> {
            MessageStepAPI();
        });
        step("Работа с группой", () -> {
            GroupStepAPI();
        });
        step("Работа с альбомами", () -> {
            AlbumStep();
        });
    }

    @AfterEach
    public void afterHook() {
        CleanStepAPI();
    }
}