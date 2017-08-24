package view.faculty;

import component_model_loader.SubjectML;
import controller.faculty.AssignSpecializationController;
import javax.swing.JOptionPane;

import daoimpl.FacultyDaoImpl;
import daoimpl.SpecializationDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.faculty.Faculty;
import model.specialization.Specialization;
import utility.component.TableUtility;

public class NewFaculty extends javax.swing.JPanel {

    public NewFaculty() {
        initComponents();
        jtbl_faculty.setAutoCreateRowSorter(true);
        setjtblFaculty();
        updateSpecializationJcb();
        loadSpecializtionToJtable();
        jlstSubjects.setModel(new SubjectML().getAllSubject());
        TableUtility.setTableColumnWidth(jtblSpecialization);
        jbtnAssignSpecilization.addActionListener(new AssignSpecializationController(jcbSpecializations, jlstFacultySpecialization));
    }

    @SuppressWarnings("unchecked")
    private void loadSpecializtionToJtable() {
        SpecializationDaoImpl sdi = new SpecializationDaoImpl();
        Object[] specializations = sdi.getAll().toArray();
        DefaultTableModel tableModel = (DefaultTableModel) jtblSpecialization.getModel();
        tableModel.setRowCount(0);
        for (Object o : specializations) {
            Specialization s = (Specialization) o;
            Object[] rowData = {
                s.getId(), s.getName(), s.getDescription(), s.getDateCreated()
            };
            tableModel.addRow(rowData);
        }
    }

    private void updateSpecializationJcb() {
        SpecializationDaoImpl sdi = new SpecializationDaoImpl();
        Object[] specializationData = sdi.getAll().toArray();
        DefaultComboBoxModel jcb = (DefaultComboBoxModel) jcbSpecializations.getModel();
        for (Object obj : specializationData) {
            Specialization s = (Specialization) obj;
            jcb.addElement(s.getName());
        }
        jcbSpecializations.setModel(jcb);
    }

    private void search(String query) {
        DefaultTableModel dtm = (DefaultTableModel) jtbl_faculty.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dtm);
        jtbl_faculty.setRowSorter(tr);

