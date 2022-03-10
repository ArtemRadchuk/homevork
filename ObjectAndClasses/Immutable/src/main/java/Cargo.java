public final class Cargo {
    private final int mass;
    private final int width;
    private final int height;
    private final int length;
    private final String address;
    private final boolean flip;
    private final String regNum;
    private final boolean brittle;

    public Cargo(int mass, int width, int height, int length, String address, boolean flip, String regNum, boolean brittle) {
        this.mass = mass;
        this.width = width;
        this.height = height;
        this.length = length;
        this.address = address;
        this.flip = flip;
        this.regNum = regNum;
        this.brittle = brittle;
    }

    public int getMass() {
        return mass;
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

    public boolean isFlip() {
        return flip;
    }

    public String getRegNum() {
        return regNum;
    }

    public boolean isBrittle() {
        return brittle;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "mass=" + mass +
                ", width=" + width +
                ", height=" + height +
                ", length=" + length +
                ", address='" + address + '\'' +
                ", flip=" + flip +
                ", regNum='" + regNum + '\'' +
                ", brittle=" + brittle +
                '}';
    }
}
