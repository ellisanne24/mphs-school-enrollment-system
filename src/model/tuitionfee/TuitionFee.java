/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tuitionfee;

import java.util.List;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.discount.Discount;
import model.downpayment.DownPaymentFee;
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
    private double balance;
    private PaymentTerm paymentTerm;
    private Discount discount;
    private DownPaymentFee downPaymentFee;
    private List<BalanceBreakDownFee> balanceBreakDownFees;
    private SchoolYear schoolYear;
    private Student student;

    public DownPaymentFee getDownPaymentFee() {
        return downPaymentFee;
    }

    public void setDownPaymentFee(DownPaymentFee downPaymentFee) {
        this.downPaymentFee = downPaymentFee;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