        tr.setRowFilter(RowFilter.regexFilter(query));

    }

    public void setjtblFaculty() {

        FacultyDaoImpl fdi = new FacultyDaoImpl();
        Object[] facultyData = fdi.getAll().toArray();
        DefaultTableModel tableModel = (DefaultTableModel) jtbl_faculty.getModel();
        tableModel.setRowCount(0);
        for (Object faculty : facultyData) {
            Faculty f = (Faculty) faculty;
            Object[] object = {
                f.getFacultyID(),
                f.getFirstName(),
                f.getLastName(),
                f.getMiddleName(),
                f.getEmailAddress(),
                f.getContact(),
                f.getStatus() == true ? "Active" : "Inactive"
            };
            tableModel.addRow(object);
        }

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        newFacultyContainer = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        facultyDetails = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtf_fname = new javax.swing.JTextField();
        jtf_lname = new javax.swing.JTextField();
        jtf_mname = new javax.swing.JTextField();
        jtf_email = new javax.swing.JTextField();
        jtf_contact = new javax.swing.JTextField();
        jlblEmployeeId = new javax.swing.JLabel();
        jtfEmployeeId = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jcbSpecializations = new javax.swing.JComboBox<>();
        jbtnAssignSpecilization = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlstFacultySpecialization = new javax.swing.JList<>();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        AddFaculty = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jtf_searchFaculty = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtbl_faculty = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jtfSpecializationName = new javax.swing.JTextField();
        jpnlDescription = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jta_description = new javax.swing.JTextArea();
        jpnlControl = new javax.swing.JPanel();
        updateSpecialization = new javax.swing.JButton();
        addSpecialization = new javax.swing.JButton();
        jpnlSubjectAssignment = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jbtnAddSubjectToAssigned = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jlstSubjects = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        jlstSubjectsAssigned = new javax.swing.JList<>();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtblSpecialization = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        newFacultyContainer.setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel3.setLayout(new java.awt.BorderLayout());

        facultyDetails.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        facultyDetails.setLayout(new java.awt.GridBagLayout());

        jPanel5.setPreferredSize(new java.awt.Dimension(250, 464));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("First Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Last Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Middle Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Email Address:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Contact Number:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jLabel5, gridBagConstraints);

        jtf_fname.setColumns(8);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jtf_fname, gridBagConstraints);

        jtf_lname.setColumns(8);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jtf_lname, gridBagConstraints);

        jtf_mname.setColumns(8);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jtf_mname, gridBagConstraints);

        jtf_email.setColumns(8);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jtf_email, gridBagConstraints);

        jtf_contact.setColumns(8);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jtf_contact, gridBagConstraints);

        jlblEmployeeId.setText("Employee ID :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jlblEmployeeId, gridBagConstraints);

        jtfEmployeeId.setColumns(8);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jtfEmployeeId, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        facultyDetails.add(jPanel5, gridBagConstraints);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))), "Specialization", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 14))); // NOI18N
        jPanel6.setPreferredSize(new java.awt.Dimension(370, 464));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jPanel7.setPreferredSize(new java.awt.Dimension(360, 350));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jPanel12.setPreferredSize(new java.awt.Dimension(150, 344));
        jPanel12.setLayout(new java.awt.GridBagLayout());

        jcbSpecializations.setPreferredSize(new java.awt.Dimension(120, 25));
        jcbSpecializations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSpecializationsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel12.add(jcbSpecializations, gridBagConstraints);

        jbtnAssignSpecilization.setText("+");
        jbtnAssignSpecilization.setPreferredSize(new java.awt.Dimension(100, 30));
        jbtnAssignSpecilization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAssignSpecilizationActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel12.add(jbtnAssignSpecilization, gridBagConstraints);

        jButton4.setText("-");
        jButton4.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel12.add(jButton4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel7.add(jPanel12, gridBagConstraints);

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel13.setPreferredSize(new java.awt.Dimension(200, 344));
        jPanel13.setLayout(new java.awt.GridBagLayout());

        jPanel14.setLayout(new java.awt.GridBagLayout());

        jScrollPane2.setPreferredSize(new java.awt.Dimension(259, 300));

        jlstFacultySpecialization.setModel(new DefaultListModel());
        jlstFacultySpecialization.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlstFacultySpecializationMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jlstFacultySpecialization);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel14.add(jScrollPane2, gridBagConstraints);
        jPanel14.add(jSeparator1, new java.awt.GridBagConstraints());

        jScrollPane3.setViewportView(jPanel14);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel13.add(jScrollPane3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel7.add(jPanel13, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jPanel7, gridBagConstraints);

        jPanel8.setPreferredSize(new java.awt.Dimension(360, 40));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        AddFaculty.setText("Save");
        AddFaculty.setPreferredSize(new java.awt.Dimension(100, 30));
        AddFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFacultyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel8.add(AddFaculty, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel6.add(jPanel8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        facultyDetails.add(jPanel6, gridBagConstraints);

        jPanel3.add(facultyDetails, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Add Faculty", jPanel3);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setPreferredSize(new java.awt.Dimension(985, 40));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel9.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel9.add(jLabel9, gridBagConstraints);

        jtf_searchFaculty.setPreferredSize(new java.awt.Dimension(140, 25));
        jtf_searchFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_searchFacultyActionPerformed(evt);
            }
        });
        jtf_searchFaculty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_searchFacultyKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_searchFacultyKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel9.add(jtf_searchFaculty, gridBagConstraints);

        jButton1.setText("Refresh");
        jPanel9.add(jButton1, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(jPanel9, gridBagConstraints);

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setPreferredSize(new java.awt.Dimension(985, 390));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel15.setLayout(new java.awt.BorderLayout());

        jtbl_faculty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Faculty ID", "First Name", "Last Name", "Middle Name", "Email Address", "Contact", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_faculty.getTableHeader().setReorderingAllowed(false);
        jtbl_faculty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_facultyMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbl_facultyMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(jtbl_faculty);
        if (jtbl_faculty.getColumnModel().getColumnCount() > 0) {
            jtbl_faculty.getColumnModel().getColumn(0).setResizable(false);
            jtbl_faculty.getColumnModel().getColumn(1).setResizable(false);
            jtbl_faculty.getColumnModel().getColumn(2).setResizable(false);
            jtbl_faculty.getColumnModel().getColumn(3).setResizable(false);
            jtbl_faculty.getColumnModel().getColumn(4).setResizable(false);
            jtbl_faculty.getColumnModel().getColumn(5).setResizable(false);
            jtbl_faculty.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel15.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jScrollPane1.setViewportView(jPanel15);

        jPanel10.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jPanel10, gridBagConstraints);

        jPanel4.add(jPanel2, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Faculty", jPanel4);

        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        jPanel16.setLayout(new java.awt.GridBagLayout());

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Create Specialization", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 14))); // NOI18N
        jPanel17.setPreferredSize(new java.awt.Dimension(800, 400));
        jPanel17.setLayout(new java.awt.GridBagLayout());

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel18.setPreferredSize(new java.awt.Dimension(350, 370));
        jPanel18.setLayout(new java.awt.GridBagLayout());

        jPanel20.setAlignmentX(0.0F);
        jPanel20.setAlignmentY(0.0F);
        jPanel20.setPreferredSize(new java.awt.Dimension(130, 50));
        jPanel20.setLayout(new java.awt.GridBagLayout());

        jLabel10.setText("Specialization");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel20.add(jLabel10, gridBagConstraints);

        jtfSpecializationName.setColumns(8);
        jtfSpecializationName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSpecializationNameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel20.add(jtfSpecializationName, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel18.add(jPanel20, gridBagConstraints);

        jpnlDescription.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 14))); // NOI18N
        jpnlDescription.setMinimumSize(new java.awt.Dimension(100, 100));
        jpnlDescription.setPreferredSize(new java.awt.Dimension(310, 310));
        jpnlDescription.setLayout(new java.awt.GridBagLayout());

        jScrollPane4.setPreferredSize(new java.awt.Dimension(310, 310));

        jta_description.setColumns(20);
        jta_description.setRows(5);
        jta_description.setPreferredSize(new java.awt.Dimension(310, 310));
        jScrollPane4.setViewportView(jta_description);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jpnlDescription.add(jScrollPane4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel18.add(jpnlDescription, gridBagConstraints);

        jpnlControl.setPreferredSize(new java.awt.Dimension(340, 50));
        jpnlControl.setLayout(new java.awt.GridBagLayout());

        updateSpecialization.setText("Update");
        updateSpecialization.setPreferredSize(new java.awt.Dimension(100, 30));
        updateSpecialization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSpecializationActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jpnlControl.add(updateSpecialization, gridBagConstraints);

        addSpecialization.setText("Create");
        addSpecialization.setPreferredSize(new java.awt.Dimension(100, 30));
        addSpecialization.setRequestFocusEnabled(false);
        addSpecialization.setVerifyInputWhenFocusTarget(false);
        addSpecialization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSpecializationActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jpnlControl.add(addSpecialization, gridBagConstraints);
        addSpecialization.getAccessibleContext().setAccessibleDescription("");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel18.add(jpnlControl, gridBagConstraints);

        jpnlSubjectAssignment.setLayout(new java.awt.GridBagLayout());

        jPanel24.setLayout(new java.awt.GridBagLayout());

        jbtnAddSubjectToAssigned.setText(">");
        jbtnAddSubjectToAssigned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddSubjectToAssignedActionPerformed(evt);
            }
        });
        jPanel24.add(jbtnAddSubjectToAssigned, new java.awt.GridBagConstraints());

        jButton2.setText("<");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel24.add(jButton2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jpnlSubjectAssignment.add(jPanel24, gridBagConstraints);

        jScrollPane9.setBorder(javax.swing.BorderFactory.createTitledBorder("Subject List"));

        jlstSubjects.setModel(new DefaultListModel());
        jScrollPane9.setViewportView(jlstSubjects);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jpnlSubjectAssignment.add(jScrollPane9, gridBagConstraints);

        jScrollPane8.setBorder(javax.swing.BorderFactory.createTitledBorder("Subjects Assigned"));

        jlstSubjectsAssigned.setModel(new DefaultListModel());
        jScrollPane8.setViewportView(jlstSubjectsAssigned);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jpnlSubjectAssignment.add(jScrollPane8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel18.add(jpnlSubjectAssignment, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel17.add(jPanel18, gridBagConstraints);

        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel19.setPreferredSize(new java.awt.Dimension(430, 370));
        jPanel19.setLayout(new java.awt.BorderLayout());

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jtblSpecialization.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Specialization Name", "Description", "Date Created"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblSpecialization.setMinimumSize(new java.awt.Dimension(500, 5000));
        jtblSpecialization.setPreferredSize(new java.awt.Dimension(500, 5000));
        jtblSpecialization.setRowHeight(30);
        jtblSpecialization.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblSpecializationMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jtblSpecialization);

        jPanel1.add(jScrollPane7, java.awt.BorderLayout.CENTER);

        jScrollPane6.setViewportView(jPanel1);

        jPanel19.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel17.add(jPanel19, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel16.add(jPanel17, gridBagConstraints);

        jPanel11.add(jPanel16);

        jTabbedPane1.addTab("Specialization", jPanel11);

        newFacultyContainer.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        add(newFacultyContainer, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void AddFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddFacultyActionPerformed
        int choice = JOptionPane.showConfirmDialog(null, "Add?", "Add Confirmation?", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            if (formIsValid()) {
                addFacultyMember();
            }else{
                JOptionPane.showMessageDialog(null,"Please fill out all fields.");
            }
        }
    }//GEN-LAST:event_AddFacultyActionPerformed

    private void addFacultyMember() {
        SpecializationDaoImpl sdi = new SpecializationDaoImpl();
        Faculty faculty = new Faculty();
        faculty.setEmployeeId(jtfEmployeeId.getText().trim());
        faculty.setFirstName(jtf_fname.getText().trim());
        faculty.setLastName(jtf_lname.getText().trim());
        faculty.setMiddleName(jtf_mname.getText().trim());
        faculty.setEmailAddress(jtf_email.getText().trim());
        faculty.setContact(jtf_contact.getText().trim());
        int listSize = jlstFacultySpecialization.getModel().getSize();
        List<Specialization> specializationList = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            int specId = sdi.getId(jlstFacultySpecialization.getModel().getElementAt(i).trim());
            System.out.println("Id : " + specId);
            Specialization specialization = new Specialization();
            specialization.setId(specId);
            specializationList.add(specialization);
        }
        faculty.setSpecializations(specializationList);

        FacultyDaoImpl fdi = new daoimpl.FacultyDaoImpl();
        boolean isAdded = fdi.add(faculty);
        if (isAdded) {
            jtf_fname.setText("");
            jtf_lname.setText("");
            jtf_mname.setText("");
            jtf_contact.setText("");
            jtf_email.setText("");
            ((DefaultListModel) jlstFacultySpecialization.getModel()).clear();
            JOptionPane.showMessageDialog(null, "Successfully added");
            setjtblFaculty();
        } else {
            JOptionPane.showMessageDialog(null, "Error occured during Adding ");
        }
    }

    private boolean formIsValid() {
        boolean isValid = true;
        if (jtf_fname.getText().isEmpty() || jtf_lname.getText().isEmpty() || jtf_mname.getText().isEmpty()
                || jtf_contact.getText().isEmpty() || jtf_email.getText().isEmpty()
                || ((DefaultListModel) jlstFacultySpecialization.getModel()).isEmpty()) {
            isValid = false;
        }
        return isValid;
    }


    private void addSpecializationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSpecializationActionPerformed
        Specialization s = new Specialization();
        s.setName(jtfSpecializationName.getText().trim());
        s.setDescription(jta_description.getText().trim());

        int add = JOptionPane.showConfirmDialog(null, "Submit new Specialization??", "SUBMIT", JOptionPane.YES_NO_OPTION);

        if (add == JOptionPane.YES_OPTION) {
            SpecializationDaoImpl sdi = new SpecializationDaoImpl();
            boolean isAdded = sdi.add(s);
            if (isAdded) {
                jtfSpecializationName.setText("");
                jta_description.setText("");
                JOptionPane.showMessageDialog(null, "Successfully added");

                loadSpecializtionToJtable();
                updateSpecializationJcb();
            } else {
                JOptionPane.showMessageDialog(null, "Error occured during Adding ");
            }
        }
    }//GEN-LAST:event_addSpecializationActionPerformed

    private void jtf_searchFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_searchFacultyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_searchFacultyActionPerformed

    private void jtbl_facultyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_facultyMouseClicked
        if (evt.getClickCount() == 2) {
            int selectedRow = jtbl_faculty.getSelectedRow();
            String valueOfFirstRowFirstColumn = jtbl_faculty.getValueAt(selectedRow, 0).toString();
            int FacultyID = Integer.parseInt(valueOfFirstRowFirstColumn);
            UpdateFaculty faculty = new UpdateFaculty(null, true, FacultyID);
            faculty.setLocationRelativeTo(null);
            faculty.setVisible(true);
        }
    }//GEN-LAST:event_jtbl_facultyMouseClicked

    private void jtbl_facultyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_facultyMousePressed


    }//GEN-LAST:event_jtbl_facultyMousePressed

    private void jtf_searchFacultyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_searchFacultyKeyPressed

    }//GEN-LAST:event_jtf_searchFacultyKeyPressed

    private void jtf_searchFacultyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_searchFacultyKeyReleased

        String query = jtf_searchFaculty.getText().toLowerCase();
        search(query);


    }//GEN-LAST:event_jtf_searchFacultyKeyReleased

    private void jcbSpecializationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSpecializationsActionPerformed

    }//GEN-LAST:event_jcbSpecializationsActionPerformed

    private void jtfSpecializationNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSpecializationNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSpecializationNameActionPerformed

    private void jbtnAssignSpecilizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAssignSpecilizationActionPerformed
