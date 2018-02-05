
package controller.section;

import daoimpl.FacultyDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.SectionDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.faculty.Faculty;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.section.Section;
import utility.form.FormValidator;
import utility.string.StringUtil;
import view.section.DialogSectionCrud;

/**
 *
 * @author Jordan
 */
public class CreateSection implements ActionListener, FormValidator{
    
    private final DialogSectionCrud view;
    private final FacultyDaoImpl facultyDaoImpl;
    private final SchoolYearDaoImpl schoolYearDaoImpl;
    private final GradeLevelDaoImpl gradeLevelDaoImpl;
    private final SectionDaoImpl sectionDaoImpl;
    
    public CreateSection(DialogSectionCrud view){
        this.view = view;
        
        facultyDaoImpl = new FacultyDaoImpl();
        schoolYearDaoImpl = new SchoolYearDaoImpl();
        gradeLevelDaoImpl = new GradeLevelDaoImpl();
        sectionDaoImpl = new SectionDaoImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int choice = JOptionPane.showConfirmDialog(null, "Save Section?", "Save Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            if (formIsValid()) {
                if (addSection()) {
                    JOptionPane.showMessageDialog(null, "Successfully added Section!");
                    view.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add Section");
                }
            }
        }
    }
    
    private boolean addSection() {
        boolean isAdded = false;
        SchoolYear schoolYear = new SchoolYear();
        schoolYear.setSchoolYearId(schoolYearDaoImpl.getCurrentSchoolYearId());

        GradeLevel gradeLevel = new GradeLevel();
        int level = Integer.parseInt(view.getJcmbGradeLevel().getSelectedItem().toString().trim());
        gradeLevel.setId(gradeLevelDaoImpl.getId(level));
        
        Section section = new Section();
        section.setSectionName(view.getJtfSectionName().getText().trim());
        section.setSchoolYear(schoolYear);
        section.setGradeLevel(gradeLevel);
        section.setAdviser(getFacultyAdviser());
        section.setSectionSession(view.getJcmbSession().getSelectedItem().toString().trim());
        section.setCapacity(Integer.parseInt(view.getJtfCapacity().getText().trim()));
        isAdded = sectionDaoImpl.addSection(section);

        return isAdded;
    }
    
    private Faculty getFacultyAdviser(){
        String selectedAdviser = view.getJcmbAdviser().getSelectedItem().toString().trim();
        int adviserId = Integer.parseInt(selectedAdviser);
        Faculty f = new Faculty();
        f.setFacultyID(adviserId);
        return f;
    }
    
    @Override
    public boolean formIsValid() {
        boolean isValid = true;
        String selectedAdviser = view.getJcmbAdviser().getSelectedItem().toString().trim();
        int adviserId = Integer.parseInt(selectedAdviser);
        int currentSchoolYearId = schoolYearDaoImpl.getCurrentSchoolYearId();
        FacultyDaoImpl facultyDaoImpl = new FacultyDaoImpl();
        if(facultyDaoImpl.facultyHasAdvisory(adviserId, currentSchoolYearId)){
            isValid = false;
            JOptionPane.showMessageDialog(null, "Faculty already has an advisory class.");
        }
        if(sectionDaoImpl.sectionExists(view.getJtfSectionName().getText().trim())){
            isValid = false;
            JOptionPane.showMessageDialog(null, "Section name is already taken.\n Please try a different name.");
        }
        return isValid;
    }
    
}
