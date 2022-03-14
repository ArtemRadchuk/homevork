public final class Monitor {
    private final double diagonal;
    private final String mType;
    private final double mWeight;

    public Monitor(int diagonal, String mType, int mWeight) {
        this.diagonal = diagonal;
        this.mType = mType;
        this.mWeight = mWeight;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public String getMType() {
        return mType;
    }

    public double getMWeight() {
        return mWeight;
    }

    @Override
    public String toString() {
        return
                "Диагональ монитора - " + diagonal +
                ", тип монитора - " + mType + '\'' +
                ", вес монитора - " + mWeight ;
    }
}
