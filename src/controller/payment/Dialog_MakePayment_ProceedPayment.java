package controller.payment;

import daoimpl.EnrollmentDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.TuitionFeeDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.particulars.Particular;
import model.payment.Payment;
import model.tuitionfee.Tuition;
import view.payment.Dialog_MakePayment;

/**
 *
 * @author Jordan
 */
public class Dialog_MakePayment_ProceedPayment implements ActionListener {

    private final boolean hasTuitionRecord;
    private final Dialog_MakePayment view;
    private final Tuition tuition;
    private final TuitionFeeDaoImpl tuitionFeeDaoImpl;

    public Dialog_MakePayment_ProceedPayment(boolean hasTuitionRecord,Dialog_MakePayment view, Tuition tuition, TuitionFeeDaoImpl tuitionFeeDaoImpl) {
        this.hasTuitionRecord = hasTuitionRecord;
        this.view = view;
        this.tuition = tuition;
        this.tuitionFeeDaoImpl = tuitionFeeDaoImpl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (proceedPayment()) {
            JOptionPane.showMessageDialog(null, "Successfully processed.");
            view.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Encountered problem processing request. Please contact your support.");
        }
    }

    private boolean proceedPayment() {
        boolean isSuccessful = false;
        int choice = JOptionPane.showConfirmDialog(null, "Proceed with payment?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            Payment payment = getPayment();
            tuition.setPayment(payment);
            
            if (!hasTuitionRecord) {
                boolean isAdded = tuitionFeeDaoImpl.add(tuition);
                boolean isPaid = tuitionFeeDaoImpl.pay(tuition);
                if (isAdded && isPaid) {
                    SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
                    EnrollmentDaoImpl enrollmentDaoImpl = new EnrollmentDaoImpl(schoolYearDaoImpl);
                    isSuccessful = enrollmentDaoImpl.enroll(tuition.getStudent());
                }
            } else {
                boolean isPaid = tuitionFeeDaoImpl.pay(tuition);
                if (isPaid) {
                    isSuccessful = true;
//                }
                }
            }            
        }
        return isSuccessful;
    }

    private Payment getPayment() {
        String orNoAttached = view.getJlblOrNo().getText().trim();
        Payment payment = new Payment();
        if (paymentInputAreValid()) {
            payment.setParticulars(getParticulars());
            payment.setAmountReceived(getAmountReceived());
            payment.setAmountCharged(getAmountCharged());
            payment.setOrNo(Integer.parseInt(orNoAttached.trim()));
        }
        return payment;
    }
    
    private boolean paymentInputAreValid() {
        boolean isValid = false;
        String amountReceived = view.getJtfTendered().getText().trim();
        String amountCharged = view.getJtfAmountCharged().getText().trim();
        if (isValidAmount(amountReceived) && isValidAmount(amountCharged)) {
            isValid = true;
        }
        return isValid;
    }
    
    private BigDecimal getAmountReceived(){
        String amountReceived = view.getJtfTendered().getText().trim();
        return BigDecimal.valueOf(Double.parseDouble(amountReceived)).setScale(2, RoundingMode.HALF_UP);
    }
    
    private BigDecimal getAmountCharged() {
        String amountCharged = view.getJtfAmountCharged().getText().trim();
        return BigDecimal.valueOf(Double.parseDouble(amountCharged)).setScale(2, RoundingMode.HALF_UP);
    }

    private List<Particular> getParticulars() {
        List<Particular> particularList = new ArrayList<>();
        JTable t = view.getJtblPaymentBreakDown();
        for (int i = 0; i < t.getRowCount(); i++) {
            String balancebreakdownName = t.getValueAt(i, 0).toString().trim();
            Particular particular = new Particular();
            particular.setName(balancebreakdownName);
            particular.setAmountPaid(getAmountCharged());
            particularList.add(particular);
        }
        return particularList;
        
    }

    private boolean isValidAmount(String s) {
        boolean isValid;
        try {
            Double.parseDouble(s.trim());
            isValid = true;
        } catch (Exception e) {
            isValid = false;
            e.printStackTrace();
        }
        return isValid;
    }
}
