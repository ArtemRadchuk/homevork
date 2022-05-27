package service;

import dao.Dao;
import java.sql.*;


public class StudentPrinterImpl implements StudentPrinter {
    public Dao dao;

    public StudentPrinterImpl(Dao dao) {
        this.dao = dao;
    }


    @Override
    public void printStudent(int courseId) {
        dao.getCourseName(courseId);
        dao.getStudent(courseId);

        for (String student: Dao.studentList) {
            System.out.println(student);
        }
    }
}
