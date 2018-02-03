package controller.payment;

import daoimpl.OrNoDaoImpl;
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
import javax.swing.JTable;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.enrollment.Enrollment;
import model.paymentterm.PaymentTerm;
import model.student.Student;
import model.tuitionfee.Tuition;
import view.payment.Dialog_MakePayment;
import view.payment.Panel_Payment;

/**
 *
 * @author Jordan
 */
public class Display_Dialog_MakePayment implements ActionListener {

    private final Panel_Payment view;

    public Display_Dialog_MakePayment(Panel_Payment view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        displayDialog();
    }
    
    private Enrollment getEnrollment() {
        SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
        Enrollment e = new Enrollment();
        String enrollmentType = getPaymentTerm().getPaymentTermName().trim().equalsIgnoreCase("Summer") == true ? "S" : "R";
        e.setEnrollmentType(enrollmentType.trim());
        e.setSchoolYearId(schoolYearDaoImpl.getCurrentSchoolYearId());
        return e;
    }

    private Student getStudent() {
        StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
        int studentNo = Integer.parseInt(view.getJtfStudentNo().getText().trim());
        Student student = studentDaoImpl.getStudentByStudentNo(studentNo);
        student.setEnrollment(getEnrollment());
        return student;
    }

    private PaymentTerm getPaymentTerm() {
        PaymentTermDaoImpl paymentTermDaoImpl = new PaymentTermDaoImpl();
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

    private Tuition getTuition() {
        SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
        Tuition tuition = new Tuition();
        tuition.setStudent(getStudent());
        tuition.setPaymentTerm(getPaymentTerm());
        tuition.setBalanceBreakDownFees(getBalanceBreakDownFeeList());
        tuition.setSchoolyearId(schoolYearDaoImpl.getCurrentSchoolYearId());
        return tuition;
    }

    private void displayDialog() {
        TuitionFeeDaoImpl tuitionFeeDaoImpl = new TuitionFeeDaoImpl();
        OrNoDaoImpl orNoDaoImpl = new OrNoDaoImpl();
        SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
        Tuition tuition = getTuition();

        Dialog_MakePayment dialog = new Dialog_MakePayment(tuition, tuitionFeeDaoImpl, orNoDaoImpl, schoolYearDaoImpl);
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
