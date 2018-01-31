package view.schoolyear;

import component_model_loader.SchoolYearJCompModelLoader;
import controller.schoolyear.CreateSchoolYear;
import daoimpl.SchoolYearDaoImpl;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.schoolyear.SchoolYear;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import utility.calendar.CalendarUtil;
import utility.component.JSpinnerUtil;
import utility.date.DateLabelFormatter;
import utility.initializer.Initializer;

/**
 *
 * @author Jordan
 */
public class DialogSchoolYearCrud extends JDialog implements Initializer{
    
    private SchoolYearDaoImpl schoolYearDaoImpl;
    private SchoolYearJCompModelLoader schoolYearJCompModelLoader;
    private Insets defaultInsets;
    
    private JPanel jpnlTopPanel;
    private GridBagConstraints gbcJpnlTopPanel;
    private JPanel jpnlControls;
    private GridBagConstraints gbcJpnlControls;
    private JPanel jpnlSchoolYear;
    private GridBagConstraints gbcJpnlSchoolYear;
    
    private JPanel jpnlSummerClassSchedule;
    private JLabel jlblSummerClassStart;
    private JDatePanelImpl dpnlSummerClassStart;
    private JDatePickerImpl dpSummerClassStart;
    private JLabel jlblSummerClassEnd;
    private JDatePanelImpl dpnlSummerClassEnd;
    private JDatePickerImpl dpSummerClassEnd;
    
    private JLabel jlblSchoolYearStartDate;
    private JLabel jlblSchoolYearEndDate;
    
    private JPanel jpnlEnrollmentSchedule;
    private JPanel jpnlRegularEnrollmentSchedule;
    private JPanel jpnlSummerEnrollmentSchedule;
    
    private JLabel jlblRegularEnrollmentStartDate;
    private JLabel jlblRegularEnrollmentEndDate;
    
    private JLabel jlblSummerEnrollmentStartDate;
    private JLabel jlblSummerEnrollmentEndDate;
    
    private JPanel jpnlQuarterScheduleAndGradingDueDate;
    private JPanel jpnlContainer;
    
    private JLabel jlbl1stQtrStartDate;
    private JLabel jlbl1stQtrEndDate;
    private JLabel jlbl1stQtrGradingDueDate;
    
    private JLabel jlbl2ndQtrStartDate;
    private JLabel jlbl2ndQtrEndDate;
    private JLabel jlbl2ndQtrGradingDueDate;
    
    private JLabel jlbl3rdQtrStartDate;
    private JLabel jlbl3rdQtrEndDate;
    private JLabel jlbl3rdQtrGradingDueDate;
    
    private JLabel jlbl4thQtrStartDate;
    private JLabel jlbl4thQtrEndDate;
    private JLabel jlbl4thQtrGradingDueDate;
    
    private JLabel jlblDash;
    
    private Properties dateProperties;
    private DateLabelFormatter dateLabelFormatter;
    
    private JDatePanelImpl dpnlSchoolYearStartDate;
    private JDatePanelImpl dpnlSchoolYearEndDate;
    
    private JDatePanelImpl dpnlRegularEnrollmentStartDate;
    private JDatePanelImpl dpnlRegularEnrollmentEndDate;
    private JDatePanelImpl dpnlSummerEnrollmentStartDate;
    private JDatePanelImpl dpnlSummerEnrollmentEndDate;
    
    private JDatePanelImpl dpnl1stQtrStartDate;
    private JDatePanelImpl dpnl2ndQtrStartDate;
    private JDatePanelImpl dpnl3rdQtrStartDate;
    private JDatePanelImpl dpnl4thQtrStartDate;
    
    private JDatePanelImpl dpnl1stQtrGradingDueDate;
    private JDatePanelImpl dpnl2ndQtrGradingDueDate;
    private JDatePanelImpl dpnl3rdQtrGradingDueDate;
    private JDatePanelImpl dpnl4thQtrGradingDueDate;
    
