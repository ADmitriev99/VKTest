package lanit.ipr.UI;

import lanit.ipr.PropertiesSingleton;
import lanit.ipr.actions.Asserts;
import lanit.ipr.actions.buttons.Buttons;
import lanit.ipr.actions.textForms.TextForms;
import org.junit.jupiter.api.Assertions;

import java.sql.*;
import java.util.Properties;

import static io.qameta.allure.Allure.step;

public class LoginTestUI {

    private static Properties properties = PropertiesSingleton.getInstance();
    private static String loginUser;
    private static String password;

    public static void loginStepUI() {
        setLoginPassword();
        connectToDatabase();
        loginOnVK();
    }

    protected static void loginOnVK() {
        step("Логин на сайт \"VK.com\"", () -> {
            Buttons.login();
            TextForms.sendkeysByName("login", loginUser);
            Buttons.clickByText("Продолжить");
            TextForms.sendkeysByName("password", password);
            Buttons.clickByText("Продолжить");
            Asserts.displayedById("top_profile_link");
        });
    }

    protected static void connectToDatabase() {
        step("Подключение к базе данных, получение пароля в хэшированном виде", () -> {
            String DB_URL = "jdbc:postgresql://127.0.0.1:5433/users";
            String USER = "postgres";
            String PASS = "user";
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "Select PassHash from users \n Where login = \'" + loginUser + "\'";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            Assertions.assertEquals(password.hashCode(), rs.getInt(1));
        });
    }

    protected static void setLoginPassword() {
        loginUser = properties.getProperty("login");
        password = properties.getProperty("password");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
