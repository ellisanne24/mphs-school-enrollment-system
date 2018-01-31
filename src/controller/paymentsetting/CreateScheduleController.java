
package controller.paymentsetting;

import daoimpl.PaymentTermDaoImpl;
import daoimpl.PeriodDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.paymentterm.PaymentTerm;
import model.period.Period;
import org.jdatepicker.impl.JDatePickerImpl;
import utility.date.DateUtil;
import utility.form.FormInspector;
import utility.form.FormValidator;

/**
 *
 * @author John Ferdinand Antonio
 */
public class CreateScheduleController extends FormInspector implements ActionListener, FormValidator{

    private final JPanel jpnlSchoolYear;
    private final JPanel jpnlSemestral;
    private final JPanel jpnlQuarterly;
    private final JPanel jpnlMonthly;
    private final JComboBox jcmbSchoolYear;
    private final JTextField jtfSemestralPenalty;
    private final JTextField jtfQuarterlyPenalty;
    private final JTextField jtfMonthlyPenalty;

    private final JDatePickerImpl dpFirstSemTo;
    private final JDatePickerImpl dpSecondSemTo;
    private final JDatePickerImpl dpFirstQuarterTo;
    private final JDatePickerImpl dpSecondQuarterTo;
    private final JDatePickerImpl dpThirdQuarterTo;
    private final JDatePickerImpl dpFourthQuarterTo;
    private final JDatePickerImpl dpFirstMonthTo;
    private final JDatePickerImpl dpSecondMonthTo;
    private final JDatePickerImpl dpThirdMonthTo;
    private final JDatePickerImpl dpFourthMonthTo;
    private final JDatePickerImpl dpFifthMonthTo;
    private final JDatePickerImpl dpSixthMonthTo;
    private final JDatePickerImpl dpSeventhMonthTo;
    private final JDatePickerImpl dpEighthMonthTo;
    private final JDatePickerImpl dpNinthMonthTo;
    private final JDatePickerImpl dpTenthMonthTo;

    private SchoolYearDaoImpl schoolYearDaoImpl;
    private PaymentTermDaoImpl paymentTermDaoImpl;
    private PeriodDaoImpl periodDaoImpl;
    private DateUtil dateUtil;

    public CreateScheduleController(
            JPanel jpnlSchoolYear,JPanel jpnlSemestral, JPanel jpnlQuarterly, JPanel jpnlMonthly,
            JComboBox jcmbSchoolYear,
            JTextField jtfSemestralPenalty, JTextField jtfQuarterlyPenalty, JTextField jtfMonthlyPenalty,
            JDatePickerImpl dpFirstSemTo, JDatePickerImpl dpSecondSemTo,
            JDatePickerImpl dpFirstQuarterTo, JDatePickerImpl dpSecondQuarterTo, JDatePickerImpl dpThirdQuarterTo,
            JDatePickerImpl dpFourthQuarterTo, JDatePickerImpl dpFirstMonthTo, JDatePickerImpl dpSecondMonthTo,
            JDatePickerImpl dpThirdMonthTo, JDatePickerImpl dpFourthMonthTo, JDatePickerImpl dpFifthMonthTo,
            JDatePickerImpl dpSixthMonthTo, JDatePickerImpl dpSeventhMonthTo, JDatePickerImpl dpEighthMonthTo,
            JDatePickerImpl dpNinthMonthTo, JDatePickerImpl dpTenthMonthTo
    ) {
        schoolYearDaoImpl = new SchoolYearDaoImpl();
        paymentTermDaoImpl = new PaymentTermDaoImpl();
        periodDaoImpl = new PeriodDaoImpl();
        dateUtil = new DateUtil();
        this.jpnlSchoolYear = jpnlSchoolYear;
        this.jpnlSemestral = jpnlSemestral;
        this.jpnlQuarterly = jpnlQuarterly;
        this.jpnlMonthly = jpnlMonthly;
        this.jcmbSchoolYear = jcmbSchoolYear;
        this.jtfSemestralPenalty = jtfSemestralPenalty;
        this.jtfQuarterlyPenalty = jtfQuarterlyPenalty;
        this.jtfMonthlyPenalty = jtfMonthlyPenalty;
        this.dpFirstSemTo = dpFirstSemTo;
        this.dpSecondSemTo = dpSecondSemTo;
        this.dpFirstQuarterTo = dpFirstQuarterTo;
        this.dpSecondQuarterTo = dpSecondQuarterTo;
        this.dpThirdQuarterTo = dpThirdQuarterTo;
        this.dpFourthQuarterTo = dpFourthQuarterTo;
        this.dpFirstMonthTo = dpFirstMonthTo;
        this.dpSecondMonthTo = dpSecondMonthTo;
        this.dpThirdMonthTo = dpThirdMonthTo;
        this.dpFourthMonthTo = dpFourthMonthTo;
        this.dpFifthMonthTo = dpFifthMonthTo;
        this.dpSixthMonthTo = dpSixthMonthTo;
        this.dpSeventhMonthTo = dpSeventhMonthTo;
        this.dpEighthMonthTo = dpEighthMonthTo;
        this.dpNinthMonthTo = dpNinthMonthTo;
        this.dpTenthMonthTo = dpTenthMonthTo;
    }

