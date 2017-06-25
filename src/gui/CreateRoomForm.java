/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JOptionPane;
import daoimpl.RoomDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Acer
 */
public class CreateRoomForm extends javax.swing.JPanel {

    /**
     * Creates new form AddRoom
     */
    public CreateRoomForm() {
        initComponents();
        SchoolYearDaoImpl sy = new SchoolYearDaoImpl();
        
//        yearFromJcbx.setModel(sy.getAllSchoolYearStart());
//        yearToJcbx.setModel(sy.getAllSchoolYearEnd());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        cancelAddRoomJbtn = new javax.swing.JButton();
        addRoomJbtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        roomNameOrNoJtf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        roomCapacityJtf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        buildingNameOrNoJtf = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        yearFromJcbx = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        yearToJcbx = new javax.swing.JComboBox<>();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        cancelAddRoomJbtn.setText("Cancel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(cancelAddRoomJbtn, gridBagConstraints);

        addRoomJbtn.setText("Add");
        addRoomJbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomJbtnActionPerformed(evt);
            }
        });
        jPanel1.add(addRoomJbtn, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jPanel1, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Room Number / Name :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jLabel1, gridBagConstraints);

        roomNameOrNoJtf.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(roomNameOrNoJtf, gridBagConstraints);

        jLabel2.setText("Capacity :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jLabel2, gridBagConstraints);

        roomCapacityJtf.setColumns(5);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(roomCapacityJtf, gridBagConstraints);

        jLabel5.setText("Building Number / Name :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jLabel5, gridBagConstraints);

        buildingNameOrNoJtf.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(buildingNameOrNoJtf, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jPanel2, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("School Year");
        jPanel3.add(jLabel3, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(yearFromJcbx, gridBagConstraints);

        jLabel4.setText("to");
        jPanel3.add(jLabel4, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(yearToJcbx, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jPanel3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void addRoomJbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomJbtnActionPerformed
        // TODO add your handling code here:
        int myCapacity = Integer.parseInt( roomCapacityJtf.getText() );
        String myRoomNameOrNo = roomNameOrNoJtf.getText();
        String myBldgNameOrNo = buildingNameOrNoJtf.getText();
        int mySyYearFrom = Integer.parseInt( yearFromJcbx.getSelectedItem().toString() );
        int mySyYearTo = Integer.parseInt( yearToJcbx.getSelectedItem().toString() );
        RoomDaoImpl myRoom = new RoomDaoImpl(myRoomNameOrNo, myBldgNameOrNo, myCapacity, mySyYearFrom, mySyYearTo);
        boolean isSuccessful = myRoom.add();
        if(isSuccessful){
            JOptionPane.showMessageDialog(null,"Successfully added Room");
        }else{
            JOptionPane.showMessageDialog(null,"Error occured.");
        }
    }//GEN-LAST:event_addRoomJbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRoomJbtn;
    private javax.swing.JTextField buildingNameOrNoJtf;
    private javax.swing.JButton cancelAddRoomJbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField roomCapacityJtf;
    private javax.swing.JTextField roomNameOrNoJtf;
    private javax.swing.JComboBox<String> yearFromJcbx;
    private javax.swing.JComboBox<String> yearToJcbx;
    // End of variables declaration//GEN-END:variables
}
