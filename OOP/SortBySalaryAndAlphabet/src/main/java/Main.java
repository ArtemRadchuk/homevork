import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        List<Employee> sortedStaff = sortBySalaryAndAlphabet(staff);
        System.out.println(staff.stream().sorted(Comparator.comparing(Employee::getName)).sorted(Comparator.comparing(Employee::getSalary)).toList());

    }

    public static List<Employee> sortBySalaryAndAlphabet(List<Employee> staff) {
        return staff.stream().sorted(Comparator.comparing(Employee::getName)).sorted(Comparator.comparing(Employee::getSalary)).toList();
    }

    public Employee sortBySalaryAndDate(List<Employee> staff, Date date) {
        return staff.stream().filter(s-> s.getWorkStart().equals(date)).toList().get(0);
    }
}



