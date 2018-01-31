package controller.payment;

import component_model_loader.PaymentTermJCompModelLoader;
import daoimpl.FeeDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.PaymentTermDaoImpl;
import daoimpl.StudentDaoImpl;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import model.fee.Fee;
import model.paymentterm.PaymentTerm;
import model.period.Period;
import model.student.Student;
import view.payment.Panel_Payment;

/**
 *
 * @author Jordan
 */
public class SearchStudent implements KeyListener {

    private int studentNo;
    private Student student;
    private List<Fee> feeList;

    private final StudentDaoImpl studentDaoImpl;
    private final FeeDaoImpl feeDaoImpl;
    private final PaymentTermDaoImpl paymentTermDaoImpl;
    private final GradeLevelDaoImpl gradeLevelDaoImpl;

    private PaymentTermJCompModelLoader paymentTermJCompModelLoader;

    private Panel_Payment view;

    public SearchStudent(
            Panel_Payment view, StudentDaoImpl studentDaoImpl, GradeLevelDaoImpl gradeLevelDaoImpl,
            FeeDaoImpl feeDaoImpl, PaymentTermDaoImpl paymentTermDaoImpl) {
        this.view = view;
        this.studentDaoImpl = studentDaoImpl;
        this.feeDaoImpl = feeDaoImpl;
        this.paymentTermDaoImpl = paymentTermDaoImpl;
        this.gradeLevelDaoImpl = gradeLevelDaoImpl;
        paymentTermJCompModelLoader = new PaymentTermJCompModelLoader();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            if (view.getJtfSearchBoxMakePayment().getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid search keyword.");
            } else {
                validate();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void validate() {
        if (inputIsValid()) {
            studentNo = Integer.parseInt(view.getJtfSearchBoxMakePayment().getText().trim());
            if (studentExist()) {
                resetForm();
                initModel();
                initForm();
            } else {
                JOptionPane.showMessageDialog(null, "Student not found.");
                resetForm();
            }
        } else {
            JOptionPane.showMessageDialog(null, "You have entered an invalid input.");
        }
    }

    private void initModel() {
        student = studentDaoImpl.getStudentByStudentNo(studentNo);
        feeList = feeDaoImpl.getFeesByGradeLevelId(gradeLevelDaoImpl.getId(student.getGradeLevelNo()));
    }

    private boolean inputIsValid() {
        try {
            Integer.parseInt(view.getJtfSearchBoxMakePayment().getText().trim());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private void initForm() {
        view.getJcmbPaymentTerm().setModel(paymentTermJCompModelLoader.getPaymentTermNames());
        view.getJtfStudentNo().setText(student.getStudentNo() + "");
        view.getJtfLastName().setText(student.getRegistration().getLastName());
        view.getJtfFirstName().setText(student.getRegistration().getFirstName());
        view.getJtfMiddleName().setText(student.getRegistration().getMiddleName());
        view.getJtfGradeLevel().setText(student.getGradeLevelNo() + "");
        view.getJtfStudentType().setText(student.getStudentType() == 1 ? "New" : "Old");
        view.getJtfStatus().setText(student.isActive() == true ? "Active" : "Inactive");
        initFeeTableModelListenerFor("Downpayment", view.getJtblDownpayment());
        initFeeTableModelListenerFor("Basic", view.getJtblBasic());
        initFeeTableModelListenerFor("Miscellaneous", view.getJtblMiscellaneous());
        initFeeTableModelListenerFor("Others", view.getJtblOthers());
        setFeeRecordTo("Downpayment", view.getJtblDownpayment());
        setFeeRecordTo("Others", view.getJtblOthers());
        setFeeRecordTo("Miscellaneous", view.getJtblMiscellaneous());
        setFeeRecordTo("Basic", view.getJtblBasic());
//        view.getJtfTotal().setText("" + getFeesSum());
        initPaymentTermItemListener();
        initBalanceBreakDownTableModelListener();
        initMakePaymentListener();
    }

    private void initMakePaymentListener() {
        view.getJbtnMakePayment().addActionListener(new DisplayMakePaymentDialog(view.getJtblBalanceBreakDown(), student, feeList));
    }

    private void initFeeTableModelListenerFor(String feeCategoryName, JTable jTable) {
        jTable.getModel().addTableModelListener((TableModelEvent e) -> {
            BigDecimal sum = new BigDecimal(BigInteger.ZERO);
            DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                sum = sum.add(BigDecimal.valueOf(Double.parseDouble(tableModel.getValueAt(i, 1).toString().trim())));
            }
            sum = sum.setScale(2, BigDecimal.ROUND_HALF_UP);
            if (feeCategoryName.trim().equalsIgnoreCase("Downpayment")) {
                view.getJtfDownPayment().setText("" + sum);
            } else if (feeCategoryName.trim().equalsIgnoreCase("Basic")) {
                view.getJtfBasicFee().setText("" + sum);
            } else if (feeCategoryName.trim().equalsIgnoreCase("Miscellaneous")) {
                view.getJtfMiscellaneous().setText("" + sum);
            } else if (feeCategoryName.trim().equalsIgnoreCase("Others")) {
                view.getJtfOtherFees().setText("" + sum);
            }
        });
    }

    private void initPaymentTermItemListener() {
        view.getJcmbPaymentTerm().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String paymentTermName = e.getItem().toString().trim().equalsIgnoreCase("Semestral") ? "Semestral"
                            : e.getItem().toString().trim().equalsIgnoreCase("Quarterly") ? "Quarterly"
                            : e.getItem().toString().trim().equalsIgnoreCase("Monthly") ? "Monthly" : "";
                    int paymentTermID = paymentTermDaoImpl.getPaymentTermIDByName(paymentTermName);
                    PaymentTerm paymentTerm = paymentTermDaoImpl.getPaymentTermByPaymentTermId(paymentTermID);
                    initBalanceBreakDownTable(paymentTerm);
                }
            }
        });
    }

    private void initBalanceBreakDownTableModelListener() {
        view.getJtblBalanceBreakDown().getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                view.getJbtnMakePayment().setEnabled(view.getJtblBalanceBreakDown().getRowCount() > 0);
            }
        });
    }

    private void initBalanceBreakDownTable(PaymentTerm paymentTerm) {
//        if(!hasBalanceBreakDownRecord()){
//              calculate
//        }
        TuitionItemsService tFeeService = new TuitionItemsService(feeList, paymentTerm);
        tFeeService.loadTuitionItemsDataToTable();
    }

    private void setFeeRecordTo(String feeCategoryName, JTable jTable) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        tableModel.setRowCount(0);
        for (Fee f : feeList) {
            if (f.getFeeCategory().getName().equalsIgnoreCase(feeCategoryName)) {
                Object[] rowData = {f.getName(), f.getAmount()};
                tableModel.addRow(rowData);
            }
            jTable.setModel(tableModel);
        }
    }

    private void resetForm() {
        List<Component[]> compArr = new ArrayList<>();
        compArr.add(view.getJpnlStudentDetails().getComponents());
        compArr.add(view.getJpnlDownpayment().getComponents());
        compArr.add(view.getJpnlMiscellaneous().getComponents());
        compArr.add(view.getJpnlBasic().getComponents());
        compArr.add(view.getJpnlOthers().getComponents());
        compArr.add(view.getJpnlBalanceBreakdown().getComponents());
        compArr.add(view.getJpnlCurrentSchoolYearTuition().getComponents());
        for (int i = 0; i < compArr.size(); i++) {
            for (Component c : compArr.get(i)) {
                if (c instanceof JTextField) {
                    ((JTextField) c).setText("");
                } else if (c instanceof JScrollPane) {
                    JViewport jViewPort = ((JScrollPane) c).getViewport();
                    DefaultTableModel tableModel = new DefaultTableModel();
                    if (((JTable) jViewPort.getView()) instanceof JTable) {
                        tableModel = (DefaultTableModel) ((JTable) jViewPort.getView()).getModel();
                        tableModel.setRowCount(0);
                        ((JTable) jViewPort.getView()).setModel(tableModel);
                    }
                } else if (c instanceof JComboBox) {
                    ((JComboBox) c).setSelectedIndex(-1);
                }
            }
        }
    }

    private boolean studentExist() {
        boolean exist;
        exist = studentDaoImpl.studentExist(studentNo);
        return exist;
    }

    private class TuitionItemsService {
        private final List<Fee> fees;
        private final PaymentTerm paymentTerm;

        public TuitionItemsService(List<Fee> fees, PaymentTerm paymentTerm) {
            this.fees = fees;
            this.paymentTerm = paymentTerm;
        }

        public BigDecimal getPerPeriodAmount() {
            BigDecimal feeSum = new BigDecimal(getFeesSum().toString());
            BigDecimal amountPerPeriod = new BigDecimal(BigInteger.ZERO);
            amountPerPeriod = amountPerPeriod.add(feeSum.subtract(getDownpaymentAmount())
                    .subtract(getOthersFeeSum())
                    .divide(BigDecimal.valueOf(paymentTerm.getDivisor())));
            amountPerPeriod = amountPerPeriod.setScale(2, BigDecimal.ROUND_HALF_UP);
            return amountPerPeriod;
        }

        private BigDecimal getFeesSum() {
            BigDecimal sum = new BigDecimal(BigInteger.ZERO);
            for (Fee f : fees) {
                sum = sum.add(f.getAmount());
            }
            return sum;
        }

        private BigDecimal getOthersFeeSum() {
            BigDecimal othersSum = new BigDecimal(BigInteger.ZERO);
            for (Fee f : fees) {
                if (f.getFeeCategory().getName().trim().equalsIgnoreCase("Others")) {
                    othersSum = othersSum.add(f.getAmount());
                }
            }
            return othersSum;
        }

        private BigDecimal getDownpaymentAmount() {
            BigDecimal downpayment = new BigDecimal(BigInteger.ZERO);
            for (Fee f : fees) {
                if (f.getFeeCategory().getName().trim().equalsIgnoreCase("Downpayment")) {
                    downpayment = downpayment.add(f.getAmount());
                }
            }
            return downpayment;
        }
        
        private void loadTuitionItemsDataToTable(){
            DefaultTableModel dtm = (DefaultTableModel) view.getJtblBalanceBreakDown().getModel();
            dtm.setRowCount(0);
            List<Period> periods = paymentTerm.getPeriods();
            for (Period p : periods) {
                Object[] perPeriodRowData = {p.getPeriodName(), getPerPeriodAmount(), getPerPeriodAmount(), p.getPaymentDeadline(), "No", 0.00, "---"};
                dtm.addRow(perPeriodRowData);
            }
            for (Fee f : fees) {
                if (f.getFeeCategory().getName().trim().equalsIgnoreCase("Others")) {
                    Object[] otherFeeRowData = {f.getName(), f.getAmount(), f.getAmount(), "--", "No", 0.00, "--"};
                    dtm.addRow(otherFeeRowData);
                }
            }
        }
    }
    
    
}
