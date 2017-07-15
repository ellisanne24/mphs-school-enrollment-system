
package view.payment;

import component_model_loader.CalendarML;
import controller.global.DateScheduleController;
import controller.paymentsetting.DisplayCreateScheduleController;
import javax.swing.DefaultComboBoxModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author John Ferdinand Antonio
 */
public class PaymentSchedule extends javax.swing.JPanel {
    private final DateScheduleController sem1Deadline;
    private final DateScheduleController sem2Deadline;
    private final DateScheduleController q1Deadline;
    private final DateScheduleController q2Deadline;
    private final DateScheduleController q3Deadline;
    private final DateScheduleController q4Deadline;
    private final DateScheduleController mo1Deadline;
    private final DateScheduleController mo2Deadline;
    private final DateScheduleController mo3Deadline;
    private final DateScheduleController mo4Deadline;
    private final DateScheduleController mo5Deadline;
    private final DateScheduleController mo6Deadline;
    private final DateScheduleController mo7Deadline;
    private final DateScheduleController mo8Deadline;
    private final DateScheduleController mo9Deadline;
    private final DateScheduleController mo10Deadline;
    private final DisplayCreateScheduleController displayController;
    
    public PaymentSchedule() {
        initComponents();
        remove_title_bar();
        
        setYearsModel();
        setMonthsModel();
        
        sem1Deadline = new DateScheduleController(jcmbSem1DeadlineMonth, jcmbSem1DeadlineDay, jcmbSem1DeadlineYear);
        sem2Deadline = new DateScheduleController(jcmbSem2DeadlineMonth, jcmbSem2DeadlineDay, jcmbSem2DeadlineYear);
        
        q1Deadline = new DateScheduleController(jcmbQ1DeadlineMonth, jcmbQ1DeadlineDay, jcmbQ1DeadlineYear);
        q2Deadline = new DateScheduleController(jcmbQ2DeadlineMonth, jcmbQ2DeadlineDay, jcmbQ2DeadlineYear);
        q3Deadline = new DateScheduleController(jcmbQ3DeadlineMonth, jcmbQ3DeadlineDay, jcmbQ3DeadlineYear);
        q4Deadline = new DateScheduleController(jcmbQ4DeadlineMonth, jcmbQ4DeadlineDay, jcmbQ4DeadlineYear);
        
        mo1Deadline = new DateScheduleController(jcmbMo1DeadlineMonth, jcmbMo1DeadlineDay, jcmbMo1DeadlineYear);
        mo2Deadline = new DateScheduleController(jcmbMo2DeadlineMonth, jcmbMo2DeadlineDay, jcmbMo2DeadlineYear);
        mo3Deadline = new DateScheduleController(jcmbMo3DeadlineMonth, jcmbMo3DeadlineDay, jcmbMo3DeadlineYear);
        mo4Deadline = new DateScheduleController(jcmbMo4DeadlineMonth, jcmbMo4DeadlineDay, jcmbMo4DeadlineYear);
        mo5Deadline = new DateScheduleController(jcmbMo5DeadlineMonth, jcmbMo5DeadlineDay, jcmbMo5DeadlineYear);
        mo6Deadline = new DateScheduleController(jcmbMo6DeadlineMonth, jcmbMo6DeadlineDay, jcmbMo6DeadlineYear);
        mo7Deadline = new DateScheduleController(jcmbMo7DeadlineMonth, jcmbMo7DeadlineDay, jcmbMo7DeadlineYear);
        mo8Deadline = new DateScheduleController(jcmbMo8DeadlineMonth, jcmbMo8DeadlineDay, jcmbMo8DeadlineYear);
        mo9Deadline = new DateScheduleController(jcmbMo9DeadlineMonth, jcmbMo9DeadlineDay, jcmbMo9DeadlineYear);
        mo10Deadline = new DateScheduleController(jcmbMo10DeadlineMonth, jcmbMo10DeadlineDay, jcmbMo10DeadlineYear);
        
        displayController = new DisplayCreateScheduleController(jmiCreate);
        displayController.control();
        
        sem1Deadline.control();
        sem2Deadline.control();
        q1Deadline.control();
        q2Deadline.control();
        q3Deadline.control();
        q4Deadline.control();
        mo1Deadline.control();
        mo2Deadline.control();
        mo3Deadline.control();
        mo4Deadline.control();
        mo5Deadline.control();
        mo6Deadline.control();
        mo7Deadline.control();
        mo8Deadline.control();
        mo9Deadline.control();
        mo10Deadline.control();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jifPaymentSchedule = new javax.swing.JInternalFrame();
        jspTop = new javax.swing.JScrollPane();
        jpnlTop = new javax.swing.JPanel();
        jpnlFilter = new javax.swing.JPanel();
        jspSchoolYear = new javax.swing.JScrollPane();
        jlstSchoolYear = new javax.swing.JList<>();
        jpnlSemestral = new javax.swing.JPanel();
        jspSemestral = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jpnlSemestralFirstPayment = new javax.swing.JPanel();
        jlblEndDate = new javax.swing.JLabel();
        jcmbSem1DeadlineYear = new javax.swing.JComboBox<>();
        jcmbSem1DeadlineMonth = new javax.swing.JComboBox<>();
        jcmbSem1DeadlineDay = new javax.swing.JComboBox<>();
        jlblEndDateYear = new javax.swing.JLabel();
        jlblEndDateMonth = new javax.swing.JLabel();
        jlblEndDateDay = new javax.swing.JLabel();
        jpnlSemestralSecondPayment = new javax.swing.JPanel();
        jlblEndDate1 = new javax.swing.JLabel();
        jcmbSem2DeadlineYear = new javax.swing.JComboBox<>();
        jcmbSem2DeadlineMonth = new javax.swing.JComboBox<>();
        jcmbSem2DeadlineDay = new javax.swing.JComboBox<>();
        jlblEndDateYear1 = new javax.swing.JLabel();
        jlblEndDateMonth1 = new javax.swing.JLabel();
        jlblEndDateDay1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jpnlQuarterly = new javax.swing.JPanel();
        jspQuarterly = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jpnlFirstQuarter = new javax.swing.JPanel();
        jlblEndDate2 = new javax.swing.JLabel();
        jcmbQ1DeadlineYear = new javax.swing.JComboBox<>();
        jcmbQ1DeadlineMonth = new javax.swing.JComboBox<>();
        jcmbQ1DeadlineDay = new javax.swing.JComboBox<>();
        jlblEndDateYear2 = new javax.swing.JLabel();
        jlblEndDateMonth2 = new javax.swing.JLabel();
        jlblEndDateDay2 = new javax.swing.JLabel();
        jpnlSecondQuarter = new javax.swing.JPanel();
        jlblEndDate3 = new javax.swing.JLabel();
        jcmbQ2DeadlineYear = new javax.swing.JComboBox<>();
        jcmbQ2DeadlineMonth = new javax.swing.JComboBox<>();
        jcmbQ2DeadlineDay = new javax.swing.JComboBox<>();
        jlblEndDateYear3 = new javax.swing.JLabel();
        jlblEndDateMonth3 = new javax.swing.JLabel();
        jlblEndDateDay3 = new javax.swing.JLabel();
        jpnlThirdQuarter = new javax.swing.JPanel();
        jlblEndDate6 = new javax.swing.JLabel();
        jcmbQ3DeadlineYear = new javax.swing.JComboBox<>();
        jcmbQ3DeadlineMonth = new javax.swing.JComboBox<>();
        jcmbQ3DeadlineDay = new javax.swing.JComboBox<>();
        jlblEndDateYear6 = new javax.swing.JLabel();
        jlblEndDateMonth6 = new javax.swing.JLabel();
        jlblEndDateDay6 = new javax.swing.JLabel();
        jpnlThirdQuarter1 = new javax.swing.JPanel();
        jlblEndDate7 = new javax.swing.JLabel();
        jcmbQ4DeadlineYear = new javax.swing.JComboBox<>();
        jcmbQ4DeadlineMonth = new javax.swing.JComboBox<>();
        jcmbQ4DeadlineDay = new javax.swing.JComboBox<>();
        jlblEndDateYear7 = new javax.swing.JLabel();
        jlblEndDateMonth7 = new javax.swing.JLabel();
        jlblEndDateDay7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jpnlMonthly = new javax.swing.JPanel();
        jspMonthly = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jpnlFirstMonth = new javax.swing.JPanel();
        jlblEndDate4 = new javax.swing.JLabel();
        jcmbMo1DeadlineYear = new javax.swing.JComboBox<>();
        jcmbMo1DeadlineMonth = new javax.swing.JComboBox<>();
        jcmbMo1DeadlineDay = new javax.swing.JComboBox<>();
        jlblEndDateYear4 = new javax.swing.JLabel();
        jlblEndDateMonth4 = new javax.swing.JLabel();
        jlblEndDateDay4 = new javax.swing.JLabel();
        jpnlSecondMonth = new javax.swing.JPanel();
        jlblEndDate5 = new javax.swing.JLabel();
        jcmbMo2DeadlineYear = new javax.swing.JComboBox<>();
        jcmbMo2DeadlineMonth = new javax.swing.JComboBox<>();
        jcmbMo2DeadlineDay = new javax.swing.JComboBox<>();
        jlblEndDateYear5 = new javax.swing.JLabel();
        jlblEndDateMonth5 = new javax.swing.JLabel();
        jlblEndDateDay5 = new javax.swing.JLabel();
        jpnlThirdMonth = new javax.swing.JPanel();
        jlblEndDate8 = new javax.swing.JLabel();
        jcmbMo3DeadlineYear = new javax.swing.JComboBox<>();
        jcmbMo3DeadlineMonth = new javax.swing.JComboBox<>();
        jcmbMo3DeadlineDay = new javax.swing.JComboBox<>();
        jlblEndDateYear8 = new javax.swing.JLabel();
        jlblEndDateMonth8 = new javax.swing.JLabel();
        jlblEndDateDay8 = new javax.swing.JLabel();
        jpnlFourthMonth = new javax.swing.JPanel();
        jlblEndDate9 = new javax.swing.JLabel();
        jcmbMo4DeadlineYear = new javax.swing.JComboBox<>();
        jcmbMo4DeadlineMonth = new javax.swing.JComboBox<>();
        jcmbMo4DeadlineDay = new javax.swing.JComboBox<>();
        jlblEndDateYear9 = new javax.swing.JLabel();
        jlblEndDateMonth9 = new javax.swing.JLabel();
        jlblEndDateDay9 = new javax.swing.JLabel();
        jpnlFifthMonth = new javax.swing.JPanel();
        jlblEndDate10 = new javax.swing.JLabel();
        jcmbMo5DeadlineYear = new javax.swing.JComboBox<>();
        jcmbMo5DeadlineMonth = new javax.swing.JComboBox<>();
        jcmbMo5DeadlineDay = new javax.swing.JComboBox<>();
        jlblEndDateYear10 = new javax.swing.JLabel();
        jlblEndDateMonth10 = new javax.swing.JLabel();
        jlblEndDateDay10 = new javax.swing.JLabel();
        jpnlSixthMonth = new javax.swing.JPanel();
        jlblEndDate11 = new javax.swing.JLabel();
        jcmbMo6DeadlineYear = new javax.swing.JComboBox<>();
        jcmbMo6DeadlineMonth = new javax.swing.JComboBox<>();
        jcmbMo6DeadlineDay = new javax.swing.JComboBox<>();
        jlblEndDateYear11 = new javax.swing.JLabel();
        jlblEndDateMonth11 = new javax.swing.JLabel();
        jlblEndDateDay11 = new javax.swing.JLabel();
        jpnlSeventhMonth = new javax.swing.JPanel();
        jlblEndDate12 = new javax.swing.JLabel();
        jcmbMo7DeadlineYear = new javax.swing.JComboBox<>();
        jcmbMo7DeadlineMonth = new javax.swing.JComboBox<>();
        jcmbMo7DeadlineDay = new javax.swing.JComboBox<>();
        jlblEndDateYear12 = new javax.swing.JLabel();
        jlblEndDateMonth12 = new javax.swing.JLabel();
        jlblEndDateDay12 = new javax.swing.JLabel();
        jpnlEigthMonth = new javax.swing.JPanel();
        jlblEndDate13 = new javax.swing.JLabel();
        jcmbMo8DeadlineYear = new javax.swing.JComboBox<>();
        jcmbMo8DeadlineMonth = new javax.swing.JComboBox<>();
        jcmbMo8DeadlineDay = new javax.swing.JComboBox<>();
        jlblEndDateYear13 = new javax.swing.JLabel();
        jlblEndDateMonth13 = new javax.swing.JLabel();
        jlblEndDateDay13 = new javax.swing.JLabel();
        jpnlNinthMonth = new javax.swing.JPanel();
        jlblEndDate14 = new javax.swing.JLabel();
        jcmbMo9DeadlineYear = new javax.swing.JComboBox<>();
        jcmbMo9DeadlineMonth = new javax.swing.JComboBox<>();
        jcmbMo9DeadlineDay = new javax.swing.JComboBox<>();
        jlblEndDateYear14 = new javax.swing.JLabel();
        jlblEndDateMonth14 = new javax.swing.JLabel();
        jlblEndDateDay14 = new javax.swing.JLabel();
        jpnlTenthMonth = new javax.swing.JPanel();
        jlblEndDate15 = new javax.swing.JLabel();
        jcmbMo10DeadlineYear = new javax.swing.JComboBox<>();
        jcmbMo10DeadlineMonth = new javax.swing.JComboBox<>();
        jcmbMo10DeadlineDay = new javax.swing.JComboBox<>();
        jlblEndDateYear15 = new javax.swing.JLabel();
        jlblEndDateMonth15 = new javax.swing.JLabel();
        jlblEndDateDay15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jmbPaymentSchedule = new javax.swing.JMenuBar();
        jmnFile = new javax.swing.JMenu();
        jmiCreate = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmiEdit = new javax.swing.JMenuItem();

        setLayout(new java.awt.GridBagLayout());

        jifPaymentSchedule.setBorder(null);
        jifPaymentSchedule.setTitle("Payment and Penalty Settings");
        jifPaymentSchedule.setVisible(true);
        jifPaymentSchedule.getContentPane().setLayout(new java.awt.GridBagLayout());

        jpnlTop.setLayout(new java.awt.GridBagLayout());

        jpnlFilter.setBorder(javax.swing.BorderFactory.createTitledBorder("School Year"));
        jpnlFilter.setLayout(new java.awt.GridBagLayout());

        jspSchoolYear.setPreferredSize(new java.awt.Dimension(80, 147));

        jspSchoolYear.setViewportView(jlstSchoolYear);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFilter.add(jspSchoolYear, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlTop.add(jpnlFilter, gridBagConstraints);

        jpnlSemestral.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Semestral", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jpnlSemestral.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jpnlSemestralFirstPayment.setBorder(javax.swing.BorderFactory.createTitledBorder("First Semester"));
        jpnlSemestralFirstPayment.setLayout(new java.awt.GridBagLayout());

        jlblEndDate.setText("Deadline");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSemestralFirstPayment.add(jlblEndDate, gridBagConstraints);

        jcmbSem1DeadlineYear.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSemestralFirstPayment.add(jcmbSem1DeadlineYear, gridBagConstraints);

        jcmbSem1DeadlineMonth.setPreferredSize(new java.awt.Dimension(43, 26));
        jcmbSem1DeadlineMonth.setRenderer(new component_renderers.JComboBoxRenderer_Month("--"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSemestralFirstPayment.add(jcmbSem1DeadlineMonth, gridBagConstraints);

        jcmbSem1DeadlineDay.setPreferredSize(new java.awt.Dimension(43, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSemestralFirstPayment.add(jcmbSem1DeadlineDay, gridBagConstraints);

        jlblEndDateYear.setText("Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSemestralFirstPayment.add(jlblEndDateYear, gridBagConstraints);

        jlblEndDateMonth.setText("Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSemestralFirstPayment.add(jlblEndDateMonth, gridBagConstraints);

        jlblEndDateDay.setText("Day");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSemestralFirstPayment.add(jlblEndDateDay, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jpnlSemestralFirstPayment, gridBagConstraints);

        jpnlSemestralSecondPayment.setBorder(javax.swing.BorderFactory.createTitledBorder("Second Semester"));
        jpnlSemestralSecondPayment.setLayout(new java.awt.GridBagLayout());

        jlblEndDate1.setText("Deadline");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSemestralSecondPayment.add(jlblEndDate1, gridBagConstraints);

        jcmbSem2DeadlineYear.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSemestralSecondPayment.add(jcmbSem2DeadlineYear, gridBagConstraints);

        jcmbSem2DeadlineMonth.setPreferredSize(new java.awt.Dimension(43, 26));
        jcmbSem2DeadlineMonth.setRenderer(new component_renderers.JComboBoxRenderer_Month("--"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSemestralSecondPayment.add(jcmbSem2DeadlineMonth, gridBagConstraints);

        jcmbSem2DeadlineDay.setPreferredSize(new java.awt.Dimension(43, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSemestralSecondPayment.add(jcmbSem2DeadlineDay, gridBagConstraints);

        jlblEndDateYear1.setText("Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSemestralSecondPayment.add(jlblEndDateYear1, gridBagConstraints);

        jlblEndDateMonth1.setText("Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSemestralSecondPayment.add(jlblEndDateMonth1, gridBagConstraints);

        jlblEndDateDay1.setText("Day");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSemestralSecondPayment.add(jlblEndDateDay1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jpnlSemestralSecondPayment, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Late  Fee:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jLabel1, gridBagConstraints);

        jTextField1.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jTextField1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jPanel1, gridBagConstraints);

        jspSemestral.setViewportView(jPanel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSemestral.add(jspSemestral, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlTop.add(jpnlSemestral, gridBagConstraints);

        jpnlQuarterly.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quarterly", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jpnlQuarterly.setLayout(new java.awt.GridBagLayout());

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jpnlFirstQuarter.setBorder(javax.swing.BorderFactory.createTitledBorder("First Quarter"));
        jpnlFirstQuarter.setLayout(new java.awt.GridBagLayout());

        jlblEndDate2.setText("Deadline");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFirstQuarter.add(jlblEndDate2, gridBagConstraints);

        jcmbQ1DeadlineYear.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFirstQuarter.add(jcmbQ1DeadlineYear, gridBagConstraints);

        jcmbQ1DeadlineMonth.setPreferredSize(new java.awt.Dimension(43, 26));
        jcmbQ1DeadlineMonth.setRenderer(new component_renderers.JComboBoxRenderer_Month("--"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFirstQuarter.add(jcmbQ1DeadlineMonth, gridBagConstraints);

        jcmbQ1DeadlineDay.setPreferredSize(new java.awt.Dimension(43, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFirstQuarter.add(jcmbQ1DeadlineDay, gridBagConstraints);

        jlblEndDateYear2.setText("Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFirstQuarter.add(jlblEndDateYear2, gridBagConstraints);

        jlblEndDateMonth2.setText("Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFirstQuarter.add(jlblEndDateMonth2, gridBagConstraints);

        jlblEndDateDay2.setText("Day");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFirstQuarter.add(jlblEndDateDay2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jpnlFirstQuarter, gridBagConstraints);

        jpnlSecondQuarter.setBorder(javax.swing.BorderFactory.createTitledBorder("Second Quarter"));
        jpnlSecondQuarter.setLayout(new java.awt.GridBagLayout());

        jlblEndDate3.setText("Deadline");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSecondQuarter.add(jlblEndDate3, gridBagConstraints);

        jcmbQ2DeadlineYear.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSecondQuarter.add(jcmbQ2DeadlineYear, gridBagConstraints);

        jcmbQ2DeadlineMonth.setPreferredSize(new java.awt.Dimension(43, 26));
        jcmbQ2DeadlineMonth.setRenderer(new component_renderers.JComboBoxRenderer_Month("--"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSecondQuarter.add(jcmbQ2DeadlineMonth, gridBagConstraints);

        jcmbQ2DeadlineDay.setPreferredSize(new java.awt.Dimension(43, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSecondQuarter.add(jcmbQ2DeadlineDay, gridBagConstraints);

        jlblEndDateYear3.setText("Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSecondQuarter.add(jlblEndDateYear3, gridBagConstraints);

        jlblEndDateMonth3.setText("Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSecondQuarter.add(jlblEndDateMonth3, gridBagConstraints);

        jlblEndDateDay3.setText("Day");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSecondQuarter.add(jlblEndDateDay3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jpnlSecondQuarter, gridBagConstraints);

        jpnlThirdQuarter.setBorder(javax.swing.BorderFactory.createTitledBorder("Third Quarter"));
        jpnlThirdQuarter.setLayout(new java.awt.GridBagLayout());

        jlblEndDate6.setText("Deadline");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdQuarter.add(jlblEndDate6, gridBagConstraints);

        jcmbQ3DeadlineYear.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdQuarter.add(jcmbQ3DeadlineYear, gridBagConstraints);

        jcmbQ3DeadlineMonth.setPreferredSize(new java.awt.Dimension(43, 26));
        jcmbQ3DeadlineMonth.setRenderer(new component_renderers.JComboBoxRenderer_Month("--"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdQuarter.add(jcmbQ3DeadlineMonth, gridBagConstraints);

        jcmbQ3DeadlineDay.setPreferredSize(new java.awt.Dimension(43, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdQuarter.add(jcmbQ3DeadlineDay, gridBagConstraints);

        jlblEndDateYear6.setText("Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdQuarter.add(jlblEndDateYear6, gridBagConstraints);

        jlblEndDateMonth6.setText("Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdQuarter.add(jlblEndDateMonth6, gridBagConstraints);

        jlblEndDateDay6.setText("Day");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdQuarter.add(jlblEndDateDay6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jpnlThirdQuarter, gridBagConstraints);

        jpnlThirdQuarter1.setBorder(javax.swing.BorderFactory.createTitledBorder("Fourth Quarter"));
        jpnlThirdQuarter1.setLayout(new java.awt.GridBagLayout());

        jlblEndDate7.setText("Deadline");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdQuarter1.add(jlblEndDate7, gridBagConstraints);

        jcmbQ4DeadlineYear.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdQuarter1.add(jcmbQ4DeadlineYear, gridBagConstraints);

        jcmbQ4DeadlineMonth.setPreferredSize(new java.awt.Dimension(43, 26));
        jcmbQ4DeadlineMonth.setRenderer(new component_renderers.JComboBoxRenderer_Month("--"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdQuarter1.add(jcmbQ4DeadlineMonth, gridBagConstraints);

        jcmbQ4DeadlineDay.setPreferredSize(new java.awt.Dimension(43, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdQuarter1.add(jcmbQ4DeadlineDay, gridBagConstraints);

        jlblEndDateYear7.setText("Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdQuarter1.add(jlblEndDateYear7, gridBagConstraints);

        jlblEndDateMonth7.setText("Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdQuarter1.add(jlblEndDateMonth7, gridBagConstraints);

        jlblEndDateDay7.setText("Day");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdQuarter1.add(jlblEndDateDay7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jpnlThirdQuarter1, gridBagConstraints);

        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("Late  Fee:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jLabel3, gridBagConstraints);

        jTextField3.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jTextField3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jPanel6, gridBagConstraints);

        jspQuarterly.setViewportView(jPanel3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlQuarterly.add(jspQuarterly, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlTop.add(jpnlQuarterly, gridBagConstraints);

        jpnlMonthly.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monthly", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jpnlMonthly.setLayout(new java.awt.GridBagLayout());

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jpnlFirstMonth.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "1st Month", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jpnlFirstMonth.setLayout(new java.awt.GridBagLayout());

        jlblEndDate4.setText("Deadline");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFirstMonth.add(jlblEndDate4, gridBagConstraints);

        jcmbMo1DeadlineYear.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFirstMonth.add(jcmbMo1DeadlineYear, gridBagConstraints);

        jcmbMo1DeadlineMonth.setPreferredSize(new java.awt.Dimension(43, 26));
        jcmbMo1DeadlineMonth.setRenderer(new component_renderers.JComboBoxRenderer_Month("--"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFirstMonth.add(jcmbMo1DeadlineMonth, gridBagConstraints);

        jcmbMo1DeadlineDay.setPreferredSize(new java.awt.Dimension(43, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFirstMonth.add(jcmbMo1DeadlineDay, gridBagConstraints);

        jlblEndDateYear4.setText("Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFirstMonth.add(jlblEndDateYear4, gridBagConstraints);

        jlblEndDateMonth4.setText("Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFirstMonth.add(jlblEndDateMonth4, gridBagConstraints);

        jlblEndDateDay4.setText("Day");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFirstMonth.add(jlblEndDateDay4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jpnlFirstMonth, gridBagConstraints);

        jpnlSecondMonth.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "2nd Month", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jpnlSecondMonth.setLayout(new java.awt.GridBagLayout());

        jlblEndDate5.setText("Deadline");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSecondMonth.add(jlblEndDate5, gridBagConstraints);

        jcmbMo2DeadlineYear.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSecondMonth.add(jcmbMo2DeadlineYear, gridBagConstraints);

        jcmbMo2DeadlineMonth.setPreferredSize(new java.awt.Dimension(43, 26));
        jcmbMo2DeadlineMonth.setRenderer(new component_renderers.JComboBoxRenderer_Month("--"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSecondMonth.add(jcmbMo2DeadlineMonth, gridBagConstraints);

        jcmbMo2DeadlineDay.setPreferredSize(new java.awt.Dimension(43, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSecondMonth.add(jcmbMo2DeadlineDay, gridBagConstraints);

        jlblEndDateYear5.setText("Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSecondMonth.add(jlblEndDateYear5, gridBagConstraints);

        jlblEndDateMonth5.setText("Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSecondMonth.add(jlblEndDateMonth5, gridBagConstraints);

        jlblEndDateDay5.setText("Day");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSecondMonth.add(jlblEndDateDay5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jpnlSecondMonth, gridBagConstraints);

        jpnlThirdMonth.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "3rd Month", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jpnlThirdMonth.setLayout(new java.awt.GridBagLayout());

        jlblEndDate8.setText("Deadline");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdMonth.add(jlblEndDate8, gridBagConstraints);

        jcmbMo3DeadlineYear.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdMonth.add(jcmbMo3DeadlineYear, gridBagConstraints);

        jcmbMo3DeadlineMonth.setPreferredSize(new java.awt.Dimension(43, 26));
        jcmbMo3DeadlineMonth.setRenderer(new component_renderers.JComboBoxRenderer_Month("--"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdMonth.add(jcmbMo3DeadlineMonth, gridBagConstraints);

        jcmbMo3DeadlineDay.setPreferredSize(new java.awt.Dimension(43, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdMonth.add(jcmbMo3DeadlineDay, gridBagConstraints);

        jlblEndDateYear8.setText("Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdMonth.add(jlblEndDateYear8, gridBagConstraints);

        jlblEndDateMonth8.setText("Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdMonth.add(jlblEndDateMonth8, gridBagConstraints);

        jlblEndDateDay8.setText("Day");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdMonth.add(jlblEndDateDay8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jpnlThirdMonth, gridBagConstraints);

        jpnlFourthMonth.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "4th Month", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jpnlFourthMonth.setLayout(new java.awt.GridBagLayout());

        jlblEndDate9.setText("Deadline");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFourthMonth.add(jlblEndDate9, gridBagConstraints);

        jcmbMo4DeadlineYear.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFourthMonth.add(jcmbMo4DeadlineYear, gridBagConstraints);

        jcmbMo4DeadlineMonth.setPreferredSize(new java.awt.Dimension(43, 26));
        jcmbMo4DeadlineMonth.setRenderer(new component_renderers.JComboBoxRenderer_Month("--"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFourthMonth.add(jcmbMo4DeadlineMonth, gridBagConstraints);

        jcmbMo4DeadlineDay.setPreferredSize(new java.awt.Dimension(43, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFourthMonth.add(jcmbMo4DeadlineDay, gridBagConstraints);

        jlblEndDateYear9.setText("Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFourthMonth.add(jlblEndDateYear9, gridBagConstraints);

        jlblEndDateMonth9.setText("Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFourthMonth.add(jlblEndDateMonth9, gridBagConstraints);

        jlblEndDateDay9.setText("Day");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFourthMonth.add(jlblEndDateDay9, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jpnlFourthMonth, gridBagConstraints);

        jpnlFifthMonth.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "5th Month", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jpnlFifthMonth.setLayout(new java.awt.GridBagLayout());

        jlblEndDate10.setText("Deadline");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFifthMonth.add(jlblEndDate10, gridBagConstraints);

        jcmbMo5DeadlineYear.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFifthMonth.add(jcmbMo5DeadlineYear, gridBagConstraints);

        jcmbMo5DeadlineMonth.setPreferredSize(new java.awt.Dimension(43, 26));
        jcmbMo5DeadlineMonth.setRenderer(new component_renderers.JComboBoxRenderer_Month("--"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFifthMonth.add(jcmbMo5DeadlineMonth, gridBagConstraints);

        jcmbMo5DeadlineDay.setPreferredSize(new java.awt.Dimension(43, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFifthMonth.add(jcmbMo5DeadlineDay, gridBagConstraints);

        jlblEndDateYear10.setText("Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFifthMonth.add(jlblEndDateYear10, gridBagConstraints);

        jlblEndDateMonth10.setText("Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFifthMonth.add(jlblEndDateMonth10, gridBagConstraints);

        jlblEndDateDay10.setText("Day");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFifthMonth.add(jlblEndDateDay10, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jpnlFifthMonth, gridBagConstraints);

        jpnlSixthMonth.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "6th Month", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jpnlSixthMonth.setLayout(new java.awt.GridBagLayout());

        jlblEndDate11.setText("Deadline");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSixthMonth.add(jlblEndDate11, gridBagConstraints);

        jcmbMo6DeadlineYear.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSixthMonth.add(jcmbMo6DeadlineYear, gridBagConstraints);

        jcmbMo6DeadlineMonth.setPreferredSize(new java.awt.Dimension(43, 26));
        jcmbMo6DeadlineMonth.setRenderer(new component_renderers.JComboBoxRenderer_Month("--"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSixthMonth.add(jcmbMo6DeadlineMonth, gridBagConstraints);

        jcmbMo6DeadlineDay.setPreferredSize(new java.awt.Dimension(43, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSixthMonth.add(jcmbMo6DeadlineDay, gridBagConstraints);

        jlblEndDateYear11.setText("Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSixthMonth.add(jlblEndDateYear11, gridBagConstraints);

        jlblEndDateMonth11.setText("Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSixthMonth.add(jlblEndDateMonth11, gridBagConstraints);

        jlblEndDateDay11.setText("Day");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSixthMonth.add(jlblEndDateDay11, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jpnlSixthMonth, gridBagConstraints);

        jpnlSeventhMonth.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "7th Month", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jpnlSeventhMonth.setLayout(new java.awt.GridBagLayout());

        jlblEndDate12.setText("Deadline");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSeventhMonth.add(jlblEndDate12, gridBagConstraints);

        jcmbMo7DeadlineYear.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSeventhMonth.add(jcmbMo7DeadlineYear, gridBagConstraints);

        jcmbMo7DeadlineMonth.setPreferredSize(new java.awt.Dimension(43, 26));
        jcmbMo7DeadlineMonth.setRenderer(new component_renderers.JComboBoxRenderer_Month("--"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSeventhMonth.add(jcmbMo7DeadlineMonth, gridBagConstraints);

        jcmbMo7DeadlineDay.setPreferredSize(new java.awt.Dimension(43, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSeventhMonth.add(jcmbMo7DeadlineDay, gridBagConstraints);

        jlblEndDateYear12.setText("Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSeventhMonth.add(jlblEndDateYear12, gridBagConstraints);

        jlblEndDateMonth12.setText("Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSeventhMonth.add(jlblEndDateMonth12, gridBagConstraints);

        jlblEndDateDay12.setText("Day");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSeventhMonth.add(jlblEndDateDay12, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jpnlSeventhMonth, gridBagConstraints);

        jpnlEigthMonth.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "8th Month", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jpnlEigthMonth.setLayout(new java.awt.GridBagLayout());

        jlblEndDate13.setText("Deadline");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlEigthMonth.add(jlblEndDate13, gridBagConstraints);

        jcmbMo8DeadlineYear.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlEigthMonth.add(jcmbMo8DeadlineYear, gridBagConstraints);

        jcmbMo8DeadlineMonth.setPreferredSize(new java.awt.Dimension(43, 26));
        jcmbMo8DeadlineMonth.setRenderer(new component_renderers.JComboBoxRenderer_Month("--"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlEigthMonth.add(jcmbMo8DeadlineMonth, gridBagConstraints);

        jcmbMo8DeadlineDay.setPreferredSize(new java.awt.Dimension(43, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlEigthMonth.add(jcmbMo8DeadlineDay, gridBagConstraints);

        jlblEndDateYear13.setText("Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlEigthMonth.add(jlblEndDateYear13, gridBagConstraints);

        jlblEndDateMonth13.setText("Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlEigthMonth.add(jlblEndDateMonth13, gridBagConstraints);

        jlblEndDateDay13.setText("Day");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlEigthMonth.add(jlblEndDateDay13, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jpnlEigthMonth, gridBagConstraints);

        jpnlNinthMonth.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "9th Month", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jpnlNinthMonth.setLayout(new java.awt.GridBagLayout());

        jlblEndDate14.setText("Deadline");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlNinthMonth.add(jlblEndDate14, gridBagConstraints);

        jcmbMo9DeadlineYear.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlNinthMonth.add(jcmbMo9DeadlineYear, gridBagConstraints);

        jcmbMo9DeadlineMonth.setPreferredSize(new java.awt.Dimension(43, 26));
        jcmbMo9DeadlineMonth.setRenderer(new component_renderers.JComboBoxRenderer_Month("--"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlNinthMonth.add(jcmbMo9DeadlineMonth, gridBagConstraints);

        jcmbMo9DeadlineDay.setPreferredSize(new java.awt.Dimension(43, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlNinthMonth.add(jcmbMo9DeadlineDay, gridBagConstraints);

        jlblEndDateYear14.setText("Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlNinthMonth.add(jlblEndDateYear14, gridBagConstraints);

        jlblEndDateMonth14.setText("Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlNinthMonth.add(jlblEndDateMonth14, gridBagConstraints);

        jlblEndDateDay14.setText("Day");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlNinthMonth.add(jlblEndDateDay14, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jpnlNinthMonth, gridBagConstraints);

        jpnlTenthMonth.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "10th Month", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jpnlTenthMonth.setLayout(new java.awt.GridBagLayout());

        jlblEndDate15.setText("Deadline");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlTenthMonth.add(jlblEndDate15, gridBagConstraints);

        jcmbMo10DeadlineYear.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlTenthMonth.add(jcmbMo10DeadlineYear, gridBagConstraints);

        jcmbMo10DeadlineMonth.setPreferredSize(new java.awt.Dimension(43, 26));
        jcmbMo10DeadlineMonth.setRenderer(new component_renderers.JComboBoxRenderer_Month("--"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlTenthMonth.add(jcmbMo10DeadlineMonth, gridBagConstraints);

        jcmbMo10DeadlineDay.setPreferredSize(new java.awt.Dimension(43, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlTenthMonth.add(jcmbMo10DeadlineDay, gridBagConstraints);

        jlblEndDateYear15.setText("Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlTenthMonth.add(jlblEndDateYear15, gridBagConstraints);

        jlblEndDateMonth15.setText("Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlTenthMonth.add(jlblEndDateMonth15, gridBagConstraints);

        jlblEndDateDay15.setText("Day");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlTenthMonth.add(jlblEndDateDay15, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jpnlTenthMonth, gridBagConstraints);

        jspMonthly.setViewportView(jPanel4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlMonthly.add(jspMonthly, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Late  Fee:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jLabel2, gridBagConstraints);

        jTextField2.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jTextField2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlMonthly.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlTop.add(jpnlMonthly, gridBagConstraints);

        jspTop.setViewportView(jpnlTop);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jifPaymentSchedule.getContentPane().add(jspTop, gridBagConstraints);

        jmnFile.setText("Action");

        jmiCreate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jmiCreate.setText("Create Schedule");
        jmnFile.add(jmiCreate);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Create Penalty");
        jmnFile.add(jMenuItem1);

        jmiEdit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jmiEdit.setText("Edit ");
        jmiEdit.setEnabled(false);
        jmnFile.add(jmiEdit);

        jmbPaymentSchedule.add(jmnFile);

        jifPaymentSchedule.setJMenuBar(jmbPaymentSchedule);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jifPaymentSchedule, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void setYearsModel(){
        jcmbSem1DeadlineYear.setModel(CalendarML.getCurrentYearToNYears(10));
        jcmbSem2DeadlineYear.setModel(CalendarML.getCurrentYearToNYears(10));
        
        jcmbQ1DeadlineYear.setModel(CalendarML.getCurrentYearToNYears(10));
        jcmbQ2DeadlineYear.setModel(CalendarML.getCurrentYearToNYears(10));
        jcmbQ3DeadlineYear.setModel(CalendarML.getCurrentYearToNYears(10));
        jcmbQ4DeadlineYear.setModel(CalendarML.getCurrentYearToNYears(10));
        
        jcmbMo1DeadlineYear.setModel(CalendarML.getCurrentYearToNYears(10));
        jcmbMo2DeadlineYear.setModel(CalendarML.getCurrentYearToNYears(10));
        jcmbMo3DeadlineYear.setModel(CalendarML.getCurrentYearToNYears(10));
        jcmbMo4DeadlineYear.setModel(CalendarML.getCurrentYearToNYears(10));
        jcmbMo5DeadlineYear.setModel(CalendarML.getCurrentYearToNYears(10));
        jcmbMo6DeadlineYear.setModel(CalendarML.getCurrentYearToNYears(10));
        jcmbMo7DeadlineYear.setModel(CalendarML.getCurrentYearToNYears(10));
        jcmbMo8DeadlineYear.setModel(CalendarML.getCurrentYearToNYears(10));
        jcmbMo9DeadlineYear.setModel(CalendarML.getCurrentYearToNYears(10));
        jcmbMo10DeadlineYear.setModel(CalendarML.getCurrentYearToNYears(10));
    }
    
    private void setMonthsModel(){
        DefaultComboBoxModel months = CalendarML.getMonthsOfYear();
        
        jcmbSem1DeadlineMonth.setModel(months);
        jcmbSem2DeadlineMonth.setModel(months);
        jcmbQ1DeadlineMonth.setModel(months);
        jcmbQ2DeadlineMonth.setModel(months);
        jcmbQ3DeadlineMonth.setModel(months);
        jcmbQ4DeadlineMonth.setModel(months);
        jcmbMo1DeadlineMonth.setModel(months);
        jcmbMo2DeadlineMonth.setModel(months);
        jcmbMo3DeadlineMonth.setModel(months);
        jcmbMo4DeadlineMonth.setModel(months);
        jcmbMo5DeadlineMonth.setModel(months);
        jcmbMo6DeadlineMonth.setModel(months);
        jcmbMo7DeadlineMonth.setModel(months);
        jcmbMo8DeadlineMonth.setModel(months);
        jcmbMo9DeadlineMonth.setModel(months);
        jcmbMo10DeadlineMonth.setModel(months);
    }
    
     private void remove_title_bar(){
        putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        ((BasicInternalFrameUI) jifPaymentSchedule.getUI()).setNorthPane(null);
        this.setBorder(null);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JComboBox<String> jcmbMo10DeadlineDay;
    private javax.swing.JComboBox<String> jcmbMo10DeadlineMonth;
    private javax.swing.JComboBox<String> jcmbMo10DeadlineYear;
    private javax.swing.JComboBox<String> jcmbMo1DeadlineDay;
    private javax.swing.JComboBox<String> jcmbMo1DeadlineMonth;
    private javax.swing.JComboBox<String> jcmbMo1DeadlineYear;
    private javax.swing.JComboBox<String> jcmbMo2DeadlineDay;
    private javax.swing.JComboBox<String> jcmbMo2DeadlineMonth;
    private javax.swing.JComboBox<String> jcmbMo2DeadlineYear;
    private javax.swing.JComboBox<String> jcmbMo3DeadlineDay;
    private javax.swing.JComboBox<String> jcmbMo3DeadlineMonth;
    private javax.swing.JComboBox<String> jcmbMo3DeadlineYear;
    private javax.swing.JComboBox<String> jcmbMo4DeadlineDay;
    private javax.swing.JComboBox<String> jcmbMo4DeadlineMonth;
    private javax.swing.JComboBox<String> jcmbMo4DeadlineYear;
    private javax.swing.JComboBox<String> jcmbMo5DeadlineDay;
    private javax.swing.JComboBox<String> jcmbMo5DeadlineMonth;
    private javax.swing.JComboBox<String> jcmbMo5DeadlineYear;
    private javax.swing.JComboBox<String> jcmbMo6DeadlineDay;
    private javax.swing.JComboBox<String> jcmbMo6DeadlineMonth;
    private javax.swing.JComboBox<String> jcmbMo6DeadlineYear;
    private javax.swing.JComboBox<String> jcmbMo7DeadlineDay;
    private javax.swing.JComboBox<String> jcmbMo7DeadlineMonth;
    private javax.swing.JComboBox<String> jcmbMo7DeadlineYear;
    private javax.swing.JComboBox<String> jcmbMo8DeadlineDay;
    private javax.swing.JComboBox<String> jcmbMo8DeadlineMonth;
    private javax.swing.JComboBox<String> jcmbMo8DeadlineYear;
    private javax.swing.JComboBox<String> jcmbMo9DeadlineDay;
    private javax.swing.JComboBox<String> jcmbMo9DeadlineMonth;
    private javax.swing.JComboBox<String> jcmbMo9DeadlineYear;
    private javax.swing.JComboBox<String> jcmbQ1DeadlineDay;
    private javax.swing.JComboBox<String> jcmbQ1DeadlineMonth;
    private javax.swing.JComboBox<String> jcmbQ1DeadlineYear;
    private javax.swing.JComboBox<String> jcmbQ2DeadlineDay;
    private javax.swing.JComboBox<String> jcmbQ2DeadlineMonth;
    private javax.swing.JComboBox<String> jcmbQ2DeadlineYear;
    private javax.swing.JComboBox<String> jcmbQ3DeadlineDay;
    private javax.swing.JComboBox<String> jcmbQ3DeadlineMonth;
    private javax.swing.JComboBox<String> jcmbQ3DeadlineYear;
    private javax.swing.JComboBox<String> jcmbQ4DeadlineDay;
    private javax.swing.JComboBox<String> jcmbQ4DeadlineMonth;
    private javax.swing.JComboBox<String> jcmbQ4DeadlineYear;
    private javax.swing.JComboBox<String> jcmbSem1DeadlineDay;
    private javax.swing.JComboBox<String> jcmbSem1DeadlineMonth;
    private javax.swing.JComboBox<String> jcmbSem1DeadlineYear;
    private javax.swing.JComboBox<String> jcmbSem2DeadlineDay;
    private javax.swing.JComboBox<String> jcmbSem2DeadlineMonth;
    private javax.swing.JComboBox<String> jcmbSem2DeadlineYear;
    private javax.swing.JInternalFrame jifPaymentSchedule;
    private javax.swing.JLabel jlblEndDate;
    private javax.swing.JLabel jlblEndDate1;
    private javax.swing.JLabel jlblEndDate10;
    private javax.swing.JLabel jlblEndDate11;
    private javax.swing.JLabel jlblEndDate12;
    private javax.swing.JLabel jlblEndDate13;
    private javax.swing.JLabel jlblEndDate14;
    private javax.swing.JLabel jlblEndDate15;
    private javax.swing.JLabel jlblEndDate2;
    private javax.swing.JLabel jlblEndDate3;
    private javax.swing.JLabel jlblEndDate4;
    private javax.swing.JLabel jlblEndDate5;
    private javax.swing.JLabel jlblEndDate6;
    private javax.swing.JLabel jlblEndDate7;
    private javax.swing.JLabel jlblEndDate8;
    private javax.swing.JLabel jlblEndDate9;
    private javax.swing.JLabel jlblEndDateDay;
    private javax.swing.JLabel jlblEndDateDay1;
    private javax.swing.JLabel jlblEndDateDay10;
    private javax.swing.JLabel jlblEndDateDay11;
    private javax.swing.JLabel jlblEndDateDay12;
    private javax.swing.JLabel jlblEndDateDay13;
    private javax.swing.JLabel jlblEndDateDay14;
    private javax.swing.JLabel jlblEndDateDay15;
    private javax.swing.JLabel jlblEndDateDay2;
    private javax.swing.JLabel jlblEndDateDay3;
    private javax.swing.JLabel jlblEndDateDay4;
    private javax.swing.JLabel jlblEndDateDay5;
    private javax.swing.JLabel jlblEndDateDay6;
    private javax.swing.JLabel jlblEndDateDay7;
    private javax.swing.JLabel jlblEndDateDay8;
    private javax.swing.JLabel jlblEndDateDay9;
    private javax.swing.JLabel jlblEndDateMonth;
    private javax.swing.JLabel jlblEndDateMonth1;
    private javax.swing.JLabel jlblEndDateMonth10;
    private javax.swing.JLabel jlblEndDateMonth11;
    private javax.swing.JLabel jlblEndDateMonth12;
    private javax.swing.JLabel jlblEndDateMonth13;
    private javax.swing.JLabel jlblEndDateMonth14;
    private javax.swing.JLabel jlblEndDateMonth15;
    private javax.swing.JLabel jlblEndDateMonth2;
    private javax.swing.JLabel jlblEndDateMonth3;
    private javax.swing.JLabel jlblEndDateMonth4;
    private javax.swing.JLabel jlblEndDateMonth5;
    private javax.swing.JLabel jlblEndDateMonth6;
    private javax.swing.JLabel jlblEndDateMonth7;
    private javax.swing.JLabel jlblEndDateMonth8;
    private javax.swing.JLabel jlblEndDateMonth9;
    private javax.swing.JLabel jlblEndDateYear;
    private javax.swing.JLabel jlblEndDateYear1;
    private javax.swing.JLabel jlblEndDateYear10;
    private javax.swing.JLabel jlblEndDateYear11;
    private javax.swing.JLabel jlblEndDateYear12;
    private javax.swing.JLabel jlblEndDateYear13;
    private javax.swing.JLabel jlblEndDateYear14;
    private javax.swing.JLabel jlblEndDateYear15;
    private javax.swing.JLabel jlblEndDateYear2;
    private javax.swing.JLabel jlblEndDateYear3;
    private javax.swing.JLabel jlblEndDateYear4;
    private javax.swing.JLabel jlblEndDateYear5;
    private javax.swing.JLabel jlblEndDateYear6;
    private javax.swing.JLabel jlblEndDateYear7;
    private javax.swing.JLabel jlblEndDateYear8;
    private javax.swing.JLabel jlblEndDateYear9;
    public static javax.swing.JList<String> jlstSchoolYear;
    private javax.swing.JMenuBar jmbPaymentSchedule;
    private javax.swing.JMenuItem jmiCreate;
    private javax.swing.JMenuItem jmiEdit;
    private javax.swing.JMenu jmnFile;
    private javax.swing.JPanel jpnlEigthMonth;
    private javax.swing.JPanel jpnlFifthMonth;
    private javax.swing.JPanel jpnlFilter;
    private javax.swing.JPanel jpnlFirstMonth;
    private javax.swing.JPanel jpnlFirstQuarter;
    private javax.swing.JPanel jpnlFourthMonth;
    private javax.swing.JPanel jpnlMonthly;
    private javax.swing.JPanel jpnlNinthMonth;
    private javax.swing.JPanel jpnlQuarterly;
    private javax.swing.JPanel jpnlSecondMonth;
    private javax.swing.JPanel jpnlSecondQuarter;
    private javax.swing.JPanel jpnlSemestral;
    private javax.swing.JPanel jpnlSemestralFirstPayment;
    private javax.swing.JPanel jpnlSemestralSecondPayment;
    private javax.swing.JPanel jpnlSeventhMonth;
    private javax.swing.JPanel jpnlSixthMonth;
    private javax.swing.JPanel jpnlTenthMonth;
    private javax.swing.JPanel jpnlThirdMonth;
    private javax.swing.JPanel jpnlThirdQuarter;
    private javax.swing.JPanel jpnlThirdQuarter1;
    private javax.swing.JPanel jpnlTop;
    private javax.swing.JScrollPane jspMonthly;
    private javax.swing.JScrollPane jspQuarterly;
    private javax.swing.JScrollPane jspSchoolYear;
    private javax.swing.JScrollPane jspSemestral;
    private javax.swing.JScrollPane jspTop;
    // End of variables declaration//GEN-END:variables
}
