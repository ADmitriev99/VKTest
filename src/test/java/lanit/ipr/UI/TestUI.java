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
import static lanit.ipr.UI.DiscussionTestUI.DiscussionStepUI;
import static lanit.ipr.UI.LoginTestUI.LoginStepUI;
import static lanit.ipr.UI.MessageTestUI.MessageStepUI;
import static lanit.ipr.UI.PhotoTestUI.PhotoStepUI;
import static lanit.ipr.UI.ProfileEditTestUI.ProfileEditStepUI;

@Epic("UI test")
@Feature("UI test")
@DisplayName("UI Test on VK.com")
public class TestUI extends TestBase {

    @Test
    @Tag("UI test")
    @Story("UI test")
    @Description("UI test on VK.com")
    public void testOnUI() {
        step("Вход в VK.com", ()->{LoginStepUI();});
        step("Редактирование профиля",()->{ProfileEditStepUI();});
        step("Работа с беседой", ()->{MessageStepUI();});
        step("Работа с обсуждениями", ()->{DiscussionStepUI();});
        step("Работа с фотографиями", ()->{PhotoStepUI();});
    }
}
