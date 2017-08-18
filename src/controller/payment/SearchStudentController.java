package controller.payment;

import component_model_loader.BalanceBreakDownML;
import component_model_loader.SchoolFeesML;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.SchoolFeesDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.StudentDaoImpl;
import daoimpl.TuitionFeeDaoImpl;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.discount.Discount;
import model.paymentterm.PaymentTerm;
import model.schoolfees.SchoolFees;
import model.schoolyear.SchoolYear;
import model.student.Student;
import model.tuitionfee.TuitionFee;
import service.TuitionFeeProcessor;
import utility.input.InputUtil;

/**
 *
 * @author John Ferdinand Antonio
 */
public class SearchStudentController implements KeyListener {

    private DecimalFormat decimalFormatter;
    private StudentDaoImpl studentDaoImpl;
    private TuitionFeeDaoImpl tuitionFeeDaoImpl;
    private SchoolYearDaoImpl schoolYearDaoImpl;
    private GradeLevelDaoImpl gradeLevelDaoImpl;
    private SchoolFeesDaoImpl schoolFeesDaoImpl;
    private BalanceBreakDownML balanceBreakDownML;
    private SchoolFeesML schoolFeesML;

    private final JTextField jtfTotalFeesWithDiscount;
    private final JButton jbtnRemoveDiscount;
    private final JComboBox jcmbPaymentTerm;
    private final JComboBox jcmbSchoolYearFrom;
    private final JTextField jtfStudentId;
    private Student student;
    private SchoolYear schoolYear;
    private SchoolFees schoolFees;
    private TuitionFee tuitionFee;
    private final JLabel jlblStudentTypeText;
    private final JLabel jlblLastNameText;
    private final JLabel jlblFirstNameText;
    private final JLabel jlblMiddleNameText;
    private final JLabel jlblAdmissionGradeLevelText;
    private final JLabel jlblPresentGradeLevelText;
    private final JLabel jlblStudentStatusText;
    private final JTextField jtfBasicFee;
    private final JTextField jtfMiscellaneousFee;
    private final JTextField jtfOtherFee;
    private final JTextField jtfTotalFees;
    private final JTextField jtfTotalPaid;
    private final JTextField jtfRemainingBalance;
    private final JComboBox jcmbDiscount;
    private final JTextField jtfDiscounPercentage;
    private final JTextField jtfDiscounts;
    private final JTable jtblBalanceBreakDown;
    private final JTable jtblDownPaymentFee;
    private final JTable jtblBasicFee;
    private final JTable jtblMiscFees;
    private final JTable jtblOtherFees;

