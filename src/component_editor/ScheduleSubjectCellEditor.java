package component_editor;

import daoimpl.SubjectDaoImpl;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import model.gradelevel.GradeLevel;
import model.subject.Subject;

/**
 *
 * @author John Ferdinand Antonio
 */
public class ScheduleSubjectCellEditor extends DefaultCellEditor {

    private final JComboBox jcmbSubject;
    private final DefaultComboBoxModel subjectModel;
    private final SubjectDaoImpl subjectDaoImpl;
    private final int gradelevelId;
    private final JTable jtblSchedule;

    public ScheduleSubjectCellEditor(JTable jtblSchedule, int gradeLevelId) {
        super(new JComboBox());
        this.jtblSchedule = jtblSchedule;
        this.gradelevelId = gradeLevelId;
        subjectDaoImpl = new SubjectDaoImpl();
        subjectModel = getAllSubjectNames();
        subjectModel.setSelectedItem(null);
        jcmbSubject = new JComboBox(subjectModel);
        jcmbSubject.setEditable(true);

        jcmbSubject.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String subjecCodeSelected = jcmbSubject.getSelectedItem().toString().trim();
                Subject s = new Subject();
                s.setSubjectCode(subjecCodeSelected);
                int subjectId = subjectDaoImpl.getSubjectId(s);
                System.out.println("SUBJECT ID: " + subjectId);
                loadFaculty();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return jcmbSubject;
    }

    @Override
    public Object getCellEditorValue() {
        return jcmbSubject.getSelectedItem(); //To change body of generated methods, choose Tools | Templates.
    }

    private DefaultComboBoxModel getAllSubjectNames() {
        DefaultComboBoxModel subjectModel = new DefaultComboBoxModel();
        GradeLevel gradeLevel = new GradeLevel();
        gradeLevel.setId(gradelevelId);

        List<Subject> list = subjectDaoImpl.getAllSubjectsByGradeLevelId(gradeLevel);
        int subjectsCount = 0;

        for (Subject s : list) {
            subjectsCount++;
            subjectModel.addElement(s.getSubjectCode());
            subjectModel.setSelectedItem(null);
        }

        DefaultTableModel tableModel = (DefaultTableModel) jtblSchedule.getModel();
        tableModel.setRowCount(subjectsCount * 2);

        return subjectModel;
    }

    private void loadFaculty() {
        TableColumnModel columnModel = jtblSchedule.getColumnModel();
        TableColumn facultyColumn = columnModel.getColumn(4);
        facultyColumn.setCellEditor(new ScheduleFacultyCellEditor());
    }
}