
package controller.grade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import model.user.User;
import view.grades.View_Dialog_OverrideGrading;

/**
 *
 * @author Jordan
 */
public class ActionListener_Display_Dialog_OverrideGrading_JButton implements ActionListener{
    
    private final User user;

    public ActionListener_Display_Dialog_OverrideGrading_JButton(User user) {
        this.user = user;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        View_Dialog_OverrideGrading dialog_OverrideGrading = new View_Dialog_OverrideGrading(null, true, user);
        dialog_OverrideGrading.pack();
        dialog_OverrideGrading.setLocationRelativeTo(null);
        dialog_OverrideGrading.setVisible(true);
    }

    
}
