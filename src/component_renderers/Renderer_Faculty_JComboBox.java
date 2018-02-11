/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_renderers;

import daoimpl.FacultyDaoImpl;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import model.faculty.Faculty;

/**
 *
 * @author Jordan
 */
public class Renderer_Faculty_JComboBox extends JLabel implements ListCellRenderer<Object>{

    public Renderer_Faculty_JComboBox(){
        this.setOpaque(true);
    }
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if(value instanceof Integer){
            int facultyId = Integer.parseInt(value.toString());
            String valueToDisplay = getFacultyCompleteName(facultyId);
            this.setText(valueToDisplay);
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
    
    private String getFacultyCompleteName(int facultyId) {
        FacultyDaoImpl facultyDaoImpl = new FacultyDaoImpl();
        Faculty f = facultyDaoImpl.getFacultyById(facultyId);
        StringBuilder sb = new StringBuilder();
        sb.append(f.getLastName());
        sb.append(", ");
        sb.append(f.getFirstName() + " ");
        sb.append(f.getMiddleName());
        return sb.toString();
    }
    
    
}