    public SearchStudentController(
            JTextField jtfTotalFeesWithDiscount, JButton jbtnRemoveDiscount,
            JComboBox jcmbPaymentTerm, JTextField jtfStudentId, JComboBox jcmbSchoolYearFrom,
            JLabel jlblStudentTypeText, JLabel jlblLastNameText, JLabel jlblFirstNameText,
            JLabel jlblMiddleNameText, JLabel jlblAdmissionGradeLevelText, JLabel jlblPresentGradeLevelText,
            JLabel jlblStudentStatusText, JTextField jtfBasicFee, JTextField jtfMiscellaneousFee, JTextField jtfOtherFee,
            JTextField jtfTotalFees, JTextField jtfTotalPaid, JTextField jtfRemainingBalance,
            JComboBox jcmbDiscount, JTextField jtfDiscountPercentage, JTextField jtfDiscounts,
            JTable jtblBalanceBreakDown, JTable jtblDownPaymentFee, JTable jtblBasicFee, JTable jtblMiscFees,
            JTable jtblOtherFees) {
        this.jtfTotalFeesWithDiscount = jtfTotalFeesWithDiscount;
        this.jbtnRemoveDiscount = jbtnRemoveDiscount;
        this.jcmbPaymentTerm = jcmbPaymentTerm;
        this.jtfStudentId = jtfStudentId;
        this.jcmbSchoolYearFrom = jcmbSchoolYearFrom;
        this.jlblStudentStatusText = jlblStudentStatusText;
        this.jlblStudentTypeText = jlblStudentTypeText;
        this.jlblLastNameText = jlblLastNameText;
        this.jlblFirstNameText = jlblFirstNameText;
        this.jlblMiddleNameText = jlblMiddleNameText;
        this.jlblAdmissionGradeLevelText = jlblAdmissionGradeLevelText;
        this.jlblPresentGradeLevelText = jlblPresentGradeLevelText;
        this.jtfBasicFee = jtfBasicFee;
        this.jtfMiscellaneousFee = jtfMiscellaneousFee;
        this.jtfOtherFee = jtfOtherFee;
        this.jtfTotalFees = jtfTotalFees;
        this.jtfTotalPaid = jtfTotalPaid;
        this.jtfRemainingBalance = jtfRemainingBalance;
        this.jcmbDiscount = jcmbDiscount;
        this.jtfDiscounPercentage = jtfDiscountPercentage;
        this.jtfDiscounts = jtfDiscounts;
        this.jtblBalanceBreakDown = jtblBalanceBreakDown;
        this.jtblBasicFee = jtblBasicFee;
        this.jtblDownPaymentFee = jtblDownPaymentFee;
        this.jtblMiscFees = jtblMiscFees;
        this.jtblOtherFees = jtblOtherFees;

        initializeComponents();
        initializeDaoImpl();
        initializeModelLoaders();
        initializeFormatters();
    }
    
    private void initializeControllers(){
        jbtnRemoveDiscount.addActionListener(
                new RemoveDiscountController(
                        jtfDiscounPercentage,
                        jtfTotalFeesWithDiscount, jtfRemainingBalance, jtfDiscounts, 
                        jcmbPaymentTerm, jcmbDiscount,
                        student, schoolFees, schoolYear, tuitionFee)
        );
        
        jcmbPaymentTerm.addItemListener(new PaymentTermChangeController
            (student, schoolFees, schoolYear, tuitionFee, jcmbPaymentTerm, jtblBalanceBreakDown)
        );
        
        jcmbDiscount.addItemListener(new DiscountChangeController(
                jbtnRemoveDiscount,
                jtfTotalFeesWithDiscount,
                jcmbPaymentTerm, 
                jtfBasicFee, 
                jtfMiscellaneousFee,
                jtfOtherFee, 
                jtfTotalFees, 
                jtfTotalPaid, 
                jtfRemainingBalance, 
                jcmbDiscount,
                jtfDiscounPercentage, 
                jtfDiscounts, 
                jtblBalanceBreakDown, 
                jtblDownPaymentFee,
                jtblBasicFee, 
                jtblMiscFees, 
                jtblOtherFees,
                student, schoolFees,schoolYear,tuitionFee)
        );
    }
    
    private void initializeComponents(){
        jcmbPaymentTerm.setEnabled(true);
        jcmbDiscount.setEnabled(true);
    }

    private void initializeModelLoaders() {
        balanceBreakDownML = new BalanceBreakDownML();
        schoolFeesML = new SchoolFeesML();
    }

    private void initializeFormatters() {
//        decimalFormatter = new DecimalFormat("#0.00");
        decimalFormatter = new DecimalFormat("#,#00.00");
    }

    private void initializeDaoImpl() {
        studentDaoImpl = new StudentDaoImpl();
        tuitionFeeDaoImpl = new TuitionFeeDaoImpl();
        schoolYearDaoImpl = new SchoolYearDaoImpl();
        gradeLevelDaoImpl = new GradeLevelDaoImpl();
        schoolFeesDaoImpl = new SchoolFeesDaoImpl();
    }

