/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.schedule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author John Ferdinand Antonio
 */
public class ClearScheduleFormController implements ActionListener{

    private final JTable jtblSchedule;
    
    public ClearScheduleFormController(JTable jtblSchedule){
        this.jtblSchedule = jtblSchedule;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int choice = JOptionPane.showConfirmDialog(null, "Clear Schedule Form?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) jtblSchedule.getModel();
            model.setRowCount(0);
        }
        
    }
    
}