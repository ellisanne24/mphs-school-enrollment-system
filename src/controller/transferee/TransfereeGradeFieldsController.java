/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.transferee;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author John Ferdinand Antonio
 */
public class TransfereeGradeFieldsController {

    private final JTextField jtfFirstQuarterGrade;
    private final JTextField jtfSecondQuarterGrade;
    private final JTextField jtfThirdQuarterGrade;
    private final JTextField jtfFourthQuarterGrade;
    private final JTextField jtfGwa;
    private final int registrationId;
    private final JButton jbtnSaveGrades;
    
    public TransfereeGradeFieldsController(JTextField jtfFirstQuarterGrade,JTextField jtfSecondQuarterGrade,
        JTextField jtfThirdQuarterGrade, JTextField jtfFourthQuarterGrade, JTextField jtfGwa, JButton jbtnSaveGrades,
        int registrationId){
        this.jtfFirstQuarterGrade = jtfFirstQuarterGrade;
        this.jtfSecondQuarterGrade = jtfSecondQuarterGrade;
        this.jtfThirdQuarterGrade = jtfThirdQuarterGrade;
        this.jtfFourthQuarterGrade = jtfFourthQuarterGrade;
        this.jtfGwa = jtfGwa;
        this.registrationId = registrationId;
        this.jbtnSaveGrades = jbtnSaveGrades;
    }
    
    public void control(){
        jtfFirstQuarterGrade.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                jtfSecondQuarterGrade.setEnabled(true);
            }
            @Override
            public void keyPressed(KeyEvent e) {
                
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        
        jtfSecondQuarterGrade.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                jtfThirdQuarterGrade.setEnabled(true);
            }
            @Override
            public void keyPressed(KeyEvent e) {
                
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        jtfThirdQuarterGrade.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                jtfFourthQuarterGrade.setEnabled(true);
            }
            @Override
            public void keyPressed(KeyEvent e) {
                
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        jtfFourthQuarterGrade.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }
            @Override
            public void keyPressed(KeyEvent e) {
                //calculate gwa
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    double firstQuarterGrade = Double.parseDouble(jtfFirstQuarterGrade.getText().trim());
                    double secondQuarterGrade = Double.parseDouble(jtfSecondQuarterGrade.getText().trim());
                    double thirdQuarterGrade = Double.parseDouble(jtfThirdQuarterGrade.getText().trim());
                    double fourthQuarterGrade = Double.parseDouble(jtfFourthQuarterGrade.getText().trim());

                    double sum = firstQuarterGrade + secondQuarterGrade + thirdQuarterGrade + fourthQuarterGrade;
                    double average = sum / 4;
                    jtfGwa.setText("" + average);
                    jbtnSaveGrades.setEnabled(true);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        
    }
    
}
