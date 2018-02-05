
package controller.enrollment;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import view.section.Dialog_SectionAssignment;

/**
 *
 * @author Jordan
 */
public class DisplayDialogSectionAssignment implements ActionListener{


    
    @Override
    public void actionPerformed(ActionEvent e) {
        Dialog_SectionAssignment view = new Dialog_SectionAssignment(null, true);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.pack();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
}
