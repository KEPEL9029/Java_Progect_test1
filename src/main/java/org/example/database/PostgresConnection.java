package org.example.database;

import java.sql.Connection; //Импортирует интерфейс Connection, который используется для взаимодействия с базой данных.
import java.sql.DriverManager; //Импортирует класс DriverManager, который управляет набором драйверов для баз данных. Через этот класс осуществляется подключение к базе данных.
import java.sql.SQLException; //Импортирует исключение SQLException, которое выбрасывается при возникновении проблем с базой данных.

public class PostgresConnection {
    private String password;
    private String userName;
    private String url;
    private String driver;


    public PostgresConnection(){
        this.password = "postgres";
        this.userName = "postgres";
        this.url ="jdbc:postgresql://localhost:5432/shop?currentSchema=public";
        this.driver="org.postgresql.Driver";
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(url, userName, password);
    }

}
