package ru.oogis.redevelopment.data.model;

import java.util.HashMap;
import java.util.Map;

public class FunctionalObjectsInTheBuilding {
    private String nameObject;
    private Map<String, Number> functionalObjectParameters;

    public FunctionalObjectsInTheBuilding(String nameObject) {
        this.nameObject = nameObject;
        functionalObjectParameters = new HashMap<String, Number>();
    }

    public FunctionalObjectsInTheBuilding(String nameObject, Map<String, Number> functionalObjectParameters) {
        this.nameObject = nameObject;
        this.functionalObjectParameters = functionalObjectParameters;
    }

    public String getNameObject() {
        return nameObject;
    }

    public void setNameObject(String nameObject) {
        this.nameObject = nameObject;
    }

    public Map<String, Number> getFunctionalObjectParameters() {
        return functionalObjectParameters;
    }

    public void setFunctionalObjectParameters(Map<String, Number> functionalObjectParameters) {
        this.functionalObjectParameters = functionalObjectParameters;
    }

    public void addParameter(String nameParameter, Number value) {
        functionalObjectParameters.put(nameParameter, value);
    }

    public boolean containsParameter(String nameParameter) {
        return functionalObjectParameters.containsKey(nameParameter);
    }

    public Number getNumberByKey(String key) {
        return functionalObjectParameters.get(key);
    }
}
