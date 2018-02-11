
package component_renderers;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import model.room.Room;

public class Renderer_GradeLevel_JComboBox extends JLabel implements ListCellRenderer<Object> {

    public Renderer_GradeLevel_JComboBox() {
        this.setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if(value instanceof Integer){
            if(((Integer)value) == 0){
                this.setText("Kindergarten");
            }else{
                this.setText(""+value);
            }
        }else {
            this.setText("Select");
        }

        if (isSelected) {
            this.setBackground(Color.YELLOW);
//            this.setBackground(list.getSelectionBackground());
            this.setForeground(Color.BLACK);
        } else {
            this.setBackground(list.getBackground());
            this.setForeground(list.getForeground());
        }

        return this;
    }

}