    private void initializeModels() {
        schoolYear = getSchoolYear();
        student = getStudent();
        schoolFees = getSchoolFees();
        tuitionFee = getTuitionFee();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            initializeModels();
            initializeControllers();
            if (inputIsValid()) {
                if (studentExists()) {
                    if (hasTuitionFeeRecord()) {
                        loadStudentRecord(true);
                    } else {
                        loadStudentRecord(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Student Id does not exist");
                }
            }
        }
    }

    private boolean studentExists() {
        boolean exists;
        exists = student.getStudentId() != null;
        return exists;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void loadStudentRecord(boolean hasTuitionFeeRecord) {
        int studentType = student.getStudentType();
        String lastName = student.getRegistration().getLastName();
        String firstName = student.getRegistration().getFirstName();
        String middleName = student.getRegistration().getMiddleName();
        int admissionGradeLevel = student.getAdmission().getGradeLevel() ;
        int currentGradeLevel = student.getCurrentGradeLevel().getLevel();
        boolean admissionStatus = student.getAdmission().isCompleted();
        double basicFee = schoolFees.getBasicFee().getAmount();
        double miscellaneousFees = schoolFees.getMiscellaneousFees().getSum();
        double otherFees = schoolFees.getOtherFees().getSum();
        double tuitionFeeSum = schoolFees.getSum();
        double remainingBalance = tuitionFee.getBalance();
        String paymentTerm ;
        String discountName = tuitionFee.getDiscount().getDiscountName();
        int discountPercentage = tuitionFee.hasDiscount() ? tuitionFee.getDiscount().getPercentOfDiscount(): 0;
        double discountAmount = tuitionFee.hasDiscount() ? tuitionFee.getDiscount().getAmount() : 0;
        int gradeLevelId = gradeLevelDaoImpl.getId(student.getCurrentGradeLevel().getLevel());
        DefaultTableModel balanceBreakDownModel = (DefaultTableModel)jtblBalanceBreakDown.getModel();
        DefaultTableModel basicFeeModel = (DefaultTableModel) jtblBasicFee.getModel();
        
        if (hasTuitionFeeRecord) {
            paymentTerm = tuitionFee.getPaymentTerm().getName().trim();
            balanceBreakDownModel = balanceBreakDownML.getBalanceBreakDownFee(student.getStudentId(), schoolYear.getSchoolYearId());
            basicFeeModel = schoolFeesML.getBasic(jtblBasicFee, gradeLevelId);
        } else {
            TuitionFee t = createFreshTuitionFee();
            paymentTerm = t.getPaymentTerm().getName().trim();
            
            List<BalanceBreakDownFee> list = t.getBalanceBreakDownFees();
            balanceBreakDownModel.setRowCount(0);
            for(BalanceBreakDownFee b : list){
                Object[] rowData = {
                    b.getDescription(),
                    decimalFormatter.format(b.getAmount()),
                    decimalFormatter.format(b.getBalance())
                };
                balanceBreakDownModel.addRow(rowData);
            }
            
            DefaultTableModel downPaymentModel = (DefaultTableModel) schoolFeesML.getDownPayment(jtblDownPaymentFee, gradeLevelId);
            jtblDownPaymentFee.setModel(downPaymentModel);
            jtblBasicFee.setModel(schoolFeesML.getBasic(jtblBasicFee, gradeLevelId));
            jtblMiscFees.setModel(schoolFeesML.getMiscellaneous(jtblMiscFees, gradeLevelId));
            jtblOtherFees.setModel(schoolFeesML.getOther(jtblOtherFees, gradeLevelId));
        }
        
        jlblStudentTypeText.setText(studentType== 0 ? "Old" : "New");
        jlblLastNameText.setText(lastName);
        jlblFirstNameText.setText(firstName);
        jlblMiddleNameText.setText(middleName);
        jlblAdmissionGradeLevelText.setText(admissionGradeLevel== 0 ? "Kindergarten" : "Grade " + admissionGradeLevel);
        jlblPresentGradeLevelText.setText(currentGradeLevel == 0 ? "Kindergarten" : "Grade " + currentGradeLevel);
        jlblStudentStatusText.setText(admissionStatus == true ? "Complete" : "Pending");
        jtfBasicFee.setText(decimalFormatter.format(basicFee));
        jtfMiscellaneousFee.setText(decimalFormatter.format(miscellaneousFees));
        jtfOtherFee.setText(decimalFormatter.format(otherFees));
        jtfTotalFees.setText(decimalFormatter.format(tuitionFeeSum));
        jtfRemainingBalance.setText(decimalFormatter.format(remainingBalance));
        jcmbPaymentTerm.setSelectedItem(paymentTerm);
        jcmbDiscount.setSelectedItem(discountName);
        jtfDiscounPercentage.setText(""+discountPercentage);
        jtfDiscounts.setText(decimalFormatter.format(discountAmount));
        jtblBalanceBreakDown.setModel(balanceBreakDownModel);
        jtblBasicFee.setModel(basicFeeModel);
    }
    
    private TuitionFee createFreshTuitionFee() {
        double totalPaid = 0.00;
        double totalFees = schoolFees.getSum();
        double remainingBalance = schoolFees.getSum();
        
        Discount discount = new Discount();
        discount.setDiscountName(null);
        discount.setPercentOfDiscount(0);
        
        PaymentTerm pt = new PaymentTerm();
        pt.setName(student.getRegistration().getPaymentTerm().trim());
        
        TuitionFee t = new TuitionFee();
        t.setExists(false);
        t.setTotalFees(totalFees);
        t.setTotalPaid(totalPaid);
        t.setBalance(remainingBalance);
        t.setPaymentTerm(pt);
        t.setDiscount(discount);
        TuitionFeeProcessor tuitionFeeProcessor = new TuitionFeeProcessor(t, schoolFees,schoolYear);
        t.setBalanceBreakDownFees(tuitionFeeProcessor.getBreakDown());

        return t;
    }

    private boolean inputIsValid() {
        boolean inputIsValid = true;
        if (!studentIdIsValid()) {
            inputIsValid = false;
            JOptionPane.showMessageDialog(null, "Please enter a valid student Id.");
        }
        if (!schoolYearIsValid()) {
            inputIsValid = false;
            JOptionPane.showMessageDialog(null, "Please select a schoolyear.");
        }
        return inputIsValid;
    }

    private boolean schoolYearIsValid() {
        boolean schoolYearIsValid;
        boolean emptySelection = jcmbSchoolYearFrom.getSelectedIndex() < 0;
        schoolYearIsValid = !emptySelection;
        return schoolYearIsValid;
    }

    private boolean studentIdIsValid() {
        boolean studentIdIsValid;
        String value = (jtfStudentId.getText().trim());
        studentIdIsValid = InputUtil.isInteger(value);
        return studentIdIsValid;
    }

    private boolean hasTuitionFeeRecord() {
        boolean hasTuitionFees;
        hasTuitionFees = tuitionFee.exists();
        return hasTuitionFees;
    }

    private Student getStudent() {
        Student s = new Student();
        int studentId = Integer.parseInt(jtfStudentId.getText().trim());
        s.setStudentId(studentId);
        student = studentDaoImpl.getStudentRecordById(s);
        return student;
    }

    private SchoolFees getSchoolFees() {
        int gradelevelId = studentDaoImpl.getCurrentGradeLevelId(student.getStudentId());
        schoolFees = schoolFeesDaoImpl.get(gradelevelId);
        return schoolFees;
    }

    private TuitionFee getTuitionFee() {
        tuitionFee = tuitionFeeDaoImpl.get(student.getStudentId(), schoolYear.getSchoolYearId());
        return tuitionFee;
    }

    private SchoolYear getSchoolYear() {
        String yearFrom = jcmbSchoolYearFrom.getSelectedItem().toString().trim();
        int schoolYearId = schoolYearDaoImpl.getId(Integer.parseInt(yearFrom));
        schoolYear = schoolYearDaoImpl.getById(schoolYearId);
        return schoolYear;
    }

}
