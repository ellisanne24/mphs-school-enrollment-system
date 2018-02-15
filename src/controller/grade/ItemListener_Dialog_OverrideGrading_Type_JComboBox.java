
package controller.grade;

import component_model_loader.SectionJCompModelLoader;
import daoimpl.FacultyDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.faculty.Faculty;
import model.schoolyear.SchoolYear;
import model.user.User;
import view.grades.View_Dialog_OverrideGrading;

/**
 *
 * @author Jordan
 */
public class ItemListener_Dialog_OverrideGrading_Type_JComboBox implements ItemListener{

    private final User user;
    private final View_Dialog_OverrideGrading view;
    private final FacultyDaoImpl facultyDaoImpl;
    private final SchoolYearDaoImpl schoolYearDaoImpl;
    private final SectionJCompModelLoader sectionJCompModelLoader;
    
    public ItemListener_Dialog_OverrideGrading_Type_JComboBox(View_Dialog_OverrideGrading view, User user) {
        this.view = view;
        this.user = user;
        this.facultyDaoImpl = new FacultyDaoImpl();
        this.schoolYearDaoImpl = new SchoolYearDaoImpl();
        this.sectionJCompModelLoader = new SectionJCompModelLoader();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED){
            resetFormState();
            JComboBox jcmbType = (JComboBox) e.getSource();
            String selected = jcmbType.getSelectedItem().toString().trim();
            if(selected.equalsIgnoreCase("Handled")){
                if(user.getRole().getRoleName().trim().equalsIgnoreCase("Faculty")){
                    SchoolYear schoolYear = schoolYearDaoImpl.getCurrentSchoolYear();
                    Faculty faculty = facultyDaoImpl.getFacultyByUser(user);
                    view.getJcmbSection().setModel(sectionJCompModelLoader.getSectionsHandledByFacultyByFacultyAndSchoolYear(faculty, schoolYear));
                }else{
                    JOptionPane.showMessageDialog(null,"There are no sections assigned to you.");
                }
                
            }else if(selected.equalsIgnoreCase("Advisory")){
                
            }
        }
    }
    
    private void resetFormState(){
        ((DefaultTableModel)view.getJtblGradingSheet().getModel()).setRowCount(0);
        view.getJcmbSection().setModel(new DefaultComboBoxModel());
        view.getJcmbGradeLevel().setModel(new DefaultComboBoxModel());
        view.getJcmbSubjectCode().setModel(new DefaultComboBoxModel());
    }
    
}

