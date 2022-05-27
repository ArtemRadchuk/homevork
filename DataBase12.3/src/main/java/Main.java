import dao.Dao;
import service.StudentPrinterImpl;

import java.sql.*;

public class Main {
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "rootroot";
    private static final String URL = "jdbc:mysql://localhost:3306/courses?useSSL=false";
    private static Connection connect;


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Dao dao = new Dao();
        dao.getConnection(URL, USER_NAME, USER_PASSWORD);
        dao.getStatement();
        StudentPrinterImpl studentPrinter = new StudentPrinterImpl(dao.connection);
        studentPrinter.courseSelectService(dao,18);
        dao.statement.close();
        /*new StudentPrinterImpl(connect).printStudent(18);
        connect.close();*/
    }
}
