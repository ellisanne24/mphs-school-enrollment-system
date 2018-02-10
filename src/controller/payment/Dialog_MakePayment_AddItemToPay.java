
package controller.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.tuitionfee.Tuition;
import view.payment.Dialog_MakePayment;

/**
 *
 * @author Jordan
 */
public class Dialog_MakePayment_AddItemToPay implements ActionListener{

    private final boolean hasTuitionRecord;
    private final Dialog_MakePayment view;
    private final Tuition tuition;
    
    public Dialog_MakePayment_AddItemToPay(boolean hasTuitionRecord,Dialog_MakePayment view, Tuition tuition){
        this.view = view;
        this.hasTuitionRecord = hasTuitionRecord;
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
                if (b.getCategory().trim().equalsIgnoreCase("Downpayment")
                        || b.getCategory().trim().equalsIgnoreCase("D")) {
                    if (!b.isFullyPaid()) {
                        bbFeeListToAdd.add(b);
                    } else {
                        JOptionPane.showMessageDialog(null, b.getName() + " is already paid.");
                    }
                }
            }
        }
        if (view.getJcbBalance().isSelected()) {
            String selectedBalanceItem = view.getJcmbBalance().getSelectedItem().toString().trim();
            if (!selectedBalanceItem.equalsIgnoreCase("Select") || !selectedBalanceItem.equalsIgnoreCase("All")) {
                for (BalanceBreakDownFee b : tuition.getBalanceBreakDownFees()) {
                    if (b.getCategory().trim().equalsIgnoreCase("Balance") || b.getCategory().trim().equalsIgnoreCase("B")) {
                        if (!b.isFullyPaid() && b.getName().trim().equalsIgnoreCase(selectedBalanceItem)) {
                            bbFeeListToAdd.add(b);
                        }else if(b.isFullyPaid() && b.getName().trim().equalsIgnoreCase(selectedBalanceItem)){
                            JOptionPane.showMessageDialog(null,b.getName()+" is already paid.");
                        }
                    }
                }
            }
        }

        if (view.getJcbOthers().isSelected()) {
            String selectedOtherItem = view.getJcmbOthers().getSelectedItem().toString().trim();
            if (!selectedOtherItem.equalsIgnoreCase("Select") || !selectedOtherItem.equalsIgnoreCase("All")) {
                for (BalanceBreakDownFee b : tuition.getBalanceBreakDownFees()) {
                    if (b.getCategory().trim().equalsIgnoreCase("Other") || b.getCategory().trim().equalsIgnoreCase("O")) {
                        if (!b.isFullyPaid() && b.getName().trim().equalsIgnoreCase(selectedOtherItem)) {
                            bbFeeListToAdd.add(b);
                        }else if(b.isFullyPaid() && b.getName().trim().equalsIgnoreCase(selectedOtherItem)){
                            JOptionPane.showMessageDialog(null,b.getName()+" is already paid.");
                        }
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
                Object[] rowData = {b.getName(),hasTuitionRecord==true? b.getBalance() : b.getAmount(), b.getDeadline(), b.getCategory()};
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
