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

public class AlbumTestAPI {
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
        RequestSpecification request = RestAssured.given();
        Response response;
        response = request.get(properties.getProperty("baseURI")+ "photos.createAlbum?privacy_view=only me&title=" + "АТ альбом 1&" + properties.getProperty("access_token")+properties.getProperty("V"));
        String album1 = response.jsonPath().getString("response.id");
        response = request.get(properties.getProperty("baseURI")+ "photos.getUploadServer?album_id=" + album1 + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        String upload_url = response.jsonPath().getString("response.upload_url");
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("photo","/C:/Users/shdmi/Downloads/Telegram Desktop/3365__45_big.jpg.webp",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File("/C:/Users/shdmi/Downloads/Telegram Desktop/3365__45_big.jpg.webp")))
                .build();
        Request request2 = new Request.Builder()
                .url(upload_url)
                .method("POST", body)
                .addHeader("Cookie", "remixlang=0")
                .build();
        okhttp3.Response response2 = client.newCall(request2).execute();
        JSONObject jsonObject = new JSONObject(response2.body().string());
        String server = jsonObject.get("server").toString();
        String photo = (String) jsonObject.get("photos_list");
        String hash = (String) jsonObject.get("hash");
        photo = photo.replace("}", "%7D");
        photo = photo.replace("{", "%7B");
        photo = photo.replaceAll("\"","%22");
        request = RestAssured.given().urlEncodingEnabled(false);
        response = request.get(properties.getProperty("baseURI")+ "photos.save?album_id=" + album1 + "&server=" +server + "&hash="+hash +"&photos_list="+ photo +"&" + properties.getProperty("access_token")+properties.getProperty("V"));
        photo = response.jsonPath().getString("response[0].id");
        request = RestAssured.given().urlEncodingEnabled(true);
        request.get(properties.getProperty("baseURI")+ "photos.makeCover?album_id=" + album1 + "&photo_id=" +photo +"&" + properties.getProperty("access_token")+properties.getProperty("V"));
        request.get(properties.getProperty("baseURI")+ "photos.createComment?message=АТ комментарий"  + "&photo_id=" +photo +"&" + properties.getProperty("access_token")+properties.getProperty("V"));
        request.get(properties.getProperty("baseURI")+ "likes.add?type=photo"  + "&item_id=" +photo +"&" + properties.getProperty("access_token")+properties.getProperty("V"));
        response = request.get(properties.getProperty("baseURI")+ "photos.createAlbum?privacy_view=all&title=" + "АТ альбом 2&" + properties.getProperty("access_token")+properties.getProperty("V"));
        String album2 = response.jsonPath().getString("response.id");
        request.get(properties.getProperty("baseURI")+ "photos.move?target_album_id=" + album2 + "&photo_id=" +photo +"&" + properties.getProperty("access_token")+properties.getProperty("V"));
        request.get(properties.getProperty("baseURI")+ "photos.deleteAlbum?album_id=" + album1 + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        request.get(properties.getProperty("baseURI")+ "photos.deleteAlbum?album_id=" + album2 + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
    }
}
