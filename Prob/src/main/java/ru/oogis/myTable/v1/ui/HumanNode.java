package ru.oogis.myTable.v1.ui;

import org.jdesktop.swingx.treetable.AbstractMutableTreeTableNode;
import ru.oogis.myTable.v1.data.Human;
import ru.oogis.myTable.v1.data.HumanGroup;
import ru.oogis.myTable.v1.data.Man;

public class HumanNode extends AbstractMutableTreeTableNode {

    public HumanNode(Human human) {
        super(human);
    }

    @Override
    public Object getValueAt(int column) {
        Human human = (Human) getUserObject();
        switch (column) {

            case 0:
                return human.getName();
            case 1:
                return human.getAge();
            case 2:
                return human.getCity();
            case 3: {
                if (human instanceof Man) {
                    return ((Man) human).getEnergy();
                } else {
                    return "non";
                }
            }
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
}
