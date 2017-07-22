/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_model_loader;

import daoimpl.SubjectDaoImpl;
import javax.swing.DefaultComboBoxModel;
import model.subject.Subject;

/**
 *
 * @author John Ferdinand Antonio
 */
public class SbjML {
    SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
    public DefaultComboBoxModel getSubjectNames(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] subjectList = subjectDaoImpl.getAllSubjects().toArray();
        for(Object o : subjectList){
            Subject s = (Subject)o;
            String subjectName = s.getSubjectTitle();
            model.addElement(subjectName);
        }
        return model;
    }
}
