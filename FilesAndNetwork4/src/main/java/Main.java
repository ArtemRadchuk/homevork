import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static String SITE_URL = "http://lenta.ru";
    private static String IMAGE_DIRECTORY = "src/images";

    public static void main(String[] args) throws IOException {
        if (!Files.exists(Paths.get(IMAGE_DIRECTORY))) {
            new File(IMAGE_DIRECTORY).mkdir();
        }
        Document document = Jsoup.connect(SITE_URL).get();
        Elements allElements = document.select("img");
        for (Element element : allElements) {
            Pattern pattern = Pattern.compile("jpg");
            Matcher matcher = pattern.matcher(element.toString());
            Pattern pattern1 = Pattern.compile("jpeg");
            Matcher matcher1 = pattern1.matcher(element.toString());
            Pattern pattern2 = Pattern.compile("webp");
            Matcher matcher2 = pattern2.matcher(element.toString());
            if (matcher.find() || matcher1.find() || matcher2.find()) {
                String imageLink = element.attr("abs:src");
                downloadImage(imageLink);
            }
        }
    }

    private static void downloadImage(String imageLink) {
        String imageName = imageLink.substring(imageLink.lastIndexOf("/") + 1);
        try {
            InputStream input = new URL(imageLink).openStream();
            byte[] bytes = new byte[2048];
            OutputStream output = new FileOutputStream(IMAGE_DIRECTORY + "/" + imageName);
            int check = -1;
            while ((check = input.read(bytes)) != -1) {
                output.write(bytes, 0, check);
            }
            output.close();
            System.out.println("Картинка сохранена");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
