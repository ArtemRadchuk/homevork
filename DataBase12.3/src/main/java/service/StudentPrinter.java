package service;

import java.sql.SQLException;


public interface StudentPrinter {

    void printStudent(int course_id) throws SQLException;

    void courseSelectService(int course_id) throws SQLException;

    void studentSelectService(int course_id) throws SQLException;
}
