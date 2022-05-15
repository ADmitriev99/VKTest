package lanit.ipr.UI;

import lanit.ipr.DriverTest;
import lanit.ipr.elements.Asserts;
import lanit.ipr.elements.buttons.Buttons;
import lanit.ipr.elements.textForms.TextForms;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static io.qameta.allure.Allure.step;

public class DiscussionTestUI extends DriverTest {
    private static By groups = By.xpath("//*[text()=\"Сообщества\"]");
    private static By createGroup = By.xpath("//*[text()=\"Создать сообщество\"]");
    private static By groupType = By.xpath("//*[text()=\"Группа по интересам\"]");
    private static By groupNameTitle = By.xpath("//*[@id=\"groups_create_box_title\"]");
    private static By groupInterestButton = By.xpath("//*[@class=\"selector_input\"]/../..//*[contains(@id, \"dropdown\")]");
    private static By groupInterest = By.xpath("//*[text()=\"Программное обеспечение\"]");
    private static By createGroupButton = By.xpath("//button[text()=\"Создать сообщество\"]");
    private static By name = By.xpath("//*[text()=\"Максим  Василенко\"]");
    private static By groupName = By.xpath("//*[text()=\"АТ группа\"]");
    private static By createDiscussion = By.xpath("//*[text()=\"Добавить обсуждение\"]");
    private static By discussionField = By.xpath("//*[@id=\"bnt_title\"]");
    private static By editDiscussionButton = By.xpath("//*[text()=\"Редактировать тему\"]");
    private static By pinDiscussionButton = By.xpath("//*[@class=\"checkbox _bet_fixed\"]");
    private static By saveButton = By.xpath("//*[text()=\"Сохранить\"]");
    private static By createComment = By.xpath("//*[@class=\"reply_field_wrap _emoji_field_wrap\"]");
    private static By textComment = By.xpath("//*[@class=\"reply_field submit_post_field\"]");
    private static By sendComment = By.xpath("//*[text()=\"Отправить\"]");
    private static By editComment = By.xpath("//*[@id=\"bp_edit4\"]");
    private static By editCommentText = By.xpath("//*[@id=\"bpe_text\"]");
    private static By deleteComment = By.xpath("//*[@id=\"bp_delete3\"]");

    public static void DiscussionStepUI() {
        step("Переход на страницу c группами",()-> {
            Buttons.clickByText("Сообщества");
            Asserts.displayedByTextLike("Создать сообщество");
        });
        step("Создание новой группы",()-> {
            Buttons.clickByTextLike("Создать сообщество");
            Buttons.clickByTextLike("Группа по интересам");
            TextForms.sendkeysById("groups_create_box_title","АТ группа");
            Buttons.clickByXPath("//*[@class=\"selector_input\"]/../..//*[contains(@id, \"dropdown\")]");
            Buttons.clickByText("Программное обеспечение");
            Buttons.clickById("groups_create_box_chat");
            Buttons.clickByText("Создать сообщество");
            try {
                Asserts.displayedByText("Максим  Василенко");
                Buttons.clickByText("Сообщества");
                Buttons.clickByText("АТ группа");
            } catch (Exception e) {
                e.printStackTrace();
            }
            Asserts.displayedByText("Добавить обсуждение");
        });
        step("Добавление нового обсуждения",()-> {
            Buttons.clickByText("Добавить обсуждение");
            TextForms.sendkeysById("bnt_title", "АТ заголовок");
            TextForms.sendkeysById("bnt_text", "АТ текст");
            Buttons.clickByTextLike("Создать тему");
            Asserts.displayedByTextLike("Редактировать тему");
        });
        step("Закреплене темы",()-> {
            Buttons.clickByTextLike("Редактировать тему");
            Buttons.clickByClass("checkbox _bet_fixed");
            Buttons.clickByText("Сохранить");
            Asserts.displayedByTextLike("Изменения сохранены");
        });
        step("Добавление 3 комментариев в обсуждение",()-> {
            TextForms.sendkeysByClass("reply_field submit_post_field", "АТ комментарий 1");
            Buttons.clickByTextLike("Отправить");
            Asserts.displayedByText("АТ комментарий 1");
            Thread.sleep(1000);
            TextForms.sendkeysByClass("reply_field submit_post_field", "АТ комментарий 2");
            Buttons.clickByTextLike("Отправить");
            Asserts.displayedByText("АТ комментарий 2");
            Thread.sleep(1000);
            TextForms.sendkeysByClass("reply_field submit_post_field", "АТ комментарий 3");
            Buttons.clickByTextLike("Отправить");
            Asserts.displayedByText("АТ комментарий 3");
        });
        step("Редактирование предпоследнего комментария",()-> {
            Buttons.clickById("bp_edit4");
            TextForms.sendkeysById("bpe_text", " edit");
            Buttons.clickByTextLike("Сохранить");
            Asserts.displayedByText("АТ комментарий 2 edit");
        });
        step("Удаление первого комментария",()-> {
            Buttons.clickById("bp_delete3");
            Asserts.displayedByTextLike("Комментарий удалён");
        });
    }
}
