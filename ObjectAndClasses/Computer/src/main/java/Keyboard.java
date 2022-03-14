public final class Keyboard {
    private final String kType;
    private final boolean light;
    private final double kWeight;

    public Keyboard(String kType, boolean light, int kWeight) {
        this.kType = kType;
        this.light = light;
        this.kWeight = kWeight;
    }

    public String getKType() {
        return kType;
    }

    public boolean isLight() {
        return light;
    }

    public double getKWeight() {
        return kWeight;
    }

    @Override
    public String toString() {
        return
                "Тип клавиатура - '" + kType +
                ", подсветка - " + light +
                ", вес клавиатура - " + kWeight
                ;
    }
}
