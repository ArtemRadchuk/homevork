import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class Main {
    private static String METRO_URL = "https://skillbox-java.github.io/";
    private static String METRO_DIRECTORY = "src/map.json";
    private static File file = new File(METRO_DIRECTORY);

    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect(METRO_URL).maxBodySize(0).get();
        readAndWriteMetro(document);
    }


    private static void readAndWriteMetro(Document doc) throws FileNotFoundException {
        PrintWriter out = new PrintWriter("map.json");
        Elements allMetro = doc.select("span.name");
        Elements allMetroNum = doc.select("span.num");
        Elements lines = doc.select("#metrodata > div > div.js-toggle-depend.s-depend-control-single");
        String[] metroLineNames = new String[40];
        String[] metroNames = new String[400];
        int[] metroNumber = new int[400];
        int index = 0;
        for (Element line : lines) {//Линии метро
            String[] split = line.toString().split(">");
            metroLineNames[index] = split[2].substring(0, split[2].indexOf("<"));
            index++;
        }
        index = 0;
        for (Element metro : allMetro) {//Станции метро
            metroNames[index] = metro.toString().substring(metro.toString().indexOf(">") + 1, metro.toString().lastIndexOf("<"));
            index++;
        }
        index = 0;
        out.println("{");
        String start = "\t\"stations\"" + " : " + "{";
        out.println(start);
        for (Element num : allMetroNum) { //Нумерация метро
            metroNumber[index] = Integer.parseInt(num.toString().substring(num.toString().indexOf(">") + 1, num.toString().indexOf(".")));
            index++;
        }
        int lineIndex = 0;
        for (index = 0; index < metroNames.length; index++) { //Запись в файл метро
            if (metroNumber[index] == 1) {
                int numberLine = lineIndex + 1;
                if (numberLine > 1) {
                    out.println("\t\t],");
                }
                out.println("\t\t\"" + numberLine + "\" : [");
                lineIndex++;
            }
            if (metroNames[index] != null) { //\"" + metroNumber[index] + "\"" + " - " + "\"
                if (metroNumber[index + 1] != 1 && metroNumber[index + 1] != 0) {
                    out.println("\t\t\t\"" + metroNames[index] + "\"" + ",");
                } else {
                    out.println("\t\t\t\"" + metroNames[index] + "\"");
                }
            } else {
                break;
            }
        }
        String startLines = "\t\"lines\"" + " : " + "[";
        int numberOfLine = 1;
        out.println("\t\t\t]");
        out.println("\t\t},");
        out.println(startLines);
        for (index = 0; index < metroLineNames.length; index++) { //Запись линий
            if (metroLineNames[index] != null) {
                out.println("\t{");
                if (numberOfLine < 16) {
                    out.println("\t\t\"number\" : " + numberOfLine + ",");
                } else {
                    switch (numberOfLine) {
                        case 16:
                            out.println("\t\t\"number\" : " + "\"D1\"" + ",");
                            break;
                        case 17:
                            out.println("\t\t\"number\" : " + "\"D2\"" + ",");
                            break;
                    }
                }
                out.println("\t\t\"name\" : " + "\"" + metroLineNames[index] + "\"");
                if (metroLineNames[index+1] != null) {
                    out.println("\t\t},");
                }else{
                    out.println("\t\t}");
                }
                numberOfLine++;
            }
        }
        out.println("\t]");
        out.println("}");
        out.close();
    }
}
