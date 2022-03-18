package practice.strings;

public class TotalEarningsCalculator {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        //TODO: напишите ваш код, результат вывести в консоль
        int start = text.indexOf("л");
        String firstMoney = text.substring(text.indexOf(" ", start), text.indexOf("р", start));
        int start2 = text.indexOf("- ", start);
        String secondMoney = text.substring(text.indexOf(" ", start2), text.indexOf("р", start2));
        int start3 = text.indexOf("- ", start2 + 1);
        String thirdMoney = text.substring(text.indexOf(" ", start3), text.indexOf("р", start3));
        int vasua = Integer.parseInt(firstMoney.trim());
        int petua = Integer.parseInt(secondMoney.trim());
        int masha = Integer.parseInt(thirdMoney.trim());
        System.out.println(vasua + petua + masha);
    }

}