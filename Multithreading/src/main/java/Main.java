import service.ResizeService;

public class Main {

    public static void main(String[] args) {
        String srcFolder = "C:/Users/User/image";
        String dstFolder = "C:/Users/User/toImage";
       new ResizeService().resize(srcFolder,dstFolder);
    }
}
