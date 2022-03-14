public class ArithmeticCalculator {
    public static int firstNum;
    public static int secondNum;

    public ArithmeticCalculator() {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    public int getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }

    public static void main(String[] args) {
        Operation operation = Operation.ADD;
        switch (operation) {
            case ADD:
            System.out.println(firstNum + secondNum);
            break;
            case SUBTRACT:
                System.out.println(firstNum - secondNum);
                break;
            case MULTIPLY:
                System.out.println((firstNum * secondNum));
                break;
        }
    }

}
