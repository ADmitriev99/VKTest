package lanit.ipr.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lanit.ipr.PropertiesTest;
import okhttp3.*;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import static io.qameta.allure.Allure.step;

public class MessageTestAPI extends PropertiesTest {
    private static RequestSpecification request = RestAssured.given();
    private static Response response;
    private static int chat;
    private static String messageId;
    private static String chatId;

    public static int getRandom(){
        return (int) (Integer.MAX_VALUE*Math.random());
    }

    public static void MessageStepAPI(){
        step("Создание беседы с названием \"АТ беседа\", получение id беседы", ()->{
            response = request.get(properties.getProperty("baseURI")+ "messages.createChat?title=" + "АТ беседа&" + properties.getProperty("access_token")+properties.getProperty("V"));
            chatId = response.jsonPath().getString("response");
            Assertions.assertFalse(chatId.isEmpty());
            chat = 2000000000 + Integer.parseInt(chatId);
            properties.setProperty("chatId", String.valueOf(chat));
        });
        step("Переименование беседы в \"Ну очень важная беседа\"",()->{
            request.post(properties.getProperty("baseURI")+ "messages.editChat?title=" + "Ну очень важная беседа&chat_id="+ chatId+ "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Добавление пользователя в беседу", ()->{
            response = request.get(properties.getProperty("baseURI")+ "messages.addChatUser?user_id=722323315&chat_id="+ chatId+ "&" + properties.getProperty("access_token")+properties.getProperty("V"));
            Assertions.assertEquals("1", response.jsonPath().getString("response"));
        });
        step("Отправка сообщения \"Это очень важная беседа, выходить!\", получение id сообщения",()->{
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request2 = new Request.Builder()
                    .url(properties.getProperty("baseURI")+ "messages.send?random_id="+ getRandom() +"&message=" + "Это очень важная беседа, выходить!&peer_id=" + chat + "&intent=default&" + properties.getProperty("access_token")+properties.getProperty("V"))
                    .addHeader("Cookie", "remixlang=0")
                    .build();
            okhttp3.Response response2 = client.newCall(request2).execute();
            JSONObject jsonObject = new JSONObject(response2.body().string());
            messageId = jsonObject.get("response").toString();
            Assertions.assertFalse(messageId.isEmpty());
        });
        step("Редактирование отправленного сообщения в \"Это очень важная беседа, НЕ выходить!\"", ()->{
            response = request.post(properties.getProperty("baseURI")+ "messages.edit?message_id=" + messageId+  "&chat_id="+ chatId + "&peer_id=" + chat + "&message=Это очень важная беседа, НЕ выходить!&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Закрепление отправленного сообщения", ()->{
            response = request.post(properties.getProperty("baseURI")+ "messages.pin?message_id=" + messageId+  "&chat_id="+ chatId + "&peer_id=" + chat + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Отправка нового сообщения \"А нет, лучше в группу\"", ()->{
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request2 = new Request.Builder()
                    .url(properties.getProperty("baseURI")+ "messages.send?random_id="+ getRandom() +"&message=" + "А нет, лучше в группу&peer_id=" + chat + "&intent=default&" + properties.getProperty("access_token")+properties.getProperty("V"))
                    .addHeader("Cookie", "remixlang=0")
                    .build();
            client.newCall(request2).execute();
        });
    }
}
