package practice;

public class IndividualBusinessman extends Client {

    @Override
    public void put(double amountToPut) {
        int minPut = 1000;
        if (amountToPut < minPut) {
            super.put((amountToPut / 100) * 99);
        } else if (amountToPut >= minPut) {
            super.put((amountToPut / 100) * 99.5);
        }
    }

    @Override
    public void info() {
        System.out.println("Доступные операции:" + "\n" + "1. Показать баланс. " + "\n" + "2. Пополнить баланс. " + "\n" + "3. Снять со счета (Комиссия 1% если снятие меньше 1000. Комиссия 0.5% если снятие 1000 или больше). ");

    }
}