    @Override
    public boolean formIsValid() {
        boolean isValid = (!hasEmptyFields(jpnlSchoolYear) && !hasEmptyFields(jpnlSemestral)
                && !hasEmptyFields(jpnlQuarterly) && !hasEmptyFields(jpnlMonthly));
        return isValid;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (formIsValid()) {
            int choice = JOptionPane.showConfirmDialog(null, "Create Payment Schedule?", "Create", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                createSchedule();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please check if all fields are filled.");
        }
    }

    private void createSchedule() {
        List<PaymentTerm> paymentTerms = new ArrayList<>();
        paymentTerms.add(getSemestral());
        paymentTerms.add(getQuarterly());
        paymentTerms.add(getMonthly());

        boolean isAdded = paymentTermDaoImpl.addPaymentSchedule(paymentTerms);
        if (isAdded) {
            JOptionPane.showMessageDialog(null, "Successfully created schedule.");
        } else {
            JOptionPane.showMessageDialog(null, "Error encountered. ");

        }
    }
    
    private PaymentTerm getSemestral() {
        PaymentTerm semestral = new PaymentTerm();
        List<Period> semestralPeriods = new ArrayList<>();
        Period firstSemPeriod = new Period();
        Period secondSemPeriod = new Period();
        try {
            firstSemPeriod.setPeriodName("First Semester");
            firstSemPeriod.setPaymentDeadline(dateUtil.toDate(dpFirstSemTo.getJFormattedTextField().getText().trim()));
            secondSemPeriod.setPeriodName("Second Semester");
            secondSemPeriod.setPaymentDeadline(dateUtil.toDate(dpSecondSemTo.getJFormattedTextField().getText().trim()));
            semestralPeriods.add(firstSemPeriod);
            semestralPeriods.add(secondSemPeriod);
            
            semestral.setPaymentTermId(paymentTermDaoImpl.getPaymentTermIDByName("Semestral"));
            semestral.setSchoolYearId(schoolYearDaoImpl.getId(Integer.parseInt(jcmbSchoolYear.getSelectedItem().toString())));
            semestral.setPeriods(semestralPeriods);
            semestral.setPenaltyAmount(BigDecimal.valueOf(Double.parseDouble(jtfSemestralPenalty.getText().trim())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return semestral;
    }
    
    private PaymentTerm getQuarterly() {
        PaymentTerm quarterly = new PaymentTerm();
        List<Period> quarterlyPeriods = new ArrayList<>();
        Period firstQuarter = new Period();
        Period secondQuarter = new Period();
        Period thirdQuarter = new Period();
        Period fourthQuarter = new Period();
        try {
            firstQuarter.setPeriodName("First Quarter");
            firstQuarter.setPaymentDeadline(dateUtil.toDate(dpFirstQuarterTo.getJFormattedTextField().getText().trim()));
            secondQuarter.setPeriodName("Second Quarter");
            secondQuarter.setPaymentDeadline(dateUtil.toDate(dpSecondQuarterTo.getJFormattedTextField().getText().trim()));
            thirdQuarter.setPeriodName("Third Quarter");
            thirdQuarter.setPaymentDeadline(dateUtil.toDate(dpThirdQuarterTo.getJFormattedTextField().getText().trim()));
            fourthQuarter.setPeriodName("Fourth Quarter");
            fourthQuarter.setPaymentDeadline(dateUtil.toDate(dpFourthQuarterTo.getJFormattedTextField().getText().trim()));
            quarterlyPeriods.add(firstQuarter);
            quarterlyPeriods.add(secondQuarter);
            quarterlyPeriods.add(thirdQuarter);
            quarterlyPeriods.add(fourthQuarter);
            
            quarterly.setPaymentTermId(paymentTermDaoImpl.getPaymentTermIDByName("Quarterly"));
            quarterly.setSchoolYearId(schoolYearDaoImpl.getId(Integer.parseInt(jcmbSchoolYear.getSelectedItem().toString().trim())));
            quarterly.setPeriods(quarterlyPeriods);
            quarterly.setPenaltyAmount(BigDecimal.valueOf(Double.parseDouble(jtfQuarterlyPenalty.getText().trim())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quarterly;
    }
    
    private PaymentTerm getMonthly() {
        PaymentTerm monthly = new PaymentTerm();
        List<Period> monthlyPeriods = new ArrayList<>();
        Period firstMonth = new Period();
        Period secondMonth = new Period();
        Period thirdMonth = new Period();
        Period fourthMonth = new Period();
        Period fifthMonth = new Period();
        Period sixthMonth = new Period();
        Period seventhMonth = new Period();
        Period eighthMonth = new Period();
        Period ninthMonth = new Period();
        Period tenthMonth = new Period();

        try {
            firstMonth.setPeriodName("First Month");
            firstMonth.setPaymentDeadline(dateUtil.toDate(dpFirstMonthTo.getJFormattedTextField().getText().trim()));
            secondMonth.setPeriodName("Second Month");
            secondMonth.setPaymentDeadline(dateUtil.toDate(dpSecondMonthTo.getJFormattedTextField().getText().trim()));
            thirdMonth.setPeriodName("Third Month");
            thirdMonth.setPaymentDeadline(dateUtil.toDate(dpThirdMonthTo.getJFormattedTextField().getText().trim()));
            fourthMonth.setPeriodName("Fourth Month");
            fourthMonth.setPaymentDeadline(dateUtil.toDate(dpFourthMonthTo.getJFormattedTextField().getText().trim()));
            fifthMonth.setPeriodName("Fifth Month");
            fifthMonth.setPaymentDeadline(dateUtil.toDate(dpFifthMonthTo.getJFormattedTextField().getText().trim()));
            sixthMonth.setPeriodName("Sixth Month");
            sixthMonth.setPaymentDeadline(dateUtil.toDate(dpSixthMonthTo.getJFormattedTextField().getText().trim()));
            seventhMonth.setPeriodName("Seventh Month");
            seventhMonth.setPaymentDeadline(dateUtil.toDate(dpSeventhMonthTo.getJFormattedTextField().getText().trim()));
            eighthMonth.setPeriodName("Eighth Month");
            eighthMonth.setPaymentDeadline(dateUtil.toDate(dpEighthMonthTo.getJFormattedTextField().getText().trim()));
            ninthMonth.setPeriodName("Ninth Month");
            ninthMonth.setPaymentDeadline(dateUtil.toDate(dpNinthMonthTo.getJFormattedTextField().getText().trim()));
            tenthMonth.setPeriodName("Tenth Month");
            tenthMonth.setPaymentDeadline(dateUtil.toDate(dpTenthMonthTo.getJFormattedTextField().getText().trim()));
            monthlyPeriods.add(firstMonth);
            monthlyPeriods.add(secondMonth);
            monthlyPeriods.add(thirdMonth);
            monthlyPeriods.add(fourthMonth);
            monthlyPeriods.add(fifthMonth);
            monthlyPeriods.add(sixthMonth);
            monthlyPeriods.add(seventhMonth);
            monthlyPeriods.add(eighthMonth);
            monthlyPeriods.add(ninthMonth);
            monthlyPeriods.add(tenthMonth);
            
            monthly.setPaymentTermId(paymentTermDaoImpl.getPaymentTermIDByName("Monthly"));
            monthly.setSchoolYearId(schoolYearDaoImpl.getId(Integer.parseInt(jcmbSchoolYear.getSelectedItem().toString().trim())));
            monthly.setPeriods(monthlyPeriods);
            monthly.setPenaltyAmount(BigDecimal.valueOf(Double.parseDouble(jtfMonthlyPenalty.getText().trim())));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        return monthly;
    }

}
