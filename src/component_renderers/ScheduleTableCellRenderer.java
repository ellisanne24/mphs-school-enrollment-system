/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_renderers;

import java.awt.Color;
import utility.component.JTableUtil;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class ScheduleTableCellRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int col) {
        
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
        JTableUtil.setCellsAlignment(table, SwingConstants.CENTER);
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if (model.getRowCount() > 0) {
            Object obj = model.getValueAt(row, col); //(row, column)
            
        }
        return c;
    }
    
}
