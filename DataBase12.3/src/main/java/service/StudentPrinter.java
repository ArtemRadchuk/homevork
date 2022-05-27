package service;

import dao.Dao;

import java.sql.SQLException;


public interface StudentPrinter {

    void printStudent(int course_id) throws SQLException;

    void courseSelectService(Dao dao, int course_id) throws SQLException;

    void studentSelectService(int course_id) throws SQLException;
}
