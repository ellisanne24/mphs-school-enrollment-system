
package view.paymentsetting;

import component_model_loader.SchoolYearJCompModelLoader;
import controller.paymentsetting.CreateScheduleController;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import utility.date.DateLabelFormatter;

/**
 *
 * @author Jordan
 */
public class DialogPaymentScheduleCrud extends JDialog{
    
    private SchoolYearJCompModelLoader schoolYearJCompModelLoader;
    private Insets defaultInsets;
    
    private JPanel jpnlTopPanel;
    private GridBagConstraints gbcJpnlTopPanel;
    private JPanel jpnlControls;
    private GridBagConstraints gbcJpnlControls;
    private JPanel jpnlSchoolYear;
    private GridBagConstraints gbcJpnlSchoolYear;
    private JLabel jtfSchoolYear;
    private JComboBox jcmbSchoolYear;
    private JPanel jpnlSemestral;
    private GridBagConstraints gbcJpnlSemestral;
    private JLabel jlblFirstSem;
    private GridBagConstraints gbcJlblFirstSem;
    private JLabel jlblSecondSem;
    private GridBagConstraints gbcJlblSecondSem;
    private JPanel jpnlQuarterly;
    private GridBagConstraints gbcJpnlQuarterly;
    private JLabel jlblFirstQuarter;
    private GridBagConstraints gbcJlblFirstQuarter;
    private JLabel jlblSecondQuarter;
    private GridBagConstraints gbcJlblSecondQuarter;
    private JLabel jlblThirdQuarter;
    private GridBagConstraints gbcJlblThirdQuarter;
    private JLabel jlblFourthQuarter;
    private GridBagConstraints gbcJlblFourthQuarter;
    private JPanel jpnlMonthly;
    private GridBagConstraints gbcJpnlMonthly;
    private JPanel jpnlPeriods;
    private GridBagConstraints gbcJpnlPeriods;
    
    private JLabel jlblFirstMonth;
    private GridBagConstraints gbcJlblFirstMonth;
    private JLabel jlblSecondMonth;
    private GridBagConstraints gbcJlblSecondMonth;
    private JLabel jlblThirdMonth;
    private GridBagConstraints gbcJlblThirdMonth;
    private JLabel jlblFourthMonth;
    private GridBagConstraints gbcJlblFourthMonth;
    private JLabel jlblFifthMonth;
    private GridBagConstraints gbcJlblFifthMonth;
    private JLabel jlblSixthMonth;
    private GridBagConstraints gbcJlblSixthMonth;
    private JLabel jlblSeventhMonth;
    private GridBagConstraints gbcJlblSeventhMonth;
    private JLabel jlblEighthMonth;
    private GridBagConstraints gbcJlblEighthMonth;
    private JLabel jlblNinthMonth;
    private GridBagConstraints gbcJlblNinthMonth;
    private JLabel jlblTenthMonth;
    private GridBagConstraints gbcJlblTenthMonth;
    
    private JLabel jlblDash;
    private GridBagConstraints gbcJlblDash;
    
    private Properties dateProperties;
    private DateLabelFormatter dateLabelFormatter;
    
    private JDatePanelImpl dpnlFirstSemTo;
    private JDatePanelImpl dpnlSecondSemTo;
    private JDatePanelImpl dpnlFirstQuarterTo;
    private JDatePanelImpl dpnlSecondQuarterTo;
    private JDatePanelImpl dpnlThirdQuarterTo;
    private JDatePanelImpl dpnlFourthQuarterTo;
    private JDatePanelImpl dpnlFirstMonthTo;
    private JDatePanelImpl dpnlSecondMonthTo;
    private JDatePanelImpl dpnlThirdMonthTo;
    private JDatePanelImpl dpnlFourthMonthTo;
    private JDatePanelImpl dpnlFifthMonthTo;
    private JDatePanelImpl dpnlSixthMonthTo;
    private JDatePanelImpl dpnlSeventhMonthTo;
    private JDatePanelImpl dpnlEighthMonthTo;
    private JDatePanelImpl dpnlNinthMonthTo;
    private JDatePanelImpl dpnlTenthMonthTo;
    
