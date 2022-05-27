package service;

import dao.Dao;
import domain.Courses;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentPrinterImpl implements StudentPrinter {
    public Connection connect;
    Statement state;
    ResultSet result;
    public Courses courses = new Courses();
    public Dao dao;

    public StudentPrinterImpl(Dao dao) {
        this.dao = dao;
    }

    public StudentPrinterImpl(Connection connect) {
        this.connect = connect;
    }

    //разделить работу класса на различные классы (дао - для взаимодействия с бд,
    // сервис - для взаимодействия уже с этими данными)

    @Override
    public void printStudent(int course_id) throws SQLException {
        try {
            state = connect.createStatement();
            courseSelectService(dao, course_id);
            studentSelectService(course_id);
        } catch (SQLException e) {
            System.err.println(e);
        }
        state.close();
        result.close();
    }

    @Override
    public void courseSelectService(Dao dao, int course_id) throws SQLException {
        dao.getCourse(course_id, courses);
        System.out.println(courses.getName());
        /*while (result.next()) {
            System.out.println("Курс - " + result.getString("name"));
        }*/
    }

    @Override
    public void studentSelectService(int course_id) throws SQLException {
        int student_count = 0;
        List<Integer> allStudentId = new ArrayList<>();
        result = state.executeQuery("select * from subscriptions where course_id = " + course_id);
        while (result.next()) {
            int st_id = result.getInt("student_id");
            student_count++;
            allStudentId.add(st_id);
        }
        System.out.println(student_count + " Студентов:");
        for (int ids : allStudentId) {
            result = state.executeQuery("select * from students where id = " + ids);
            while (result.next()) {
                System.out.println(result.getString("name"));
            }
        }
    }
}
