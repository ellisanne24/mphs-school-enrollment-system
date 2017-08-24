package controller.schedule;

import daoimpl.FacultyDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.ScheduleDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
public class CreateScheduleController2 implements ActionListener{

    private List<Schedule> scheduleList;
    private final JTable jtblSchedule;
    private final JTable jtblMonday;
    private final JTable jtblTuesday;
    private final JTable jtblWednesday;
    private final JTable jtblThursday;
    private final JTable jtblFriday;
    private final JComboBox jcmbSection;
    private final JComboBox jcmbGradeLevel;
    private final JDialog jdlgCreateSchedule;

    public CreateScheduleController2(JTable jtblSchedule,
            JTable jtblMonday, JTable jtblTuesday, JTable jtblWednesday,
            JTable jtblThursday, JTable jtblFriday, JComboBox jcmbSection,
            JComboBox jcmbGradeLevel, JDialog jdlgCreateSchedule) {
        this.jtblSchedule = jtblSchedule;
        this.jtblMonday = jtblMonday;
        this.jtblTuesday = jtblTuesday;
        this.jtblWednesday = jtblWednesday;
        this.jtblThursday = jtblThursday;
        this.jtblFriday = jtblFriday;
        this.jcmbGradeLevel = jcmbGradeLevel;
        this.jcmbSection = jcmbSection;
        this.jdlgCreateSchedule = jdlgCreateSchedule;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int choice = JOptionPane.showConfirmDialog(null, "Save Schedule?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            List<JTable> tables = new ArrayList<>();
            tables.add(jtblMonday);
            tables.add(jtblTuesday);
            tables.add(jtblWednesday);
            tables.add(jtblThursday);
            tables.add(jtblFriday);
            create(tables);
        }
    }
    
    private void create(List<JTable> tables) {
        int countOfFailed = 0;
        for (JTable t : tables) {
            setScheduleList(t);
            ScheduleDaoImpl scheduleDaoImpl = new ScheduleDaoImpl();
            boolean isAdded = scheduleDaoImpl.add(scheduleList);
            if (isAdded) {

            } else {
                countOfFailed++;
            }
        }
        if (countOfFailed > 0) {
            JOptionPane.showMessageDialog(null, "Error, schedule not added.");
        } else {
            String scheduleFor = jcmbSection.getSelectedItem().toString();
            JOptionPane.showMessageDialog(null, "Successfully created schedule for " + scheduleFor);
            jdlgCreateSchedule.dispose();
        }
    }
    
    private void setScheduleList(JTable table) {
        GradeLevelDaoImpl gradeLevelDaoImpl = new GradeLevelDaoImpl();
        SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
        FacultyDaoImpl fdi = new FacultyDaoImpl();
        scheduleList = new ArrayList<>();
        for (int row = 0; row < table.getRowCount(); row++) {
            String day = table.getValueAt(row, 0).toString().trim();
            String startTime = table.getValueAt(row, 1).toString().replace(":", "").trim();
            String endTime = table.getValueAt(row, 2).toString().replace(":","");
            String subjectName = table.getValueAt(row, 3).toString().trim();
            String facultyName = table.getValueAt(row, 4).toString().trim();
            String roomName = table.getValueAt(row, 5).toString().trim();
            
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
}
