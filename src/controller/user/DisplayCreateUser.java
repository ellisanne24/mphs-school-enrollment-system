/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.user.UserInfo;

/**
 *
 * @author John Ferdinand Antonio
 */
public class DisplayCreateUser implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        UserInfo userInfo = new UserInfo(null, true);
        userInfo.setTitle("Create User");
        userInfo.setPreferredSize(new Dimension(450,450));
        userInfo.pack();
        userInfo.setLocationRelativeTo(null);
        userInfo.setVisible(true);
    }
    
}
