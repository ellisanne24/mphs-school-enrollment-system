package controller.schedule;

import daoimpl.ScheduleDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import model.faculty.Faculty;
import model.schedule.Schedule;
import model.schoolyear.SchoolYear;
import view.schedule.Dialog_CreateSchedule;

/**
 *
 * @author Jordan
 */
public class TableModelListener_ScheduleSheet_JTable implements TableModelListener {

    private final Dialog_CreateSchedule view;

    public TableModelListener_ScheduleSheet_JTable(Dialog_CreateSchedule view) {
        this.view = view;
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        TableModel tableModel = (TableModel) e.getSource();
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            SchoolYear schoolYear = new SchoolYearDaoImpl().getCurrentSchoolYear();
            Object day = tableModel.getValueAt(row, 0);
            Object startTime = tableModel.getValueAt(row, 1);
            Object endTime = tableModel.getValueAt(row, 2);
            Object subject = tableModel.getValueAt(row, 3);
            Faculty faculty = (Faculty) tableModel.getValueAt(row, 4);
            Object session = tableModel.getValueAt(row, 6);
            if (day!=null && startTime != null && endTime != null && faculty != null && session != null) {
                int sTime = Integer.parseInt(startTime.toString().trim().replace(":", ""));
                int eTime = Integer.parseInt(endTime.toString().trim().replace(":", ""));
                if (hasDuplicateAt(1, startTime, tableModel)) {
                    view.getJtaWarnings().setText("Duplicate time found for " + startTime);
                    break;
                }
                if (hasDuplicateAt(2, endTime, tableModel)) {
                    view.getJtaWarnings().setText("Duplicate time found for " + endTime);
                    break;
                }
                if (sTime == eTime) {
                    view.getJtaWarnings().setText("Start time must not be equal to End time\n");
                    break;
                }
                if (sTime > eTime) {
                    view.getJtaWarnings().setText("Start time must be less than End time\n");
                    break;
                }
                if (!startTimeMatchesSession(sTime, session.toString().trim())) {
                    view.getJtaWarnings().setText("Start time of " + startTime + " is not valid for " + session + " session");
                    break;
                }
                if (!endTimeMatchesSession(eTime, session.toString().trim())) {
                    view.getJtaWarnings().setText("End time of " + endTime + " is not valid for " + session + " session");
                    break;
                }
                if (facultyHasScheduleAt(day.toString(), sTime, eTime, faculty, schoolYear)) {
                    view.getJtaWarnings().setText(
                            "*** Faculty avialability conflict found! *** \n"
                            + ((Faculty) faculty).getFirstName() + ((Faculty) faculty).getLastName() + "\n"
                            + "has an existing schedule at (" + startTime + "-" + endTime + " , " + day + ")\n"
                            + "Please select a different faculty member OR change the other schedule."
                    );
                    break;
                } else {
                    view.getJtaWarnings().setText("");
                }
            }
        }
    }

    private boolean facultyHasScheduleAt(String day, int startTime, int endTime, Faculty faculty, SchoolYear schoolYear) {
        boolean hasSchedule = false;
        ScheduleDaoImpl scheduleDaoImpl = new ScheduleDaoImpl();
        Schedule schedule = new Schedule();
        schedule.setDay(getDayEquivalent(day));
        schedule.setStartTime(startTime);
        schedule.setEndTime(endTime);
        schedule.setFaculty(faculty);
        schedule.setSchoolYear(schoolYear);
        hasSchedule = scheduleDaoImpl.facultyhasScheduleAt(schedule);
        return hasSchedule;
    }

    private String getDayEquivalent(String longDay) {
        String oneCharDay = longDay.trim().equalsIgnoreCase("Mon") ? "M"
                : longDay.trim().equalsIgnoreCase("Tue") ? "T"
                : longDay.trim().equalsIgnoreCase("Wed") ? "W"
                : longDay.trim().equalsIgnoreCase("Thu") ? "TH" : "F";
        return oneCharDay;
    }

    private boolean startTimeMatchesSession(int startTime, String session) {
        boolean valid;
        if (session.trim().equalsIgnoreCase("PM")) {
            valid = ((startTime >= 1200) && (startTime <= 1600));
        } else if (session.trim().equalsIgnoreCase("AM")) {
            valid = ((startTime >= 700) && (startTime <= 1100));
        } else {//WD
            valid = ((startTime >= 700) && (startTime <= 1600));
        }
        return valid;
    }

    private boolean endTimeMatchesSession(int et, String s) {
        boolean valid;
        if (s.trim().equalsIgnoreCase("PM")) {
            valid = ((et >= 1300) && (et <= 1700));
        } else if (s.trim().equalsIgnoreCase("AM")) {
            valid = ((et >= 800) && (et <= 1200));
        } else {//WD
            valid = ((et >= 800) && (et <= 1700));
        }
        return valid;
    }

    private boolean hasDuplicateAt(int col, Object value, TableModel tableModel) {
        int countOfRecord = 0;
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            if (value.equals(tableModel.getValueAt(row, col))) {
                countOfRecord++;
            }
        }
        return countOfRecord > 1;
    }

}
