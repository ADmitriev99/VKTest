package lanit.ipr.API;

import io.restassured.response.Response;
import lanit.ipr.PropertiesSingleton;
import org.junit.jupiter.api.Assertions;

import java.util.Properties;

import static io.qameta.allure.Allure.step;
import static lanit.ipr.actions.ResponseClass.getRequest;

public class GroupAPI {
    private static Response response;
    private static String groupId;
    private static String topicId;
    private static String comment1;
    private static String comment2;
    private static Properties properties = PropertiesSingleton.getInstance();

    public static void GroupStepAPI() {
        step("Создание группы \"АТ группа\", получение id группы", () -> {
            groupId = getRequest("groups.create?title=" + "АТ группа&type=group&public_subcategory=0&", "response.id");
            Assertions.assertFalse(groupId.isEmpty());
            properties.setProperty("groupId", groupId);
        });
        step("Создание нового обсуждения, получение id обсуждения", () -> {
            topicId = getRequest("board.addTopic?title=" + "АТ обсуждение&text=АТ текст&group_id=" + groupId + "&", "response");
            Assertions.assertFalse(topicId.isEmpty());
        });
        step("Закрепление созданного обсуждения", () -> {
            getRequest("board.fixTopic?topic_id=" + topicId + "&group_id=" + groupId + "&");
        });
        step("Создание комментария с текстом \"АТ комментарий1\"", () -> {
            comment1 = getRequest("board.createComment?message=АТ комментарий1&topic_id=" + topicId + "&group_id=" + groupId + "&", "response");
            Assertions.assertFalse(comment1.isEmpty());
        });
        step("Создание комментария с текстом \"АТ комментарий2\"", () -> {
            comment2 = getRequest("board.createComment?message=АТ комментарий2&topic_id=" + topicId + "&group_id=" + groupId + "&", "response");
            Assertions.assertFalse(comment2.isEmpty());
        });
        step("Создание комментария с текстом \"АТ комментарий3\"", () -> {
            getRequest("board.createComment?message=АТ комментарий3&topic_id=" + topicId + "&group_id=" + groupId + "&");
        });
        step("Редактирование второго комментария", () -> {
            getRequest("board.editComment?message=АТ комментарий edit&topic_id=" + topicId + "&group_id=" + groupId + "&comment_id=" + comment2 + "&");
        });
        step("Удаление первого комментария", () -> {
            getRequest("board.deleteComment?topic_id=" + topicId + "&group_id=" + groupId + "&comment_id=" + comment1 + "&");
        });
    }
}
