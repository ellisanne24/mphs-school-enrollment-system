package service;

import daoimpl.PaymentTermDaoImpl;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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
    private final List<BalanceBreakDownFee> breakDown;

    public TuitionFeeProcessor(TuitionFee tuitionFee,SchoolFees schoolFees,SchoolYear schoolYear) {
        this.tuitionFee = tuitionFee;
        this.schoolFees = schoolFees;
        this.schoolYear = schoolYear;
        paymentTermDaoImpl = new PaymentTermDaoImpl();
        breakDown = new ArrayList<>();
        populateFees();
    }

    public double getDiscount() {
        Double tuitionAmount;
        Double discountAmount = null;
        int discountPercentage = 0;
        try {
            tuitionAmount = schoolFees.getSum();
            if (tuitionFee.getDiscount() != null) {
                discountPercentage = tuitionFee.getDiscount().getPercentOfDiscount();
            }
            discountAmount = (tuitionAmount * discountPercentage) / 100;
            
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return discountAmount;
    }
    
    public double getFinalTuition() {
        Double tuitionAmount;
        Double discountAmount;
        Double finalTuitionAmount = null;
        int discountPercentage = getDiscountPercentage();
        try {
            tuitionAmount = schoolFees.getSum();
            discountAmount = (tuitionAmount * discountPercentage) / 100;
            finalTuitionAmount = (tuitionAmount - discountAmount);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return finalTuitionAmount;
    }
    
    private int getDiscountPercentage(){
        int discountPercentage = 0;
        if(tuitionFee.getDiscount()!=null){
            discountPercentage = tuitionFee.getDiscount().getPercentOfDiscount();
        }
        return discountPercentage;
    }

    public List<BalanceBreakDownFee> getBreakDown() {
        return breakDown;
    }
    
    private void populateFees(){
        PaymentTerm paymentTerm = tuitionFee.getPaymentTerm();
        String paymentMethod = paymentTerm.getName().trim();
        switch (paymentMethod) {
            case "Cash":
                setCashFeesToBreakDown();
                break;
            case "Quarterly":
                setQuarterlyFeesToBreakDown();
                break;
            case "Monthly":
                setMonthlyFeesToBreakDown();
                break;
            case "Semestral":
                setSemestralFeesToBreakDown();
                break;
            default:
                break;
        }
    }
    
    private void setCashFeesToBreakDown(){
        addCashFees();
        addOtherFees();
    }
    
    private void setQuarterlyFeesToBreakDown(){
        addQuarterlyFees();
        addOtherFees();
    }
    
    private void setMonthlyFeesToBreakDown(){
        addMonthlyFees();
        addOtherFees();
    }
    
    private void setSemestralFeesToBreakDown(){
        addSemestralFees();
        addOtherFees();
    }
    
    
    private void addCashFees(){
        breakDown.add(getCashFees());
    }
    
    private void addQuarterlyFees(){
        List<Period> periods = getPaymentTermPeriods();
        int discountPercentage = getDiscountPercentage();
        BigDecimal perQuarterAmount = getPerPeriodAmount();
        BigDecimal perQuarterBalance = perQuarterAmount;
        
       DecimalFormat df = new DecimalFormat("#0.00");
       String formatted = df.format(perQuarterAmount.doubleValue());
       System.out.println("Formatted : "+formatted);
       BigDecimal bdperQtrAmt = new BigDecimal(formatted);
       System.out.println("New BigDecimal :"+bdperQtrAmt);
        
        BalanceBreakDownFee dp = getDownPayment();
        if (discountPercentage >= 100) {
            dp.setAmount(null);
            dp.setBalance(null);
            breakDown.add(dp);
        } else {
            breakDown.add(dp);
        }
        
        for (Period p : periods) {
            BalanceBreakDownFee b = new BalanceBreakDownFee();
            b.setDescription(p.getDescription());
            b.setAmount(bdperQtrAmt);
            b.setBalance(perQuarterBalance);
            b.setDeadline(p.getDeadlineOfPayment());
            breakDown.add(b);
        }
    }
    
    private void addMonthlyFees() {
        List<Period> periods = getPaymentTermPeriods();
        int discountPercentage = getDiscountPercentage();
        BigDecimal perMonthAmount = getPerPeriodAmount();
        BigDecimal perMonthBalance = perMonthAmount;

        BalanceBreakDownFee dp = getDownPayment();
        if (discountPercentage >= 100) {
            dp.setAmount(null);
            dp.setBalance(null);
            breakDown.add(dp);
        } else {
            breakDown.add(dp);
        }
        
        for (Period p : periods) {
            BalanceBreakDownFee b = new BalanceBreakDownFee();
            b.setDescription(p.getDescription());
            b.setAmount(perMonthAmount);
            b.setBalance(perMonthBalance);
            b.setDeadline(p.getDeadlineOfPayment());

            breakDown.add(b);
        }
    }
    
    private void addSemestralFees(){
        List<Period> periods = getPaymentTermPeriods();
        int discountPercentage = getDiscountPercentage();
        BigDecimal perSemesterAmount = getPerPeriodAmount();
        BigDecimal perSemesterBalance = perSemesterAmount;

        BalanceBreakDownFee dp = getDownPayment();
        if (discountPercentage >= 100) {
            dp.setAmount(null);
            dp.setBalance(null);
            breakDown.add(dp);
        } else {
            breakDown.add(dp);
        }

        for (Period p : periods) {
            BalanceBreakDownFee b = new BalanceBreakDownFee();
            b.setDescription(p.getDescription());
            b.setAmount(perSemesterAmount);
            b.setBalance(perSemesterBalance);
            b.setDeadline(p.getDeadlineOfPayment());

            breakDown.add(b);
        }
    }
    
    private void addOtherFees() {
        OtherFees otherFees = schoolFees.getOtherFees();
        for (Fee f : otherFees.getFees()) {
            BalanceBreakDownFee others = new BalanceBreakDownFee();
            others.setAmount(BigDecimal.valueOf(f.getAmount()));
            others.setDescription(f.getDescription());
            others.setBalance(BigDecimal.valueOf(f.getAmount()));
            breakDown.add(others);
        }
    }
    
    private BalanceBreakDownFee getCashFees() {
        double tuitionAmount = schoolFees.getSum();
        int discountPercentage = getDiscountPercentage();
        double discountAmount = (tuitionAmount * discountPercentage) / 100;
        double finalTuitionAmount = (tuitionAmount - discountAmount);
        OtherFees otherFees = schoolFees.getOtherFees();

        BalanceBreakDownFee cashFee = new BalanceBreakDownFee();
        cashFee.setAmount(BigDecimal.valueOf(finalTuitionAmount - otherFees.getSum()) );
        cashFee.setBalance(BigDecimal.valueOf(finalTuitionAmount - otherFees.getSum()));
        cashFee.setDescription("Cash");
        return cashFee;
    }
    
    private BigDecimal getPerPeriodAmount() {
        BalanceBreakDownFee dp = getDownPayment();
        OtherFees otherFees = schoolFees.getOtherFees();

        BigDecimal downPayment = dp.getAmount();
        double otherFeesSum = otherFees.getSum();
        double finalTuitionAmount = getFinalTuition();
        int quaterlyPeriodCount = tuitionFee.getPaymentTerm().getDivisor();
       
        double calculated = ((finalTuitionAmount - downPayment.doubleValue() - otherFeesSum)/quaterlyPeriodCount);
        calculated = Math.round(calculated * 100);
        calculated = calculated / 100;
        BigDecimal perPeriodAmount = BigDecimal.valueOf(calculated);
        System.out.println("perPeriodAmount after constructor initialization :"+perPeriodAmount);
        try {
            System.out.println("perPeriodAmount inside try :"+perPeriodAmount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return perPeriodAmount;
    }
    
    private BalanceBreakDownFee getDownPayment() {
        DownPaymentFee downPaymentFee = schoolFees.getDownPaymentFee();
        BalanceBreakDownFee dp = new BalanceBreakDownFee();
        dp.setAmount(BigDecimal.valueOf(downPaymentFee.getAmount()));
        dp.setBalance(BigDecimal.valueOf(downPaymentFee.getAmount()));
        dp.setDescription("Downpayment");
        return dp;
    }
    
    private List<Period> getPaymentTermPeriods(){
        PaymentTerm paymentTerm = tuitionFee.getPaymentTerm();
        int schoolYearId = schoolYear.getSchoolYearId();
        int paymentTermId = paymentTermDaoImpl.getId(paymentTerm.getName());
        List<Period> periods = paymentTermDaoImpl.getPeriodsByPaymentTermId(paymentTermId, schoolYearId);
        return periods;
    }
}
