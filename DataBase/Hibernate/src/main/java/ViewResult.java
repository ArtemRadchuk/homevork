import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewResult {
    public Connection connect;
    Statement state;
    ResultSet result;

    public ViewResult(Connection connect) {
        this.connect = connect;
    }

    //разделить работу класса на различные классы (дао - для взаимодействия с бд,
    // сервис - для взаимодействия уже с этими данными)
    public void getStudent(int course_id) throws SQLException {
        int student_count = 0;
        List<Integer> allStudentId = new ArrayList<>();
        try {
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
            for (int ids : allStudentId) {
                result = state.executeQuery("select * from students where id = " + ids);
                while (result.next()) {
                    String name = result.getString("name");
                    System.out.println(name);
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        state.close();
        result.close();
    }


}
