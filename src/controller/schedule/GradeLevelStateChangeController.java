/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.schedule;

import daoimpl.GradeLevelDaoImpl;
import daoimpl.SectionDaoImpl;
import daoimpl.SubjectDaoImpl;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import model.gradelevel.GradeLevel;
import model.section.Section;
import model.subject.Subject;

/**
 *
 * @author John Ferdinand Antonio
 */
public class GradeLevelStateChangeController implements ItemListener {

    private final JComboBox jcmbGradeLevel;
    private final JComboBox jcmbSections;
    private final JComboBox jcmbSubjects;

    public GradeLevelStateChangeController(JComboBox jcmbGradeLevel, JComboBox jcmbSections, JComboBox jcmbSubjects) {
        this.jcmbGradeLevel = jcmbGradeLevel;
        this.jcmbSections = jcmbSections;
        this.jcmbSubjects = jcmbSubjects;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (jcmbGradeLevel.getSelectedIndex() > -1) {
            GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
            String level = jcmbGradeLevel.getSelectedItem().toString().trim();
            int gradeLevelId = gldi.getId(Integer.parseInt(level));
            GradeLevel gradeLevel = new GradeLevel();
            gradeLevel.setId(gradeLevelId);

            jcmbSections.setModel(getGradeLevelSections(gradeLevel));
            jcmbSections.setEnabled(true);
            jcmbSubjects.setModel(getGradeLevelSubjects(gradeLevel));
            jcmbSubjects.setEnabled(true);
        }
    }
    
    private DefaultComboBoxModel getGradeLevelSubjects(GradeLevel g){
        SubjectDaoImpl sbjDaoImpl = new SubjectDaoImpl();
        List<Subject> subjectList = sbjDaoImpl.getAllSubjectsByGradeLevelId(g);
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(Subject s : subjectList){
            model.addElement(s.getSubjectTitle().trim());
        }
        model.setSelectedItem(null);
        return model;
    }
    
    private DefaultComboBoxModel getGradeLevelSections(GradeLevel g){
        SectionDaoImpl sdi = new SectionDaoImpl();
        DefaultComboBoxModel sectionModel = new DefaultComboBoxModel();
        List<Section> sections = sdi.getAllSectionsByGradeLevelId(g);
        for (Section s : sections) {
            sectionModel.addElement(s.getSectionName().trim());
        }
        sectionModel.setSelectedItem(null);
        return sectionModel;
    }
}
