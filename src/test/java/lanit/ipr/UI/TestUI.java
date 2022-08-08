package lanit.ipr.UI;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lanit.ipr.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static lanit.ipr.UI.GroupTestUI.groupStepUI;
import static lanit.ipr.UI.MessageTestUI.messageStepUI;
import static lanit.ipr.UI.LoginTestUI.loginStepUI;
import static lanit.ipr.UI.PhotoTestUI.photoStepUI;
import static lanit.ipr.UI.ProfileEditTestUI.profileEditStepUI;

@Epic("UI test")
@Feature("UI test")
@DisplayName("UI Test on VK.com")
public class TestUI extends TestBase {

    @Test
    @Tag("UI test")
    @Story("UI test")
    @Description("UI test on VK.com")
    public void testOnUI() {
        step("Вход в VK.com", () -> {
            loginStepUI();
        });
        step("Редактирование профиля", () -> {
            profileEditStepUI();
        });
        step("Работа с беседой", () -> {
            messageStepUI();
        });
        step("Работа с обсуждениями", () -> {
            groupStepUI();
        });
        step("Работа с фотографиями", () -> {
            photoStepUI();
        });
    }
}
