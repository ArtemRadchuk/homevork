
public class Loader {

    public static void main(String[] args) throws Exception {
        long startThread = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            new Generator(i).run();
        }
        System.out.println((System.currentTimeMillis() - startThread) + " ms - время работы всех потоков");
    }
}
