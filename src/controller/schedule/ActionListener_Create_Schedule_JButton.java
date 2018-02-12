package controller.schedule;

import daoimpl.ScheduleDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.faculty.Faculty;
import model.gradelevel.GradeLevel;
import model.room.Room;
import model.schedule.Schedule;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.subject.Subject;
import utility.form.FormValidator;
import utility.string.StringUtil;
import view.schedule.Dialog_CreateSchedule;

/**
 *
 * @author Jordan
 */
public class ActionListener_Create_Schedule_JButton implements ActionListener, FormValidator {

    private final Dialog_CreateSchedule view;
    private final SchoolYearDaoImpl schoolYearDaoImpl;
    private final ScheduleDaoImpl scheduleDaoImpl;
    private final JTable jtblScheduleSummary;

    public ActionListener_Create_Schedule_JButton(Dialog_CreateSchedule view) {
        schoolYearDaoImpl = new SchoolYearDaoImpl();
        scheduleDaoImpl = new ScheduleDaoImpl();
        this.view = view;
        this.jtblScheduleSummary = view.getJtblScheduleSummary();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (formIsValid()) {
            if (JOptionPane.showConfirmDialog(null, "Create Schedule", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (createSchedule()) {
                    Section section = (Section) view.getJcmbSection().getSelectedItem();
                    JOptionPane.showMessageDialog(null, "Successfully created schedule for " + section.getSectionName());
                } else {
                    JOptionPane.showMessageDialog(null, "Encountered problems while creating schedule. Please contact your support.");
                }
            }
        }
    }

    private boolean createSchedule() {
        List<Schedule> scheduleList = getScheduleFromScheduleSummaryTable();
        boolean isSuccessful = scheduleDaoImpl.add(scheduleList);
        return isSuccessful;
    }

    private List<Schedule> getScheduleFromScheduleSummaryTable() {
        List<Schedule> scheduleList = new ArrayList<>();
        Section section = (Section) view.getJcmbSection().getSelectedItem();
        GradeLevel gradeLevel = (GradeLevel)view.getJcmbGradeLevel().getSelectedItem();
        SchoolYear currentSchoolYear = schoolYearDaoImpl.getCurrentSchoolYear();
        ArrayList<Integer> dayColumns = getDayColumnsWithSched();
        JTable t = jtblScheduleSummary;
        for (int i = 0; i < dayColumns.size(); i++) {
            Schedule schedule = new Schedule();
            for (int row = 0; row < t.getRowCount(); row++) {
                for (int col = 0; col <= dayColumns.get(i); col++) {
                    if((row % 3 == 0 || row == 0) && (col == 0)){
                        schedule.setStartTime(getStartTime(t.getValueAt(row, col)));
                        schedule.setEndTime(getEndTime(t.getValueAt(row, col)));
                    }
                    if (col == dayColumns.get(i)) {
                        if (t.getValueAt(row, col) instanceof Subject) {
                            schedule.setSubject((Subject) t.getValueAt(row, col));
                        } else if (t.getValueAt(row, col) instanceof Faculty) {
                            schedule.setFaculty((Faculty) t.getValueAt(row, col));
                        } else if (t.getValueAt(row, col) instanceof Room) {
                            schedule.setRoom((Room) t.getValueAt(row, col));
                            schedule.setDay(getDayByTableIndex(dayColumns.get(i)));
                            schedule.setSection(section);
                            schedule.setGradeLevel(gradeLevel);
                            schedule.setSchoolYear(currentSchoolYear);
                            scheduleList.add(schedule);
                            schedule = new Schedule();
                        }
                    }
                }
            }
        }
        
//        for(Schedule s : scheduleList){
//            JOptionPane.showMessageDialog(null,
//                    s.getDay()+", "+s.getStartTime()+" - "+s.getEndTime()+", "
//                    +s.getGradeLevel().getLevelNo()+", SY: "+s.getSchoolYear().getYearFrom()+", "
//                    +s.getSection().getSectionName()+", "
//                    +s.getSection().getSectionSession()+", "
//                    +s.getSubject().getSubjectCode()+", "
//                    +s.getFaculty().getLastName()+", "
//                    +s.getRoom().getRoomName());
//        }
        return scheduleList;
    }

    private ArrayList<Integer> getDayColumnsWithSched(){
        ArrayList<Integer> dayColumn = new ArrayList<>();
        for(int row = 0; row < 1; row++){
            for(int col = 1; col <= 5; col++){
                if(jtblScheduleSummary.getValueAt(row, col) != null){
                    dayColumn.add(col);
                }
            }
        }
        return dayColumn;
    }
    
    private String getDayByTableIndex(int tableDayColumnIndex) {
        String day;
        switch (tableDayColumnIndex) {
            case 1:
                day = dayValueForDB("Mon");
                break;
            case 2:
                day = dayValueForDB("Tue");
                break;
            case 3:
                day = dayValueForDB("Wed");
                break;
            case 4:
                day = dayValueForDB("Thu");
                break;
            default:
                day = dayValueForDB("Fri");
                break;
        }
        return day;
    }

    private int getStartTime(Object o) {
        String[] parts = o.toString().trim().split("-");
        String startTimeStr = parts[0].replace(":", "");
        int startTime = Integer.parseInt(StringUtil.removeWhiteSpaces(startTimeStr));
        return startTime;
    }

    private int getEndTime(Object o) {
        String[] parts = o.toString().trim().split("-");
        String startTimeStr = parts[1].replace(":", "");
        int startTime = Integer.parseInt(StringUtil.removeWhiteSpaces(startTimeStr));
        return startTime;
    }

    private String dayValueForDB(Object day) {
        if (day.toString().trim().equalsIgnoreCase("Mon")) {
            return "M";
        } else if (day.toString().trim().equalsIgnoreCase("Tue")) {
            return "T";
        } else if (day.toString().trim().equalsIgnoreCase("Wed")) {
            return "W";
        } else if (day.toString().trim().equalsIgnoreCase("Thu")) {
            return "TH";
        } else {
            return "F";
        }
    }

    @Override
    public boolean formIsValid() {
        return true;
    }

}
