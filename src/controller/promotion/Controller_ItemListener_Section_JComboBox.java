
package controller.promotion;

import daoimpl.GradeDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.SectionDaoImpl;
import daoimpl.StudentDaoImpl;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.grade.Grade;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.student.Student;
import view.promotion.Dialog_Promotion;

/**
 *
 * @author Jordan
 */
public class Controller_ItemListener_Section_JComboBox implements ItemListener{

    private final Dialog_Promotion view;
    private final SectionDaoImpl sectionDaoImpl;
    private final GradeDaoImpl gradeDaoImpl;
    private final StudentDaoImpl studentDaoImpl;
    private final SchoolYearDaoImpl schoolYearDaoImpl;
    
    public Controller_ItemListener_Section_JComboBox(Dialog_Promotion view) {
        this.view = view;
        this.sectionDaoImpl = new SectionDaoImpl();
        this.gradeDaoImpl = new GradeDaoImpl();
        this.studentDaoImpl = new StudentDaoImpl();
        this.schoolYearDaoImpl = new SchoolYearDaoImpl();
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        JComboBox jcmbSection = (JComboBox) e.getSource();
        if(jcmbSection.getSelectedIndex() > -1){
            Section section = (Section) jcmbSection.getSelectedItem();
            loadStudentsToTable(section);
            loadStudentGrades();
        }
    }
    
    private void loadStudentsToTable(Section section){
        DefaultTableModel tableModel = (DefaultTableModel) view.getJtblStudents().getModel();
        tableModel.setRowCount(0);
        List<Student> students = sectionDaoImpl.getSectionStudentsBySectionIdAndSchoolYearId(section);
        for(Student s : students){
            Object[] rowData = {
                s.getRegistration().getLastName()+", "+s.getRegistration().getFirstName()+" "+s.getRegistration().getMiddleName(),
                s.getStudentNo(),s.getGradeLevelNo()
            };
            tableModel.addRow(rowData);
        }
    }
    
    private void loadStudentGrades(){
        if(view.getJtblStudents().getRowCount() > 0){
            JTable t = view.getJtblStudents();
            for(int row = 0; row < t.getRowCount(); row++){
                Object studentNo = t.getValueAt(row, 1);
                Student student = studentDaoImpl.getStudentByStudentNo(Integer.parseInt(studentNo.toString().trim()));
                SchoolYear schoolYear = schoolYearDaoImpl.getCurrentSchoolYear();
                Grade syFinalGrade = gradeDaoImpl.getStudentFinalGradeForSchoolYear(student, schoolYear);
                t.setValueAt(syFinalGrade.getValue(), row, 3);
            }
        }
    }
    
}
