public final class Keyboard {
    private final String kType;
    private final boolean light;
    private final int kWeight;

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

    public int getKWeight() {
        return kWeight;
    }
}
