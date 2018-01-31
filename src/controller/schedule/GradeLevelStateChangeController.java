package controller.schedule;

import component_editor.ScheduleSubjectCellEditor;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.SectionDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import model.gradelevel.GradeLevel;
import model.section.Section;

/**
 *
 * @author John Ferdinand Antonio
 */
public class GradeLevelStateChangeController implements ItemListener {

    private final JComboBox jcmbGradeLevel;
    private final JComboBox jcmbSections;
    private final JTable jtblSchedule;
    private final JButton jbtnRemoveEntry;
    private final JComboBox jcmbRoom;

    public GradeLevelStateChangeController(JTable jtblSchedule, JComboBox jcmbGradeLevel, JComboBox jcmbSections, JButton jbtnRemoveEntry, JComboBox jcmbRoom) {
        this.jcmbGradeLevel = jcmbGradeLevel;
        this.jcmbSections = jcmbSections;
        this.jtblSchedule = jtblSchedule;
        this.jbtnRemoveEntry = jbtnRemoveEntry;
        this.jcmbRoom = jcmbRoom;

        jbtnRemoveEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] rowsToDel = jtblSchedule.getSelectedRows();
                int choice = JOptionPane.showConfirmDialog(null, "Remove Row?", "Remove Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (choice == JOptionPane.YES_OPTION) {
                    DefaultTableModel model = (DefaultTableModel) jtblSchedule.getModel();
                    for (int i = 0; i < rowsToDel.length; i++) {
                        model.removeRow(rowsToDel[i] - i);
                    }
                }
            }
        });
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (jcmbGradeLevel.getSelectedIndex() > -1) {
            GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
            String level = jcmbGradeLevel.getSelectedItem().toString().trim();
            int gradeLevelId = gldi.getId(Integer.parseInt(level));
            GradeLevel gradeLevel = new GradeLevel();
            gradeLevel.setId(gradeLevelId);

            clearScheduleTableModel();
            enableScheduleTable();
            TableColumnModel columnModel = jtblSchedule.getColumnModel();
            TableColumn subjectColumn = columnModel.getColumn(3);
            subjectColumn.setCellEditor(new ScheduleSubjectCellEditor(jtblSchedule, gradeLevelId));

            jcmbSections.setModel(getGradeLevelSections(gradeLevel));
            jcmbSections.setEnabled(true);
   
            jcmbRoom.setEnabled(false);
            jcmbRoom.setSelectedItem(null);
        }
    }

    private DefaultComboBoxModel getGradeLevelSections(GradeLevel g) {
        SectionDaoImpl sdi = new SectionDaoImpl();
        SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();
        DefaultComboBoxModel sectionModel = new DefaultComboBoxModel();
//        List<Section> sections = sdi.getAllSectionsByGradeLevelId(g);
//        for (Section s : sections) {
//            if (!sdi.hasSchedule(s.getSectionId(), sydi.getCurrentSchoolYearId())) {
//                sectionModel.addElement(s.getSectionName().trim());
//            }
//
//        }
        sectionModel.setSelectedItem(null);
        return sectionModel;
    }

    private void enableScheduleTable() {
        jtblSchedule.setEnabled(true);
    }

    private void clearScheduleTableModel() {
        DefaultTableModel model = (DefaultTableModel) jtblSchedule.getModel();
        model.setRowCount(0);
    }
}
