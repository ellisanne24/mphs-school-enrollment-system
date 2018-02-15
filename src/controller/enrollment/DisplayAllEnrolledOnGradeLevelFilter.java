package controller.enrollment;

import component_model_loader.EnrollmentJCompModelLoader;
import daoimpl.EnrollmentDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JTable;
import view.enrollment.Panel_Enrollment;

/**
 *
 * @author Jordan
 */
public class DisplayAllEnrolledOnGradeLevelFilter implements ItemListener {

    private final Panel_Enrollment view;
    private SchoolYearDaoImpl schoolYearDaoImpl;
    private EnrollmentDaoImpl enrollmentDaoImpl;
    private EnrollmentJCompModelLoader enrollmentJCompModelLoader;

    public DisplayAllEnrolledOnGradeLevelFilter(Panel_Enrollment view) {
        this.view = view;
        schoolYearDaoImpl = new SchoolYearDaoImpl();
        enrollmentDaoImpl = new EnrollmentDaoImpl(schoolYearDaoImpl);
        enrollmentJCompModelLoader = new EnrollmentJCompModelLoader(enrollmentDaoImpl);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            JTable table = view.getJtblEnrolledMasterList();
            JComboBox combo = view.getJcmbEnrolledFilterGradeLevel();
            table.setModel(enrollmentJCompModelLoader.getAllEnrolledOfCurrentSchoolYearByGradeLevel(table, combo));
        }
    }

}
