package component_model_loader;

import daoimpl.SchoolYearDaoImpl;
import daoimpl.SectionDaoImpl;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.student.Student;

public class SectionJCompModelLoader {

    private final SectionDaoImpl sectionDaoImpl;

    public SectionJCompModelLoader() {
        sectionDaoImpl = new SectionDaoImpl();
    }

    public DefaultTableModel getAllSections(JTable jTable) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        tableModel.setRowCount(0);
        Object[] sectionList = sectionDaoImpl.getAllSections().toArray();
        for (Object o : sectionList) {
            Section s = (Section) o;
            Object[] rowData = {
                s.getSectionId(), s.getSectionName(), s.getGradeLevel().getLevelNo(),
                s.getAdviser().getLastName() + ", " + s.getAdviser().getFirstName() + " " + s.getAdviser().getMiddleName(),
                s.getSectionSession(), s.getSchoolYear().getYearFrom(),
                s.getIsActive() == true ? "Active" : "Inactive"
            };
            tableModel.addRow(rowData);
        }
        return tableModel;
    }

    public DefaultTableModel getSectionsByWildCard(JTextField jtfSearchBox, JTable jTable) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        tableModel.setRowCount(0);
        String wildCardChar = jtfSearchBox.getText().trim();
        Object[] sectionList = sectionDaoImpl.getSectionsByWildCard(wildCardChar).toArray();
        for (Object o : sectionList) {
            Section s = (Section) o;
            Object[] rowData = {
                s.getSectionId(), s.getSectionName(), s.getGradeLevel().getLevelNo(),
                s.getAdviser().getLastName() + ", " + s.getAdviser().getFirstName() + " " + s.getAdviser().getMiddleName(),
                s.getSectionSession(), s.getSchoolYear().getYearFrom(),
                s.getIsActive() == true ? "Yes" : "No"
            };
            tableModel.addRow(rowData);
        }
        return tableModel;
    }

    /**
     * Returns a DefaultTableModel containing sectionId, sectionName,
     * sectionGradeLevel level, sectionAdviser lastname, firstname, middlename,
     * session, schoolyear yearfrom, isactive properties of section. Record
     * returned are <b>active</b> sections of whatever the current schoolyear
     * is.
     *
     * @param jcmbGradeLevel is any JComboBox containing gradelevel level nos
     * @param jTable is any JTable to put the record in the DefaultTableModel
     * @return
     */
    public DefaultTableModel getSectionsOfCurrentSchoolYearByGradeLevelNo(JComboBox jcmbGradeLevel, JTable jTable) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        tableModel.setRowCount(0);
        SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
        int gradeLevelNo = Integer.parseInt(jcmbGradeLevel.getSelectedItem().toString().trim());
        int schoolYearId = schoolYearDaoImpl.getCurrentSchoolYearId();
        Object[] sectionList = sectionDaoImpl.getSectionsByGradeLevelNoAndSchoolYearId(gradeLevelNo, schoolYearId).toArray();
        for (Object o : sectionList) {
            Section s = (Section) o;
            Object[] rowData = {
                s.getSectionId(), s.getSectionName(), s.getGradeLevel().getLevelNo(),
                s.getAdviser().getLastName() + ", " + s.getAdviser().getFirstName() + " " + s.getAdviser().getMiddleName(),
                s.getSectionSession(), s.getSchoolYear().getYearFrom(),
                s.getIsActive() == true ? "Yes" : "No"
            };
            tableModel.addRow(rowData);
        }
        return tableModel;
    }

    public DefaultComboBoxModel getSectionsOfCurrentSchoolYearByGradeLevelNo(JComboBox jcmbGradeLevel) {
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
        int gradeLevelNo = Integer.parseInt(jcmbGradeLevel.getSelectedItem().toString().trim());
        int schoolYearId = schoolYearDaoImpl.getCurrentSchoolYearId();
        List<Section> sectionList = sectionDaoImpl.getSectionsByGradeLevelNoAndSchoolYearId(gradeLevelNo, schoolYearId);
        for (Section s : sectionList) {
            comboModel.addElement(s.getSectionId());
        }
        return comboModel;
    }

    public DefaultComboBoxModel getAllSectionsByStatusAndSchoolYearId(boolean status, int schoolYearId) {
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        List<Section> sectionList = sectionDaoImpl.getAllSectionsByStatusAndSchoolYearId(status, schoolYearId);
        for (Section s : sectionList) {
            comboModel.addElement(s.getSectionId());
        }
        return comboModel;
    }

    public DefaultTableModel getSectionStudentsBySectionIdAndSchoolYearId(JTable table, JComboBox jcmbSection, int schoolYearId) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        int sectionId = Integer.parseInt(jcmbSection.getSelectedItem().toString().trim());
        SchoolYear schoolYear = new SchoolYear();
        schoolYear.setSchoolYearId(schoolYearId);
        Section section = new Section();
        section.setSectionId(sectionId);
        section.setSchoolYear(schoolYear);
        List<Student> studentList = sectionDaoImpl.getSectionStudentsBySectionIdAndSchoolYearId(section);
        for (Student s : studentList) {
            Object[] rowData = {
                s.getStudentId(), s.getStudentNo(), s.getRegistration().getLastName(),
                s.getRegistration().getFirstName(), s.getRegistration().getMiddleName(),
                s.getStudentType() == 1 ? "New" : "Old", s.getGradeLevelNo()
            };
            tableModel.addRow(rowData);
        }
        return tableModel;
    }

    public DefaultComboBoxModel getSectionIdsOfSectionsWithNoSchedules(boolean status, int schoolyearId) {
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        List<Section> sectionList = sectionDaoImpl.getSectionsWithNoAssignedScheduleByStatusAndSchoolYearId(status, schoolyearId);
        for (Section s : sectionList) {
            comboModel.addElement(s.getSectionId());
        }
        comboModel.setSelectedItem(null);
        return comboModel;
    }

    public DefaultComboBoxModel getSectionIdsWithoutSchedule(boolean isActive, int schoolyearId, int gradeLevelId) {
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        List<Section> sectionList = sectionDaoImpl.getSectionsWithNoAssignedScheduleBy_Status_SchoolYearId_GradeLevelId(isActive, schoolyearId, gradeLevelId);
        for (Section s : sectionList) {
            comboModel.addElement(s.getSectionId());
        }
        comboModel.setSelectedItem(null);
        return comboModel;
    }
}
