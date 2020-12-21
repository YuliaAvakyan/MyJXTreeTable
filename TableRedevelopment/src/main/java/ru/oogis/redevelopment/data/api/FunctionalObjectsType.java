/**
 * Характеристики здания
 */
public enum FunctionalObjectsType {

    HOUSING_STOCK("Современный жилищный фонд","кв.м.", Integer.class),
    KINDERGARTEN("Современная емкость детских садов", "мест", Integer.class),
    SPORTS("Современная общая площадь физкультурно-спортивных", "кв.м.", Integer.class),
    POLYCLINIC("Современная емкость поликлиник", "посещ.", Integer.class),
    LAND_AREA("Существующая площадь земельного участка", "га", Double.class),
    TRADING_AREA("Торговая площадь", "кв.м.", Integer.class),
    OFFICE_AREA("Офисная площадь", "кв.м.", Integer.class),
    EMPLOYEES_NUMBER("Численность сотрудников", "чел.", Integer.class),
    EMPLOYEES_NUMBER_MAX("Численность сотрудников максимальной смены", "чел.", Integer.class),
    AVERAGE_FLOOR("Средняя этажность", "ед.", Integer.class),
    FOOTBALL("Количество спортядер футбольного типа", "ед.", Integer.class),
    VOLEYBALL("Количество волейбольных площадок", "ед.", Integer.class),
    // Неопределённый тип - признак ошибки ввода
    NONE("Неопределённый тип", "", Integer.class);

    // Название характеристики
    private String funcName;

    // Единица измерения
    private String unit;

    // Тип значения
    private Class classType;



    FunctionalObjectsType(String funcName, String unit, Class classType) {
        this.funcName = funcName;
        this.unit = unit;
        this.classType = classType;
    }

    public Class getClassType() {
        return classType;
    }

    public String getFuncName() {
        return funcName;
    }

    public String getUnit() {
        return unit;
    }

    public static String getTypeNameByTypeNumber(int number) {
        for (FunctionalObjectsType functionalObjectsType : FunctionalObjectsType.values()) {
            if (functionalObjectsType.ordinal() == number) {
                return functionalObjectsType.getFuncName();
            }
        }
        return "";
    }

    public static Class getClassTypeByNumber(int number) {
        for (FunctionalObjectsType functionalObjectsType : FunctionalObjectsType.values()) {
            if (functionalObjectsType.ordinal() == number) {
                return functionalObjectsType.getClassType();
            }
        }
        return Number.class;
    }
}
