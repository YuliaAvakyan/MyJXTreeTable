package ru.oogis.myTable.v1.ui;

import org.jdesktop.swingx.treetable.AbstractMutableTreeTableNode;

public class StringNode extends AbstractMutableTreeTableNode {

    public StringNode(String name) {
        super(name);
    }

    @Override
    public Object getValueAt(int column) {
        return getUserObject();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }
}
