package controller.registration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

/**
 *
 * @author John Ferdinand Antonio
 */
public class DeleteRegistrationController implements ActionListener{

    private final JTable jtblRegistrationList;
    
    public DeleteRegistrationController(JTable jtblRegistrationList){
        this.jtblRegistrationList = jtblRegistrationList;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
