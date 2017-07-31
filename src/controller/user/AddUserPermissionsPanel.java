/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import view.user.UserPermissions;

/**
 *
 * @author John Ferdinand Antonio
 */
public class AddUserPermissionsPanel implements ItemListener{

    private final JComboBox jcmbUserRole;
    private final JPanel jpnlInfo;
    
    public AddUserPermissionsPanel(JComboBox jcmbUserRole,JPanel jpnlInfo){
        this.jcmbUserRole = jcmbUserRole;
        this.jpnlInfo = jpnlInfo;
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (jcmbUserRole.getSelectedIndex() > -1) {
            UserPermissions userPermission = new UserPermissions();
            GridBagConstraints gc = new GridBagConstraints();
            gc.fill = GridBagConstraints.BOTH;
            gc.gridx = 1;
            gc.gridy = 3;
            jpnlInfo.add(userPermission, gc);
            
        }
        
    }
}

   

