package lanit.ipr.API;

import io.restassured.response.Response;
import lanit.ipr.PropertiesSingleton;
import okhttp3.*;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.util.Properties;

import static io.qameta.allure.Allure.step;
import static lanit.ipr.actions.ResponseClass.getFromResponse;
import static lanit.ipr.actions.ResponseClass.getRequest;
import static okhttp3.Request.Builder;

public class PhotoAPI {
    private static okhttp3.Response response2;
    private static String uploadUrl;
    private static Response response;
    private static String server;
    private static String photo;
    private static String hash;
    private static String photoId;
    private static Properties properties = PropertiesSingleton.getInstance();

    public static void PhotoEditStepAPI() {
        step("Получение адреса для загрузки фотографии", () -> {
            uploadUrl = getRequest("photos.getOwnerPhotoUploadServer?", "response.upload_url");
            Assertions.assertFalse(uploadUrl.isEmpty());
        });
        step("Загрузка фотографии на сервер", () -> {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("photo", "./src/test/resources/P_20190812_163931.jpg",
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
        step("Подтверждение загрузки фотографии, получение id фотографии", () -> {
            getRequest("photos.saveOwnerPhoto?server=" + server + "&photo=" + photo + "&hash=" + hash + "&");
            photoId = getRequest("photos.get?album_id=profile&", "response.items[0].id");
            properties.setProperty("mainPhotoId", photoId);
        });

    }
}
