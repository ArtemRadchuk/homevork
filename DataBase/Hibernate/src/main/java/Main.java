import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "rootroot";
    private static final String URL = "jdbc:mysql://localhost:3306/courses?useSSL=false";
    private static Connection connect;
    private static Statement state;
    private static ResultSet result;

    public static void main(String[] args) throws SQLException {
        List<Integer> allStudentId = new ArrayList<>();
        int course_id = 12; // ID курса
        int student_count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
            state = connect.createStatement();
            result = state.executeQuery("select * from courses where id = " + course_id);
            while (result.next()) {
                String name = result.getString("name");
                System.out.println("Курс - " + name);
            }
            result = state.executeQuery("select * from subscriptions where course_id = " + course_id);
            while (result.next()) {
                int st_id = result.getInt("student_id");
                student_count++;
                allStudentId.add(st_id);
            }
            System.out.println(student_count + " Студентов:");
            List<String> names = new ArrayList<>();
            for (int ids : allStudentId) {
                result = state.executeQuery("select * from students where id = " + ids);
                while (result.next()) {
                    String name = result.getString("name");
                    System.out.println(name);
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connect.close();
        state.close();
        result.close();

    }
}
