package ru.oogis.redevelopment.data.model;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private long id;
    private String address;
    private String ObjectName;
    List<FunctionalObjectsInTheBuilding> functionalObjectsInTheBuildings;

    public Building(long id, String address, String objectName) {
        this(id, address, objectName, new ArrayList<FunctionalObjectsInTheBuilding>());
    }

    public Building(long id, String address, String objectName, List<FunctionalObjectsInTheBuilding> functionalObjectsInTheBuildings) {
        this.id = id;
        this.address = address;
        ObjectName = objectName;
        this.functionalObjectsInTheBuildings = functionalObjectsInTheBuildings;
    }

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }


    public String getObjectName() {
        return ObjectName;
    }

    public void setObjectName(String objectName) {
        ObjectName = objectName;
    }

    public List<FunctionalObjectsInTheBuilding> getFunctionalObjectsInTheBuildings() {
        return functionalObjectsInTheBuildings;
    }

    public void setFunctionalObjectsInTheBuildings(List<FunctionalObjectsInTheBuilding> functionalObjectsInTheBuildings) {
        this.functionalObjectsInTheBuildings = functionalObjectsInTheBuildings;
    }

    public void addFunctionalObjectsInTheBuilding(FunctionalObjectsInTheBuilding functionalObjectsInTheBuilding){
        this.functionalObjectsInTheBuildings.add(functionalObjectsInTheBuilding);
    }
}
