package Interfaces;

public interface climateControl {

    default void climate() {
        System.out.println("Включен климат контроль");
    }
}
