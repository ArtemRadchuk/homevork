public final class RAM {
    private String rType;
    private int ramVolume;
    private int ramWeight;

    public RAM(String type, int ramVolume, int ramWeight) {
        this.rType = type;
        this.ramVolume = ramVolume;
        this.ramWeight = ramWeight;
    }

    public String getRType() {
        return rType;
    }


    public int getRamVolume() {
        return ramVolume;
    }

    public int getRamWeight() {
        return ramWeight;
    }

}
