package org.example.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection; //Импортирует интерфейс Connection, который используется для взаимодействия с базой данных.
import java.sql.DriverManager; //Импортирует класс DriverManager, который управляет набором драйверов для баз данных. Через этот класс осуществляется подключение к базе данных.
import java.sql.SQLException; //Импортирует исключение SQLException, которое выбрасывается при возникновении проблем с базой данных.
import java.util.Properties;

public class PostgresConnection {
    private String password;
    private String userName;
    private String url;
    private String driver;


    public PostgresConnection() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) {
                throw new IOException("Файл database.properties не найден");
            }
            properties.load(input);
            this.url = properties.getProperty("db.url");
            this.userName = properties.getProperty("db.username");
            this.password = properties.getProperty("db.password");
            this.driver = properties.getProperty("db.driver");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(url, userName, password);
    }

}
