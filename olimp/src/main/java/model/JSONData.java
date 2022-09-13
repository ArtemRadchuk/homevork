package model;

public class JSONData {
    private String symbol;
    private  int[] reference;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int[] getReference() {
        return reference;
    }

    public void setReference(int[] reference) {
        this.reference = reference;
    }
}
