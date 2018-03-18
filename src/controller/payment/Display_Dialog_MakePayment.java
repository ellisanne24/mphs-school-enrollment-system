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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.discount.Discount;
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
public class Display_Dialog_MakePayment implements ActionListener{
    
    private boolean hasStudentNo;
    private Student student;
    private List<Discount> discounts;
    private final Panel_Payment view;
    private final SchoolYear currentSchoolYear;
    private final User user;
    private final PaymentTermDaoImpl paymentTermDaoImpl;
    private final StudentDaoImpl studentDaoImpl;
    private final TuitionFeeDaoImpl tuitionFeeDaoImpl;

    public Display_Dialog_MakePayment(Panel_Payment view) {
        this.view = view;
        this.currentSchoolYear = view.getCurrentSchoolYear();
        this.user = view.getUser();
        this.paymentTermDaoImpl = new PaymentTermDaoImpl();
        this.studentDaoImpl = new StudentDaoImpl();
        this.tuitionFeeDaoImpl = new TuitionFeeDaoImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(hasStudentNo){
            int studentId = student.getStudentId();
            int schoolYearId = currentSchoolYear.getSchoolYearId();
            Tuition tuition = tuitionFeeDaoImpl.getBy(studentId, schoolYearId);
            tuition.setStudent(student);
            displayDialog(true, tuition);
        }else{
            student = view.getStudent();
            discounts = view.getDiscounts();
            Tuition newTuition = createTuitionFor(student);
            displayDialog(false, newTuition);
        }
    }

    private Tuition createTuitionFor(Student s) {
        s.setEnrollment(enrollment());
        Tuition tuition = new Tuition();
        tuition.setStudent(s);
        tuition.setPaymentTerm(paymentTerm());
        tuition.setBalanceBreakDownFees(balanceBreakDownFees());
        tuition.setSchoolyearId(currentSchoolYear.getSchoolYearId());
        tuition.setDiscounts(discounts);
        return tuition;
    }
    
    
    private Enrollment enrollment() {
        Enrollment enrollment = new Enrollment();
        String enrollmentType = paymentTerm().getPaymentTermName().trim().equalsIgnoreCase("Summer") == true ? "S" : "R";
        enrollment.setEnrollmentType(enrollmentType.trim());
        enrollment.setSchoolYearId(currentSchoolYear.getSchoolYearId());
        return enrollment;
    }
    
    
    private PaymentTerm paymentTerm() {
        String paymentTermName = view.getJcmbPaymentTerm().getSelectedItem().toString().trim();
        int paymentTermID = paymentTermDaoImpl.getPaymentTermIDByName(paymentTermName);
        PaymentTerm paymentTerm = paymentTermDaoImpl.getPaymentTermByPaymentTermId(paymentTermID);
        return paymentTerm;
    }
    
    private List<BalanceBreakDownFee> balanceBreakDownFees() {
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
