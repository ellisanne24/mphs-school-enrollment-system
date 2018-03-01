package controller.payment;

import daoimpl.PaymentTermDaoImpl;
import daoimpl.SchoolYearDaoImpl;
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
import model.enrollment.Enrollment;
import model.paymentterm.PaymentTerm;
import model.student.Student;
import model.tuitionfee.Tuition;
import model.user.User;
import view.payment.Dialog_MakePayment;
import view.payment.Panel_Payment;

/**
 *
 * @author Jordan
 */
public class Display_Dialog_MakePayment implements ActionListener {

    private final int currentSchoolYearId;
    private final Panel_Payment view;
    private final SchoolYearDaoImpl schoolYearDaoImpl;
    private final TuitionFeeDaoImpl tuitionFeeDaoImpl;
    private final StudentDaoImpl studentDaoImpl;
    private final PaymentTermDaoImpl paymentTermDaoImpl;
    private Student student;
    private final User user;

    public Display_Dialog_MakePayment(Panel_Payment view, User user) {
        this.view = view;
        this.user = user;
        studentDaoImpl = new StudentDaoImpl();
        schoolYearDaoImpl = new SchoolYearDaoImpl();
        tuitionFeeDaoImpl = new TuitionFeeDaoImpl();
        paymentTermDaoImpl = new PaymentTermDaoImpl();
        currentSchoolYearId = schoolYearDaoImpl.getCurrentSchoolYearId();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String studentNo = view.getJtfStudentNo().getText().trim();
        if (inputIsValid(studentNo)) {
            initializeStudent(studentNo);
            if (studentHasTuitionRecord(student.getStudentNo())) {
                Tuition tuition = tuitionFeeDaoImpl.getBy(student.getStudentId(), currentSchoolYearId);
                tuition.setStudent(student);
                displayDialog(true, tuition);
            } else {
                Tuition newTuition = getNewTuition();
                displayDialog(false, newTuition);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input");
        }
    }

    private void initializeStudent(String studentNo) {
        student = studentDaoImpl.getStudentByStudentNo(Integer.parseInt(studentNo));
    }

    /**
     * Checks if the string is an Integer.
     *
     * @param s is any String input on JComponent such as JTextField, JLabel,
     * etc
     * @return false if it fails to parse the string to an Integer. true if the
     * String input is Integer.
     */
    private boolean inputIsValid(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if the student has already been assigned with Tuition
     * BalanceBreakDownFees in the database for a particular school year. This
     * method does the checking by studentNo instead of studentId
     *
     * @return
     */
    private boolean studentHasTuitionRecord(int studentNo) {
        return studentDaoImpl.hasTuitionRecord(studentNo, currentSchoolYearId);
    }

    /**
     * Use for students with no record yet.
     *
     * @return
     */
    private Student getStudent() {
        int studentNo = Integer.parseInt(view.getJtfStudentNo().getText().trim());
        Student s = studentDaoImpl.getStudentByStudentNo(studentNo);
        s.setEnrollment(getEnrollment());
        return s;
    }

    /**
     * Use for students with no record yet.
     *
     * @return
     */
    private Enrollment getEnrollment() {
        Enrollment enrollment = new Enrollment();
        String enrollmentType = getPaymentTerm().getPaymentTermName().trim().equalsIgnoreCase("Summer") == true ? "S" : "R";
        enrollment.setEnrollmentType(enrollmentType.trim());
        enrollment.setSchoolYearId(currentSchoolYearId);
        return enrollment;
    }

    /**
     * Use for students with no record yet.
     *
     * @return
     */
    private PaymentTerm getPaymentTerm() {
        String paymentTermName = view.getJcmbPaymentTerm().getSelectedItem().toString().trim();
        int paymentTermID = paymentTermDaoImpl.getPaymentTermIDByName(paymentTermName);
        PaymentTerm paymentTerm = paymentTermDaoImpl.getPaymentTermByPaymentTermId(paymentTermID);
        return paymentTerm;
    }

    /**
     * Use for students with no record yet
     *
     * @return
     */
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

    /**
     * Use for students with no record yet.
     *
     * @return
     */
    private Tuition getNewTuition() {
        Tuition tuition = new Tuition();
        tuition.setStudent(getStudent());
        tuition.setPaymentTerm(getPaymentTerm());
        tuition.setBalanceBreakDownFees(getBalanceBreakDownFeeList());
        tuition.setSchoolyearId(currentSchoolYearId);
        return tuition;
    }

    private void displayDialog(boolean hasTuitionRecord, Tuition tuition) {
        Dialog_MakePayment dialog = new Dialog_MakePayment(hasTuitionRecord, tuition,user);
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
