
package controller.grade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.schoolyear.SchoolYear;
import model.user.User;
import view.grades.View_Dialog_InputGrade;

/**
 *
 * @author Jordan
 */
public class ActionListener_Display_Dialog_InputGrade_JButton implements ActionListener{
    
    private final User user;
    private final SchoolYear currentSchoolYear;
    
    public ActionListener_Display_Dialog_InputGrade_JButton(User user, SchoolYear currentSchoolYear) {
        this.user = user;
        this.currentSchoolYear = currentSchoolYear;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        View_Dialog_InputGrade dialog_OverrideGrading = new View_Dialog_InputGrade(null, true, user, currentSchoolYear);
        dialog_OverrideGrading.pack();
        dialog_OverrideGrading.setLocationRelativeTo(null);
        dialog_OverrideGrading.setVisible(true);
    }

    
}
