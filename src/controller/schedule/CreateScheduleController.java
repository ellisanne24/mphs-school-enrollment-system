/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.schedule;

import daoimpl.FacultyDaoImpl;
import daoimpl.ScheduleDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.faculty.Faculty;
import model.schedule.Schedule;
import utility.string.StringUtil;

/**
 *
 * @author John Ferdinand Antonio
 */
public class CreateScheduleController implements ActionListener{

    private final JTable jtblSchedule;
    private List<Schedule> scheduleList;
    private final JDialog jdlgCreateSchedule;
            
    public CreateScheduleController(JTable jtblSchedule,JDialog jdlgCreateSchedule){
        this.jtblSchedule = jtblSchedule;
        this.jdlgCreateSchedule = jdlgCreateSchedule;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (jtblSchedule.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(null,"Schedule list is empty.");
        } else {
            create();
        }
    }
    
    private void create() {
        int choice = JOptionPane.showConfirmDialog(null, "Save Schedule?","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            setScheduleList();
            ScheduleDaoImpl scheduleDaoImpl = new ScheduleDaoImpl();
            boolean isAdded = scheduleDaoImpl.add(scheduleList);
            if (isAdded) {
                JOptionPane.showMessageDialog(null, "Successfully added schedule.");
                jdlgCreateSchedule.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error, schedule not added.");
            }
        }
    }
    
    private void setScheduleList() {
        SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
        FacultyDaoImpl fdi = new FacultyDaoImpl();
        scheduleList = new ArrayList<>();
        for (int row = 0; row < jtblSchedule.getRowCount(); row++) {
            String day = jtblSchedule.getValueAt(row, 0).toString().trim();
            int startTime = Integer.parseInt(jtblSchedule.getValueAt(row, 1).toString());
            int endtime = Integer.parseInt(jtblSchedule.getValueAt(row, 2).toString());
            String subjectName = jtblSchedule.getValueAt(row, 3).toString().trim();
            String setionName = jtblSchedule.getValueAt(row, 4).toString().trim();
            String roomName = jtblSchedule.getValueAt(row, 5).toString().trim();
            
            String facultyName = jtblSchedule.getValueAt(row,6).toString().trim();
            String strFacultyId = StringUtil.getNumbers(facultyName).trim();
            int facultyId = Integer.parseInt(strFacultyId);
//            System.out.println("facultyId :"+strFacultyId);
            
            
            Faculty faculty = new Faculty();
            faculty.setFacultyID(facultyId);
            
            Schedule schedule = new Schedule();
            schedule.setDay(day);
            schedule.setStartTime(startTime);
            schedule.setEndTime(endtime);
            schedule.setSubjectName(subjectName);
            schedule.setSectionName(setionName);
            schedule.setRoomName(roomName);
            schedule.setSchoolYearId(schoolYearDaoImpl.getCurrentSchoolYearId());
            schedule.setFaculty(faculty);
            
            scheduleList.add(schedule);
        }
    }
    
}
