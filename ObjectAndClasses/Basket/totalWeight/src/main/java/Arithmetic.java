import java.util.Scanner;

public class Arithmetic {
    public int firstNum, secondNum, total;

public Arithmetic(int firstNum, int secondNum){
    this.firstNum = firstNum;
    this.secondNum = secondNum;
    System.out.println("Введите 1 число");
    firstNum = new Scanner(System.in).nextInt();
    System.out.println("Введите 2 число");
    secondNum = new Scanner(System.in).nextInt();
}

    public void unm(){
        total = firstNum * secondNum;
        System.out.println(total);
    }

    public void sum(){
        total = firstNum + secondNum;
        System.out.println(total);
    }

    public void max(){
        if(firstNum > secondNum){
            System.out.println(firstNum + " Больше");
        }
        else if (firstNum < secondNum){
            System.out.println(secondNum + " Больше");
        }  else
        System.out.println("Числа одинаковые");
    }

    public void min(){
        if(firstNum > secondNum){
            System.out.println(firstNum + " Меньше");
        }
        else if (firstNum < secondNum){
            System.out.println(secondNum + " Меньше");
        }  else
            System.out.println("Числа одинаковые");
    }

    public static void main(String[] args) {

}
}
