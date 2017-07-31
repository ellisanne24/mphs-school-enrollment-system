/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.transferee;

import daoimpl.TransfereeGradeDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.transfereegrade.TransfereeGrade;

/**
 *
 * @author John Ferdinand Antonio
 */
public class SaveTransfereeGradesController implements ActionListener{

    private final JTextField jtfFirstQuarterGrade;
    private final JTextField jtfSecondQuarterGrade;
    private final JTextField jtfThirdQuarterGrade;
    private final JTextField jtfFourthQuarterGrade;
    private final JTextField jtfGwa;
    private final int registrationId;
    
    public SaveTransfereeGradesController(
            JTextField jtfFirstQuarterGrade, JTextField jtfSecondQuarterGrade,
            JTextField jtfThirdQuarterGrade, JTextField jtfFourthQuarterGrade, JTextField jtfGwa, int registrationId
    ) {
        this.jtfFirstQuarterGrade = jtfFirstQuarterGrade;
        this.jtfSecondQuarterGrade = jtfSecondQuarterGrade;
        this.jtfThirdQuarterGrade = jtfThirdQuarterGrade;
        this.jtfFourthQuarterGrade = jtfFourthQuarterGrade;
        this.jtfGwa = jtfGwa;
        this.registrationId = registrationId;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        TransfereeGradeDaoImpl transfereeGradeDaoImpl = new TransfereeGradeDaoImpl();
        
        double firstQuarterGrade = !jtfFirstQuarterGrade.getText().isEmpty()? Double.parseDouble(jtfFirstQuarterGrade.getText().trim()) : 0.00;
        double secondQuarterGrade = !jtfSecondQuarterGrade.getText().isEmpty()? Double.parseDouble(jtfSecondQuarterGrade.getText().trim()) : 0.00;
        double thirdQuarterGrade = !jtfThirdQuarterGrade.getText().isEmpty()? Double.parseDouble(jtfThirdQuarterGrade.getText().trim()) : 0.00;
        double fourthQuarterGrade = !jtfFourthQuarterGrade.getText().isEmpty()? Double.parseDouble(jtfFourthQuarterGrade.getText().trim()) : 0.00;

        double sum = firstQuarterGrade + secondQuarterGrade + thirdQuarterGrade + fourthQuarterGrade;
        if(sum == 0){
            JOptionPane.showMessageDialog(null,"Please input grades.");
        }else{
            double gwa = sum / 4;
            TransfereeGrade transfereeGrade = new TransfereeGrade();
            transfereeGrade.setFirstQuarterGrade(firstQuarterGrade);
            transfereeGrade.setSecondQuarterGrade(secondQuarterGrade);
            transfereeGrade.setThirdQuarterGrade(thirdQuarterGrade);
            transfereeGrade.setFourthQuarterGrade(fourthQuarterGrade);
            transfereeGrade.setGwa(gwa);
            transfereeGrade.setRegistrationId(registrationId);
            
            boolean isAdded = transfereeGradeDaoImpl.add(transfereeGrade);
            if(isAdded){
                JOptionPane.showMessageDialog(null,"Grades successfully recorded.");
            }else{
                JOptionPane.showMessageDialog(null,"Error encountered while adding grades.");
            }
        }
        
    }
    
}
