
package utility.jtable;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jordan
 */
public class JTableUtil {
    
    public static void removeSelectedRows(int[] selectedRows, JTable jTable) {
        for (int i = selectedRows.length - 1; i >= 0; i--) {
            DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
            tableModel.removeRow(selectedRows[i]);
        }
    }
    
    public static void moveRowData(JTable tableSource, JTable tableDestination){
        DefaultTableModel tableModelSource = (DefaultTableModel) tableSource.getModel();
        DefaultTableModel tableModelDestination = (DefaultTableModel) tableDestination.getModel();
        int tableSourceColCount = tableSource.getColumnCount();
        int[] selectedRows = tableSource.getSelectedRows();
        for(int i = 0; i < selectedRows.length; i++){
            Object[] rowData = new Object[tableSourceColCount];
            for(int col = 0; col < tableSourceColCount; col++){
                rowData[col] = tableModelSource.getValueAt(i, col);
            }
            tableModelDestination.addRow(rowData);
        }
        removeSelectedRows(selectedRows, tableSource);
    }
    
}