    private JDatePickerImpl dpFirstSemTo;
    private GridBagConstraints gbcDpFirstSemTo;
    private JDatePickerImpl dpSecondSemTo;
    private GridBagConstraints gbcDpSecondSemTo;
    private JDatePickerImpl dpFirstQuarterTo;
    private GridBagConstraints gbcDpFirstQuarterTo;
    private JDatePickerImpl dpSecondQuarterTo;
    private GridBagConstraints gbcDpSecondQuarterTo;
    private JDatePickerImpl dpThirdQuarterTo;
    private GridBagConstraints gbcDpThirdQuarterTo;
    private JDatePickerImpl dpFourthQuarterTo;
    private GridBagConstraints gbcDpFourthQuarterTo;
    private JDatePickerImpl dpFirstMonthTo;
    private GridBagConstraints gbcDpFirstMonthTo;
    private JDatePickerImpl dpSecondMonthTo;
    private GridBagConstraints gbcDpSecondMonthTo;
    private JDatePickerImpl dpThirdMonthTo;
    private GridBagConstraints gbcDpThirdMonthTo;
    private JDatePickerImpl dpFourthMonthTo;
    private GridBagConstraints gbcDpFourthMonthTo;
    private JDatePickerImpl dpFifthMonthTo;
    private GridBagConstraints gbcDpFifthMonthTo;
    private JDatePickerImpl dpSixthMonthTo;
    private GridBagConstraints gbcDpSixthMonthTo;
    private JDatePickerImpl dpSeventhMonthTo;
    private GridBagConstraints gbcDpSeventhMonthTo;
    private JDatePickerImpl dpEighthMonthTo;
    private GridBagConstraints gbcDpEighthMonthTo;
    private JDatePickerImpl dpNinthMonthTo;
    private GridBagConstraints gbcDpNinthMonthTo;
    private JDatePickerImpl dpTenthMonthTo;
    private GridBagConstraints gbcDpTenthMonthTo;
    
    private JLabel jlblSemestralPenalty;
    private GridBagConstraints gbcJlblSemestralPenalty;
    private JTextField jtfSemestralPenalty;
    private GridBagConstraints gbcJtfSemestralPenalty;
    private JLabel jlblQuarterlyPenalty;
    private GridBagConstraints gbcJlblQuarterlyPenalty;
    private JTextField jtfQuarterlyPenalty;
    private GridBagConstraints gbcJtfQuarterlyPenalty;
    private JLabel jlblMonthlyPenalty;
    private GridBagConstraints gbcJlblMonthlyPenalty;
    private JTextField jtfMonthlyPenalty;
    private GridBagConstraints gbcJtfMonthlyPenalty;
    
    private JButton jbtnSave;
    
    public DialogPaymentScheduleCrud(){
        initConstraints();
        initModels();
        initComponents();
        initControllers();
        createGUI();
    }

    private void initControllers() {
        jbtnSave.addActionListener(new CreateScheduleController(
                jpnlSchoolYear,jpnlSemestral,jpnlQuarterly,jpnlMonthly,
                jcmbSchoolYear,
                jtfSemestralPenalty, jtfQuarterlyPenalty, jtfMonthlyPenalty,
                dpFirstSemTo, dpSecondSemTo,
                dpFirstQuarterTo, dpSecondQuarterTo,
                dpThirdQuarterTo, dpFourthQuarterTo,
                dpFirstMonthTo, dpSecondMonthTo, dpThirdMonthTo,
                dpFourthMonthTo, dpFifthMonthTo, dpSixthMonthTo,
                dpSeventhMonthTo, dpEighthMonthTo, dpNinthMonthTo,
                dpTenthMonthTo
        )
        );
    }
    
