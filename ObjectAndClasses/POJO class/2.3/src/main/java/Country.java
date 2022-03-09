public class Country {
    public String countryName;
    public int populationSize;
    public int square;
    public String capitalName;
    public boolean sea;

    public Country(String countryName) {
        this.countryName = countryName;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public boolean getSea() {
        return sea;
    }

    public void setSea(boolean sea) {
        this.sea = sea;
    }

}



