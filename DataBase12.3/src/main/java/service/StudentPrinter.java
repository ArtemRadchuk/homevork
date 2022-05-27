package service;

import dao.Dao;

import java.sql.SQLException;


public interface StudentPrinter {

    void printStudent(int course_id) throws SQLException;

}
