
package controller.schedule;

import component_editor.ScheduleFacultyCellEditor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author Jordan
 */
public class ScheduleTableLoadSubjectFacultyOnClick implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JTable) {
            JTable table = (JTable) e.getSource();
            TableColumn facultyColumn =  table.getColumnModel().getColumn(4);
            facultyColumn.setCellEditor(new ScheduleFacultyCellEditor(table));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
    
}
