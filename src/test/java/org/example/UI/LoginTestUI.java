package org.example.UI;

import com.sun.istack.NotNull;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.*;

public class LoginTestUI {
    public static void LoginStepUI(@NotNull WebDriver driver) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String DB_URL = "jdbc:postgresql://127.0.0.1:5433/users";
        String USER = "postgres";
        String PASS = "user";
        String loginUser = "79859473378";
        String pass="Poro1Wk7";
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        String query = "Select PassHash from users \n Where login = \'" + loginUser + "\'";
        Statement stmt = connection.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        rs.next();
        Assertions.assertTrue(pass.hashCode()==rs.getInt(1));
        driver.get("https://vk.com/");
        driver.findElement(By.xpath("//*[@id='index_email']")).sendKeys(loginUser);
        driver.findElement(By.xpath("//*[@id='index_pass']")).sendKeys(pass);
        driver.findElement(By.xpath("//*[@id='index_login_button']")).click();
        driver.findElement(By.xpath("//*[@id='top_profile_link']"));
    }
}
