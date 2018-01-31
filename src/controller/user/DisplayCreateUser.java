/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import component_model_loader.RolesJCompModelLoader;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import view.user.UserInfo;

/**
 *
 * @author John Ferdinand Antonio
 */
public class DisplayCreateUser implements ActionListener{

    private final RolesJCompModelLoader rolesML;
    
    public DisplayCreateUser(){
        rolesML = new RolesJCompModelLoader();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultComboBoxModel rolesComboModel = rolesML.getAllRoleNames();
        
        UserInfo userInfo = new UserInfo(null,true,rolesComboModel);
        userInfo.setTitle("Create User");
        userInfo.setPreferredSize(new Dimension(450,450));
        userInfo.pack();
        userInfo.setLocationRelativeTo(null);
        userInfo.setVisible(true);
    }
    
}
