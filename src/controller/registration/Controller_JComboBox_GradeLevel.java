
package controller.registration;

import daoimpl.CredentialDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.credential.Credential;
import model.gradelevel.GradeLevel;
import view.registration.View_Panel_Registration;

/**
 *
 * @author Jordan
 */
public class Controller_JComboBox_GradeLevel implements ItemListener{
    
    private final View_Panel_Registration view;
    private final GradeLevelDaoImpl gradeLevelDaoImpl;
    private final CredentialDaoImpl credentialDaoImpl;

    public Controller_JComboBox_GradeLevel(View_Panel_Registration view) {
        this.view = view;
        gradeLevelDaoImpl = new GradeLevelDaoImpl();
        credentialDaoImpl = new CredentialDaoImpl();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == view.getJcmbGradeLevel()){
            JComboBox combo = view.getJcmbGradeLevel();
            if(view.getJcmbGradeLevel().getSelectedIndex() > -1){
                if(combo.getSelectedItem() instanceof Integer){
                    int gradeLevelNo = Integer.parseInt(combo.getSelectedItem().toString());
                    int gradeLevelId = gradeLevelDaoImpl.getId(gradeLevelNo);
                    GradeLevel gradeLevel = gradeLevelDaoImpl.getById(gradeLevelId);
                    loadCredentialCheckBoxBy(gradeLevel);
                }
            }
        }
    }
    
    
    private void loadCredentialCheckBoxBy(GradeLevel gradeLevel) {
        List<Credential> credentialList = credentialDaoImpl.getCredentialsBy(gradeLevel);
        GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(3, 3, 3, 3), 0, 0);
        for (Credential c : credentialList) {
            JCheckBox checkBox = new JCheckBox(c.getCredentialName().trim());
            checkBox.setText(c.getCredentialName());
            view.getJpnlCredentials().add(checkBox, gbc);
            view.getJpnlCredentials().revalidate();
            gbc.gridy++;
        }
    }
}
