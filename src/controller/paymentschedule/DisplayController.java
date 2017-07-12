/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.paymentschedule;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import view.CreatePaymentSchedule;

/**
 *
 * @author John Ferdinand Antonio
 */
public class DisplayController {
    private final JMenuItem jmiDisplayCreate;
    private ActionListener displayCreate;
    
    public DisplayController(JMenuItem jmiDisplayCreate){
        this.jmiDisplayCreate = jmiDisplayCreate;
    }
    
    
    public void control() {
        displayCreate = (ActionEvent e) -> {
            CreatePaymentSchedule c = new CreatePaymentSchedule();
            c.setPreferredSize(new Dimension(1150,650));
            c.pack();
            c.setLocationRelativeTo(null);
            c.setVisible(true);
        };
        jmiDisplayCreate.addActionListener(displayCreate);
    }
}
