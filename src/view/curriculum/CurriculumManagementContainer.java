package view.curriculum;

import component_editor.JSpinnerEditor_Curriculum;
import component_model_loader.CurriculumML;
import component_model_loader.GradeLevelML;
import component_model_loader.SchoolYearML;
import component_renderers.GradeLevelJComboBoxRenderer;
import daoimpl.CurriculumDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.SubjectDaoImpl;
import java.awt.Color;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import model.curriculum.Curriculum;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.subject.Subject;
import utility.component.JInternalFrameUtil;
import utility.component.JTableUtil;
import utility.layout.CurriculumUtility;

public class CurriculumManagementContainer extends javax.swing.JPanel {

    //HAS-A
    // Has the following classes
    GradeLevelML glu = new GradeLevelML();
    SchoolYearML syu = new SchoolYearML();
    CurriculumML cu = new CurriculumML();

    SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();
    CurriculumDaoImpl cdi = new CurriculumDaoImpl();
    SubjectDaoImpl sdi = new SubjectDaoImpl();
    GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();

    Subject subject = new Subject();
    GradeLevel gradeLevel = new GradeLevel();
    Curriculum curriculum = new Curriculum();
    SchoolYear schoolYear = new SchoolYear();

    CurriculumUtility curriculumUtility = new CurriculumUtility();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

    List <Integer> gradeIdList = new ArrayList();
    
    JTableUtil jtu = new JTableUtil();
    
