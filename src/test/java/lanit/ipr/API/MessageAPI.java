package lanit.ipr.API;

import lanit.ipr.PropertiesSingleton;
import org.junit.jupiter.api.Assertions;

import java.util.Properties;

import static io.qameta.allure.Allure.step;
import static lanit.ipr.actions.ResponseClass.getRequest;
import static lanit.ipr.actions.ResponseClass.postRequest;

public class MessageAPI {
    private static int chat;
    private static String messageId;
    private static String chatId;
    private static Properties properties = PropertiesSingleton.getInstance();

    public static int getRandom() {
        return (int) (Integer.MAX_VALUE * Math.random());
    }

    public static void messageStepAPI() {
        createChat();
        renameChat();
        addUserInChat();
        sendMessage("Это очень важная беседа, выходить!");
        editSentMessage();
        pinMessage();
        sendMessage("А нет, лучше в группу");
    }

    protected static void pinMessage() {
        step("Закрепление отправленного сообщения", () -> {
            postRequest("messages.pin?message_id=" + messageId + "&chat_id=" + chatId + "&peer_id=" + chat + "&");
        });
    }

    protected static void editSentMessage() {
        step("Редактирование отправленного сообщения в \"Это очень важная беседа, НЕ выходить!\"", () -> {
            postRequest("messages.edit?message_id=" + messageId + "&chat_id=" + chatId + "&peer_id=" + chat + "&message=Это очень важная беседа, НЕ выходить!&");
        });
    }

    protected static void sendMessage(String message) {
        step("Отправка сообщения \"" + message + "\", получение id сообщения", () -> {
            messageId = postRequest("messages.send?random_id=" + getRandom() + "&message=" + message + "&peer_id=" + chat + "&intent=default&", "response");
            Assertions.assertFalse(messageId.isEmpty());
        });
    }

    protected static void addUserInChat() {
        step("Добавление пользователя в беседу", () -> {
            Assertions.assertEquals("1", getRequest("messages.addChatUser?user_id=722323315&chat_id=" + chatId + "&", "response"));
        });
    }

    protected static void renameChat() {
        step("Переименование беседы в \"Ну очень важная беседа\"", () -> {
            postRequest("messages.editChat?title=" + "Ну очень важная беседа&chat_id=" + chatId + "&");
        });
    }

    protected static void createChat() {
        step("Создание беседы с названием \"АТ беседа\", получение id беседы", () -> {
            chatId = getRequest("messages.createChat?title=" + "АТ беседа&", "response");
            Assertions.assertFalse(chatId.isEmpty());
            chat = 2000000000 + Integer.parseInt(chatId);
            properties.setProperty("chatId", String.valueOf(chat));
        });
    }
}
