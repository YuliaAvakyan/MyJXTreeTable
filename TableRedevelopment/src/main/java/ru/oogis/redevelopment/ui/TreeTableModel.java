package ru.oogis.redevelopment.ui;

import org.jdesktop.swingx.treetable.AbstractMutableTreeTableNode;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeTableModel extends AbstractTreeTableModel {
    List<String> columnName;
    // TODO сделать енам???? для использования в Node
    private final String[] defaultNameColumn = {"Name", "id", "Address", "Name Object", "FunctionalObjects"};

    public TreeTableModel(List<String> columnName) {
        this.columnName = new ArrayList<>();
        for (String name : defaultNameColumn) {
            this.columnName.add(name);
        }
        this.columnName.addAll(columnName);
    }

    public void setRoot(AbstractMutableTreeTableNode root) {
        super.root = root;
    }


    public int getColumnCount() {
        return columnName.size();
    }
// TODO можно ли выдать null?
    public Object getValueAt(Object node, int column) {
        return ((AbstractMutableTreeTableNode) node).getValueAt(column);
    }

    public Object getChild(Object parent, int index) {
        return ((AbstractMutableTreeTableNode) parent).getChildAt(index);
    }

    public int getChildCount(Object parent) {
        return ((AbstractMutableTreeTableNode) parent).getChildCount();
    }

    public int getIndexOfChild(Object parent, Object child) {
        return ((AbstractMutableTreeTableNode) parent).getIndex((AbstractMutableTreeTableNode) child);
    }

    @Override
    public String getColumnName(int column) {
        return columnName.get(column);
    }

    //TODO как взять класс у нужного объекта
    @Override
    public Class<?> getColumnClass(int column) {
        return Object.class;
    }

    @Override
    public boolean isCellEditable(Object node, int column) {
        return ((AbstractMutableTreeTableNode) node).isEditable(column);
    }

    @Override
    public void setValueAt(Object value, Object node, int column) {
        ((AbstractMutableTreeTableNode) node).setValueAt(value, column);
    }
}
