/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_model_loader;

import daoimpl.FacultyDaoImpl;
import javax.swing.JOptionPane;
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
        Object[] facultyList = facultyDaoImpl.getAllFaculty().toArray();
        JOptionPane.showMessageDialog(null,"Faculty Size: "+facultyList.length);
        String[]columns = {"Faculty Id","Middle Name","First Name","Middle Name"};
        model.setColumnIdentifiers(columns);
        for(Object o: facultyList){
            Faculty f = (Faculty)o;
//            JOptionPane.showMessageDialog(null,"Faculty Id: "+f.getFacultyID());
            model.addRow(new Object[]{f.getFacultyID(),f.getLastName(),f.getFirstName(),f.getMiddleName()});
        }
        return model;
    }
}
