
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
public class Tuition {

    private Payment payment;
    private PaymentTerm paymentTerm;
    private int schoolyearId;
    private boolean hasDiscount;
    private double totalFees;
    private boolean exists;
    private double totalPaid;
    private double remainingBalance;
    private Discount discount;
    
    private List<BalanceBreakDownFee> balanceBreakDownFees; //composed only of (basic + miscellaneous)/paymentterm
    
    private SchoolYear schoolYear;
    private Student student;

    public int getSchoolyearId() {
        return schoolyearId;
    }

    public void setSchoolyearId(int schoolyearId) {
        this.schoolyearId = schoolyearId;
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