/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.schoolfees.SchoolFees;
import model.schoolyear.SchoolYear;
import model.student.Student;
import model.tuitionfee.TuitionFee;
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
            JComboBox jcmbPaymentTerm, JTextField jtfStudentId, JComboBox jcmbSchoolYearFrom,
            JLabel jlblStudentTypeText, JLabel jlblLastNameText, JLabel jlblFirstNameText,
            JLabel jlblMiddleNameText, JLabel jlblAdmissionGradeLevelText, JLabel jlblPresentGradeLevelText,
            JLabel jlblStudentStatusText, JTextField jtfBasicFee, JTextField jtfMiscellaneousFee, JTextField jtfOtherFee,
            JTextField jtfTotalFees, JTextField jtfTotalPaid, JTextField jtfRemainingBalance,
            JComboBox jcmbDiscount, JTextField jtfDiscountPercentage, JTextField jtfDiscounts,
            JTable jtblBalanceBreakDown, JTable jtblDownPaymentFee, JTable jtblBasicFee, JTable jtblMiscFees,
            JTable jtblOtherFees) {
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
        
        initializeDaoImpl();
        initializeModelLoaders();
        initializeFormatters();
    }

    private void initializeModelLoaders(){
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
        System.out.println();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            initializeModels();
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
        System.out.println();
    }

    private void loadStudentRecord(boolean hasTuitionFeeRecord) {
//        if (hasTuitionFeeRecord) {
            jlblStudentTypeText.setText(student.getStudentType() == 0 ? "Old" : "New");
            jlblLastNameText.setText(student.getRegistration().getLastName());
            jlblFirstNameText.setText(student.getRegistration().getFirstName());
            jlblMiddleNameText.setText(student.getRegistration().getMiddleName());
            jlblAdmissionGradeLevelText.setText(student.getAdmission().isCompleted() == true ? "Complete" : "Pending");
            jlblPresentGradeLevelText.setText(student.getCurrentGradeLevel().getLevel()==0? "Kindergarten":"Grade "+student.getCurrentGradeLevel().getLevel());
            jlblStudentStatusText.setText(student.getAdmission().isCompleted() == true ? "Complete" : "Pending");
            jtfBasicFee.setText(decimalFormatter.format(schoolFees.getBasicFee().getAmount()));
            jtfMiscellaneousFee.setText(decimalFormatter.format(schoolFees.getMiscellaneousFees().getSum()));
            jtfOtherFee.setText(decimalFormatter.format(schoolFees.getOtherFees().getSum()));
            jtfTotalFees.setText(decimalFormatter.format(tuitionFee.getSum()));
            jtfRemainingBalance.setText(decimalFormatter.format(tuitionFee.getBalance()));
//            jcmbPaymentTerm.setSelectedItem(tuitionFee.getPaymentTerm().getName().trim());
            jcmbDiscount.setSelectedItem(tuitionFee.getDiscount().getDiscountName());
            jtfDiscounPercentage.setText(tuitionFee.hasDiscount()? 
                    tuitionFee.getDiscount().getPercentOfDiscount()+"" : "");
            jtfDiscounts.setText(tuitionFee.hasDiscount()?
                    tuitionFee.getDiscount().getAmount()+"" : "");
            jtblBalanceBreakDown.setModel(balanceBreakDownML.getBalanceBreakDownFee(student.getStudentId(), schoolYear.getSchoolYearId()));
            int gradeLevelId = gradeLevelDaoImpl.getId(student.getCurrentGradeLevel().getLevel());
            jtblBasicFee.setModel(schoolFeesML.getBasic(jtblBasicFee, gradeLevelId));
            
//        } else {

//        }
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
        System.out.println("studentId @ getStudent: "+studentId);
        student = studentDaoImpl.getStudentRecordById(s);
        return student;
    }

    private SchoolFees getSchoolFees() {
        System.out.println("studentId @ getSchoolFees: "+student.getStudentId());
        int gradelevelId = studentDaoImpl.getCurrentGradeLevelId(student.getStudentId());
        schoolFees = schoolFeesDaoImpl.get(gradelevelId);
        return schoolFees;
    }

    private TuitionFee getTuitionFee() {
        System.out.println("studentId @ getTuitionFee: "+student.getStudentId());
        System.out.println("schoolYearId @ getTuitionFee: "+schoolYear.getSchoolYearId());
        tuitionFee = tuitionFeeDaoImpl.get(student.getStudentId(), schoolYear.getSchoolYearId());
        return tuitionFee;
    }
    
    private SchoolYear getSchoolYear(){
        String yearFrom = jcmbSchoolYearFrom.getSelectedItem().toString().trim();
        int schoolYearId = schoolYearDaoImpl.getId(Integer.parseInt(yearFrom));
        schoolYear = schoolYearDaoImpl.getById(schoolYearId);
        return schoolYear;
    }

}
