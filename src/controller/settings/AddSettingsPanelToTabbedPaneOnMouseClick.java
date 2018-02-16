
package controller.settings;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import view.curriculum.Panel_Curriculum;
import view.faculty.Panel_Faculty;
import view.fees.JpnlFeeRecord;
import view.paymentsetting.PaymentScheduleSettings;
import view.rooms.Panel_Rooms;
import view.schedule.Panel_ClassSchedules;
import view.schoolyear.Panel_SchoolYear;
import view.section.Panel_Sections;
import view.subject.Panel_Subjects;
import view.subjectcategory.Panel_SubjectCategory;

/**
 *
 * @author Jordan
 */
public class AddSettingsPanelToTabbedPaneOnMouseClick implements MouseListener {

    private final JTabbedPane jtpManagementTabbedPane;
    private final JPanel jpnlSubjectMgmt;
    private final JPanel jpnlSubjectCatMgmt;
    private final JPanel jpnlCurriculumMgmt;
    private final JPanel jpnlFacultyMgmt;
    private final JPanel jpnlSectionMgmt;
    private final JPanel jpnlRoomMgmt;
    private final JPanel jpnlScheduleMgmt;
    private final JPanel jpnlFeesMgmt;
    private final JPanel jpnlCredentialsMgmt;
    private final JPanel jpnlPaymentSchedulesMgmt;
    private final JPanel jpnlDiscountsMgmt;
    private final JPanel jpnlLanMgmt;
    private final JPanel jpnlSchoolYearManagement;
    
    public AddSettingsPanelToTabbedPaneOnMouseClick(
            JTabbedPane jtpManagementTabbedPane, JPanel jpnlSubjectMgmt, JPanel jpnlSubjectCatMgmt,
            JPanel jpnlCurriculumMgmt, JPanel jpnlFacultyMgmt, JPanel jpnlSectionMgmt, JPanel jpnlRoomMgmt,
            JPanel jpnlScheduleMgmt, JPanel jpnlFeesMgmt, JPanel jpnlCredentialsMgmt, JPanel jpnlPaymentSchedulesMgmt,
            JPanel jpnlDiscountsMgmt, JPanel jpnlLanMgmt, JPanel jpnlSchoolYearManagement
    ) {
        this.jtpManagementTabbedPane = jtpManagementTabbedPane;
        this.jpnlSubjectMgmt = jpnlSubjectMgmt;
        this.jpnlSubjectCatMgmt = jpnlSubjectCatMgmt;
        this.jpnlCurriculumMgmt = jpnlCurriculumMgmt;
        this.jpnlFacultyMgmt = jpnlFacultyMgmt;
        this.jpnlSectionMgmt = jpnlSectionMgmt;
        this.jpnlRoomMgmt = jpnlRoomMgmt;
        this.jpnlScheduleMgmt = jpnlScheduleMgmt;
        this.jpnlFeesMgmt = jpnlFeesMgmt;
        this.jpnlCredentialsMgmt = jpnlCredentialsMgmt;
        this.jpnlPaymentSchedulesMgmt = jpnlPaymentSchedulesMgmt;
        this.jpnlDiscountsMgmt = jpnlDiscountsMgmt;
        this.jpnlLanMgmt = jpnlLanMgmt;
        this.jpnlSchoolYearManagement = jpnlSchoolYearManagement;
    }

    private void addPanelToTabbedPane(JPanel jpnlContainerPanel, JPanel jpnlPanelToAdd) {
        jpnlContainerPanel.removeAll();
        jpnlContainerPanel.add(jpnlPanelToAdd);
        jtpManagementTabbedPane.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            int selectedTab = jtpManagementTabbedPane.getSelectedIndex();
            switch (selectedTab) {
                case 0:
                    addPanelToTabbedPane(jpnlSubjectMgmt, new Panel_Subjects());
                    break;
                case 1:
                    addPanelToTabbedPane(jpnlSubjectCatMgmt, new Panel_SubjectCategory());
                    break;
                case 2:
                    addPanelToTabbedPane(jpnlCurriculumMgmt, new Panel_Curriculum());
                    break;
                case 3:
                    addPanelToTabbedPane(jpnlFacultyMgmt, new Panel_Faculty());
                    break;
                case 4:
                    addPanelToTabbedPane(jpnlSectionMgmt, new Panel_Sections());
                    break;
                case 5:
                    addPanelToTabbedPane(jpnlRoomMgmt, new Panel_Rooms());
                    break;
                case 6:
                    addPanelToTabbedPane(jpnlScheduleMgmt, new Panel_ClassSchedules());
                    break;
                case 7:
                    addPanelToTabbedPane(jpnlFeesMgmt, new JpnlFeeRecord());
                    break;
                case 8:
                    addPanelToTabbedPane(jpnlCredentialsMgmt, null); //replace null with the correct panel used as UI
                    break;
                case 9:
                    addPanelToTabbedPane(jpnlPaymentSchedulesMgmt, new PaymentScheduleSettings());
                    break;
                case 10:
//                    addPanelToTabbedPane(jpnlDiscountsMgmt, null);
                    JOptionPane.showMessageDialog(null,"Settings for Discounts is still under development.");
                    break;
                case 11:
//                    addPanelToTabbedPane(jpnlLanMgmt, null);
                    JOptionPane.showMessageDialog(null,"Settings for LAN Management is still under development.");
                    break;
                case 12:
                    addPanelToTabbedPane(jpnlSchoolYearManagement, new Panel_SchoolYear());
                    break;
                default:
                    break;
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
