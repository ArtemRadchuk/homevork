import org.json.simple.parser.ParseException;
import reader.JsonReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Main {
    public static final String URL = "URL";

    public static void main(String[] args) throws IOException, ParseException {
        URL website = new URL(URL);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/src/main/resources/json/json.json");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        JsonReader reader = new JsonReader();
        reader.readeJson(System.getProperty("user.dir") + "/src/main/resources/json/jsonformatter.json");
    }
}
