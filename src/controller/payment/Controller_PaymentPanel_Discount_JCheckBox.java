
package controller.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.payment.Panel_Payment;

/**
 *
 * @author Jordan
 */
public class Controller_PaymentPanel_Discount_JCheckBox implements ActionListener{
    
    private final Panel_Payment view;

    public Controller_PaymentPanel_Discount_JCheckBox(Panel_Payment view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getJcbDiscount()){
            if(view.getJcbDiscount().isSelected()){
                view.getJbtnAddDiscount().setEnabled(true);
            }else{
                view.getJbtnAddDiscount().setEnabled(false);
            }
        }
    }
    
}
