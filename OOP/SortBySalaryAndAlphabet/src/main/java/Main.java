import java.util.*;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        List<Employee> sortedStaff = sortBySalaryAndAlphabet(staff);
        System.out.println(sortedStaff);
        Date date = new Date();
        date.setYear(117); //2017 год
        System.out.println(findEmployeeWithHighestSalary(staff, date));
    }

    public static List<Employee> sortBySalaryAndAlphabet(List<Employee> staff) {
        return staff.stream().sorted(Comparator.comparing(Employee::getName)).sorted(Comparator.comparing(Employee::getSalary)).toList();
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, Date date) {
        return staff.stream().filter(Employee -> Employee.getWorkStart().getYear() == date.getYear()).sorted(Comparator.comparing(Employee::getSalary).reversed()).toList().get(0);
    }
}



