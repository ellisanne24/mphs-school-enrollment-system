package controller.payment;

import component_model_loader.BalanceBreakDownML;
import component_model_loader.SchoolFeesML;
import daoimpl.DiscountDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.PaymentTermDaoImpl;
import daoimpl.SchoolFeesDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.StudentDaoImpl;
import daoimpl.TuitionFeeDaoImpl;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

/**
 *
 * @author John Ferdinand Antonio
 */
public class DiscountChangeController implements ItemListener {

    private DecimalFormat df;

    private final SchoolFeesDaoImpl schoolFeesDaoImpl = new SchoolFeesDaoImpl();
    private final StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
    private final SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
    private final TuitionFeeDaoImpl tuitionFeeDaoImpl = new TuitionFeeDaoImpl();
    private final GradeLevelDaoImpl gradeLevelDaoImpl = new GradeLevelDaoImpl();

    private final BalanceBreakDownML balanceBreakDownML = new BalanceBreakDownML();
    private final SchoolFeesML schoolFeesML = new SchoolFeesML();

    private final JTextField jtfTotalFeesWithDiscount;
    private final JComboBox jcmbPaymentTerm;
    private final Student student;
    private final SchoolYear schoolYear;
    private final SchoolFees schoolFees;
    private final TuitionFee tuitionFee;
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
    private final JButton jbtnRemoveDiscount;

    public DiscountChangeController(
            JButton jbtnRemoveDiscount,
            JTextField jtfTotalFeesWithDiscount,
            JComboBox jcmbPaymentTerm, 
            JTextField jtfBasicFee, 
            JTextField jtfMiscellaneousFee, 
            JTextField jtfOtherFee,
            JTextField jtfTotalFees, 
            JTextField jtfTotalPaid, 
            JTextField jtfRemainingBalance,
            JComboBox jcmbDiscount, 
            JTextField jtfDiscountPercentage, 
            JTextField jtfDiscounts,
            JTable jtblBalanceBreakDown, 
            JTable jtblDownPaymentFee, 
            JTable jtblBasicFee, 
            JTable jtblMiscFees,
            JTable jtblOtherFees,
            Student student,
            SchoolFees schoolFees,
            SchoolYear schoolYear,
            TuitionFee tuitionFee) {
        this.jbtnRemoveDiscount = jbtnRemoveDiscount;
        this.jtfTotalFeesWithDiscount = jtfTotalFeesWithDiscount;
        this.jcmbPaymentTerm = jcmbPaymentTerm;
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
        
        this.student = student;
        this.schoolFees = schoolFees;
        this.schoolYear = schoolYear;
        this.tuitionFee = tuitionFee;
        
        initializeFormatters();
    }

    private void initializeFormatters() {
//        decimalFormatter = new DecimalFormat("#0.00");
        df = new DecimalFormat("#,#00.00");
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (jcmbDiscount.getSelectedIndex() > -1) {
            jbtnRemoveDiscount.setEnabled(true);
            setForm();
        }else if(jcmbDiscount.getSelectedIndex() == -1){
            jbtnRemoveDiscount.setEnabled(false);
        }
    }

