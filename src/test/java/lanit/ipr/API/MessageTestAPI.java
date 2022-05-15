package lanit.ipr.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lanit.ipr.PropertiesTest;
import org.junit.jupiter.api.Assertions;

import static io.qameta.allure.Allure.step;

public class MessageTestAPI extends PropertiesTest {
    private static RequestSpecification request = RestAssured.given();
    private static Response response;
    private static int chat;
    private static int random = (int) (Integer.MAX_VALUE*Math.random());
    private static String messageId;
    private static String chatId;

    public static void MessageStepAPI(){
        step("Создание беседы с названием \"АТ беседа\", получение id беседы", ()->{
            response = request.get(properties.getProperty("baseURI")+ "messages.createChat?title=" + "АТ беседа&" + properties.getProperty("access_token")+properties.getProperty("V"));
            chatId = response.jsonPath().getString("response");
            Assertions.assertTrue(!chatId.isEmpty());
            chat = 2000000000 + Integer.parseInt(chatId);
            properties.setProperty("chatId", String.valueOf(chat));
        });
        step("Переименование беседы в \"Ну очень важная беседа\"",()->{
            request.post(properties.getProperty("baseURI")+ "messages.editChat?title=" + "Ну очень важная беседа&chat_id="+ chatId+ "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Добавление пользователя в беседу", ()->{
            response = request.get(properties.getProperty("baseURI")+ "messages.addChatUser?user_id=722323315&chat_id="+ chatId+ "&" + properties.getProperty("access_token")+properties.getProperty("V"));
            Assertions.assertTrue(response.jsonPath().getString("response").equals("1"));
        });
        step("Отправка сообщения \"Это очень важная беседа, выходить!\", получение id сообщения",()->{
            response = request.get(properties.getProperty("baseURI")+ "messages.send?random_id="+ random +"&message=" + "Это очень важная беседа, выходить!&peer_id=" + chat + "&intent=default&" + properties.getProperty("access_token")+properties.getProperty("V"));
            System.out.println(properties.getProperty("baseURI")+ "messages.send?random_id="+ random +"&message=" + "Это очень важная беседа, выходить!&peer_id=" + chat + "&intent=default&" + properties.getProperty("access_token")+properties.getProperty("V"));
            System.out.println("\n"+response.body().asString());
            messageId = response.jsonPath().getString("response");
            Assertions.assertTrue(!messageId.isEmpty());
        });
        step("Редактирование отправленного сообщения в \"Это очень важная беседа, НЕ выходить!\"", ()->{
            response = request.post(properties.getProperty("baseURI")+ "messages.edit?message_id=" + messageId+  "&chat_id="+ chatId + "&peer_id=" + chat + "&message=Это очень важная беседа, НЕ выходить!&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Закрепление отправленного сообщения", ()->{
            response = request.post(properties.getProperty("baseURI")+ "messages.pin?message_id=" + messageId+  "&chat_id="+ chatId + "&peer_id=" + chat + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Отправка нового сообщения \"А нет, лучше в группу\"", ()->{
            response = request.get(properties.getProperty("baseURI")+ "messages.send?random_id="+ (int)Math.sqrt(random) +"&message=" + "А нет, лучше в группу&chat_id="+ chatId + "&peer_id=" + chat + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
    }
}
