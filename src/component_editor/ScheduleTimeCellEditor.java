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

/**
 *
 * @author John Ferdinand Antonio
 */
public class ScheduleTimeCellEditor extends DefaultCellEditor {

    private final JSpinner spinner;
    private final SpinnerDateModel spinnerDateModel;
    private SimpleDateFormat format;
    private final JSpinner.DateEditor editor;
    private final JTable jtblSchedule;
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return spinner;
    }
    
    public ScheduleTimeCellEditor(JTable jtblSchedule) {
        super(new JTextField());
        this.jtblSchedule = jtblSchedule;
        spinnerDateModel = new SpinnerDateModel();
        spinnerDateModel.setValue(new CustomSpinnerModelArg().getValue());
        spinnerDateModel.setCalendarField(new CustomSpinnerModelArg().getStep());
        
        spinner = new JSpinner(spinnerDateModel);
        
        editor = new JSpinner.DateEditor(spinner, "HH:mm");
        editor.getTextField().setEditable(true);
        spinner.setEditor(editor);
       
        final JLabel label = new JLabel();
        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(!tableHasEmptyFields()){
                    checkConflict();
                }
                
            }
        });
        
//        ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                if (e.getKeyChar() == KeyEvent.VK_ENTER || e.getKeyChar() == KeyEvent.VK_TAB) {
//                    JOptionPane.showMessageDialog(null,"User keytyped ENTER!");
//                }
//            }
//        });
    }

    @Override
    public Object getCellEditorValue() {
        Date date = (Date) spinner.getValue();
        int time = getDateAsIntTime(date);
         SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//        return editor.getFormat().format(spinner.getValue());
return sdf.format(spinner.getValue());
    }
    
    private int getDateAsIntTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        int hour = calendar.get(Calendar.HOUR_OF_DAY) * 100;
        int mins = calendar.get(Calendar.MINUTE);
        int time = (hour + mins);
        return time;
    }
    
    public class CustomSpinnerModelArg {
        Calendar value;
        Calendar minimum;
        Calendar maximum;
        Calendar step;

        public CustomSpinnerModelArg() {
            value = Calendar.getInstance();
            minimum = Calendar.getInstance();
            maximum = Calendar.getInstance();
            step = Calendar.getInstance();
        }
        
        public Date getValue() {
            value.set(Calendar.HOUR_OF_DAY, 7);
            value.set(Calendar.MINUTE, 0);
            return value.getTime();
        }

        public Calendar getMinimum() {
            minimum.set(Calendar.HOUR_OF_DAY, 7);
            maximum.set(Calendar.MINUTE, 0);
            return minimum;
        }

        public Calendar getMaximum() {
            maximum.set(Calendar.HOUR_OF_DAY, 18);
            maximum.set(Calendar.MINUTE, 0);
            return maximum;
        }

        public int getStep() {
            step.set(Calendar.HOUR_OF_DAY, 00);
            step.set(Calendar.MINUTE, 15);
            return step.get(Calendar.HOUR_OF_DAY);
        }
    }

    
    private void checkConflict() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        int selectedRow = jtblSchedule.getSelectedRow();
        String d = jtblSchedule.getValueAt(selectedRow, 0).toString().trim();
        String sT = sdf.format(spinner.getValue());
        String eT = sdf.format(spinner.getValue());

        System.out.println(d + "\n" + sT + "\n" + eT + "\n");
    }
    
    private boolean tableHasEmptyFields(){
        boolean hasEmptyFields = true;
        int countOfEmpty = 0;
        for(int row = 0; row<jtblSchedule.getRowCount(); row++){
            for(int col = 0; col <jtblSchedule.getColumnCount(); col++){
                if(jtblSchedule.getValueAt(row, col) == null){
                    countOfEmpty++;
                }
            }
            if(countOfEmpty <= 0){
                hasEmptyFields = false;
            }
        }
        return hasEmptyFields;
    }
}
