package component_renderers;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author John Ferdinand Antonio
 */
public class Renderer_Schedule_Conflict_JTableCell extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int col) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        boolean hasStartTime = (model.getValueAt(row, 1) != null);
        boolean hasEndTime = (model.getValueAt(row, 2) != null);

        if (hasStartTime && hasEndTime) {
            String startTime = model.getValueAt(row, 1).toString().trim();
            String endTime = model.getValueAt(row, 2).toString().trim();
            if (startTime.equals(endTime)) {
                cellComponent.setBackground(Color.RED);
                ((JLabel) cellComponent).setForeground(Color.WHITE);
            } else {
                colorWithOriginal(cellComponent, row);
            }
        } else {
            colorWithOriginal(cellComponent, row);
        }
        return cellComponent;
    }

    private void colorWithOriginal(Component c, int row) {
        if (row % 2 == 0) {
            c.setBackground(Color.WHITE);
            ((JLabel) c).setForeground(Color.BLACK);
        } else {
            c.setBackground(Color.WHITE);
            ((JLabel) c).setForeground(Color.BLACK);
        }
    }
}
