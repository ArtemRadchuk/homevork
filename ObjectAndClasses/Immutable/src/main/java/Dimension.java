
public final class Dimension {
    int width;
    int height;
    int length;
    String address;
    int mass;

    public void findVolume() {
        int size = width * height * length;
    }

    public Cargo clone(Cargo cargo, String address, int mass,int width, int height, int length) {
     return new Cargo(
                mass,
                width,
                height,
                length,
                address,
                true,
                "aasdasd",
                true);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress() {
        this.address = address;
    }

    public int getMass() {
        return mass;
    }

    public void setMass() {
        this.mass = mass;
    }
}