    public CurriculumManagementContainer() {
        UIManager.put("ComboBox.disabledBackground", new Color(212, 212, 210));
        UIManager.put("ComboBox.disabledForeground", Color.BLACK);
        initComponents();
        JInternalFrameUtil.removeTitleBar(jInternalFrame1);

        jcmbGradeLevel.setModel(glu.getAllGradeLevels());
        jcmbGradeLevel.setRenderer(new GradeLevelJComboBoxRenderer());
        jcmbGradeLevel.setSelectedIndex(-1);

       
        jcmbGradeLevel.setRenderer(new GradeLevelJComboBoxRenderer());

        tblCreatedCurriculum.setModel(cu.getAllCurriculum());

        //Hide first column
        tblCreatedCurriculum.getColumnModel().getColumn(0).setMinWidth(0);
        tblCreatedCurriculum.getColumnModel().getColumn(0).setMaxWidth(0);
        
        curriculumSubjectsJtbl.getColumnModel().getColumn(0).setMinWidth(0);
        curriculumSubjectsJtbl.getColumnModel().getColumn(0).setMaxWidth(0);
        //Getting column model
        TableColumnModel tcm = curriculumSubjectsJtbl.getColumnModel();
        TableColumn tc = tcm.getColumn(2);
        //Setting jspinner editor at column 2
        tc.setCellEditor(new JSpinnerEditor_Curriculum());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel18 = new javax.swing.JPanel();
        jtpCurriculum = new javax.swing.JTabbedPane();
        jpnlCurriculumListCardContainer = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCreatedCurriculum = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jpnlCurriculumCreatorCardContainer = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        gradeLevelJlbl = new javax.swing.JLabel();
        jcmbGradeLevel = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        tfCurriculumName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        curriculumDescriptionJta = new javax.swing.JTextArea();
        jpnlSubjectAssignment = new javax.swing.JPanel();
        subjectsListJPanel = new javax.swing.JPanel();
        subjectsListJsp = new javax.swing.JScrollPane();
        subjectsListJtbl = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        addSubjectJbtn = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        removeSubjectJbtn = new javax.swing.JButton();
        curriculumSubjectsJPanel = new javax.swing.JPanel();
        curriculumSubjectsJsp = new javax.swing.JScrollPane();
        curriculumSubjectsJtbl = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        cancelCreateCurriculumJbtn = new javax.swing.JButton();
        saveCurriculumJbtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel17.setLayout(new java.awt.GridBagLayout());

        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel18.setLayout(new java.awt.GridBagLayout());

        jtpCurriculum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtpCurriculumMouseClicked(evt);
            }
        });

        jpnlCurriculumListCardContainer.setLayout(new java.awt.BorderLayout());

        jPanel15.setLayout(new java.awt.GridBagLayout());

        tblCreatedCurriculum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Curriculum Name", "School Year", "Description", "Date Created", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCreatedCurriculum.setRowHeight(25);
        tblCreatedCurriculum.getTableHeader().setReorderingAllowed(false);
        tblCreatedCurriculum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCreatedCurriculumMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCreatedCurriculum);
        if (tblCreatedCurriculum.getColumnModel().getColumnCount() > 0) {
            tblCreatedCurriculum.getColumnModel().getColumn(0).setResizable(false);
            tblCreatedCurriculum.getColumnModel().getColumn(1).setResizable(false);
            tblCreatedCurriculum.getColumnModel().getColumn(2).setResizable(false);
            tblCreatedCurriculum.getColumnModel().getColumn(3).setResizable(false);
            tblCreatedCurriculum.getColumnModel().getColumn(4).setResizable(false);
            tblCreatedCurriculum.getColumnModel().getColumn(5).setResizable(false);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 696;
        gridBagConstraints.ipady = 279;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(17, 6, 6, 6);
        jPanel15.add(jScrollPane1, gridBagConstraints);

        jpnlCurriculumListCardContainer.add(jPanel15, java.awt.BorderLayout.CENTER);

        jPanel16.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Open");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        jPanel16.add(jButton1, gridBagConstraints);

        jpnlCurriculumListCardContainer.add(jPanel16, java.awt.BorderLayout.PAGE_END);

        jtpCurriculum.addTab("Record", jpnlCurriculumListCardContainer);

        jpnlCurriculumCreatorCardContainer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpnlCurriculumCreatorCardContainer.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel11.setLayout(new java.awt.GridBagLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter Controls"));
        jPanel9.setMinimumSize(new java.awt.Dimension(150, 98));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        gradeLevelJlbl.setText("Grade Level:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel9.add(gradeLevelJlbl, gridBagConstraints);

        jcmbGradeLevel.setModel(new component_model_loader.GradeLevelML().getAllGradeLevels());
        jcmbGradeLevel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbGradeLevelItemStateChanged(evt);
            }
        });
        jcmbGradeLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbGradeLevelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel9.add(jcmbGradeLevel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel11.add(jPanel9, gridBagConstraints);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("New Curriculum"));
        jPanel13.setMinimumSize(new java.awt.Dimension(200, 107));
        jPanel13.setPreferredSize(new java.awt.Dimension(200, 107));
        jPanel13.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel13.add(tfCurriculumName, gridBagConstraints);

        jLabel1.setText("Curriculum Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel13.add(jLabel1, gridBagConstraints);

        jLabel8.setText("Description:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel13.add(jLabel8, gridBagConstraints);

        curriculumDescriptionJta.setColumns(20);
        curriculumDescriptionJta.setRows(5);
        jScrollPane3.setViewportView(curriculumDescriptionJta);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel13.add(jScrollPane3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel11.add(jPanel13, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jPanel11, gridBagConstraints);

        jpnlSubjectAssignment.setLayout(new java.awt.GridBagLayout());

        subjectsListJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Subject List"));
        subjectsListJPanel.setLayout(new java.awt.GridBagLayout());

        subjectsListJtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject Id", "Code", "Subject Name", "Grade Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        subjectsListJtbl.getTableHeader().setReorderingAllowed(false);
        subjectsListJtbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subjectsListJtblMouseClicked(evt);
            }
        });
        subjectsListJsp.setViewportView(subjectsListJtbl);
        if (subjectsListJtbl.getColumnModel().getColumnCount() > 0) {
            subjectsListJtbl.getColumnModel().getColumn(0).setResizable(false);
            subjectsListJtbl.getColumnModel().getColumn(1).setResizable(false);
            subjectsListJtbl.getColumnModel().getColumn(2).setResizable(false);
            subjectsListJtbl.getColumnModel().getColumn(3).setResizable(false);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        subjectsListJPanel.add(subjectsListJsp, gridBagConstraints);

        jPanel8.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        subjectsListJPanel.add(jPanel8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSubjectAssignment.add(subjectsListJPanel, gridBagConstraints);

        jPanel6.setLayout(new java.awt.GridBagLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        addSubjectJbtn.setText("Transfer");
        addSubjectJbtn.setMargin(new java.awt.Insets(3, 3, 3, 3));
        addSubjectJbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSubjectJbtnActionPerformed(evt);
            }
        });
        jPanel5.add(addSubjectJbtn, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jPanel5, gridBagConstraints);

        jPanel7.setLayout(new java.awt.BorderLayout());

        removeSubjectJbtn.setText("Remove");
        removeSubjectJbtn.setMargin(new java.awt.Insets(3, 3, 3, 3));
        removeSubjectJbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSubjectJbtnActionPerformed(evt);
            }
        });
        jPanel7.add(removeSubjectJbtn, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jPanel7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSubjectAssignment.add(jPanel6, gridBagConstraints);

        curriculumSubjectsJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Curriculum with Subjects"));
        curriculumSubjectsJPanel.setLayout(new java.awt.GridBagLayout());

        curriculumSubjectsJtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Code", "Subject Name", "Subject Hours", "Grade Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        curriculumSubjectsJtbl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                curriculumSubjectsJtblFocusLost(evt);
            }
        });
        curriculumSubjectsJtbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                curriculumSubjectsJtblMouseClicked(evt);
            }
        });
        curriculumSubjectsJsp.setViewportView(curriculumSubjectsJtbl);
        if (curriculumSubjectsJtbl.getColumnModel().getColumnCount() > 0) {
            curriculumSubjectsJtbl.getColumnModel().getColumn(0).setResizable(false);
            curriculumSubjectsJtbl.getColumnModel().getColumn(1).setResizable(false);
            curriculumSubjectsJtbl.getColumnModel().getColumn(2).setResizable(false);
            curriculumSubjectsJtbl.getColumnModel().getColumn(3).setResizable(false);
            curriculumSubjectsJtbl.getColumnModel().getColumn(4).setResizable(false);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        curriculumSubjectsJPanel.add(curriculumSubjectsJsp, gridBagConstraints);

        jPanel10.setLayout(new java.awt.GridBagLayout());
        curriculumSubjectsJPanel.add(jPanel10, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSubjectAssignment.add(curriculumSubjectsJPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel4.add(jpnlSubjectAssignment, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jPanel4, gridBagConstraints);

        jPanel12.setLayout(new java.awt.GridBagLayout());

        cancelCreateCurriculumJbtn.setText("Cancel");
        cancelCreateCurriculumJbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelCreateCurriculumJbtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel12.add(cancelCreateCurriculumJbtn, gridBagConstraints);

        saveCurriculumJbtn.setText("Create");
        saveCurriculumJbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveCurriculumJbtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel12.add(saveCurriculumJbtn, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jPanel12, gridBagConstraints);

        jpnlCurriculumCreatorCardContainer.add(jPanel3, java.awt.BorderLayout.CENTER);

        jtpCurriculum.addTab("New", jpnlCurriculumCreatorCardContainer);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel18.add(jtpCurriculum, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jInternalFrame1.getContentPane().add(jPanel18, gridBagConstraints);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("New");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Edit");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Save");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jInternalFrame1.setJMenuBar(jMenuBar1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel17.add(jInternalFrame1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel2.add(jPanel17, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jPanel2, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jtpCurriculumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtpCurriculumMouseClicked

    }//GEN-LAST:event_jtpCurriculumMouseClicked

    private void jcmbGradeLevelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbGradeLevelItemStateChanged
        if (jcmbGradeLevel.getSelectedIndex() != -1) {
            gradeLevel.setLevel((int) jcmbGradeLevel.getSelectedItem());
            gradeLevel.setId(gldi.getId(gradeLevel));
            
            sdi.getEachSubjectByGradeLevelId(gradeLevel);

            subjectsListJtbl.setModel(cu.getEachSubjectsByGradeLevelId(gradeLevel));
            
            subjectsListJtbl.getColumnModel().getColumn(0).setMinWidth(0);
            subjectsListJtbl.getColumnModel().getColumn(0).setMaxWidth(0);
        }
    }//GEN-LAST:event_jcmbGradeLevelItemStateChanged

    private void subjectsListJtblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjectsListJtblMouseClicked
//        if (subjectsListJtbl.getSelectedRow() > -1) {
//            addSubjectJbtn.setEnabled(true);
//        }
//        if (evt.getSource().equals(subjectsListJtbl)) {
//            if (evt.getClickCount() == 2) {
//                JTableGUIUtil jtm = new JTableGUIUtil();
//                jtm.copyTableData(subjectsListJtbl, curriculumSubjectsJtbl);
//            }
//        }
    }//GEN-LAST:event_subjectsListJtblMouseClicked

    private void addSubjectJbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSubjectJbtnActionPerformed
        jtu.copyTableCurriculumData(subjectsListJtbl, curriculumSubjectsJtbl);
    }//GEN-LAST:event_addSubjectJbtnActionPerformed

    private void removeSubjectJbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSubjectJbtnActionPerformed
        if (curriculumSubjectsJtbl.getSelectedRow() > -1) {
            int selectedRowIndex = curriculumSubjectsJtbl.getSelectedRow();
            DefaultTableModel curriculumSubjectsModel = (DefaultTableModel) curriculumSubjectsJtbl.getModel();
            curriculumSubjectsModel.removeRow(selectedRowIndex);
            curriculumSubjectsJtbl.clearSelection();
            removeSubjectJbtn.setEnabled(false);
        }
    }//GEN-LAST:event_removeSubjectJbtnActionPerformed

    private void curriculumSubjectsJtblFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_curriculumSubjectsJtblFocusLost

    }//GEN-LAST:event_curriculumSubjectsJtblFocusLost

    private void curriculumSubjectsJtblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_curriculumSubjectsJtblMouseClicked
