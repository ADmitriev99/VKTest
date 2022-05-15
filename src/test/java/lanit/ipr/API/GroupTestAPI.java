package lanit.ipr.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lanit.ipr.PropertiesTest;
import org.junit.jupiter.api.Assertions;

import static io.qameta.allure.Allure.step;

public class GroupTestAPI extends PropertiesTest {
    private static RequestSpecification request = RestAssured.given();
    private static Response response;
    private static String groupId;
    private static String topicId;
    private static String comment1;
    private static String comment2;

    public static void GroupStepAPI() {
        step("Создание группы \"АТ группа\", получение id группы", ()->{
            response = request.get(properties.getProperty("baseURI")+ "groups.create?title=" + "АТ группа&type=group&public_subcategory=0&" + properties.getProperty("access_token")+properties.getProperty("V"));
            groupId = response.jsonPath().getString("response.id");
            Assertions.assertTrue(!groupId.isEmpty());
            properties.setProperty("groupId", groupId);
        });
        step("Создание нового обсуждения, получение id обсуждения", ()->{
            response = request.get(properties.getProperty("baseURI")+ "board.addTopic?title=" + "АТ обсуждение&text=АТ текст&group_id=" + groupId + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
            topicId = response.jsonPath().getString("response");
            Assertions.assertTrue(!topicId.isEmpty());
        });
        step("Закрепление созданного обсуждения", ()->{
            request.get(properties.getProperty("baseURI")+ "board.fixTopic?topic_id=" + topicId + "&group_id=" + groupId + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Создание комментария с текстом \"АТ комментарий1\"", ()->{
            response = request.get(properties.getProperty("baseURI")+ "board.createComment?message=АТ комментарий1&topic_id=" + topicId + "&group_id=" + groupId + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
            comment1 =response.jsonPath().getString("response");
            Assertions.assertTrue(!comment1.isEmpty());
        });
        step("Создание комментария с текстом \"АТ комментарий2\"", ()->{
            response = request.get(properties.getProperty("baseURI")+ "board.createComment?message=АТ комментарий2&topic_id=" + topicId + "&group_id=" + groupId + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
            comment2 =response.jsonPath().getString("response");
            Assertions.assertTrue(!comment2.isEmpty());
        });
        step("Создание комментария с текстом \"АТ комментарий3\"", ()->{
            request.get(properties.getProperty("baseURI")+ "board.createComment?message=АТ комментарий3&topic_id=" + topicId + "&group_id=" + groupId + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Редактирование второго комментария", ()->{
            request.get(properties.getProperty("baseURI")+ "board.editComment?message=АТ комментарий edit&topic_id=" + topicId + "&group_id=" + groupId + "&comment_id="+ comment2 + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
        step("Удаление первого комментария", ()->{
            request.get(properties.getProperty("baseURI")+ "board.deleteComment?topic_id=" + topicId + "&group_id=" + groupId + "&comment_id="+ comment1 + "&" + properties.getProperty("access_token")+properties.getProperty("V"));
        });
    }
}
