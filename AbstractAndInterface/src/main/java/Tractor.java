import javax.sound.midi.Soundbank;

public class Tractor extends Car implements Car.plough {

    public Tractor(int maximumSpeed, String model, int tankCapacity, String color) {
        super(maximumSpeed, model, tankCapacity, color);
    }

    @Override
    public void drive() {
        System.out.println("Трактор начинает ехать");
    }

    @Override
    public void brake() {
        System.out.println("Трактор тормозит");
    }

    enum tractorColor {
        зеленый, красный, синий
    }
}
