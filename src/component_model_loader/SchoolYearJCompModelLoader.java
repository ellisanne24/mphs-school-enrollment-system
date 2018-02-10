
package component_model_loader;

import daoimpl.SchoolYearDaoImpl;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.schoolyear.SchoolYear;

/**
 *
 * @author John Ferdinand Antonio
 */
public class SchoolYearJCompModelLoader {

    // HAS A
    private final SchoolYearDaoImpl schoolYearDaoImpl;
    
    public SchoolYearJCompModelLoader(){
        schoolYearDaoImpl = new SchoolYearDaoImpl();
    }

    public DefaultTableModel getAllSchoolYearInfo(JTable jTable) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        Object[] schoolYearList = schoolYearDaoImpl.getAllSchoolYearInfo().toArray();
        for (Object o : schoolYearList) {
            SchoolYear sy = (SchoolYear) o;
            Object[] rowData = {
                sy.getSchoolYearId(),
                sy.getYearFrom() + " - " + sy.getYearTo(),
                sy.getSchoolYearStartDate(),
                sy.getSchoolYearEndDate(),
                sy.getRegularEnrollmentStartDate(), 
                sy.getRegularEnrollmentEndDate(),
                sy.getSummerEnrollmentStartDate(), 
                sy.getSummerEnrollmentEndDate(),
                sy.getSummerClassStartDate(), 
                sy.getSummerClassEndDate(),
                sy.getIsActive() == true ? "Active" : "Inactive",};
            tableModel.addRow(rowData);
        }
        return tableModel;
    }
    
    public DefaultComboBoxModel getCurrentSchoolYearFrom() {
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        SchoolYear schoolYear = schoolYearDaoImpl.getCurrentSchoolYear();
        comboModel.addElement(schoolYear.getYearFrom());
        comboModel.setSelectedItem(null);
        return comboModel;
    }

    public DefaultComboBoxModel getCurrentSchoolYearTo() {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        SchoolYear schoolYear = schoolYearDaoImpl.getCurrentSchoolYear();
        dcm.addElement(schoolYear.getYearTo());
        dcm.setSelectedItem(null);
        return dcm;
    }

    public DefaultComboBoxModel getAllSchoolYearStart() {
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        List<SchoolYear> schoolYearList = schoolYearDaoImpl.getAllYearFrom();
        for (SchoolYear s : schoolYearList) {
            comboModel.addElement(s.getYearFrom());
        }
        return comboModel;
    }

    public DefaultComboBoxModel getAllSchoolYearEnd() {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        List<SchoolYear> syList = schoolYearDaoImpl.getAllYearTo();
        Object[] oArr = syList.toArray();
        for (Object o : oArr) {
            SchoolYear s = (SchoolYear) o;
            dcm.addElement(s.getYearTo());
        }
        return dcm;
    }
    
    public DefaultComboBoxModel getCurrentSchoolYearId() {
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        SchoolYear schoolYear = schoolYearDaoImpl.getCurrentSchoolYear();
        comboModel.addElement(schoolYear.getSchoolYearId());
        return comboModel;
    }
}
