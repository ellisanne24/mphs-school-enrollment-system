package controller.grade;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import view.grades.View_Dialog_OverrideGrading;

/**
 *
 * @author Jordan
 */
public class TableModelListener_Dialog_OverrideGrading_GradingSheet_JTable implements TableModelListener {

    private final View_Dialog_OverrideGrading view;

    public TableModelListener_Dialog_OverrideGrading_GradingSheet_JTable(View_Dialog_OverrideGrading view) {
        this.view = view;
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        int colChanged = e.getColumn();
        if (colChanged == 3|| colChanged == 4 || colChanged == 5 || colChanged == 6) {
            DefaultTableModel tableModel = (DefaultTableModel) e.getSource();
            if (tableModel.getRowCount() > 0) {
                for (int row = 0; row < tableModel.getRowCount(); row++) {
                    int sum = 0;
                    int divisor = 0;
                    for (int col = 0; col < tableModel.getColumnCount(); col++) {
                        if (col == 3 || col == 4 || col == 5 || col == 6) {
                            if (tableModel.getValueAt(row, col) != null) {
                                divisor++;
                                sum += Integer.parseInt(tableModel.getValueAt(row, col).toString());
                            }
                        }
                    }
                    tableModel.setValueAt(sum, row, 7);
                    if(divisor != 0){
                        int finalGrade = sum/divisor;
                        tableModel.setValueAt(finalGrade,row,8);
                        tableModel.setValueAt(finalGrade >= 75? "Passed" : "Failed", row, 11);
                    }
                }
            }
        }
    }
}
