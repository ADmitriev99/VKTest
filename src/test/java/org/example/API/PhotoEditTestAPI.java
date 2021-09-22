package org.example.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import okhttp3.*;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.qameta.allure.Allure.step;
import static okhttp3.Request.*;

public class PhotoEditTestAPI {
    private static okhttp3.Response response2;
    private static String uploadUrl;
    private static Response response;
    private static String server;
    private static String photo;
    private static String hash;
    private static RequestSpecification request = RestAssured.given();
    private static String photoId;

    public static void PhotoEditStepAPI() {
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
        step("Получение адреса загрузки фотографии",()-> {
            response = request.get(properties.getProperty("baseURI")+ "photos.getOwnerPhotoUploadServer?" + properties.getProperty("access_token")+properties.getProperty("V"));
            uploadUrl = response.jsonPath().getString("response.upload_url");
            Assertions.assertTrue(!uploadUrl.isEmpty());
        });
        step ("Загрузка фотографии на сервер", ()->{
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("photo","./src/test/resources/P_20190812_163931.jpg",
                            RequestBody.create(MediaType.parse("application/octet-stream"),
                                    new File("./src/test/resources/P_20190812_163931.jpg")))
                    .build();
            Request request2 = new Builder()
                    .url(uploadUrl)
                    .method("POST", body)
                    .addHeader("Cookie", "remixlang=0")
                    .build();
            response2 = client.newCall(request2).execute();
            JSONObject jsonObject = new JSONObject(response2.body().string());
            server = jsonObject.get("server").toString();
            photo = (String) jsonObject.get("photo");
            hash = (String) jsonObject.get("hash");
            Assertions.assertTrue(!server.isEmpty());
            Assertions.assertTrue(!photo.isEmpty());
            Assertions.assertTrue(!hash.isEmpty());
        });
        step ("Подтверждение загрузки фотографии, получение id фотографии", ()->{
            request.get(properties.getProperty("baseURI")+ "photos.saveOwnerPhoto?server=" + server + "&photo=" + photo +"&hash=" + hash + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
            response = request.get(properties.getProperty("baseURI")+ "photos.get?album_id=profile&" + properties.getProperty("access_token")+properties.getProperty("V"));
            photoId = response.jsonPath().getString("response.items[0].id");
            PropertiesConfiguration configuration = null;
            try {
                configuration = new PropertiesConfiguration(path);
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
            configuration.setProperty("mainPhotoId", photoId);
            try {
                configuration.save();
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
        });

    }
}