//        DefaultListModel listModel = (DefaultListModel) addSpecializationToFaculty.getModel();
//        DefaultListModel dlm = new DefaultListModel();
//        listModel.addElement(jcb_getSpecialization.getSelectedItem().toString());
//        addSpecializationToFaculty.setModel(dlm);
//        addSpecializationToFaculty.setModel(new DefaultListModel<>());
//        ((DefaultListModel) addSpecializationToFaculty.getModel()).addElement(jcb_getSpecialization.getSelectedItem().toString());

    }//GEN-LAST:event_jbtnAssignSpecilizationActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultListModel dlm = new DefaultListModel();
        String o = jcbSpecializations.getSelectedItem().toString();
        dlm.removeElement(o);
        jlstFacultySpecialization.setModel(dlm);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jlstFacultySpecializationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlstFacultySpecializationMouseClicked

    }//GEN-LAST:event_jlstFacultySpecializationMouseClicked

    private void jtblSpecializationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblSpecializationMouseClicked

        String title = jtblSpecialization.getValueAt(jtblSpecialization.getSelectedRow(), 1).toString();
        String description = jtblSpecialization.getValueAt(jtblSpecialization.getSelectedRow(), 2).toString();

        jtfSpecializationName.setText(title);
        jta_description.setText(description);
    }//GEN-LAST:event_jtblSpecializationMouseClicked

    private void updateSpecializationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSpecializationActionPerformed

        FacultyDaoImpl fdi = new FacultyDaoImpl();

        String title = jtfSpecializationName.getText().trim();
        String description = jta_description.getText().trim();
        int specializationId = Integer.parseInt(jtblSpecialization.getValueAt(jtblSpecialization.getSelectedRow(), 0).toString());

        Faculty faculty = new Faculty();
