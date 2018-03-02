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
public class Controller_Dialog_AddDiscount_MoveDiscountToApplied implements ActionListener{
    
    private final Dialog_AddDiscount view;

    public Controller_Dialog_AddDiscount_MoveDiscountToApplied(Dialog_AddDiscount view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getJbtnMoveToAppliedDiscount()){
            if(view.getJtblDiscountList().getRowCount() > 0){
                JTableUtil.moveRowData(view.getJtblDiscountList(), view.getJtblAppliedDiscount());
            }else{
                JOptionPane.showMessageDialog(null, "Nothing to move.");
            }
        }
    }
    
}
