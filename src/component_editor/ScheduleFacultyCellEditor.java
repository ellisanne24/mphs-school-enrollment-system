/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_editor;

import daoimpl.FacultyDaoImpl;
import java.awt.Component;
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
        jcmbFaculty.setEditable(true);
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
        List<Faculty> list = facultyDaoImpl.getAll();
        for (Faculty f : list) {
            model.addElement(f.getFacultyID() + " - " + f.getLastName() + ", " + f.getFirstName() + ", " + f.getMiddleName());
        }
        return model;
    }
}
