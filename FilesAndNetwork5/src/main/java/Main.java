import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    private static String METRO_URL = "https://skillbox-java.github.io/";
    private static String METRO_DIRECTORY = "src/map.json";

    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect(METRO_URL).maxBodySize(0).get();
        readMetro(document);
    }


    private static void readMetro(Document doc) {
        Elements allMetro = doc.select("span.name");
        Elements allMetroNum = doc.select("span.num");
        Elements lines = doc.select("#metrodata > div > div.js-toggle-depend.s-depend-control-single");
        String[] metroLineNames = new String[40];
        String[] metroNames = new String[400];
        int[] metroNumber = new int[400];
        int index = 0;
        for (Element line : lines) {
            String[] split = line.toString().split(">");
            metroLineNames[index] = split[2].substring(0, split[2].indexOf("<"));
            index++;
        }
        index = 0;
        for (Element metro : allMetro) {
            metroNames[index] = metro.toString().substring(metro.toString().indexOf(">") + 1, metro.toString().lastIndexOf("<"));
            index++;
        }
        index = 0;
        for (Element num : allMetroNum) {
            metroNumber[index] = Integer.parseInt(num.toString().substring(num.toString().indexOf(">") + 1, num.toString().indexOf(".")));
            index++;
        }
        int lineIndex = 0;
        for (index = 0; index < metroNames.length; index++) {
            if (metroNumber[index] == 1) {
                System.out.println(metroLineNames[lineIndex]);
                lineIndex++;
            }
            if (metroNames[index] != null) {
                System.out.println(metroNumber[index] + " - " + metroNames[index]);
            } else {
                break;
            }
        }
    }
}
