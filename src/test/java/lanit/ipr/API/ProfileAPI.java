package lanit.ipr.API;

import static io.qameta.allure.Allure.step;
import static lanit.ipr.actions.ResponseClass.getRequest;

public class ProfileAPI {

    public static void profileEditStepAPI() {
        editPersonalData();
    }

    protected static void editPersonalData() {
        step("Редактирование семейного положения, страны и города", () -> {
            getRequest("account.saveProfileInfo?" + "relation=1&" + "country_id=1&" + "city_id=1&");
        });
    }
}
