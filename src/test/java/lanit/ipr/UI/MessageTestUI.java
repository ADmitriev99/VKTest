package lanit.ipr.UI;

import lanit.ipr.actions.Asserts;
import lanit.ipr.actions.buttons.Buttons;
import lanit.ipr.actions.textForms.TextForms;


import static io.qameta.allure.Allure.step;

public class MessageTestUI {

    public static void messageStepUI() {
        getMessagePage();
        createChat();
        renameChat();
        addUserInChat();
        sendMessage("Это очень важная беседа, выходить!");
        editMessage();
        pinMessage();
        sendMessage("А нет, лучше в группу");
    }

    protected static void pinMessage() {
        step("Закрепление сообщения", () -> {
            Asserts.displayedByTextLike("(ред.)");
            Asserts.displayedByClass("im-mess--text wall_module _im_log_body");
            Buttons.clickByClass("im-mess--text wall_module _im_log_body");
            Asserts.displayedByAriaLabel("Закрепить сообщение");
            Buttons.clickByAriaLabel("Закрепить сообщение");
        });
    }

    protected static void editMessage() {
        step("Редактирование сообщения - \"Это очень важная беседа, НЕ выходить!\"", () -> {
            Buttons.mouseOnClass("im-mess--actions");
            Buttons.clickByAriaLabel("Редактировать");
            TextForms.editMessage("im_editable0", "Это очень важная беседа, НЕ выходить!");
            TextForms.sendkeysByIdEnter("im_editable0", "");
        });
    }

    protected static void sendMessage(String message) {
        step("Отправка в группу сообщения - \"" + message + "\"", () -> {
            TextForms.sendkeysByIdEnter("im_editable0", message);
            Asserts.divDisplayedByText(message);
        });
    }

    protected static void addUserInChat() {
        step("Добавление участника", () -> {
            Buttons.clickByText("Добавить участников");
            Buttons.clickByText("Алексей Непомнящий");
            Buttons.clickByText("Добавить собеседника");
            Buttons.clickByClass("PopupHeader__closeBtn");
            Asserts.displayedByText("Напишите сообщение...");
        });
    }

    protected static void renameChat() {
        step("Переименование беседы в \"Ну очень важная беседа\"", () -> {
            Buttons.clickByClass("im-page--aside-photo");
            Asserts.displayedByTextLike("Все участники");
            Buttons.clickByText("АТ беседа");
            TextForms.sendkeysByTextEnter("АТ беседа", "Ну очень важная беседа");
        });
    }

    protected static void createChat() {
        step("Создание новой беседы", () -> {
            Buttons.clickByAriaLabel("Новая беседа");
            TextForms.sendkeysById("im_dialogs_creation_name", "АТ беседа");
            Buttons.clickByText("Создать беседу");
            Asserts.displayedByText("Напишите сообщение...");
        });
    }

    protected static void getMessagePage() {
        step("Переход на страницу c сообщениями", () -> {
            Buttons.clickByText("Мессенджер");
            Asserts.displayedByText("Все чаты");
        });
    }
}
