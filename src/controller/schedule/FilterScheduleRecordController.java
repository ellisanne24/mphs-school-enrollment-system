/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.schedule;

import component_model_loader.ScheduleML;
import daoimpl.SbjDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utility.string.StringUtil;

/**
 *
 * @author John Ferdinand Antonio
 */
public class FilterScheduleRecordController {

    private ItemListener schoolYearFromChange;
    private ItemListener subjectChange;
    private ItemListener facultyChange;
    

    private final JComboBox jcmbSchoolYearFrom;
    private final JComboBox jcmbSubject;
    private final JTable jtblScheduleRecord;
    private final JCheckBox jcbAllSubjects;
    private final JComboBox jcmbFaculty;

    public FilterScheduleRecordController(
            JComboBox jcmbSchoolYearFrom, JComboBox jcmbSubject, 
            JTable jtblScheduleRecord, JCheckBox jcbAllSubjects,
            JComboBox jcmbFaculty) {
        this.jcmbSchoolYearFrom = jcmbSchoolYearFrom;
        this.jcmbSubject = jcmbSubject;
        this.jtblScheduleRecord = jtblScheduleRecord;
        this.jcbAllSubjects = jcbAllSubjects;
        this.jcmbFaculty = jcmbFaculty;
    }

    public void control() {
        SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
        SbjDaoImpl sbjDaoImpl = new SbjDaoImpl();

        schoolYearFromChange = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (jcmbSubject.getSelectedIndex() == -1 && jcmbSchoolYearFrom.getSelectedIndex() > -1) {
                    int schoolyearId = schoolYearDaoImpl.getId(Integer.parseInt(jcmbSchoolYearFrom.getSelectedItem().toString()));
                    DefaultTableModel model = new ScheduleML().getAllBySchoolYearId(schoolyearId, jtblScheduleRecord);
                    jtblScheduleRecord.setModel(model);
                } else {
                    String subjectName = jcmbSubject.getSelectedItem().toString();
                    int subjectId = sbjDaoImpl.getId(subjectName);
                    int schoolyearId = schoolYearDaoImpl.getId(Integer.parseInt(jcmbSchoolYearFrom.getSelectedItem().toString()));
                    DefaultTableModel model = new ScheduleML().getAll(subjectId, schoolyearId, jtblScheduleRecord);
                    jtblScheduleRecord.setModel(model);
                }
            }
        };
        jcmbSchoolYearFrom.addItemListener(schoolYearFromChange);

        subjectChange = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String subjectName = jcmbSubject.getSelectedItem().toString();
                int subjectId = sbjDaoImpl.getId(subjectName);
                int schoolyearId = schoolYearDaoImpl.getId(Integer.parseInt(jcmbSchoolYearFrom.getSelectedItem().toString()));
                DefaultTableModel model = new ScheduleML().getAll(subjectId, schoolyearId, jtblScheduleRecord);
                jtblScheduleRecord.setModel(model);
            }
        };
        jcmbSubject.addItemListener(subjectChange);
        
        facultyChange = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int schoolyearId = schoolYearDaoImpl.getId(Integer.parseInt(jcmbSchoolYearFrom.getSelectedItem().toString()));
                String cleansedFacultyId = StringUtil.getNumbers(jcmbFaculty.getSelectedItem().toString().trim());
                int facultyId = Integer.parseInt(cleansedFacultyId.trim());
                DefaultTableModel model = new ScheduleML().getByFacultyId(facultyId, schoolyearId, jtblScheduleRecord);
                jtblScheduleRecord.setModel(model);
            }
        };
        jcmbFaculty.addItemListener(facultyChange);
    }
}
