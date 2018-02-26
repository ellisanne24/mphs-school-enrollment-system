
package controller.enrollment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import model.schoolyear.SchoolYear;
import view.section.Dialog_SectionAssignment;

/**
 *
 * @author Jordan
 */
public class DisplayDialogSectionAssignment implements ActionListener{

    private final SchoolYear currentSchoolYear;
    
    public DisplayDialogSectionAssignment(SchoolYear currentSchoolYear) {
        this.currentSchoolYear = currentSchoolYear;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Dialog_SectionAssignment view = new Dialog_SectionAssignment(null, true,currentSchoolYear);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.pack();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
}
