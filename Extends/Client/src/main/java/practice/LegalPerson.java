package practice;

public class LegalPerson extends Client {

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake * 1.01);
    }

    @Override
    public void info() {
        System.out.println("Доступные операции:" + "\n" + "1. Показать баланс. " + "\n" + "2. Пополнить баланс. " + "\n" + "3. Снять со счета (Комиссия 1%). ");

    }
}
