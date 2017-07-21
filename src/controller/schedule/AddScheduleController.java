/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.schedule;

import daoimpl.GradeLevelDaoImpl;
import daoimpl.SectionDaoImpl;
import daoimpl.SubjectDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.schedule.Schedule;

/**
 *
 * @author John Ferdinand Antonio
 */
public class AddScheduleController implements ActionListener {
    private final JTable jtblSchedule;
    private final JSpinner jsprNewStartTime;
    private final JSpinner jsprNewEndTime;
    private final JComboBox jcmbGradeLevel;
    private final JComboBox jcmbSubject;
    private final JComboBox jcmbSchoolYearFrom;
    private final JComboBox jcmbSchoolYearEnd;
    private final JComboBox jcmbDay;
    private final JComboBox jcmbRoom;
    private final JComboBox jcmbSection;
    
    public AddScheduleController(JTable jtblSchedule,JSpinner jsprNewStartTime,
            JSpinner jsprNewEndTime, JComboBox jcmbGradeLevel, JComboBox jcmbSubject,
            JComboBox jcmbSchoolYearFrom, JComboBox jcmbSchoolYearTo, 
            JComboBox jcmbDay,JComboBox jcmbRoom, JComboBox jcmbSection){
        
        this.jtblSchedule = jtblSchedule;
        this.jsprNewStartTime = jsprNewStartTime;
        this.jsprNewEndTime = jsprNewEndTime;
        this.jcmbGradeLevel = jcmbGradeLevel;
        this.jcmbSubject = jcmbSubject;
        this.jcmbSchoolYearFrom = jcmbSchoolYearFrom;
        this.jcmbSchoolYearEnd = jcmbSchoolYearTo;
        this.jcmbDay = jcmbDay;
        this.jcmbRoom = jcmbRoom;
        this.jcmbSection = jcmbSection;
    }
    
    private Schedule getSchedule(){
        SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
        GradeLevelDaoImpl gradeLevelDaoImpl = new GradeLevelDaoImpl();
        SectionDaoImpl sectionDaoImpl = new SectionDaoImpl();
        
        Date startDate = (Date)jsprNewStartTime.getValue();
        Calendar calA = Calendar.getInstance();
        calA.setTime(startDate);
        int startHr = calA.get(Calendar.HOUR_OF_DAY) * 100;
        int startMin = calA.get(Calendar.MINUTE);
        int startTime = (startHr + startMin);
        
        Date endDate = (Date)jsprNewEndTime.getValue();
        Calendar calB = Calendar.getInstance();
        calB.setTime(endDate);
        int endHr = calB.get(Calendar.HOUR_OF_DAY) * 100;
        int endMin = calB.get(Calendar.MINUTE);
        int endTime = (endHr + endMin);
        
        Schedule schedule = new Schedule();
        schedule.setDay(jcmbDay.getSelectedItem().toString().trim());
        schedule.setStartTime(startTime);
        schedule.setEndTime(endTime);
        schedule.setRoomName(jcmbRoom.getSelectedItem().toString().trim());
        schedule.setSubjectName(jcmbSubject.getSelectedItem().toString().trim());
        schedule.setSectionName(jcmbSection.getSelectedItem().toString().trim());
        
        return schedule;
    }
    
    private void addSchedule() {
        Schedule newSchedule = getSchedule();
        ScheduleValidator s = new ScheduleValidator(newSchedule, jtblSchedule);
        if (s.isValid()) {
            DefaultTableModel tableModel = (DefaultTableModel) jtblSchedule.getModel();
            Object[] rowData = {
                newSchedule.getDay(), newSchedule.getStartTime(), newSchedule.getEndTime(),
                newSchedule.getSubjectName(),newSchedule.getSectionName(),newSchedule.getRoomName()
            };
            tableModel.addRow(rowData);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        addSchedule();
    }

    private class ScheduleValidator {

        private final Schedule scheduleEntry;
        private final JTable table;
        private boolean isValid;

        public ScheduleValidator(Schedule scheduleEntry, JTable table) {
            this.scheduleEntry = scheduleEntry;
            this.table = table;
            validateScheduleEntry();
        }
        
        public boolean isValid(){
            return isValid;
        }
        
        private boolean isTimeValid(int startTimeNew, int endTimeNew){
            boolean isTimeValid = ((startTimeNew < endTimeNew) && ((startTimeNew >0) && (endTimeNew > 0)) );
            if(isTimeValid){
                
            }else{
                JOptionPane.showMessageDialog(null,"Time is invalid.\nPlease check START time and END time.");
            }
            return isTimeValid;
        }
        
        private boolean hasTimeConflict(int startTime, int endTime, int startTimeNew, int endTimeNew) {
            boolean hasTimeConflict = false;
            boolean timeConflictA = ((startTimeNew >= startTime) && (endTimeNew <= endTime));
            boolean timeConflictB = ((startTimeNew < startTime) && (endTimeNew > startTime && endTimeNew <= endTime));
            boolean timeConflictC = startTimeNew == endTimeNew;

            if (timeConflictA == true) {
                hasTimeConflict = true;
            } else if (timeConflictB == true) {
                hasTimeConflict = true;
            } else if (timeConflictC == true) {
                hasTimeConflict = true;
            }
            
            if(hasTimeConflict){
                JOptionPane.showMessageDialog(null, "Time conflict.");
            }
            
            return hasTimeConflict;
        }
        
        private void validateScheduleEntry() {
            int startTimeEntry = scheduleEntry.getStartTime();
            int endTimeEntry = scheduleEntry.getEndTime();
            String dayEntry = scheduleEntry.getDay();
            String roomEntry = scheduleEntry.getRoomName();

            boolean scheduleIsEmpty = (table.getRowCount() == 0);
            
            if (scheduleIsEmpty) {
                isValid = isTimeValid(startTimeEntry, endTimeEntry);
            } else {
                for (int row = 0; row < table.getRowCount(); row++) {
                    String day = table.getValueAt(row, 0).toString();
                    int startTime = Integer.parseInt(table.getValueAt(row, 1).toString().trim());
                    int endTime = Integer.parseInt(table.getValueAt(row, 2).toString().trim());
                    String room = table.getValueAt(row,5).toString().trim();
                    
                    boolean hasSameDay = (dayEntry.equals(day));
                    boolean hasSameRoom = (roomEntry.equals(room));

                    if (hasSameDay && hasSameRoom) {
                        isValid = !hasTimeConflict(startTime, endTime, startTimeEntry, endTimeEntry);
                    } else if(hasSameDay && !hasSameRoom){
                        isValid = true;
                    }else {
                        isValid = true;
                    }
                }
            }
        }
    }
}
