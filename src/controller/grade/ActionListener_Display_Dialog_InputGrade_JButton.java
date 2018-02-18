
package controller.grade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import model.user.User;
import view.grades.View_Dialog_InputGrade;

/**
 *
 * @author Jordan
 */
public class ActionListener_Display_Dialog_InputGrade_JButton implements ActionListener{
    
    private final User user;

    public ActionListener_Display_Dialog_InputGrade_JButton(User user) {
        this.user = user;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        View_Dialog_InputGrade dialog_OverrideGrading = new View_Dialog_InputGrade(null, true, user);
        dialog_OverrideGrading.pack();
        dialog_OverrideGrading.setLocationRelativeTo(null);
        dialog_OverrideGrading.setVisible(true);
    }

    
}
