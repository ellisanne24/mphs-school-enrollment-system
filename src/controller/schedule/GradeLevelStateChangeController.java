/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.schedule;

import component_editor.ScheduleSubjectCellEditor;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.SectionDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import model.gradelevel.GradeLevel;
import model.section.Section;

/**
 *
 * @author John Ferdinand Antonio
 */
public class GradeLevelStateChangeController implements ItemListener {

    private final JComboBox jcmbGradeLevel;
    private final JComboBox jcmbSections;
    private final JTable jtblSchedule;
    private final JButton jbtnRemoveEntry;

    public GradeLevelStateChangeController(JTable jtblSchedule,JComboBox jcmbGradeLevel, JComboBox jcmbSections, JButton jbtnRemoveEntry) {
        this.jcmbGradeLevel = jcmbGradeLevel;
        this.jcmbSections = jcmbSections;
        this.jtblSchedule = jtblSchedule;
        this.jbtnRemoveEntry = jbtnRemoveEntry;
        
        jbtnRemoveEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int [] rowsToDel = jtblSchedule.getSelectedRows();
                for(int i : rowsToDel){
                    DefaultTableModel model = (DefaultTableModel)jtblSchedule.getModel();
                    model.removeRow(i);
                }
            }
        });
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (jcmbGradeLevel.getSelectedIndex() > -1) {
            GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
            String level = jcmbGradeLevel.getSelectedItem().toString().trim();
            int gradeLevelId = gldi.getId(Integer.parseInt(level));
            GradeLevel gradeLevel = new GradeLevel();
            gradeLevel.setId(gradeLevelId);

            clearScheduleTableModel();
            enableScheduleTable();
            TableColumnModel columnModel = jtblSchedule.getColumnModel();
            TableColumn subjectColumn = columnModel.getColumn(3);
            subjectColumn.setCellEditor(new ScheduleSubjectCellEditor(jtblSchedule,gradeLevelId));
            
            jcmbSections.setModel(getGradeLevelSections(gradeLevel));
            jcmbSections.setEnabled(true);
        }
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
    
    private void enableScheduleTable(){
        jtblSchedule.setEnabled(true);
    }
    
    private void clearScheduleTableModel(){
        DefaultTableModel model = (DefaultTableModel)jtblSchedule.getModel();
        model.setRowCount(0);
    }
}
