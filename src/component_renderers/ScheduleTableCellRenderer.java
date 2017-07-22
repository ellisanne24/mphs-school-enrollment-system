/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_renderers;

import utility.component.JTableUtil;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

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
        
//        int day = Integer.parseInt( ((JLabel)c).getText().trim());
//        int dayCol = 0;
//        
//        if ((day == 0) && (col == dayCol)) {
//            ((JLabel) c).setText("M");
//        }else if((day == 1) && (col == dayCol)) {
//            ((JLabel) c).setText("T");
//        }else if((day == 2) && (col == dayCol)){
//            ((JLabel) c).setText("W");
//        }else if((day == 3) && (col == dayCol)){
//            ((JLabel) c).setText("T");
//        }else if((day == 4) && (col == dayCol)){
//            ((JLabel) c).setText("F");
//        }else if((day == 5) && (col == dayCol)){
//            ((JLabel) c).setText("S");
//        }else if((day == 6) && (col == dayCol)){
//            ((JLabel) c).setText("Su");
//        }
        
        return c;
    }
    
    
}
