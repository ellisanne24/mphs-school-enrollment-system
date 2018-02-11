package component_renderers;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.faculty.Faculty;
import model.room.Room;
import model.subject.Subject;

/**
 *
 * @author John Ferdinand Antonio
 */
public class Renderer_Schedule_Conflict_JTableCell extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int col) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        boolean hasStartTime = (model.getValueAt(row, 1) != null);
        boolean hasEndTime = (model.getValueAt(row, 2) != null);

        if(col == 3 || col == 4 || col == 5){
            if(value instanceof Subject){
                Subject subject = (Subject) value;
                ((JLabel) cellComponent).setText(subject.getSubjectCode());
            }else if(value instanceof Faculty){
                Faculty f = (Faculty) value;
                ((JLabel) cellComponent).setText("" + f.getLastName() + ", " + f.getFirstName() + " " + f.getMiddleName());
                colorWithOriginal(cellComponent, row);
            }else if(value instanceof Room){
                Room r = (Room) value;
                ((JLabel) cellComponent).setText("" + r.getRoomName());
                colorWithOriginal(cellComponent, row);
            }
        }

        if (hasStartTime && hasEndTime) {
            checkConflict(table, model, row, cellComponent);
        } else {
            colorWithOriginal(cellComponent, row);
        }
        return cellComponent;
    }
    
    private void checkConflict(JTable table, DefaultTableModel model, int row, Component cellComponent) {
        Object objStartTime = model.getValueAt(row, 1);
        Object objEndTime = model.getValueAt(row, 2);
        Object objSession = model.getValueAt(row, 6);
        int startTime = Integer.parseInt(model.getValueAt(row, 1).toString().trim().replace(":", ""));
        int endTime = Integer.parseInt(model.getValueAt(row, 2).toString().trim().replace(":", ""));
        if ((startTime == endTime) || (startTime > endTime) || (endTime < startTime)) {
            cellComponent.setBackground(Color.RED);
            ((JLabel) cellComponent).setForeground(Color.WHITE);
        } else if (hasDuplicateAt(1, objStartTime, table)) {
            cellComponent.setBackground(Color.RED);
            ((JLabel) cellComponent).setForeground(Color.WHITE);
        }else if(hasDuplicateAt(2, objEndTime, table)){
            cellComponent.setBackground(Color.RED);
            ((JLabel) cellComponent).setForeground(Color.WHITE);
        } 
        else if (!startTimeMatchesSession(startTime, objSession.toString())) {
            cellComponent.setBackground(Color.RED);
            ((JLabel) cellComponent).setForeground(Color.WHITE);
        } else if (!endTimeMatchesSession(endTime, objSession.toString())) {
            cellComponent.setBackground(Color.RED);
            ((JLabel) cellComponent).setForeground(Color.WHITE);
        } else {
            colorWithOriginal(cellComponent, row);
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
    
    private boolean endTimeMatchesSession(int et, String s){
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
