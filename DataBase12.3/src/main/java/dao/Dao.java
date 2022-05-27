package dao;

import domain.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class Dao {
    public static List<String> studentList = new ArrayList<>();
    Session session;
    Course courses;

    public void getConnection() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        session = sessionFactory.openSession();
    }

    public void getCourseName(int course_id) {
        courses = session.get(Course.class, course_id);
        System.out.println("Курс - " + courses.getName());
    }

    public void getStudent(int course_id) {
        NativeQuery studentIdList = (session.createSQLQuery("select student_id from subscriptions where course_id = " +
                course_id));
        String[] allStudentId = studentIdList.getResultList().toString().replaceAll("]", "")
                .replaceAll("\\[", "").split(", ");
        for (int i = 0; i < allStudentId.length; i++) {
            NativeQuery students = session.createSQLQuery("select name from students where id = " +
                    allStudentId[i]);
            String result = students.getResultList().toString();
            studentList.add(result);
        }
    }
}