//        faculty.setSpecializationID(specializationId);
//        faculty.setSpecializationTitle(title);
//        faculty.setSpecializationDescription(description);

        int update = JOptionPane.showConfirmDialog(null, "Update faculty?", "SUBMIT", JOptionPane.YES_NO_OPTION);

        if (update == JOptionPane.YES_OPTION) {
            boolean isUpdated = fdi.update(faculty);
            if (isUpdated) {
                jtfSpecializationName.setText("");
                jta_description.setText("");

                loadSpecializtionToJtable();
                updateSpecializationJcb();
                JOptionPane.showMessageDialog(null, "Successfully Updated");

            } else {
                JOptionPane.showMessageDialog(null, "Error occured during Updating ");
            }
        }
    }//GEN-LAST:event_updateSpecializationActionPerformed

    private void jbtnAddSubjectToAssignedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddSubjectToAssignedActionPerformed
        if (jlstSubjects.getSelectedIndex() > -1) {
            String s = jlstSubjects.getSelectedValue();
            DefaultListModel model = (DefaultListModel) jlstSubjectsAssigned.getModel();
            if (!model.contains(s)) {
                model.addElement(s);
            } else {
                JOptionPane.showMessageDialog(null, s + " is already on the list.");
            }
        }
    }//GEN-LAST:event_jbtnAddSubjectToAssignedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddFaculty;
    private javax.swing.JButton addSpecialization;
    private javax.swing.JPanel facultyDetails;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtnAddSubjectToAssigned;
    private javax.swing.JButton jbtnAssignSpecilization;
    private javax.swing.JComboBox<String> jcbSpecializations;
    private javax.swing.JLabel jlblEmployeeId;
    private javax.swing.JList<String> jlstFacultySpecialization;
    private javax.swing.JList<String> jlstSubjects;
    private javax.swing.JList<String> jlstSubjectsAssigned;
    private javax.swing.JPanel jpnlControl;
    private javax.swing.JPanel jpnlDescription;
    private javax.swing.JPanel jpnlSubjectAssignment;
    private javax.swing.JTextArea jta_description;
    private javax.swing.JTable jtblSpecialization;
    public static javax.swing.JTable jtbl_faculty;
    private javax.swing.JTextField jtfEmployeeId;
    private javax.swing.JTextField jtfSpecializationName;
    private javax.swing.JTextField jtf_contact;
    private javax.swing.JTextField jtf_email;
    private javax.swing.JTextField jtf_fname;
    private javax.swing.JTextField jtf_lname;
    private javax.swing.JTextField jtf_mname;
    private javax.swing.JTextField jtf_searchFaculty;
    private javax.swing.JPanel newFacultyContainer;
    private javax.swing.JButton updateSpecialization;
    // End of variables declaration//GEN-END:variables
}
