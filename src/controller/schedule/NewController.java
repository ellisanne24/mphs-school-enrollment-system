/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.schedule;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.schedule.CreateSchedule;

/**
 *
 * @author John Ferdinand Antonio
 */
public class NewController implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        CreateSchedule c = new CreateSchedule(null,true);
        c.setPreferredSize(new Dimension(1000,540));
        c.pack();
        c.setLocationRelativeTo(null);
        c.setVisible(true);
    }
    
}
