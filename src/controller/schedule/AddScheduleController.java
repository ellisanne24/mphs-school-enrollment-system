/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.schedule;

import daoimpl.FacultyDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.SectionDaoImpl;
import daoimpl.SubjectDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.schedule.Schedule;

/**
 *
 * @author John Ferdinand Antonio
 */
public class AddScheduleController implements ActionListener {
    private final JTable jtblSchedule;
    private final JButton jbtnAddSchedule;
    
    public AddScheduleController(JTable jtblSchedule,JButton jbtnAddSchedule){
        this.jtblSchedule = jtblSchedule;
        this.jbtnAddSchedule = jbtnAddSchedule;
    }
    
    private Schedule getSchedule(){
        SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
        GradeLevelDaoImpl gradeLevelDaoImpl = new GradeLevelDaoImpl();
        SectionDaoImpl sectionDaoImpl = new SectionDaoImpl();
        FacultyDaoImpl facultyDaoImpl = new FacultyDaoImpl();
        
        Schedule schedule = new Schedule();
        
        return schedule;
    }
    
    private void addSchedule() {
        Schedule newSchedule = getSchedule();
        ScheduleValidator s = new ScheduleValidator(newSchedule, jtblSchedule);
        if (s.isValid()) {

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
            boolean timeConflictC = (startTimeNew == endTimeNew);
            boolean timeConflictD = (startTimeNew == startTime) && (endTimeNew > endTime);

            if (timeConflictA == true) {
                hasTimeConflict = true;
            } else if (timeConflictB == true) {
                hasTimeConflict = true;
            } else if (timeConflictC == true) {
                hasTimeConflict = true;
            } else if(timeConflictD){
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
            ArrayList<String> dayEntry = scheduleEntry.getDays();
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
                    
                    boolean hasSameDay = true;
                    for(int i = 0; i < dayEntry.size(); i++){
                        hasSameDay = dayEntry.get(i).equals(day);
                        System.out.println("Day :"+ dayEntry.get(i));
                    }
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
