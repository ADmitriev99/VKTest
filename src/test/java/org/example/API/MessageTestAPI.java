package org.example.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MessageTestAPI {
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
        RequestSpecification request = RestAssured.given();
        Response response = request.get(properties.getProperty("baseURI")+ "messages.createChat?title=" + "АТ беседа&" + properties.getProperty("access_token")+properties.getProperty("V"));
        PropertiesConfiguration configuration = null;
        try {
            configuration = new PropertiesConfiguration(path);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        configuration.setProperty("chatId", response.jsonPath().getString("response"));
        try {
            configuration.save();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        int chat = Integer.parseInt(response.jsonPath().getString("response"));
        int random = (int) ((int) Integer.MAX_VALUE*Math.random());
        request.post(properties.getProperty("baseURI")+ "messages.editChat?title=" + "Ну очень важная беседа&chat_id="+ chat+ "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        request.post(properties.getProperty("baseURI")+ "messages.addChatUser?user_id=" + "671826444&chat_id="+ chat+ "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        response = request.get(properties.getProperty("baseURI")+ "messages.send?random_id="+ random +"&message=" + "Это очень важная беседа, выходить!&chat_id="+ chat + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        String messageId = response.jsonPath().getString("response.message_id");
        request.post(properties.getProperty("baseURI")+ "messages.edit?message_id=" + messageId+  "&peer_id=" + (2000000000+chat) + "&message=Это очень важная беседа, НЕ выходить!" + properties.getProperty("access_token")+properties.getProperty("V"));
        request.post(properties.getProperty("baseURI")+ "messages.pin?message_id=" + messageId+  "&peer_id=" + (2000000000+chat) + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        request.get(properties.getProperty("baseURI")+ "messages.send?random_id="+ random +"&message=" + "А нет, лучше в группу&chat_id="+ chat + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
    }
}
