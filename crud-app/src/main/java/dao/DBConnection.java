package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnection {
    public static Connection connection;
    public static Statement statement;

    public static void connect(String dbLink ,String userName, String userPass) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(dbLink, userName, userPass);
        statement = connection.createStatement();
        System.out.println("База данных подключена!");
    }

}
