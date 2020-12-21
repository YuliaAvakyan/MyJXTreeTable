package ru.oogis.redevelopment.ui.model;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class DoubleTableCallEditor  extends AbstractCellEditor implements TableCellEditor {
    private JSpinner spinner;

    public DoubleTableCallEditor() {
        this.spinner = new JSpinner(new SpinnerNumberModel(0d , 0d , 6000000d , 0.01));
    }

    @Override
    public Component getTableCellEditorComponent(JTable jTable, Object value, boolean isSelect, int row, int column) {
        spinner.setValue(value);
        return spinner;

    }

    @Override
    public Object getCellEditorValue() {
        return spinner.getValue();
    }
}
