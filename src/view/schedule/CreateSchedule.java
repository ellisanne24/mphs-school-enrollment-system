
package view.schedule;

import component_editor.ScheduleDayCellEditor;
import component_editor.ScheduleRoomCellEditor;
import component_editor.ScheduleTimeCellEditor;
import controller.schedule.CreateScheduleController;
import component_model_loader.SchoolYearML;
import component_renderers.ScheduleTableCellRenderer;
import controller.global.SchoolYearController;
import controller.schedule.AddScheduleController;
import controller.schedule.ClearScheduleFormController;
import controller.schedule.GradeLevelStateChangeController;
import controller.schedule.RemoveSelectedEntryController;
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
        jtblSchedule.setAutoCreateRowSorter(true);
        initializeModels();
        initializeControllers();
        initializeTableCellEditors();
        initializeRenderers();
    }

    private void initializeControllers() {
        CreateScheduleController createController = new CreateScheduleController(jtblSchedule, this, jcmbSection);
        jbtnCreate.addActionListener(createController);
        SchoolYearController schoolYearController = new SchoolYearController(jcmbSchoolYearFrom, jcmbSchoolYearTo);
        jcmbSchoolYearFrom.addItemListener(schoolYearController);

        jcmbGradeLevel.addItemListener(new GradeLevelStateChangeController(jtblSchedule, jcmbGradeLevel, jcmbSection,jbtnRemoveEntry));

        AddScheduleController addScheduleController = new AddScheduleController(jtblSchedule,jbtnAddSchedule);
        jbtnAddSchedule.addActionListener(addScheduleController);
        jbtnClearSchedule.addActionListener(new ClearScheduleFormController(jtblSchedule));
    }

    private void initializeModels() {
        jcmbSchoolYearFrom.setModel(schoolYearModelLoader.getCurrentSchoolYearFrom());
        jcmbSchoolYearTo.setModel(schoolYearModelLoader.getCurrentSchoolYearTo());
        jcmbGradeLevel.setModel(new component_model_loader.GradeLevelML().getAllGradeLevels());
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
        jtblSchedule.setDefaultRenderer(Object.class, new ScheduleTableCellRenderer());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jpnlCreateSchedule = new javax.swing.JPanel();
        jpnlDayAndTime = new javax.swing.JPanel();
        jbtnAddSchedule = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jlblGradeLevel = new javax.swing.JLabel();
        jcmbGradeLevel = new javax.swing.JComboBox<>();
        jlblSection = new javax.swing.JLabel();
        jcmbSection = new javax.swing.JComboBox<>();
        jcmbSchoolYearFrom = new javax.swing.JComboBox<>();
        jlblSchoolYear = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jcmbSchoolYearTo = new javax.swing.JComboBox<>();
        jpnlScheduleTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblSchedule = new javax.swing.JTable();
        jpnlSubmitSchedule = new javax.swing.JPanel();
        jbtnClearSchedule = new javax.swing.JButton();
        jbtnCreate = new javax.swing.JButton();
        jbtnRemoveEntry = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jpnlCreateSchedule.setLayout(new java.awt.GridBagLayout());

        jpnlDayAndTime.setBorder(javax.swing.BorderFactory.createTitledBorder("Schedule"));
        jpnlDayAndTime.setLayout(new java.awt.GridBagLayout());

        jbtnAddSchedule.setText("Add Schedule");
        jbtnAddSchedule.setEnabled(false);
        jbtnAddSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddScheduleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlDayAndTime.add(jbtnAddSchedule, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateSchedule.add(jpnlDayAndTime, gridBagConstraints);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Setting"));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jlblGradeLevel.setText("Grade Level");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jlblGradeLevel, gridBagConstraints);

        jcmbGradeLevel.setRenderer(new component_renderers.GradeLevelJComboBoxRenderer());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbSection, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jLabel9, gridBagConstraints);

        jcmbSchoolYearTo.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbSchoolYearTo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateSchedule.add(jPanel5, gridBagConstraints);

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

        jtblSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Day", "Start Time", "End Time", "Subject", "Faculty", "Room"
            }
        ));
        jtblSchedule.setEnabled(false);
        jtblSchedule.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtblSchedule);

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

        jbtnClearSchedule.setText("Clear Form");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSubmitSchedule.add(jbtnClearSchedule, gridBagConstraints);

        jbtnCreate.setText("Create Schedule");
        jbtnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCreateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSubmitSchedule.add(jbtnCreate, gridBagConstraints);

        jbtnRemoveEntry.setText("Remove Selected");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSubmitSchedule.add(jbtnRemoveEntry, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlSubmitSchedule, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAddScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddScheduleActionPerformed
//        Date startDate = (Date) jsprStartTime.getValue();
//        Calendar myCalendar = Calendar.getInstance();
//        myCalendar.setTime(startDate);
//        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
//        String myStartTime_str = localDateFormat.format(startDate);
//        
//        int myStartHours = myCalendar.get(Calendar.HOUR_OF_DAY) * 100;
//        int myStartMins = myCalendar.get(Calendar.MINUTE);
//        int startTimeINT_fromSpinner = ( (myStartHours)+myStartMins );
//        System.out.println("myStartHours: "+myStartHours);
//        System.out.println("myStartMins: "+myStartMins);
//        System.out.println("startTimeINT_fromSpinner: "+startTimeINT_fromSpinner);
//
//        Date endDate = (Date) jsprEndTime.getValue();
//        String myEndTime_str = localDateFormat.format(endDate);
//        myCalendar.setTime(endDate);
//        int myEndHours = myCalendar.get(Calendar.HOUR_OF_DAY) * 100;
//        int myEndMins = myCalendar.get(Calendar.MINUTE);
//        int endTimeINT_fromSpinner = ( (myEndHours)+myEndMins );

    }//GEN-LAST:event_jbtnAddScheduleActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAddSchedule;
    private javax.swing.JButton jbtnClearSchedule;
    private javax.swing.JButton jbtnCreate;
    private javax.swing.JButton jbtnRemoveEntry;
    private javax.swing.JComboBox<String> jcmbGradeLevel;
    private javax.swing.JComboBox<String> jcmbSchoolYearFrom;
    private javax.swing.JComboBox<String> jcmbSchoolYearTo;
    public static javax.swing.JComboBox<String> jcmbSection;
    private javax.swing.JLabel jlblGradeLevel;
    private javax.swing.JLabel jlblSchoolYear;
    private javax.swing.JLabel jlblSection;
    private javax.swing.JPanel jpnlCreateSchedule;
    private javax.swing.JPanel jpnlDayAndTime;
    private javax.swing.JPanel jpnlScheduleTable;
    private javax.swing.JPanel jpnlSubmitSchedule;
    public static javax.swing.JTable jtblSchedule;
    // End of variables declaration//GEN-END:variables
}
