package org.example.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProfileEditTestAPI {
    public static void ProfileEditStepAPI(){
        String path = "src/test/resources/resource.properties";
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            try {
                properties.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        RequestSpecification request = RestAssured.given();
        request.get(properties.getProperty("baseURI")+ "account.saveProfileInfo?" + "relation=1&" + "country_id=1&" + "city_id=1&" + properties.getProperty("access_token")+properties.getProperty("V"));
    }
}
