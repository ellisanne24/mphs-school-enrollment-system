/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.faculty;

import daoimpl.FacultyDaoImpl;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.faculty.Faculty;


/**
 *
 * @author John Ferdinand Antonio
 */
public class FacultyManagement extends javax.swing.JPanel {

    public FacultyManagement() {
        initComponents();
    }
    
    private void setjtblFaculty() {
        FacultyDaoImpl fdi = new FacultyDaoImpl();
        Object[] FacultyData = fdi.getAll().toArray();
        DefaultTableModel tableModel = (DefaultTableModel) jtblFaculty.getModel();
        tableModel.setRowCount(0);
        for (Object faculty : FacultyData) {
            Faculty f = (Faculty) faculty;
            Object[] o = {
                f.getFacultyID(), f.getFirstName(), f.getLastName(),
                f.getMiddleName(), f.getEmailAddress(), f.getContact(),
                f.getStatus() == true ? "Active" : "Inactive"};
            tableModel.addRow(o);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_fname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtf_lname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtf_mname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtf_contact = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtf_emailAdd = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jbtnAddFaculty = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jcb_isActive = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jtfSearchFaculty = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblFaculty = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jbtnUpdateFaculty = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setPreferredSize(new java.awt.Dimension(250, 479));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("First Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jLabel1, gridBagConstraints);

        jtf_fname.setPreferredSize(new java.awt.Dimension(120, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.insets = new java.awt.Insets(40, 2, 3, 2);
        jPanel6.add(jtf_fname, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel2.setText("Last Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jLabel2, gridBagConstraints);

        jtf_lname.setPreferredSize(new java.awt.Dimension(120, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel6.add(jtf_lname, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setText("Middle Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jLabel3, gridBagConstraints);

        jtf_mname.setPreferredSize(new java.awt.Dimension(120, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel6.add(jtf_mname, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel5.setText("Contact Number:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jLabel5, gridBagConstraints);

        jtf_contact.setPreferredSize(new java.awt.Dimension(120, 28));
        jtf_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_contactActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel6.add(jtf_contact, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel6.setText("Email Address:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jLabel6, gridBagConstraints);

        jtf_emailAdd.setPreferredSize(new java.awt.Dimension(120, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel6.add(jtf_emailAdd, gridBagConstraints);

        jButton1.setText("Cancel");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 28));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(100, 2, 3, 2);
        jPanel6.add(jButton1, gridBagConstraints);

        jbtnAddFaculty.setText("Add");
        jbtnAddFaculty.setPreferredSize(new java.awt.Dimension(100, 28));
        jbtnAddFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddFacultyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(100, 2, 3, 2);
        jPanel6.add(jbtnAddFaculty, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel7.setText("Status:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jLabel7, gridBagConstraints);

        jcb_isActive.setText("Active");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel6.add(jcb_isActive, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel5.add(jPanel6, gridBagConstraints);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setPreferredSize(new java.awt.Dimension(720, 479));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setPreferredSize(new java.awt.Dimension(716, 50));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel8.setText("Search:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel8.add(jLabel8, gridBagConstraints);

        jtfSearchFaculty.setPreferredSize(new java.awt.Dimension(130, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel8.add(jtfSearchFaculty, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel7.add(jPanel8, gridBagConstraints);

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setPreferredSize(new java.awt.Dimension(716, 370));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jtblFaculty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Faculty ID", "First Name", "Last Name", "Middle Name", "Email Address", "Contact Number", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblFaculty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblFacultyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblFaculty);

        jPanel9.add(jScrollPane1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel7.add(jPanel9, gridBagConstraints);

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setPreferredSize(new java.awt.Dimension(716, 50));
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jbtnUpdateFaculty.setText("Update");
        jbtnUpdateFaculty.setPreferredSize(new java.awt.Dimension(100, 28));
        jbtnUpdateFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUpdateFacultyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 6);
        jPanel10.add(jbtnUpdateFaculty, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel7.add(jPanel10, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel5.add(jPanel7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        add(jPanel5, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_contactActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jtf_fname.setText("");
        jtf_lname.setText("");
        jtf_mname.setText("");
        jtf_contact.setText("");
        jtf_emailAdd.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbtnAddFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddFacultyActionPerformed

        Faculty faculty = new Faculty();
        faculty.setFirstName(jtf_fname.getText().trim());
        faculty.setLastName(jtf_lname.getText().trim());
        faculty.setMiddleName(jtf_mname.getText().trim());
        faculty.setContact(jtf_contact.getText().trim());
        faculty.setEmailAddress(jtf_emailAdd.getText().trim());

        boolean isActive;
        if(jcb_isActive.isSelected()){
            isActive = true;
        }else{
            isActive = false;
        }
        faculty.setStatus(isActive);

        int register = JOptionPane.showConfirmDialog(null, "Submit new faculty?", "SUBMIT", JOptionPane.YES_NO_OPTION);

        if (register == JOptionPane.YES_OPTION) {
            FacultyDaoImpl fdi = new FacultyDaoImpl();
            boolean isAdded = fdi.add(faculty);
            if (isAdded) {
                jtf_fname.setText("");
                jtf_lname.setText("");
                jtf_mname.setText("");
                jtf_contact.setText("");
                jtf_emailAdd.setText("");
                JOptionPane.showMessageDialog(null, "Successfully added");
                setjtblFaculty();
            } else {
                JOptionPane.showMessageDialog(null, "Error occured during Adding ");
            }
        }

    }//GEN-LAST:event_jbtnAddFacultyActionPerformed

    private void jtblFacultyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblFacultyMouseClicked
        String fname  = jtblFaculty.getValueAt(jtblFaculty.getSelectedRow(),1).toString();
        String lname = jtblFaculty.getValueAt(jtblFaculty.getSelectedRow(),2).toString();
        String mname = jtblFaculty.getValueAt(jtblFaculty.getSelectedRow(),3).toString();
        String civilStatus  = jtblFaculty.getValueAt(jtblFaculty.getSelectedRow(),4).toString();
        String contact = jtblFaculty.getValueAt(jtblFaculty.getSelectedRow(),5).toString();
        String  emailAdd= jtblFaculty.getValueAt(jtblFaculty.getSelectedRow(),6).toString();

        jtf_fname.setText(fname);
        jtf_lname.setText(lname);
        jtf_mname.setText(mname);
        jtf_contact.setText(contact);
        jtf_emailAdd.setText(emailAdd);
    }//GEN-LAST:event_jtblFacultyMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jbtnUpdateFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpdateFacultyActionPerformed
        FacultyDaoImpl fdi = new FacultyDaoImpl();

        String lName = jtf_lname.getText().trim();
        String fName = jtf_fname.getText().trim();
        String mName = jtf_mname.getText().trim();
        int facultyId = Integer.parseInt(jtblFaculty.getValueAt(jtblFaculty.getSelectedRow(), 0).toString());

        Faculty faculty = new Faculty();
        faculty.setFacultyID(facultyId);
        faculty.setFirstName(jtf_fname.getText().trim());
        faculty.setLastName(jtf_lname.getText().trim());
        faculty.setMiddleName(jtf_mname.getText().trim());
        faculty.setContact(jtf_contact.getText().trim());
        faculty.setEmailAddress(jtf_emailAdd.getText().trim());
        //faculty.setStatus(jtf_status.getText();

            int choice = JOptionPane.showConfirmDialog(null, "Update faculty?", "SUBMIT", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
            boolean isUpdated = fdi.update(faculty);
            if (isUpdated) {
                jtf_fname.setText("");
                jtf_lname.setText("");
                jtf_mname.setText("");
                jtf_contact.setText("");
                jtf_emailAdd.setText("");

                JOptionPane.showMessageDialog(null, "Successfully Updated");
                setjtblFaculty();

            } else {
                JOptionPane.showMessageDialog(null, "Error occured during Updating ");
            }
        }
    }//GEN-LAST:event_jbtnUpdateFacultyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAddFaculty;
    private javax.swing.JButton jbtnUpdateFaculty;
    private javax.swing.JCheckBox jcb_isActive;
    private javax.swing.JTable jtblFaculty;
    private javax.swing.JTextField jtfSearchFaculty;
    private javax.swing.JTextField jtf_contact;
    private javax.swing.JTextField jtf_emailAdd;
    private javax.swing.JTextField jtf_fname;
    private javax.swing.JTextField jtf_lname;
    private javax.swing.JTextField jtf_mname;
    // End of variables declaration//GEN-END:variables
}
