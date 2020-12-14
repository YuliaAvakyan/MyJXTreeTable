package ru.oogis.myTable.v1.ui;

import org.jdesktop.swingx.treetable.AbstractMutableTreeTableNode;
import ru.oogis.myTable.v1.data.HumanGroup;

public class GroupNode extends AbstractMutableTreeTableNode {

    public GroupNode(HumanGroup group) {
        super(group);
    }

    @Override
    public Object getValueAt(int column) {
        return ((HumanGroup) getUserObject()).getName();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }
}
