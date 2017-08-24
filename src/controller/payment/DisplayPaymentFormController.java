package controller.payment;

import daoimpl.DiscountDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.PaymentTermDaoImpl;
import daoimpl.SchoolFeesDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.StudentDaoImpl;
import daoimpl.TuitionFeeDaoImpl;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.discount.Discount;
import model.particulars.Particulars;
import model.paymentterm.PaymentTerm;
import model.schoolfees.SchoolFees;
import model.schoolyear.SchoolYear;
import model.student.Student;
import model.tuitionfee.TuitionFee;
import service.TuitionFeeProcessor;
import view.payment.PaySelectedForm;
import view.payment.PaymentAndAssessmentForm;
import static view.payment.PaymentAndAssessmentForm.jtblBalanceBreakdown;

/**
 *
 * @author John Ferdinand Antonio
 */
public class DisplayPaymentFormController implements ActionListener {

    private DecimalFormat df = new DecimalFormat("#0.00");
    SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();
    TuitionFeeDaoImpl tfdi = new TuitionFeeDaoImpl();
    DiscountDaoImpl ddi = new DiscountDaoImpl();
    StudentDaoImpl sdi = new StudentDaoImpl();
    SchoolFeesDaoImpl sfdi = new SchoolFeesDaoImpl();
    GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
    PaymentTermDaoImpl ptdi = new PaymentTermDaoImpl();
    private final JTextField jtfStudentId;
    private final JComboBox jcmbSchoolYearFrom;
    private final JComboBox jcmbDiscount;
    private final JComboBox jcmbPaymentTerm;
    private final JTable jtblBalanceBreakDown;

    public DisplayPaymentFormController(
            JTextField jtfStudentId, JComboBox jcmbSchoolYearFrom, JTable jtblBalanceBreakDown,
            JComboBox jcmbDiscount, JComboBox jcmbPaymentTerm) {
        this.jtfStudentId = jtfStudentId;
        this.jcmbSchoolYearFrom = jcmbSchoolYearFrom;
        this.jcmbDiscount = jcmbDiscount;
        this.jtblBalanceBreakDown = jtblBalanceBreakDown;
        this.jcmbPaymentTerm = jcmbPaymentTerm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Particulars particulars = getParticulars();
        TuitionFee tuitionFee = getTuitionFee();

        if (particulars.getBalanceSum() <= 0) {
            JOptionPane.showMessageDialog(null, "All fees are paid.");
        } else {
            PaySelectedForm psf = new PaySelectedForm(particulars, tuitionFee);
            psf.setPreferredSize(new Dimension(540, 450));
            psf.pack();
            psf.setLocationRelativeTo(null);
            psf.setVisible(true);
        }
    }

