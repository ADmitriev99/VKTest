package org.example.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import okhttp3.*;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static okhttp3.Request.*;

public class PhotoEditTestAPI {
    public static void PhotoEditStepAPI() throws IOException {
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
        Response response = request.get(properties.getProperty("baseURI")+ "photos.getOwnerPhotoUploadServer?" + properties.getProperty("access_token")+properties.getProperty("V"));
        String upload_url = response.jsonPath().getString("response.upload_url");
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("photo","C:\\Users\\shdmi\\Downloads\\Telegram Desktop\\P_20190812_163931.jpg",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File("C:\\Users\\shdmi\\Downloads\\Telegram Desktop\\P_20190812_163931.jpg")))
                .build();
        Request request2 = new Builder()
                .url(upload_url)
                .method("POST", body)
                .addHeader("Cookie", "remixlang=0")
                .build();
        okhttp3.Response response2 = client.newCall(request2).execute();
        JSONObject jsonObject = new JSONObject(response2.body().string());
        String server = jsonObject.get("server").toString();
        String photo = (String) jsonObject.get("photo");
        String hash = (String) jsonObject.get("hash");
        request.get(properties.getProperty("baseURI")+ "photos.saveOwnerPhoto?server=" + server + "&photo=" + photo +"&hash=" + hash + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        response = request.get(properties.getProperty("baseURI")+ "photos.get?album_id=profile&" + properties.getProperty("access_token")+properties.getProperty("V"));
        PropertiesConfiguration configuration = null;
        try {
            configuration = new PropertiesConfiguration(path);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        configuration.setProperty("mainPhotoId", response.jsonPath().getString("response.items[0].id"));
        try {
            configuration.save();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }
}
