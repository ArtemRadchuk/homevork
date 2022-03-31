public class RacingCar extends Car implements Car.launchControl {
    public RacingCar(int maximumSpeed, String model, int tankCapacity, String color) {
        super(maximumSpeed, model, tankCapacity, color);
    }

    @Override
    public void drive() {
        super.drive();
    }

    @Override
    public void brake() {
        super.brake();
    }
enum racingColor{
        Красный, Черный, Желтый
}
}
