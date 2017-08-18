package service;

import daoimpl.PaymentTermDaoImpl;
import java.util.ArrayList;
import java.util.List;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.downpayment.DownPaymentFee;
import model.fee.Fee;
import model.otherfees.OtherFees;
import model.paymentterm.PaymentTerm;
import model.period.Period;
import model.schoolfees.SchoolFees;
import model.schoolyear.SchoolYear;
import model.tuitionfee.TuitionFee;

/**
 *
 * @author John Ferdinand Antonio
 */
public class TuitionFeeProcessor {
    private final TuitionFee tuitionFee;
    private final SchoolFees schoolFees;
    private final SchoolYear schoolYear;
    private final PaymentTermDaoImpl paymentTermDaoImpl;

    public TuitionFeeProcessor(TuitionFee tuitionFee,SchoolFees schoolFees,SchoolYear schoolYear) {
        this.tuitionFee = tuitionFee;
        this.schoolFees = schoolFees;
        this.schoolYear = schoolYear;
        paymentTermDaoImpl = new PaymentTermDaoImpl();
    }

    public double getDiscount(){
        double tuitionAmount = schoolFees.getSum();
        int discountPercentage = tuitionFee.getDiscount()==null? 0:tuitionFee.getDiscount().getPercentOfDiscount();
        double discountAmount = (tuitionAmount * discountPercentage)/100;
        return discountAmount;
    }
    
    public double getFinalTuition(){
        double tuitionAmount = schoolFees.getSum();
        int discountPercentage = tuitionFee.getDiscount()==null? 
                0:tuitionFee.getDiscount().getPercentOfDiscount();
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
        int discountPercentage = tuitionFee.getDiscount()==null? 
                0:tuitionFee.getDiscount().getPercentOfDiscount();
        double discountAmount = (tuitionAmount * discountPercentage)/100;
        double finalTuitionAmount = (tuitionAmount - discountAmount);
        
        BalanceBreakDownFee dp = new BalanceBreakDownFee();
        dp.setAmount(downPaymentFee.getAmount());
        dp.setBalance(downPaymentFee.getAmount());
        dp.setDescription("Downpayment");
        
        
        int schoolYearId = schoolYear.getSchoolYearId();
        int paymentTermId = paymentTermDaoImpl.getId(paymentTerm.getName());
        List<Period> periodsList = paymentTermDaoImpl.getPeriodsByPaymentTermId(paymentTermId, schoolYearId);
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
                double perQuarterAmount = (finalTuitionAmount - dp.getAmount() - otherFees.getSum() )/paymentTerm.getDivisor();
                double perQuarterBalance = perQuarterAmount;
                if(discountPercentage >= 100){
                    dp.setAmount(0.00);
                    dp.setBalance(0.00);
                    balanceBreakDownFees.add(dp);
                }else{
                    balanceBreakDownFees.add(dp);
                }
                
                for(Period p : periodsList){
                    BalanceBreakDownFee b = new BalanceBreakDownFee();
                    b.setDescription(p.getDescription());
                    b.setAmount(perQuarterAmount < 0? 0.00 : perQuarterAmount);
                    b.setBalance(perQuarterBalance < 0? 0.00: perQuarterBalance);
                    b.setDeadline(p.getDeadlineOfPayment());
                    balanceBreakDownFees.add(b);
                }
                
                for(Fee f : otherFees.getFees()){
                    BalanceBreakDownFee others = new BalanceBreakDownFee();
                    others.setAmount(f.getAmount());
                    others.setDescription(f.getDescription());
                    others.setBalance(f.getAmount());
                    balanceBreakDownFees.add(others);
                }
                break;
                
            case "Monthly":
                double perMonthAmount = (finalTuitionAmount - dp.getAmount() - otherFees.getSum() )/paymentTerm.getDivisor();
                double perMonthBalance = perMonthAmount;
               
                if(discountPercentage >= 100){
                    dp.setAmount(0.00);
                    dp.setBalance(0.00);
                    balanceBreakDownFees.add(dp);
                }else{
                    balanceBreakDownFees.add(dp);
                }
                
                for(Period p : periodsList){
                    BalanceBreakDownFee b = new BalanceBreakDownFee();
                    b.setDescription(p.getDescription());
                    b.setAmount(perMonthAmount < 0? 0.00 : perMonthAmount);
                    b.setBalance(perMonthBalance < 0? 0.00: perMonthBalance);
                    b.setDeadline(p.getDeadlineOfPayment());
                    balanceBreakDownFees.add(b);
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
                double perSemesterAmount = (finalTuitionAmount - dp.getAmount() - otherFees.getSum()  )/paymentTerm.getDivisor();
                double perSemesterBalance = perSemesterAmount;
                
                if(discountPercentage >= 100){
                    dp.setAmount(0.00);
                    dp.setBalance(0.00);
                    balanceBreakDownFees.add(dp);
                }else{
                    balanceBreakDownFees.add(dp);
                }
                
                for(Period p : periodsList){
                    BalanceBreakDownFee b = new BalanceBreakDownFee();
                    b.setDescription(p.getDescription());
                    b.setAmount(perSemesterAmount < 0? 0.00 : perSemesterAmount);
                    b.setBalance(perSemesterBalance < 0? 0.00: perSemesterBalance);
                    b.setDeadline(p.getDeadlineOfPayment());
                    balanceBreakDownFees.add(b);
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
