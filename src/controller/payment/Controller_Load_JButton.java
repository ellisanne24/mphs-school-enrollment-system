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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import model.admission.Admission;
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
    private final Panel_Payment view;
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

    public Controller_Load_JButton(Dialog_SearchStudentByKeyword searchResultDialog, Panel_Payment view, SchoolYear currentSchoolYear, User user) {
        this.searchResultDialog = searchResultDialog;
        this.view = view;
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
                    view.clearForm();
                    initForm(false);
                } else {
                    initStudentBy(studentNo);
                    view.clearForm();
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
        view.clearForm();
        initStudentDetails(hasStudentNo);
        initializeFees();
        initializeBalanceBreakDownTableModelListener();

        if (hasStudentNo) {
            Tuition tuition = tuitionFeeDaoImpl.getBy(student.getStudentId(), currentSchoolYear.getSchoolYearId());
            view.getJlblTotalPaidText().setText("" + tuition.getTotalPaid());
            view.getJlblRemainingBalanceText().setText("" + tuition.getRemainingBalance());
            view.getJcmbPaymentTerm().setSelectedItem(tuition.getPaymentTerm().getPaymentTermName().trim());
            view.getJcmbPaymentTerm().setEnabled(false);
            initializeBalanceBreakDownTable();
            initializeReceiptsMasterListTable();
            initAssignSummerFeeButton();
            view.getJbtnMakePayment().addActionListener(new New_Display_Dialog_MakePayment(hasStudentNo, student, view, currentSchoolYear, user));
        } else {
            view.getJcmbPaymentTerm().setEnabled(true);
            initializePaymentTermComboItemListener();
            view.getJbtnAddDiscount().addActionListener(new Controller_Display_Dialog_AddDiscount(view, feeList, hasStudentNo, student, currentSchoolYear, user));
            view.getJbtnMakePayment().addActionListener(new New_Display_Dialog_MakePayment(hasStudentNo, student, view, currentSchoolYear, user));
        }
    }

    
    private void initializeBalanceBreakDownTable(){
        JTable table = view.getJtblBalanceBreakDown();
        int studentId = student.getStudentId();
        table.setModel(tuitionFeesJCompModelLoader.getTuitionByStudentIdAndSchoolYearId(table, studentId, currentSchoolYear.getSchoolYearId()));
    }
    
    private void initializeReceiptsMasterListTable(){
        OfficialReceiptJCompModelLoader officialReceiptJCompModelLoader = new OfficialReceiptJCompModelLoader();
        JTable table = view.getJtblReceipts();
        int studentId = student.getStudentId();
        table.setModel(officialReceiptJCompModelLoader.getAllOfficialReceiptsByStudentId(table, studentId));
    }
    
    private void initAssignSummerFeeButton() {
        view.getJbtnAssignSummerFee().addActionListener(new Controller_Display_Dialog_AssignSummerFees_JButton(view, student, currentSchoolYear));
        if (student.getIsRecommendedToTakeSummer()) {
            view.getJlblRecommendForSummerMessage().setText("Student is recommended for summer.");
            view.getJbtnAssignSummerFee().setEnabled(true);
        } else {
            view.getJbtnAssignSummerFee().setEnabled(false);
        }
    }

    private void initializePaymentTermComboItemListener() {
        view.getJcmbPaymentTerm().addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String paymentTermName = e.getItem().toString().trim();
                int paymentTermID = paymentTermDaoImpl.getPaymentTermIDByName(paymentTermName);
                paymentTerm = paymentTermDaoImpl.getPaymentTermByPaymentTermId(paymentTermID);
                initBalanceBreakDownTable(paymentTerm);
                view.getJtfDiscount().setText("");
                view.getJcbDiscount().setSelected(false);
                view.getJbtnAddDiscount().setEnabled(false);
            }
        });
    }

    private void initBalanceBreakDownTable(PaymentTerm paymentTerm) {
        TuitionPopulator tuitionPopulator = new TuitionPopulator(feeList, paymentTerm);
        DefaultTableModel tableModel = tuitionPopulator.getTuitionItemsTableModel(view.getJtblBalanceBreakDown());
        view.getJtblBalanceBreakDown().setModel(tableModel);
    }

    private void initStudentDetails(boolean hasStudentNo) {
        int gradeLevelNo = (hasStudentNo == true) ? student.getGradeLevelNo() : student.getRegistration().getGradeLevelNo();
        String studentNo = (hasStudentNo == true) ? student.getStudentNo() + "" : "";
        Object studentType = (hasStudentNo == true) ? student.getStudentType() : student.getRegistration().getStudentType();
        if (studentType instanceof Integer) {
            view.getJtfStudentType().setText(Integer.parseInt(studentType.toString()) == 1 ? "New" : "Old");
        } else if (studentType instanceof String) {
            view.getJtfStudentType().setText(studentType.toString().equalsIgnoreCase("N") ? "New" : studentType.toString().equalsIgnoreCase("T") ? "Transferee" : "Old");
        }
        view.getJcmbPaymentTerm().setModel(paymentTermJCompModelLoader.getPaymentTermNames());
        view.getJtfStudentNo().setText(studentNo);
        view.getJtfLastName().setText(student.getRegistration().getLastName());
        view.getJtfFirstName().setText(student.getRegistration().getFirstName());
        view.getJtfMiddleName().setText(student.getRegistration().getMiddleName());
        view.getJtfGradeLevel().setText(gradeLevelNo == 0 ? "Kindergarten" : gradeLevelNo + "");
        view.getJtfStatus().setText(student.isActive() == true ? "Active" : "Inactive");
    }

    private void initializeFees() {
        feeList = feeDaoImpl.getFeesByGradeLevelId(gradeLevelDaoImpl.getId(student.getGradeLevelNo()));
        initFeeTableModelListenerFor(view.getJtblDownpayment(), view.getJtfDownPayment());
        initFeeTableModelListenerFor(view.getJtblBasic(), view.getJtfBasicFee());
        initFeeTableModelListenerFor(view.getJtblMiscellaneous(), view.getJtfMiscellaneous());
        initFeeTableModelListenerFor(view.getJtblOthers(), view.getJtfOtherFees());
        view.getJtfTotal().setText("" + getFeesSum());
        setFeeRecordTo("Downpayment", view.getJtblDownpayment());
        setFeeRecordTo("Others", view.getJtblOthers());
        setFeeRecordTo("Miscellaneous", view.getJtblMiscellaneous());
        setFeeRecordTo("Basic", view.getJtblBasic());
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
        view.getJtblBalanceBreakDown().getModel().addTableModelListener((TableModelEvent e) -> {
            view.getJbtnMakePayment().setEnabled(view.getJtblBalanceBreakDown().getRowCount() > 0);
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
