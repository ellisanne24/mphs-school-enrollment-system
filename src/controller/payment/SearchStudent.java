package controller.payment;

import component_model_loader.PaymentTermJCompModelLoader;
import daoimpl.FeeDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.PaymentTermDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.StudentDaoImpl;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.fee.Fee;
import model.paymentterm.PaymentTerm;
import model.student.Student;
import model.tuitionfee.Tuition;
import service.tuition.TuitionPopulator;
import view.payment.Dialog_MakePayment;
import view.payment.Panel_Payment;

/**
 *
 * @author Jordan
 */
public class SearchStudent implements KeyListener {

    private int studentNo;
    private PaymentTerm paymentTerm;
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
                initStudent();
                initFees();
                initPaymentTermComboItemListener();
                initBalanceBreakDownTableModelListener();
            } else {
                JOptionPane.showMessageDialog(null, "Student not found.");
                resetForm();
            }
        } else {
            JOptionPane.showMessageDialog(null, "You have entered an invalid input.");
        }
    }

    private void initStudent() {
        student = studentDaoImpl.getStudentByStudentNo(studentNo);
        view.getJcmbPaymentTerm().setModel(paymentTermJCompModelLoader.getPaymentTermNames());
        view.getJtfStudentNo().setText(student.getStudentNo() + "");
        view.getJtfLastName().setText(student.getRegistration().getLastName());
        view.getJtfFirstName().setText(student.getRegistration().getFirstName());
        view.getJtfMiddleName().setText(student.getRegistration().getMiddleName());
        view.getJtfGradeLevel().setText(student.getGradeLevelNo() + "");
        view.getJtfStudentType().setText(student.getStudentType() == 1 ? "New" : "Old");
        view.getJtfStatus().setText(student.isActive() == true ? "Active" : "Inactive");
    }
    
    private void initFees(){
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
    
    private boolean inputIsValid() {
        try {
            Integer.parseInt(view.getJtfSearchBoxMakePayment().getText().trim());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private BigDecimal getFeesSum() {
        BigDecimal sum = new BigDecimal(BigInteger.ZERO);
        for (Fee f : feeList) {
            sum = sum.add(f.getAmount());
        }
        return sum;
    }
    
    private List<BalanceBreakDownFee> getBalanceBreakDownFeeList() {
        List<BalanceBreakDownFee> bbFeeList = new ArrayList<>();
        for (int i = 0; i < view.getJtblBalanceBreakDown().getRowCount(); i++) {
            try {
                BalanceBreakDownFee bbFee = new BalanceBreakDownFee();
                String name = view.getJtblBalanceBreakDown().getValueAt(i, 0).toString().trim();
                BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(view.getJtblBalanceBreakDown().getValueAt(i, 1).toString().trim()));
                String date = (view.getJtblBalanceBreakDown().getValueAt(i, 3).toString().trim());
                String category = (view.getJtblBalanceBreakDown().getValueAt(i, 5).toString().trim());
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                if (!date.contains("--")) {
                    Date deadline = format.parse(date);
                    bbFee.setDeadline(deadline);
                }
                bbFee.setAmount(amount);

                bbFee.setName(name);
                bbFee.setCategory(category);

                bbFeeList.add(bbFee);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        return bbFeeList;
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

    private void initPaymentTermComboItemListener() {
        view.getJcmbPaymentTerm().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String paymentTermName = e.getItem().toString().trim();
                    int paymentTermID = paymentTermDaoImpl.getPaymentTermIDByName(paymentTermName);
                    paymentTerm = paymentTermDaoImpl.getPaymentTermByPaymentTermId(paymentTermID);
                    initBalanceBreakDownTable(paymentTerm);

                    SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
                    Tuition tuition = new Tuition();
                    tuition.setStudent(student);
                    tuition.setBalanceBreakDownFees(getBalanceBreakDownFeeList());
                    tuition.setPaymentTerm(paymentTerm);
                    tuition.setSchoolyearId(schoolYearDaoImpl.getCurrentSchoolYearId());

                    Dialog_MakePayment d = new Dialog_MakePayment(tuition);
                    if (d.isShowing()) {
                        d.dispose();
                    } else {
                        d.setModal(true);
                        d.pack();
                        d.setLocationRelativeTo(null);
                        d.setVisible(true);
                        d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    }
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
        TuitionPopulator tFeeService = new TuitionPopulator(feeList, paymentTerm);
        DefaultTableModel tableModel = tFeeService.getTuitionItemsTableModel(view.getJtblBalanceBreakDown());
        view.getJtblBalanceBreakDown().setModel(tableModel);
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

}