//        if (curriculumSubjectsJtbl.getSelectedRow() > -1) {
//            removeSubjectJbtn.setEnabled(true);
//        } else if (curriculumSubjectsJtbl.getSelectedRow() == -1) {
//            curriculumSubjectsJtbl.clearSelection(); //deselects all rows and columns
//        }
//
//        if (evt.getClickCount() == 2) {
//            int selectedRow = curriculumSubjectsJtbl.getSelectedRow();
//            DefaultTableModel model = (DefaultTableModel) curriculumSubjectsJtbl.getModel();
//            model.removeRow(selectedRow);
//        }

    }//GEN-LAST:event_curriculumSubjectsJtblMouseClicked

    private void cancelCreateCurriculumJbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelCreateCurriculumJbtnActionPerformed

    }//GEN-LAST:event_cancelCreateCurriculumJbtnActionPerformed

    private void saveCurriculumJbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveCurriculumJbtnActionPerformed
        for(int i = 0; i < curriculumSubjectsJtbl.getRowCount(); i++)
        {
            if(curriculumSubjectsJtbl.getValueAt(i, 4) == "Kindergarten")
            {
                gradeLevel.setId(301);
            }
            else
            {
                gradeLevel.setLevel((Integer) curriculumSubjectsJtbl.getValueAt(i, 4));
                gradeLevel.setId(gldi.getId(gradeLevel));
            }
            
            if(!gradeIdList.contains(gradeLevel.getId()))
            {
                gradeIdList.add(gradeLevel.getId());
            }
        }
        
        for(int y = 0; y < gradeIdList.size(); y++)
        {
            gradeLevel.setId(gradeIdList.get(y));
        }
        
        
        schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());
        curriculum.setCurriculumTitle(tfCurriculumName.getText());
        curriculum.setCurriculumDescription(curriculumDescriptionJta.getText());

        if (cdi.checkCurriculumExists(curriculum, schoolYear) == true) {
            JOptionPane.showMessageDialog(null, "Curriculum " + tfCurriculumName.getText() + " already exist"
                    + "\n" + "please choose different grade level and school year");

        } else if (cdi.checkCurriculumExists(curriculum, schoolYear) == true) {
            JOptionPane.showMessageDialog(null, "Curriculum " + tfCurriculumName.getText() + " already exist"
                    + "\n" + "please choose different grade level and school year"
                    + "\n" + "Subject total hours should not exceed");
        } //If not exist
        else {
            if (cdi.createCurriculum(curriculum, schoolYear, gradeLevel) == true) {
                for (int i = 0; i < curriculumSubjectsJtbl.getModel().getRowCount(); i++) {
                    //While looping < rowCount also insert into curriculum_subject_lt

                    //Setter call from Curriculum && Getter call from CurriculumDAOImpl
                    curriculum.setCurriculumId(curriculum.getCurriculumId());

                    //Setter call from Subject
                    subject.setSubjectCode(curriculumSubjectsJtbl.getValueAt(i, 1).toString());

                    subject.setSubjectHours(Double.parseDouble(curriculumSubjectsJtbl.getValueAt(i, 3).toString()));

                    //Setter call from Subject & Method call from SubjectDaoImpl
                    subject.setSubjectId(sdi.getSubjectId(subject));
                    
                    System.out.println(subject.getSubjectId());
                    
                    //Method call from CurriculumDAOImpl
                    cdi.createCurriculumSubjects(curriculum, subject, gradeLevel);
                }
            }
            JOptionPane.showMessageDialog(null, "Successful created " + tfCurriculumName.getText() + " curriculum");
        }
    }//GEN-LAST:event_saveCurriculumJbtnActionPerformed

    private void jcmbGradeLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbGradeLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmbGradeLevelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UpdateCurriculum updateCurriculum;

        //Setter call from Curriculum & Getting the id at selected row at column 0
        curriculum.setCurriculumId((int) tblCreatedCurriculum.getValueAt(tblCreatedCurriculum.getSelectedRow(), 0));
        
        updateCurriculum = new UpdateCurriculum(curriculum.getCurriculumId());
        
        //Set model on tblCreatedCurriculumList
        updateCurriculum.getTblCreatedCurriculumList().setModel(cu.getCreatedCurriculumById(curriculum));

        updateCurriculum.getTblCreatedCurriculumList().getColumnModel().getColumn(0).setMinWidth(0);
        updateCurriculum.getTblCreatedCurriculumList().getColumnModel().getColumn(0).setMaxWidth(0);

        //Set text on jtextfield and jtextarea
        updateCurriculum.getTfCurriculumName().setText((String) tblCreatedCurriculum.getValueAt(tblCreatedCurriculum.getSelectedRow(), 1));
        updateCurriculum.getTaCurriculumDescription().setText((String) tblCreatedCurriculum.getValueAt(tblCreatedCurriculum.getSelectedRow(), 3));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblCreatedCurriculumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCreatedCurriculumMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCreatedCurriculumMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static JTable getTblCreatedCurriculum() {
        return tblCreatedCurriculum;
    }

    public static JTable getTblCurriculumSubjects() {
        return curriculumSubjectsJtbl;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSubjectJbtn;
    private javax.swing.JButton cancelCreateCurriculumJbtn;
    private javax.swing.JTextArea curriculumDescriptionJta;
    private javax.swing.JPanel curriculumSubjectsJPanel;
    private javax.swing.JScrollPane curriculumSubjectsJsp;
    public static javax.swing.JTable curriculumSubjectsJtbl;
    private javax.swing.JLabel gradeLevelJlbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> jcmbGradeLevel;
    public static javax.swing.JPanel jpnlCurriculumCreatorCardContainer;
    public static javax.swing.JPanel jpnlCurriculumListCardContainer;
    private javax.swing.JPanel jpnlSubjectAssignment;
    private javax.swing.JTabbedPane jtpCurriculum;
    private javax.swing.JButton removeSubjectJbtn;
    private javax.swing.JButton saveCurriculumJbtn;
    private javax.swing.JPanel subjectsListJPanel;
    private javax.swing.JScrollPane subjectsListJsp;
    private javax.swing.JTable subjectsListJtbl;
    private static javax.swing.JTable tblCreatedCurriculum;
    private javax.swing.JTextField tfCurriculumName;
    // End of variables declaration//GEN-END:variables
}
