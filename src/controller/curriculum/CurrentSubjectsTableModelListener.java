
package controller.curriculum;

import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Jordan
 */
public class CurrentSubjectsTableModelListener implements TableModelListener{

    private JLabel jlblTotalHours;
    private JTable jtblCurrentSubjects;
    
    public CurrentSubjectsTableModelListener(JLabel jlblTotalHours,JTable jtblCurrentSubjects){
        this.jlblTotalHours = jlblTotalHours;
        this.jtblCurrentSubjects = jtblCurrentSubjects;
    }
    
    @Override
    public void tableChanged(TableModelEvent e) {
        TableModel tableModel = (TableModel) e.getSource();
        setTotalHours(getTotalHours(tableModel));
    }
    
    private Double getTotalHours(TableModel tableModel) {
        double totalHours = 0.00;
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            if (tableModel.getValueAt(row, 4) != null) {
                totalHours += Double.parseDouble(tableModel.getValueAt(row, 4).toString().trim());
            }
        }
        double roundedValue = Math.round(totalHours * 100D) / 100D;
        return roundedValue;
    }

    private void setTotalHours(double totalHours) {
        DecimalFormat df = new DecimalFormat("0.00");
        jlblTotalHours.setText(df.format(totalHours));
    }
}
