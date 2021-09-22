package org.example.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.jupiter.api.Assertions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.qameta.allure.Allure.step;

public class MessageTestAPI {
    private static RequestSpecification request = RestAssured.given();
    private static Response response;
    private static int chat;
    private static int random = (int) ((int) Integer.MAX_VALUE*Math.random());
    private static String messageId;
    private static String chatId;

    public static void MessageStepAPI(){
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
        step("Создание беседы с названием \"АТ беседа\", получение id беседы", ()->{
            response = request.get(properties.getProperty("baseURI")+ "messages.createChat?title=" + "АТ беседа&" + properties.getProperty("access_token")+properties.getProperty("V"));
            chatId = response.jsonPath().getString("response");
            Assertions.assertTrue(!chatId.isEmpty());
            chat = 2000000000 + Integer.parseInt(chatId);
            PropertiesConfiguration configuration = null;
            try {
                configuration = new PropertiesConfiguration(path);
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
            configuration.setProperty("chatId", chat);
            try {
                configuration.save();
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
        });
        step("Переименование беседы в \"Ну очень важная беседа\"",()->{
            request.post(properties.getProperty("baseURI")+ "messages.editChat?title=" + "Ну очень важная беседа&chat_id="+ chatId+ "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Добавление пользователя в беседу", ()->{
            request.post(properties.getProperty("baseURI")+ "messages.addChatUser?user_id=" + "671826444&chat_id="+ chatId+ "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Отправка сообщения \"Это очень важная беседа, выходить!\"",()->{
            response = request.get(properties.getProperty("baseURI")+ "messages.send?random_id="+ random +"&message=" + "Это очень важная беседа, выходить!&chat_id="+ chatId + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
            System.out.println(properties.getProperty("baseURI")+ "messages.send?random_id="+ random +"&message=" + "Это очень важная беседа, выходить!&chat_id="+ chatId + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
            System.out.println(response.body().asString());
            messageId = response.jsonPath().getString("response");
            Assertions.assertTrue(!messageId.isEmpty());
        });
        step("Редактирование сообщения в \"Это очень важная беседа, НЕ выходить!\"", ()->{
            request.post(properties.getProperty("baseURI")+ "messages.edit?message_id=" + messageId+  "&peer_id=" + chat + "&message=Это очень важная беседа, НЕ выходить!" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Закрепление сообщения", ()->{
            request.post(properties.getProperty("baseURI")+ "messages.pin?message_id=" + messageId+  "&peer_id=" + chat + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Отправка сообщения \"А нет, лучше в группу\"", ()->{
            request.get(properties.getProperty("baseURI")+ "messages.send?random_id="+ random +"&message=" + "А нет, лучше в группу&chat_id="+ chatId + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
    }
}
