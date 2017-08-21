
package view.schedule;

import component_editor.ScheduleDayCellEditor;
import component_editor.ScheduleRoomCellEditor;
import component_editor.ScheduleTimeCellEditor;
import component_model_loader.RoomML;
import controller.schedule.CreateScheduleController;
import component_model_loader.SchoolYearML;
import component_renderers.ScheduleTableCellRenderer;
import controller.global.SchoolYearController;
import controller.schedule.AddRowToSchedule;
import controller.schedule.ClearScheduleFormController;
import controller.schedule.GradeLevelStateChangeController;
import controller.schedule.RoomStateChange;
import controller.schedule.SectionStateChange;
import java.awt.event.KeyEvent;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author John Ferdinand Antonio
 */
public class CreateSchedule extends javax.swing.JDialog {

    SchoolYearML schoolYearModelLoader = new SchoolYearML();

    public CreateSchedule(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jlblConflictInfo.setText("");
        jtblSchedule.setAutoCreateRowSorter(true);
        initializeModels();
        initializeControllers();
        initializeTableCellEditors();
        initializeRenderers();
    }

    private void initializeControllers() {
        CreateScheduleController createController
                = new CreateScheduleController(
                        jtblSchedule, this, jcmbSection, jpnlCreateSchedule, jlblConflictInfo, jcmbGradeLevel
                );
        jbtnCreate.addActionListener(createController);
        SchoolYearController schoolYearController = new SchoolYearController(jcmbSchoolYearFrom, jcmbSchoolYearTo);
        jcmbSchoolYearFrom.addItemListener(schoolYearController);

        jcmbGradeLevel.addItemListener(
                new GradeLevelStateChangeController(jtblSchedule, jcmbGradeLevel, jcmbSection,jbtnRemoveEntry,jcmbRoom)
        );
        jbtnAddRow.addActionListener(new AddRowToSchedule(jtblSchedule,jcmbRoom));
        
        jcmbRoom.addItemListener(new RoomStateChange(jcmbRoom, jtblSchedule));
        jbtnClearSchedule.addActionListener(new ClearScheduleFormController(jtblSchedule));
        jcmbSection.addItemListener(new SectionStateChange(jcmbSection, jtblSchedule, jcmbGradeLevel,jcmbRoom));
    }

    private void initializeModels() {
        jcmbSchoolYearFrom.setModel(schoolYearModelLoader.getCurrentSchoolYearFrom());
        jcmbSchoolYearTo.setModel(schoolYearModelLoader.getCurrentSchoolYearTo());
        jcmbGradeLevel.setModel(new component_model_loader.GradeLevelML().getAllGradeLevels());
        jcmbRoom.setModel(new RoomML().getRoomNames());
    }
    
    public static void initializeTableCellEditors() {
        TableColumnModel columnModel = jtblSchedule.getColumnModel();
        TableColumn daysCol = columnModel.getColumn(0);
        TableColumn startTimeCol = columnModel.getColumn(1);
        TableColumn endTimeCol = columnModel.getColumn(2);
        TableColumn roomsCol = columnModel.getColumn(5);
        
        startTimeCol.setCellEditor(new ScheduleTimeCellEditor(jtblSchedule));
        endTimeCol.setCellEditor(new ScheduleTimeCellEditor(jtblSchedule));
        daysCol.setCellEditor(new ScheduleDayCellEditor());
        roomsCol.setCellEditor(new ScheduleRoomCellEditor());
    }
    
    private void initializeRenderers(){
        jtblSchedule.setDefaultRenderer(Object.class, new ScheduleTableCellRenderer(jlblConflictInfo));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jpnlCreateSchedule = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jlblGradeLevel = new javax.swing.JLabel();
        jcmbGradeLevel = new javax.swing.JComboBox<>();
        jlblSection = new javax.swing.JLabel();
        jcmbSection = new javax.swing.JComboBox<>();
        jcmbSchoolYearFrom = new javax.swing.JComboBox<>();
        jlblSchoolYear = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jcmbSchoolYearTo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jcmbRoom = new javax.swing.JComboBox<>();
        jlblConflictInfo = new javax.swing.JLabel();
        jpnlScheduleTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblSchedule = new javax.swing.JTable();
        jpnlSubmitSchedule = new javax.swing.JPanel();
        jbtnAddRow = new javax.swing.JButton();
        jbtnRemoveEntry = new javax.swing.JButton();
        jbtnClearSchedule = new javax.swing.JButton();
        jbtnCreate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jpnlCreateSchedule.setLayout(new java.awt.GridBagLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Control"));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jlblGradeLevel.setText("Grade Level");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jlblGradeLevel, gridBagConstraints);

        jcmbGradeLevel.setRenderer(new component_renderers.GradeLevelJComboBoxRenderer());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbGradeLevel, gridBagConstraints);

        jlblSection.setText("Section");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jlblSection, gridBagConstraints);

        jcmbSection.setEnabled(false);
        jcmbSection.setMinimumSize(new java.awt.Dimension(80, 26));
        jcmbSection.setPreferredSize(new java.awt.Dimension(80, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbSection, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbSchoolYearFrom, gridBagConstraints);

        jlblSchoolYear.setText("School Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jlblSchoolYear, gridBagConstraints);

        jLabel9.setText("to");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jLabel9, gridBagConstraints);

        jcmbSchoolYearTo.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbSchoolYearTo, gridBagConstraints);

