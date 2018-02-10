package controller.schedule;

import component_renderers.Renderer_Schedule_JTableCell;
import daoimpl.FacultyDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.ScheduleDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.SectionDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    private final JPanel jpnlScheduleTable;
    private final JLabel jlblConflictInfo;
    private final JComboBox jcmbGradeLevel;
            
    public CreateScheduleController(JTable jtblSchedule,JDialog jdlgCreateSchedule,JComboBox jcmbSection,JPanel jpnlScheduleTable,JLabel jlblConflictInfo,JComboBox jcmbGradeLevel){
        this.jtblSchedule = jtblSchedule;
        this.jdlgCreateSchedule = jdlgCreateSchedule;
        this.jcmbSection = jcmbSection;
        this.jpnlScheduleTable = jpnlScheduleTable;
        this.jlblConflictInfo = jlblConflictInfo;
        this.jcmbGradeLevel = jcmbGradeLevel;
        facultyDaoImpl = new FacultyDaoImpl();
        sectionDaoImpl = new SectionDaoImpl();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!hasNullFields()){
            validateSchedule();
            create();
        }else{
            jtblSchedule.setDefaultRenderer(Object.class, new Renderer_Schedule_JTableCell(jlblConflictInfo));
            jtblSchedule.repaint();
            JOptionPane.showMessageDialog(null,"Empty fields are not allowed.");
        }
    }
    
    private void create() {
        int choice = JOptionPane.showConfirmDialog(null, "Save Schedule?","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            setScheduleList();
            
            ScheduleDaoImpl scheduleDaoImpl = new ScheduleDaoImpl();
            boolean isAdded = scheduleDaoImpl.add(scheduleList);
            if (isAdded) {
                String scheduleFor = jcmbSection.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null, "Successfully created schedule for "+scheduleFor);
                jdlgCreateSchedule.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error, schedule not added.");
            }
        }
    }
    
    private void setScheduleList() {
        GradeLevelDaoImpl gradeLevelDaoImpl = new GradeLevelDaoImpl();
        SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
        FacultyDaoImpl fdi = new FacultyDaoImpl();
        scheduleList = new ArrayList<>();
        for (int row = 0; row < jtblSchedule.getRowCount(); row++) {
            String day = jtblSchedule.getValueAt(row, 0).toString().trim();
            String startTime = jtblSchedule.getValueAt(row, 1).toString().replace(":", "").trim();
            String endTime = jtblSchedule.getValueAt(row, 2).toString().replace(":","");
            String subjectName = jtblSchedule.getValueAt(row, 3).toString().trim();
            String facultyName = jtblSchedule.getValueAt(row, 4).toString().trim();
            String roomName = jtblSchedule.getValueAt(row, 5).toString().trim();
            
            String[] parts = facultyName.split("-");
            System.out.println("Faculty Id: "+parts[0].trim());
            int facultyId = Integer.parseInt(parts[0].trim());
            Faculty f = new Faculty();
            f.setFacultyID(facultyId);
            
            String sectionName = jcmbSection.getSelectedItem().toString();
            int level = Integer.parseInt(jcmbGradeLevel.getSelectedItem().toString());
            int gradeLevelId = gradeLevelDaoImpl.getId(level);
            
            Schedule s = new Schedule();
            s.setDay(day);
            s.setStartTime(Integer.parseInt(startTime));
            s.setEndTime(Integer.parseInt(endTime));
            s.setSubjectCode(subjectName);
            s.setSectionName(sectionName);
            s.setRoomName(roomName);
            s.setSchoolYearId(schoolYearDaoImpl.getCurrentSchoolYearId());
            s.setFaculty(f);
            s.setGradeLevelId(gradeLevelId);

            scheduleList.add(s);
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
    
    private boolean hasNullFields(){
        boolean hasNull = true;
        int countOfNull = 0;
        for(int r = 0; r < jtblSchedule.getRowCount(); r++){
            for(int c = 0; c < jtblSchedule.getColumnCount(); c++){
                if(jtblSchedule.getValueAt(r, c)==null){
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
    
    private void validateSchedule(){
        for(int row = 0; row <jtblSchedule.getRowCount(); row++){
            String day = jtblSchedule.getValueAt(row, 0).toString().trim();
            String start = jtblSchedule.getValueAt(row, 1).toString().trim();
            String end = jtblSchedule.getValueAt(row, 2).toString().trim();
            String subject = jtblSchedule.getValueAt(row, 3).toString().trim();
            String faculty = jtblSchedule.getValueAt(row, 4).toString().trim();
            String room = jtblSchedule.getValueAt(row, 5).toString().trim();
            
            compare(row,day, start, end, subject, faculty, room);
        }
    }
    
    private void compare(int rowIndex, String day1, String startTime1, String endTime1, String subject1, String faculty1, String room1) {
        ArrayList<Integer> rowsWithConflict = new ArrayList<>();
        System.out.println("Row Count :" + jtblSchedule.getRowCount());
        for (int row = 0; row < jtblSchedule.getRowCount(); row++) {
            if (row != rowIndex) {
                String day = jtblSchedule.getValueAt(row, 0).toString().trim();
                String startTime = jtblSchedule.getValueAt(row, 1).toString().trim();
                String endTime = jtblSchedule.getValueAt(row, 2).toString().trim();
                String subject = jtblSchedule.getValueAt(row, 3).toString().trim();
                String faculty = jtblSchedule.getValueAt(row, 4).toString().trim();
                String room = jtblSchedule.getValueAt(row, 5).toString().trim();

                if (hasSameRoom(room1, room) && hasSameFaculty(faculty1, faculty)
                        && hasSameDay(day1, day) && hasSameTime(startTime1, endTime1, startTime, endTime)) {
                    System.out.println("Time Conflict Row: " + row + " Column :" + 1 + ", " + 2);
                } else if (hasSameRoom(room1, room) && !hasSameFaculty(faculty1, faculty)) {
                    //valid
                } else if (hasSameRoom(room1, room) && hasSameFaculty(faculty1, faculty) && !hasSameDay(day1, day)) {
                    //valid
                } else if (hasSameRoom(room1, room) && hasSameFaculty(faculty1, faculty)
                        && hasSameDay(day1, day) && !hasSameTime(startTime1, endTime1, startTime, endTime)
                        && hasSameSubject(subject1, subject)) {
                    System.out.println("Subject Conflict Row: " + row + " Column :" + 3);
                } else if (hasSameRoom(room1, room) && hasSameFaculty(faculty1, faculty)
                        && hasSameDay(day1, day) && !hasSameTime(startTime1, endTime1, startTime, endTime)
                        && !hasSameSubject(subject1, subject)) {
                    //valid
                }
            }
        }

    }
    
    
}//end of class
