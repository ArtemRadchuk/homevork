public final class Monitor  {
    final int diagonal;
    final String mType;
    final int mWeight;

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
}
