/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_model_loader;

import daoimpl.TuitionFeeDaoImpl;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.tuitionfee.Tuition;
import static view.payment.Old_PaymentAndAssessmentForm.jtblBalanceBreakdown;

/**
 *
 * @author John Ferdinand Antonio
 */
public class BalanceBreakDownJCompModelLoader {
    private final TuitionFeeDaoImpl tuitionFeeDaoImpl;
    private final DecimalFormat decimalFormatter;
    
    public BalanceBreakDownJCompModelLoader(){
        tuitionFeeDaoImpl = new TuitionFeeDaoImpl();
        decimalFormatter = new DecimalFormat("#,#00.00");
    }
    
    public DefaultTableModel getBalanceBreakDownFee(int studentId, int schoolYearId){
        Tuition tuitionFee = tuitionFeeDaoImpl.get(studentId, schoolYearId);
        List<BalanceBreakDownFee> balanceBreakDownFee = tuitionFee.getBalanceBreakDownFees();
            DefaultTableModel model = (DefaultTableModel) jtblBalanceBreakdown.getModel();
            model.setRowCount(0);
            for (BalanceBreakDownFee b : balanceBreakDownFee) {
                System.out.println("Descriptin :"+b.getName());
                System.out.println("Amount :"+b.getAmount());
                System.out.println("Balance :"+b.getBalance());
                Object[] rowData = {
                    b.getName(),
                    decimalFormatter.format(b.getAmount()),
                    decimalFormatter.format(b.getBalance())
                };
                model.addRow(rowData);
            }
            model.setColumnIdentifiers(new Object[]{"Description","Amount","Balance"});
            return model;
    }
}
