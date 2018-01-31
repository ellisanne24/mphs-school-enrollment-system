
package model.tuitionfee;

import java.util.List;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.discount.Discount;
import model.fee.Fee;
import model.payment.Payment;
import model.paymentterm.PaymentTerm;
import model.schoolyear.SchoolYear;
import model.student.Student;

/**
 *
 * @author John Ferdinand Antonio
 */
public class TuitionFee {

    private Payment payment;
    private boolean hasDiscount;
    private double totalFees;
    private boolean exists;
    private double totalPaid;
    private double remainingBalance;
    private PaymentTerm paymentTerm;
    private Discount discount;
    
    private Fee downpayment;
    private List<Fee> others;
    private List<BalanceBreakDownFee> balanceBreakDownFees; //composed only of (basic + miscellaneous)/paymentterm
    
    private SchoolYear schoolYear;
    private Student student;

    public Fee getDownpayment() {
        return downpayment;
    }

    public void setDownpayment(Fee downpayment) {
        this.downpayment = downpayment;
    }

    
    
    public List<Fee> getOthers() {
        return others;
    }

    public void setOthers(List<Fee> others) {
        this.others = others;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public boolean hasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SchoolYear getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(SchoolYear schoolYear) {
        this.schoolYear = schoolYear;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(double totalFees) {
        this.totalFees = totalFees;
    }

    public boolean exists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public PaymentTerm getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(PaymentTerm paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public List<BalanceBreakDownFee> getBalanceBreakDownFees() {
        return balanceBreakDownFees;
    }

    public void setBalanceBreakDownFees(List<BalanceBreakDownFee> balanceBreakDownFees) {
        this.balanceBreakDownFees = balanceBreakDownFees;
    }

}
