/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.schedule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author John Ferdinand Antonio
 */
public class AddRowToSchedule implements ActionListener {

    private final JTable jtblSchedule;
    private final JComboBox jcmbRoom;
    
    public AddRowToSchedule(JTable jtblSchedule, JComboBox jcmbRoom){
        this.jtblSchedule = jtblSchedule;
        this.jcmbRoom = jcmbRoom;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultTableModel tableModel = (DefaultTableModel) jtblSchedule.getModel();
        int currentRowCount = tableModel.getRowCount();
        tableModel.setRowCount(currentRowCount+1);
        int newlyAddedRowIndex = tableModel.getRowCount()-1;
        
        if(jcmbRoom.getSelectedIndex()>-1){
            tableModel.setValueAt(jcmbRoom.getSelectedItem().toString(), newlyAddedRowIndex, 5);
        }
    }
    
}
