package ru.oogis.myTable.v1.ui;

import org.jdesktop.swingx.treetable.AbstractMutableTreeTableNode;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;
import org.jdesktop.swingx.treetable.TreeTableNode;

public class MyTreeTableModel extends AbstractTreeTableModel {
    private String[] columnName;

    public MyTreeTableModel(TreeTableNode root, String[] columnName) {
        super(root);
        this.columnName = columnName;
    }


    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    @Override
    public boolean isCellEditable(Object node, int column) {
        return node instanceof HumanNode;
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(Object node, int column) {
        if (node instanceof GroupNode) {
            switch (column) {
                case 0:
                    return ((GroupNode) node).getValueAt(0);
                default:
                    return "--";
            }
        } else if (node instanceof HumanNode) {
            switch (column) {
                case 0:
                    return "--";
                default:
                    return ((HumanNode) node).getValueAt(column - 1);
            }
        } else {
            throw new IllegalArgumentException(node.toString());
        }
    }

    @Override
    public Object getChild(Object o, int i) {
        return ((AbstractMutableTreeTableNode) o).getChildAt(i);
    }

    @Override
    public int getChildCount(Object o) {
        return ((AbstractMutableTreeTableNode) o).getChildCount();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        return ((TreeTableNode) parent).getIndex((TreeTableNode) child);
    }
}
