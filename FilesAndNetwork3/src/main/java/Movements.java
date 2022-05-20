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
        List<String> moneyList = new ArrayList<>();
        try {
            Path path = Paths.get(pathMovementsCsv);
            readCsv = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String string : readCsv) {
            string.replaceAll(" ", "");
            String[] stringArray = string.trim().split("MCC");
            stringArray[0] = "";

            for (int i = 0; i < stringArray.length; i++) {
                if (!stringArray[i].equals("")) {
                    moneyList.add(stringArray[i]);
                }
            }
        }
        String money = null;
        for (String string : moneyList) {
            String out = string.substring(4);
            out = out.replaceAll("\"", "");
            String[] stingArray = out.split(",");
            if (!stingArray[0].equals("0")) {
                if (stingArray.length == 3) {
                    money = stingArray[1] + "," + stingArray[2];
                } else if (stingArray.length == 4) {
                    money = stingArray[1] + "," + stingArray[2] + "," + stingArray[3];
                }
            } else if (stingArray[0].equals("0")) {
                money = stingArray[2] + "," + stingArray[3];
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
