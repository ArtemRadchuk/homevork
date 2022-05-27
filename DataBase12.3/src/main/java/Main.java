
import dao.Dao;
import service.StudentPrinterImpl;

public class Main {

    public static void main(String[] args) {
        int courseId = 10;
        Dao dao = new Dao();
        dao.getConnection();
        new StudentPrinterImpl(dao).printStudent(courseId);
    }
}
