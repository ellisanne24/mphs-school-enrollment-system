package component_renderers;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Jordan
 */
public class Renderer_Promotion_Students_JTable extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (isSelected) {
            cellComponent.setBackground(Color.BLUE);
            ((JLabel) cellComponent).setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        } else {
            validateGrade(cellComponent, table, row, 3);
            ((JLabel) cellComponent).setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
        }
        return this;
    }

    private void validateGrade(Component cellComponent, JTable table, int row, int col) {
        int grade = Integer.parseInt(table.getValueAt(row, col).toString().trim());
        if (grade >= 75) {
            cellComponent.setBackground(Color.GREEN);
        } else {
            cellComponent.setBackground(Color.PINK);
        }
    }
}
