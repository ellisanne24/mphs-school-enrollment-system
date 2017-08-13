package view.section;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import component_model_loader.FacultyML;
import component_model_loader.GradeLevelML;
import component_model_loader.SchoolYearML;
import component_model_loader.SectionML;
import daoimpl.FacultyDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.SectionDaoImpl;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import model.faculty.Faculty;
import model.grade.Grade;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.session.Session;
import model.student.Student;
import utility.component.JTableUtil;
import utility.layout.SectionUtility;

/**
 *
 * @author francisunoxx
 */
public class UpdateSection extends javax.swing.JFrame {

    Object[] sessionList = new Object[]{"AM", "PM"};
    
    DefaultComboBoxModel sessionModel = new DefaultComboBoxModel(sessionList);

    private SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();
    private SectionDaoImpl sdi = new SectionDaoImpl();
    private GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
    private FacultyDaoImpl fdi = new FacultyDaoImpl();
    
    private GradeLevelML gl = new GradeLevelML();
    private SchoolYearML syml = new SchoolYearML();
    private SectionML sml = new SectionML();

    private SchoolYear schoolYear = new SchoolYear();
    private Section section = new Section();
    private GradeLevel gradeLevel = new GradeLevel();
    private Session session = new Session();
    private Student student = new Student();
    private Faculty faculty = new Faculty();
    private Grade grade = new Grade();
    
    private SectionUtility su = new SectionUtility();
    
    private FacultyML fml = new FacultyML();
    
    private JTableUtil jtu = new JTableUtil();
    
