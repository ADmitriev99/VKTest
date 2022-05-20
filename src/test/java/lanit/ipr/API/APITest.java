package lanit.ipr.API;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;
import static lanit.ipr.API.AlbumTestAPI.AlbumStep;
import static lanit.ipr.API.CleanTestAPI.CleanStepAPI;
import static lanit.ipr.API.GroupTestAPI.GroupStepAPI;
import static lanit.ipr.API.MessageTestAPI.MessageStepAPI;
import static lanit.ipr.API.PhotoEditTestAPI.PhotoEditStepAPI;
import static lanit.ipr.API.ProfileEditTestAPI.ProfileEditStepAPI;

@Epic("API test")
@Feature("API test")
@DisplayName("API Test on VK.com")
public class APITest {

    @Test
    @Tag("API test")
    @Story("API test")
    @Description("API test on VK.com")
    public void APITest() {
        step("Редактирование главной фотографии",()-> {PhotoEditStepAPI();});
        step("Редактирование данных профиля", ()-> {ProfileEditStepAPI();});
        step("Работа с беседой", ()-> {MessageStepAPI();});
        step("Работа с группой", ()-> {GroupStepAPI();});
        step("Работа с альбомами", ()-> {AlbumStep();});
    }

    @AfterEach
    public void afterHook() {
       CleanStepAPI();
    }
}