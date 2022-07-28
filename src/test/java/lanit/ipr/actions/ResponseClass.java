package lanit.ipr.actions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lanit.ipr.PropertiesSingleton;
import org.junit.jupiter.api.Assertions;

import java.util.Properties;

public class ResponseClass {

    private static final Properties properties = PropertiesSingleton.getInstance();

    private static String requestBuilder(String request){
        return properties.getProperty("baseURI") + request + properties.getProperty("access_token") + properties.getProperty("V");
    }

    public static void getRequest(String request) {
        RequestSpecification requestSpecification = RestAssured.given().urlEncodingEnabled(false);
        Response response = requestSpecification.get(requestBuilder(request));
        Assertions.assertNotEquals("", response.asString());
    }

    public static void postRequest(String request) {
        RequestSpecification requestSpecification = RestAssured.given().urlEncodingEnabled(false);
        requestSpecification.post(requestBuilder(request));
    }

    public static String getRequest(String request, String data) {
        RequestSpecification requestSpecification = RestAssured.given().urlEncodingEnabled(false);
        requestSpecification.get(requestBuilder(request));
        return getFromResponse((Response) requestSpecification, data);
    }

    public static String postRequest(String request, String data) {
        RequestSpecification requestSpecification = RestAssured.given().urlEncodingEnabled(false);
        requestSpecification.post(requestBuilder(request));
        return getFromResponse((Response) requestSpecification, data);
    }

    public static String getFromResponse(Response response, String data) {
        return response.jsonPath().getString(data);
    }
}
