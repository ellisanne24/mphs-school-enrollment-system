
package controller.payment;

import daoimpl.PaymentTermDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.discount.Discount;
import model.fee.Fee;
import model.paymentterm.PaymentTerm;
import model.schoolyear.SchoolYear;
import model.student.Student;
import model.user.User;
import service.tuition.TuitionPopulator;
import view.payment.Dialog_AddDiscount;
import view.payment.Panel_Payment;

/**
 *
 * @author Jordan
 */
public class Controller_Dialog_AddDiscount_ApplyDiscount_JButton implements ActionListener{
    
    private final Panel_Payment panelPayment;
    private final Dialog_AddDiscount dialogAddDiscount;
    private final List<Fee> feeList;
    private final boolean hasStudentNo;
    private final PaymentTermDaoImpl paymentTermDaoImpl;
    private final Student student;
    private final SchoolYear currentSchoolYear;
    private final User user;
    
    public Controller_Dialog_AddDiscount_ApplyDiscount_JButton(
            Panel_Payment panelPayment, Dialog_AddDiscount dialogAddDiscount, 
            List<Fee> feeList, boolean hasStudentNo,Student student, SchoolYear currentSchoolyear, User user) {
        this.feeList = feeList;
        this.hasStudentNo = hasStudentNo;
        this.student = student;
        this.currentSchoolYear = currentSchoolyear;
        this.user = user;
        this.panelPayment = panelPayment;
        this.dialogAddDiscount = dialogAddDiscount;
        this.paymentTermDaoImpl = new PaymentTermDaoImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(hasStudentNo){
            
        }else{
            //first payment
            initializeBalanceBreakDownTable();
            panelPayment.getJtfDiscount().setText(""+getDiscountAmount());
            List<Discount> discounts = getDiscount();
            panelPayment.getJbtnMakePayment().addActionListener(new New_Display_Dialog_MakePayment(student, panelPayment, currentSchoolYear, user,discounts));
            
            dialogAddDiscount.dispose();
        }
        
    }
    
    private List<Discount> getDiscount(){
        List<Discount> discounts = new ArrayList<>();
        JTable t = dialogAddDiscount.getJtblAppliedDiscount();
        for(int row = 0; row < t.getRowCount(); row++){
            Discount discount = new Discount();
            discount.setDiscountID(Integer.parseInt(t.getValueAt(row,0).toString().trim()));
            discount.setDiscountName(t.getValueAt(row, 1).toString().trim());
            discount.setPercent(Integer.parseInt(t.getValueAt(row, 2).toString().trim()));
            discount.setDescription(t.getValueAt(row, 3).toString().trim());
            discount.setProvision(t.getValueAt(row, 4).toString().trim());
            discount.setCreatedBy(user);
            discounts.add(discount);
        }
        return discounts;
    }
    
    private BigDecimal getDiscountAmount(){
        BigDecimal feeSum = new BigDecimal(BigInteger.ZERO);
        for(Fee f : feeList){
            feeSum = feeSum.add(f.getAmount());
        }
        double totalPercent = 0.0;
        for(Discount discount : getDiscount()){
            totalPercent += discount.getPercent();
        }
        BigDecimal discountAmount = feeSum.multiply(BigDecimal.valueOf(totalPercent).divide(BigDecimal.valueOf(100))).setScale(2,BigDecimal.ROUND_HALF_UP);
        return discountAmount;
    }
    
    private PaymentTerm getPaymentTerm(){
        JComboBox combo = panelPayment.getJcmbPaymentTerm();
        PaymentTerm paymentTerm = new PaymentTerm();
        if(combo.getSelectedIndex() > -1){
            String paymentTermName = combo.getSelectedItem().toString().trim();
            int paymentTermID = paymentTermDaoImpl.getPaymentTermIDByName(paymentTermName);
            paymentTerm = paymentTermDaoImpl.getPaymentTermByPaymentTermId(paymentTermID);
        }
        return paymentTerm;
    }
    
    private void initializeBalanceBreakDownTable(){
        List<Discount> discounts = getDiscount();
        PaymentTerm paymentTerm = getPaymentTerm();
        
        TuitionPopulator tuitionPopulator = new TuitionPopulator(feeList, paymentTerm,discounts);
        DefaultTableModel tableModel = tuitionPopulator.getTuitionItemsTableModel(panelPayment.getJtblBalanceBreakDown());
        panelPayment.getJtblBalanceBreakDown().setModel(tableModel);
    }
    
}
