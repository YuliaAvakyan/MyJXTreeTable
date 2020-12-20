package ru.oogis.redevelopment.ui;

import org.jdesktop.swingx.treetable.AbstractMutableTreeTableNode;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;


import java.util.*;


public class TreeTableModel extends AbstractTreeTableModel {
    private final List<String> columnName;
    private final Map<String, Number> columnMap;

    public TreeTableModel(Map<String, Number> columnMap) {
        this.columnName = new ArrayList<>();
        this.columnMap = columnMap;
        String[] defaultNameColumn = {"Name", "id", "Address", "Name Object", "FunctionalObjects"};
        this.columnName.addAll(Arrays.asList(defaultNameColumn));
        this.columnName.addAll(columnMap.keySet());
    }

    public void setRoot(AbstractMutableTreeTableNode root) {
        super.root = root;
    }


    public int getColumnCount() {
        return columnName.size();
    }


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


    @Override
    public Class<?> getColumnClass(int column) {
       Object object = columnMap.get(columnName.get(column));
        return object == null ? Object.class : object.getClass();

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