    private JDatePanelImpl dpnl1stQtrEndDate;
    private JDatePanelImpl dpnl2ndQtrEndDate;
    private JDatePanelImpl dpnl3rdQtrEndDate;
    private JDatePanelImpl dpnl4thQtrEndDate;
    
    private JDatePickerImpl dpSchoolYearStartDate;
    private JDatePickerImpl dpSchoolYearEndDate;
    
    private JDatePickerImpl dpRegularEnrollmentStartDate;
    private JDatePickerImpl dpRegularEnrollmentEndDate;
    private JDatePickerImpl dpSummerEnrollmentStartDate;
    private JDatePickerImpl dpSummerEnrollmentEndDate;
    
    private JDatePickerImpl dp1stQtrStartDate;
    private JDatePickerImpl dp1stQtrEndDate;
    private JDatePickerImpl dp1stQtrGradingDuedate;
    
    private JDatePickerImpl dp2ndQtrStartDate;
    private JDatePickerImpl dp2ndQtrEndDate;
    private JDatePickerImpl dp2ndQtrGradingDueDate;
    
    private JDatePickerImpl dp3rdQtrStartDate;
    private JDatePickerImpl dp3rdQtrEndDate;
    private JDatePickerImpl dp3rdQtrGradingDueDate;
    
    private JDatePickerImpl dp4thQtrStartDate;
    private JDatePickerImpl dp4thQtrEndDate;
    private JDatePickerImpl dp4thQtrGradingDueDate;
    
    private JLabel jlblYearFrom;
    private JLabel jlblYearTo;
    private JSpinner jsprYearFrom;
    private JSpinner jsprYearTo;
    
    private JButton jbtnSave;
    private JLabel jlblStatus;
    private JComboBox jcmbStatus;
    
    private int schoolYearIdOfSelected;
    private String action;
    
    public DialogSchoolYearCrud(Frame parent, boolean modal, String action){
        this.action = action;
        initModels();
        initComponents();
        
        initGridBagConstraints();
        initJCompModelLoaders();
        initRenderers();
        initViewComponents();
        initControllers();
        initDaoImpl();
        
        createGUI();
    }
    
    public DialogSchoolYearCrud(Frame parent, boolean modal, String action, int schoolYearIdOfSelected){
        this.action = action;
        this.schoolYearIdOfSelected = schoolYearIdOfSelected;
        initModels();
        initComponents();
        
        initGridBagConstraints();
        initJCompModelLoaders();
        initRenderers();
        initControllers();
        initDaoImpl();
        
        createGUI();
        
        initForm();
        initViewComponents();
    }

    @Override
    public void initRenderers() {
    }
    
    @Override
    public void initJCompModelLoaders() {
        schoolYearJCompModelLoader = new SchoolYearJCompModelLoader();
    }

    @Override
    public void initViewComponents() {
        if(action.equalsIgnoreCase("create")){
            jlblStatus.setVisible(false);
            jcmbStatus.setVisible(false);
        }else if(action.equalsIgnoreCase("edit")){
            
        }else if(action.equalsIgnoreCase("view")){
            disableFields();
        }
    }

