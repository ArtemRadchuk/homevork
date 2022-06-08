package main;

import dao.DBConnection;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
@SpringBootApplication
public class SpringApplication {

        private static String dbName = "jdbc:mysql://localhost:3306/book_list";
        private static String dbUser = "root";
        private static String dbPass = "rootroot";

        public static void main(String[] args) throws SQLException, ClassNotFoundException {
            DBConnection.connect(dbName,dbUser,dbPass);
            org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
        }
}
