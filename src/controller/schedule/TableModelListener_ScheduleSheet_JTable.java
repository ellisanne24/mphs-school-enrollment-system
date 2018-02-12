
package controller.schedule;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import view.schedule.Dialog_CreateSchedule;

/**
 *
 * @author Jordan
 */
public class TableModelListener_ScheduleSheet_JTable implements TableModelListener{

    private final Dialog_CreateSchedule view;
    
    public TableModelListener_ScheduleSheet_JTable(Dialog_CreateSchedule view){
        this.view = view;
    }
    
    @Override
    public void tableChanged(TableModelEvent e) {
        TableModel tableModel = (TableModel) e.getSource();
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            Object startTime = tableModel.getValueAt(row, 1);
            Object endTime = tableModel.getValueAt(row, 2);
            Object subject = tableModel.getValueAt(row, 3);
            Object session = tableModel.getValueAt(row, 6);
            if (startTime != null && endTime != null && session != null) {
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
                if(sTime == eTime){
                    view.getJtaWarnings().setText("Start time must not be equal to End time\n");
                    break;
                }
                if(sTime > eTime){
                    view.getJtaWarnings().setText("Start time must be less than End time\n");
                    break;
                }
                if(!startTimeMatchesSession(sTime, session.toString().trim())){
                    view.getJtaWarnings().setText("Start time of "+startTime+ " is not valid for "+session+ " session");
                    break;
                }
                if(!endTimeMatchesSession(eTime, session.toString().trim())){
                    view.getJtaWarnings().setText("End time of "+endTime+ " is not valid for "+session+ " session");
                    break;
                }else{
                    view.getJtaWarnings().setText("");
                }
            }
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
