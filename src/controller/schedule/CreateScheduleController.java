/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.schedule;

import daoimpl.FacultyDaoImpl;
import daoimpl.ScheduleDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.SectionDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.faculty.Faculty;
import model.schedule.Schedule;

/**
 *
 * @author John Ferdinand Antonio
 */
public class CreateScheduleController implements ActionListener{

    FacultyDaoImpl facultyDaoImpl;
    SectionDaoImpl sectionDaoImpl;
    private final JTable jtblSchedule;
    private List<Schedule> scheduleList;
    private final JDialog jdlgCreateSchedule;
    private final JComboBox jcmbSection;
            
    public CreateScheduleController(JTable jtblSchedule,JDialog jdlgCreateSchedule,JComboBox jcmbSection){
        this.jtblSchedule = jtblSchedule;
        this.jdlgCreateSchedule = jdlgCreateSchedule;
        this.jcmbSection = jcmbSection;
        facultyDaoImpl = new FacultyDaoImpl();
        sectionDaoImpl = new SectionDaoImpl();
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
            int startTime = getTime(jtblSchedule.getValueAt(row, 1).toString().trim());
            int endTime = getTime(jtblSchedule.getValueAt(row, 2).toString().trim());
            String subjectName = jtblSchedule.getValueAt(row, 3).toString().trim();
            String facultyName = jtblSchedule.getValueAt(row, 4).toString().trim();
            String roomName = jtblSchedule.getValueAt(row, 5).toString().trim();
            
            String[] parts = facultyName.split("-");
            int facultyId = Integer.parseInt(parts[0].trim());
            Faculty faculty = new Faculty();
            faculty.setFacultyID(facultyId);
            
            String sectionName = jcmbSection.getSelectedItem().toString();

            System.out.println("Start Time: "+startTime);
            System.out.println("End Time: "+endTime);
            
            Schedule schedule = new Schedule();
            schedule.setDay(day);
            schedule.setStartTime(startTime);
            schedule.setEndTime(endTime);
            schedule.setSubjectCode(subjectName);
            schedule.setSectionName(sectionName);
            schedule.setRoomName(roomName);
            schedule.setSchoolYearId(schoolYearDaoImpl.getCurrentSchoolYearId());
            schedule.setFaculty(faculty);

            scheduleList.add(schedule);
        }
    }
    private int getTime(String s){
        Integer time;
        String[] parts = s.split(":");
        String hour = parts[0].trim();
        int hr = Integer.parseInt(hour)*100;
        String minutes =parts[1].trim();
        int mins = Integer.parseInt(minutes);
        
        time = hr+mins;
        return time;
    }
    
    
}
