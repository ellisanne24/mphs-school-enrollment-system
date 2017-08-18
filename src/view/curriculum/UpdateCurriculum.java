/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.curriculum;

import component_model_loader.CurriculumML;
import component_model_loader.GradeLevelML;
import component_model_loader.SchoolYearML;
import component_renderers.GradeLevelJComboBoxRenderer;
import daoimpl.CurriculumDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.SubjectDaoImpl;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.curriculum.Curriculum;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.subject.Subject;
import utility.component.JTableUtil;
import utility.layout.CurriculumUtility;

/**
 *
 * @author francisunoxx
 */
public class UpdateCurriculum extends javax.swing.JFrame {

    GradeLevelML glu = new GradeLevelML();
    SchoolYearML syu = new SchoolYearML();
    CurriculumML cu = new CurriculumML();
    
    GradeLevel gradeLevel = new GradeLevel();
    Curriculum curriculum = new Curriculum();
    Subject subject = new Subject();
    SchoolYear schoolYear = new SchoolYear();
    
    SubjectDaoImpl sdi = new SubjectDaoImpl();
    GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
    SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();
    CurriculumDaoImpl cdi = new CurriculumDaoImpl();
    
    CurriculumUtility curriculumUtility = new CurriculumUtility();
    
    JTableUtil jtu = new JTableUtil();
    
