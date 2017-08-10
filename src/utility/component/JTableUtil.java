package utility.component;

import java.awt.Component;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class JTableUtil {
    
    
    public static void deleteAllRows(final DefaultTableModel model) {
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    public void copyTableSectionData(JTable aSourceJTable, JTable aDestinationTable, double gwa) {
        int selectedRow = aSourceJTable.getSelectedRow(); //selected row which has the data to be added
        int destinationRows = aDestinationTable.getRowCount();
        Object selected = aSourceJTable.getValueAt(selectedRow, 1);
        Object[] destinationObj = new Object[destinationRows];
        
        DefaultTableModel sectionDestinationModel = null;
        DefaultTableModel sectionSourceModel = (DefaultTableModel) aSourceJTable.getModel();

        for (int j = 0; j < destinationRows; j++) {
            destinationObj[j] = aDestinationTable.getValueAt(j, 1);
        }
        
        
        
        if(Double.parseDouble(String.valueOf(aSourceJTable.getValueAt(aSourceJTable.getSelectedRow(), 2))) < gwa)
        {
            Object[] options = {"Yes, please",
                "No!"};
                int n = JOptionPane.showOptionDialog(null, aSourceJTable.getValueAt(aSourceJTable.getSelectedRow(), 1)+
                " doesn't meet requirements. Still add this student?",
                "Message",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[1]); //default button title
        
            if(n == JOptionPane.YES_OPTION)
            {
                sectionDestinationModel = (DefaultTableModel) aDestinationTable.getModel();

                Object[] rowData = new Object[aSourceJTable.getColumnCount()];
                int selectedRowIndex = aSourceJTable.getSelectedRow();
                
                for (int i = 0; i < aSourceJTable.getColumnCount(); i++) 
                {
                    rowData[i] = aSourceJTable.getValueAt(selectedRowIndex, i);
                }

                sectionDestinationModel.addRow(rowData);
                aDestinationTable.setModel(sectionDestinationModel);
                sectionSourceModel.removeRow(selectedRowIndex);
            }
            
            
        }
        
        else
        {
            if (Arrays.asList(destinationObj).contains(selected)) 
            {
                JOptionPane.showMessageDialog(null, selected + " is already on the list.");
            }
            else
            {
                sectionDestinationModel = (DefaultTableModel) aDestinationTable.getModel();

                Object[] rowData = new Object[aSourceJTable.getColumnCount()];
                int selectedRowIndex = aSourceJTable.getSelectedRow();
                
                for (int i = 0; i < aSourceJTable.getColumnCount(); i++) 
                {
                    rowData[i] = aSourceJTable.getValueAt(selectedRowIndex, i);
                }
            
                sectionDestinationModel.addRow(rowData);
                aDestinationTable.setModel(sectionDestinationModel);
                sectionSourceModel.removeRow(selectedRowIndex);
            }
        }
        
        
        

    }
    
    public void returnCopyData(JTable aDestinationTbl, JTable aSourceTbl)
    {
        DefaultTableModel sourceTblModel = (DefaultTableModel) aSourceTbl.getModel();
        DefaultTableModel destinatonTblModel = (DefaultTableModel) aDestinationTbl.getModel();
        int selectedRow = aDestinationTbl.getSelectedRow();
        Object[] destinationObj = new Object[aDestinationTbl.getColumnCount()];
        
        for(int i = 0; i < aDestinationTbl.getColumnCount(); i++)
        {
            destinationObj[i] = aDestinationTbl.getValueAt(selectedRow, i);
        }
        
        sourceTblModel.addRow(destinationObj);
        destinatonTblModel.removeRow(selectedRow);
    }
    
    public void copyTableCurriculumData(JTable aSourceJTable, JTable aDestinationJTable)
    {
        int selectedRow = aSourceJTable.getSelectedRow(); //selected row which has the data to be added
        int destinationRows = aDestinationJTable.getRowCount();
        Object selected = aSourceJTable.getValueAt(selectedRow, 1);//get value at selected
        Object[] destinationObj = new Object[destinationRows];
        
        DefaultTableModel sectionDestinationModel = null;
        DefaultTableModel sectionSourceModel = (DefaultTableModel) aSourceJTable.getModel();

        for (int j = 0; j < destinationRows; j++) {
            destinationObj[j] = aDestinationJTable.getValueAt(j, 1);
        }
    }
    
    public static void setCellsAlignment(JTable table, int alignment) {

        //Usage:
        // JTableGUIUtil.setCellsAlignment(table, SwingConstants.CENTER);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }

    public static void resizeColumnWidth(JTable table, int minimumCellWidth) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300) {
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
}
