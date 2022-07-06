
import model.XlsxModel;
import service.Reader;
import service.Writer;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        List<XlsxModel> list = reader.reade("C:\\Users\\User\\IdeaProjects\\homework\\LoadAndCheck\\src\\main\\resources\\KTI.xlsx");
        Writer writer = new Writer();
        writer.write(list);
            /*if (m.getArticle() == null){
            }*/
    }
}
