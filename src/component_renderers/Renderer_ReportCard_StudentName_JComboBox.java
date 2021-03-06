/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_renderers;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import model.student.Student;

/**
 *
 * @author Jordan
 */
public class Renderer_ReportCard_StudentName_JComboBox extends JLabel implements ListCellRenderer<Object>{

    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if(value instanceof Student){
            Student student = (Student)value;
            this.setText(""+student.getRegistration().getLastName()+", "+student.getRegistration().getFirstName()+" "+student.getRegistration().getMiddleName());
        }else {
            this.setText("SELECT");
        }
        return this;
    }
    
    
    
}