    private void initConstraints(){
        this.setLayout(new GridBagLayout());
        this.setModal(true);
        
        defaultInsets = new Insets(3, 3, 3, 3);
        
        gbcJlblDash = new GridBagConstraints();
        
        gbcJpnlTopPanel = new GridBagConstraints();
        gbcJpnlTopPanel.fill = GridBagConstraints.BOTH;
        gbcJpnlTopPanel.weightx = 0.5;
        gbcJpnlTopPanel.weighty = 0.5;
        gbcJpnlTopPanel.insets = defaultInsets;
        
        gbcJpnlControls = new GridBagConstraints();
        gbcJpnlControls.gridx = 0;
        gbcJpnlControls.gridy = 3;
        gbcJpnlControls.insets = defaultInsets;
        
        gbcJpnlSchoolYear = new GridBagConstraints();
        gbcJpnlSchoolYear.weightx = 0.5;
        gbcJpnlSchoolYear.gridx = 0;
        gbcJpnlSchoolYear.gridy = 0;
        gbcJpnlSchoolYear.fill = GridBagConstraints.HORIZONTAL;
        gbcJpnlSchoolYear.insets = defaultInsets;
        
        gbcJpnlSemestral = new GridBagConstraints();
        gbcJpnlSemestral.weightx = 0.5;
//        gbcJpnlSemestral.weighty = 0.5;
        gbcJpnlSemestral.gridx = 0;        
        gbcJpnlSemestral.gridy = 0;  
        gbcJpnlSemestral.fill = GridBagConstraints.HORIZONTAL;
        gbcJpnlSemestral.insets = defaultInsets;
        
        gbcJpnlQuarterly = new GridBagConstraints();
        gbcJpnlQuarterly.weightx = 0.5;
//        gbcJpnlQuarterly.weighty = 0.5;
        gbcJpnlQuarterly.gridx = 0;
        gbcJpnlQuarterly.gridy = 1;
        gbcJpnlQuarterly.fill = GridBagConstraints.HORIZONTAL;
        gbcJpnlQuarterly.insets = defaultInsets;
        
        gbcJpnlMonthly = new GridBagConstraints();
        gbcJpnlMonthly.weightx = 0.5;
//        gbcJpnlMonthly.weighty = 0.5;
        gbcJpnlMonthly.gridx = 0;
        gbcJpnlMonthly.gridy = 2;
        gbcJpnlMonthly.fill = GridBagConstraints.HORIZONTAL;
        gbcJpnlMonthly.insets = defaultInsets;
        
        gbcJpnlPeriods = new GridBagConstraints();
        gbcJpnlPeriods.weightx = 0.5;
        gbcJpnlPeriods.weighty = 0.5;
        gbcJpnlPeriods.gridx = 0;
        gbcJpnlPeriods.gridy = 1;
        gbcJpnlPeriods.fill = GridBagConstraints.BOTH;
        gbcJpnlPeriods.insets = defaultInsets;
        
        gbcJlblFirstSem = new GridBagConstraints();
        gbcJlblFirstSem.gridx = 0;
        gbcJlblFirstSem.gridy = 0;
        gbcJlblFirstSem.insets = defaultInsets;
        
        gbcJlblSecondSem = new GridBagConstraints();
        gbcJlblSecondSem.gridx = 0;
        gbcJlblSecondSem.gridy = 1;
        gbcJlblSecondSem.insets = defaultInsets;
        
        gbcJlblSemestralPenalty = new GridBagConstraints();
        gbcJlblSemestralPenalty.gridx = 0;
        gbcJlblSemestralPenalty.gridy = 2;
        gbcJlblSemestralPenalty.insets = defaultInsets;
        gbcJtfSemestralPenalty = new GridBagConstraints();
        gbcJtfSemestralPenalty.gridx = 2;
        gbcJtfSemestralPenalty.gridy = 2;
        gbcJtfSemestralPenalty.insets = defaultInsets;
        gbcJtfSemestralPenalty.anchor = GridBagConstraints.WEST;
        
        gbcJlblFirstQuarter = new GridBagConstraints();
        gbcJlblFirstQuarter.gridx = 0;
        gbcJlblFirstQuarter.gridy = 0;
        gbcJlblFirstQuarter.insets = defaultInsets;
        
        gbcJlblSecondQuarter = new GridBagConstraints();
        gbcJlblSecondQuarter.gridx = 0;
        gbcJlblSecondQuarter.gridy = 1;
        gbcJlblSecondQuarter.insets = defaultInsets;
        
        gbcJlblThirdQuarter = new GridBagConstraints();
        gbcJlblThirdQuarter.gridx = 3;
        gbcJlblThirdQuarter.gridy = 0;
        gbcJlblThirdQuarter.insets = defaultInsets;
        
        gbcJlblFourthQuarter = new GridBagConstraints();
        gbcJlblFourthQuarter.gridx = 3;
        gbcJlblFourthQuarter.gridy = 1;
        gbcJlblFourthQuarter.insets = defaultInsets;
        
        gbcJlblQuarterlyPenalty = new GridBagConstraints();
        gbcJlblQuarterlyPenalty.gridx = 0;
        gbcJlblQuarterlyPenalty.gridy = 2;
        gbcJlblQuarterlyPenalty.insets = defaultInsets;
        gbcJtfQuarterlyPenalty = new GridBagConstraints();
        gbcJtfQuarterlyPenalty.gridx = 2;
        gbcJtfQuarterlyPenalty.gridy = 2;
        gbcJtfQuarterlyPenalty.insets = defaultInsets;
        gbcJtfQuarterlyPenalty.anchor = GridBagConstraints.WEST;
        
        gbcDpFirstSemTo = new GridBagConstraints();
        gbcDpFirstSemTo.gridx = 2;
        gbcDpFirstSemTo.gridy = 0;
        gbcDpFirstSemTo.weightx = 0.5;
        gbcDpFirstSemTo.anchor = GridBagConstraints.WEST;
        gbcDpFirstSemTo.insets = defaultInsets;
        
        gbcDpSecondSemTo = new GridBagConstraints();
        gbcDpSecondSemTo.gridx = 2;
        gbcDpSecondSemTo.gridy = 1;
        gbcDpSecondSemTo.weightx = 0.5;
        gbcDpSecondSemTo.anchor = GridBagConstraints.WEST;
        gbcDpSecondSemTo.insets = defaultInsets;
        
        gbcDpFirstQuarterTo = new GridBagConstraints();
        gbcDpFirstQuarterTo.gridx = 2;
        gbcDpFirstQuarterTo.gridy = 0;
        gbcDpFirstQuarterTo.insets = defaultInsets;
        
        gbcDpSecondQuarterTo = new GridBagConstraints();
        gbcDpSecondQuarterTo.gridx = 2;
        gbcDpSecondQuarterTo.gridy = 1;
        gbcDpSecondQuarterTo.insets = defaultInsets;
        
        gbcDpThirdQuarterTo = new GridBagConstraints();
        gbcDpThirdQuarterTo.gridx = 5;
        gbcDpThirdQuarterTo.gridy = 0;
        gbcDpThirdQuarterTo.insets = defaultInsets;
        
        gbcDpFourthQuarterTo = new GridBagConstraints();
        gbcDpFourthQuarterTo.gridx = 5;
        gbcDpFourthQuarterTo.gridy = 1;
        
        gbcJlblFirstMonth = new GridBagConstraints();
        gbcJlblFirstMonth.gridx = 0;
        gbcJlblFirstMonth.gridy = 0;
        gbcJlblFirstMonth.insets = defaultInsets;
        gbcDpFirstMonthTo = new GridBagConstraints();
        gbcDpFirstMonthTo.gridx = 2;
        gbcDpFirstMonthTo.gridy = 0;
        
        gbcJlblSecondMonth = new GridBagConstraints();
        gbcJlblSecondMonth.gridx = 0;
        gbcJlblSecondMonth.gridy = 1;
        gbcJlblSecondMonth.insets = defaultInsets;
        gbcDpSecondMonthTo = new GridBagConstraints();
        gbcDpSecondMonthTo.gridx = 2;
        gbcDpSecondMonthTo.gridy = 1;
        gbcDpSecondMonthTo.insets = defaultInsets;
        
        gbcJlblThirdMonth = new GridBagConstraints();
        gbcJlblThirdMonth.gridx = 0;
        gbcJlblThirdMonth.gridy = 2;
        gbcJlblThirdMonth.insets = defaultInsets;
        gbcDpThirdMonthTo = new GridBagConstraints();
        gbcDpThirdMonthTo.gridx = 2;
        gbcDpThirdMonthTo.gridy = 2;
        
        gbcJlblFourthMonth = new GridBagConstraints();
        gbcJlblFourthMonth.gridx = 0;
        gbcJlblFourthMonth.gridy = 3;
        gbcJlblFourthMonth.insets = defaultInsets;
        gbcDpFourthMonthTo = new GridBagConstraints();
        gbcDpFourthMonthTo.gridx = 2;
        gbcDpFourthMonthTo.gridy = 3;
        gbcDpFourthMonthTo.insets = defaultInsets;
                
        gbcJlblFifthMonth = new GridBagConstraints();
        gbcJlblFifthMonth.gridx = 0;
        gbcJlblFifthMonth.gridy = 4;
        gbcJlblFifthMonth.insets = defaultInsets;
        gbcDpFifthMonthTo = new GridBagConstraints();
        gbcDpFifthMonthTo.gridx = 2;
        gbcDpFifthMonthTo.gridy = 4;
        gbcDpFifthMonthTo.insets = defaultInsets;
        
        gbcJlblMonthlyPenalty = new GridBagConstraints();
        gbcJlblMonthlyPenalty.gridx = 0;
        gbcJlblMonthlyPenalty.gridy = 5;
        gbcJlblMonthlyPenalty.insets = defaultInsets;
        gbcJtfMonthlyPenalty = new GridBagConstraints();
        gbcJtfMonthlyPenalty.gridx = 2;
        gbcJtfMonthlyPenalty.gridy = 5;
        gbcJtfMonthlyPenalty.insets = defaultInsets;
        gbcJtfMonthlyPenalty.anchor = GridBagConstraints.WEST;
        
        gbcJlblSixthMonth = new GridBagConstraints();
        gbcJlblSixthMonth.gridx = 3;
        gbcJlblSixthMonth.gridy = 0;
        gbcJlblSixthMonth.insets = defaultInsets;
        gbcDpSixthMonthTo = new GridBagConstraints();
        gbcDpSixthMonthTo.gridx = 5;
        gbcDpSixthMonthTo.gridy = 0;
        gbcDpSixthMonthTo.insets = defaultInsets;
        
        gbcJlblSeventhMonth = new GridBagConstraints();
        gbcJlblSeventhMonth.gridx = 3;
        gbcJlblSeventhMonth.gridy = 1;
        gbcJlblSeventhMonth.insets = defaultInsets;
        gbcDpSeventhMonthTo = new GridBagConstraints();
        gbcDpSeventhMonthTo.gridx = 5;
        gbcDpSeventhMonthTo.gridy = 1;
        gbcDpSeventhMonthTo.insets = defaultInsets;
        
        gbcJlblEighthMonth = new GridBagConstraints();
        gbcJlblEighthMonth.gridx = 3;
        gbcJlblEighthMonth.gridy = 2;
        gbcJlblEighthMonth.insets = defaultInsets;
        gbcDpEighthMonthTo = new GridBagConstraints();
        gbcDpEighthMonthTo.gridx = 5;
        gbcDpEighthMonthTo.gridy = 2;
        gbcDpEighthMonthTo.insets = defaultInsets;
        
        gbcJlblNinthMonth = new GridBagConstraints();
        gbcJlblNinthMonth.gridx = 3;
        gbcJlblNinthMonth.gridy = 3;
        gbcJlblNinthMonth.insets = defaultInsets;
        gbcDpNinthMonthTo = new GridBagConstraints();
        gbcDpNinthMonthTo.gridx = 5;
        gbcDpNinthMonthTo.gridy = 3;
        gbcDpNinthMonthTo.insets = defaultInsets;
        
        gbcJlblTenthMonth = new GridBagConstraints();
        gbcJlblTenthMonth.gridx = 3;
        gbcJlblTenthMonth.gridy = 4;
        gbcJlblTenthMonth.insets= defaultInsets;
        gbcDpTenthMonthTo = new GridBagConstraints();
        gbcDpTenthMonthTo.gridx = 5;
        gbcDpTenthMonthTo.gridy = 4;
        gbcDpTenthMonthTo.insets = defaultInsets;
    }
    
