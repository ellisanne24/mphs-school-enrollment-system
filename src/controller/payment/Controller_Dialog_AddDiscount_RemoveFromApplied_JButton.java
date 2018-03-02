/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import utility.jtable.JTableUtil;
import view.payment.Dialog_AddDiscount;

/**
 *
 * @author Jordan
 */
public class Controller_Dialog_AddDiscount_RemoveFromApplied_JButton implements ActionListener{
    
    private final Dialog_AddDiscount view;

    public Controller_Dialog_AddDiscount_RemoveFromApplied_JButton(Dialog_AddDiscount view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getJbtnRemoveFromAppliedDiscount()){
            if(view.getJtblAppliedDiscount().getRowCount() > 0 && view.getJtblAppliedDiscount().getSelectedRowCount() > 0){
                JTableUtil.moveRowData(view.getJtblAppliedDiscount(), view.getJtblDiscountList());
            }else{
                JOptionPane.showMessageDialog(null,"Nothing is selected.");
            }
        }
    }
    
}
