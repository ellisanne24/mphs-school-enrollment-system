
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
public class EditSection implements ActionListener, FormValidator{
    
    private final int sectionIdOfSelected;
    
    private final DialogSectionCrud view;
    
    private SectionDaoImpl sectionDaoImpl;
    private GradeLevelDaoImpl gradeLevelDaoImpl;
    private SchoolYearDaoImpl schoolYearDaoImpl;
    
    public EditSection(int sectionIfOfSelected, DialogSectionCrud view){
        this.view = view;
        this.sectionIdOfSelected = sectionIfOfSelected;
        
        sectionDaoImpl = new SectionDaoImpl();
        gradeLevelDaoImpl = new GradeLevelDaoImpl();
        schoolYearDaoImpl = new SchoolYearDaoImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int choice = 
                JOptionPane.showConfirmDialog(null, "Update Section?", "Update Confirmation", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION){
            if (formIsValid()) {
                if (update()) {
                    JOptionPane.showMessageDialog(null, "Successfully updated section!");
                    view.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update section.");
                }
            } 
        }
    }

    @Override
    public boolean formIsValid() {
        boolean isValid = true;
        int adviserId = Integer.parseInt(view.getJcmbAdviser().getSelectedItem().toString().trim());
        int currentSchoolYearId = schoolYearDaoImpl.getCurrentSchoolYearId();
        FacultyDaoImpl facultyDaoImpl = new FacultyDaoImpl();

        if (facultyDaoImpl.facultyHasAdvisory(adviserId, currentSchoolYearId)) {
            isValid = false;
            JOptionPane.showMessageDialog(null, "Faculty already has an advisory class.");
        }

        if (sectionNameExists()) {
            isValid = false;
            JOptionPane.showMessageDialog(null, "Section name is already taken.\n Please try a different name.");
        }
        return isValid;
    }
    
    private boolean sectionNameExists(){
        return sectionDaoImpl.sectionExists(view.getJtfSectionName().getText().trim());
    }
    
    private boolean update(){
        boolean isUpdated = false;
        
        SchoolYear schoolYear = new SchoolYear();
        schoolYear.setSchoolYearId(schoolYearDaoImpl.getCurrentSchoolYearId());
        
        GradeLevel gradeLevel = new GradeLevel();
        int gradeLevelNo = Integer.parseInt(view.getJcmbGradeLevel().getSelectedItem().toString().trim());
        gradeLevel.setId(gradeLevelDaoImpl.getId(gradeLevelNo));

        String selectedAdviser = StringUtil.removeAllNonNumeric(view.getJcmbAdviser().getSelectedItem().toString().trim());
        int adviserId = Integer.parseInt(StringUtil.removeWhiteSpaces(selectedAdviser));
        Faculty adviser = new Faculty();
        adviser.setFacultyID(adviserId);
        
        Section section = new Section();
        section.setSectionId(sectionIdOfSelected);
        section.setSectionName(view.getJtfSectionName().getText().trim());
        section.setIsActive(view.getJcmbStatus().getSelectedItem().toString().trim().equalsIgnoreCase("Yes")?true:false);
        section.setSchoolYear(schoolYear);
        section.setGradeLevel(gradeLevel);
        section.setSectionSession(view.getJcmbSession().getSelectedItem().toString().trim());
        section.setAdviser(adviser);
        section.setCapacity(Integer.parseInt(view.getJtfCapacity().getText().trim()));
        isUpdated = sectionDaoImpl.updateSection(section);
        
        return isUpdated;
    }
    
    
}
