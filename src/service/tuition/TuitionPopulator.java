/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.tuition;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.fee.Fee;
import model.paymentterm.PaymentTerm;
import model.period.Period;

/**
 *
 * @author Jordan
 */
public class TuitionPopulator {

    private final List<Fee> fees;
    private final PaymentTerm paymentTerm;

    public TuitionPopulator(List<Fee> fees, PaymentTerm paymentTerm) {
        this.fees = fees;
        this.paymentTerm = paymentTerm;
    }

    public BigDecimal getPerPeriodAmount() {
        BigDecimal feeSum = new BigDecimal(getFeesSum().toString());
        BigDecimal downpayment = getDownpaymentAmount();
        BigDecimal others = getOthersFeeSum();
        BigDecimal divisor = BigDecimal.valueOf(paymentTerm.getDivisor());
        BigDecimal perPeriod = new BigDecimal(BigInteger.ZERO);
        perPeriod = perPeriod.add(feeSum.subtract(downpayment).subtract(others).divide(divisor)).setScale(2, BigDecimal.ROUND_HALF_UP);
        return perPeriod;
    }

    private BigDecimal getFeesSum() {
        BigDecimal sum = new BigDecimal(BigInteger.ZERO);
        for (Fee f : fees) {
            sum = sum.add(f.getAmount());
        }
        return sum;
    }

    private BigDecimal getOthersFeeSum() {
        BigDecimal othersSum = new BigDecimal(BigInteger.ZERO);
        for (Fee f : fees) {
            if (f.getFeeCategory().getName().trim().equalsIgnoreCase("Others")) {
                othersSum = othersSum.add(f.getAmount());
            }
        }
        return othersSum;
    }

    private BigDecimal getDownpaymentAmount() {
        BigDecimal downpayment = new BigDecimal(BigInteger.ZERO);
        for (Fee f : fees) {
            if (f.getFeeCategory().getName().trim().equalsIgnoreCase("Downpayment")) {
                downpayment = downpayment.add(f.getAmount());
            }
        }
        return downpayment;
    }

    private void addCash(DefaultTableModel tableModel) {
        List<Period> periods = paymentTerm.getPeriods();
        for (Period p : periods) {
            String name = paymentTerm.getPaymentTermName().trim();
            BigDecimal amountDue = getFeesSum();
            Date dueDate = p.getPaymentDeadline();
            String category = paymentTerm.getPaymentTermName().trim();
            Object[] perPeriodRowData = {name, amountDue, amountDue, dueDate, "No", category};
            tableModel.addRow(perPeriodRowData);
        }
    }

    private void addPerPeriodFees(DefaultTableModel tableModel) {
        List<Period> periods = paymentTerm.getPeriods();
        for (Period p : periods) {
            String name = p.getPeriodName();
            BigDecimal amountDue = name.trim().equalsIgnoreCase("Downpayment") ? getDownpaymentAmount() : getPerPeriodAmount();
            Date dueDate = p.getPaymentDeadline();
            String category = name.trim().equalsIgnoreCase("Downpayment")? "Downpayment" : "Balance";
            Object[] perPeriodRowData = {name, amountDue, amountDue, dueDate, "No", category};
            tableModel.addRow(perPeriodRowData);
        }
    }

    private void addOtherFees(DefaultTableModel tableModel) {
        for (Fee f : fees) {
            if (f.getFeeCategory().getName().trim().equalsIgnoreCase("Others")) {
                Object[] otherFeeRowData = {f.getName(), f.getAmount(), f.getAmount(), "1970-01-01", "No", "Other"};
                tableModel.addRow(otherFeeRowData);
            }
        }
    }

    public DefaultTableModel getTuitionItemsTableModel(JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        boolean cash = paymentTerm.getPaymentTermName().trim().equalsIgnoreCase("Cash");
        if (cash) {
            addCash(tableModel);
        } else {
            addPerPeriodFees(tableModel);
        }
        addOtherFees(tableModel);
        return tableModel;
    }
}
