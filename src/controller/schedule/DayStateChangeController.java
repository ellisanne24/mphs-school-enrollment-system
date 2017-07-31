/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.schedule;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

/**
 *
 * @author John Ferdinand Antonio
 */
public class DayStateChangeController implements ItemListener{

    private final JComboBox jcmbRoom;
    private final JCheckBox jcbDay;
    
    public DayStateChangeController(JComboBox jcmbRoom, JCheckBox jcbDay){
        this.jcmbRoom = jcmbRoom;
        this.jcbDay = jcbDay;
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(jcbDay.isSelected()){
            jcmbRoom.setEnabled(true);
        }
    }
    
}
