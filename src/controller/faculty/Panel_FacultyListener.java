
package controller.faculty;

import component_model_loader.FacultyJCompModelLoader;
import component_model_loader.SubjectCategoryJCompModelLoader;
import daoimpl.FacultyDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.faculty.Faculty;
import model.subjectcategory.SubjectCategory;
import view.faculty.Dialog_FacultyAdd;
import view.faculty.Dialog_FacultyEdit;
import view.faculty.Panel_Faculty;

/**
 *
 * @author franc
 */
public class Panel_FacultyListener implements ActionListener, MouseListener{
    
    private Panel_Faculty panelFaculty;
    private Dialog_FacultyEdit dialog_FacultyEdit;
    
    private Faculty faculty = new Faculty();
    private SubjectCategory subjectCategory = new SubjectCategory();
    
    private FacultyDaoImpl fdi = new FacultyDaoImpl();
    
    private FacultyJCompModelLoader tblFacultyLoader = new FacultyJCompModelLoader();
    private SubjectCategoryJCompModelLoader subjectCategoryJCompModelLoader = new SubjectCategoryJCompModelLoader();
    
    public Panel_FacultyListener(Panel_Faculty panelFaculty){
//        JOptionPane.showMessageDialog(null,"Test");
        this.panelFaculty = panelFaculty;
    }
    
    public Panel_FacultyListener(Dialog_FacultyEdit dialog_FacultyEdit){
        this.dialog_FacultyEdit = dialog_FacultyEdit;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(panelFaculty.getBtnNewFaculty())) {
            new Dialog_FacultyAdd(null, true);
        } else if (e.getSource().equals(panelFaculty.getBtnSearch())) {
            faculty.setLastName(panelFaculty.getTfSearch().getText());

            panelFaculty.getTblFaculty().setModel(tblFacultyLoader.facultyInfo(fdi.getFacultyByName(faculty)));
            panelFaculty.getTblFaculty().getColumnModel().getColumn(0).setMinWidth(0);
            panelFaculty.getTblFaculty().getColumnModel().getColumn(0).setMaxWidth(0);
        } else if (e.getSource().equals(panelFaculty.getBtnEditFaculty())) {
            if (panelFaculty.getTblFaculty().getSelectedRow() >= 0) {
                faculty.setFacultyID((int) panelFaculty.getTblFaculty().getValueAt(panelFaculty.getTblFaculty().getSelectedRow(), 0));
                dialog_FacultyEdit = new Dialog_FacultyEdit(null, true, faculty, subjectCategory);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 1){
            if(e.getSource().equals(panelFaculty.getTblFaculty())){
                faculty.setFacultyID((int) panelFaculty.getTblFaculty().getValueAt(panelFaculty.getTblFaculty().getSelectedRow(), 0));
                panelFaculty.getTblSpecialization().setModel(tblFacultyLoader.loadFacultySpecialization(fdi.loadFacultySpecialization(faculty, subjectCategory),"select"));
                panelFaculty.getTblSpecialization().getColumnModel().getColumn(0).setMinWidth(0);
                panelFaculty.getTblSpecialization().getColumnModel().getColumn(0).setMaxWidth(1);
            }
            else if(e.getSource().equals(panelFaculty.getTblSpecialization())){
                DefaultTableModel tableModel = 
                    subjectCategoryJCompModelLoader.getSubjectCategoryAssignedSubjectsById(panelFaculty.getTblSpecialization(),panelFaculty.getTblSpecializationSubjects());
                panelFaculty.getTblSpecializationSubjects().setModel(tableModel);
            }
            else if(e.getSource().equals(panelFaculty.getTfSearch())){
                panelFaculty.getTfSearch().setText("");
            }
        }
        else if(e.getClickCount() == 2){
            if(e.getSource().equals(panelFaculty.getTfSearch())){
                if(!panelFaculty.getTfSearch().equals("Search here")){
                    panelFaculty.getTfSearch().setText("");
                }
            }
        }
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
