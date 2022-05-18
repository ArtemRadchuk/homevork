import java.sql.*;

public class Main {
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "rootroot";
    private static final String URL = "jdbc:mysql://localhost:3306/courses?useSSL=false";
    private static Connection connect;


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
        new ViewResult(connect).getStudent(18);
        connect.close();
    }
}
