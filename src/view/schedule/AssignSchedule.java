/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.schedule;

import component_model_loader.FacultyML;
import daoimpl.ScheduleDaoImpl;
import model.faculty.Faculty;

import model.schedule.Schedule;

/**
 *
 * @author John Ferdinand Antonio
 */
public class AssignSchedule extends javax.swing.JDialog {

    ScheduleDaoImpl scheduleDaoImpl = new ScheduleDaoImpl();
    FacultyML facultyML = new FacultyML();
    private int scheduleId;
    
    public AssignSchedule(java.awt.Frame parent, boolean modal,int scheduleId) {
        super(parent, modal);
        initComponents();
        jtblFacultyList.setModel(facultyML.getAllFaculty());
        jpnlCreateSchedule.remove(jpnlDayAndTime);
        jpnlCreateSchedule.remove(jPanel5);
        jpnlCreateSchedule.remove(jpnlRoom);
        this.scheduleId = scheduleId;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jpnlCreateSchedule = new javax.swing.JPanel();
        jpnlDayAndTime = new javax.swing.JPanel();
        jlblStartTime = new javax.swing.JLabel();
        jsprStartTime = new javax.swing.JSpinner();
        jlblEndTime = new javax.swing.JLabel();
        jsprEndTime = new javax.swing.JSpinner();
        jlblDay = new javax.swing.JLabel();
        jcmbDay = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jlblGradeLevel = new javax.swing.JLabel();
        jcmbGradeLevel = new javax.swing.JComboBox<>();
        jlblSection = new javax.swing.JLabel();
        jcmbSection = new javax.swing.JComboBox<>();
        jlblSubject = new javax.swing.JLabel();
        jcmbSubject = new javax.swing.JComboBox<>();
        jcmbSchoolYearFrom = new javax.swing.JComboBox<>();
        jlblSchoolYear = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jcmbSchoolYearTo = new javax.swing.JComboBox<>();
        jpnlRoom = new javax.swing.JPanel();
        jlblRoom = new javax.swing.JLabel();
        jcmbRoom = new javax.swing.JComboBox<>();
        jpnlFacultySelection = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblFacultyList = new javax.swing.JTable();
        jpnlControl = new javax.swing.JPanel();
        jbtnAssignFaculty = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jpnlCreateSchedule.setLayout(new java.awt.GridBagLayout());

        jpnlDayAndTime.setLayout(new java.awt.GridBagLayout());

        jlblStartTime.setText("Start Time");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlDayAndTime.add(jlblStartTime, gridBagConstraints);

        jsprStartTime.setMinimumSize(new java.awt.Dimension(55, 30));
        jsprStartTime.setPreferredSize(new java.awt.Dimension(55, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlDayAndTime.add(jsprStartTime, gridBagConstraints);

        jlblEndTime.setText("End Time");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlDayAndTime.add(jlblEndTime, gridBagConstraints);

        jsprEndTime.setMinimumSize(new java.awt.Dimension(55, 30));
        jsprEndTime.setPreferredSize(new java.awt.Dimension(55, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlDayAndTime.add(jsprEndTime, gridBagConstraints);

        jlblDay.setText("Day");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlDayAndTime.add(jlblDay, gridBagConstraints);

        jcmbDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlDayAndTime.add(jcmbDay, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateSchedule.add(jpnlDayAndTime, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jlblGradeLevel.setText("Grade Level");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jlblGradeLevel, gridBagConstraints);

        jcmbGradeLevel.setModel(new component_model_loader.GradeLevelML().getAllGradeLevels());
        jcmbGradeLevel.setRenderer(new component_renderers.GradeLevelJComboBoxRenderer());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbGradeLevel, gridBagConstraints);

        jlblSection.setText("Section");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jlblSection, gridBagConstraints);

        jcmbSection.setMinimumSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbSection, gridBagConstraints);

        jlblSubject.setText("Subject");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jlblSubject, gridBagConstraints);

        jcmbSubject.setMinimumSize(new java.awt.Dimension(370, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbSubject, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbSchoolYearFrom, gridBagConstraints);

        jlblSchoolYear.setText("School Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jlblSchoolYear, gridBagConstraints);

        jLabel9.setText("to");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jLabel9, gridBagConstraints);

        jcmbSchoolYearTo.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbSchoolYearTo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateSchedule.add(jPanel5, gridBagConstraints);

        jpnlRoom.setLayout(new java.awt.GridBagLayout());

        jlblRoom.setText("Room");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlRoom.add(jlblRoom, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlRoom.add(jcmbRoom, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateSchedule.add(jpnlRoom, gridBagConstraints);

        jpnlFacultySelection.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpnlFacultySelection.setPreferredSize(new java.awt.Dimension(120, 120));
        jpnlFacultySelection.setLayout(new java.awt.GridBagLayout());

        jtblFacultyList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Faculty Id", "Last Name", "First Name", "Middle Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblFacultyList.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtblFacultyList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFacultySelection.add(jScrollPane2, gridBagConstraints);

        jpnlControl.setLayout(new java.awt.GridBagLayout());

        jbtnAssignFaculty.setText("Assign Selected");
        jbtnAssignFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAssignFacultyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlControl.add(jbtnAssignFaculty, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFacultySelection.add(jpnlControl, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateSchedule.add(jpnlFacultySelection, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlCreateSchedule, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAssignFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAssignFacultyActionPerformed
        Faculty f = new Faculty();
        int row = jtblFacultyList.getSelectedRow();
        int col = 0;
        int facultyId = Integer.parseInt(jtblFacultyList.getValueAt(row, col).toString().trim());
        f.setFacultyID(facultyId);
        System.out.println("Faculty Id: "+f.getFacultyID());
        
        Schedule s = new Schedule();
        s.setFaculty(f);
        s.setScheduleId(scheduleId);
        scheduleDaoImpl.assignFaculty(s);
        

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
        
        
    }//GEN-LAST:event_jbtnAssignFacultyActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnAssignFaculty;
    private javax.swing.JComboBox<String> jcmbDay;
    private javax.swing.JComboBox<String> jcmbGradeLevel;
    private javax.swing.JComboBox<String> jcmbRoom;
    private javax.swing.JComboBox<String> jcmbSchoolYearFrom;
    private javax.swing.JComboBox<String> jcmbSchoolYearTo;
    private javax.swing.JComboBox<String> jcmbSection;
    private javax.swing.JComboBox<String> jcmbSubject;
    private javax.swing.JLabel jlblDay;
    private javax.swing.JLabel jlblEndTime;
    private javax.swing.JLabel jlblGradeLevel;
    private javax.swing.JLabel jlblRoom;
    private javax.swing.JLabel jlblSchoolYear;
    private javax.swing.JLabel jlblSection;
    private javax.swing.JLabel jlblStartTime;
    private javax.swing.JLabel jlblSubject;
    private javax.swing.JPanel jpnlControl;
    private javax.swing.JPanel jpnlCreateSchedule;
    private javax.swing.JPanel jpnlDayAndTime;
    private javax.swing.JPanel jpnlFacultySelection;
    private javax.swing.JPanel jpnlRoom;
    private javax.swing.JSpinner jsprEndTime;
    private javax.swing.JSpinner jsprStartTime;
    private javax.swing.JTable jtblFacultyList;
    // End of variables declaration//GEN-END:variables
}
