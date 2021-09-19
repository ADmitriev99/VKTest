package org.example.API;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.example.API.AlbumTestAPI.AlbumStepAPI;
import static org.example.API.CleanTestAPI.CleanStepAPI;
import static org.example.API.GroupTestAPI.GroupStepAPI;
import static org.example.API.MessageTestAPI.MessageStepAPI;
import static org.example.API.PhotoEditTestAPI.PhotoEditStepAPI;
import static org.example.API.ProfileEditTestAPI.ProfileEditStepAPI;

@Epic("API test")
@Feature("API test")
@DisplayName("API Test on VK.com")
public class APITest {
    @Tag("API test")
    @Story("API test")
    @Description("API test on VK.com")
    public static void APITest() {
        step("Редактирование главной фотографии",()-> {PhotoEditStepAPI();});
        step("Редактирование данных профиля", ()-> {ProfileEditStepAPI();});
        step("Работа с беседой", ()-> {MessageStepAPI();});
        step("Работа с группой", ()-> {GroupStepAPI();});
        step("Работа с альбомами", ()-> {AlbumStepAPI();});
        step("Приведение в исходное состояние", ()->{CleanStepAPI();});
    }
}