package ru.oogis.redevelopment.ui.node;

import org.jdesktop.swingx.treetable.AbstractMutableTreeTableNode;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;
import ru.oogis.redevelopment.data.model.FunctionalObjectsInTheBuilding;

public class FunctionalObjectsInTheBuildingNode extends AbstractMutableTreeTableNode {

    private AbstractTreeTableModel treeTableModel;
    private FunctionalObjectsInTheBuilding functionalObjectsInTheBuilding;

    public FunctionalObjectsInTheBuildingNode(FunctionalObjectsInTheBuilding functionalObjectsInTheBuilding, AbstractTreeTableModel treeTableModel) {
        this.functionalObjectsInTheBuilding = functionalObjectsInTheBuilding;
        this.treeTableModel = treeTableModel;
    }

    // TODO переделать switch   {"Name" , "id" , "Address" , "Name Object", "FunctionalObjects"};
    public Object getValueAt(int i) {
        switch (treeTableModel.getColumnName(i)) {
            case "FunctionalObjects":
                return functionalObjectsInTheBuilding.getNameObject();
            default: {
                Number number = functionalObjectsInTheBuilding.getNumberByKey(treeTableModel.getColumnName(i));
                return number == null ? "" : number;
            }
        }
    }

    public int getColumnCount() {
        return treeTableModel.getColumnCount();
    }

    @Override
    public boolean isEditable(int column) {
        return functionalObjectsInTheBuilding.containsParameter(treeTableModel.getColumnName(column));
    }

    // TODO
    @Override
    public void setValueAt(Object aValue, int column) {
        functionalObjectsInTheBuilding.addParameter(treeTableModel.getColumnName(column), Double.parseDouble(aValue.toString()));
    }
}
