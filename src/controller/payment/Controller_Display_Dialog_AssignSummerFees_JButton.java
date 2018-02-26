
package controller.payment;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.schoolyear.SchoolYear;
import model.student.Student;
import view.payment.Dialog_AddSummerFee;
import view.payment.Panel_Payment;

/**
 *
 * @author Jordan
 */
public class Controller_Display_Dialog_AssignSummerFees_JButton implements ActionListener{

    private final Panel_Payment view;
    private final Student student;
    private final SchoolYear currentSchoolYear;
    
    public Controller_Display_Dialog_AssignSummerFees_JButton(Panel_Payment view,Student student, SchoolYear currentSchoolYear) {
        this.view = view;
        this.student = student;
        this.currentSchoolYear = currentSchoolYear;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getJbtnAssignSummerFee()){
            displayAssignSummerFeeDialog();
        }
    }
    
    private void displayAssignSummerFeeDialog(){
        Dialog_AddSummerFee dialog = new Dialog_AddSummerFee(null, true,student, currentSchoolYear);
        dialog.setPreferredSize(new Dimension(600,450));
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
}
