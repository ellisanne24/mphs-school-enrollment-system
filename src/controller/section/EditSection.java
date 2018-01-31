
package controller.section;

import daoimpl.GradeLevelDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.SectionDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.section.Section;

/**
 *
 * @author Jordan
 */
public class EditSection implements ActionListener{
    
    private final int sectionIdOfSelected;
    
    private final JDialog dialogSectionCrud;
    private final JTextField jtfSectionName;
    private final JComboBox jcmbGradeLevel;
    private final JComboBox jcmbAdviser;
    private final JComboBox jcmbSession;
    private final JComboBox jcmbStatus;
    
    private SectionDaoImpl sectionDaoImpl;
    private GradeLevelDaoImpl gradeLevelDaoImpl;
    private SchoolYearDaoImpl schoolYearDaoImpl;
    
    public EditSection(int sectionIfOfSelected, JDialog dialogSectionCrud,JTextField jtfSectionName, JComboBox jcmbGradeLevel, JComboBox jcmbAdviser, JComboBox jcmbSession,JComboBox jcmbStatus){
        this.dialogSectionCrud = dialogSectionCrud;
        
        this.sectionIdOfSelected = sectionIfOfSelected;
        
        this.jtfSectionName = jtfSectionName;
        this.jcmbGradeLevel = jcmbGradeLevel;
        this.jcmbAdviser = jcmbAdviser;
        this.jcmbSession = jcmbSession;
        this.jcmbStatus = jcmbStatus;
        
        sectionDaoImpl = new SectionDaoImpl();
        gradeLevelDaoImpl = new GradeLevelDaoImpl();
        schoolYearDaoImpl = new SchoolYearDaoImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int choice = 
                JOptionPane.showConfirmDialog(null, "Update Section?", "Update Confirmation", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION){
            if(update()){
                JOptionPane.showMessageDialog(null,"Successfully updated section!");
                dialogSectionCrud.dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Failed to update section.");
            }
        }
    }
    
    private boolean update(){
        boolean isUpdated = false;
        Section section = new Section();
        section.setSectionId(sectionIdOfSelected);
        section.setSectionName(jtfSectionName.getText().trim());
        section.setIsActive(jcmbStatus.getSelectedItem().toString().trim().equalsIgnoreCase("Yes")?true:false);
        
        SchoolYear schoolYear = new SchoolYear();
        schoolYear.setSchoolYearId(schoolYearDaoImpl.getCurrentSchoolYearId());
        
        section.setSchoolYear(schoolYear);
        
        GradeLevel gradeLevel = new GradeLevel();
        int gradeLevelNo = Integer.parseInt(jcmbGradeLevel.getSelectedItem().toString().trim());
        gradeLevel.setId(gradeLevelDaoImpl.getId(gradeLevelNo));
        
        section.setGradeLevel(gradeLevel);
        section.setSectionSession(jcmbSession.getSelectedItem().toString().trim());
        
        isUpdated = sectionDaoImpl.updateSection(section);
        
        return isUpdated;
    }
}