    @Override
    public void initControllers() {
        if (action.equalsIgnoreCase("create")) {
            jbtnSave.addActionListener(new CreateSchoolYear(
                    this, dpSchoolYearStartDate, dpSchoolYearEndDate, dpRegularEnrollmentStartDate,
                    dpRegularEnrollmentEndDate, dpSummerEnrollmentStartDate, dpSummerEnrollmentEndDate,
                    dp1stQtrStartDate, dp1stQtrEndDate, dp1stQtrGradingDuedate, dp2ndQtrStartDate,
                    dp2ndQtrEndDate, dp2ndQtrGradingDueDate, dp3rdQtrStartDate, dp3rdQtrEndDate,
                    dp3rdQtrGradingDueDate, dp4thQtrStartDate, dp4thQtrEndDate, dp4thQtrGradingDueDate,
                    jlblStatus, jcmbStatus, jsprYearFrom, jsprYearTo, dpSummerClassStart, dpSummerClassEnd)
            );
        }
        
        jsprYearFrom.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jsprYearTo.setValue(Integer.parseInt(jsprYearFrom.getValue().toString())+1);
                setAllDatePickerToYearFromSelected(Integer.parseInt(jsprYearFrom.getValue().toString()));
            }
        });
    }

    @Override
    public void initDaoImpl() {
        schoolYearDaoImpl = new SchoolYearDaoImpl();
    }
    
    
    @Override
    public void initGridBagConstraints(){
        this.setLayout(new GridBagLayout());
        this.setModal(true);
        defaultInsets = new Insets(3, 3, 3, 3);
    }
    
    private GridBagConstraints setPosition(int gridX, int gridY, double weightX, double weightY, int gbcFillValue) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridX;
        gbc.gridy = gridY;
        gbc.weightx = weightX;
        gbc.weighty = weightY;
        gbc.insets = defaultInsets;
        gbc.fill = gbcFillValue;
        return gbc;
    }
    
    @Override
    public void initModels(){
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
        jpnlSchoolYear = new JPanel(new GridBagLayout());
        
        TitledBorder borderSchoolYear = BorderFactory.createTitledBorder("SCHOOL YEAR");
        borderSchoolYear.setTitleJustification(TitledBorder.CENTER);
        jpnlSchoolYear.setBorder(borderSchoolYear);
        jlblSchoolYearStartDate = new JLabel("START DATE");
        jlblSchoolYearEndDate = new JLabel("END DATE");
        
        jpnlEnrollmentSchedule = new JPanel(new GridBagLayout());
        TitledBorder borderEnrollmentSchedule = BorderFactory.createTitledBorder("ENROLLMENT SCHEDULE");
        borderEnrollmentSchedule.setTitleJustification(TitledBorder.CENTER);
        jpnlEnrollmentSchedule.setBorder(borderEnrollmentSchedule);

        jpnlRegularEnrollmentSchedule = new JPanel(new GridBagLayout());
        TitledBorder borderRegularEnrollment = BorderFactory.createTitledBorder("REGULAR ENROLLMENT");
        borderRegularEnrollment.setTitleJustification(TitledBorder.CENTER);
        jpnlRegularEnrollmentSchedule.setBorder(borderRegularEnrollment);
        
        jpnlSummerEnrollmentSchedule = new JPanel(new GridBagLayout());
        TitledBorder borderSummerEnrollment = BorderFactory.createTitledBorder("SUMMER ENROLLMENT");
        borderSummerEnrollment.setTitleJustification(TitledBorder.CENTER);
        jpnlSummerEnrollmentSchedule.setBorder(borderSummerEnrollment);
        
        jlblRegularEnrollmentStartDate = new JLabel("START DATE");
        jlblRegularEnrollmentEndDate = new JLabel("END DATE");
        jlblSummerEnrollmentStartDate = new JLabel("START DATE");
        jlblSummerEnrollmentEndDate = new JLabel("END DATE");
        
        jpnlQuarterScheduleAndGradingDueDate = new JPanel(new GridBagLayout());
        TitledBorder borderQuarterAndGradingDueDate = BorderFactory.createTitledBorder("QUARTER SCHEDULE AND GRADING DUE DATE");
        borderQuarterAndGradingDueDate.setTitleJustification(TitledBorder.CENTER);
        jpnlQuarterScheduleAndGradingDueDate.setBorder(borderQuarterAndGradingDueDate);
        
        jpnlSummerClassSchedule = new JPanel(new GridBagLayout());
        TitledBorder borderSummerClassSchedule = BorderFactory.createTitledBorder("SUMMER CLASS SCHEDULE");
        borderSummerClassSchedule.setTitleJustification(TitledBorder.CENTER);
        jpnlSummerClassSchedule.setBorder(borderSummerClassSchedule);
        
        jlblSummerClassStart = new JLabel("START");
        dpnlSummerClassStart = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpSummerClassStart = new JDatePickerImpl(dpnlSummerClassStart, dateLabelFormatter);
        jlblSummerClassEnd = new JLabel("End");
        dpnlSummerClassEnd = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpSummerClassEnd = new JDatePickerImpl(dpnlSummerClassEnd, dateLabelFormatter);
        
        jpnlContainer = new JPanel(new GridBagLayout());
        jpnlContainer.setBorder(BorderFactory.createTitledBorder("SCHOOL YEAR"));
        jlblDash = new JLabel("-");
        
        dpnlSchoolYearStartDate = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnlSchoolYearEndDate = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        
        dpnlRegularEnrollmentStartDate = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnlRegularEnrollmentEndDate = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnlSummerEnrollmentStartDate = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnlSummerEnrollmentEndDate = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        
        dpnl1stQtrStartDate = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnl2ndQtrStartDate = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnl3rdQtrStartDate = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnl4thQtrStartDate = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        
        dpnl1stQtrGradingDueDate = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnl2ndQtrGradingDueDate = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnl3rdQtrGradingDueDate = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnl4thQtrGradingDueDate = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        
        dpnl1stQtrEndDate = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnl2ndQtrEndDate = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnl3rdQtrEndDate = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        dpnl4thQtrEndDate = new JDatePanelImpl(new UtilDateModel(), dateProperties);
        
        dpSchoolYearStartDate = new JDatePickerImpl(dpnlSchoolYearStartDate, dateLabelFormatter);
        dpSchoolYearEndDate = new JDatePickerImpl(dpnlSchoolYearEndDate, dateLabelFormatter);
        
        dpRegularEnrollmentStartDate = new JDatePickerImpl(dpnlRegularEnrollmentStartDate, dateLabelFormatter);
        dpRegularEnrollmentEndDate = new JDatePickerImpl(dpnlRegularEnrollmentEndDate, dateLabelFormatter);
        dpSummerEnrollmentStartDate = new JDatePickerImpl(dpnlSummerEnrollmentStartDate, dateLabelFormatter);
        dpSummerEnrollmentEndDate = new JDatePickerImpl(dpnlSummerEnrollmentEndDate, dateLabelFormatter);
        
        dp1stQtrStartDate = new JDatePickerImpl(dpnl1stQtrStartDate,dateLabelFormatter);
        dp1stQtrEndDate = new JDatePickerImpl(dpnl1stQtrEndDate,dateLabelFormatter);
        dp1stQtrGradingDuedate = new JDatePickerImpl(dpnl1stQtrGradingDueDate,dateLabelFormatter);
        
        dp2ndQtrStartDate = new JDatePickerImpl(dpnl2ndQtrStartDate,dateLabelFormatter);
        dp2ndQtrEndDate = new JDatePickerImpl(dpnl2ndQtrEndDate,dateLabelFormatter);
        dp2ndQtrGradingDueDate = new JDatePickerImpl(dpnl2ndQtrGradingDueDate,dateLabelFormatter);
        
        dp3rdQtrStartDate = new JDatePickerImpl(dpnl3rdQtrStartDate,dateLabelFormatter);
        dp3rdQtrEndDate = new JDatePickerImpl(dpnl3rdQtrEndDate,dateLabelFormatter);
        dp3rdQtrGradingDueDate = new JDatePickerImpl(dpnl3rdQtrGradingDueDate, dateLabelFormatter);
        
        dp4thQtrStartDate = new JDatePickerImpl(dpnl4thQtrStartDate,dateLabelFormatter);
        dp4thQtrEndDate = new JDatePickerImpl(dpnl4thQtrEndDate,dateLabelFormatter);
        dp4thQtrGradingDueDate = new JDatePickerImpl(dpnl4thQtrGradingDueDate, dateLabelFormatter);
        
        jlbl1stQtrStartDate = new JLabel("1st QTR START DATE");
        jlbl1stQtrEndDate = new JLabel("1st QTR END DATE");
        
        jlbl2ndQtrStartDate = new JLabel("2nd QTR START DATE");
        jlbl2ndQtrEndDate = new JLabel("2nd QTR END DATE");
        
        jlbl3rdQtrStartDate = new JLabel("3rd QTR START DATE");
        jlbl3rdQtrEndDate = new JLabel("3rd QTR END DATE");
        
        jlbl4thQtrStartDate = new JLabel("4th QTR START DATE");
        jlbl4thQtrEndDate = new JLabel("4th QTR END DATE");
        
        jlbl1stQtrGradingDueDate = new JLabel("Grading Due Date");
        jlbl2ndQtrGradingDueDate = new JLabel("Grading Due Date");
        jlbl3rdQtrGradingDueDate = new JLabel("Grading Due Date");
        jlbl4thQtrGradingDueDate = new JLabel("Grading Due Date");
        
        jbtnSave = new JButton("Save");
        jlblStatus = new JLabel("Active");
        jcmbStatus = new JComboBox(new Object[]{"Yes","No"});
        
        jlblYearFrom = new JLabel("Year From");
        jlblYearTo = new JLabel("Year To");
        
        int currentYear = CalendarUtil.getCurrentYear();
        int min = CalendarUtil.getCurrentYear();
        int max = (currentYear + 10);
        int stepSize = 1;
        
        SpinnerNumberModel yearFromModel = new SpinnerNumberModel(currentYear, min, max, stepSize);
        jsprYearFrom = new JSpinner();
        jsprYearFrom.setModel(yearFromModel);
        JSpinner.NumberEditor yearFromEditor = new JSpinner.NumberEditor(jsprYearFrom, "#");
        jsprYearFrom.setEditor(yearFromEditor);

        SpinnerNumberModel yearToModel = new SpinnerNumberModel(currentYear+1,min+1,max+1,stepSize);
        jsprYearTo = new JSpinner();
        jsprYearTo.setModel(yearToModel);
        JSpinner.NumberEditor yearToEditor = new JSpinner.NumberEditor(jsprYearTo, "#");
        jsprYearTo.setEditor(yearToEditor);
        JSpinnerUtil.setDisabledForegroundColorTo(jsprYearTo, Color.BLACK);
        
        jsprYearTo.setEnabled(false);
        JSpinnerUtil.setDisabledForegroundColorTo(jsprYearTo, Color.BLACK);
    }
    
    private void setAllDatePickerToYearFromSelected(int spinnerYearFromValue){
        List<Component[]> componentsArr = new ArrayList<>();
        componentsArr.add(jpnlSchoolYear.getComponents());
        componentsArr.add(jpnlRegularEnrollmentSchedule.getComponents());
        componentsArr.add(jpnlSummerEnrollmentSchedule.getComponents());
        componentsArr.add(jpnlQuarterScheduleAndGradingDueDate.getComponents());
        componentsArr.add(jpnlSummerClassSchedule.getComponents());
        for (int i = 0; i < componentsArr.size(); i++) {
            for (Component c : componentsArr.get(i)) {
                if (c instanceof JDatePickerImpl) {
                    ((JDatePickerImpl) c).getModel().setYear(spinnerYearFromValue);
                }
            }
        }
    }
    
    private void createGUI(){
        this.add(jpnlTopPanel,gbcJpnlTopPanel);
        
        jpnlSchoolYear.add(jlblSchoolYearStartDate,setPosition(0, 0, 0, 0, GridBagConstraints.NONE));
        jpnlSchoolYear.add(dpSchoolYearStartDate,setPosition(1, 0, 0, 0, GridBagConstraints.NONE));
        jpnlSchoolYear.add(jlblSchoolYearEndDate,setPosition(2, 0, 0, 0, GridBagConstraints.NONE));
        jpnlSchoolYear.add(dpSchoolYearEndDate,setPosition(3, 0, 0, 0, GridBagConstraints.NONE));
        jpnlSchoolYear.add(jlblStatus,setPosition(4, 0, 0, 0, GridBagConstraints.NONE));
        jpnlSchoolYear.add(jcmbStatus,setPosition(5, 0, 0, 0, GridBagConstraints.NONE));
        jpnlSchoolYear.add(jlblYearFrom,setPosition(6, 0, 0, 0, GridBagConstraints.NONE));
        jpnlSchoolYear.add(jsprYearFrom,setPosition(7, 0, 0, 0, GridBagConstraints.NONE));
        jpnlSchoolYear.add(jlblYearTo,setPosition(8, 0, 0, 0, GridBagConstraints.NONE));
        jpnlSchoolYear.add(jsprYearTo,setPosition(9, 0, 0, 0, GridBagConstraints.NONE));
        
        jpnlEnrollmentSchedule.add(jpnlRegularEnrollmentSchedule,setPosition(0, 0, 0.5, 0.5, GridBagConstraints.HORIZONTAL));
        jpnlEnrollmentSchedule.add(jpnlSummerEnrollmentSchedule,setPosition(1, 0, 0.5, 0.5, GridBagConstraints.HORIZONTAL));
        
        jpnlRegularEnrollmentSchedule.add(jlblRegularEnrollmentStartDate,setPosition(0, 0, 0, 0, GridBagConstraints.NONE));
        jpnlRegularEnrollmentSchedule.add(dpRegularEnrollmentStartDate,setPosition(1, 0, 0, 0, GridBagConstraints.NONE));
        jpnlRegularEnrollmentSchedule.add(jlblRegularEnrollmentEndDate,setPosition(2, 0, 0, 0, GridBagConstraints.NONE));
        jpnlRegularEnrollmentSchedule.add(dpRegularEnrollmentEndDate,setPosition(3, 0, 0, 0, GridBagConstraints.NONE));
        
        jpnlSummerEnrollmentSchedule.add(jlblSummerEnrollmentStartDate,setPosition(0, 0, 0, 0, GridBagConstraints.NONE));
        jpnlSummerEnrollmentSchedule.add(dpSummerEnrollmentStartDate,setPosition(1, 0, 0, 0, GridBagConstraints.NONE));
        jpnlSummerEnrollmentSchedule.add(jlblSummerEnrollmentEndDate,setPosition(2, 0, 0, 0, GridBagConstraints.NONE));
        jpnlSummerEnrollmentSchedule.add(dpSummerEnrollmentEndDate,setPosition(3, 0, 0, 0, GridBagConstraints.NONE));
        
        jpnlQuarterScheduleAndGradingDueDate.add(jlbl1stQtrStartDate,setPosition(0, 0, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(dp1stQtrStartDate,setPosition(1, 0, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(jlbl1stQtrEndDate,setPosition(2, 0, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(dp1stQtrEndDate,setPosition(3, 0, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(jlbl1stQtrGradingDueDate,setPosition(4, 0, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(dp1stQtrGradingDuedate,setPosition(5, 0, 0, 0, GridBagConstraints.NONE));
        
        jpnlQuarterScheduleAndGradingDueDate.add(jlbl2ndQtrStartDate,setPosition(0, 1, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(dp2ndQtrStartDate,setPosition(1, 1, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(jlbl2ndQtrEndDate,setPosition(2, 1, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(dp2ndQtrEndDate,setPosition(3, 1, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(jlbl2ndQtrGradingDueDate,setPosition(4, 1, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(dp2ndQtrGradingDueDate,setPosition(5, 1, 0, 0, GridBagConstraints.NONE));
        
        jpnlQuarterScheduleAndGradingDueDate.add(jlbl3rdQtrStartDate,setPosition(0, 2, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(dp3rdQtrStartDate,setPosition(1, 2, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(jlbl3rdQtrEndDate,setPosition(2, 2, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(dp3rdQtrEndDate,setPosition(3, 2, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(jlbl3rdQtrGradingDueDate,setPosition(4, 2, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(dp3rdQtrGradingDueDate, setPosition(5, 2, 0, 0, GridBagConstraints.NONE));
        
        jpnlQuarterScheduleAndGradingDueDate.add(jlbl4thQtrStartDate,setPosition(0, 3, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(dp4thQtrStartDate,setPosition(1, 3, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(jlbl4thQtrEndDate,setPosition(2, 3, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(dp4thQtrEndDate,setPosition(3, 3, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(jlbl4thQtrGradingDueDate,setPosition(4, 3, 0, 0, GridBagConstraints.NONE));
        jpnlQuarterScheduleAndGradingDueDate.add(dp4thQtrGradingDueDate,setPosition(5, 3, 0, 0, GridBagConstraints.NONE));
        
        jpnlSummerClassSchedule.add(jlblSummerClassStart,setPosition(0, 0, 0, 0, GridBagConstraints.NONE));
        jpnlSummerClassSchedule.add(dpSummerClassStart,setPosition(1, 0, 0, 0, GridBagConstraints.NONE));
        jpnlSummerClassSchedule.add(jlblSummerClassEnd,setPosition(2, 0, 0, 0, GridBagConstraints.NONE));
        jpnlSummerClassSchedule.add(dpSummerClassEnd,setPosition(3, 0, 0, 0, GridBagConstraints.NONE));
        
        jpnlContainer.add(jpnlSchoolYear,setPosition(0, 0, 0.5, 0, GridBagConstraints.HORIZONTAL));
        jpnlContainer.add(jpnlEnrollmentSchedule,setPosition(0, 1, 0.5, 0, GridBagConstraints.HORIZONTAL));
        jpnlContainer.add(jpnlQuarterScheduleAndGradingDueDate,setPosition(0, 2, 0.5, 0, GridBagConstraints.HORIZONTAL));
        jpnlContainer.add(jpnlSummerClassSchedule,setPosition(0, 3, 0.5, 0, GridBagConstraints.HORIZONTAL));
        
        jpnlControls.add(jbtnSave,setPosition(0, 0, 0, 0, GridBagConstraints.NONE));
        
        jpnlTopPanel.add(jpnlContainer,setPosition(0, 0, 0.5, 0.5, GridBagConstraints.BOTH));
        jpnlTopPanel.add(jpnlControls,setPosition(0, 4, 0.5, 0.5, GridBagConstraints.HORIZONTAL));
    } 
    
    private int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String calendarString = sdf.format(calendar.getTime());
        int year = calendar.get(Calendar.YEAR);
        return year;
    }
    
    private int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String calendarString = sdf.format(calendar.getTime());
        int month = calendar.get(Calendar.MONTH);
//        System.out.println("month: "+month);
        return month;
    }
    
    private int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String calendarString = sdf.format(calendar.getTime());
        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        System.out.println("Day: "+day);
        return day;
    }
    
    private void initForm(){
        SchoolYear sy = new SchoolYear();
        sy = schoolYearDaoImpl.getSchoolYearById(schoolYearIdOfSelected);
        
        Date syStartDate = sy.getSchoolYearStartDate();
        Date syEndDate = sy.getSchoolYearEndDate();
        Date enrollmentStart = sy.getRegularEnrollmentStartDate();
        Date enrollmentEnd = sy.getRegularEnrollmentEndDate();
        Date summerEnrollmentStart = sy.getSummerEnrollmentStartDate();
        Date summerEnrollmentEnd = sy.getSummerEnrollmentEndDate();
        Date summerClassStart = sy.getSummerClassStartDate();
        Date summerClassEnd = sy.getSummerClassEndDate();
        Date firstQStart = sy.getQuarters().get(0).getQuarterNo() == 1? sy.getQuarters().get(0).getStartDate() : new Date();
        Date firstQEnd = sy.getQuarters().get(0).getQuarterNo() == 1? sy.getQuarters().get(0).getStartDate() : new Date();
        Date firstQGradingDueDate = sy.getQuarters().get(0).getQuarterNo() == 1? sy.getQuarters().get(0).getGradingDueDate() : new Date();
        
        Date secondQStart = sy.getQuarters().get(1).getQuarterNo() == 2? sy.getQuarters().get(1).getStartDate() : new Date();
        Date secondQEnd = sy.getQuarters().get(1).getQuarterNo() == 2? sy.getQuarters().get(1).getStartDate() : new Date();
        Date secondQGradingDueDate = sy.getQuarters().get(1).getQuarterNo() == 2? sy.getQuarters().get(1).getGradingDueDate() : new Date();
        
        Date thirdQStart = sy.getQuarters().get(2).getQuarterNo() == 3? sy.getQuarters().get(2).getStartDate() : new Date();
        Date thirdQEnd = sy.getQuarters().get(2).getQuarterNo() == 3? sy.getQuarters().get(2).getStartDate() : new Date();
        Date thirdQGradingDueDate = sy.getQuarters().get(2).getQuarterNo() == 3? sy.getQuarters().get(2).getGradingDueDate() : new Date();
        
        Date fourthQStart = sy.getQuarters().get(3).getQuarterNo() == 4? sy.getQuarters().get(3).getStartDate() : new Date();
        Date fourthQEnd = sy.getQuarters().get(3).getQuarterNo() == 4? sy.getQuarters().get(3).getStartDate() : new Date();
        Date fourthQGradingDueDate = sy.getQuarters().get(3).getQuarterNo() == 4? sy.getQuarters().get(3).getGradingDueDate() : new Date();
       
//        System.out.println("Date: "+syStartDate);
        
        dpSchoolYearStartDate.getJFormattedTextField().setText(syStartDate+"");
        dpSchoolYearEndDate.getJFormattedTextField().setText(syEndDate+"");
        dpRegularEnrollmentStartDate.getJFormattedTextField().setText(enrollmentStart+"");
        dpRegularEnrollmentEndDate.getJFormattedTextField().setText(enrollmentEnd+"");
        dpSummerEnrollmentStartDate.getJFormattedTextField().setText(summerEnrollmentStart+"");
        dpSummerEnrollmentEndDate.getJFormattedTextField().setText(summerEnrollmentEnd+"");
        dpSummerClassStart.getJFormattedTextField().setText(summerClassStart+"");
        dpSummerClassEnd.getJFormattedTextField().setText(summerClassEnd+"");
        dp1stQtrStartDate.getJFormattedTextField().setText(firstQStart+"");
        dp1stQtrEndDate.getJFormattedTextField().setText(firstQEnd+"");
        dp1stQtrGradingDuedate.getJFormattedTextField().setText(firstQGradingDueDate+"");
        dp2ndQtrStartDate.getJFormattedTextField().setText(secondQStart+"");
        dp2ndQtrEndDate.getJFormattedTextField().setText(secondQEnd+"");
        dp2ndQtrGradingDueDate.getJFormattedTextField().setText(secondQGradingDueDate+"");
        dp3rdQtrStartDate.getJFormattedTextField().setText(thirdQStart+"");
        dp3rdQtrEndDate.getJFormattedTextField().setText(thirdQEnd+"");
        dp3rdQtrGradingDueDate.getJFormattedTextField().setText(thirdQGradingDueDate+"");
        dp4thQtrStartDate.getJFormattedTextField().setText(fourthQStart+"");
        dp4thQtrEndDate.getJFormattedTextField().setText(fourthQEnd+"");
        dp4thQtrGradingDueDate.getJFormattedTextField().setText(fourthQGradingDueDate+"");
    }
    
    private void disableFields(){
        List<Component[]> componentsArr = new ArrayList<>();
        componentsArr.add(jpnlSchoolYear.getComponents());
        componentsArr.add(jpnlRegularEnrollmentSchedule.getComponents());
        componentsArr.add(jpnlSummerEnrollmentSchedule.getComponents());
        componentsArr.add(jpnlQuarterScheduleAndGradingDueDate.getComponents());
        for (int i = 0; i < componentsArr.size(); i++) {
            for (Component c : componentsArr.get(i)) {
                if (c instanceof JDatePickerImpl) {
                    ((JDatePickerImpl) c).setEnabled(false);
                }
                else if(c instanceof JDatePanelImpl){
                    ((JDatePanelImpl) c).setEnabled(false);
                }
                else if(c instanceof JComboBox){
                    ((JComboBox) c).setEnabled(false);
                }
                else if(c instanceof JSpinner){
                    ((JSpinner) c).setEnabled(false);
                }
            }
        }
    }
    
  
}
