/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_renderers;

import daoimpl.SectionDaoImpl;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import model.section.Section;

/**
 *
 * @author Jordan
 */
public class Renderer_Section_JComboBox extends JLabel implements ListCellRenderer<Object>{
    
    public Renderer_Section_JComboBox(){
        this.setOpaque(true);
    }
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if(value instanceof Integer){
            int sectionId = Integer.parseInt(value.toString());
            String valueToDisplay = getSectionName(sectionId);
            this.setText(valueToDisplay);
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
    
    private String getSectionName(int sectionId){
        SectionDaoImpl sectionDaoImpl = new SectionDaoImpl();
        Section s = sectionDaoImpl.getSectionById(sectionId);
        String sectionName = s.getSectionName();
        return sectionName;
    }
    
}
