package controller.faculty;

import daoimpl.FacultyDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.faculty.Faculty;
import model.subjectcategory.SubjectCategory;
import view.faculty.Dialog_FacultyEdit;

/**
 *
 * @author franc
 */
public class EditFacultyDialogListener implements ActionListener {

    private Dialog_FacultyEdit facultyEdit;
    private ArrayList<String> rejectedData;
    private Faculty faculty;
    private SubjectCategory subjectCategory = new SubjectCategory();

    private FacultyDaoImpl fdi = new FacultyDaoImpl();

    public EditFacultyDialogListener(Dialog_FacultyEdit facultyEdit, Faculty faculty) {
        this.facultyEdit = facultyEdit;
        rejectedData = new ArrayList<>();
        this.faculty = faculty;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(facultyEdit.getBtnAdd())) {
            add();
            if (rejectedData.size() > 0) {
                displayRejectedData();
                rejectedData.clear();
            }
        } else if (e.getSource().equals(facultyEdit.getBtnRemove())) {
            removeRowsSelected();
        } else if (e.getSource().equals(facultyEdit.getBtnSave())) {
            if (facultyEdit.getTfLastname().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Lastname field cannot be left blank!");
            } else if (facultyEdit.getTfFirstname().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Firstname field cannot be left blank!");
            } else if (facultyEdit.getTfMiddlename().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Middlename field cannot be left blank!");
            } else {
                faculty.setFacultyID(faculty.getFacultyID());
                faculty.setLastName(facultyEdit.getTfLastname().getText().trim());
                faculty.setFirstName(facultyEdit.getTfFirstname().getText().trim());
                faculty.setMiddleName(facultyEdit.getTfMiddlename().getText().trim());
                faculty.setContactNo(facultyEdit.getTfContact().getText().trim());
                faculty.setEmail(facultyEdit.getTfEmail().getText().trim());
                if (facultyEdit.getCbStatus().getSelectedIndex() == 0) {
                    faculty.setStatus(true);
                } else {
                    faculty.setStatus(false);
                }

                fdi.updateFaculty(faculty);

                if (fdi.countFacultySpecialization(faculty) == 0) {
                    for (int i = 0; i < facultyEdit.getTblFacultySpecialization().getRowCount(); i++) {

                        subjectCategory.setSubjectCategoryId(Integer.parseInt((String) facultyEdit.getTblFacultySpecialization().getValueAt(i, 0)));

                        fdi.createFacultySpecialization(faculty, subjectCategory);

                        if (i == facultyEdit.getTblFacultySpecialization().getRowCount() - 1) {
                            JOptionPane.showMessageDialog(null, "Successful!");
                            facultyEdit.getDialog().dispose();
                        }
                    }
                } else {

                    fdi.deleteFacultySpecialization(faculty);

                    for (int i = 0; i < facultyEdit.getTblFacultySpecialization().getRowCount(); i++) {

                        subjectCategory.setSubjectCategoryId(Integer.parseInt(facultyEdit.getTblFacultySpecialization().getValueAt(i, 0).toString()));

                        fdi.createFacultySpecialization(faculty, subjectCategory);

                        if (i == facultyEdit.getTblFacultySpecialization().getRowCount() - 1) {
                            JOptionPane.showMessageDialog(null, "Successful!");
                            facultyEdit.getDialog().dispose();
                        }
                    }
                }
            }
        }
    }

    private boolean exists(String id) {
        boolean exists = false;

        for (int i = 0; i < facultyEdit.getTblFacultySpecialization().getRowCount(); i++) {
            if (id.equalsIgnoreCase(facultyEdit.getTblFacultySpecialization().getValueAt(i, 0).toString().trim())) {
                exists = true;
            }
        }
        return exists;
    }

    private boolean add() {
        boolean isAdded = false;
        DefaultTableModel dtmFacultySpecToAssign = (DefaultTableModel) facultyEdit.getTblFacultySpecialization().getModel();
        int[] selectedRows = facultyEdit.getTblLoadedSpecialization().getSelectedRows();
        for (int i = 0; i < selectedRows.length; i++) {
            String id = facultyEdit.getTblLoadedSpecialization().getValueAt(selectedRows[i], 0).toString();
            String name = facultyEdit.getTblLoadedSpecialization().getValueAt(selectedRows[i], 1).toString();
//            JOptionPane.showMessageDialog(null,"Id: "+id);
            if (!exists(id.trim())) {
                Object[] rowData = {id, name};
                dtmFacultySpecToAssign.addRow(rowData);
            } else {
                rejectedData.add(id + " " + name);
            }
        }
        removeRowsSelected(selectedRows, facultyEdit.getTblLoadedSpecialization());

        return isAdded;
    }

    private void removeRowsSelected(int[] selectedRows, JTable jTable) {
        for (int i = selectedRows.length - 1; i >= 0; i--) {
            DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
            tableModel.removeRow(selectedRows[i]);
            ;
        }
    }

    private void displayRejectedData() {
        String output = "";
        for (int i = 0; i < rejectedData.size(); i++) {
            output = output + rejectedData.get(i) + ",\n";
        }
        JOptionPane.showMessageDialog(null, "The following are already on the list of assigned\n" + output);
    }

    private void removeRowsSelected() {
        int[] indices = facultyEdit.getTblFacultySpecialization().getSelectedRows();
        for (int i = indices.length - 1; i >= 0; i--) {
            DefaultTableModel tableModel = (DefaultTableModel) facultyEdit.getTblFacultySpecialization().getModel();
            tableModel.removeRow(indices[i]);
            ;
        }
    }

}
