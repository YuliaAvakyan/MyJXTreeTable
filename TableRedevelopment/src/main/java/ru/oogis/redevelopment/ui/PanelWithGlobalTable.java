/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.oogis.redevelopment.ui;

import org.jdesktop.swingx.JXTreeTable;
import org.jdesktop.swingx.treetable.AbstractMutableTreeTableNode;
import ru.oogis.redevelopment.data.model.Building;
import ru.oogis.redevelopment.data.model.FunctionalObjectsInTheBuilding;
import ru.oogis.redevelopment.data.model.WrapperForTheGlobalTable;
import ru.oogis.redevelopment.ui.node.BuildingNode;
import ru.oogis.redevelopment.ui.node.FunctionalObjectsInTheBuildingNode;
import ru.oogis.redevelopment.ui.node.NameGroupNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author �
 */
public class PanelWithGlobalTable extends javax.swing.JPanel {

    private WrapperForTheGlobalTable wrapperForTheGlobalTable;

    /**
     * Creates new form PanelWithGlobalTable
     */

    public PanelWithGlobalTable(WrapperForTheGlobalTable wrapperForTheGlobalTable) {
        this.wrapperForTheGlobalTable = wrapperForTheGlobalTable;
        initComponents();
        initTable(wrapperForTheGlobalTable);
    }

    private void initTable(WrapperForTheGlobalTable wrapperForTheGlobalTable) {
        TreeTableModel treeTableModel = new TreeTableModel(wrapperForTheGlobalTable.getNameColumnMap());
        AbstractMutableTreeTableNode root = new NameGroupNode("root", treeTableModel);
        for (AbstractMutableTreeTableNode node : wrapperForTheGlobalTable.getListNode(treeTableModel)) {
            root.add(node);
        }
        treeTableModel.setRoot(root);
        JXTreeTable table = new JXTreeTable(treeTableModel);

        table.setShowGrid(true, true);
       table.setRowHeight(25);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelWithTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        javax.swing.JButton nextButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        panelWithTable.setBackground(new java.awt.Color(240, 220, 240));
        panelWithTable.setLayout(new java.awt.BorderLayout());
        panelWithTable.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(panelWithTable, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(420, 50));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        nextButton.setText("next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(nextButton, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        System.out.println("next");

    }//GEN-LAST:event_nextButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelWithTable;
    // End of variables declaration//GEN-END:variables
}
