package component_editor;

import daoimpl.SubjectDaoImpl;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;
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
        jcmbSubject = new JComboBox(subjectModel);
        jcmbSubject.setEditable(false);

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
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        GradeLevel gradeLevel = new GradeLevel();
        gradeLevel.setId(gradelevelId);

        List<Subject> list = subjectDaoImpl.getAllSubjectsByGradeLevelId(gradeLevel.getId());
        int subjectsCount = 0;
        
        
        DefaultTableModel scheduleTableModel = (DefaultTableModel) jtblSchedule.getModel();
        int tableRow = 0;
        for (Subject s : list) {
            subjectsCount++;
            scheduleTableModel.setRowCount(subjectsCount);
            model.addElement(s.getSubjectCode());
            model.setSelectedItem(s.getSubjectCode());
            scheduleTableModel.setValueAt(s.getSubjectCode(), tableRow, 3);
            tableRow++;
        }
        scheduleTableModel.setRowCount(subjectsCount);

        model.setSelectedItem(null);
        return model;
    }

    private void loadFaculty() {
        TableColumnModel columnModel = jtblSchedule.getColumnModel();
        TableColumn facultyColumn = columnModel.getColumn(4);
        facultyColumn.setCellEditor(new ScheduleFacultyCellEditor());
    }
    
    
    @Override
    public boolean isCellEditable(EventObject anEvent) {
        boolean cellEditable = super.isCellEditable(anEvent);
        if (cellEditable && anEvent instanceof MouseEvent) {
            cellEditable = ((MouseEvent) anEvent).getClickCount() == 2;
        }
        if(cellEditable && anEvent instanceof ItemEvent){
            cellEditable = ((ItemEvent)anEvent).getStateChange() == 1;
        }
        return cellEditable;
    }
}
