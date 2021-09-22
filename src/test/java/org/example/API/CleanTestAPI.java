package org.example.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CleanTestAPI {
    public static void CleanStepAPI() throws InterruptedException {
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
        request.post(properties.getProperty("baseURI")+ "photos.delete?photo_id="+ properties.getProperty("mainPhotoId")+ "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        request.get(properties.getProperty("baseURI")+ "account.saveProfileInfo?" + "relation=0&" + "country_id=0&" + "city_id=0&" + properties.getProperty("access_token")+properties.getProperty("V"));
        request.post(properties.getProperty("baseURI")+ "messages.deleteConversation?peer_id=" + properties.getProperty("chatId") + "&"+ properties.getProperty("access_token")+properties.getProperty("V"));
        request.get(properties.getProperty("baseURI")+ " groups.leave?group_id=" + properties.getProperty("groupId") + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        request.get(properties.getProperty("baseURI")+ "photos.deleteAlbum?album_id=" + properties.getProperty("albumId") + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
    }
}
