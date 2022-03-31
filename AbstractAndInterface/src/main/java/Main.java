public class Main {
    public static void main(String[] args) {
        Tractor t1 = new Tractor(50,"Белорус",40,"Белый");
        System.out.println("Трактор - " + t1.getModel() + ", цвет - " +t1.getColor());
        t1.plowDown();
        t1.plough();
        RacingCar f1 = new RacingCar(356,"ferrari",35,"Красный");
        f1.launch();
        Sedan s1 = new Sedan(180,"Hendai", 30, "Серый");
        s1.drive();
        s1.climate();
    }

}
