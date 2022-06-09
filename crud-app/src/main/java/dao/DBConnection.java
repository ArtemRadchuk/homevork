package dao;

import java.sql.*;

public class DBConnection {
    public static Connection connection;
    public static Statement statement;

    public static void connect(String dbLink, String userName, String userPass) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(dbLink, userName, userPass);
        statement = connection.createStatement();
        System.out.println("База данных подключена!");
    }
}
