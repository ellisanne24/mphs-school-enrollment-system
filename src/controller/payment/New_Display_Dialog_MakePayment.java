package controller.payment;

import daoimpl.PaymentTermDaoImpl;
import daoimpl.StudentDaoImpl;
import daoimpl.TuitionFeeDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JTable;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.enrollment.Enrollment;
import model.paymentterm.PaymentTerm;
import model.schoolyear.SchoolYear;
import model.student.Student;
import model.tuitionfee.Tuition;
import model.user.User;
import view.payment.Dialog_MakePayment;
import view.payment.Panel_Payment;

/**
 *
 * @author Jordan
 */
public class New_Display_Dialog_MakePayment implements ActionListener{
    
    private final boolean hasStudentNo;
    private final Student student;
    private final Panel_Payment view;
    private final SchoolYear currentSchoolYear;
    private final User user;
    private final PaymentTermDaoImpl paymentTermDaoImpl;
    private final StudentDaoImpl studentDaoImpl;
    private final TuitionFeeDaoImpl tuitionFeeDaoImpl;

    public New_Display_Dialog_MakePayment(boolean hasStudentNo, Student student, Panel_Payment view, SchoolYear currentSchoolYear,User user) {
        this.hasStudentNo = hasStudentNo;
        this.student = student;
        this.view = view;
        this.currentSchoolYear = currentSchoolYear;
        this.user = user;
        this.paymentTermDaoImpl = new PaymentTermDaoImpl();
        this.studentDaoImpl = new StudentDaoImpl();
        this.tuitionFeeDaoImpl = new TuitionFeeDaoImpl();
    }
    
    /**
     * Use this constructor only for student applicants who has not been given a student number
     * In other words, use only for student applicants who are not officially considered student of school.
     * @param student
     * @param view
     * @param currentSchoolYear 
     */
    public New_Display_Dialog_MakePayment(Student student, Panel_Payment view, SchoolYear currentSchoolYear, User user) {
        this.hasStudentNo = false;
        this.student = student;
        this.view = view;
        this.currentSchoolYear = currentSchoolYear;
        this.user = user;
        this.paymentTermDaoImpl = new PaymentTermDaoImpl();
        this.studentDaoImpl = new StudentDaoImpl();
        this.tuitionFeeDaoImpl = new TuitionFeeDaoImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(hasStudentNo){
            Tuition tuition = tuitionFeeDaoImpl.getBy(student.getStudentId(), currentSchoolYear.getSchoolYearId());
            tuition.setStudent(student);
            displayDialog(true, tuition);
        }else{
            Tuition newTuition = createNewTuition();
            displayDialog(false, newTuition);
        }
    }

    private Tuition createNewTuition() {
        student.setEnrollment(getEnrollment());
        Tuition tuition = new Tuition();
        tuition.setStudent(student);
        tuition.setPaymentTerm(getPaymentTerm());
        tuition.setBalanceBreakDownFees(getBalanceBreakDownFeeList());
        tuition.setSchoolyearId(currentSchoolYear.getSchoolYearId());
        return tuition;
    }
    
    
    private Enrollment getEnrollment() {
        Enrollment enrollment = new Enrollment();
        String enrollmentType = getPaymentTerm().getPaymentTermName().trim().equalsIgnoreCase("Summer") == true ? "S" : "R";
        enrollment.setEnrollmentType(enrollmentType.trim());
        enrollment.setSchoolYearId(currentSchoolYear.getSchoolYearId());
        return enrollment;
    }
    
    
    private PaymentTerm getPaymentTerm() {
        String paymentTermName = view.getJcmbPaymentTerm().getSelectedItem().toString().trim();
        int paymentTermID = paymentTermDaoImpl.getPaymentTermIDByName(paymentTermName);
        PaymentTerm paymentTerm = paymentTermDaoImpl.getPaymentTermByPaymentTermId(paymentTermID);
        return paymentTerm;
    }
    
    private List<BalanceBreakDownFee> getBalanceBreakDownFeeList() {
        List<BalanceBreakDownFee> bbFeeList = new ArrayList<>();
        JTable t = view.getJtblBalanceBreakDown();
        for (int i = 0; i < t.getRowCount(); i++) {
            try {
                BalanceBreakDownFee bbFee = new BalanceBreakDownFee();
                String name = t.getValueAt(i, 0).toString().trim();
                BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(t.getValueAt(i, 1).toString().trim())).setScale(2, BigDecimal.ROUND_HALF_UP);
                String date = (t.getValueAt(i, 3).toString().trim());
                String category = (t.getValueAt(i, 5).toString().trim());
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date deadline = format.parse(date);
                bbFee.setDeadline(deadline);
                bbFee.setIsPaid(false);
                bbFee.setAmount(amount);
                bbFee.setName(name);
                bbFee.setCategory(category);
                bbFeeList.add(bbFee);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        return bbFeeList;
    }
    
    
    private void displayDialog(boolean hasTuitionRecord, Tuition tuition) {
        Dialog_MakePayment dialog = new Dialog_MakePayment(hasTuitionRecord, tuition, user);
        if (dialog.isShowing()) {
            dialog.dispose();
        } else {
            dialog.setModal(true);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        }
    }
}
