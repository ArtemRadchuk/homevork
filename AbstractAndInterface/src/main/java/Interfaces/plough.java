package Interfaces;

public interface plough {

    default void plowDown() {
        System.out.println("Плуг опущен");
    }

    default void plough() {
        System.out.println("Вспахиваем");
    }

    default void plowUp() {
        System.out.println("Плуг поднят");
    }
}
