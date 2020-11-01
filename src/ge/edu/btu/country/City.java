package ge.edu.btu.country;

import java.io.Serializable;

public class City implements Serializable {

    private String name;

    private boolean capital;

    private long population;

    public City() {
    }

    public City(String name, boolean capital, long population) {
        this.name = name;
        this.capital = capital;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}
