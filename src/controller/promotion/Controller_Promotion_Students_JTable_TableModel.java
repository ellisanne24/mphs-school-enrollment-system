
package controller.promotion;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Jordan
 */
public class Controller_Promotion_Students_JTable_TableModel implements TableModelListener{

    
    
    @Override
    public void tableChanged(TableModelEvent e) {
        if(e.getColumn() == 3){
            TableModel tableModel = (TableModel) e.getSource();
            int passingGrade = 75;
            for(int row = 0; row < tableModel.getRowCount(); row++){
                if(tableModel.getValueAt(row, 3) != null){
                    int currentGradeLevelNo = Integer.parseInt(tableModel.getValueAt(row, 2).toString().trim());
                    int finalGrade = Integer.parseInt(tableModel.getValueAt(row,3).toString().trim());
                    if(finalGrade >= passingGrade){
                        tableModel.setValueAt("Passed", row, 4);
//                        tableModel.setValueAt("Yes", row, 5);
                        tableModel.setValueAt(currentGradeLevelNo+1, row, 6);
                    }else{
                        tableModel.setValueAt("Failed", row, 4);
//                        tableModel.setValueAt("No", row, 5);
                        tableModel.setValueAt("Summer", row, 6);
                    }
                }
            }
        }
    }
}
