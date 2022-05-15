package lanit.ipr.UI;

import lanit.ipr.PropertiesTest;
import lanit.ipr.elements.Asserts;
import lanit.ipr.elements.buttons.Buttons;
import lanit.ipr.elements.textForms.TextForms;
import org.junit.jupiter.api.Assertions;

import java.sql.*;

import static io.qameta.allure.Allure.step;

public class LoginTestUI extends PropertiesTest {

    public static void LoginStepUI(){
        String loginUser = properties.getProperty("login");
        String password = properties.getProperty("password");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        step("Подключение к базе данных, получение пароля в хэшированном виде",()-> {
            String DB_URL = "jdbc:postgresql://127.0.0.1:5433/users";
            String USER = "postgres";
            String PASS = "user";
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "Select PassHash from users \n Where login = \'" + loginUser + "\'";
            Statement stmt = connection.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            rs.next();
            Assertions.assertTrue(password.hashCode()==rs.getInt(1));
        });
        step("Логин на сайт \"VK.com\"",()-> {
            Buttons.login();
            TextForms.sendkeysByName("login", loginUser);
            Buttons.clickByText("Продолжить");
            TextForms.sendkeysByName("password", password);
            Buttons.clickByText("Продолжить");
            Asserts.displayedById("top_profile_link");
        });

    }
}
