
import domain.Courses;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import java.sql.*;

public class Main {
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "rootroot";
    private static final String URL = "jdbc:mysql://localhost:3306/courses?useSSL=false";
    private static Connection connect;


    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Courses courses = session.get(Courses.class, 1);
        System.out.println(courses.getName());
        /*Session session;
        Dao dao = new Dao();
        dao.getConnection(URL, USER_NAME, USER_PASSWORD);
        dao.getStatement();
        StudentPrinterImpl studentPrinter = new StudentPrinterImpl(dao.connection);
        studentPrinter.courseSelectService(dao,18);
        dao.statement.close();*/
        /*new StudentPrinterImpl(connect).printStudent(18);
        connect.close();*/
    }
}