    private int id;
    private String name;
    public UpdateSection(int id) 
    {
        this.id = id;
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
        
        
        section.setSectionId(id);
        
        btnGrpSession.add(chbAM);
        btnGrpSession.add(chbPM);
        btnGrpSession.add(chbDefault);
        
        cbGradeLevel.setModel(gl.getAllGradeLevels());
        
        cbAdviser.setPrototypeDisplayValue("XXXXXXXX");
        
        if(chbAM.isSelected())
        {
            session.setSessionId(1);
        }
        else if(chbPM.isSelected())
        {
            session.setSessionId(2);
        }
        else
        {
            session.setSessionId(3);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btnGrpSession = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfSectionName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbGradeLevel = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        chbAM = new javax.swing.JRadioButton();
        chbPM = new javax.swing.JRadioButton();
        chbDefault = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        cbAdviser = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudentList = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStudentSectionList = new javax.swing.JTable();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(754, 437));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(746, 400));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel8.setPreferredSize(new java.awt.Dimension(692, 100));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jLabel5.setText("Section Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 0);
        jPanel8.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel8.add(tfSectionName, gridBagConstraints);

        jLabel1.setText("Grade Level:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel8.add(jLabel1, gridBagConstraints);

        cbGradeLevel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbGradeLevelItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel8.add(cbGradeLevel, gridBagConstraints);

        jLabel3.setText("Session:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 0);
        jPanel8.add(jLabel3, gridBagConstraints);

        chbAM.setText("AM");
        chbAM.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbAMItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        jPanel8.add(chbAM, gridBagConstraints);

        chbPM.setText("PM");
        chbPM.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbPMItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        jPanel8.add(chbPM, gridBagConstraints);

        chbDefault.setText("Default");
        chbDefault.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbDefaultItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        jPanel8.add(chbDefault, gridBagConstraints);

        jLabel4.setText("Adviser:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel8.add(jLabel4, gridBagConstraints);

        cbAdviser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAdviserItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel8.add(cbAdviser, gridBagConstraints);

        jPanel2.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        jPanel4.setPreferredSize(new java.awt.Dimension(746, 250));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Student List"));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel5.setPreferredSize(new java.awt.Dimension(330, 300));

        tblStudentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Student Number", "Student Name", "General Average"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStudentList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudentList);
        if (tblStudentList.getColumnModel().getColumnCount() > 0) {
            tblStudentList.getColumnModel().getColumn(0).setResizable(false);
            tblStudentList.getColumnModel().getColumn(1).setResizable(false);
            tblStudentList.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        jPanel4.add(jPanel5, gridBagConstraints);

        jPanel6.setBackground(new java.awt.Color(254, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(86, 300));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel6.add(jButton1, gridBagConstraints);

        jButton2.setText("-");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 20;
        jPanel6.add(jButton2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.5;
        jPanel4.add(jPanel6, gridBagConstraints);

        jPanel7.setBackground(java.awt.Color.white);
        jPanel7.setPreferredSize(new java.awt.Dimension(330, 300));

        tblStudentSectionList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Student Number", "Student Name", "General Average"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStudentSectionList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentSectionListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblStudentSectionList);
        if (tblStudentSectionList.getColumnModel().getColumnCount() > 0) {
            tblStudentSectionList.getColumnModel().getColumn(0).setResizable(false);
            tblStudentSectionList.getColumnModel().getColumn(1).setResizable(false);
            tblStudentSectionList.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        jPanel4.add(jPanel7, gridBagConstraints);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Section Details", jPanel2);

        jPanel1.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu2.setText("Actions");

        jMenuItem1.setText("Apply");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbGradeLevelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbGradeLevelItemStateChanged
        //Setter call from GradeLevel
        gradeLevel.setLevel((Integer) cbGradeLevel.getSelectedItem());
        gradeLevel.setId(gldi.getId(gradeLevel));

        //Set model on jtable
        tblStudentList.setModel(sml.getAllStudentsByGradeLevelId(gradeLevel));
        
        tblStudentSectionList.setModel(sml.getAllAddedStudentBySectionId(gradeLevel,section));
    }//GEN-LAST:event_cbGradeLevelItemStateChanged

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(tblStudentList.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(null, "Cannot update empty section");
        }
        else
        {
            int i = JOptionPane.showConfirmDialog(null, "Apply changes?", "", JOptionPane.YES_NO_OPTION);
            
            if(i == JOptionPane.YES_OPTION)
            {
                if(cbAdviser.getSelectedIndex() == -1)
                {
                    JOptionPane.showMessageDialog(null, "Please select adviser");
                }
                else
                {
                    //Setter call from Section
                    section.setSectionName(tfSectionName.getText().trim());
                    //Setter call from SchoolYear
                    schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());
                    sdi.deleteStudentSectionById(section);
                    for (int y = 0; y < tblStudentSectionList.getRowCount(); y++) {
                        student.setStudentId((int) tblStudentSectionList.getValueAt(y, 0));
                        sdi.createStudentSection(section, student, schoolYear);

                    }
                    System.out.println(section.getSectionId());
                    
                    System.out.println(faculty.getFacultyID());
            
                    //Method call
                    
                    sdi.updateSectionName(section);
                    sdi.updateSectionSettingsById(schoolYear, gradeLevel, session, faculty, section);
                    
                    JOptionPane.showMessageDialog(null, "Successfully updated!");
                }
                
                
            }

            
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void chbAMItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbAMItemStateChanged
        if(chbAM.isSelected())
        {
            session.setSessionId(1);
        }
    }//GEN-LAST:event_chbAMItemStateChanged

    private void chbPMItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbPMItemStateChanged
        if(chbPM.isSelected())
        {
            session.setSessionId(2);
        }
    }//GEN-LAST:event_chbPMItemStateChanged

    private void chbDefaultItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbDefaultItemStateChanged
        if(chbDefault.isSelected())
        {
            session.setSessionId(3);
        }
    }//GEN-LAST:event_chbDefaultItemStateChanged

    private void cbAdviserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAdviserItemStateChanged
        //Setter call from Faculty
        faculty.setFullName(String.valueOf(cbAdviser.getSelectedItem()));
        faculty.setFacultyID(fdi.getFacultyId(faculty));
    }//GEN-LAST:event_cbAdviserItemStateChanged

    private void tblStudentListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentListMouseClicked
        if (evt.getSource().equals(tblStudentList)) {
            if (evt.getClickCount() == 2) {
                
                    jtu.copyTableSectionData(tblStudentList, tblStudentSectionList, grade.getGwa());
                
                
            }
        }
    }//GEN-LAST:event_tblStudentListMouseClicked

    private void tblStudentSectionListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentSectionListMouseClicked
        jtu.returnCopyData(tblStudentSectionList, tblStudentList);
    }//GEN-LAST:event_tblStudentSectionListMouseClicked
    
    public JTextField getTfSectionName()
    {
        return tfSectionName;
    }
    
    public JComboBox getCbGradeLevel()
    {
        return cbGradeLevel;
    }
    
    public JRadioButton getChbAM()
    {
        return chbAM;
    }
    
    public JRadioButton getChbPM()
    {
        return chbPM;
    }
    
    public JRadioButton getChbDefault()
    {
        return chbDefault;
    }
    
    public JTable getTblAssign()
    {
        return tblStudentList;
    }
    
    public JComboBox getCbAdviser()
    {
        return cbAdviser;
    }
    
    public JPanel getPnlStudentList()
    {
        return jPanel7;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGrpSession;
    private javax.swing.JComboBox<String> cbAdviser;
    private javax.swing.JComboBox<String> cbGradeLevel;
    private javax.swing.JRadioButton chbAM;
    private javax.swing.JRadioButton chbDefault;
    private javax.swing.JRadioButton chbPM;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblStudentList;
    private javax.swing.JTable tblStudentSectionList;
    private javax.swing.JTextField tfSectionName;
    // End of variables declaration//GEN-END:variables
}
