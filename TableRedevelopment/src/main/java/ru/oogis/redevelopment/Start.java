package ru.oogis.redevelopment;

import ru.oogis.redevelopment.data.model.Building;
import ru.oogis.redevelopment.data.model.FunctionalObjectsInTheBuilding;
import ru.oogis.redevelopment.ui.FrameForGlobalTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Start {
    private String[] nameKeyMap1 = {"A", "B", "C", "D"};
    private String[] nameBuilding = {"House", "Shop", "Offices", "Object"};
    private FrameForGlobalTable frameForGlobalTable;
    private String[] nameParameters = {"human", "Area", "value", "pipe", "price"};

    public Start() {

        frameForGlobalTable = new FrameForGlobalTable(Arrays.asList(nameParameters), initMap());
        frameForGlobalTable.setVisible(true);
    }

    private Map<String, Map<String, Map<String, Building>>> initMap() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
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
                            functionalObjectsInTheBuilding.addParameter(nameParameters[random.nextInt(nameParameters.length)], random.nextDouble(2000));
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


    public static void main(String[] args) {
        new Start();
    }
}
