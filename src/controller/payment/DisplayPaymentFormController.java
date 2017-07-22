/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.payment;

import daoimpl.DiscountDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.PaymentTermDaoImpl;
import daoimpl.SchoolFeesDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.StudentDaoImpl;
import daoimpl.TuitionFeeDaoImpl;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.discount.Discount;
import model.particulars.Particulars;
import model.paymentterm.PaymentTerm;
import model.schoolfees.SchoolFees;
import model.schoolyear.SchoolYear;
import model.student.Student;
import model.tuitionfee.TuitionFee;
import service.TuitionFeeProcessor;
import view.payment.PaySelectedForm;
import view.payment.PaymentAndAssessmentForm;
import static view.payment.PaymentAndAssessmentForm.jtblBalanceBreakdown;

/**
 *
 * @author John Ferdinand Antonio
 */
public class DisplayPaymentFormController implements ActionListener {

    SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();
    private JTextField jtfStudentId;
    private JComboBox jcmbSchoolYearFrom;
    private JComboBox jcmbDiscount;
    private JComboBox jcmbPaymentTerm;
    private JTable jtblBalanceBreakDown;

    public DisplayPaymentFormController(JTextField jtfStudentId, JComboBox jcmbSchoolYearFrom, JTable jtblBalanceBreakDown,
            JComboBox jcmbDiscount, JComboBox jcmbPaymentTerm) {
        this.jtfStudentId = jtfStudentId;
        this.jcmbSchoolYearFrom = jcmbSchoolYearFrom;
        this.jcmbDiscount = jcmbDiscount;
        this.jtblBalanceBreakDown = jtblBalanceBreakDown;
        this.jcmbPaymentTerm = jcmbPaymentTerm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Particulars particulars = getParticulars();
        TuitionFee tuitionFee = getTuitionFee();

        PaySelectedForm psf = new PaySelectedForm(particulars, tuitionFee);
        psf.setPreferredSize(new Dimension(540, 450));
        psf.pack();
        psf.setLocationRelativeTo(null);
        psf.setVisible(true);
    }

    private Particulars getParticulars() {
        Integer studentId = Integer.parseInt(jtfStudentId.getText().trim());
        Integer schoolYearId = sydi.getId(Integer.parseInt(jcmbSchoolYearFrom.getSelectedItem().toString()));

        Particulars particulars = new Particulars();
        List<BalanceBreakDownFee> balanceBreakDownFeeList = new ArrayList<>();
        int[] selectedRows = jtblBalanceBreakdown.getSelectedRows();
        int jtblBalanceColumn = 2;
        double particularSum = 0;
        for (int i = 0; i < selectedRows.length; i++) {
            try {
                NumberFormat nf = NumberFormat.getInstance();
                double balanceAmount = nf.parse(jtblBalanceBreakdown.getValueAt(selectedRows[i], jtblBalanceColumn).toString().trim()).doubleValue();
                if (balanceAmount > 0) {
                    String description = "" + jtblBalanceBreakdown.getValueAt(selectedRows[i], 0);
                    double amount = nf.parse(jtblBalanceBreakdown.getValueAt(selectedRows[i], 1).toString()).doubleValue();
                    double balance = nf.parse(jtblBalanceBreakdown.getValueAt(selectedRows[i], 2).toString()).doubleValue();

                    BalanceBreakDownFee balanceFeeToPay = new BalanceBreakDownFee();
                    balanceFeeToPay.setDescription(description);
                    balanceFeeToPay.setAmount(amount);
                    balanceFeeToPay.setBalance(balance);
                    balanceFeeToPay.setStudentId(studentId);
                    balanceFeeToPay.setSchoolYearId(schoolYearId);

                    balanceBreakDownFeeList.add(balanceFeeToPay);
                    particularSum += balance;
                    particulars.setBalanceBreakDownFees(balanceBreakDownFeeList);
                    particulars.setBalanceSum(particularSum);
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
                Logger.getLogger(PaymentAndAssessmentForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return particulars;
    }

    private TuitionFee getTuitionFee() {
        TuitionFee tuitionFee = new TuitionFee();

        TuitionFeeDaoImpl tfdi = new TuitionFeeDaoImpl();
        DiscountDaoImpl ddi = new DiscountDaoImpl();
        StudentDaoImpl sdi = new StudentDaoImpl();
        SchoolFeesDaoImpl sfdi = new SchoolFeesDaoImpl();
        GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
        PaymentTermDaoImpl ptdi = new PaymentTermDaoImpl();
        
        Integer studentId = Integer.parseInt(jtfStudentId.getText().trim());
        Integer schoolYearId = sydi.getId(Integer.parseInt(jcmbSchoolYearFrom.getSelectedItem().toString()));

        Student student = sdi.getStudentById(studentId);
        SchoolYear schoolYear = sydi.getById(schoolYearId);
        Integer gradeLevelId = gldi.getId(student.getPresentGradeLevel());
        SchoolFees schoolFees = sfdi.get(gradeLevelId);
        Discount discount = null;
        PaymentTerm paymentTerm = new PaymentTerm();

        boolean tuitionFeeExists = tfdi.get(studentId, schoolYearId).exists();

        if (!tuitionFeeExists) {
            if (jcmbDiscount.getSelectedIndex() > -1) {
                String discountName = jcmbDiscount.getSelectedItem().toString().trim();
                int discountId = ddi.getId(discountName);
                discount = ddi.get(discountId);
            }
            paymentTerm.setName(jcmbPaymentTerm.getSelectedItem().toString().trim());
            paymentTerm.setPaymentTermId(ptdi.getId(jcmbPaymentTerm.getSelectedItem().toString().trim()));

            tuitionFee.setExists(false);
            tuitionFee.setDiscount(discount);
            tuitionFee.setPaymentTerm(paymentTerm);
            tuitionFee.setTotalPaid(0.00);
            tuitionFee.setSum(schoolFees.getSum());
            tuitionFee.setBalance(schoolFees.getSum());
            TuitionFeeProcessor tuitionFeeProcessor = new TuitionFeeProcessor(tuitionFee, schoolFees);
            System.out.println("At Pay Selected Action Performed: ");
            tuitionFee.setBalanceBreakDownFees(tuitionFeeProcessor.getBreakDown());
            tuitionFee.setSchoolYear(schoolYear);
            tuitionFee.setStudent(student);

        } else {
            TuitionFee t = tfdi.get(studentId, schoolYearId);
            t.setExists(true);
        }
        return tuitionFee;
    }

}
