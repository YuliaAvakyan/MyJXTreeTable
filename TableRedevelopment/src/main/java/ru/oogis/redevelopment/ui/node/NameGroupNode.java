package ru.oogis.redevelopment.ui.node;


import org.jdesktop.swingx.treetable.AbstractMutableTreeTableNode;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;
import ru.oogis.redevelopment.ui.TreeTableModel;

public class NameGroupNode extends AbstractMutableTreeTableNode {
    private String name;
    private AbstractTreeTableModel treeTableModel;

    public NameGroupNode(String name, AbstractTreeTableModel treeTableModel) {
        this.treeTableModel = treeTableModel;
        this.name = name;
    }
//TODO сделать через названия шапок?
    public Object getValueAt(int column) {
        switch (column) {
            case 0:
                return name;
            default:
                return null;
        }
    }

    public int getColumnCount() {
        return treeTableModel.getColumnCount();
    }
}
