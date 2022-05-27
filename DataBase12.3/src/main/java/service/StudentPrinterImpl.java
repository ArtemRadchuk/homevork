package service;

import dao.Dao;
import domain.Course;



public class StudentPrinterImpl implements StudentPrinter {
    public Dao dao;

    public StudentPrinterImpl(Dao dao) {
        this.dao = dao;
    }


    @Override
    public void printStudent(int courseId) {
        Course course = dao.getCourse(courseId);
        System.out.println("Курс: " + course.getName() + ", количество студентов:  " + course.getStudent_count() + " человек.");
    }
}
