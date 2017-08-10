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
    private final JTable jtblScheduleRecord;
    private final JComboBox jcmbFaculty;

    public FilterScheduleRecordController(
            JComboBox jcmbSchoolYearFrom, 
            JTable jtblScheduleRecord, 
            JComboBox jcmbFaculty) {
        this.jcmbSchoolYearFrom = jcmbSchoolYearFrom;
        this.jtblScheduleRecord = jtblScheduleRecord;
        this.jcmbFaculty = jcmbFaculty;
    }

    public void control() {
        SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
        SbjDaoImpl sbjDaoImpl = new SbjDaoImpl();

        schoolYearFromChange = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (jcmbSchoolYearFrom.getSelectedIndex() > -1) {
                    
                } else {
                    
                }
            }
        };
        jcmbSchoolYearFrom.addItemListener(schoolYearFromChange);

        subjectChange = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                
            }
        };
        
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
