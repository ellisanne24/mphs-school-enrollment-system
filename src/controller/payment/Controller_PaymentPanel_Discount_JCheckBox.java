
package controller.payment;

import daoimpl.PaymentTermDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.fee.Fee;
import model.paymentterm.PaymentTerm;
import service.tuition.TuitionPopulator;
import view.payment.Panel_Payment;

/**
 *
 * @author Jordan
 */
public class Controller_PaymentPanel_Discount_JCheckBox implements ActionListener{
    
    private final Panel_Payment panelPayment;

    public Controller_PaymentPanel_Discount_JCheckBox(Panel_Payment panelPayment) {
        this.panelPayment = panelPayment;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == panelPayment.getJcbDiscount()){
            if(panelPayment.getJcbDiscount().isSelected()){
                panelPayment.getJbtnSelectDiscount().setEnabled(true);
            }else{
                panelPayment.getJbtnSelectDiscount().setEnabled(false);
                initBalanceBreakDownTable(panelPayment.getFeeList(), getPaymentTerm());
            }
        }
    }
    
    private void initBalanceBreakDownTable(List<Fee> fees, PaymentTerm paymentTerm) {
        TuitionPopulator tuitionPopulator = new TuitionPopulator(fees, paymentTerm);
        DefaultTableModel tableModel = tuitionPopulator.getTuitionItemsTableModel(panelPayment.getJtblBalanceBreakDown());
        panelPayment.getJtblBalanceBreakDown().setModel(tableModel);
    }
    
    private PaymentTerm getPaymentTerm() {
        PaymentTermDaoImpl paymentTermDaoImpl = new PaymentTermDaoImpl();
        PaymentTerm paymentTerm = new PaymentTerm();
        if (panelPayment.getJcmbPaymentTerm().getSelectedIndex() > -1) {
            String paymentTermName = panelPayment.getJcmbPaymentTerm().getSelectedItem().toString().trim();
            int paymentTermID = paymentTermDaoImpl.getPaymentTermIDByName(paymentTermName);
            paymentTerm = paymentTermDaoImpl.getPaymentTermByPaymentTermId(paymentTermID);
            panelPayment.getJtfDiscount().setText("");
            panelPayment.getJcbDiscount().setSelected(false);
            panelPayment.getJbtnSelectDiscount().setEnabled(false);
        }
        return paymentTerm;
    }
    
}
