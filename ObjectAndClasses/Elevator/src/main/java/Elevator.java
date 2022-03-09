import java.util.Scanner;

public class Elevator {
    int currentFloor = 1;
    int minFloor;
    int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor(int currentFloor) {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int moveDown(int currentFloor) {
        this.currentFloor = currentFloor - 1;
        return currentFloor;
    }

    public int moveUp(int currentFloor) {
        this.currentFloor = currentFloor + 1;
        return currentFloor;
    }

    public int move(int floor) {
        if (floor <= maxFloor && floor >= minFloor) {
            while (currentFloor > floor) {
                moveDown(currentFloor);
                System.out.println(currentFloor + " Этаж");
            }
            while (currentFloor < floor) {
                moveUp(currentFloor);
                System.out.println(currentFloor + " Этаж");
            }
        } else {
            System.out.println("Этаж не найден");
        }
        return currentFloor;
    }

}


