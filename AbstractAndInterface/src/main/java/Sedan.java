import Interfaces.climateControl;

public class Sedan extends Car implements climateControl {
    public Sedan(int maximumSpeed, String model, int tankCapacity, String color) {
        super(maximumSpeed, model, tankCapacity, color);
    }

    enum sedanColor{
        белый, черный, серый
    }
}
