
package controller.schoolyear;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import view.schoolyear.DialogSchoolYearCrud;
import view.section.DialogSectionCrud;

/**
 *
 * @author Jordan
 */
public class DisplaySchoolYearCrudDialog implements ActionListener{

    private final JTable jtblSchoolYearMasterList;
    
    public DisplaySchoolYearCrudDialog(JTable jtblSchoolYearMasterList){
        this.jtblSchoolYearMasterList = jtblSchoolYearMasterList;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String dialogTitle = getDialogTitle(e);
        String action = getAction(e);
        
        if (action.equalsIgnoreCase("create")) {
            displayDialog(dialogTitle, action);
        } else if (action.equalsIgnoreCase("edit") || action.equalsIgnoreCase("view")) {
            validateSelection(dialogTitle, action);
        }
    }
    
    private String getDialogTitle(ActionEvent e) {
        String dialogTitle = e.getActionCommand().equalsIgnoreCase("create") ? "Create New School Year"
                : e.getActionCommand().equalsIgnoreCase("edit") ? "Edit School Year"
                : e.getActionCommand().equalsIgnoreCase("view") ? "School Year Info(View)"
                : e.getActionCommand().equalsIgnoreCase("print") ? "Print" : "";
        return dialogTitle;
    }

    private String getAction(ActionEvent e) {
        String action = e.getActionCommand().equalsIgnoreCase("create") ? "create"
                : e.getActionCommand().equalsIgnoreCase("edit") ? "edit"
                : e.getActionCommand().equalsIgnoreCase("view") ? "view"
                : e.getActionCommand().equalsIgnoreCase("print") ? "print" : "";
        return action;
    }

    private boolean hasSchoolYearSelected() {
        boolean hasSchoolYearSelected = false;
        if (jtblSchoolYearMasterList.getSelectedRow() > -1) {
            hasSchoolYearSelected = true;
        }
        return hasSchoolYearSelected;
    }

    private void validateSelection(String dialogTitle, String action) {
        if (hasSchoolYearSelected()) {
            displayDialog(dialogTitle, action);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a school year from the list.");
        }
    }

    private void displayDialog(String dialogTitle, String action) {
        if (action.equals("edit") || action.equals("view")) {
            if (hasSchoolYearSelected()) {
                int schoolyearId = 0;
                int rowSelected = jtblSchoolYearMasterList.getSelectedRow();
                int schoolYearId = Integer.parseInt(jtblSchoolYearMasterList.getValueAt(rowSelected, schoolyearId).toString());
                DialogSchoolYearCrud dialogSchoolYearCrud = new DialogSchoolYearCrud(null, true, action, schoolYearId);
                dialogSchoolYearCrud.setTitle(dialogTitle);
                dialogSchoolYearCrud.pack();
                dialogSchoolYearCrud.setLocationRelativeTo(null);
                dialogSchoolYearCrud.setVisible(true);
            }
        } else {
            DialogSchoolYearCrud dialogSchoolYearCrud = new DialogSchoolYearCrud(null, true, action);
            dialogSchoolYearCrud.setTitle(dialogTitle);
            dialogSchoolYearCrud.pack();
            dialogSchoolYearCrud.setLocationRelativeTo(null);
            dialogSchoolYearCrud.setVisible(true);
        }
    }
    
}
