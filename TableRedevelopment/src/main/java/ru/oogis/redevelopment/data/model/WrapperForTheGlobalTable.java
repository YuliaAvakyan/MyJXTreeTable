package ru.oogis.redevelopment.data.model;

import org.jdesktop.swingx.treetable.AbstractMutableTreeTableNode;
import ru.oogis.redevelopment.ui.TreeTableModel;
import ru.oogis.redevelopment.ui.node.BuildingNode;
import ru.oogis.redevelopment.ui.node.FunctionalObjectsInTheBuildingNode;
import ru.oogis.redevelopment.ui.node.NameGroupNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WrapperForTheGlobalTable {
    private Map<String, Number> nameColumnMap;
    private Map<String, ?> dataMap;

    public WrapperForTheGlobalTable(Map<String, Number> nameColumnMap, Map<String, ?> dataMap) {
        this.nameColumnMap = nameColumnMap;
        this.dataMap = dataMap;
    }

    public Map<String, Number> getNameColumnMap() {
        return nameColumnMap;
    }

    public void setNameColumnMap(Map<String, Number> nameColumnMap) {
        this.nameColumnMap = nameColumnMap;
    }

    public Map<String, ?> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, ?> dataMap) {
        this.dataMap = dataMap;
    }

    public List<AbstractMutableTreeTableNode> getListNode(TreeTableModel treeTableModel) {
        return getNameGroupNode(dataMap, treeTableModel);
    }

    private List<AbstractMutableTreeTableNode> getNameGroupNode(Map<String, ?> map, TreeTableModel treeTableModel) {
        List<AbstractMutableTreeTableNode> nodes = new ArrayList<>();
        for (Map.Entry<String, ?> value : map.entrySet()) {
            AbstractMutableTreeTableNode node = new NameGroupNode(value.getKey(), treeTableModel);
            if (value.getValue() instanceof Map) {
                for (AbstractMutableTreeTableNode children : getNameGroupNode((Map<String, Object>) value.getValue(), treeTableModel)) {
                    node.add(children);
                }
            } else if (value.getValue().getClass() == Building.class) {
                node.add(getBuildingNode((Building) value.getValue(), treeTableModel));
            } else {
                throw new IllegalArgumentException();
            }
            nodes.add(node);
        }
        return nodes;
    }

    private BuildingNode getBuildingNode(Building building, TreeTableModel treeTableModel) {
        BuildingNode buildingNode = new BuildingNode(building, treeTableModel);
        for (FunctionalObjectsInTheBuilding functionalObjectsInTheBuilding : building.getFunctionalObjectsInTheBuildings()) {
            buildingNode.add(new FunctionalObjectsInTheBuildingNode(functionalObjectsInTheBuilding, treeTableModel));
        }
        return buildingNode;
    }
}
