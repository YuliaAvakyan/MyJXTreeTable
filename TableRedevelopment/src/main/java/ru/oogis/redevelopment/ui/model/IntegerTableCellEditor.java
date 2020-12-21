package ru.oogis.redevelopment.ui.model;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class IntegerTableCallEditor extends AbstractCellEditor implements TableCellEditor {
    private JSpinner spinner;

    public IntegerTableCallEditor() {
        this.spinner = new JSpinner(new SpinnerNumberModel(0, 0, 6000000, 1));
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

