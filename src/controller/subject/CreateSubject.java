package controller.subject;

import daoimpl.GradeLevelDaoImpl;
import daoimpl.SubjectDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.gradelevel.GradeLevel;
import model.subject.Subject;
import utility.form.FormValidator;

/**
 *
 * @author Jordan
 */
public class CreateSubject implements ActionListener, FormValidator{

    private final JDialog jdlgSubjectCrud;
    private final JTextField jtfSubjectCode;
    private final JTextField jtfSubjectName;
    private final JTextArea jtaDescription;
    private final JComboBox jcmbGradeLevel;
    
    private GradeLevelDaoImpl gradeLevelDaoImpl;
    private SubjectDaoImpl subjectDaoImpl;
    
    public CreateSubject(JDialog jdlgSubjectCrud, JTextField jtfSubjectCode,JTextField jtfSubjectName,JTextArea jtaDescription,JComboBox jcmbGradeLevel){
        this.jdlgSubjectCrud = jdlgSubjectCrud;
        this.jtfSubjectCode = jtfSubjectCode;
        this.jtfSubjectName = jtfSubjectName;
        this.jtaDescription = jtaDescription;
        this.jcmbGradeLevel = jcmbGradeLevel;
        gradeLevelDaoImpl = new GradeLevelDaoImpl();
        subjectDaoImpl = new SubjectDaoImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (formIsValid()) {
            int choice = JOptionPane.showConfirmDialog(null, "Add Subject?", "Add", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                if (addSubject()) {
                    JOptionPane.showMessageDialog(null, "Successfully added subject.");
                    jdlgSubjectCrud.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add subject.");
                }
            }
        } else {

        }
    }

    private boolean addSubject(){
        boolean isAdded = false;
        
        int selectedGradeLevel = Integer.parseInt(jcmbGradeLevel.getSelectedItem().toString());
        int gradeLevelId = gradeLevelDaoImpl.getId(selectedGradeLevel);
        
        GradeLevel gradeLevel = new GradeLevel();
        gradeLevel.setId(gradeLevelId);
        
        Subject subject = new Subject();
        subject.setSubjectCode(jtfSubjectCode.getText().trim());
        subject.setSubjectTitle(jtfSubjectName.getText().trim());
        subject.setSubjectDescription(jtaDescription.getText().trim());
        subject.setGradeLevel(gradeLevel);
        
        isAdded = subjectDaoImpl.createSubject(subject);
        
        return isAdded;
    }
    
    @Override
    public boolean formIsValid() {
        return true;
    }
    
    
    
}
