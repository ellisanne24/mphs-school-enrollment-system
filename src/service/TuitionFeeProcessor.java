/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.downpayment.DownPaymentFee;
import model.fee.Fee;
import model.otherfees.OtherFees;
import model.paymentterm.PaymentTerm;
import model.schoolfees.SchoolFees;
import model.student.Student;
import model.tuitionfee.TuitionFee;

/**
 *
 * @author John Ferdinand Antonio
 */
public class TuitionFeeProcessor {
    private final TuitionFee tuitionFee;
    private final SchoolFees schoolFees;

    public TuitionFeeProcessor(TuitionFee tuitionFee,SchoolFees schoolFees) {
        for(Fee f:schoolFees.getOtherFees().getFees()){
            System.out.println("Description: "+f.getDescription());
        }
        this.tuitionFee = tuitionFee;
        this.schoolFees = schoolFees;
    }

    public double getDiscount(){
        double tuitionAmount = schoolFees.getSum();
        int discountPercentage = tuitionFee.getDiscount()==null? 0:tuitionFee.getDiscount().getPercentOfDiscount();
        double discountAmount = (tuitionAmount * discountPercentage)/100;
        return discountAmount;
    }
    
    public double getFinalTuition(){
        double tuitionAmount = schoolFees.getSum();
        int discountPercentage = tuitionFee.getDiscount()==null? 0:tuitionFee.getDiscount().getPercentOfDiscount();
        double discountAmount = (tuitionAmount * discountPercentage)/100;
        double finalTuitionAmount = (tuitionAmount - discountAmount);
        return finalTuitionAmount;
    }
    
    public List<BalanceBreakDownFee> getBreakDown(){
        List<BalanceBreakDownFee> balanceBreakDownFees = new ArrayList<>();
        PaymentTerm paymentTerm = tuitionFee.getPaymentTerm();
        DownPaymentFee downPaymentFee = schoolFees.getDownPaymentFee();
        OtherFees otherFees = schoolFees.getOtherFees();
        double tuitionAmount = schoolFees.getSum();
        int discountPercentage = tuitionFee.getDiscount()==null? 0:tuitionFee.getDiscount().getPercentOfDiscount();
        double discountAmount = (tuitionAmount * discountPercentage)/100;
        double finalTuitionAmount = (tuitionAmount - discountAmount);
        
        BalanceBreakDownFee dp = new BalanceBreakDownFee();
        dp.setAmount(downPaymentFee.getAmount());
        dp.setBalance(downPaymentFee.getAmount());
        dp.setDescription("Downpayment");
        
        switch(paymentTerm.getName()){
            case "Cash":
                BalanceBreakDownFee cashFee = new BalanceBreakDownFee();
                cashFee.setAmount(finalTuitionAmount - otherFees.getSum());
                cashFee.setBalance(finalTuitionAmount - otherFees.getSum());
                cashFee.setDescription("Cash");
                balanceBreakDownFees.add(cashFee);
                
                for(Fee f : otherFees.getFees()){
                    BalanceBreakDownFee others = new BalanceBreakDownFee();
                    others.setAmount(f.getAmount());
                    others.setDescription(f.getDescription());
                    others.setBalance(f.getAmount());
                    
                    balanceBreakDownFees.add(others);
                }
                break;
            case "Quarterly":
                double perQuarterAmount = (finalTuitionAmount - dp.getAmount() - otherFees.getSum() )/4;
                double perQuarterBalance = perQuarterAmount;
                if(discountPercentage >= 100){
                    dp.setAmount(0.00);
                    dp.setBalance(0.00);
                    balanceBreakDownFees.add(dp);
                }else{
                    balanceBreakDownFees.add(dp);
                }
                
                System.out.println("Added DownPayment");
                for (int x = 1; x <= 4; x++ ) {
                    BalanceBreakDownFee quarterlyFee = new BalanceBreakDownFee();
                    quarterlyFee.setAmount(perQuarterAmount < 0? 0.00 : perQuarterAmount);
                    quarterlyFee.setBalance(perQuarterBalance < 0? 0.00: perQuarterBalance);
                    quarterlyFee.setDescription("Quarter "+x);
                    
                    balanceBreakDownFees.add(quarterlyFee);
                    System.out.println("Added QuarterLy fee: "+x);
                }
                
                    System.out.println("Other Fees SIZE Is: "+otherFees.getFees().size());
                
                
                for(Fee f : otherFees.getFees()){
                    System.out.println("Entered other.getFees() block @ Quarterly\n");
                    BalanceBreakDownFee others = new BalanceBreakDownFee();
                    others.setAmount(f.getAmount());
                    others.setDescription(f.getDescription());
                    others.setBalance(f.getAmount());
                    balanceBreakDownFees.add(others);
                    System.out.println("Added Other Fee\n");
                }
                break;
                
            case "Monthly":
                double perMonthAmount = (finalTuitionAmount - dp.getAmount() - otherFees.getSum() )/10;
                double perMonthBalance = perMonthAmount;
               
                if(discountPercentage >= 100){
                    dp.setAmount(0.00);
                    dp.setBalance(0.00);
                    balanceBreakDownFees.add(dp);
                }else{
                    balanceBreakDownFees.add(dp);
                }
                
                for (int x = 1; x <= 10; x++ ) {
                    BalanceBreakDownFee monthlyFee = new BalanceBreakDownFee();
                    monthlyFee.setAmount(perMonthAmount < 0? 0.00 :perMonthAmount);
                    monthlyFee.setBalance(perMonthBalance < 0? 0.00 :perMonthBalance);
                    monthlyFee.setDescription("Month "+x);
                    
                    balanceBreakDownFees.add(monthlyFee);
                }
                
                for(Fee f : otherFees.getFees()){
                    BalanceBreakDownFee others = new BalanceBreakDownFee();
                    others.setAmount(f.getAmount());
                    others.setDescription(f.getDescription());
                    others.setBalance(f.getAmount());
                    balanceBreakDownFees.add(others);
                }
                break;
                
            case "Semestral":
                double perSemesterAmount = (finalTuitionAmount - dp.getAmount() - otherFees.getSum()  )/2;
                double perSemesterBalance = perSemesterAmount;
                
                if(discountPercentage >= 100){
                    dp.setAmount(0.00);
                    dp.setBalance(0.00);
                    balanceBreakDownFees.add(dp);
                }else{
                    balanceBreakDownFees.add(dp);
                }
                
                for (int x = 1; x <= 2; x++ ) {
                    BalanceBreakDownFee semestralFee = new BalanceBreakDownFee();
                    semestralFee.setAmount(perSemesterAmount < 0? 0.00 :perSemesterAmount);
                    semestralFee.setBalance(perSemesterBalance < 0? 0.00 :perSemesterBalance);
                    semestralFee.setDescription("Semester "+x);
                    
                    balanceBreakDownFees.add(semestralFee);
                }
               
                for(Fee f : otherFees.getFees()){
                    BalanceBreakDownFee others = new BalanceBreakDownFee();
                    others.setAmount(f.getAmount());
                    others.setDescription(f.getDescription());
                    others.setBalance(f.getAmount());
                    
                    balanceBreakDownFees.add(others);
                }
                break;
        }
        
        return balanceBreakDownFees;
    } 
}
