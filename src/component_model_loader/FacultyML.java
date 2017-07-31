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

/**
 *
 * @author John Ferdinand Antonio
 */
public class FacultyML {
    FacultyDaoImpl facultyDaoImpl = new FacultyDaoImpl();
    
    public DefaultTableModel getAllFaculty(){
        DefaultTableModel model = new DefaultTableModel();
        Object[] facultyList = facultyDaoImpl.getAll().toArray();
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
        List<Faculty> facultyList = facultyDaoImpl.getAll();
        String name;
        for (Faculty f : facultyList) {
            name = "("+f.getFacultyID()+")"+" "+f.getLastName().trim() + " " + f.getFirstName().trim() + " " + f.getMiddleName().trim();
            model.addElement(name);
        }
        model.setSelectedItem(null);
        return model;
    }
}
