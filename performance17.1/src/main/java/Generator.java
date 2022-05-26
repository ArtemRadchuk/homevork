import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Generator extends Thread {
    public FileOutputStream writer;
    public StringBuilder builder;
    public int regionCode;

    public Generator(int regionCode) throws FileNotFoundException{
        writer = new FileOutputStream("res/numbers" + regionCode + "Reg.txt");
        builder = new StringBuilder();
        this.regionCode = regionCode;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        for (int number = 1; number < 1000; number++) {
            for (char firstLetter : letters) {
                for (char secondLetter : letters) {
                    for (char thirdLetter : letters) {
                        builder.append(firstLetter);
                        builder.append(padNumber(number, 3));
                        builder.append(secondLetter);
                        builder.append(thirdLetter);
                        builder.append(padNumber(regionCode, 2));
                        builder.append("\n");
                    }
                }
            }
        }

        try {
            writer.write(builder.toString().getBytes());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static StringBuilder padNumber(int number, int numberLength) {
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();
        StringBuilder numberBuilder = new StringBuilder();
        for (int i = 0; i < padSize; i++) {
            numberBuilder.append("0");
        }
        numberBuilder.append(numberStr);
        return numberBuilder;
    }
}
