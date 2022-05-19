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

public class AlbumTestAPI extends PropertiesTest {
    private static String uploadUrl;
    private static Response response;
    private static String server;
    private static String photo;
    private static String hash;
    private static RequestSpecification request = RestAssured.given();
    private static String album1;
    private static String album2;
    private static String photoId;

    public static void AlbumStep() {
        step("Создание нового альбома, получение id альбома",()->{
            response = request.get(properties.getProperty("baseURI")+ "photos.createAlbum?privacy_view=only me&title=" + "АТ альбом 1&" + properties.getProperty("access_token")+properties.getProperty("V"));
            album1 = response.jsonPath().getString("response.id");
            Assertions.assertFalse(album1.isEmpty());
        });
        step("Получение адреса загрузки фотографии",()->{
            response = request.get(properties.getProperty("baseURI")+ "photos.getUploadServer?album_id=" + album1 + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
            uploadUrl = response.jsonPath().getString("response.upload_url");
            Assertions.assertFalse(uploadUrl.isEmpty());
        });
        step("Загрузка фотографии на сервер",()->{
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
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
            Assertions.assertFalse(server.isEmpty());
            Assertions.assertFalse(photo.isEmpty());
            Assertions.assertFalse(hash.isEmpty());
            photo = photo.replace("}", "%7D");
            photo = photo.replace("{", "%7B");
            photo = photo.replaceAll("\"","%22");
        });
        step("Подтверждение загрузки фотографии, получение id фотографии",()->{
            request = RestAssured.given().urlEncodingEnabled(false);
            response = request.get(properties.getProperty("baseURI")+ "photos.save?album_id=" + album1 + "&server=" +server + "&hash="+hash +"&photos_list="+ photo +"&" + properties.getProperty("access_token")+properties.getProperty("V"));
            photoId = response.jsonPath().getString("response[0].id");
            Assertions.assertFalse(photoId.isEmpty());
        });
        step("Установка фотографии в качестве обложки альбома",()->{
            request = RestAssured.given().urlEncodingEnabled(true);
            request.get(properties.getProperty("baseURI")+ "photos.makeCover?album_id=" + album1 + "&photo_id=" +photoId +"&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Создание комментария с текстом \"АТ комментарий\"",()->{
            request.get(properties.getProperty("baseURI")+ "photos.createComment?message=АТ комментарий"  + "&photo_id=" +photoId +"&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Постановка отметки на фотографии",()->{
            request.get(properties.getProperty("baseURI")+ "likes.add?type=photo" + "&item_id=" +photoId +"&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Создание нового альбома, получение id альбома",()->{
            response = request.get(properties.getProperty("baseURI")+ "photos.createAlbum?privacy_view=all&title=" + "АТ альбом 2&" + properties.getProperty("access_token")+properties.getProperty("V"));
            album2 = response.jsonPath().getString("response.id");
            Assertions.assertFalse(album2.isEmpty());
            properties.setProperty("albumId", album2);
        });
        step("Перемещение фотографии во второй альбом",()->{
            request.get(properties.getProperty("baseURI")+ "photos.move?target_album_id=" + album2 + "&photo_id=" +photoId +"&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Удаление первого альбома",()->{
            request.get(properties.getProperty("baseURI")+ "photos.deleteAlbum?album_id=" + album1 + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
    }
}
