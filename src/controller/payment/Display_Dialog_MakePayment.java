package controller.payment;

import daoimpl.OfficialReceiptDaoImpl;
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

    private final int currentSchoolYearId;
    private final Panel_Payment view;
    private final SchoolYearDaoImpl schoolYearDaoImpl;
    private final TuitionFeeDaoImpl tuitionFeeDaoImpl;
    private final StudentDaoImpl studentDaoImpl;
    private final OfficialReceiptDaoImpl officialReceiptDaoImpl;
    private final PaymentTermDaoImpl paymentTermDaoImpl;
    private Student student;
    private PaymentTerm paymentTerm;
    private Enrollment enrollment;
    
    public Display_Dialog_MakePayment(Panel_Payment view) {
        this.view = view;
        studentDaoImpl = new StudentDaoImpl();
        schoolYearDaoImpl = new SchoolYearDaoImpl();
        tuitionFeeDaoImpl = new TuitionFeeDaoImpl();
        officialReceiptDaoImpl = new OfficialReceiptDaoImpl();
        paymentTermDaoImpl = new PaymentTermDaoImpl();
        
        //enable MakePayment button only if form is loaded with information on keypress search of panelpayment
        //int studentNo = view.getJlblStudentNo
        //studentDaoImpl.hasTuitionRecord(studentNo,schoolYearId)
        //if hasTuitionRecord, Tuition tuition = tuitiondaoImpl.getBy(studentId, schoolYearId);
        //    displayDialog(tuition)
        //else populate Tuition fields by changing initializeX() methods to get() methods getStudent(), getEnrollment(), getPaymentTerm()
        //remove if()'s isEmpty() getSelectedIndex() > -1 etc to avoid nulls
        
        currentSchoolYearId = schoolYearDaoImpl.getCurrentSchoolYearId();
        initializePaymentTerm();
        initializeEnrollment(paymentTerm,currentSchoolYearId);
        initializeStudent(enrollment);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        displayDialog();
    }
    
    private void initializeStudent(Enrollment e) {
        if (!view.getJtfStudentNo().getText().trim().isEmpty()) {
            int studentNo = Integer.parseInt(view.getJtfStudentNo().getText().trim());
            student = studentDaoImpl.getStudentByStudentNo(studentNo);
            student.setEnrollment(e);
        }
    }
    
    private void initializeEnrollment(PaymentTerm pt, int syId) {
        if (pt != null) {
            enrollment = new Enrollment();
            String enrollmentType = pt.getPaymentTermName().trim().equalsIgnoreCase("Summer") == true ? "S" : "R";
            enrollment.setEnrollmentType(enrollmentType.trim());
            enrollment.setSchoolYearId(syId);
        }
    }

    private void initializePaymentTerm() {
        if (view.getJcmbPaymentTerm().getSelectedIndex() > -1) {
            String paymentTermName = view.getJcmbPaymentTerm().getSelectedItem().toString().trim();
            int paymentTermID = paymentTermDaoImpl.getPaymentTermIDByName(paymentTermName);
            paymentTerm = paymentTermDaoImpl.getPaymentTermByPaymentTermId(paymentTermID);
        }
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
        Tuition tuition = new Tuition();
        tuition.setStudent(student);
        tuition.setPaymentTerm(paymentTerm);
        tuition.setBalanceBreakDownFees(getBalanceBreakDownFeeList());
        tuition.setSchoolyearId(currentSchoolYearId);
        return tuition;
    }

    private void displayDialog() {
        Tuition tuition = getTuition();

        Dialog_MakePayment dialog = new Dialog_MakePayment(tuition, tuitionFeeDaoImpl, officialReceiptDaoImpl, schoolYearDaoImpl);
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
