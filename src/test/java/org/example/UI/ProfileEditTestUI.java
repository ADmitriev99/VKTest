package org.example.UI;

import com.sun.istack.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ProfileEditTestUI {
    public static void ProfileEditStepUI(@NotNull WebDriver driver) {
        driver.findElement(By.xpath("//*[text()=\"Моя страница\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"page_avatar\"]")).click();
        driver.findElement(By.cssSelector(".OwnerAvatarEditor__formInput")).sendKeys("C:\\Users\\shdmi\\Downloads\\Telegram Desktop\\P_20190812_163931.jpg");
        driver.findElement(By.xpath("//*[text()=\"Сохранить и продолжить\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Сохранить изменения\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Опубликовать запись\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Продолжить\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"profile_edit_act\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pedit_status\"]/..")).click();
        driver.findElement(By.xpath("//*[text()=\"Не женат\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Сохранить\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Новые данные будут отражены на вашей странице.\"]"));
        driver.findElement(By.xpath("//*[@id=\"ui_rmenu_contacts\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pedit_country\"]/..")).click();
        driver.findElement(By.xpath("//*[text()=\"Россия\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pedit_city\"]/..")).click();
        driver.findElement(By.xpath("//*[text()=\"Москва\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Сохранить\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Новые данные будут отражены на вашей странице.\"]"));
        driver.findElement(By.xpath("//*[@id='ui_rmenu_interests']")).click();
        driver.findElement(By.xpath("//*[@id='pedit_interests_activities']")).sendKeys("АТ деятельность");
        driver.findElement(By.xpath("//*[@id='pedit_interests_interests']")).sendKeys("АТ интересы");
        driver.findElement(By.xpath("//*[@id='pedit_interests_music']")).sendKeys("АТ музыка");
        driver.findElement(By.xpath("//*[@id='pedit_interests_movies']")).sendKeys("АТ фильмы");
        driver.findElement(By.xpath("//*[@id='pedit_interests_tv']")).sendKeys("АТ телешоу");
        driver.findElement(By.xpath("//*[@id='pedit_interests_books']")).sendKeys("АТ книги");
        driver.findElement(By.xpath("//*[@id='pedit_interests_games']")).sendKeys("АТ игры");
        driver.findElement(By.xpath("//*[@id='pedit_interests_quotes']")).sendKeys("АТ цитаты");
        driver.findElement(By.xpath("//*[@id='pedit_interests_about']")).sendKeys("АТ о себе");
        driver.findElement(By.xpath("//*[text()=\"Сохранить\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Новые данные будут отражены на вашей странице.\"]"));
        driver.findElement(By.xpath("//*[@id='ui_rmenu_education']")).click();
        driver.findElement(By.xpath("//*[@id=\"s_school-1\"]/..")).click();
        driver.findElement(By.xpath("//*[text()=\"Школа № 198\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"s_start-1\"]/..")).click();
        driver.findElement(By.xpath("//*[text()=\"2005\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"s_finish-1\"]/../input[@class=\"selector_input\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"first active\"]/..//*[text()=\"2016\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"s_graduation-1\"]/../input[@class=\"selector_input\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"first active\"]/..//*[text()=\"2016\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"s_class-1\"]/..")).click();
        driver.findElement(By.xpath("//*[text()=\"а\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Сохранить\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Новые данные будут отражены на вашей странице.\"]"));
        driver.findElement(By.xpath("//*[@href=\"/edit?act=higher_education\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"u_university0\"]/../input[@class=\"selector_input\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"МГУ\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"u_faculty0\"]/../input[@class=\"selector_input\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Физический факультет\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"u_chair0\"]/../input[@class=\"selector_input\"]")).click();
        driver.findElement(By.xpath("//*[text()=\" Кафедра математики\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"u_edu_form0\"]/../input[@type=\"text\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Очная\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"u_edu_status0\"]/../input[@type=\"text\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Студент (магистр)\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"u_graduation0\"]/../input[@class=\"selector_input\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"first active\"]/..//*[text()=\"2022\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Сохранить\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Новые данные будут отражены на вашей странице.\"]"));
        try {
            if (driver.findElement(By.xpath("//*[text()=\"Продолжить\"]")).isDisplayed()) {
                driver.findElement(By.xpath("//*[text()=\"Продолжить\"]")).click();
            }
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        driver.findElement(By.xpath("//*[@id=\"ui_rmenu_military\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"unit-1\"]/../input[@class=\"selector_input\"]")).sendKeys("Не служил");
        driver.findElement(By.xpath("//*[text()=\"Год начала службы:\"]"));
        driver.findElement(By.xpath("//*[text()=\"Сохранить\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Сохранить\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Новые данные будут отражены на вашей странице.\"]"));
        driver.findElement(By.xpath("//*[@id=\"ui_rmenu_career\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"group-1\"]/../input[@class=\"selector_input\"]")).sendKeys("ЛАНИТ");
        driver.findElement(By.xpath("//*[@id=\"start-1\"]/../input[@class=\"selector_input\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"2021\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"position-1\"]/../input[@type=\"text\"]")).sendKeys("АТ инженер", Keys.ENTER);
        driver.findElement(By.xpath("//*[text()=\"Сохранить\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Новые данные будут отражены на вашей странице.\"]"));
        driver.findElement(By.xpath("//*[@id=\"ui_rmenu_personal\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pedit_political\"]/../input[@type=\"text\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Либеральные\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pedit_religion\"]/../input[@type=\"text\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Светский гуманизм\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pedit_life\"]/../input[@type=\"text\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Карьера и деньги\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pedit_people\"]/../input[@type=\"text\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Доброта и честность\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pedit_smoking\"]/../input[@type=\"text\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Негативное\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pedit_alcohol\"]/../input[@type=\"text\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"selector_container dropdown_container big limited_height selector_focused\"]//*[text()=\"Компромиссное\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pedit_inspired_by\"]")).sendKeys("АТ вдохновление");
        driver.findElement(By.xpath("//*[text()=\"Сохранить\"]")).click();
        driver.findElement(By.xpath("//*[text()=\"Новые данные будут отражены на вашей странице.\"]"));
    }
}
