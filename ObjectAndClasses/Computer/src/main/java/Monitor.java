public final class Monitor {
    private final int diagonal;
    private final String mType;
    private final int mWeight;

    public Monitor(int diagonal, String mType, int mWeight) {
        this.diagonal = diagonal;
        this.mType = mType;
        this.mWeight = mWeight;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public String getMType() {
        return mType;
    }

    public int getMWeight() {
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
