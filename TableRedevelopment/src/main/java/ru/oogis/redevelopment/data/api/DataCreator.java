import model.Building;
import model.FunctionalObjectsInTheBuilding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataCreator {

    // Количество зданий разного типа
    private int apn_count;
    private int tn_count;
    private int ind_count;

    public DataCreator(int ind_count, int tn_count, int apn_count) {
        this.apn_count = apn_count;
        this.tn_count = tn_count;
        this.ind_count = ind_count;
    }

    private static final String FILE_PATH = "../resources/buildings.txt";

    List<String> allBuilds = new ArrayList<>();

    private List<String> getBuildingsFromFile() throws IOException {
        Path path = Paths.get(FILE_PATH);
        List<String> allLines = Files.readAllLines(path);
        allLines.remove(0);

        return allLines;
    }

    // Список всех зданий файла с функциональными объектами
    private List<Building> createBuilding() {
        List<Building> buildingList = new ArrayList<>();

        // Чтение из файла
        try {
            allBuilds = getBuildingsFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Создание здания с id, address, name. Добавление в список зданий.
        for (int i = 0; i < allBuilds.size(); i++) {
            String[] s = allBuilds.get(i).split(";");
            Building building = new Building(Long.parseLong(s[0].trim()), s[1].trim(), s[2].trim());
            // Если есть функциональные объекты, читаем и добавляем их к зданию.
            // В качестве параметра передаем строку, описывающую текущее здание.
            if (s.length > 3) {
                building.setFunctionalObjectsInTheBuildings(createFunctionalObj(s));
            }
            buildingList.add(building);
        }

//        for (int i = 0; i < buildingList.size(); i++) {
//            for (int j = 0; j < buildingList.get(i).getFunctionalObjectsInTheBuildings().size(); j++)
//                System.out.println(i + " = " + buildingList.get(i).getFunctionalObjectsInTheBuildings().get(j).getNameObject());
//        }

//        for (Map.Entry<String, Number> b : buildingList.get(0).getFunctionalObjectsInTheBuildings().get(0).getFunctionalObjectParameters().entrySet()) {
//            System.out.println(b.getKey() + " " + b.getValue());
//        }

        return buildingList;
    }

    // Список параметров для каждого здания
    private List<FunctionalObjectsInTheBuilding> createFunctionalObj(String[] s) {
        List<FunctionalObjectsInTheBuilding> funcList = new ArrayList<>();
        List<Map<String, Number>> funcListMap = new ArrayList<>();

        int count = 4;

        // Названия функциональных объектов
        for (int i = 3; i < s.length; i = i + 13) {
            if (!s[i].trim().equals("end")) {
                FunctionalObjectsInTheBuilding fo = new FunctionalObjectsInTheBuilding(s[i].trim());
                funcList.add(fo);
            }
        }

//            for (FunctionalObjectsInTheBuilding f : funcList) {
//                System.out.println(k + " " + f.getNameObject());
//            }

        // Значения параметров
        while (count < s.length) {
            Map<String, Number> functionalObjectParameters = new HashMap<>();
            for (int i = count; i < 12 + count; i++) {
                String name = FunctionalObjectsType.getTypeNameByTypeNumber(i - count);
                Class classType = FunctionalObjectsType.getClassTypeByNumber(i - count);
                // Если значения нет, то записываем 0
                if (s[i].isEmpty()) {
                    s[i] = "0";
                }
                if (classType.equals(Integer.class)) {
                    functionalObjectParameters.put(name, Integer.valueOf(s[i].trim()));
                } else {
                    functionalObjectParameters.put(name, Double.valueOf(s[i].trim()));
                }
            }
            // Добавлем Map с параметрами в общий список
            funcListMap.add(functionalObjectParameters);
            count = count + 13;
        }

        // Устанавливаем значения параметров для соответствующего функционального объекта
        for (int i = 0; i < funcList.size(); i++) {
            funcList.get(i).setFunctionalObjectParameters(funcListMap.get(i));
        }

//        for (int i = 0; i < funcListMap.size(); i++) {
//            System.out.println("\n" + funcList.get(i).getNameObject());
//            for (Map.Entry<String, Number> b : funcListMap.get(i).entrySet()) {
//                System.out.println(b.getKey() + " " + b.getValue());
//            }
//        }
        return funcList;
    }


    // Создание трех типов зданий
    private Map<String, List<Building>> createBuildingsBySubType() {
        List<Building> buildingList = createBuilding();
        Map<String, List<Building>> map = new HashMap<>();

        if (ind_count > 0) {
            map.put(BuildingType.IND_2525.getTypeName(), buildingList.subList(0, ind_count));
        }

        if (tn_count > 0) {
            map.put(BuildingType.TN_1012.getTypeName(), buildingList.subList(ind_count, tn_count + ind_count));
        }

        if (apn_count > 0) {
            map.put(BuildingType.APN_01.getTypeName(), buildingList.subList(tn_count + ind_count, apn_count + tn_count + ind_count));
        }
        return map;
    }


    private Map<String, Map<String, List<Building>>> createBuildingsByType() {
        Map<String, List<Building>> subtypeMap = createBuildingsBySubType();
        Map<String, Map<String, List<Building>>> map = new HashMap<>();
        if (ind_count > 0) {
            map.put(BuildingType.INDIVIDUAL_AREA.getTypeName(), subtypeMap.entrySet()
                                                                    .stream()
                                                                    .filter(m -> m.getKey().startsWith("ИЖС"))
                                                                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        }

        if (tn_count > 0) {
            map.put(BuildingType.TOWNHOUSE_AREA.getTypeName(), subtypeMap.entrySet()
                                                                    .stream()
                                                                    .filter(m -> m.getKey().startsWith("ТХ"))
                                                                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        }

        if (apn_count > 0) {
            map.put(BuildingType.APART_AREA.getTypeName(), subtypeMap.entrySet()
                                                                    .stream()
                                                                    .filter(m -> m.getKey().startsWith("МКД"))
                                                                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        }
        return map;
    }

    /**
     *
     * @return Map со всеми значениями
     */
    public Map<String, Map<String, Map<String, List<Building>>>> createCommonData() {
        Map<String, Map<String, Map<String, List<Building>>>> commonMap = new HashMap<>();
        commonMap.put(BuildingType.ACCOMMODATION_AREA.getTypeName(), createBuildingsByType());
        return commonMap;
    }

    /**
     *
     * @return Названия параметров функциональных объектов
     */

    public Map<String, Class> createParametersHeader(){
        Map<String, Class> map = new HashMap<>();
        for (FunctionalObjectsType f : FunctionalObjectsType.values()) {
            map.put(f.getFuncName(), f.getClassType());
        }
        return map;
    }


}