    private void initModels(){
        schoolYearJCompModelLoader = new SchoolYearJCompModelLoader();
        dateLabelFormatter = new DateLabelFormatter();
        dateProperties = new Properties();
        dateProperties.put("text.today", "Today");
        dateProperties.put("text.month", "Month");
        dateProperties.put("text.year", "Year");
    }
    
    private void initComponents(){
        jpnlTopPanel = new JPanel(new GridBagLayout());
        
        jpnlControls = new JPanel(new GridBagLayout());
        
        jtfSchoolYear = new JLabel("School Year");
        jcmbSchoolYear = new JComboBox(schoolYearJCompModelLoader.getCurrentSchoolYearFrom());
        jpnlSchoolYear = new JPanel(new GridBagLayout());
        
        jpnlSemestral = new JPanel(new GridBagLayout());
        TitledBorder borderSemestral = BorderFactory.createTitledBorder("SEMESTRAL");
        borderSemestral.setTitleJustification(TitledBorder.CENTER);
        jpnlSemestral.setBorder(borderSemestral);
        jlblFirstSem = new JLabel("1st Semester Due Date");
        jlblSecondSem = new JLabel("2nd Semester Due Date");
        jpnlQuarterly = new JPanel(new GridBagLayout());
        
        TitledBorder borderQuarterly = BorderFactory.createTitledBorder("QUARTERLY");
        borderQuarterly.setTitleJustification(TitledBorder.CENTER);
        jpnlQuarterly.setBorder(borderQuarterly);
        jlblFirstQuarter = new JLabel("1st Quarter Due Date");
        jlblSecondQuarter = new JLabel("2nd Quarter Due Date");
        jlblThirdQuarter = new JLabel("3rd Quarter Due Date");
        jlblFourthQuarter = new JLabel("4th Quarter Due Date");
        
        jpnlMonthly = new JPanel(new GridBagLayout());
        TitledBorder borderMonthly = BorderFactory.createTitledBorder("MONTHLY");
        borderMonthly.setTitleJustification(TitledBorder.CENTER);
        jpnlMonthly.setBorder(borderMonthly);
        
        jpnlPeriods = new JPanel(new GridBagLayout());
        jpnlPeriods.setBorder(BorderFactory.createTitledBorder("PAYMENT SCHEDULE"));
        jlblDash = new JLabel("-");
        dpnlFirstSemTo = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnlSecondSemTo = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnlFirstQuarterTo = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnlSecondQuarterTo  = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnlThirdQuarterTo = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnlFourthQuarterTo = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnlFirstMonthTo = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnlSecondMonthTo = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnlThirdMonthTo = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnlFourthMonthTo = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnlFifthMonthTo = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnlSixthMonthTo = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnlSeventhMonthTo = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnlEighthMonthTo = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnlNinthMonthTo = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnlTenthMonthTo = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        
        dpFirstSemTo = new JDatePickerImpl(dpnlFirstSemTo, dateLabelFormatter);
        dpSecondSemTo = new JDatePickerImpl(dpnlSecondSemTo, dateLabelFormatter);
        dpFirstQuarterTo = new JDatePickerImpl(dpnlFirstQuarterTo, dateLabelFormatter);
        dpSecondQuarterTo = new JDatePickerImpl(dpnlSecondQuarterTo, dateLabelFormatter);
        dpThirdQuarterTo = new JDatePickerImpl(dpnlThirdQuarterTo, dateLabelFormatter);
        dpFourthQuarterTo = new JDatePickerImpl(dpnlFourthQuarterTo, dateLabelFormatter);
        
        dpFirstMonthTo = new JDatePickerImpl(dpnlFirstMonthTo,dateLabelFormatter);
        dpSecondMonthTo = new JDatePickerImpl(dpnlSecondMonthTo,dateLabelFormatter);
        dpThirdMonthTo = new JDatePickerImpl(dpnlThirdMonthTo,dateLabelFormatter);
        dpFourthMonthTo = new JDatePickerImpl(dpnlFourthMonthTo,dateLabelFormatter);
        dpFifthMonthTo = new JDatePickerImpl(dpnlFifthMonthTo,dateLabelFormatter);
        dpSixthMonthTo = new JDatePickerImpl(dpnlSixthMonthTo,dateLabelFormatter);
        dpSeventhMonthTo = new JDatePickerImpl(dpnlSeventhMonthTo,dateLabelFormatter);
        dpEighthMonthTo = new JDatePickerImpl(dpnlEighthMonthTo,dateLabelFormatter);
        dpNinthMonthTo = new JDatePickerImpl(dpnlNinthMonthTo,dateLabelFormatter);
        dpTenthMonthTo = new JDatePickerImpl(dpnlTenthMonthTo,dateLabelFormatter);
        
        jlblFirstMonth = new JLabel("1st Month Due Date");
        jlblSecondMonth = new JLabel("2nd Month Due Date");
        jlblThirdMonth = new JLabel("3rd Month Due Date");
        jlblFourthMonth = new JLabel("4th Month Due Date");
        jlblFifthMonth = new JLabel("5th Month Due Date");
        jlblSixthMonth = new JLabel("6th Month Due Date");
        jlblSeventhMonth = new JLabel("7th Month Due Date");
        jlblEighthMonth = new JLabel("8th Month Due Date");
        jlblNinthMonth = new JLabel("9th Month Due Date");
        jlblTenthMonth = new JLabel("10th Month Due Date");
        
        jlblSemestralPenalty = new JLabel("PENALTY AMOUNT");
        jtfSemestralPenalty = new JTextField(10);
        jlblQuarterlyPenalty = new JLabel("PENALTY AMOUNT");
        jtfQuarterlyPenalty = new JTextField(10);
        jlblMonthlyPenalty = new JLabel("PENALTY AMOUNT");
        jtfMonthlyPenalty = new JTextField(10);
        
        jbtnSave = new JButton("Save");
    }
    
