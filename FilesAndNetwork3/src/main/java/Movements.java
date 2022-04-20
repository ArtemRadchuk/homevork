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
        List<Double> income = new ArrayList<>();
        List<Double> expense = null;
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
        for (String m : a) {
            String out = m.substring(4);
            out = out.replaceAll("\"", "");
            String[] st = out.split(",");
            String money;
            if (!st[0].equals("0")) {
                if (st.length == 3) {
                    money = st[1] + "," + st[2];
                    System.out.println(money + "method1");
                } else if (st.length == 4) {
                    money = st[1] + "," + st[2] + "," + st[3];
                    System.out.println(money + "method2");
                }
            } else if (st[0].equals("0")) {
                money = st[2] + "," + st[3];
                System.out.println(money + "method3");
            }
        }
    }

    public double getExpenseSum() {
        return expenseSum;
    }

    public double getIncomeSum() {
        return incomeSum;
    }
}
