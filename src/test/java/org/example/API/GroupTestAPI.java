package org.example.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GroupTestAPI {
    public static void GroupStepAPI() {
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
        response = request.get(properties.getProperty("baseURI")+ "groups.create?title=" + "АТ группа&type=group&public_subcategory=0&" + properties.getProperty("access_token")+properties.getProperty("V"));
        String groupId = response.jsonPath().getString("response.id");
        PropertiesConfiguration configuration = null;
        try {
            configuration = new PropertiesConfiguration(path);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        configuration.setProperty("groupId", groupId);
        try {
            configuration.save();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        response = request.get(properties.getProperty("baseURI")+ "board.addTopic?title=" + "АТ обсуждение&text=АТ текст&group_id=" + groupId + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        String topicId = response.jsonPath().getString("response");
        request.get(properties.getProperty("baseURI")+ "board.fixTopic?topic_id=" + topicId + "&group_id=" + groupId + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        response = request.get(properties.getProperty("baseURI")+ "board.createComment?message=АТ комментарий1&topic_id=" + topicId + "&group_id=" + groupId + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        String comment1 =response.jsonPath().getString("response");
        response = request.get(properties.getProperty("baseURI")+ "board.createComment?message=АТ комментарий2&topic_id=" + topicId + "&group_id=" + groupId + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        String comment2 =response.jsonPath().getString("response");
        request.get(properties.getProperty("baseURI")+ "board.createComment?message=АТ комментарий3&topic_id=" + topicId + "&group_id=" + groupId + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        request.get(properties.getProperty("baseURI")+ "board.editComment?message=АТ комментарий edit&topic_id=" + topicId + "&group_id=" + groupId + "&comment_id="+ comment2 + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        request.get(properties.getProperty("baseURI")+ "board.deleteComment?topic_id=" + topicId + "&group_id=" + groupId + "&comment_id="+ comment1 + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
    }
}
