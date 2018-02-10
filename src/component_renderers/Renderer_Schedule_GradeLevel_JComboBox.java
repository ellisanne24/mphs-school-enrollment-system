package component_renderers;

import daoimpl.GradeLevelDaoImpl;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import model.gradelevel.GradeLevel;

/**
 *
 * @author Jordan
 */
public class Renderer_Schedule_GradeLevel_JComboBox extends JLabel implements ListCellRenderer<Object>{

    private GradeLevelDaoImpl gradeLevelDaoImpl;
    public Renderer_Schedule_GradeLevel_JComboBox() {
        this.setOpaque(true);
        gradeLevelDaoImpl = new GradeLevelDaoImpl();
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if(value instanceof Integer){
            int gradeLevelId = Integer.parseInt(value.toString().trim());
            Object valueToDisplay = getValueToDisplay(gradeLevelId);
            this.setText(String.valueOf(valueToDisplay).equals("0")?"Kindergarten" : String.valueOf(valueToDisplay));
        }else{
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
    
    private Object getValueToDisplay(int gradeLevelId) {
        GradeLevel gradeLevel = gradeLevelDaoImpl.getById(gradeLevelId);
        return gradeLevel.getLevelNo();
    }
    
}
