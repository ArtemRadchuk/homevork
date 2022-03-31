public abstract class Car {
    int maximumSpeed;
    String model;
    int tankCapacity;
   private String color;

    public Car(int maximumSpeed, String model, int tankCapacity, String color) {
        this.maximumSpeed = maximumSpeed;
        this.model = model;
        this.tankCapacity = tankCapacity;
        this.color = color;
    }

    public void drive() {
        System.out.println("начинает ехать");
    }

    public void brake() {
        System.out.println("тормозит");
    }

    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(int maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    interface launchControl{
        default void launch(){
            System.out.println("Старт с лаунчем");
        }
    }
interface climateControl{
        default void climate(){
            System.out.println("Включен климат контроль");
        }
}
    interface plough {
        default void plowDown(){
            System.out.println("Плуг опущен");
        }
        default void plough() {
            System.out.println("Вспахиваем");
        }
        default void plowUp(){
            System.out.println("Плуг поднят");
        }

    }
}
