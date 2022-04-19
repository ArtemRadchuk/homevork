import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Movements {

    public Movements(String pathMovementsCsv) {
        List<String> readCsv = null;
        List<Double> income = new ArrayList<>();
        List<Double> expense = null;
        double incomeSum = 0;
        double expenseSum = 0;
        try {
            Path path = Paths.get(pathMovementsCsv);
            readCsv = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : readCsv) {
            String string = s;
            String[] str = string.split("   ");
            str[0] = " ";

            for (int i = 0; i < str.length; i++) {
                if (str[i].trim().equals("")) {
                    continue;
                }
                if (str[i].indexOf("/") > -1){
                    String a =  str[i+3].substring(str[i+3].lastIndexOf(" "),str[i+3].length());
                   // System.out.println(a + "------");
                    income.add(Double.parseDouble(a));
                }
               /* if (str[i].indexOf("\\") > -1){
                    String a =  str[i+3].substring(str[i+3].lastIndexOf(" "),str[i].length());
                    System.out.println(a+ "------");
                 //   expense.add(Double.parseDouble(a));
                }
            System.out.println(i + " " + str[i].trim());
            }*/
        }
        for (double a: income) {
            System.out.println(a + "........");
            incomeSum = incomeSum+ a;
        }

        /*for (double a: expense) {
            expenseSum = expenseSum+ a;
        }
        System.out.println(incomeSum + " " + expenseSum);
    }*/}
        System.out.println(incomeSum+"--11--");}

    public double getExpenseSum() {
        double expenseSum;
        return 0.0;
    }

    public double getIncomeSum() {
        double incomeSum = 0;
        return incomeSum;
    }
}
