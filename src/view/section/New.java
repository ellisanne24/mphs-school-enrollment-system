/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.section;

import component_model_loader.FacultyML;
import component_model_loader.GradeLevelML;
import component_model_loader.SectionML;
import component_renderers.GradeLevelJComboBoxRenderer;
import daoimpl.FacultyDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.SectionDaoImpl;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.faculty.Faculty;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.session.Session;

/**
 *
 * @author francisunoxx
 */
public class New extends javax.swing.JPanel {
    
    Object[] sessionList = new Object[]{"AM", "PM"};
    
    DefaultComboBoxModel sessionModel = new DefaultComboBoxModel(sessionList);
    DefaultComboBoxModel averageModel = new DefaultComboBoxModel();
    
    private SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();
    private SectionDaoImpl sdi = new SectionDaoImpl();
    private GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
    private FacultyDaoImpl fdi = new FacultyDaoImpl();
    private GradeLevelML gl = new GradeLevelML();
    private FacultyML fml = new FacultyML();
    
    private SchoolYear schoolYear = new SchoolYear();
    
    private Section section = new Section();
    private GradeLevel gradeLevel = new GradeLevel();
    private Session session = new Session();
    private Faculty faculty = new Faculty();
    
    private SectionML sml = new SectionML();
  
    
    
    public New() {
        initComponents();
        
        for(int i = 75; i < 100; i++)
        {
            averageModel.addElement(i);
        }
        
        cbAverage.setModel(averageModel);
        cbAverage.setSelectedIndex(-1);
        
        cbGradeLevel.setModel(gl.getAllGradeLevels());
//        cbGradeLevel.setSelectedIndex(-1);
        
        
        cbAdviser.setModel(fml.getAllFacultyName());
        cbAdviser.setSelectedIndex(-1);
        cbAdviser.setPrototypeDisplayValue("XXXXXXXXXXXXX");
        
        cbSession.setModel(sessionModel);
        cbSession.setSelectedIndex(-1);
        
        cbGradeLevel.setRenderer(new GradeLevelJComboBoxRenderer());
        
        if(cbAverage.getSelectedIndex() == -1)
        {
            section.setRequiredAverage(String.valueOf(0.0));
        }
        else
        {
            section.setRequiredAverage(String.valueOf(cbAverage.getSelectedItem()));
        }
        
        if(cbSession.getSelectedIndex() == -1)
        {
            session.setSessionId(3);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfSubjectName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbGradeLevel = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbSession = new javax.swing.JComboBox<>();
        chbBoth = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        cbAverage = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbAdviser = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Create Section"));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Section Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 0);
        jPanel4.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel4.add(tfSubjectName, gridBagConstraints);

        jLabel6.setText("Grade Level:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 0);
        jPanel4.add(jLabel6, gridBagConstraints);

        cbGradeLevel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbGradeLevelItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel4.add(cbGradeLevel, gridBagConstraints);

        jLabel10.setText("Session:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 0);
        jPanel4.add(jLabel10, gridBagConstraints);

        cbSession.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSessionItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel4.add(cbSession, gridBagConstraints);

        chbBoth.setText("Both");
        chbBoth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbBothItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        jPanel4.add(chbBoth, gridBagConstraints);

        jLabel4.setText("Required Average:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel4.add(jLabel4, gridBagConstraints);

        cbAverage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAverageItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel4.add(cbAverage, gridBagConstraints);

        jLabel2.setText("Adviser:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel4.add(jLabel2, gridBagConstraints);

        cbAdviser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAdviserItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel4.add(cbAdviser, gridBagConstraints);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        btnSave.setText("Create");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        jPanel5.add(btnSave, gridBagConstraints);

        jPanel2.add(jPanel5, java.awt.BorderLayout.SOUTH);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cbGradeLevelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbGradeLevelItemStateChanged
        //Setter call from GradeLevel
        gradeLevel.setLevel((Integer) cbGradeLevel.getSelectedItem());
    }//GEN-LAST:event_cbGradeLevelItemStateChanged

    private void cbSessionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSessionItemStateChanged
        if (cbSession.getSelectedIndex() == 0) {
            session.setSessionId(1);

        } else {
            session.setSessionId(2);

        }
    }//GEN-LAST:event_cbSessionItemStateChanged

    private void chbBothItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbBothItemStateChanged
        if(chbBoth.isSelected())
        {
            cbSession.setEnabled(false);
            if(cbAverage.getSelectedIndex() != 0)
            {
                section.setRequiredAverage("");
            }
            else
            {
                section.setRequiredAverage(cbAverage.getSelectedItem().toString().trim());
            }
        }
        else
        {
            cbSession.setEnabled(true);
        }
    }//GEN-LAST:event_chbBothItemStateChanged

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (chbBoth.isSelected())
        {
            if(cbAverage.getSelectedIndex() == -1)
            {   
                section.setRequiredAverage(String.valueOf(0.0));
            }
            else
            {
                section.setRequiredAverage(String.valueOf(cbAverage.getSelectedItem()));
            }
            
            
            //Setter call from Section
            section.setSectionName(tfSubjectName.getText());
            //Setter call from Section
            section.setSectionId(section.getSectionId());
            
            //Setter call from SchoolYear
            schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());
            //Setter call from GradeLevel
            gradeLevel.setId(gldi.getId(gradeLevel));
            
            sdi.createSection(section);
            
            
            
            for (int i = 0; i < 2; i++)
            {
                if(i == 0)
                {
                    //Setter call from Session
                    session.setSessionId(1);
                    
                    //Method call from SectionDaoImpl
                    sdi.createSectionSettings(section, schoolYear, gradeLevel, session, faculty);
                }
                else 
                {
                    
                    //Setter call from Session
                    session.setSessionId(2);

                    //Method call from SectionDaoImpl
                    sdi.createSectionSettings(section, schoolYear, gradeLevel, session, faculty);
                    JOptionPane.showMessageDialog(null, "Successfully created " + tfSubjectName.getText() + " section!");
                }
                
            }
        }
        else 
        {
            //Setter call from Section
            section.setSectionName(tfSubjectName.getText());
            section.setSectionId(section.getSectionId());
            //Setter call from SchoolYear
            schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());
            //Setter call from GradeLevel
            gradeLevel.setId(gldi.getId(gradeLevel));
            //Setter call from Session
            session.setSessionId(session.getSessionId());

            
            //Method call from SectionDaoImpl
            sdi.createSection(section);
            sdi.createSectionSettings(section, schoolYear, gradeLevel, session, faculty);
            JOptionPane.showMessageDialog(null, "Successfully created " + tfSubjectName.getText() + " section!");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cbAverageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAverageItemStateChanged
        if(cbAverage.getSelectedIndex() != 0)
        {
            section.setRequiredAverage(String.valueOf(cbAverage.getSelectedItem()));
        }
    }//GEN-LAST:event_cbAverageItemStateChanged

    private void cbAdviserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAdviserItemStateChanged
        //Setter call from Faculty
        faculty.setFullName((String) cbAdviser.getSelectedItem());
        faculty.setFacultyID(fdi.getFacultyId(faculty));
    }//GEN-LAST:event_cbAdviserItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbAdviser;
    private javax.swing.JComboBox<String> cbAverage;
    private javax.swing.JComboBox<String> cbGradeLevel;
    private javax.swing.JComboBox<String> cbSession;
    private javax.swing.JCheckBox chbBoth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField tfSubjectName;
    // End of variables declaration//GEN-END:variables
}
