public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }

    public static void task2(){
        System.out.println("task 2");
        int vasyaAge = 20;
        int katyaAge = 20;
        int mishaAge = 30;
        int minimalage = -1;
        int middleage = -1;
        int maxage = -1;

        //Ищем кто старше
        if (vasyaAge > katyaAge & vasyaAge > mishaAge) {
            maxage = vasyaAge;
        } else if (katyaAge > vasyaAge & katyaAge > mishaAge) {
            maxage = katyaAge;
        } else if (mishaAge > katyaAge & mishaAge > vasyaAge) {
            maxage = mishaAge;
        }


        //Ищем кто младше
        if (vasyaAge < katyaAge & vasyaAge < mishaAge) {
            minimalage = vasyaAge;
        } else if (katyaAge < vasyaAge & katyaAge < mishaAge) {
            minimalage = katyaAge;
        } else if (mishaAge < katyaAge & mishaAge < vasyaAge) {
            minimalage = mishaAge;
        }

        //Ищем среднего
        if (katyaAge < mishaAge & katyaAge > vasyaAge) {
            middleage = katyaAge;
        } else if (mishaAge < katyaAge & mishaAge > vasyaAge) {
            middleage = mishaAge;
        } else if (vasyaAge < mishaAge & vasyaAge > katyaAge) {
            middleage = vasyaAge;
        }

        System.out.println("Младшему");
        System.out.println(minimalage);
        System.out.println("Среднему");
        System.out.println(middleage);
        System.out.println("Старшему");
        System.out.println(maxage);
        System.out.println("end 2 task");
    }

    public static void task1(){
        System.out.println("Первое задание");
        int milkAmount = 200; // ml
        int powderAmount = 5; // g
        int eggsCount = 3; // items
        int sugarAmount = 5; // g
        int oilAmount = 30; // ml
        int appleCount = 8;

        if (powderAmount >= 400 && sugarAmount >= 10 && milkAmount >= 1000 && oilAmount >= 30 ) {
            System.out.println("Pancakes");
        }
        if (milkAmount >= 300 & powderAmount >= 5 & eggsCount >= 5){
            System.out.println("Omelette");
        }
        if (appleCount >= 3 & milkAmount >= 100 & powderAmount >= 300 & eggsCount >= 4){
            System.out.println("Apple pie");
        }
        System.out.println("окончание задания");
    }
}
