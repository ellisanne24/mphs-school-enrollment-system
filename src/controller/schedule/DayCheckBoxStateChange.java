package controller.schedule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import utility.string.StringUtil;
import view.schedule.Dialog_CreateSchedule;

/**
 *
 * @author John Ferdinand Antonio
 */
public class DayCheckBoxStateChange implements ActionListener {

    private final Dialog_CreateSchedule view;
    private final JCheckBox jcbMonday;
    private final JCheckBox jcbTuesday;
    private final JCheckBox jcbWednesday;
    private final JCheckBox jcbThursday;
    private final JCheckBox jcbFriday;
    private final JCheckBox jcbDayMonWedFri;
    private final JTable jtblSchedule;

    public DayCheckBoxStateChange(Dialog_CreateSchedule view) {
        this.view = view;
        this.jtblSchedule = view.getJtblSchedule();
        this.jcbMonday = view.getJcbMonday();
        this.jcbTuesday = view.getJcbTuesday();
        this.jcbWednesday = view.getJcbWednesday();
        this.jcbThursday = view.getJcbThursday();
        this.jcbFriday = view.getJcbFriday();
        this.jcbDayMonWedFri = view.getJcbDayMonWedFri();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jcbMonday && jcbMonday.isSelected()) {
            loadDaysToTable(jcbMonday);
        } else if (e.getSource() == jcbTuesday && jcbTuesday.isSelected()) {
            loadDaysToTable(jcbTuesday);
        } else if (e.getSource() == jcbWednesday && jcbWednesday.isSelected()) {
            loadDaysToTable(jcbWednesday);
        } else if (e.getSource() == jcbThursday && jcbThursday.isSelected()) {
            loadDaysToTable(jcbThursday);
        } else if (e.getSource() == jcbFriday && jcbFriday.isSelected()) {
            loadDaysToTable(jcbFriday);
        } else if(e.getSource() == jcbDayMonWedFri && jcbDayMonWedFri.isSelected()){
            loadDaysToTable(jcbDayMonWedFri);
        }
    }

    private void loadDaysToTable(JCheckBox jcbDay) {
        String day = jcbDay.getText().trim();
        int dayCol = 0;
        
        for (int row = 0; row < jtblSchedule.getRowCount(); row++) {
            jtblSchedule.setValueAt(day, row, dayCol);
        }
    }
}
