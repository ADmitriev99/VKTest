package lanit.ipr.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lanit.ipr.PropertiesTest;
import org.junit.jupiter.api.Assertions;

import static io.qameta.allure.Allure.step;

public class ProfileEditTestAPI extends PropertiesTest {
    private static Response response;
    private static RequestSpecification request = RestAssured.given();

    public static void ProfileEditStepAPI() {
        step("Редактирование семейного положения, страны и города",()-> {
            response = request.get(properties.getProperty("baseURI")+ "account.saveProfileInfo?" + "relation=1&" + "country_id=1&" + "city_id=1&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        Assertions.assertTrue(!response.body().asString().isEmpty());
        }
}
