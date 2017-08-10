/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.enrollment;

import component_model_loader.StudentML;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author John Ferdinand Antonio
 */
public class FilterStudentRecordBtStatus implements ActionListener{
    private final JTable jtblStudentsList;
    private DefaultTableModel studentTableModel;
    private StudentML studentML;
    private final JComboBox jcmbStatus;
    
    public FilterStudentRecordBtStatus(JTable jtblStudentsList, JComboBox jcmbStatus){
        initModels();
        this.jtblStudentsList = jtblStudentsList;
        this.jcmbStatus = jcmbStatus;
    }
    
    private void initModels(){
        studentML = new StudentML();
        studentTableModel = new DefaultTableModel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean inactive = jcmbStatus.getSelectedItem().toString().equals("Inactive");
        boolean active = jcmbStatus.getSelectedItem().toString().equals("Active");

        if(active ){
           loadActiveStudents();
        }else if(inactive){
            loadInactiveStudents();
        }
    }
    
    private void loadActiveStudents(){
        studentTableModel = studentML.getAllActiveStudentsOfCurrentSchoolYear(jtblStudentsList);
        jtblStudentsList.setModel(studentTableModel);
    }
    
    private void loadInactiveStudents(){
        studentTableModel = studentML.getAllInactiveStudents(jtblStudentsList);
        jtblStudentsList.setModel(studentTableModel);
    }
    
    
}
