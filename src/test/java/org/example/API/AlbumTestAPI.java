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

public class AlbumTestAPI {
    private static okhttp3.Response response2;
    private static String uploadUrl;
    private static Response response;
    private static String server;
    private static String photo;
    private static String hash;
    private static RequestSpecification request = RestAssured.given();
    private static String album1;
    private static String album2;
    private static String photoId;

    public static void AlbumStepAPI() throws IOException {
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
        step("Создание нового альбома, получение id альбома",()->{
            response = request.get(properties.getProperty("baseURI")+ "photos.createAlbum?privacy_view=only me&title=" + "АТ альбом 1&" + properties.getProperty("access_token")+properties.getProperty("V"));
            album1 = response.jsonPath().getString("response.id");
            Assertions.assertTrue(!album1.isEmpty());
        });
        step("Получение адреса загрузки фотографии",()->{
            response = request.get(properties.getProperty("baseURI")+ "photos.getUploadServer?album_id=" + album1 + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
            uploadUrl = response.jsonPath().getString("response.upload_url");
            Assertions.assertTrue(!uploadUrl.isEmpty());
        });
        step("Загрузка фотографии на сервер",()->{
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("photo","./src/test/resources/3365__45_big.jpg.webp",
                            RequestBody.create(MediaType.parse("application/octet-stream"),
                                    new File("./src/test/resources/3365__45_big.jpg.webp")))
                    .build();
            Request request2 = new Request.Builder()
                    .url(uploadUrl)
                    .method("POST", body)
                    .addHeader("Cookie", "remixlang=0")
                    .build();
            okhttp3.Response response2 = client.newCall(request2).execute();
            JSONObject jsonObject = new JSONObject(response2.body().string());
            server = jsonObject.get("server").toString();
            photo = (String) jsonObject.get("photos_list");
            hash = (String) jsonObject.get("hash");
            Assertions.assertTrue(!server.isEmpty());
            Assertions.assertTrue(!photo.isEmpty());
            Assertions.assertTrue(!hash.isEmpty());
            photo = photo.replace("}", "%7D");
            photo = photo.replace("{", "%7B");
            photo = photo.replaceAll("\"","%22");
        });
        step("Подтверждение загрузки фотографии, получение id фотографии",()->{
            request = RestAssured.given().urlEncodingEnabled(false);
            response = request.get(properties.getProperty("baseURI")+ "photos.save?album_id=" + album1 + "&server=" +server + "&hash="+hash +"&photos_list="+ photo +"&" + properties.getProperty("access_token")+properties.getProperty("V"));
            photoId = response.jsonPath().getString("response[0].id");
            Assertions.assertTrue(!photoId.isEmpty());
        });
        step("Установка фотографии в качестве обложки альбома",()->{
            request = RestAssured.given().urlEncodingEnabled(true);
            request.get(properties.getProperty("baseURI")+ "photos.makeCover?album_id=" + album1 + "&photo_id=" +photo +"&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Создание комментария с текстом \"АТ комментарий\"",()->{
            request.get(properties.getProperty("baseURI")+ "photos.createComment?message=АТ комментарий"  + "&photo_id=" +photo +"&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Постановка отметки на фотографии",()->{
            request.get(properties.getProperty("baseURI")+ "likes.add?type=photo" + "&item_id=" +photo +"&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Создание нового альбома, получение id альбома",()->{
            response = request.get(properties.getProperty("baseURI")+ "photos.createAlbum?privacy_view=all&title=" + "АТ альбом 2&" + properties.getProperty("access_token")+properties.getProperty("V"));
            album2 = response.jsonPath().getString("response.id");
            Assertions.assertTrue(!album2.isEmpty());
            PropertiesConfiguration configuration = null;
            try {
                configuration = new PropertiesConfiguration(path);
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
            configuration.setProperty("albumId", album2);
            try {
                configuration.save();
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
        });
        step("Перемещение фотографии во второй альбом",()->{
            request.get(properties.getProperty("baseURI")+ "photos.move?target_album_id=" + album2 + "&photo_id=" +photo +"&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Удаление первого альбома",()->{
            request.get(properties.getProperty("baseURI")+ "photos.deleteAlbum?album_id=" + album1 + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Создание нового альбома, получение id альбома",()->{
            request.get(properties.getProperty("baseURI")+ "photos.deleteAlbum?album_id=" + album2 + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
    }
}
