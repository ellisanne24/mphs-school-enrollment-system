/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.faculty;

import daoimpl.FacultyDaoImpl;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.faculty.Faculty;
import view.faculty.Dialog_FacultyAdd;

/**
 *
 * @author franc
 */
public class AddFacultyDialogListener implements ActionListener{
    private Dialog_FacultyAdd facultyAdd;
    private Faculty faculty = new Faculty();
    private FacultyDaoImpl fdi = new FacultyDaoImpl();
    
    public AddFacultyDialogListener(Dialog_FacultyAdd facultyAdd){
        this.facultyAdd = facultyAdd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource().equals(facultyAdd.getBtnSaveNew())){
           JOptionPane.showMessageDialog(null,"Test");
           faculty.setLastName(facultyAdd.getTfLastname().getText().trim());
           faculty.setFirstName(facultyAdd.getTfFirstname().getText().trim());
           faculty.setMiddleName(facultyAdd.getTfMiddlename().getText().trim());
           faculty.setEmail(facultyAdd.getTfEmail().getText().trim());
           faculty.setContactNo(facultyAdd.getTfContact().getText().trim());
           
           fdi.createFaculty(faculty);
       }
    }
}
