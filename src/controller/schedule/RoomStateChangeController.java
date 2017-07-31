/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.schedule;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;

/**
 *
 * @author John Ferdinand Antonio
 */
public class RoomStateChangeController implements ItemListener{

    private final JButton jbtnAddSchedule;
    
    public RoomStateChangeController(JButton jbtnAddSchedule){
        this.jbtnAddSchedule = jbtnAddSchedule;
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        jbtnAddSchedule.setEnabled(true);
    }
    
}
