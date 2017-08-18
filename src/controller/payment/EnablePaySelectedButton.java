/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.payment;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author John Ferdinand Antonio
 */
public class EnablePaySelectedButton implements MouseListener{

    private final JTable jtblBalanceBreakdown;
    private final JButton jbtnPaySelected;
    
    public EnablePaySelectedButton(JTable jtblBalanceBreakdown,JButton jbtnPaySelected){
        this.jtblBalanceBreakdown = jtblBalanceBreakdown;
        this.jbtnPaySelected = jbtnPaySelected;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        jbtnPaySelected.setEnabled(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
   
    
}
