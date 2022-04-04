import java.util.Comparator;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        staff = sortBySalaryAndAlphabet(staff);
        System.out.println(staff);

    }


    public static List<Employee> sortBySalaryAndAlphabet(List<Employee> staff) {
        staff.stream().sorted(Comparator.comparing(Employee::getName)).sorted(Comparator.comparing(Employee::getSalary)).toList();
        return staff;
    }
}