    private void setForm() {
        int gradeLevelId = gradeLevelDaoImpl.getId(student.getCurrentGradeLevel().getLevel());
        double basicFee = schoolFees.getBasicFee().getAmount();
        double miscellaneousFees = schoolFees.getMiscellaneousFees().getSum();
        double otherFees = schoolFees.getOtherFees().getSum();
        double totalFees = schoolFees.getSum();
        double totalFeesWithDiscount ;
        double remainingBalance = tuitionFee.getBalance();
        double totalPaid;
        String paymentTerm;
        String discountName = tuitionFee.getDiscount().getDiscountName();
        int discountPercentage = tuitionFee.hasDiscount() ? tuitionFee.getDiscount().getPercentOfDiscount() : 0;
        double discountAmount = tuitionFee.hasDiscount() ? tuitionFee.getDiscount().getAmount() : 0;
        DefaultTableModel balanceBreakDownModel = (DefaultTableModel) jtblBalanceBreakDown.getModel();
        DefaultTableModel basicFeeModel = (DefaultTableModel) jtblBasicFee.getModel();

        if (tuitionFee.exists()) {
            totalFeesWithDiscount = schoolFees.getSum();
            totalPaid = tuitionFee.getTotalPaid();
            paymentTerm = tuitionFee.getPaymentTerm().getName().trim();
            balanceBreakDownModel = balanceBreakDownML.getBalanceBreakDownFee(student.getStudentId(), schoolYear.getSchoolYearId());
            basicFeeModel = schoolFeesML.getBasic(jtblBasicFee, gradeLevelId);
        } else {
            TuitionFee t = getFreshTuitionFee();
            totalPaid = t.getTotalPaid();
            totalFees = t.getTotalFees();
            totalFeesWithDiscount = (t.getTotalFees() - t.getDiscount().getAmount());
            remainingBalance = t.getBalance();
            discountName = t.getDiscount().getDiscountName();
            discountAmount = t.getDiscount().getAmount();
            discountPercentage = t.getDiscount().getPercentOfDiscount();

            System.out.println("Total Paid: "+totalPaid);
            System.out.println("Total Fees: "+totalFees);
            System.out.println("Total Fees w/Discount :"+totalFeesWithDiscount);
            System.out.println("Remaining Balance: "+remainingBalance);
            System.out.println("Discount Name :"+discountName);
            System.out.println("Discount Amount :"+discountAmount);
            System.out.println("Discount Percentage :"+discountPercentage);
            System.out.println("Balance BreakDown Fess Size :"+t.getBalanceBreakDownFees().size());
            System.out.println("-------------------------------------------------------------------");
            
            List<BalanceBreakDownFee> list = t.getBalanceBreakDownFees();
            balanceBreakDownModel.setRowCount(0);
            for (BalanceBreakDownFee b : list) {
                Object[] rowData = {
                    b.getDescription(),
                    b.getAmount(),
                    b.getBalance(),
                    b.getDeadline()
                };
                balanceBreakDownModel.addRow(rowData);
            }
        }

        jtfBasicFee.setText(df.format(basicFee));
        jtfMiscellaneousFee.setText(df.format(miscellaneousFees));
        jtfOtherFee.setText(df.format(otherFees));
        jtfTotalFees.setText(df.format(totalFees));
        jtfTotalFeesWithDiscount.setText(df.format(totalFeesWithDiscount));
        jtfRemainingBalance.setText(df.format(remainingBalance));
        jtfDiscounts.setText(df.format(discountAmount));
        
//        jcmbDiscount.setSelectedItem(discountName);
        jtfDiscounPercentage.setText("" + discountPercentage);
        jtfDiscounts.setText(df.format(discountAmount));
        jtblBalanceBreakDown.setModel(balanceBreakDownModel);
        jtblBasicFee.setModel(basicFeeModel);
        jtfTotalPaid.setText(df.format(totalPaid));
        
        
        DefaultTableModel downPaymentModel = (DefaultTableModel) schoolFeesML.getDownPayment(jtblDownPaymentFee, gradeLevelId);
        jtblDownPaymentFee.setModel(downPaymentModel);
        jtblBasicFee.setModel(schoolFeesML.getBasic(jtblBasicFee, gradeLevelId));
        jtblMiscFees.setModel(schoolFeesML.getMiscellaneous(jtblMiscFees, gradeLevelId));
        jtblOtherFees.setModel(schoolFeesML.getOther(jtblOtherFees, gradeLevelId));
    }

    private TuitionFee getFreshTuitionFee() {
        TuitionFee tuition = new TuitionFee();
        DiscountDaoImpl discountDaoImpl = new DiscountDaoImpl();
        PaymentTermDaoImpl paymentTermDaoImpl = new PaymentTermDaoImpl();
        try {
            double totalPaid = 0.00;
            double totalFees = schoolFees.getSum();
            double balance = schoolFees.getSum();
            
            String paymentTermName = jcmbPaymentTerm.getSelectedItem().toString().trim();
            int paymentTermId = paymentTermDaoImpl.getId(paymentTermName);
            PaymentTerm paymentTerm = paymentTermDaoImpl.getById(paymentTermId);
            
            String discountName = jcmbDiscount.getSelectedItem().toString().trim() == null? "":jcmbDiscount.getSelectedItem().toString().trim();
            int discountId = discountDaoImpl.getId(discountName);
            Discount discount = discountDaoImpl.get(discountId);
            double discountAmount = (schoolFees.getSum() * discount.getPercentOfDiscount()) / 100;
            discount.setAmount(discountAmount);
            
            tuition.setExists(false);
            tuition.setTotalFees(totalFees);
            tuition.setTotalPaid(totalPaid);
            tuition.setBalance(balance);
            tuition.setPaymentTerm(paymentTerm);
            tuition.setDiscount(discount);
            TuitionFeeProcessor tuitionFeeProcessor = new TuitionFeeProcessor(tuition, schoolFees,schoolYear);
            tuition.setBalanceBreakDownFees(tuitionFeeProcessor.getBreakDown());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return tuition;
    }
}
