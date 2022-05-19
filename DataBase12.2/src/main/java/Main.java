import java.sql.*;

public class Main {
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "rootroot";
    private static final String URL = "jdbc:mysql://localhost:3306/courses?useSSL=false";
    private static Connection connect;
    private static ResultSet result;
    private static Statement state;
    private static final String REQUEST = "select (select name from courses where id = course_id), count(*) /  (select courses.duration from courses where id = course_id) from courses.subscriptions  group by course_id ;";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
        state = connect.createStatement();
        result = state.executeQuery(REQUEST);

        while (result.next()) {
            String name = result.getString("(select name from courses where id = course_id)");
            String duration = result.getString("count(*) /  (select courses.duration from courses where id = course_id)");
            System.out.println("Курс - " + name + ". Среднее количество покупок в месяц: " + duration);
        }
    }
}
