/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.reports;

import daoimpl.SectionDaoImpl;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.student.Student;
import view.reports.Panel_Reports;

/**
 *
 * @author Jordan
 */
public class Controller_Reports_ClassList_Section_JComboBox implements ItemListener{
    
    private final Panel_Reports view;
    private final SectionDaoImpl sectionDaoImpl;

    public Controller_Reports_ClassList_Section_JComboBox(Panel_Reports view) {
        this.view = view;
        this.sectionDaoImpl = new SectionDaoImpl();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == view.getJcmbClassListSecttion()){
            if(view.getJcmbClassListSecttion().getSelectedIndex() > -1){
                view.clearClassList();
                
                Section section = (Section)view.getJcmbClassListSecttion().getSelectedItem();
                view.getJlblClassListAdviserName().setText(section.getAdviser().getLastName()+", "+section.getAdviser().getFirstName());
                view.getJlblClassListGradeLevelText().setText(section.getGradeLevel().getLevelNo() == 0? "Kindergarten": section.getGradeLevel().getLevelNo()+"");
                view.getJlblClassListSectionName().setText(section.getSectionName());

                SchoolYear schoolYear  = (SchoolYear) view.getJcmbCorSchoolYear().getSelectedItem();
                view.getJlblClassListSchoolYear().setText(schoolYear.getYearFrom()+"-"+schoolYear.getYearTo());
                section.setSchoolYear(schoolYear);
                
                List<Student> studentList = sectionDaoImpl.getSectionStudentsBySectionIdAndSchoolYearId(section);
                DefaultTableModel tableModel = (DefaultTableModel) view.getJtblClassList().getModel();
                tableModel.setRowCount(0);
                int count = 1;
                for (Student s : studentList) {
                    Object[] rowData = {
                        count, s.getStudentNo(), s.getRegistration().getLastName(),
                        s.getRegistration().getFirstName(), s.getRegistration().getMiddleName()
                    };
                    tableModel.addRow(rowData);
                    count++;
                }
                view.getJcmbClassListSchoolYear().setEnabled(true);
            }
        }
    }
}
