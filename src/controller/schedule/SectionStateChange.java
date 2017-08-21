package controller.schedule;

import component_editor.ScheduleSubjectCellEditor;
import daoimpl.GradeLevelDaoImpl;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import model.gradelevel.GradeLevel;

/**
 *
 * @author John Ferdinand Antonio
 */
public class SectionStateChange implements ItemListener{

    private final JComboBox jcmbRoom;
    private final JComboBox jcmbGradeLevel;
    private final JComboBox jcmbSections;
    private final JTable jtblSchedule;
    
    public SectionStateChange(JComboBox jcmbSections, JTable jtblSchedule,JComboBox jcmbGradeLevel, JComboBox jcmbRoom){
        this.jtblSchedule = jtblSchedule;
        this.jcmbSections = jcmbSections;
        this.jcmbGradeLevel = jcmbGradeLevel;
        this.jcmbRoom = jcmbRoom;
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (jcmbSections.getSelectedIndex() > -1) {
                loadSubjectsToTable();
                loadRoom();
                jcmbRoom.setEnabled(true);
        }
    }
    
    private void loadSubjectsToTable() {
        GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
        String level = jcmbGradeLevel.getSelectedItem().toString().trim();
        int gradeLevelId = gldi.getId(Integer.parseInt(level));
        GradeLevel gradeLevel = new GradeLevel();
        gradeLevel.setId(gradeLevelId);

        TableColumnModel columnModel = jtblSchedule.getColumnModel();
        TableColumn subjectColumn = columnModel.getColumn(3);
        subjectColumn.setCellEditor(new ScheduleSubjectCellEditor(jtblSchedule, gradeLevelId));
    }
    
    private void loadRoom(){
        if(jcmbRoom.getSelectedIndex() > -1){
            String room = jcmbRoom.getSelectedItem().toString();
            for(int r = 0; r<jtblSchedule.getRowCount(); r++){
                jtblSchedule.setValueAt(room, r, 5);
            }
        }
    }
    
    
    
}
