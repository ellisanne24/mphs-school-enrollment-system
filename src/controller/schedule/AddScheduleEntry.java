/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.schedule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author John Ferdinand Antonio
 */
public class AddScheduleEntry implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private boolean timeHasConflict(int sTime, int eTime, int sTimeNew, int eTimeNew) {
        boolean hasConflict;
        boolean a = ((sTimeNew >= sTime) && (eTimeNew <= eTime));
        boolean b = ((sTimeNew < sTime) && (eTimeNew > sTime && eTimeNew <= eTime));

        hasConflict = a || b;

        return hasConflict;
    }
    
    private boolean dayHasConflict(int day, int dayNew){
        boolean hasConflict;
        hasConflict = (day == dayNew);
        return hasConflict;
    }
    
    private boolean dayHasConflict(String day, String dayNew){
        boolean hasConflict = (day.toLowerCase().equals(dayNew.trim().toLowerCase()));
        return hasConflict;
    }
    
    private boolean roomHasConflict(String room, String roomNew){
        boolean hasConflict = room.toLowerCase().trim().equals(roomNew.toLowerCase().trim());
        return hasConflict;
    }
    
}
