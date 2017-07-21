/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_model_loader;

import daoimpl.SectionDaoImpl;
import javax.swing.DefaultComboBoxModel;
import model.Section;

/**
 *
 * @author John Ferdinand Antonio
 */
public class SctnML {
    SectionDaoImpl sectionDaoImpl = new SectionDaoImpl();
    
    public DefaultComboBoxModel getAllSectionNames() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] sectionList = sectionDaoImpl.getAllSections().toArray();
        for(Object o : sectionList){
            Section s = (Section)o;
            String sectionName = s.getSectionName();
            model.addElement(sectionName);
        }
        return model;
    }
}
