package main;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    private static Connection connection;

    private DBUtil() throws IOException, SQLException {
       connection = createConnection();
    }
    public static Connection createConnection() throws IOException, SQLException {
        Properties properties = new Properties();
        if (connection == null) {
            Reader reader = new FileReader("C:\\Users\\valer\\OneDrive\\Рабочий стол\\Java\\homeworks\\manyToMany\\src\\main\\resources\\db.properties");
            properties.load(reader);
        }

        return DriverManager.getConnection(
                properties.getProperty("db.url"),
                properties.getProperty("db.user"),
                properties.getProperty("db.password")
        );
    }

}
