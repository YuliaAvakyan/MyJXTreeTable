package ru.oogis.redevelopment.ui.node;

import org.jdesktop.swingx.treetable.AbstractMutableTreeTableNode;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;
import ru.oogis.redevelopment.data.model.Building;

public class BuildingNode extends AbstractMutableTreeTableNode {

    private Building building;
    AbstractTreeTableModel treeTableModel;

    public BuildingNode(Building building, AbstractTreeTableModel treeTableModel) {
        this.building = building;
        this.treeTableModel = treeTableModel;
    }


    public Object getValueAt(int column) {
        switch (column) {
            case 1:
                return building.getId();
            case 2:
                return building.getAddress();
            case 3:
                return building.getObjectName();
            default:
                return "";
        }
    }

    public int getColumnCount() {
        return treeTableModel.getColumnCount();
    }
}