        jLabel1.setText("Room ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jLabel1, gridBagConstraints);

        jcmbRoom.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbRoom, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateSchedule.add(jPanel5, gridBagConstraints);

        jlblConflictInfo.setText("Conflict Details");
        jpnlCreateSchedule.add(jlblConflictInfo, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlCreateSchedule, gridBagConstraints);

        jpnlScheduleTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpnlScheduleTable.setPreferredSize(new java.awt.Dimension(600, 410));
        jpnlScheduleTable.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setMinimumSize(new java.awt.Dimension(500, 402));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 402));

        jtblSchedule.setAutoCreateRowSorter(true);
        jtblSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Day", "Start Time", "End Time", "Subject", "Faculty", "Room"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblSchedule.setColumnSelectionAllowed(true);
        jtblSchedule.setEnabled(false);
        jtblSchedule.setRowHeight(30);
        jtblSchedule.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jtblSchedule.getTableHeader().setReorderingAllowed(false);
        jtblSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblScheduleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtblScheduleMousePressed(evt);
            }
        });
        jtblSchedule.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblScheduleKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtblSchedule);
        jtblSchedule.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlScheduleTable.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlScheduleTable, gridBagConstraints);

        jpnlSubmitSchedule.setLayout(new java.awt.GridBagLayout());

        jbtnAddRow.setText("Add Row");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSubmitSchedule.add(jbtnAddRow, gridBagConstraints);

        jbtnRemoveEntry.setText("Remove Row");
        jbtnRemoveEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRemoveEntryActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSubmitSchedule.add(jbtnRemoveEntry, gridBagConstraints);

        jbtnClearSchedule.setText("Clear Form");
        jbtnClearSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClearScheduleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSubmitSchedule.add(jbtnClearSchedule, gridBagConstraints);

        jbtnCreate.setText("Create Schedule");
        jbtnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCreateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSubmitSchedule.add(jbtnCreate, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlSubmitSchedule, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCreateActionPerformed
//        int choice = JOptionPane.showConfirmDialog(null, "Add Schedule","Add Schedule?",JOptionPane.YES_NO_OPTION);
//        if(choice == JOptionPane.YES_OPTION){
//            boolean isSuccessful = true;
//            for(int i=0; i < jtblSchedule.getRowCount(); i++){
//                for(int j = 0; j < jtblSchedule.getColumnCount(); j++){
//                    String startTime = (String) jtblSchedule.getValueAt(i,1);
//                    String[] startTimeParts = startTime.split(":") ;
//                    startTimeINT = Integer.parseInt(startTimeParts[0]+startTimeParts[1]);
//
//                    String endTime = (String) jtblSchedule.getValueAt(i,2);
//                    String[] endTimeParts = endTime.split(":") ;
//                    endTimeINT = Integer.parseInt(endTimeParts[0]+endTimeParts[1]);
//
//                    myGradeLevel = (String) jtblSchedule.getValueAt(i, 5);
//                    myRoom = (String) jtblSchedule.getValueAt(i, 3);
//                    mySectionName = (String) jtblSchedule.getValueAt(i, 6);
//                    mySubject = (String) jtblSchedule.getValueAt(i, 4);
//                    myDay = (String) jtblSchedule.getValueAt(i,0);
//                }
//            }
//        }
    }//GEN-LAST:event_jbtnCreateActionPerformed

    private void jbtnClearScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnClearScheduleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnClearScheduleActionPerformed

    private void jbtnRemoveEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRemoveEntryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnRemoveEntryActionPerformed

    private void jtblScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblScheduleMouseClicked
        
    }//GEN-LAST:event_jtblScheduleMouseClicked

    private void jtblScheduleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblScheduleMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtblScheduleMousePressed

    private void jtblScheduleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblScheduleKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            jpnlScheduleTable.repaint();
        }
    }//GEN-LAST:event_jtblScheduleKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAddRow;
    private javax.swing.JButton jbtnClearSchedule;
    private javax.swing.JButton jbtnCreate;
    private javax.swing.JButton jbtnRemoveEntry;
    private javax.swing.JComboBox<String> jcmbGradeLevel;
    private javax.swing.JComboBox<String> jcmbRoom;
    private javax.swing.JComboBox<String> jcmbSchoolYearFrom;
    private javax.swing.JComboBox<String> jcmbSchoolYearTo;
    public static javax.swing.JComboBox<String> jcmbSection;
    private javax.swing.JLabel jlblConflictInfo;
    private javax.swing.JLabel jlblGradeLevel;
    private javax.swing.JLabel jlblSchoolYear;
    private javax.swing.JLabel jlblSection;
    private javax.swing.JPanel jpnlCreateSchedule;
    private javax.swing.JPanel jpnlScheduleTable;
    private javax.swing.JPanel jpnlSubmitSchedule;
    public static javax.swing.JTable jtblSchedule;
    // End of variables declaration//GEN-END:variables
}
