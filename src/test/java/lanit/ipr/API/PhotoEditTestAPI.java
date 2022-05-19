package lanit.ipr.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lanit.ipr.PropertiesTest;
import okhttp3.*;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.File;

import static io.qameta.allure.Allure.step;
import static okhttp3.Request.*;

public class PhotoEditTestAPI extends PropertiesTest{
    private static okhttp3.Response response2;
    private static String uploadUrl;
    private static Response response;
    private static String server;
    private static String photo;
    private static String hash;
    private static RequestSpecification request = RestAssured.given();
    private static String photoId;

    public static void PhotoEditStepAPI() {
        step("Получение адреса для загрузки фотографии",()-> {
            response = request.get(properties.getProperty("baseURI")+ "photos.getOwnerPhotoUploadServer?" + properties.getProperty("access_token")+properties.getProperty("V"));
            uploadUrl = response.jsonPath().getString("response.upload_url");
            Assertions.assertFalse(uploadUrl.isEmpty());
        });
        step ("Загрузка фотографии на сервер", ()->{
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
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
            Assertions.assertFalse(server.isEmpty());
            Assertions.assertFalse(photo.isEmpty());
            Assertions.assertFalse(hash.isEmpty());
        });
        step ("Подтверждение загрузки фотографии, получение id фотографии", ()->{
            request.get(properties.getProperty("baseURI")+ "photos.saveOwnerPhoto?server=" + server + "&photo=" + photo +"&hash=" + hash + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
            response = request.get(properties.getProperty("baseURI")+ "photos.get?album_id=profile&" + properties.getProperty("access_token")+properties.getProperty("V"));
            photoId = response.jsonPath().getString("response.items[0].id");
            properties.setProperty("mainPhotoId", photoId);
        });

    }
}
