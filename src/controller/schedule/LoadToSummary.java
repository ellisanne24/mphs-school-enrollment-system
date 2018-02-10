package controller.schedule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.schedule.Dialog_CreateSchedule;

/**
 *
 * @author John Ferdinand Antonio
 */
public class LoadToSummary implements ActionListener{

    private final Dialog_CreateSchedule view;
    
    private final JTable jtblSchedule;
    private final JTable jtblMonday;
    private final JTable jtblTuesday;
    private final JTable jtblWednesday;
    private final JTable jtblThursday;
    private final JTable jtblFriday;
    
    private DefaultTableModel monday ;
    private DefaultTableModel tuesday;
    private DefaultTableModel wednesday;
    private DefaultTableModel thursday;
    private DefaultTableModel friday;
    
    public LoadToSummary(Dialog_CreateSchedule view) {
        this.view = view;
        this.jtblSchedule = view.getJtblSchedule();
        this.jtblMonday = view.getJtblMonday();
        this.jtblTuesday = view.getJtblTuesday();
        this.jtblWednesday = view.getJtblWednesday();
        this.jtblThursday = view.getJtblThursday();
        this.jtblFriday = view.getJtblFriday();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        monday = (DefaultTableModel)jtblMonday.getModel();
        tuesday = (DefaultTableModel)jtblTuesday.getModel();
        wednesday = (DefaultTableModel)jtblWednesday.getModel();
        thursday = (DefaultTableModel)jtblThursday.getModel();
        friday = (DefaultTableModel)jtblFriday.getModel();
        
        if(!hasNullFields(jtblSchedule)){
            check();
        }else{
            JOptionPane.showMessageDialog(null,"Empty fields are not allowed.");
        }
    }
    
    private void populateScheduleModel() {
        for (int i = 0; i < jtblSchedule.getRowCount(); i++) {
            if (jtblSchedule.getValueAt(i, 0) != null) {
                String day = jtblSchedule.getValueAt(i, 0).toString();
                Object startTime = jtblSchedule.getValueAt(i, 1);
                Object endTime = jtblSchedule.getValueAt(i, 2);
                Object subjetct = jtblSchedule.getValueAt(i, 3);
                Object faculty = jtblSchedule.getValueAt(i, 4);
                Object room = jtblSchedule.getValueAt(i, 5);
                System.out.println(day+","+startTime+","+endTime+","+subjetct+","+faculty+","+room);
                if (day.equals("Mon")) {
                    monday.addRow(new Object[]{day, startTime, endTime, subjetct, faculty, room});
                } else if (day.equals("Tue")) {
                    tuesday.addRow(new Object[]{day, startTime, endTime, subjetct, faculty, room});
                } else if (day.equals("Wed")) {
                    wednesday.addRow(new Object[]{day, startTime, endTime, subjetct, faculty, room});
                } else if (day.equals("Thu")) {
                    thursday.addRow(new Object[]{day, startTime, endTime, subjetct, faculty, room});
                } else if (day.equals("Fri")) {
                    friday.addRow(new Object[]{day, startTime, endTime, subjetct, faculty, room});
                }
            }
        }
        System.out.println("Monday Row Count :"+monday.getRowCount());
        System.out.println("Tuesday Row Count :"+tuesday.getRowCount());
        System.out.println("Wednesday Row Count :"+wednesday.getRowCount());
        System.out.println("Thursday Row Count :"+thursday.getRowCount());
        System.out.println("Friday Row Count :"+friday.getRowCount());
    }
    
    private void setScheduleModel(){
        if(monday != null){
            jtblMonday.setModel(monday);
        }
        else if(tuesday != null){
            jtblTuesday.setModel(tuesday);
        }
        else if(wednesday != null){
            jtblWednesday.setModel(wednesday);
        }
        else if(thursday != null){
            jtblThursday.setModel(thursday);
        }
        else if(friday != null){
            jtblFriday.setModel(friday);
        }
    }
    
    private void check(){
        int errors = 0;
        for(int row = 0; row < jtblSchedule.getRowCount(); row++){
            if (hasConflict(row)) {
                errors++;
            }
        }
        if(errors >0){
            System.out.println("Errors found on form.");
        }else{
            populateScheduleModel();
            setScheduleModel();
        }
    }
    
