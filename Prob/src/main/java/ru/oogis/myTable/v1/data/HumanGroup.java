package ru.oogis.myTable.v1.data;

import java.util.ArrayList;
import java.util.List;

public class HumanGroup {

    private String name;
    private List<Human> humans = new ArrayList<Human>();


    public HumanGroup(String name) {
        this.name = name;
    }

    public void add(Human human){
        humans.add(human);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Human> getHumans() {
        return humans;
    }

    public void setHumans(List<Human> humans) {
        this.humans = humans;
    }
}
