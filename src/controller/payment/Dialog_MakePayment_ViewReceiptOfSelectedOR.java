
package controller.payment;

import daoimpl.OfficialReceiptDaoImpl;
import daoimpl.StudentDaoImpl;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.officialreceipt.OfficialReceipt;
import model.student.Student;
import view.receipt.Dialog_Receipt;

/**
 *
 * @author Jordan
 */
public class Dialog_MakePayment_ViewReceiptOfSelectedOR implements ActionListener{

    private final JTable jtblReceiptsMasterList;
    private final JTextField jtfStudentNo;

    public Dialog_MakePayment_ViewReceiptOfSelectedOR(JTable jtblReceiptsMasterList,JTextField jtfStudentNo) {
        this.jtblReceiptsMasterList = jtblReceiptsMasterList;
        this.jtfStudentNo = jtfStudentNo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        displayReceipt();
    }
    
    private void displayReceipt(){
        if(jtblReceiptsMasterList.getSelectedRow() > -1){
            int selectedRow = jtblReceiptsMasterList.getSelectedRow();
            int studentNo = Integer.parseInt(jtfStudentNo.getText().trim());
            StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
            Student student = studentDaoImpl.getStudentByStudentNo(studentNo);
            int orNo = Integer.parseInt(jtblReceiptsMasterList.getValueAt(selectedRow, 0).toString().toString());
            OfficialReceiptDaoImpl officialReceiptDaoImpl = new OfficialReceiptDaoImpl();
            OfficialReceipt officialReceipt = new OfficialReceipt();
            officialReceipt = officialReceiptDaoImpl.getOfficialReceiptByOrNo(orNo);
            Dialog_Receipt dialog = new Dialog_Receipt(student,officialReceipt);
            dialog.setPreferredSize(new Dimension(800,600));
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }
    }
}
