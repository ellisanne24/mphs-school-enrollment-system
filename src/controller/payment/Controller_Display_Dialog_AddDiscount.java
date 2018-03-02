
package controller.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import model.fee.Fee;
import model.schoolyear.SchoolYear;
import model.student.Student;
import model.user.User;
import view.payment.Dialog_AddDiscount;
import view.payment.Panel_Payment;

/**
 *
 * @author Jordan
 */
public class Controller_Display_Dialog_AddDiscount implements ActionListener{
    
    private final Panel_Payment view;
    private final List<Fee> feeList;
    private final boolean hasStudentNo;
    private final Student student;
    private final SchoolYear currentSchoolYear;
    private final User user;

    public Controller_Display_Dialog_AddDiscount(
            Panel_Payment view, List<Fee> feeList,boolean hasStudentNo, Student student,SchoolYear currentSchoolYear,User user) {
        this.view = view;
        this.feeList = feeList;
        this.hasStudentNo = hasStudentNo;
        this.student = student;
        this.currentSchoolYear = currentSchoolYear;
        this.user = user;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getJbtnAddDiscount()){
            Dialog_AddDiscount dialog = new Dialog_AddDiscount(null, true, view,feeList,hasStudentNo,student,currentSchoolYear,user);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }
    }
    
}
