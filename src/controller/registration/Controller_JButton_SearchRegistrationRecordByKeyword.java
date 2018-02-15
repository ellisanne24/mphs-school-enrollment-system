package controller.registration;

import component_model_loader.RegistrationJCompModelLoader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jordan
 */
public class Controller_JButton_SearchRegistrationRecordByKeyword implements ActionListener{
    
    private RegistrationJCompModelLoader registrationJCompModelLoader;
    
    private final JTextField jtfSearchRegistered;
    private final JTable jtblRegisteredMasterList;

    public Controller_JButton_SearchRegistrationRecordByKeyword(JTextField jtfSearchRegistered, JTable jtblRegisteredMasterList) {
        this.jtfSearchRegistered = jtfSearchRegistered;
        this.jtblRegisteredMasterList = jtblRegisteredMasterList;
        registrationJCompModelLoader = new RegistrationJCompModelLoader();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        displayRecord();
    }
    
    private void displayRecord(){
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel = registrationJCompModelLoader.getAllRegisteredApplicantsByKeyword(jtfSearchRegistered, jtblRegisteredMasterList);
        jtblRegisteredMasterList.setModel(tableModel);
    }
    
}
