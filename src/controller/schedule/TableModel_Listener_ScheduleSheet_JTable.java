
package controller.schedule;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Jordan
 */
public class TableModel_Listener_ScheduleSheet_JTable implements TableModelListener{

    private final int subjectColumn;
    
    public TableModel_Listener_ScheduleSheet_JTable(int subjectColumn){
        this.subjectColumn = subjectColumn;
    }
    
    @Override
    public void tableChanged(TableModelEvent e) {
        if(e.getColumn() == subjectColumn){
            System.out.println("Column that changed : "+e.getColumn());
            System.out.println("ScheduleModelChange source : "+e.getSource());
            TableModel tableModel = (TableModel)e.getSource();
            for(int i = 0; i < tableModel.getRowCount(); i++){
                System.out.println("Subject : "+tableModel.getValueAt(i, subjectColumn));
            }
        }
    }
    
}
