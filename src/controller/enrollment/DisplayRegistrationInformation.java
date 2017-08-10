/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.enrollment;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import view.registration.UpdateRegistration;

/**
 *
 * @author John Ferdinand Antonio
 */
public class DisplayRegistrationInformation implements MouseListener{

    private final JTable jtblRegistrationList;
    
    public DisplayRegistrationInformation(JTable jtblRegistrationList){
        this.jtblRegistrationList = jtblRegistrationList;
    }
    
    private void displayRegistrationInfo(){
        int rowSelected = jtblRegistrationList.getSelectedRow();
            int colRegistrationId = 0;
            String registrationIdStr = jtblRegistrationList.getValueAt(rowSelected, colRegistrationId).toString();
            int registrationId = Integer.parseInt(registrationIdStr);
            UpdateRegistration registrationInfo = new UpdateRegistration(registrationId);
            registrationInfo.setLocationRelativeTo(null);
            registrationInfo.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            displayRegistrationInfo();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
}
