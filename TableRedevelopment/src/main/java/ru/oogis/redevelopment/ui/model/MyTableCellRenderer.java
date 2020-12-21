package ru.oogis.redevelopment.ui.model;

import org.jdesktop.swingx.tree.DefaultXTreeCellRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class MyTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object o, boolean b, boolean b1, int i, int i1) {
        System.out.println(i + " " + i1);
        super.getTableCellRendererComponent(jTable, o, b, b1, i, i1);
   if(! jTable.isCellEditable(i, i1))
       setBackground(Color.BLUE);
        return this;
    }
}

