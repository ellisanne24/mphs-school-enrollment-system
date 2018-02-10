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
import view.schedule.Dialog_CreateSchedule;

/**
 *
 * @author John Ferdinand Antonio
 */
public class CreateScheduleController2 implements ActionListener {

    private final Dialog_CreateSchedule view;
    private List<Schedule> scheduleList;
    private final JTable jtblSchedule;
    private final JTable jtblMonday;
    private final JTable jtblTuesday;
    private final JTable jtblWednesday;
    private final JTable jtblThursday;
    private final JTable jtblFriday;
    private final JComboBox jcmbSection;
    private final JComboBox jcmbGradeLevel;

    public CreateScheduleController2(Dialog_CreateSchedule view) {
        this.view = view;
        this.jtblSchedule = view.getJtblSchedule();
        this.jtblMonday = view.getJtblMonday();
        this.jtblTuesday = view.getJtblTuesday();
        this.jtblWednesday = view.getJtblWednesday();
        this.jtblThursday = view.getJtblThursday();
        this.jtblFriday = view.getJtblFriday();
        this.jcmbGradeLevel = view.getJcmbGradeLevel();
        this.jcmbSection = view.getJcmbSection();
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
            view.dispose();
        }
    }

    private void setScheduleList(JTable table) {
        GradeLevelDaoImpl gradeLevelDaoImpl = new GradeLevelDaoImpl();
        SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
        FacultyDaoImpl facultyDaoImpl = new FacultyDaoImpl();
        scheduleList = new ArrayList<>();
        for (int row = 0; row < table.getRowCount(); row++) {
            String day = table.getValueAt(row, 0).toString().trim();
            String startTime = table.getValueAt(row, 1).toString().replace(":", "").trim();
            String endTime = table.getValueAt(row, 2).toString().replace(":", "");
            String subjectName = table.getValueAt(row, 3).toString().trim();
            String facultyName = table.getValueAt(row, 4).toString().trim();
            String roomName = table.getValueAt(row, 5).toString().trim();

            String[] parts = facultyName.split("-");
            int facultyId = Integer.parseInt(parts[0].trim());
            Faculty faculty = new Faculty();
            faculty.setFacultyID(facultyId);

            String sectionName = jcmbSection.getSelectedItem().toString();
            int level = Integer.parseInt(jcmbGradeLevel.getSelectedItem().toString());
            int gradeLevelId = gradeLevelDaoImpl.getId(level);

            Schedule schedule = new Schedule();
            schedule.setDay(day);
            schedule.setStartTime(Integer.parseInt(startTime));
            schedule.setEndTime(Integer.parseInt(endTime));
            schedule.setSubjectCode(subjectName);
            schedule.setSectionName(sectionName);
            schedule.setRoomName(roomName);
            schedule.setSchoolYearId(schoolYearDaoImpl.getCurrentSchoolYearId());
            schedule.setFaculty(faculty);
            schedule.setGradeLevelId(gradeLevelId);

            scheduleList.add(schedule);
        }
    }
}
