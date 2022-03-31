public class Sedan extends Car implements Car.climateControl{
    public Sedan(int maximumSpeed, String model, int tankCapacity, String color) {
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
    enum sedanColor{
        белый, черный, серый
    }
}
