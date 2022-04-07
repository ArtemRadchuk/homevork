import Interfaces.launchControl;

public class RacingCar extends Car implements launchControl {
    public RacingCar(int maximumSpeed, String model, int tankCapacity, String color) {
        super(maximumSpeed, model, tankCapacity, color);
    }

enum racingColor{
        Красный, Черный, Желтый
}
}
