
package controller.navigation;

import constants.DashboardMenuItem;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import utility.layout.CardLayoutUtil;
import view.container.Dashboard;

/**
 *
 * @author John Ferdinand Antonio
 */
public class UINavigationExit implements ActionListener{
    private final Container container;
    private final DashboardMenuItem dashboardMenuItem;
    
    public UINavigationExit(Container container,DashboardMenuItem dashboardMenuPanel){
        this.container = container;
        this.dashboardMenuItem = dashboardMenuPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        removeContainer();
    }
    
    private void removeContainer(){
        int choice = JOptionPane.showConfirmDialog(null, "Exit?", "Exit Confirmation", JOptionPane.WARNING_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            Dashboard.jtpTopTabbedPane.remove(container);
            returnToDashboard();
            switch (dashboardMenuItem) {
                case ENROLLMENT:
                    Dashboard.setENROLLMENT_INSTANCE(0);
                    break;
                case SETTINGS:
                    Dashboard.setMANAGEMENT_INSTANCE(0);
                    break;
                case GRADINGSYSTEM:
                    Dashboard.setGRADES_INSTANCE(0);
                    break;
                case PAYMENTS:
                    Dashboard.setPAYMENTS_INSTANCE(0);
                    break;
                case REGISTRATION:
                    Dashboard.setREGISTRATION_INSTANCE(0);
                    break;
                case ACCOUNTS:
                    Dashboard.setACCOUNTS_INSTANCE(0);
                    break;
                default:
                    break;
            }
            
        }
    }
    
    private void returnToDashboard() {
        CardLayoutUtil.flipCardTo(Dashboard.jpnlTopCardContainer, Dashboard.jpnlTopCard);
    }
    
}
