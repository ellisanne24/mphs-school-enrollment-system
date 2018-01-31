package component_model_loader;

import daoimpl.SectionDaoImpl;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.section.Section;


public class SectionJCompModelLoader {
    private final SectionDaoImpl sectionDaoImpl;
    
    public SectionJCompModelLoader(){
        sectionDaoImpl = new SectionDaoImpl();
    }
    
    public DefaultTableModel getAllSections(JTable jTable) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        tableModel.setRowCount(0);
        Object[] sectionList = sectionDaoImpl.getAllSections().toArray();
        for (Object o : sectionList) {
            Section s = (Section) o;
            Object[] rowData = {
                s.getSectionId(), s.getSectionName(), s.getGradeLevel().getLevel(),
                "edit this code once faculty module is completed",
                s.getSectionSession(), s.getSchoolYear().getYearFrom(),
                s.getIsActive() == true ? "Yes" : "No"
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
                s.getSectionId(), s.getSectionName(), s.getGradeLevel().getLevel(),
                "edit this code once faculty module is completed",
                s.getSectionSession(), s.getSchoolYear().getYearFrom(),
                s.getIsActive() == true ? "Yes" : "No"
            };
            tableModel.addRow(rowData);
        }
        return tableModel;
    }
    
    public DefaultTableModel getSectionsByGradeLevelNo(JComboBox jcmbGradeLevel, JTable jTable) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        tableModel.setRowCount(0);
        int gradeLevelNo = Integer.parseInt(jcmbGradeLevel.getSelectedItem().toString().trim());
        Object[] sectionList = sectionDaoImpl.getSectionsByGradeLevelNo(gradeLevelNo).toArray();
        for (Object o : sectionList) {
            Section s = (Section) o;
            Object[] rowData = {
                s.getSectionId(), s.getSectionName(), s.getGradeLevel().getLevel(),
                "edit this code once faculty module is completed",
                s.getSectionSession(), s.getSchoolYear().getYearFrom(),
                s.getIsActive() == true ? "Yes" : "No"
            };
            tableModel.addRow(rowData);
        }
        return tableModel;
    }

}
