/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_editor;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author John Ferdinand Antonio
 */
public class ScheduleDayCellEditor extends DefaultCellEditor{
    private JComboBox jcmbDays;
    private DefaultComboBoxModel model;
    
    
    public ScheduleDayCellEditor(){
        super(new JComboBox());
        model = new DefaultComboBoxModel(new String[]{"Mon","Tue","Wed","Thu","Fri"});
        jcmbDays = new JComboBox(model);
        jcmbDays.setEditable(true);
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return jcmbDays;
    }

    @Override
    public Object getCellEditorValue() {
        return jcmbDays.getSelectedItem(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
