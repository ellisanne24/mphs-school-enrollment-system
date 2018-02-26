/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.reports;

import component_model_loader.SectionJCompModelLoader;
import daoimpl.GradeLevelDaoImpl;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import view.reports.Panel_Reports;

/**
 *
 * @author Jordan
 */
public class Controller_Reports_ClassList_GradeLevel_JComboBox implements ItemListener{
    
    private final Panel_Reports view;
    private final GradeLevelDaoImpl gradeLevelDaoImpl; 
    private final SectionJCompModelLoader sectionJCompModelLoader;

    public Controller_Reports_ClassList_GradeLevel_JComboBox(Panel_Reports view) {
        this.view = view;
        this.gradeLevelDaoImpl = new GradeLevelDaoImpl();
        this.sectionJCompModelLoader = new SectionJCompModelLoader();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == view.getJcmbClassListGradeLevel()){
            if(view.getJcmbClassListGradeLevel().getSelectedIndex() > -1){
                DefaultComboBoxModel comboModel = sectionJCompModelLoader.getSectionsByGradeLevelNo(view.getJcmbClassListGradeLevel());
                view.getJcmbClassListSecttion().setModel(comboModel);
                view.getJcmbClassListSecttion().setEnabled(true);
                view.getJcmbClassListSchoolYear().setEnabled(false);
            }
        }
    }
    
}
