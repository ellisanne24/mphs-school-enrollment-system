package controller.payment;

import component_model_loader.BalanceBreakDownML;
import daoimpl.PaymentTermDaoImpl;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.discount.Discount;
import model.paymentterm.PaymentTerm;
import model.schoolfees.SchoolFees;
import model.schoolyear.SchoolYear;
import model.student.Student;
import model.tuitionfee.TuitionFee;
import service.TuitionFeeProcessor;

/**
 *
 * @author John Ferdinand Antonio
 */
public class PaymentTermChangeController implements ItemListener {

    private final BalanceBreakDownML balanceBreakDownML = new BalanceBreakDownML();
    private DecimalFormat df;

    private final Student student;
    private final SchoolFees schoolFees;
    private final SchoolYear schoolYear;
    private final TuitionFee tuitionFee;
    private final JComboBox jcmbPaymentTerm;
    private final JTable jtblBalanceBreakDown;

    public PaymentTermChangeController(
            Student student, SchoolFees schoolFees, SchoolYear schoolYear, TuitionFee tuitionFee,
            JComboBox jcmbPaymentTerm, JTable jtblBalanceBreakDown) {
        this.student = student;
        this.schoolFees = schoolFees;
        this.schoolYear = schoolYear;
        this.tuitionFee = tuitionFee;
        this.jcmbPaymentTerm = jcmbPaymentTerm;
        this.jtblBalanceBreakDown = jtblBalanceBreakDown;

        initializeFormatters();
    }

    private void initializeFormatters() {
//        decimalFormatter = new DecimalFormat("#0.00");
        df = new DecimalFormat("#,#00.00");
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        setForm();
    }

    private void setForm() {
        if (tuitionFee.exists()) {

        } else {
            TuitionFee t = createFreshTuitionFee();

        }
    }

    private TuitionFee createFreshTuitionFee() {
        PaymentTermDaoImpl paymentTermDaoImpl = new PaymentTermDaoImpl();
        try {
            String paymentTermName = jcmbPaymentTerm.getSelectedItem().toString().trim();
            int paymentTermId = paymentTermDaoImpl.getId(paymentTermName);
            PaymentTerm paymentTerm = paymentTermDaoImpl.getById(paymentTermId);

            Discount discount = new Discount();
            discount.setDiscountName(null);
            discount.setPercentOfDiscount(0);

            double totalPaid = 0.00;
            double totalFees = schoolFees.getSum();
            double remainingBalance = schoolFees.getSum();

            TuitionFee tuition = new TuitionFee();
            tuition.setExists(false);
            tuition.setTotalFees(totalFees);
            tuition.setTotalPaid(totalPaid);
            tuition.setBalance(remainingBalance);
            tuition.setPaymentTerm(paymentTerm);
            tuition.setDiscount(discount);
            TuitionFeeProcessor tuitionFeeProcessor = new TuitionFeeProcessor(tuition, schoolFees, schoolYear);
            tuition.setBalanceBreakDownFees(tuitionFeeProcessor.getBreakDown());

            DefaultTableModel tableModel = (DefaultTableModel) jtblBalanceBreakDown.getModel();
            List<BalanceBreakDownFee> balanceBreakDownFee = tuition.getBalanceBreakDownFees();
            tableModel.setRowCount(0);
            for (BalanceBreakDownFee b : balanceBreakDownFee) {
                Object[] rowData = {
                    b.getDescription(),
                    b.getAmount(),
                    b.getBalance(),
                    b.getDeadline()
                };
                tableModel.addRow(rowData);
            }
            jtblBalanceBreakDown.setModel(tableModel);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return tuitionFee;
    }

}
