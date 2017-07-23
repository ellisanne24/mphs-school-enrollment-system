/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.faculty;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author John Ferdinand Antonio
 */
public class AssignSpecializationController implements ActionListener{

    private final JComboBox jcmbSpecialization;
    private final JList jlstFacultySpecializations;
    private final DefaultListModel listModel;
    
    public AssignSpecializationController(JComboBox jcmbSpecialization, JList jlstFacultySpecializations){
        this.jcmbSpecialization = jcmbSpecialization;
        this.jlstFacultySpecializations = jlstFacultySpecializations;
        listModel = new DefaultListModel();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        addFacultySpecialization();
        jlstFacultySpecializations.setModel(listModel);
    }
    
    private void addFacultySpecialization(){
        String specialization = jcmbSpecialization.getSelectedItem().toString().trim();
        if (listModel.contains(specialization)) {
            JOptionPane.showMessageDialog(null, specialization + " already assigned.");
        } else {
            listModel.addElement(specialization);
        }
    }
}
