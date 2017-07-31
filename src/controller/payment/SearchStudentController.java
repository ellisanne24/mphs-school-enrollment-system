/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.payment;

import daoimpl.StudentDaoImpl;
import daoimpl.TuitionFeeDaoImpl;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.paymentterm.PaymentTerm;
import model.registration.Registration;
import model.schoolfees.SchoolFees;
import model.student.Student;
import model.tuitionfee.TuitionFee;
import utility.input.InputUtil;

/**
 *
 * @author John Ferdinand Antonio
 */
public class SearchStudentController implements KeyListener{
    StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
    TuitionFeeDaoImpl tuitionFeeDaoImpl = new TuitionFeeDaoImpl();
    private final JComboBox jcmbPaymentTerm;
    private final JComboBox jcmbSchoolYearFrom;
    private final JTextField jtfStudentId;
    private int studentId;
    private int schoolYearId;
    
    public SearchStudentController(JComboBox jcmbPaymentTerm, JTextField jtfStudentId,JComboBox jcmbSchoolYearFrom){
        this.jcmbPaymentTerm = jcmbPaymentTerm;
        this.jtfStudentId = jtfStudentId;
        this.jcmbSchoolYearFrom = jcmbSchoolYearFrom;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            if (inputIsValid()) {
                if (studentExists()) {
                    if (!hasTuitionFeeRecord()) {
                        loadRecord(false);
                    } else {
                        loadRecord(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Student Id does not exist");
                }
            } 
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println();
    }
    
    private void loadRecord(boolean hasTuitionFeeRecord){
        Student student = studentDaoImpl.getStudentById(studentId);
        if(hasTuitionFeeRecord){
            
        }else{
            PaymentTerm paymentTerm = new PaymentTerm();
            
            TuitionFee tuitionFee = new TuitionFee();
            tuitionFee.setExists(false);
            
            
        }
    }
    
    private boolean inputIsValid(){
        boolean inputIsValid = true;
        if(studentIdIsValid()){
             setStudentId();
        }else{
            inputIsValid = false;
            JOptionPane.showMessageDialog(null,"Please enter a valid student Id.");
        }
        if(schoolYearIsValid()){
            setSchoolYearId();
        }else{
            inputIsValid = false;
            JOptionPane.showMessageDialog(null,"Please select a schoolyear.");
        }
        return inputIsValid;
    }
    
    private void setStudentId(){
        String value = (jtfStudentId.getText().trim());
        studentId = Integer.parseInt(value);
    }
    
    private void setSchoolYearId() {
        String schoolYearFrom = jcmbSchoolYearFrom.getSelectedItem().toString().trim();
        schoolYearId = Integer.parseInt(schoolYearFrom);
    }
    
    private boolean schoolYearIsValid(){
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
    
    private boolean studentExists(){
        boolean exists;
        Student s = studentDaoImpl.getStudentById(studentId);
        exists = s.getStudentId() != null;
        return exists;
    }
    
    private boolean newStudent(){
        boolean isNew = true;
        return isNew;
    }
    
    private boolean hasTuitionFeeRecord() {
        boolean hasTuitionFees;
        TuitionFee tuitionFee = tuitionFeeDaoImpl.get(studentId, schoolYearId);
        hasTuitionFees = tuitionFee.exists();
        return hasTuitionFees;
    }
    
    private SchoolFees getSchoolFees(){
        SchoolFees schoolFees = new SchoolFees();
        return schoolFees;
    }
    
    private TuitionFee getTuitionFee(){
        TuitionFee tuitionFee = new TuitionFee();
        return tuitionFee;
    }
    
}
