package ru.oogis.myTable.v1.data;

public class Man extends Human {
    private int energy;

    public Man(String name, int age, String city , int energy) {
        super(name, age, city);
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
