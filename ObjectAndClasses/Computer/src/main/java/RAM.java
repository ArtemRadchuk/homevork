public final class RAM {
    private String rType;
    private int ramVolume;
    private double ramWeight;

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

    public double getRamWeight() {
        return ramWeight;
    }

    @Override
    public String toString() {
        return
                "rТип оперативной памяти - " + rType + '\'' +
                ", объем оперативной памяти - " + ramVolume +
                ", вес оперативной памяти - " + ramWeight ;
    }
}