    int id;
    public UpdateCurriculum(int id) {
        this.id = id;
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
        
        cbGradeLevel.setModel(glu.getAllGradeLevels());
        cbGradeLevel.setRenderer(new GradeLevelJComboBoxRenderer());
        cbGradeLevel.setSelectedIndex(0);
        
        tblCurriculumList.getColumnModel().getColumn(0).setMinWidth(0);
        tblCurriculumList.getColumnModel().getColumn(0).setMaxWidth(0);
        
        tblCreatedCurriculumList.getColumnModel().getColumn(0).setMinWidth(0);
        tblCreatedCurriculumList.getColumnModel().getColumn(0).setMaxWidth(0);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbGradeLevel = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tfCurriculumName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taCurriculumDescription = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCurriculumList = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCreatedCurriculumList = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setPreferredSize(new java.awt.Dimension(692, 100));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel11.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel11.setLayout(new java.awt.GridBagLayout());

        jLabel5.setText("Grade Level:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel11.add(jLabel5, gridBagConstraints);

        cbGradeLevel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbGradeLevelItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel11.add(cbGradeLevel, gridBagConstraints);

        jPanel4.add(jPanel11, java.awt.BorderLayout.WEST);

        jPanel10.setPreferredSize(new java.awt.Dimension(400, 100));
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jLabel6.setText("Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 0, 0);
        jPanel10.add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel10.add(tfCurriculumName, gridBagConstraints);

        jLabel7.setText("Description:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 0, 0);
        jPanel10.add(jLabel7, gridBagConstraints);

        taCurriculumDescription.setColumns(20);
        taCurriculumDescription.setRows(5);
        jScrollPane3.setViewportView(taCurriculumDescription);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 170;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel10.add(jScrollPane3, gridBagConstraints);

        jPanel4.add(jPanel10, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel5.setPreferredSize(new java.awt.Dimension(333, 300));

        tblCurriculumList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Code", "Subject Name", "Grade Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCurriculumList);
        if (tblCurriculumList.getColumnModel().getColumnCount() > 0) {
            tblCurriculumList.getColumnModel().getColumn(0).setResizable(false);
            tblCurriculumList.getColumnModel().getColumn(1).setResizable(false);
            tblCurriculumList.getColumnModel().getColumn(2).setResizable(false);
            tblCurriculumList.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel3.add(jPanel5, gridBagConstraints);

        jPanel6.setBackground(java.awt.Color.white);
        jPanel6.setPreferredSize(new java.awt.Dimension(80, 300));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Transfer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel6.add(jButton1, gridBagConstraints);

        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel6.add(jButton2, gridBagConstraints);

        jPanel3.add(jPanel6, new java.awt.GridBagConstraints());

        jPanel7.setBackground(java.awt.Color.white);
        jPanel7.setPreferredSize(new java.awt.Dimension(333, 300));

        tblCreatedCurriculumList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Code", "Subject Name", "Subject Hours", "Grade Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCreatedCurriculumList);
        if (tblCreatedCurriculumList.getColumnModel().getColumnCount() > 0) {
            tblCreatedCurriculumList.getColumnModel().getColumn(0).setResizable(false);
            tblCreatedCurriculumList.getColumnModel().getColumn(1).setResizable(false);
            tblCreatedCurriculumList.getColumnModel().getColumn(2).setResizable(false);
            tblCreatedCurriculumList.getColumnModel().getColumn(3).setResizable(false);
            tblCreatedCurriculumList.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        jPanel3.add(jPanel7, gridBagConstraints);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Curriculum Details", jPanel2);

        jPanel1.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Actions");

        jMenuItem1.setText("Apply");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbGradeLevelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbGradeLevelItemStateChanged
        
        //Setter call on Curriculum
        gradeLevel.setLevel((Integer) cbGradeLevel.getSelectedItem());
        gradeLevel.setId(gldi.getId(gradeLevel));
        sdi.getEachSubjectByGradeLevelId(gradeLevel);

        tblCurriculumList.setModel(cu.getEachSubjectsByGradeLevelId(gradeLevel));
        
        tblCurriculumList.getColumnModel().getColumn(0).setMinWidth(0);
        tblCurriculumList.getColumnModel().getColumn(0).setMaxWidth(0);
        
    }//GEN-LAST:event_cbGradeLevelItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jtu.copyTableCurriculumData(tblCurriculumList, tblCreatedCurriculumList);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jtu.returnCopyData(tblCreatedCurriculumList, tblCurriculumList);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
//        List list = new ArrayList();
//        list.add(tfCurriculumName.getText());
//        list.add(taCurriculumDescription.getText());
//        
//        for(int i = 0; i < tblCreatedCurriculumList.getModel().getRowCount(); i++)
//        {
//            list.add(tblCreatedCurriculumList.getValueAt(i, 1));
//            list.add(tblCreatedCurriculumList.getValueAt(i, 2));
//        }
//        
//        
//        list.retainAll(new CurriculumValidation().checkCurriculumChanges(curriculum));
//        
//        //If nothing changes
//        if(list.size() == 6)
//        {
//            JOptionPane.showMessageDialog(null, "No changes detected");
//        }
        //If anything changes
        
            if(tblCreatedCurriculumList.getRowCount() == 0)
            {
                JOptionPane.showMessageDialog(null, "Cannot update empty curriculum!");
            }
            else
            {
                int x = JOptionPane.showConfirmDialog(null, "Apply changes?", "", JOptionPane.YES_NO_OPTION);
            
                if(x == JOptionPane.YES_OPTION)
                {
                    
                    //Setter call from Curriculum while getting the text of jtextfield and jtextarea
                    curriculum.setCurriculumTitle(tfCurriculumName.getText());
                    curriculum.setCurriculumDescription(taCurriculumDescription.getText());
                    curriculum.setCurriculumId(id);
                    
                    //Setter call from SchoolYear
                    schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());
                    
                    //Method call from CurriculumDaoImpl
                    cdi.updateCurriculumById(curriculum, schoolYear);
                    cdi.deleteCurriculumById(curriculum);

                    //while looping to row count of table
                    for(int i = 0; i < tblCreatedCurriculumList.getRowCount(); i++)
                    {
                        //Setter call from Subject
                        subject.setSubjectId((int) tblCreatedCurriculumList.getValueAt(i, 0));
                        subject.setSubjectCode((String) tblCreatedCurriculumList.getValueAt(i, 1));
                        subject.setSubjectTitle((String) tblCreatedCurriculumList.getValueAt(i, 2));
                        
                        subject.setSubjectHours((double) tblCreatedCurriculumList.getValueAt(i, 3));
                        
                        if(tblCreatedCurriculumList.getValueAt(i, 4) == "Kindergarten")
                        {
                            gradeLevel.setId(301);
                        }
                        else
                        {
                            gradeLevel.setLevel((Integer) tblCreatedCurriculumList.getValueAt(i, 4));
                            //Setter call from GradeLevel & Getting cbGradeLevel id
                            gradeLevel.setId(gldi.getId(gradeLevel));
                        }
                                                

                        //Method call from CurriculumDaoImpl
                        cdi.createCurriculumSubjects(curriculum, subject, gradeLevel);
                    }

                    JOptionPane.showMessageDialog(null, "Successfully updated curriculum "+tfCurriculumName.getText());
                }  
            }
            
            if(tblCurriculumList.getRowCount() != 0)
            {
                for(int i = 0; i < tblCurriculumList.getRowCount(); i++)
                {
                    //Setter call from Subject
                    subject.setSubjectId((int) tblCurriculumList.getValueAt(i, 0));
                    
                    //Method call from CurriculumDaoImpl
                    cdi.updateSubjectIsAddedById(subject);
                }
                
                
                
            }
        


    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    public JTable getTblCreatedCurriculumList()
    {
        return tblCreatedCurriculumList;
    }
    
    public JComboBox getCbCreatedGradeLevel()
    {
        return cbGradeLevel;
    }
    
   
    
    public JTextField getTfCurriculumName()
    {
        return tfCurriculumName;
    }
    
    public JTextArea getTaCurriculumDescription()
    {
        return taCurriculumDescription;
    }
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbGradeLevel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea taCurriculumDescription;
    private javax.swing.JTable tblCreatedCurriculumList;
    private javax.swing.JTable tblCurriculumList;
    private javax.swing.JTextField tfCurriculumName;
    // End of variables declaration//GEN-END:variables
}
