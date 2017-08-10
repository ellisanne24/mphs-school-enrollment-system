/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_editor;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DateFormatter;

/**
 *
 * @author John Ferdinand Antonio
 */
public class ScheduleTimeCellEditor extends DefaultCellEditor {

    private final JSpinner spinner;
    private SpinnerDateModel model;
    private SimpleDateFormat format;
    private JSpinner.DateEditor editor;
    private JTable jtable;
    
    public ScheduleTimeCellEditor(JTable jtable) {
        super(new JTextField());
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        model = new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
        spinner = new JSpinner(model);
        editor = new JSpinner.DateEditor(spinner, "HH:mm");
        editor.getTextField().setEditable(true);
        spinner.setEditor(editor);
       
        final JLabel label = new JLabel();
        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSpinner s = (JSpinner)e.getSource();
                
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return spinner;
    }

    @Override
    public Object getCellEditorValue() {
        Date date = (Date) spinner.getValue();
        int time = getTimeAsInteger(date);
        
        return editor.getFormat().format(spinner.getValue());
    }
    
    private int getTimeAsInteger(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        int hour = calendar.get(Calendar.HOUR_OF_DAY) * 100;
        int mins = calendar.get(Calendar.MINUTE);
        int time = (hour + mins);
        return time;
    }

}
