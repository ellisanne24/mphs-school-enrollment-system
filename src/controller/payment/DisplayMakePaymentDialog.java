package controller.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.fee.Fee;
import model.student.Student;
import model.tuitionfee.TuitionFee;
import view.payment.Dialog_MakePayment;

/**
 *
 * @author Jordan
 */
public class DisplayMakePaymentDialog implements ActionListener {

    private final JTable jtblTuitionItems;
    private final Student student;
    private final List<Fee> fees;

    public DisplayMakePaymentDialog(JTable jtblTuitionItems, Student student, List<Fee> fees) {
        this.jtblTuitionItems = jtblTuitionItems;
        this.student = student;
        this.fees = fees;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        displayDialog();
    }

    private void displayDialog() {
        TuitionFee tuitionFee = new TuitionFee();
        tuitionFee.setBalanceBreakDownFees(getBalanceBreakDownFeeList());
        tuitionFee.setDownpayment(getDownPayment());
        tuitionFee.setOthers(getOthers());

        Dialog_MakePayment dialog = new Dialog_MakePayment(null, true, tuitionFee);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private List<BalanceBreakDownFee> getBalanceBreakDownFeeList() {
        List<BalanceBreakDownFee> balanceBreakDownFeeList = new ArrayList<>();
        for (int i = 0; i < jtblTuitionItems.getRowCount(); i++) {
            BalanceBreakDownFee bbf = new BalanceBreakDownFee();
            String name = jtblTuitionItems.getValueAt(i, 0).toString().trim();
            System.out.println("Name: "+name);
                bbf.setName(name);
                balanceBreakDownFeeList.add(bbf);
        }
        return balanceBreakDownFeeList;
    }

    private Fee getDownPayment() {
        BigDecimal dpAmount = new BigDecimal(BigInteger.ZERO);
        Fee fee = new Fee();
        fee.setAmount(dpAmount);
        return fee;
    }

    private List<Fee> getOthers() {
        List<Fee> others = new ArrayList<>();
        return others;
    }

}
