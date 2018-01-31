
package component_renderers;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import model.gradelevel.GradeLevel;

public class GradeLevelJComboBoxRenderer extends JLabel implements ListCellRenderer<Object> {

    public GradeLevelJComboBoxRenderer() {
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
            this.setText("--");
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