    private void createGUI(){
        this.add(jpnlTopPanel,gbcJpnlTopPanel);
        jpnlSchoolYear.add(jtfSchoolYear);
        jpnlSchoolYear.add(jcmbSchoolYear);
        
        jpnlSemestral.add(jlblFirstSem,gbcJlblFirstSem);
        jpnlSemestral.add(dpFirstSemTo,gbcDpFirstSemTo);
        
        jpnlSemestral.add(jlblSecondSem,gbcJlblSecondSem);
        jpnlSemestral.add(dpSecondSemTo,gbcDpSecondSemTo);
        
        jpnlSemestral.add(jlblSemestralPenalty,gbcJlblSemestralPenalty);
        jpnlSemestral.add(jtfSemestralPenalty,gbcJtfSemestralPenalty);
        
        jpnlPeriods.add(jpnlSemestral,gbcJpnlSemestral);
        
        jpnlQuarterly.add(jlblFirstQuarter,gbcJlblFirstQuarter);
        jpnlQuarterly.add(dpFirstQuarterTo,gbcDpFirstQuarterTo);
        
        jpnlQuarterly.add(jlblSecondQuarter,gbcJlblSecondQuarter);
        jpnlQuarterly.add(dpSecondQuarterTo,gbcDpSecondQuarterTo);
        
        jpnlQuarterly.add(jlblThirdQuarter,gbcJlblThirdQuarter);
        jpnlQuarterly.add(dpThirdQuarterTo,gbcDpThirdQuarterTo);
        
        jpnlQuarterly.add(jlblFourthQuarter,gbcJlblFourthQuarter);
        jpnlQuarterly.add(dpFourthQuarterTo,gbcDpFourthQuarterTo);
        
        jpnlQuarterly.add(jlblQuarterlyPenalty,gbcJlblQuarterlyPenalty);
        jpnlQuarterly.add(jtfQuarterlyPenalty,gbcJtfQuarterlyPenalty);
        
        jpnlMonthly.add(jlblFirstMonth,gbcJlblFirstMonth);
        jpnlMonthly.add(dpFirstMonthTo,gbcDpFirstMonthTo);
        
        jpnlMonthly.add(jlblSecondMonth,gbcJlblSecondMonth);
        jpnlMonthly.add(dpSecondMonthTo,gbcDpSecondMonthTo);
        
        jpnlMonthly.add(jlblThirdMonth,gbcJlblThirdMonth);
        jpnlMonthly.add(dpThirdMonthTo,gbcDpThirdMonthTo);
        
        jpnlMonthly.add(jlblFourthMonth,gbcJlblFourthMonth);
        jpnlMonthly.add(dpFourthMonthTo,gbcDpFourthMonthTo);
        
        jpnlMonthly.add(jlblFifthMonth,gbcJlblFifthMonth);
        jpnlMonthly.add(dpFifthMonthTo,gbcDpFifthMonthTo);
        
        jpnlMonthly.add(jlblSixthMonth,gbcJlblSixthMonth);
        jpnlMonthly.add(dpSixthMonthTo,gbcDpSixthMonthTo);
        
        jpnlMonthly.add(jlblSeventhMonth,gbcJlblSeventhMonth);
        jpnlMonthly.add(dpSeventhMonthTo,gbcDpSeventhMonthTo);
        
        jpnlMonthly.add(jlblEighthMonth,gbcJlblEighthMonth);
        jpnlMonthly.add(dpEighthMonthTo,gbcDpEighthMonthTo);
        
        jpnlMonthly.add(jlblNinthMonth,gbcJlblNinthMonth);
        jpnlMonthly.add(dpNinthMonthTo,gbcDpNinthMonthTo);
        
        jpnlMonthly.add(jlblTenthMonth,gbcJlblTenthMonth);
        jpnlMonthly.add(dpTenthMonthTo,gbcDpTenthMonthTo);
        
        jpnlMonthly.add(jlblMonthlyPenalty,gbcJlblMonthlyPenalty);
        jpnlMonthly.add(jtfMonthlyPenalty,gbcJtfMonthlyPenalty);
        
        jpnlPeriods.add(jpnlQuarterly,gbcJpnlQuarterly);
        
        jpnlPeriods.add(jpnlMonthly,gbcJpnlMonthly);
        
        jpnlControls.add(jbtnSave);
        
        jpnlTopPanel.add(jpnlSchoolYear,gbcJpnlSchoolYear);
        jpnlTopPanel.add(jpnlPeriods,gbcJpnlPeriods);
        jpnlTopPanel.add(jpnlControls,gbcJpnlControls);
    } 
}
