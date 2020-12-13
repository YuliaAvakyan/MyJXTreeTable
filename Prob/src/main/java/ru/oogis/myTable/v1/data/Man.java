package ru.oogis.myTable.v1.data;

public class Man extends Human {
    private int energy;

    public Man(String name, int age, String city) {
        super(name, age, city);
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
