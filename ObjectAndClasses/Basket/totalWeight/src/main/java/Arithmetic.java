
public class Arithmetic {
   static int numA ;
   static int numB ;

    public Arithmetic(int numA, int numB) {
        this.numA = numA;
        this.numB = numB;
    }

    public static void main(String[] args) {
        Arithmetic a = new Arithmetic(2, 4);
        System.out.println("Сумма = "+ (numB + numA));
        System.out.println("Произведение = " + numA * numB);
        if(numA > numB) {
            System.out.println(numA + " Больше");
            System.out.println(numB + " Меньше");
        } else{
            System.out.println(numA +" Меньше");
            System.out.println(numB +" Больше");
        }
    }
}


