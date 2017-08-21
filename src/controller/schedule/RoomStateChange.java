package controller.schedule;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author John Ferdinand Antonio
 */
public class RoomStateChange implements ItemListener{

    private final JComboBox jcmbRoom;
    private final JTable jtblSchedule;
    
    public RoomStateChange(JComboBox jcmbRoom, JTable jtblSchedule){
        this.jcmbRoom = jcmbRoom;
        this.jtblSchedule = jtblSchedule;
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(jcmbRoom.getSelectedIndex() > -1){
            String room = jcmbRoom.getSelectedItem().toString().trim();
            for(int i = 0; i<jtblSchedule.getRowCount(); i++){
                jtblSchedule.setValueAt(room, i, 5);
            }
            jtblSchedule.repaint();
        }
    }
    
}
