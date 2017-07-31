/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.transferee;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import view.transfereegrade.AddGrade;

/**
 *
 * @author John Ferdinand Antonio
 */
public class AddTransfereeGradeController implements ActionListener{
    
    private final int registrationId;
    private final JCheckBox jcbTransferee;
    
    public AddTransfereeGradeController(int registrationId,JCheckBox jcbTransferee){
        this.registrationId = registrationId;
        this.jcbTransferee = jcbTransferee;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean transferee = jcbTransferee.isSelected();
        if (transferee) {
//            AddGrade addGrade = new AddGrade(null, true, registrationId);
//            addGrade.setPreferredSize(new Dimension(650, 300));
//            addGrade.pack();
//            addGrade.setLocationRelativeTo(null);
//            addGrade.setVisible(true);
        }else{
            
        }
    }
    
}
