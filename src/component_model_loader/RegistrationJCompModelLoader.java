package component_model_loader;

import daoimpl.RegistrationDaoImpl;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.registration.Registration;

/**
 *
 * @author Jordan
 */
public class RegistrationJCompModelLoader {
    private final RegistrationDaoImpl registrationDaoImpl;
    
    public RegistrationJCompModelLoader(){
        registrationDaoImpl = new RegistrationDaoImpl();
    }
    
    public DefaultTableModel getAllRegistrationInfoByAdmissionStatus(JComboBox jcmbAdmissionStatus, JTable jTable) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        tableModel.setRowCount(0);
        int admissionStatus = jcmbAdmissionStatus.getSelectedItem().toString().equalsIgnoreCase("Complete") ? 1 : 0;
        Object[] registrationList = registrationDaoImpl.getAllRegistrationInfoByAdmissionStatus(admissionStatus).toArray();
        for (Object o : registrationList) {
            Registration r = (Registration) o;
            Object[] rowData = {
                r.getRegistrationId(),
                r.getLastName(),
                r.getFirstName(),
                r.getMiddleName(),
                r.getGradeLevelNo() == 0 ? "Kindergarten" : r.getGradeLevelNo(),
                r.getRegistrationDate(),
                r.getIsAdmissionComplete() == true ? "Completed" : "Pending"
            };
            tableModel.addRow(rowData);
        }
        return tableModel;
    }
    
    public DefaultTableModel getAllRegisteredApplicants(int yearFrom, JTable jTable){
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        tableModel.setRowCount(0);
        Object[] registrationList = registrationDaoImpl.getAllRegistrationInfoBySyYearFrom(yearFrom).toArray();
        for (Object o : registrationList) {
            Registration r = (Registration) o;
            Object[] rowData = {
                r.getRegistrationId(),
                r.getLastName(),
                r.getFirstName(),
                r.getMiddleName(),
                r.getGradeLevelNo() == 0 ? "Kindergarten" : r.getGradeLevelNo(),
                r.getRegistrationDate(),
                r.getIsAdmissionComplete() == true? "Completed" : "Pending"
            };
            tableModel.addRow(rowData);
        }
        return tableModel;
    }
    
    public DefaultTableModel getAllRegisteredApplicantsByKeyword(JTextField jtfSearchBox,JTable jTable){
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        tableModel.setRowCount(0);
        Object[] registrationList = registrationDaoImpl.getAllRegistrationInfoByWildCard(jtfSearchBox.getText().trim()).toArray();
        for (Object o : registrationList) {
            Registration r = (Registration) o;
            Object[] rowData = {
                r.getRegistrationId(),
                r.getLastName(),
                r.getFirstName(),
                r.getMiddleName(),
                r.getGradeLevelNo() == 0 ? "Kindergarten" : r.getGradeLevelNo(),
                r.getRegistrationDate(),
                r.getIsAdmissionComplete() == true? "Completed" : "Pending"
            };
            tableModel.addRow(rowData);
        }
        return tableModel;
    }
}
