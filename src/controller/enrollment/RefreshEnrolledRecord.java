package controller.enrollment;

import component_model_loader.EnrollmentJCompModelLoader;
import daoimpl.EnrollmentDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.enrollment.EnrollmentPanel;

/**
 *
 * @author Jordan
 */
public class RefreshEnrolledRecord implements ActionListener {

    private EnrollmentPanel view;
    private SchoolYearDaoImpl schoolYearDaoImpl;
    private EnrollmentDaoImpl enrollmentDaoImpl;
    private EnrollmentJCompModelLoader enrollmentJCompModelLoader;

    public RefreshEnrolledRecord(EnrollmentPanel view) {
        this.view = view;
        schoolYearDaoImpl = new SchoolYearDaoImpl();
        enrollmentDaoImpl = new EnrollmentDaoImpl(schoolYearDaoImpl);
        enrollmentJCompModelLoader = new EnrollmentJCompModelLoader(enrollmentDaoImpl);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.getJcmbEnrolledShowFilter().setSelectedIndex(-1);
        view.getJcmbEnrolledFilterGradeLevel().setSelectedIndex(-1);
        JTable table = view.getJtblEnrolledMasterList();
        DefaultTableModel tableModel = enrollmentJCompModelLoader.getAllEnrolledOfCurrentSchoolYear(table);
        table.setModel(tableModel);
    }

}
