
package controller.schoolyear;

import daoimpl.SchoolYearDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import model.quarter.Quarter;
import model.schoolyear.SchoolYear;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePickerImpl;
import utility.date.DateUtil;

/**
 *
 * @author Jordan
 */
public class CreateSchoolYear implements ActionListener{
    
    private JDialog dialogSchoolYearCrud;
    
    private final JDatePickerImpl dpSchoolYearStartDate;
    private final JDatePickerImpl dpSchoolYearEndDate;
    
    private final JDatePickerImpl dpRegularEnrollmentStartDate;
    private final JDatePickerImpl dpRegularEnrollmentEndDate;
    private final JDatePickerImpl dpSummerEnrollmentStartDate;
    private final JDatePickerImpl dpSummerEnrollmentEndDate;
    
    private final JDatePickerImpl dpSummerClassStart;
    private final JDatePickerImpl dpSummerClassEnd;
    
    private final JDatePickerImpl dp1stQtrStartDate;
    private final JDatePickerImpl dp1stQtrEndDate;
    private final JDatePickerImpl dp1stQtrGradingDueDate;
    
    private final JDatePickerImpl dp2ndQtrStartDate;
    private final JDatePickerImpl dp2ndQtrEndDate;
    private final JDatePickerImpl dp2ndQtrGradingDueDate;
    
    private final JDatePickerImpl dp3rdQtrStartDate;
    private final JDatePickerImpl dp3rdQtrEndDate;
    private final JDatePickerImpl dp3rdQtrGradingDueDate;
    
    private final JDatePickerImpl dp4thQtrStartDate;
    private final JDatePickerImpl dp4thQtrEndDate;
    private final JDatePickerImpl dp4thQtrGradingDueDate;
    
    private final JLabel jlblStatus;
    private final JComboBox jcmbStatus;
    private final JSpinner jsprYearFrom;
    private final JSpinner jsprYearTo;
    
    private SchoolYearDaoImpl schoolYearDaoImpl;
    private DateUtil dateUtil;

    public CreateSchoolYear(JDialog dialogSchoolYearCrud, JDatePickerImpl dpSchoolYearStartDate, 
            JDatePickerImpl dpSchoolYearEndDate, JDatePickerImpl dpRegularEnrollmentStartDate, 
            JDatePickerImpl dpRegularEnrollmentEndDate, JDatePickerImpl dpSummerEnrollmentStartDate, 
            JDatePickerImpl dpSummerEnrollmentEndDate, JDatePickerImpl dp1stQtrStartDate, 
            JDatePickerImpl dp1stQtrEndDate, JDatePickerImpl dp1stQtrGradingDuedate, 
            JDatePickerImpl dp2ndQtrStartDate, JDatePickerImpl dp2ndQtrEndDate, 
            JDatePickerImpl dp2ndQtrGradingDueDate, JDatePickerImpl dp3rdQtrStartDate, 
            JDatePickerImpl dp3rdQtrEndDate, JDatePickerImpl dp3rdQtrGradingDueDate, 
            JDatePickerImpl dp4thQtrStartDate, JDatePickerImpl dp4thQtrEndDate, 
            JDatePickerImpl dp4thQtrGradingDueDate, JLabel jlblStatus, JComboBox jcmbStatus, 
            JSpinner jsprYearFrom, JSpinner jsprYearTo, JDatePickerImpl dpSummerClassStart, 
            JDatePickerImpl dpSummerClassEnd) {
        this.dialogSchoolYearCrud = dialogSchoolYearCrud;
        this.dpSchoolYearStartDate = dpSchoolYearStartDate;
        this.dpSchoolYearEndDate = dpSchoolYearEndDate;
        this.dpRegularEnrollmentStartDate = dpRegularEnrollmentStartDate;
        this.dpRegularEnrollmentEndDate = dpRegularEnrollmentEndDate;
        this.dpSummerEnrollmentStartDate = dpSummerEnrollmentStartDate;
        this.dpSummerEnrollmentEndDate = dpSummerEnrollmentEndDate;
        this.dp1stQtrStartDate = dp1stQtrStartDate;
        this.dp1stQtrEndDate = dp1stQtrEndDate;
        this.dp1stQtrGradingDueDate = dp1stQtrGradingDuedate;
        this.dp2ndQtrStartDate = dp2ndQtrStartDate;
        this.dp2ndQtrEndDate = dp2ndQtrEndDate;
        this.dp2ndQtrGradingDueDate = dp2ndQtrGradingDueDate;
        this.dp3rdQtrStartDate = dp3rdQtrStartDate;
        this.dp3rdQtrEndDate = dp3rdQtrEndDate;
        this.dp3rdQtrGradingDueDate = dp3rdQtrGradingDueDate;
        this.dp4thQtrStartDate = dp4thQtrStartDate;
        this.dp4thQtrEndDate = dp4thQtrEndDate;
        this.dp4thQtrGradingDueDate = dp4thQtrGradingDueDate;
        this.jlblStatus = jlblStatus;
        this.jcmbStatus = jcmbStatus;
        this.jsprYearFrom = jsprYearFrom;
        this.jsprYearTo = jsprYearTo;
        this.dpSummerClassStart = dpSummerClassStart;
        this.dpSummerClassEnd = dpSummerClassEnd;
        
        schoolYearDaoImpl = new SchoolYearDaoImpl();
        dateUtil = new DateUtil();
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        int choice = JOptionPane.showConfirmDialog(null, "Save School Year?", "Save Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(choice == JOptionPane.YES_OPTION){
            if(add()){
                JOptionPane.showMessageDialog(null,"Successfully saved School Year!");
            }else{
                JOptionPane.showMessageDialog(null,"Failed to save School Year");
            }
        }
    }
    
