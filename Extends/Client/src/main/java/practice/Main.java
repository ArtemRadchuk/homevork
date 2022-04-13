package practice;

public class Main {
    public static void main(String[] args) {
        PhysicalPerson alex = new PhysicalPerson();
        alex.info();
        alex.put(500);
        alex.getAmount();
        alex.take(300);
        alex.getAmount();
        LegalPerson sberBank = new LegalPerson();
        sberBank.info();
        sberBank.put(120000);
        sberBank.getAmount();
        sberBank.take(65000);
        sberBank.getAmount();
        IndividualBusinessman andrew = new IndividualBusinessman();
        andrew.info();
        andrew.put(69000);
        andrew.take(17000);
        andrew.getAmount();
    }
}
