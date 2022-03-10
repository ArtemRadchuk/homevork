public final class Keyboard {
    final String kType;
    final boolean light;
    final int kWeight;

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
