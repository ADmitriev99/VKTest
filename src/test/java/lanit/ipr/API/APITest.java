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
import static lanit.ipr.API.AlbumAPI.albumStep;
import static lanit.ipr.API.CleanAPI.cleanStepAPI;
import static lanit.ipr.API.GroupAPI.groupStepAPI;
import static lanit.ipr.API.MessageAPI.messageStepAPI;
import static lanit.ipr.API.PhotoAPI.photoEditStepAPI;
import static lanit.ipr.API.ProfileAPI.profileEditStepAPI;

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
            photoEditStepAPI();
        });
        step("Редактирование данных профиля", () -> {
            profileEditStepAPI();
        });
        step("Работа с беседой", () -> {
            messageStepAPI();
        });
        step("Работа с группой", () -> {
            groupStepAPI();
        });
        step("Работа с альбомами", () -> {
            albumStep();
        });
    }

    @AfterEach
    public void afterHook() {
        cleanStepAPI();
    }
}