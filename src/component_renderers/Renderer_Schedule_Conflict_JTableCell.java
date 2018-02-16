package component_renderers;

import daoimpl.ScheduleDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.faculty.Faculty;
import model.room.Room;
import model.schedule.Schedule;
import model.schoolyear.SchoolYear;
import model.subject.Subject;

/**
 *
 * @author John Ferdinand Antonio
 */
public class Renderer_Schedule_Conflict_JTableCell extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        Component tableCell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
        
        renderCellValues(value, row, col, tableCell);
        if (allRowColsHasInput(table, row)) {
            validateFacultyAvailability(table, row, tableCell);
        }
        else {
            colorWithOriginal(tableCell, row);
        }
        return tableCell;
    }

    private boolean allRowColsHasInput(JTable table, int tRow ){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        boolean hasDay = (tableModel.getValueAt(tRow, 0) != null);
        boolean hasStartTime = (tableModel.getValueAt(tRow, 1) != null);
        boolean hasEndTime = (tableModel.getValueAt(tRow, 2) != null);
        boolean hasSubject = (tableModel.getValueAt(tRow, 3) != null);
        boolean hasFaculty = (tableModel.getValueAt(tRow, 4) != null);
        boolean hasRoom = (tableModel.getValueAt(tRow, 5) != null);
        boolean hasSession = (tableModel.getValueAt(tRow, 6) != null);
        return (hasDay && hasStartTime && hasEndTime && hasSubject && hasFaculty && hasRoom && hasSession);
    }
    
    private void renderCellValues(Object value, int row, int col, Component c) {
        JLabel cellLabel = ((JLabel) c);
        if (col == 3 || col == 4 || col == 5) {
            if (value instanceof Subject) {
                cellLabel.setText(((Subject) value).getSubjectCode());
            } else if (value instanceof Faculty) {
                cellLabel.setText(((Faculty) value).getLastName() + ", " + ((Faculty) value).getFirstName() + " " + ((Faculty) value).getMiddleName());
                colorWithOriginal(c, row);
            } else if (value instanceof Room) {
                ((JLabel) c).setText(((Room) value).getRoomName());
                colorWithOriginal(c, row);
            }
        }
    }

    private void validateFacultyAvailability(JTable table, int row, Component cellComponent) {
        boolean hasSchedule = false;
        ScheduleDaoImpl scheduleDaoImpl = new ScheduleDaoImpl();
        SchoolYear schoolYear = new SchoolYearDaoImpl().getCurrentSchoolYear();
        Schedule schedule = new Schedule();
        schedule.setDay(getDayEquivalent(table.getValueAt(row, 0).toString().trim()));
        schedule.setStartTime(Integer.parseInt(table.getValueAt(row, 1).toString().trim().replace(":", "")));
        schedule.setEndTime(Integer.parseInt(table.getValueAt(row, 2).toString().trim().replace(":", "")));
        schedule.setFaculty((Faculty) table.getValueAt(row, 4));
        schedule.setSchoolYear(schoolYear);
        hasSchedule = scheduleDaoImpl.facultyhasScheduleAt(schedule);
        if (hasSchedule) {
            cellComponent.setBackground(Color.PINK);
            ((JLabel) cellComponent).setForeground(Color.BLACK);
        } else {
            validateTimeAndSession(table, (DefaultTableModel)table.getModel(), row, cellComponent);
//            colorWithOriginal(cellComponent, row);
        }
    }

    private String getDayEquivalent(String longDay) {
        String oneCharDay = longDay.trim().equalsIgnoreCase("Mon") ? "M"
                : longDay.trim().equalsIgnoreCase("Tue") ? "T"
                : longDay.trim().equalsIgnoreCase("Wed") ? "W"
                : longDay.trim().equalsIgnoreCase("Thu") ? "TH" : "F";
        return oneCharDay;
    }

    private void validateTimeAndSession(JTable table, DefaultTableModel tableModel, int row, Component c) {
        Object objStartTime = tableModel.getValueAt(row, 1);
        Object objEndTime = tableModel.getValueAt(row, 2);
        Object objSession = tableModel.getValueAt(row, 6);
        int sTime = Integer.parseInt(tableModel.getValueAt(row, 1).toString().trim().replace(":", ""));
        int eTime = Integer.parseInt(tableModel.getValueAt(row, 2).toString().trim().replace(":", ""));
        JLabel cellLabel = (JLabel) c;
        if ((sTime == eTime) || (sTime > eTime) || (eTime < sTime)) {
            c.setBackground(Color.RED);
            cellLabel.setForeground(Color.WHITE);
        } else if (hasDuplicateAt(1, objStartTime, table)) {
            c.setBackground(Color.RED);
            cellLabel.setForeground(Color.WHITE);
        } else if (hasDuplicateAt(2, objEndTime, table)) {
            c.setBackground(Color.RED);
            cellLabel.setForeground(Color.WHITE);
        } else if (!startTimeMatchesSession(sTime, objSession.toString())) {
            c.setBackground(Color.RED);
            cellLabel.setForeground(Color.WHITE);
        } else if (!endTimeMatchesSession(eTime, objSession.toString())) {
            c.setBackground(Color.RED);
            cellLabel.setForeground(Color.WHITE);
        } else {
            colorWithOriginal(c, row);
        }
    }

    private void colorWithOriginal(Component c, int row) {
        if (row % 2 == 0) {
            c.setBackground(Color.WHITE);
            ((JLabel) c).setForeground(Color.BLACK);
        } else {
            c.setBackground(Color.WHITE);
            ((JLabel) c).setForeground(Color.BLACK);
        }
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

    private boolean hasDuplicateAt(int col, Object value, JTable table) {
        int countOfRecord = 0;
        for (int row = 0; row < table.getRowCount(); row++) {
            if (value.equals(table.getValueAt(row, col))) {
                countOfRecord++;
            }
        }
        return countOfRecord > 1;
    }

    private boolean hasDuplicate(Object startTime, Object endTime, Object faculty, JTable table) {
        int countOfRecord = 0;
        for (int row = 0; row < table.getRowCount(); row++) {
            Object sTime = table.getValueAt(row, 1);
            Object eTime = table.getValueAt(row, 2);
            Object f = table.getValueAt(row, 4);
            if (startTime.equals(sTime) && endTime.equals(eTime) && faculty.equals(f)) {
                countOfRecord++;
            }
        }
        return countOfRecord > 1;
    }

}
