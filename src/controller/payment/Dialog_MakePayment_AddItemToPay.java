
package controller.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.tuitionfee.Tuition;
import view.payment.Dialog_MakePayment;

/**
 *
 * @author Jordan
 */
public class Dialog_MakePayment_AddItemToPay implements ActionListener{

    private final Dialog_MakePayment view;
    private final Tuition tuition;
    
    public Dialog_MakePayment_AddItemToPay(Dialog_MakePayment view, Tuition tuition){
        this.view = view;
        this.tuition = tuition;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        add();
    }
    
    private void add() {
        List<BalanceBreakDownFee> bbFeeListToAdd = new ArrayList<>();
        if (view.getJcbDownPayment().isSelected()) {
            for (BalanceBreakDownFee b : tuition.getBalanceBreakDownFees()) {
                if (b.getCategory().trim().equalsIgnoreCase("Downpayment")) {
                    bbFeeListToAdd.add(b);
                }
            }
        }
        if (view.getJcbBalance().isSelected()) {
            String selectedBalanceItem = view.getJcmbBalance().getSelectedItem().toString().trim();
            if (!selectedBalanceItem.equalsIgnoreCase("Select") || !selectedBalanceItem.equalsIgnoreCase("All")) {
                for (BalanceBreakDownFee b : tuition.getBalanceBreakDownFees()) {
                    if (b.getCategory().trim().equalsIgnoreCase("Balance")) {
                        bbFeeListToAdd.add(b);
                    }
                }
            }
        }

        if (view.getJcbOthers().isSelected()) {
            String selectedOtherItem = view.getJcmbOthers().getSelectedItem().toString().trim();
            if (!selectedOtherItem.equalsIgnoreCase("Select") || !selectedOtherItem.equalsIgnoreCase("All")) {
                for (BalanceBreakDownFee b : tuition.getBalanceBreakDownFees()) {
                    if (b.getCategory().trim().equalsIgnoreCase("Other")) {
                        bbFeeListToAdd.add(b);
                    }
                }
            }
        }
        addRowToTable(bbFeeListToAdd);
    }
    
    private void addRowToTable(List<BalanceBreakDownFee> bbFeeList) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getJtblPaymentBreakDown().getModel();
        for (BalanceBreakDownFee b : bbFeeList) {
            if (!isDuplicate(b.getName().trim())) {
                Object[] rowData = {b.getName(), b.getAmount(), b.getDeadline(), b.getCategory()};
                tableModel.addRow(rowData);
            }
        }
    }
    
    private boolean isDuplicate(String name) {
        boolean isDuplicate = false;
        DefaultTableModel tableModel = (DefaultTableModel) view.getJtblPaymentBreakDown().getModel();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (name.trim().equalsIgnoreCase(tableModel.getValueAt(i, 0).toString().trim())) {
                isDuplicate = true;
                break;
            }
        }
        return isDuplicate;
    }
    
}
