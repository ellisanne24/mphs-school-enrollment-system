
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
import model.faculty.Faculty;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.section.Section;

/**
 *
 * @author Jordan
 */
public class CreateSection implements ActionListener{
    
    private final JDialog dialogSectionCrud;
    private final JTextField jtfSectionName;
    private final JComboBox jcmbGradeLevel;
    private final JComboBox jcmbAdviser;
    private final JComboBox jcmbSession;
    
    private final SchoolYearDaoImpl schoolYearDaoImpl;
    private final GradeLevelDaoImpl gradeLevelDaoImpl;
    private final SectionDaoImpl sectionDaoImpl;
    
    public CreateSection(JDialog dialogSectionCrud, JTextField jtfSectionName,JComboBox jcmbGradeLevel,JComboBox jcmbAdviser,JComboBox jcmbSession){
        this.dialogSectionCrud = dialogSectionCrud;
        this.jtfSectionName = jtfSectionName;
        this.jcmbGradeLevel = jcmbGradeLevel;
        this.jcmbAdviser = jcmbAdviser;
        this.jcmbSession = jcmbSession;
        
        schoolYearDaoImpl = new SchoolYearDaoImpl();
        gradeLevelDaoImpl = new GradeLevelDaoImpl();
        sectionDaoImpl = new SectionDaoImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int choice = JOptionPane.showConfirmDialog(null, "Save Section?", "Save Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(choice == JOptionPane.YES_OPTION){
            if(addSection()){
                JOptionPane.showMessageDialog(null,"Successfully added Section!");
                dialogSectionCrud.dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Failed to add Section");
            }
        }
    }
    
    private boolean addSection() {
        boolean isAdded = false;
        Section section = new Section();
        section.setSectionName(jtfSectionName.getText().trim());
        SchoolYear schoolYear = new SchoolYear();
        schoolYear.setSchoolYearId(schoolYearDaoImpl.getCurrentSchoolYearId());

        GradeLevel gradeLevel = new GradeLevel();
        int gradeLevelNo = Integer.parseInt(jcmbGradeLevel.getSelectedItem().toString().trim());
        gradeLevel.setId(gradeLevelDaoImpl.getId(gradeLevelNo));

        section.setGradeLevel(gradeLevel);
//        section.setFacultyAdviser(getFacultyAdviser());
        section.setSectionSession(jcmbSession.getSelectedItem().toString().trim());

        isAdded = sectionDaoImpl.addSection(section);

        return isAdded;
    }
    
    private Faculty getFacultyAdviser(){
        Faculty f = new Faculty();
        return f;
    }
    
}
