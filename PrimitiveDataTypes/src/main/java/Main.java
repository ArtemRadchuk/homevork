public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.
        for (char a = 'А'; a <= 'я'; a++) {
            int b = a;
            if (a == 'Ж'){
                char e1 = 'Ё';
                int ee1 = e1;
                System.out.println(e1 + " - " + ee1);
            }
            if (a == 'ж'){
                char e2 = 'ё';
                int ee2 = e2;
                System.out.println(e2 + " - " + ee2);
            }
            System.out.println(a + " - " + b);
        }

    }
}