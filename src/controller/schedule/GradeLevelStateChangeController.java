package controller.schedule;

import component_editor.ScheduleSubjectCellEditor;
import component_model_loader.SectionJCompModelLoader;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.SubjectDaoImpl;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.gradelevel.GradeLevel;
import view.schedule.Dialog_CreateSchedule;

/**
 *
 * @author John Ferdinand Antonio
 */
public class GradeLevelStateChangeController implements ItemListener {

    private SubjectDaoImpl subjectDaoImpl;
    private SectionJCompModelLoader sectionJCompModelLoader;
    private GradeLevelDaoImpl gradeLevelDaoImpl;
    private final Dialog_CreateSchedule view;
    private final JComboBox jcmbGradeLevel;
    private final JComboBox jcmbSections;
    private final JTable jtblSchedule;
    private final JButton jbtnRemoveEntry;
    private final JComboBox jcmbRoom;
    private final JComboBox jcmbSchoolYear;

    public GradeLevelStateChangeController(Dialog_CreateSchedule view) {
        this.view = view;
        this.jcmbGradeLevel = view.getJcmbGradeLevel();
        this.jcmbSections = view.getJcmbSection();
        this.jtblSchedule = view.getJtblSchedule();
        this.jbtnRemoveEntry = view.getJbtnRemoveEntry();
        this.jcmbRoom = view.getJcmbRoom();
        this.jcmbSchoolYear = view.getJcmbSchoolYear();

        subjectDaoImpl = new SubjectDaoImpl();
        gradeLevelDaoImpl = new GradeLevelDaoImpl();
        sectionJCompModelLoader = new SectionJCompModelLoader();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (jcmbGradeLevel.getSelectedIndex() > -1) {
            resetForm();
            loadSectionIdsByGradeLevelSelected();
            loadSubjectsByGradeLevelSelected();
            loadGradeLevelToScheduleHeader();
        }
    }

    private void loadSectionIdsByGradeLevelSelected() {
        int gradeLevelId = Integer.parseInt(jcmbGradeLevel.getSelectedItem().toString().trim());
        int schoolYearId = Integer.parseInt(jcmbSchoolYear.getSelectedItem().toString().trim());
        jcmbSections.setModel(sectionJCompModelLoader.getSectionIdsWithoutSchedule(true, schoolYearId, gradeLevelId));
    }
    
    private void loadSubjectsByGradeLevelSelected(){
        int gradeLevelId = Integer.parseInt(jcmbGradeLevel.getSelectedItem().toString().trim());
        TableColumn subjectColumn = jtblSchedule.getColumnModel().getColumn(3);
        subjectColumn.setCellEditor(new ScheduleSubjectCellEditor(jtblSchedule, gradeLevelId));
    }
    
    private void loadGradeLevelToScheduleHeader() {
        String gradeLevelId = view.getJcmbGradeLevel().getSelectedItem().toString().trim();
        GradeLevel g = gradeLevelDaoImpl.getById(Integer.parseInt(gradeLevelId));
        view.getJtfGradeLevel().setText(g.getLevelNo() == 0 ? "Kindergarten" : g.getLevelNo() + "");
    }

    private void resetForm(){
        view.getJbtnGrpDays().clearSelection();
        view.getJtfSectionName().setText("");
        view.getJtfAdviserName().setText("");
        view.getJtfGradeLevel().setText("");
        ((DefaultTableModel)view.getJtblSchedule().getModel()).setRowCount(0);
        ((DefaultTableModel)view.getJtblMonday().getModel()).setRowCount(0);
        ((DefaultTableModel)view.getJtblTuesday().getModel()).setRowCount(0);
        ((DefaultTableModel)view.getJtblWednesday().getModel()).setRowCount(0);
        ((DefaultTableModel)view.getJtblThursday().getModel()).setRowCount(0);
        ((DefaultTableModel)view.getJtblFriday().getModel()).setRowCount(0);
    }
}
