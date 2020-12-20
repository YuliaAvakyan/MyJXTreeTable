package ru.oogis.redevelopment;

import ru.oogis.redevelopment.data.model.Building;
import ru.oogis.redevelopment.data.model.FunctionalObjectsInTheBuilding;
import ru.oogis.redevelopment.data.model.WrapperForTheGlobalTable;
import ru.oogis.redevelopment.ui.FrameForGlobalTable;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Start {
    private String[] nameKeyMap1 = {"A", "B", "C", "D"};
    private String[] nameBuilding = {"House", "Shop", "Offices", "Object"};
    private FrameForGlobalTable frameForGlobalTable;
    private String[] nameParameters = {"human", "Area", "value", "pipe", "price"};
    private ThreadLocalRandom random = ThreadLocalRandom.current();

    public Start() {
        Map<String, Number> nameColumn = new HashMap<>();
        frameForGlobalTable = new FrameForGlobalTable(new WrapperForTheGlobalTable(nameColumn, initMap(nameColumn)));
        frameForGlobalTable.setVisible(true);
    }

    private Map<String, Map<String, Map<String, Building>>> initMap(Map<String, Number> nameColumn) {
        Map<String, Map<String, Map<String, Building>>> map1 = new HashMap<>();
        for (String kay1 : nameKeyMap1) {
            Map<String, Map<String, Building>> map2 = new HashMap<>();
            for (int i = 0; i < 4; i++) {
                Map<String, Building> map3 = new HashMap<>();
                for (int j = 0; j < 4; j++) {
                    Building building = new Building(random.nextInt(20000), "address", "name Object");
                    for (int k = 0; k < 3; k++) {
                        FunctionalObjectsInTheBuilding functionalObjectsInTheBuilding = new FunctionalObjectsInTheBuilding(nameBuilding[random.nextInt(nameBuilding.length)]);
                        for (int m = 0; m < 3; m++) {

                            addParameter(functionalObjectsInTheBuilding, nameColumn);

                        }
                        building.addFunctionalObjectsInTheBuilding(functionalObjectsInTheBuilding);
                    }

                    map3.put(Integer.valueOf(j).toString(), building);
                }
                map2.put(nameBuilding[random.nextInt(nameBuilding.length)], map3);
            }
            map1.put(kay1, map2);
        }
        return map1;
    }

    private void addParameter(FunctionalObjectsInTheBuilding functionalObjectsInTheBuilding, Map<String, Number> nameColumn) {
        String nameParam = nameParameters[random.nextInt(nameParameters.length)];
        Number number;
        if (nameColumn.containsKey(nameParam)) {
            number = nameColumn.get(nameParam);
            if (number.getClass() == Integer.class) {
                functionalObjectsInTheBuilding.addParameter(nameParam, random.nextInt(2000));
            } else if (number.getClass() == Double.class) {
                functionalObjectsInTheBuilding.addParameter(nameParam, random.nextDouble(2000));
            } else {
                throw new IllegalArgumentException((number.getClass()).toString());
            }
        } else {
            if (random.nextInt(200) % 2 == 0) {
                number = random.nextInt(2000);
                functionalObjectsInTheBuilding.addParameter(nameParam, number);
                nameColumn.put(nameParam, number);
            } else {
                number = random.nextDouble(2000);
                functionalObjectsInTheBuilding.addParameter(nameParam, number);
                nameColumn.put(nameParam, number);
            }
        }
    }


    public static void main(String[] args) {
        new Start();
    }
}
