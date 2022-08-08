package lanit.ipr.UI;

import lanit.ipr.actions.Asserts;
import lanit.ipr.actions.buttons.Buttons;
import lanit.ipr.actions.textForms.TextForms;

import static io.qameta.allure.Allure.step;

public class GroupTestUI {

    public static void groupStepUI() {
        getGroupPage();
        createGroup();
        createTopic();
        pinTopic();
        createThreeComments();
        editSecondComment();
        deleteFirstComment();
    }

    protected static void deleteFirstComment() {
        step("Удаление первого комментария", () -> {
            Buttons.clickById("bp_delete3");
            Asserts.displayedByTextLike("Комментарий удалён");
        });
    }

    protected static void editSecondComment() {
        step("Редактирование предпоследнего комментария", () -> {
            Buttons.clickById("bp_edit4");
            TextForms.sendkeysById("bpe_text", " edit");
            Buttons.clickByTextLike("Сохранить");
            Asserts.displayedByText("АТ комментарий 2 edit");
        });
    }

    protected static void createThreeComments() {
        step("Добавление 3 комментариев в обсуждение", () -> {
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
    }

    protected static void pinTopic() {
        step("Закрепление темы", () -> {
            Buttons.clickByTextLike("Редактировать тему");
            Buttons.clickByClass("checkbox _bet_fixed");
            Buttons.clickByText("Сохранить");
            Asserts.displayedByTextLike("Изменения сохранены");
        });
    }

    protected static void createTopic() {
        step("Добавление нового обсуждения", () -> {
            Buttons.clickByText("Добавить обсуждение");
            TextForms.sendkeysById("bnt_title", "АТ заголовок");
            TextForms.sendkeysById("bnt_text", "АТ текст");
            Buttons.clickByTextLike("Создать тему");
            Asserts.displayedByTextLike("Редактировать тему");
        });
    }

    protected static void createGroup() {
        step("Создание новой группы", () -> {
            Buttons.clickByTextLike("Создать сообщество");
            Buttons.clickByTextLike("Группа по интересам");
            TextForms.sendkeysById("groups_create_box_title", "АТ группа");
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
    }

    protected static void getGroupPage() {
        step("Переход на страницу c группами", () -> {
            Buttons.clickByText("Сообщества");
            Asserts.displayedByTextLike("Создать сообщество");
        });
    }
}
