public final class Drive {
    final String dType;
    final int dVolume;
    final int dWeight;

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