    private boolean hasConflict(int rowIndex) {
        boolean hasConflict = false;
        String day1 = jtblSchedule.getValueAt(rowIndex, 0).toString();
        String startTime1 = jtblSchedule.getValueAt(rowIndex, 1).toString();
        String endTime1 = jtblSchedule.getValueAt(rowIndex, 2).toString();
        String subject1 = jtblSchedule.getValueAt(rowIndex, 3).toString();
        String faculty1 = jtblSchedule.getValueAt(rowIndex, 4).toString();
        String room1 = jtblSchedule.getValueAt(rowIndex, 5).toString();

        for (int row = 0; row < jtblSchedule.getRowCount(); row++) {
            if (row != rowIndex) {
                String day = jtblSchedule.getValueAt(row, 0).toString().trim();
                String startTime = jtblSchedule.getValueAt(row, 1).toString().trim();
                String endTime = jtblSchedule.getValueAt(row, 2).toString().trim();
                String subject = jtblSchedule.getValueAt(row, 3).toString().trim();
                String faculty = jtblSchedule.getValueAt(row, 4).toString().trim();
                String room = jtblSchedule.getValueAt(row, 5).toString().trim();

                if (hasSameRoom(room1, room)
                        && hasSameFaculty(faculty1, faculty)
                        && hasSameDay(day1, day)
                        && hasSameTime(startTime1, endTime1, startTime, endTime)) {
                    JOptionPane.showMessageDialog(null,"Time and Faculty conflict at row "+row +"& "+rowIndex);
                    hasConflict = true;
                } else if (hasSameRoom(room1, room) && hasSameFaculty(faculty1, faculty)
                        && hasSameDay(day1, day) && !hasSameTime(startTime1, endTime1, startTime, endTime)
                        && hasSameSubject(subject1, subject)) {
                    hasConflict = true;
                } else if(hasSameDay(day1, day) && hasTimeConflict(startTime1, endTime1, startTime, endTime)){
                    JOptionPane.showMessageDialog(null, "Time conflict found on row "+row+" & "+rowIndex);
                    hasConflict = true;
                } else if(hasSameDay(day1, day) && hasSameSubject(subject1, subject)){
                    JOptionPane.showMessageDialog(null,"Same subject on same day is not allowed.\n Check row "+row+"&"+rowIndex);
                    hasConflict = true;
                } 
            }
        }
        return hasConflict;
    }
    
    private boolean hasTimeConflict(String st1, String et1, String st, String et) {
        boolean hasTimeConflict = false;
        int startTime1 = Integer.parseInt(st1.replace(":", ""));
        int endTime1 = Integer.parseInt(et1.replace(":", ""));
        int startTime = Integer.parseInt(st.replace(":", ""));
        int endTime = Integer.parseInt(et.replace(":", ""));
        
        System.out.println("Start Time1 : " + startTime1);
        System.out.println("End Time1 : " + endTime1);
        System.out.println("Start Time : "+startTime);
        System.out.println("End Time : "+endTime);
        
        boolean timeConflictA = ((startTime >= startTime1) && (endTime <= endTime1));
        boolean timeConflictB = ((startTime < startTime1) && (endTime > startTime1 && endTime <= endTime1));
        boolean timeConflictC = (startTime == endTime);
        boolean timeConflictD = (startTime == startTime1) && (endTime > endTime1);
        boolean timeConflictE = (endTime1 < startTime1);

        if (timeConflictA == true) {
            hasTimeConflict = true;
        } else if (timeConflictB == true) {
            hasTimeConflict = true;
        } else if (timeConflictC == true) {
            hasTimeConflict = true;
        } else if (timeConflictD) {
            hasTimeConflict = true;
        } else if(timeConflictE){
            hasTimeConflict = true;
        }

        if (hasTimeConflict) {
            System.out.println("Time conflict.");
        }

        return hasTimeConflict;
    }
    
    private boolean hasNullFields(JTable table){
        boolean hasNull = true;
        int countOfNull = 0;
        for(int r = 0; r < table.getRowCount(); r++){
            for(int c = 0; c < table.getColumnCount(); c++){
                if(table.getValueAt(r, c)==null){
                    countOfNull++;
                }
            }
        }
        if(countOfNull == 0){
            hasNull = false;
        }
        return hasNull;
    }
    
    private boolean hasSameSubject(String subject1, String subject2) {
        boolean hasSameSubject = false;
        if (subject1.equals(subject2)) {
            hasSameSubject = true;
        }
        return hasSameSubject;
    }

    private boolean hasSameFaculty(String faculty1, String faculty2) {
        boolean hasSameFaculty = false;
        if (faculty1.equals(faculty2)) {
            hasSameFaculty = true;
        }
        return hasSameFaculty;
    }
    
    private boolean hasSameDay(String day1,String day2){
        boolean hasSameDay = false;
        if(day1.equals(day2)){
            hasSameDay = true;
        }
        return hasSameDay;
    }
    
    private boolean hasSameTime(String startTime1, String endTime1, String startTime2, String endTime2) {
        boolean hasSameTime = false;
        if (startTime1.equals(startTime2) && endTime1.equals(endTime2)) {
            hasSameTime = true;
        }
        return hasSameTime;
    }
    
    private boolean hasSameRoom(String room1, String room2){
        boolean hasSameRoom = false;
        if(room1.equals(room2)){
            hasSameRoom = true;
        }
        return hasSameRoom;
    }
}
