import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Movements {
    public double incomeSum = 0;
    public double expenseSum = 0;

    public Movements(String pathMovementsCsv) {
        List<String> readCsv = null;
        List<String> a = new ArrayList<>();
        try {
            Path path = Paths.get(pathMovementsCsv);
            readCsv = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : readCsv) {
            s.replaceAll(" ", "");
            String[] str = s.trim().split("MCC");
            str[0] = "";

            for (int i = 0; i < str.length; i++) {
                if (!str[i].equals("")) {
                    a.add(str[i]);
                }
            }
        }
        String money = null;
        for (String m : a) {
            String out = m.substring(4);
            out = out.replaceAll("\"", "");
            String[] st = out.split(",");
            if (!st[0].equals("0")) {
                if (st.length == 3) {
                    money = st[1] + "," + st[2];
                } else if (st.length == 4) {
                    money = st[1] + "," + st[2] + "," + st[3];
                }
            } else if (st[0].equals("0")) {
                money = st[2] + "," + st[3];
            }
            String [] splittedString =  money.split(",");
            if (splittedString.length == 3) {
                if (splittedString[0].equals("0")) {
                    expenseSum = expenseSum + Double.parseDouble(splittedString[1] + "." + splittedString[2]);
                } else {
                    incomeSum = incomeSum + Double.parseDouble(splittedString[0] + "." + splittedString[1]);
                }
            }else if (splittedString.length == 2){
                if (splittedString[0].equals("0")) {
                    expenseSum = expenseSum + Double.parseDouble(  splittedString[1]);
                } else {
                    incomeSum = incomeSum + Double.parseDouble(splittedString[0]);
                }
            }
        }
    }

    public double getExpenseSum() {
        System.out.println("Сумма расходов: " + expenseSum + " руб.");
        return expenseSum;
    }

    public double getIncomeSum() {
        System.out.println("Сумма доходов: " + incomeSum + " руб.");
        return incomeSum;
    }
}
