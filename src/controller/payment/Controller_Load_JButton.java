package controller.payment;

import component_model_loader.OfficialReceiptJCompModelLoader;
import component_model_loader.PaymentTermJCompModelLoader;
import component_model_loader.TuitionFeesJCompModelLoader;
import daoimpl.FeeDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.PaymentTermDaoImpl;
import daoimpl.RegistrationDaoImpl;
import daoimpl.StudentDaoImpl;
import daoimpl.TuitionFeeDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import model.admission.Admission;
import model.discount.Discount;
import model.fee.Fee;
import model.paymentterm.PaymentTerm;
import model.registration.Registration;
import model.schoolyear.SchoolYear;
import model.student.Student;
import model.tuitionfee.Tuition;
import model.user.User;
import service.tuition.TuitionPopulator;
import view.payment.Dialog_SearchStudentByKeyword;
import view.payment.Panel_Payment;

/**
 *
 * @author Jordan
 */
public class Controller_Load_JButton implements ActionListener {

    private final Dialog_SearchStudentByKeyword searchResultDialog;
    private final Panel_Payment panelPayment;
    private final RegistrationDaoImpl registrationDaoImpl;
    private final StudentDaoImpl studentDaoImpl;
    private final GradeLevelDaoImpl gradeLevelDaoImpl;
    private final FeeDaoImpl feeDaoImpl;
    private final PaymentTermDaoImpl paymentTermDaoImpl;
    private final TuitionFeeDaoImpl tuitionFeeDaoImpl;
    private final PaymentTermJCompModelLoader paymentTermJCompModelLoader;
    private final TuitionFeesJCompModelLoader tuitionFeesJCompModelLoader;
    private Student student;
    private List<Fee> feeList;
    private PaymentTerm paymentTerm;
    private final SchoolYear currentSchoolYear;
    private final User user;

