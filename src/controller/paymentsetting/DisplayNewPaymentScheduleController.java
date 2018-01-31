/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.paymentsetting;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import view.paymentsetting.DialogPaymentScheduleCrud;

/**
 *
 * @author John Ferdinand Antonio
 */
public class DisplayNewPaymentScheduleController {
    private final JMenuItem jmiDisplayCreate;
    private ActionListener displayCreate;
    
    public DisplayNewPaymentScheduleController(JMenuItem jmiDisplayCreate){
        this.jmiDisplayCreate = jmiDisplayCreate;
    }
    
    
    public void control() {
        displayCreate = (ActionEvent e) -> {
            DialogPaymentScheduleCrud newPaymentSchedule = new DialogPaymentScheduleCrud();
            newPaymentSchedule.setTitle("New Payment Schedule");
//            newPaymentSchedule.setPreferredSize(new Dimension(1150, 650));
            newPaymentSchedule.pack();
            newPaymentSchedule.setLocationRelativeTo(null);
            newPaymentSchedule.setVisible(true);
        };
        jmiDisplayCreate.addActionListener(displayCreate);
    }
}
