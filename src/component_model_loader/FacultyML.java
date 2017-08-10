/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_model_loader;

import daoimpl.FacultyDaoImpl;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.faculty.Faculty;
import model.section.Section;
import model.user.User;

/**
 *
 * @author John Ferdinand Antonio
 */
public class FacultyML {
    FacultyDaoImpl fdi = new FacultyDaoImpl();
    
    public DefaultTableModel getAllFaculty(){
        DefaultTableModel model = new DefaultTableModel();
        Object[] facultyList = fdi.getAll().toArray();
        String[]columns = {"Faculty Id","Middle Name","First Name","Middle Name"};
        model.setColumnIdentifiers(columns);
        for(Object o: facultyList){
            Faculty f = (Faculty)o;
            model.addRow(new Object[]{f.getFacultyID(),f.getLastName(),f.getFirstName(),f.getMiddleName()});
        }
        return model;
    }
    
    public DefaultComboBoxModel getAllFacultyNames() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        List<Faculty> facultyList = fdi.getAll();
        String name;
        for (Faculty f : facultyList) {
            name = "("+f.getFacultyID()+")"+" "+f.getLastName().trim() + " " + f.getFirstName().trim() + " " + f.getMiddleName().trim();
            model.addElement(name);
        }
        model.setSelectedItem(null);
        return model;
    }
    
    // To be edited. Supply facultyId who's currently logged in.
    public DefaultComboBoxModel getAllFacultySectionByFacultyId(User user) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] obj = fdi.getAllFacultySectionByFacultyId(user).toArray();
        for (Object o : obj) {
            Section section = (Section) o;
            model.addElement(section.getSectionName());
        }

        return model;
    }
    
    public DefaultComboBoxModel getAllFacultyName()
    {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] obj = fdi.getAllFaculty().toArray();

        for(Object o : obj)
        {
            Faculty faculty = (Faculty) o;
            
            model.addElement(faculty.getFirstName() + " " + faculty.getMiddleName() + ". " + faculty.getLastName());
        }
        return model;
    }
    
    public DefaultComboBoxModel getAllFacultyNameWithAssigned(String name)
    {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] obj = fdi.getAllFaculty().toArray();

        model.addElement(name);
        
        for(Object o : obj)
        {
            Faculty faculty = (Faculty) o;
            
            model.addElement(faculty.getFirstName() + " " + faculty.getMiddleName() + ". " + faculty.getLastName());
        }
        
        return model;
    }
}
