package lanit.ipr.UI;

import lanit.ipr.DriverTest;
import lanit.ipr.elements.Asserts;
import lanit.ipr.elements.buttons.Buttons;
import lanit.ipr.elements.textForms.TextForms;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import static io.qameta.allure.Allure.step;

public class MessageTestUI extends DriverTest {

    private static By editChat = By.xpath("//*[@class=\"im-page--aside-photo\"]");
    private static By editChatName = By.cssSelector(".EditableLabel__text");
    private static By textArea = By.cssSelector(".Textarea");
    private static By saveText = By.cssSelector(".EditableLabel__save");
    private static By newChatName = By.xpath("//*[text()=\"Ну очень важная беседа\"]");
    private static By addUserInChat = By.xpath("//*[text()=\"Добавить участников\"]");
    private static By userId = By.xpath("//*[@data-id=\"671826444\"]");
    private static By addUsers = By.xpath("//*[text()=\"Добавить собеседника\"]");
    private static By closeButton = By.xpath("//*[@class=\"PopupHeader__closeBtn\"]");
    private static By editMessage = By.xpath("//*[@id=\"im_editable0\"]");
    private static By editMessageButton = By.xpath("//*[@class=\"im-send-btn__icon im-send-btn__icon--edit\"]");
    private static By messageText = By.xpath("//*[text()=\"Это очень важная беседа, выходить!\"]");
    private static By resendMessage =By.xpath("//*[text()=\"Переслать\"]");
    private static By newMessageText =By.xpath("//div[contains(text(),\"Это очень важная беседа\")]/..");
    private static By pinMessageButton =By.xpath("//*[@aria-label=\"Закрепить сообщение\"]");
    private static By pinMessageText =By.xpath("//*[text()=\"Закрепить сообщение\"]");
    private static By anotherMessageText =By.xpath("//*[text()=\"А нет, лучше в группу\"]");
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
            Asserts.displayedByClass("ui_clean_list im-mess-stack--mess _im_stack_messages");
            Buttons.clickByClass("ui_clean_list im-mess-stack--mess _im_stack_messages");
            Buttons.clickByAriaLabel("Закрепить сообщение");
        });
        step("Отправка в группу сообщения - \"А нет, лучше в группу\"",()-> {
            TextForms.sendkeysByIdEnter("im_editable0", "А нет, лучше в группу");
            Asserts.divDisplayedByText("А нет, лучше в группу");
        });
    }
}
