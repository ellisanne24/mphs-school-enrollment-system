package component_editor;

import daoimpl.FacultyDaoImpl;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import model.faculty.Faculty;

/**
 *
 * @author John Ferdinand Antonio
 */
public class ScheduleFacultyCellEditor extends DefaultCellEditor {

    private final FacultyDaoImpl facultyDaoImpl;
    private final JComboBox jcmbFaculty;
    private final DefaultComboBoxModel facultyModel;

    public ScheduleFacultyCellEditor() {
        super(new JComboBox());
        facultyDaoImpl = new FacultyDaoImpl();
        jcmbFaculty = new JComboBox();
        facultyModel = getFacultyModel();
        jcmbFaculty.setModel(facultyModel);
        jcmbFaculty.setEditable(false);
        
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return jcmbFaculty;
    }

    @Override
    public Object getCellEditorValue() {
        return jcmbFaculty.getSelectedItem(); //To change body of generated methods, choose Tools | Templates.
    }

    private DefaultComboBoxModel getFacultyModel() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
//        List<Faculty> list = facultyDaoImpl.getAll();
        List<Faculty> list = new ArrayList<>();
        for (Faculty f : list) {
            model.addElement(f.getFacultyID() + " - " + f.getLastName() + ", " + f.getFirstName() + ", " + f.getMiddleName());
        }
        return model;
    }
    
    @Override
    public boolean isCellEditable(EventObject anEvent) {
        boolean cellEditable = super.isCellEditable(anEvent);
        if (cellEditable && anEvent instanceof MouseEvent) {
            cellEditable = ((MouseEvent) anEvent).getClickCount() == 2;
        }
        return cellEditable;
    }
}
