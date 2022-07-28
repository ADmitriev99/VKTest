package lanit.ipr.UI;

import lanit.ipr.actions.Asserts;
import lanit.ipr.actions.buttons.Buttons;
import lanit.ipr.actions.textForms.TextForms;


import static io.qameta.allure.Allure.step;

public class MessageTestUI {

    public static void MessageStepUI() {
        step("Переход на страницу c сообщениями",()-> {
            Buttons.clickByText("Мессенджер");
            Asserts.displayedByText("Все чаты");
        });
        step("Создание новой беседы",()-> {
            Buttons.clickByAriaLabel("Новая беседа");
            TextForms.sendkeysById("im_dialogs_creation_name", "АТ беседа");
            Buttons.clickByText("Создать беседу");
            Asserts.displayedByText("Напишите сообщение...");
        });
        step("Переименование беседы в \"Ну очень важная беседа\"",()-> {
            Buttons.clickByClass("im-page--aside-photo");
            Asserts.displayedByTextLike("Все участники");
            Buttons.clickByText("АТ беседа");
            TextForms.sendkeysByTextEnter("АТ беседа","Ну очень важная беседа");
        });
        step("Добавление участника",()-> {
            Buttons.clickByText("Добавить участников");
            Buttons.clickByText("Алексей Непомнящий");
            Buttons.clickByText("Добавить собеседника");
            Buttons.clickByClass("PopupHeader__closeBtn");
            Asserts.displayedByText("Напишите сообщение...");
        });
        step("Отправка в группу сообщения - \"Это очень важная беседа, выходить!\"",()-> {
            TextForms.sendkeysByIdEnter("im_editable0", "Это очень важная беседа, выходить!");
            Asserts.divDisplayedByText("Это очень важная беседа, выходить!");
        });
        step("Редактирование сообщения - \"Это очень важная беседа, НЕ выходить!\"",()-> {
            Buttons.mouseOnClass("im-mess--actions");
            Buttons.clickByAriaLabel("Редактировать");
            TextForms.editMessage("im_editable0", "Это очень важная беседа, НЕ выходить!");
            TextForms.sendkeysByIdEnter("im_editable0", "");
        });
        step("Закрепление сообщения",()-> {
            Asserts.displayedByTextLike("(ред.)");
            Asserts.displayedByClass("im-mess--text wall_module _im_log_body");
            Buttons.clickByClass("im-mess--text wall_module _im_log_body");
            Asserts.displayedByAriaLabel("Закрепить сообщение");
            Buttons.clickByAriaLabel("Закрепить сообщение");
        });
        step("Отправка в группу сообщения - \"А нет, лучше в группу\"",()-> {
            TextForms.sendkeysByIdEnter("im_editable0", "А нет, лучше в группу");
            Asserts.divDisplayedByText("А нет, лучше в группу");
        });
    }
}