    private boolean add() {
        boolean isAdded = false;
        SchoolYear schoolYear = new SchoolYear();
        schoolYear = getSchoolYear();
        isAdded = schoolYearDaoImpl.add(schoolYear);
        return isAdded;
    }
    
    private SchoolYear getSchoolYear() {
        SchoolYear schoolYear = new SchoolYear();
        try {
            schoolYear.setYearFrom(Integer.parseInt(jsprYearFrom.getValue().toString().trim()));
            schoolYear.setYearTo(Integer.parseInt(jsprYearTo.getValue().toString().trim()));
            schoolYear.setSchoolYearStartDate(dateUtil.toDate(dpSchoolYearStartDate.getJFormattedTextField().getText().trim()));
            schoolYear.setSchoolYearEndDate(dateUtil.toDate(dpSchoolYearEndDate.getJFormattedTextField().getText().trim()));
            schoolYear.setRegularEnrollmentStartDate(dateUtil.toDate(dpRegularEnrollmentStartDate.getJFormattedTextField().getText().trim()));
            schoolYear.setRegularEnrollmentEndDate(dateUtil.toDate(dpRegularEnrollmentEndDate.getJFormattedTextField().getText().trim()));
            schoolYear.setSummerEnrollmentStartDate(dateUtil.toDate(dpSummerEnrollmentStartDate.getJFormattedTextField().getText().trim()));
            schoolYear.setSummerEnrollmentEndDate(dateUtil.toDate(dpSummerEnrollmentEndDate.getJFormattedTextField().getText().trim()));
            schoolYear.setQuarters(getQuarters());
            schoolYear.setSummerClassStartDate(dateUtil.toDate(dpSummerClassStart.getJFormattedTextField().getText().trim()));
            schoolYear.setSummerClassEndDate(dateUtil.toDate(dpSummerClassEnd.getJFormattedTextField().getText().trim()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return schoolYear;
    }
    
    private List<Quarter> getQuarters() {
        List<Quarter> quarterList = new ArrayList<>();
        try {
            Quarter firstQuarter = new Quarter();
            firstQuarter.setQuarterNo(1);
            firstQuarter.setStartDate(dateUtil.toDate(dp1stQtrStartDate.getJFormattedTextField().getText().trim()));
            firstQuarter.setEndDate(dateUtil.toDate(dp1stQtrEndDate.getJFormattedTextField().getText().trim()));
            firstQuarter.setGradingDueDate(dateUtil.toDate(dp1stQtrGradingDueDate.getJFormattedTextField().getText().trim()));
            quarterList.add(firstQuarter);
            
            Quarter secondQuarter = new Quarter();
            secondQuarter.setQuarterNo(2);
            secondQuarter.setStartDate(dateUtil.toDate(dp2ndQtrStartDate.getJFormattedTextField().getText().trim()));
            secondQuarter.setEndDate(dateUtil.toDate(dp2ndQtrEndDate.getJFormattedTextField().getText().trim()));
            secondQuarter.setGradingDueDate(dateUtil.toDate(dp2ndQtrGradingDueDate.getJFormattedTextField().getText().trim()));
            quarterList.add(secondQuarter);
            
            Quarter thirdQuarter = new Quarter();
            thirdQuarter.setQuarterNo(3);
            thirdQuarter.setStartDate(dateUtil.toDate(dp3rdQtrStartDate.getJFormattedTextField().getText().trim()));
            thirdQuarter.setEndDate(dateUtil.toDate(dp3rdQtrEndDate.getJFormattedTextField().getText().trim()));
            thirdQuarter.setGradingDueDate(dateUtil.toDate(dp3rdQtrGradingDueDate.getJFormattedTextField().getText().trim()));
            quarterList.add(thirdQuarter);
            
            Quarter fourthQuarter = new Quarter();
            fourthQuarter.setQuarterNo(4);
            fourthQuarter.setStartDate(dateUtil.toDate(dp4thQtrStartDate.getJFormattedTextField().getText().trim()));
            fourthQuarter.setEndDate(dateUtil.toDate(dp4thQtrEndDate.getJFormattedTextField().getText().trim()));
            fourthQuarter.setGradingDueDate(dateUtil.toDate(dp4thQtrGradingDueDate.getJFormattedTextField().getText().trim()));
            quarterList.add(fourthQuarter);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quarterList;
    }
    
}
