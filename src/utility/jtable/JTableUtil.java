
package utility.jtable;

import javax.swing.JOptionPane;
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
    
    public static void moveRowData(JTable tableSource, JTable tableDestination) {
        DefaultTableModel tableModelSource = (DefaultTableModel) tableSource.getModel();
        DefaultTableModel tableModelDestination = (DefaultTableModel) tableDestination.getModel();
        int tableSourceColCount = tableSource.getColumnCount();
        int[] selectedRows = tableSource.getSelectedRows();
        for (int i = 0; i < selectedRows.length; i++) {
            Object[] rowData = new Object[tableSourceColCount];
            boolean added = false;
            for (int col = 0; col < tableSourceColCount; col++) {
                if (!exists(tableDestination, tableModelSource.getValueAt(i, 0).toString().trim())) {
                    rowData[col] = tableModelSource.getValueAt(i, col);
                    added = true;
                }
            }
            if (added) {
                tableModelDestination.addRow(rowData);
            }else{
                JOptionPane.showMessageDialog(null,tableModelSource.getValueAt(i, 0)+" already on table");
            }
        }
        removeSelectedRows(selectedRows, tableSource);
    }
    
    private static boolean exists(JTable table, String valueToCheck){
        boolean exists = false;
        for(int i = 0; i<table.getRowCount(); i++){
            exists = table.getValueAt(i, 0).toString().trim().equalsIgnoreCase(valueToCheck.trim());
            if(exists){
                break;
            }
        }
        return exists;
    }
    
}
