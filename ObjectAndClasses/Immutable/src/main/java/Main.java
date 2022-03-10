import javax.imageio.spi.ImageInputStreamSpi;

public class Main {

    public static void main(String[] args) {
        Cargo cargo = new Cargo(1,1,1, 1,"hello",true,"aasdasd",true);
        System.out.println(cargo.toString());
        Dimension dimension = new Dimension();
        Cargo cargo1 = dimension.clone(cargo,"asqsa",5, 3, 4 ,2);
        System.out.println(cargo1.toString());
    }
}

