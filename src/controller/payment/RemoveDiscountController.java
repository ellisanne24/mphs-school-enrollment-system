
package controller.payment;

import daoimpl.PaymentTermDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.discount.Discount;
import model.paymentterm.PaymentTerm;
import model.schoolfees.SchoolFees;
import model.schoolyear.SchoolYear;
import model.student.Student;
import model.tuitionfee.TuitionFee;
import service.TuitionFeeProcessor;
import static view.payment.PaymentAndAssessmentForm.jtblBalanceBreakdown;

/**
 *
 * @author John Ferdinand Antonio
 */
public class RemoveDiscountController implements ActionListener{

    
    private DecimalFormat df ;
    private final JTextField jtfDiscountPercentage;
    private final JTextField jtfTotalFeesWithDiscount;
    private final JTextField jtfRemainingBalance;
    private final JTextField jtfDiscounts;
    private final Student student;
    private final SchoolFees schoolFees;
    private final SchoolYear schoolYear;
    private final TuitionFee tuitionFee;
    private final JComboBox jcmbPaymentTerm;
    private final JComboBox jcmbDiscount;
    
    public RemoveDiscountController(
            JTextField jtfDiscountPercentage,
            JTextField jtfTotalFeesWithDiscount, JTextField jtfRemainingBalance, 
            JTextField jtfDiscounts,JComboBox jcmbPaymentTerm,JComboBox jcmbDiscount,
            Student student, SchoolFees schoolFees, SchoolYear schoolYear, TuitionFee tuitionFee) {
        this.jtfDiscountPercentage = jtfDiscountPercentage;
        this.jtfTotalFeesWithDiscount = jtfTotalFeesWithDiscount;
        this.jtfRemainingBalance = jtfRemainingBalance;
        this.jtfDiscounts = jtfDiscounts;
        this.student = student;
        this.schoolFees = schoolFees;
        this.schoolYear = schoolYear;
        this.tuitionFee = tuitionFee;
        this.jcmbPaymentTerm = jcmbPaymentTerm;
        this.jcmbDiscount = jcmbDiscount;
        initializeFormatters();
    }
    
    private void initializeFormatters() {
//        decimalFormatter = new DecimalFormat("#0.00");
        df = new DecimalFormat("#,#00.00");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int choice = JOptionPane.showConfirmDialog(null, "Remove Discount?","Remove Discount Confirmation",JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION){
            removeDiscount();
        }
    }
    
    private void removeDiscount(){
        setForm();
    }
    
    private void setForm(){
        double totalFeesWithDiscount = 0;
        String totalFees = df.format(tuitionFee.getTotalFees());
        String totalPaid = df.format(tuitionFee.getTotalPaid());
        String balance = df.format(tuitionFee.getBalance());
        String paymentTerm = tuitionFee.getPaymentTerm().getName();
        String discountName = tuitionFee.getDiscount().getDiscountName();
        String discountPercentage = tuitionFee.hasDiscount()
                ? tuitionFee.getDiscount().getPercentOfDiscount() + "" : "";
        String discountAmount = tuitionFee.hasDiscount()
                ? tuitionFee.getDiscount().getAmount() + "" : "";
        
        if(tuitionFee.exists()){
            
        } else {
            TuitionFee t = createFreshTuitionFee();
            totalFees = df.format(t.getTotalFees());
            totalFeesWithDiscount = 0;
            totalPaid = df.format(t.getTotalPaid());
            balance = df.format(t.getBalance());
            paymentTerm = t.getPaymentTerm().getName().trim();
            discountName = t.getDiscount().getDiscountName();
            discountPercentage = t.getDiscount().getPercentOfDiscount() + "";
            discountAmount = df.format(t.getDiscount().getAmount());

            List<BalanceBreakDownFee> balanceBreakDownFee = t.getBalanceBreakDownFees();
            DefaultTableModel tableModel = (DefaultTableModel) jtblBalanceBreakdown.getModel();
            tableModel.setRowCount(0);
            for (BalanceBreakDownFee b : balanceBreakDownFee) {
                Object[] rowData = {
                    b.getDescription(),
                    df.format(b.getAmount()),
                    df.format(b.getBalance()),
                    b.getDeadline()
                };
                tableModel.addRow(rowData);
            }
            jtblBalanceBreakdown.setModel(tableModel);
        }
        jtfDiscountPercentage.setText(discountPercentage);
        jcmbDiscount.setSelectedItem(discountName);
        jtfDiscounts.setText(discountAmount);
        jtfRemainingBalance.setText(balance);
        jtfTotalFeesWithDiscount.setText(df.format(totalFeesWithDiscount));
    }
    
    private TuitionFee createFreshTuitionFee() {
        TuitionFee t = new TuitionFee();

        double totalPaid = 0.00;
        double totalFees = schoolFees.getSum();
        double remainingBalance = schoolFees.getSum();
        PaymentTermDaoImpl ptdi = new PaymentTermDaoImpl();
        int paymentTermId = ptdi.getId(jcmbPaymentTerm.getSelectedItem().toString().trim());
        PaymentTerm paymentTerm = ptdi.getById(paymentTermId);
        
        Discount discount = new Discount();
        discount.setDiscountName(null);
        discount.setPercentOfDiscount(0);
        discount.setAmount(0);

        t.setExists(false);
        t.setTotalFees(totalFees);
        t.setTotalPaid(totalPaid);
        t.setBalance(remainingBalance);
        t.setPaymentTerm(paymentTerm);
        t.setDiscount(discount);
        TuitionFeeProcessor tuitionFeeProcessor = new TuitionFeeProcessor(t, schoolFees, schoolYear);
        t.setBalanceBreakDownFees(tuitionFeeProcessor.getBreakDown());

        return t;
    }
    
}
