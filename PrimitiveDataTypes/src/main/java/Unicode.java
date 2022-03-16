public class Unicode {
    char a = 'А';
    int b = a;

    public void findUnicode() {
        for (; a <= 'я'; a++) {
            if (a == 'Ж') {
                char e1 = 'Ё';
                int ee1 = e1;
                System.out.println(e1 + " - " + ee1);
            }
            if (a == 'ж') {
                char e2 = 'ё';
                int ee2 = e2;
                System.out.println(e2 + " - " + ee2);
            }
            System.out.println(a + " - " + b);
        }
    }
}
