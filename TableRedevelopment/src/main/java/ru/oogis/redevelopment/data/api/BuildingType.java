/**
 * Типы жилой застройки и соответствующая им площадь элемента застройки
 */
public enum BuildingType {
    // ! порядок групп типов не изменять !
    // типы ИЖС (индивидуальное жилое строительство)
    IND_2020("ИЖС-1", 2),
    IND_2025("ИЖС-2", 2),
    IND_2030("ИЖС-3", 2),
    IND_2040("ИЖС-4", 2),
    IND_2525("ИЖС-5", 2),
    IND_2530("ИЖС-6", 2),
    IND_2540("ИЖС-7", 2),
    IND_3030("ИЖС-8", 2),
    IND_3035("ИЖС-9", 2),
    IND_3040("ИЖС-10", 2),
    // типы таунхаусов
    TN_0612("ТХ-1", 2),
    TN_0812("ТХ-2", 2),
    TN_1012("ТХ-3", 2),
    TN_1212("ТХ-4", 2),
    TN_1020("ТХ-5", 2),
    TN_1220("ТХ-6", 2),
    // типы многоквартирных домов
    APN_01("МКД-1", 4),
    APN_02("МКД-2", 8),
    APN_03("МКД-3", 10),
    APN_04("МКД-4", 16),
    // корневые типы
    INDIVIDUAL_AREA("ИЖС", 0),                // корневой элемент для ИЖС
    TOWNHOUSE_AREA("Таунхаусы", 0),           // корневой элемент для таунхаусов
    APART_AREA("Многоквартирные дома", 0),    // корневой элемент для многоквартирных домов
    ACCOMMODATION_AREA("Жилье", 0),    // общая группа
    // Неопределённый тип - признак ошибки ввода
    NONE("Неопределённый тип", 0);


    // корневые типы не используются в рядовых расчётах, только для итоговых (суммирующих) расчётов
    // количество корневых типов (любых корневых) в перечислении
    public static final int ROOT_ITEM_COUNT = 4;
    // количество корневых типов жилья (исключительно и только их) в перечислении
    public static final int ROOT_ACCOMMODATION_ITEM_COUNT = 3;
    // номер последнего элемента типов таунхаусов
    public static final int LAST_NUMBER_OF_TOWNHOUSE_AREA = BuildingType.TN_1220.ordinal();


    // Название данного типа
    private String typeName;

    // Средняя этажность жилой застройки данного типа
    private Integer meanFloor;


    BuildingType(String typeName, Integer meanFloor) {
        this.typeName = typeName;
        this.meanFloor = meanFloor;
    }

    public String getTypeName() {
        return typeName;
    }

    public Integer getMeanFloor() {
        return meanFloor;
    }

    public static String getTypeNameByTypeNumber(int number) {
        for (BuildingType buildingType : BuildingType.values()) {
            if (buildingType.ordinal() == number) {
                return buildingType.getTypeName();
            }
        }
        return "";
    }

    public static BuildingType getTypeByName(String typeName) {
        for (BuildingType t : BuildingType.values())
            if (t.getTypeName().equals(typeName))
                return t;

        return BuildingType.NONE;
    }
}