    private Particulars getParticulars() {
        Integer studentId = Integer.parseInt(jtfStudentId.getText().trim());
        Integer schoolYearId = sydi.getId(Integer.parseInt(jcmbSchoolYearFrom.getSelectedItem().toString()));

        Particulars particulars = new Particulars();
        List<BalanceBreakDownFee> balanceBreakDownFeeList = new ArrayList<>();
        int[] selectedRows = jtblBalanceBreakdown.getSelectedRows();
        int jtblBalanceColumn = 2;
        double particularSum = 0;
        for (int i = 0; i < selectedRows.length; i++) {
            try {
                NumberFormat nf = NumberFormat.getInstance();
                double balanceAmount = nf.parse(jtblBalanceBreakdown.getValueAt(selectedRows[i], jtblBalanceColumn).toString().trim()).doubleValue();
                if (balanceAmount > 0) {
                    String description = "" + jtblBalanceBreakdown.getValueAt(selectedRows[i], 0);
                    double amount = nf.parse(jtblBalanceBreakdown.getValueAt(selectedRows[i], 1).toString()).doubleValue();
                    double balance = nf.parse(jtblBalanceBreakdown.getValueAt(selectedRows[i], 2).toString()).doubleValue();

                    System.out.println("Particular Amount :"+amount);
                    System.out.println("Particular Balance :"+balance);
                    
                    BalanceBreakDownFee balanceFeeToPay = new BalanceBreakDownFee();
                    balanceFeeToPay.setDescription(description);
                    balanceFeeToPay.setAmount(BigDecimal.valueOf(amount));
                    balanceFeeToPay.setBalance(BigDecimal.valueOf(balance));
                    balanceFeeToPay.setStudentId(studentId);
                    balanceFeeToPay.setSchoolYearId(schoolYearId);

                    balanceBreakDownFeeList.add(balanceFeeToPay);
                    particularSum += balance;
                    particulars.setBalanceBreakDownFees(balanceBreakDownFeeList);
                    particulars.setBalanceSum(particularSum);
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
                Logger.getLogger(PaymentAndAssessmentForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return particulars;
    }

    private TuitionFee getTuitionFee() {
        TuitionFee tuitionFee = createFreshTuitionFee();
        
//        if (hasTuitionRecord()) {
//           
//        } else {
//            tuitionFee = createFreshTuitionFee();
//        }
        return tuitionFee;
    }
    
    private boolean hasTuitionRecord(){
        Integer studentId = Integer.parseInt(jtfStudentId.getText().trim());
        Integer schoolYearId = sydi.getId(Integer.parseInt(jcmbSchoolYearFrom.getSelectedItem().toString()));
        boolean hasRecord = tfdi.get(studentId, schoolYearId).exists();
        return hasRecord;
    }
    
    private TuitionFee createFreshTuitionFee() {
        Integer studentId = Integer.parseInt(jtfStudentId.getText().trim());
        int schoolYearId = sydi.getId(Integer.parseInt(jcmbSchoolYearFrom.getSelectedItem().toString().trim()));
        Student student = sdi.getStudentById(studentId);
        SchoolYear schoolYear = sydi.getById(schoolYearId);
        Integer gradeLevelId = gldi.getId(student.getCurrentGradeLevel());
        SchoolFees schoolFees = sfdi.get(gradeLevelId);
        PaymentTermDaoImpl paymentTermDaoImpl = new PaymentTermDaoImpl();
        TuitionFee tuition = new TuitionFee();
        try {
            String paymentTermName = jcmbPaymentTerm.getSelectedItem().toString().trim();
            int paymentTermId = paymentTermDaoImpl.getId(paymentTermName);
            PaymentTerm paymentTerm = paymentTermDaoImpl.getById(paymentTermId);

            Discount discount;
            if(jcmbDiscount.getSelectedIndex()>-1){
                String discountName = jcmbDiscount.getSelectedItem().toString().trim();
                int discountId = ddi.getId(discountName);
                discount = ddi.get(discountId);
                double tuitionAmount = schoolFees.getSum();
                int discountPercentage = discount.getPercentOfDiscount();
                double discountAmount = (tuitionAmount * discountPercentage) / 100;
                
                discount.setAmount(discountAmount);
            }else{
                discount = null;
            }

            double totalPaid = 0.00;
            double totalFees = schoolFees.getSum();
            double remainingBalance = schoolFees.getSum();

            tuition.setSchoolYear(schoolYear);
            tuition.setStudent(student);
            tuition.setExists(false);
            tuition.setTotalFees(totalFees);
            tuition.setTotalPaid(totalPaid);
            tuition.setBalance(remainingBalance);
            tuition.setPaymentTerm(paymentTerm);
            tuition.setDiscount(discount);
            TuitionFeeProcessor tuitionFeeProcessor = new TuitionFeeProcessor(tuition, schoolFees, schoolYear);
            tuition.setBalanceBreakDownFees(tuitionFeeProcessor.getBreakDown());

            DefaultTableModel tableModel = (DefaultTableModel) jtblBalanceBreakDown.getModel();
            List<BalanceBreakDownFee> balanceBreakDownFee = tuition.getBalanceBreakDownFees();
            tableModel.setRowCount(0);
            for (BalanceBreakDownFee b : balanceBreakDownFee) {
                Object[] rowData = {
                    b.getDescription(),
                    df.format(b.getAmount()),
                    df.format(b.getBalance()),
                    b.getDeadline()
                };
                tableModel.addRow(rowData);
            }
            jtblBalanceBreakDown.setModel(tableModel);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return tuition;
    }
    
}
