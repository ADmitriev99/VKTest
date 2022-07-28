package lanit.ipr.API;

import io.restassured.response.Response;
import lanit.ipr.PropertiesSingleton;
import okhttp3.*;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.util.Properties;

import static io.qameta.allure.Allure.step;
import static lanit.ipr.actions.ResponseClass.getRequest;

public class AlbumAPI {
    private static String uploadUrl;
    private static Response response;
    private static String server;
    private static String photo;
    private static String hash;
    private static String album1;
    private static String album2;
    private static String photoId;
    private static Properties properties = PropertiesSingleton.getInstance();

    public static void AlbumStep() {
        step("Создание нового альбома, получение id альбома", () -> {
            album1 = getRequest("photos.createAlbum?privacy_view=only me&title=" + "АТ альбом 1&","response.id");
            Assertions.assertFalse(album1.isEmpty());
        });
        step("Получение адреса загрузки фотографии", () -> {
            uploadUrl = getRequest("photos.getUploadServer?album_id=" + album1 + "&", "response.upload_url");
            Assertions.assertFalse(uploadUrl.isEmpty());
        });
        step("Загрузка фотографии на сервер", () -> {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("photo", "./src/test/resources/3365__45_big.jpg.webp",
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
            photo = photo.replaceAll("\"", "%22");
        });
        step("Подтверждение загрузки фотографии, получение id фотографии", () -> {
            photoId = getRequest("photos.save?album_id=" + album1 + "&server=" + server + "&hash=" + hash + "&photos_list=" + photo + "&", "response[0].id");
            Assertions.assertFalse(photoId.isEmpty());
        });
        step("Установка фотографии в качестве обложки альбома", () -> {
            getRequest("photos.makeCover?album_id=" + album1 + "&photo_id=" + photoId + "&");
        });
        step("Создание комментария с текстом \"АТ комментарий\"", () -> {
            getRequest("photos.createComment?message=АТ комментарий" + "&photo_id=" + photoId + "&");
        });
        step("Постановка отметки на фотографии", () -> {
            getRequest("likes.add?type=photo" + "&item_id=" + photoId + "&");
        });
        step("Создание нового альбома, получение id альбома", () -> {
            album2 = getRequest("photos.createAlbum?privacy_view=all&title=" + "АТ альбом 2" + "&", "response.id");
            Assertions.assertFalse(album2.isEmpty());
            properties.setProperty("albumId", album2);
        });
        step("Перемещение фотографии во второй альбом", () -> {
            getRequest("photos.move?target_album_id=" + album2 + "&photo_id=" + photoId + "&");
        });
        step("Удаление первого альбома", () -> {
            getRequest("photos.deleteAlbum?album_id=" + album1 + "&");
        });
    }
}