    public Controller_Load_JButton(Dialog_SearchStudentByKeyword searchResultDialog, Panel_Payment panelPayment, SchoolYear currentSchoolYear, User user) {
        this.searchResultDialog = searchResultDialog;
        this.panelPayment = panelPayment;
        this.currentSchoolYear = currentSchoolYear;
        this.user = user;
        this.registrationDaoImpl = new RegistrationDaoImpl();
        this.studentDaoImpl = new StudentDaoImpl();
        this.gradeLevelDaoImpl = new GradeLevelDaoImpl();
        this.feeDaoImpl = new FeeDaoImpl();
        this.paymentTermDaoImpl = new PaymentTermDaoImpl();
        this.tuitionFeeDaoImpl = new TuitionFeeDaoImpl();
        this.paymentTermJCompModelLoader = new PaymentTermJCompModelLoader();
        this.tuitionFeesJCompModelLoader = new TuitionFeesJCompModelLoader();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchResultDialog.getJbtnLoad()) {
            if (searchResultDialog.getJtblStudents().getSelectedRowCount() > 0) {
                JTable t = searchResultDialog.getJtblStudents();
                int registrationId = Integer.parseInt(t.getValueAt(t.getSelectedRow(), 0).toString().trim());
                int admissionId = Integer.parseInt(t.getValueAt(t.getSelectedRow(), 1).toString().trim());
                int studentNo = Integer.parseInt(t.getValueAt(t.getSelectedRow(), 3).toString().trim());
                if (studentNo == 0) {
                    Registration registration = registrationDaoImpl.getRegistrationInfoById(registrationId);
                    Admission admission = new Admission();
                    admission.setAdmissionId(admissionId);
                    initStudentBy(registration, admission);
                    panelPayment.clearForm();
                    initForm(false);
                } else {
                    initStudentBy(studentNo);
                    panelPayment.clearForm();
                    initForm(true);
                }
            }
            searchResultDialog.dispose();
        }
    }

    private void initStudentBy(int studentNo) {
        student = studentDaoImpl.getStudentByStudentNo(studentNo);
    }

    private void initStudentBy(Registration registration, Admission admission) {
        student = new Student();
        student.setRegistration(registration);
        student.setAdmission(admission);
    }

    private void initForm(boolean hasStudentNo) {
        panelPayment.clearForm();
        initStudentDetails(hasStudentNo);
        initializeFees();
        initializeBalanceBreakDownTableModelListener();

        if (hasStudentNo) {
            Tuition tuition = tuitionFeeDaoImpl.getBy(student.getStudentId(), currentSchoolYear.getSchoolYearId());
            panelPayment.getJlblTotalPaidText().setText("" + tuition.getTotalPaid());
            panelPayment.getJlblRemainingBalanceText().setText("" + tuition.getRemainingBalance());
            panelPayment.getJcmbPaymentTerm().setSelectedItem(tuition.getPaymentTerm().getPaymentTermName().trim());
            panelPayment.getJcmbModeOfPayment().setSelectedItem(tuition.getPaymentTerm().getPaymentTermName().trim().equalsIgnoreCase("Cash")? "Cash" : "Installment");
            BigDecimal totalDiscount = new BigDecimal(BigInteger.ZERO).setScale(2,BigDecimal.ROUND_HALF_UP);
            for(Discount d : tuition.getDiscounts()){
                totalDiscount = totalDiscount.add(d.getAmount());
            }
            if(tuition.getDiscounts().size() > 0){
                panelPayment.getJcbDiscount().setSelected(true);
                panelPayment.getJcbDiscount().setEnabled(false);
            }else{
                panelPayment.getJcbDiscount().setSelected(false);
                panelPayment.getJcbDiscount().setEnabled(true);
            }
            DefaultTableModel discountTableModel = (DefaultTableModel) panelPayment.getJtblDiscounts().getModel();
            for (Discount d : tuition.getDiscounts()) {
                Object[] rowData = {
                    d.getSchoolYear().getYearFrom() + "-" + d.getSchoolYear().getYearTo(), d.getDiscountName(),
                    d.getPercent(), d.getAmount(), d.getProvision(), d.getDateApplied()
                };
                discountTableModel.addRow(rowData);
            }
            panelPayment.getJtblDiscounts().setModel(discountTableModel);
            
            panelPayment.getJtfDiscount().setText(""+totalDiscount);
            panelPayment.getJcmbPaymentTerm().setEnabled(false);
            panelPayment.setHasStudentNo(hasStudentNo);
            panelPayment.setStudent(student);
            panelPayment.setFeeList(feeList);
            initializeBalanceBreakDownTable();
            initializeReceiptsMasterListTable();
            initAssignSummerFeeButton();
        } else {
            panelPayment.getJcmbPaymentTerm().setEnabled(true);
            initializePaymentTermComboItemListener();
            panelPayment.setHasStudentNo(hasStudentNo);
            panelPayment.setStudent(student);
            panelPayment.setFeeList(feeList);
            panelPayment.getJcmbModeOfPayment().setEnabled(true);
        }
    }

    
    private void initializeBalanceBreakDownTable(){
        JTable table = panelPayment.getJtblBalanceBreakDown();
        int studentId = student.getStudentId();
        table.setModel(tuitionFeesJCompModelLoader.getTuitionByStudentIdAndSchoolYearId(table, studentId, currentSchoolYear.getSchoolYearId()));
    }
    
    private void initializeReceiptsMasterListTable(){
        OfficialReceiptJCompModelLoader officialReceiptJCompModelLoader = new OfficialReceiptJCompModelLoader();
        JTable table = panelPayment.getJtblReceipts();
        int studentId = student.getStudentId();
        table.setModel(officialReceiptJCompModelLoader.getAllOfficialReceiptsByStudentId(table, studentId));
    }
    
    private void initAssignSummerFeeButton() {
        panelPayment.getJbtnAssignSummerFee().addActionListener(new Controller_Display_Dialog_AssignSummerFees_JButton(panelPayment, student, currentSchoolYear));
        if (student.getIsRecommendedToTakeSummer()) {
            panelPayment.getJlblRecommendForSummerMessage().setText("Student is recommended for summer.");
            panelPayment.getJbtnAssignSummerFee().setEnabled(true);
        } else {
            panelPayment.getJbtnAssignSummerFee().setEnabled(false);
        }
    }

    private void initializePaymentTermComboItemListener() {
        panelPayment.getJcmbPaymentTerm().addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String paymentTermName = e.getItem().toString().trim();
                int paymentTermID = paymentTermDaoImpl.getPaymentTermIDByName(paymentTermName);
                paymentTerm = paymentTermDaoImpl.getPaymentTermByPaymentTermId(paymentTermID);
                initBalanceBreakDownTable(paymentTerm);
                panelPayment.getJtfDiscount().setText("");
                panelPayment.getJcbDiscount().setSelected(false);
                panelPayment.getJcbDiscount().setEnabled(true);
                panelPayment.getJbtnSelectDiscount().setEnabled(false);
            }
        });
    }

    private void initBalanceBreakDownTable(PaymentTerm paymentTerm) {
        TuitionPopulator tuitionPopulator = new TuitionPopulator(feeList, paymentTerm);
        DefaultTableModel tableModel = tuitionPopulator.getTuitionItemsTableModel(panelPayment.getJtblBalanceBreakDown());
        panelPayment.getJtblBalanceBreakDown().setModel(tableModel);
    }

    private void initStudentDetails(boolean hasStudentNo) {
        int gradeLevelNo = (hasStudentNo == true) ? student.getGradeLevelNo() : student.getRegistration().getGradeLevelNo();
        String studentNo = (hasStudentNo == true) ? student.getStudentNo() + "" : "";
        Object studentType = (hasStudentNo == true) ? student.getStudentType() : student.getRegistration().getStudentType();
        if (studentType instanceof Integer) {
            panelPayment.getJtfStudentType().setText(Integer.parseInt(studentType.toString()) == 1 ? "New" : "Old");
        } else if (studentType instanceof String) {
            panelPayment.getJtfStudentType().setText(studentType.toString().equalsIgnoreCase("N") ? "New" : studentType.toString().equalsIgnoreCase("T") ? "Transferee" : "Old");
        }
        panelPayment.getJcmbPaymentTerm().setModel(paymentTermJCompModelLoader.getPaymentTermNames());
        panelPayment.getJtfStudentNo().setText(studentNo);
        panelPayment.getJtfLastName().setText(student.getRegistration().getLastName());
        panelPayment.getJtfFirstName().setText(student.getRegistration().getFirstName());
        panelPayment.getJtfMiddleName().setText(student.getRegistration().getMiddleName());
        panelPayment.getJtfGradeLevel().setText(gradeLevelNo == 0 ? "Kindergarten" : gradeLevelNo + "");
        panelPayment.getJtfStatus().setText(student.isActive() == true ? "Active" : "Inactive");
    }

    private void initializeFees() {
        feeList = feeDaoImpl.getFeesByGradeLevelId(gradeLevelDaoImpl.getId(student.getGradeLevelNo()));
        initFeeTableModelListenerFor(panelPayment.getJtblDownpayment(), panelPayment.getJtfDownPayment());
        initFeeTableModelListenerFor(panelPayment.getJtblBasic(), panelPayment.getJtfBasicFee());
        initFeeTableModelListenerFor(panelPayment.getJtblMiscellaneous(), panelPayment.getJtfMiscellaneous());
        initFeeTableModelListenerFor(panelPayment.getJtblOthers(), panelPayment.getJtfOtherFees());
        panelPayment.getJtfTotal().setText("" + getFeesSum());
        setFeeRecordTo("Downpayment", panelPayment.getJtblDownpayment());
        setFeeRecordTo("Others", panelPayment.getJtblOthers());
        setFeeRecordTo("Miscellaneous", panelPayment.getJtblMiscellaneous());
        setFeeRecordTo("Basic", panelPayment.getJtblBasic());
    }

    private void initFeeTableModelListenerFor(JTable table, JTextField textField) {
        table.getModel().addTableModelListener((TableModelEvent e) -> {
            BigDecimal sum = new BigDecimal(BigInteger.ZERO);
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                BigDecimal amountDue = BigDecimal.valueOf(Double.parseDouble(tableModel.getValueAt(i, 1).toString().trim()));
                sum = sum.add(amountDue).setScale(2, BigDecimal.ROUND_HALF_UP);
            }
            textField.setText("" + sum);
        });
    }

    private void initializeBalanceBreakDownTableModelListener() {
        panelPayment.getJtblBalanceBreakDown().getModel().addTableModelListener((TableModelEvent e) -> {
            panelPayment.getJbtnMakePayment().setEnabled(panelPayment.getJtblBalanceBreakDown().getRowCount() > 0);
        });
    }

    private void setFeeRecordTo(String feeCategoryName, JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        for (Fee f : feeList) {
            if (f.getFeeCategory().getName().equalsIgnoreCase(feeCategoryName)) {
                Object[] rowData = {f.getName(), f.getAmount()};
                tableModel.addRow(rowData);
            }
            table.setModel(tableModel);
        }
    }

    private BigDecimal getFeesSum() {
        BigDecimal sum = new BigDecimal(BigInteger.ZERO);
        for (Fee f : feeList) {
            if (!f.getFeeCategory().getName().trim().equalsIgnoreCase("Summer")) {
                sum = sum.add(f.getAmount());
            }
        }
        return sum;
    }
}
