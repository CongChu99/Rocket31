package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    public static Connection getConnection() throws SQLException, IOException {
        try (FileInputStream fis = new FileInputStream("src/main/resources/database.properties")) {
            Properties properties = new Properties();
            properties.load(fis);
            String url = properties.getProperty("url");
            return DriverManager.getConnection(url);
        }
    }

    public static void checkConnection() {
        try (Connection connection = getConnection()) {
            System.out.println("Kết nối thành công: " + connection.getCatalog());
        } catch (SQLException | IOException e) {
            System.out.println("Kết nối thất bại: " + e.getMessage());
        }
    }
}
