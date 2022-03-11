public final class Drive {
    private final String dType;
    private final int dVolume;
    private final int dWeight;

    public Drive(String dType, int dVolume, int dWeight) {
        this.dType = dType;
        this.dVolume = dVolume;
        this.dWeight = dWeight;
    }

    public String getDType() {
        return dType;
    }

    public int getDVolume() {
        return dVolume;
    }

    public int getDWeight() {
        return dWeight;
    }
}
