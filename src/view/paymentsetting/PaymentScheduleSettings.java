
package view.paymentsetting;

import controller.paymentsetting.DisplayNewPaymentScheduleController;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author John Ferdinand Antonio
 */
public class PaymentScheduleSettings extends javax.swing.JPanel {
    
    private final DisplayNewPaymentScheduleController displayController;
    
    public PaymentScheduleSettings() {
        initComponents();
        remove_title_bar();
        
        displayController = new DisplayNewPaymentScheduleController(jmiCreate);
        displayController.control();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jifPaymentSchedule = new javax.swing.JInternalFrame();
        jspTop = new javax.swing.JScrollPane();
        jpnlTop = new javax.swing.JPanel();
        jpnlFilter = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jpnlSemestral = new javax.swing.JPanel();
        jspSemestral = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jpnlSemestralFirstPayment = new javax.swing.JPanel();
        jlblEndDate = new javax.swing.JLabel();
        jpnlSemestralSecondPayment = new javax.swing.JPanel();
        jlblEndDate1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpnlQuarterly = new javax.swing.JPanel();
        jspQuarterly = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jpnlFirstQuarter = new javax.swing.JPanel();
        jlblEndDate16 = new javax.swing.JLabel();
        jpnlSecondQuarter = new javax.swing.JPanel();
        jlblEndDate17 = new javax.swing.JLabel();
        jpnlThirdQuarter = new javax.swing.JPanel();
        jlblEndDate18 = new javax.swing.JLabel();
        jpnlThirdQuarter1 = new javax.swing.JPanel();
        jlblEndDate19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jpnlMonthly = new javax.swing.JPanel();
        jspMonthly = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jpnlFirstMonth = new javax.swing.JPanel();
        jlblEndDate20 = new javax.swing.JLabel();
        jpnlSecondMonth = new javax.swing.JPanel();
        jlblEndDate21 = new javax.swing.JLabel();
        jpnlThirdMonth = new javax.swing.JPanel();
        jlblEndDate22 = new javax.swing.JLabel();
        jpnlFourthMonth = new javax.swing.JPanel();
        jlblEndDate23 = new javax.swing.JLabel();
        jpnlFifthMonth = new javax.swing.JPanel();
        jlblEndDate24 = new javax.swing.JLabel();
        jpnlSixthMonth = new javax.swing.JPanel();
        jlblEndDate25 = new javax.swing.JLabel();
        jpnlSeventhMonth = new javax.swing.JPanel();
        jlblEndDate26 = new javax.swing.JLabel();
        jpnlEigthMonth = new javax.swing.JPanel();
        jlblEndDate27 = new javax.swing.JLabel();
        jpnlNinthMonth = new javax.swing.JPanel();
        jlblEndDate28 = new javax.swing.JLabel();
        jpnlTenthMonth = new javax.swing.JPanel();
        jlblEndDate29 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jmbPaymentSchedule = new javax.swing.JMenuBar();
        jmnFile = new javax.swing.JMenu();
        jmiCreate = new javax.swing.JMenuItem();
        jmiEdit = new javax.swing.JMenuItem();

        setLayout(new java.awt.GridBagLayout());

        jifPaymentSchedule.setBorder(null);
        jifPaymentSchedule.setTitle("Payment Schedule");
        jifPaymentSchedule.setVisible(true);
        jifPaymentSchedule.getContentPane().setLayout(new java.awt.GridBagLayout());

        jpnlTop.setLayout(new java.awt.GridBagLayout());

        jpnlFilter.setBorder(javax.swing.BorderFactory.createTitledBorder("School Year"));
        jpnlFilter.setPreferredSize(new java.awt.Dimension(98, 50));
        jpnlFilter.setLayout(new java.awt.GridBagLayout());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFilter.add(jComboBox1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlTop.add(jpnlFilter, gridBagConstraints);

        jpnlSemestral.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Semestral", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jpnlSemestral.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jpnlSemestralFirstPayment.setBorder(javax.swing.BorderFactory.createTitledBorder("First Semester"));
        jpnlSemestralFirstPayment.setLayout(new java.awt.GridBagLayout());

        jlblEndDate.setText("Payment Deadline :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSemestralFirstPayment.add(jlblEndDate, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jpnlSemestralFirstPayment, gridBagConstraints);

        jpnlSemestralSecondPayment.setBorder(javax.swing.BorderFactory.createTitledBorder("Second Semester"));
        jpnlSemestralSecondPayment.setLayout(new java.awt.GridBagLayout());

        jlblEndDate1.setText("Payment Deadline : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSemestralSecondPayment.add(jlblEndDate1, gridBagConstraints);

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

        jlblEndDate16.setText("Payment Deadline :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFirstQuarter.add(jlblEndDate16, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jpnlFirstQuarter, gridBagConstraints);

        jpnlSecondQuarter.setBorder(javax.swing.BorderFactory.createTitledBorder("Second Quarter"));
        jpnlSecondQuarter.setLayout(new java.awt.GridBagLayout());

        jlblEndDate17.setText("Payment Deadline :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSecondQuarter.add(jlblEndDate17, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jpnlSecondQuarter, gridBagConstraints);

        jpnlThirdQuarter.setBorder(javax.swing.BorderFactory.createTitledBorder("Third Quarter"));
        jpnlThirdQuarter.setLayout(new java.awt.GridBagLayout());

        jlblEndDate18.setText("Payment Deadline :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdQuarter.add(jlblEndDate18, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jpnlThirdQuarter, gridBagConstraints);

        jpnlThirdQuarter1.setBorder(javax.swing.BorderFactory.createTitledBorder("Fourth Quarter"));
        jpnlThirdQuarter1.setLayout(new java.awt.GridBagLayout());

        jlblEndDate19.setText("Payment Deadline :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdQuarter1.add(jlblEndDate19, gridBagConstraints);

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

        jlblEndDate20.setText("Payment Deadline :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFirstMonth.add(jlblEndDate20, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jpnlFirstMonth, gridBagConstraints);

        jpnlSecondMonth.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "2nd Month", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jpnlSecondMonth.setLayout(new java.awt.GridBagLayout());

        jlblEndDate21.setText("Payment Deadline :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSecondMonth.add(jlblEndDate21, gridBagConstraints);

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

        jlblEndDate22.setText("Payment Deadline :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThirdMonth.add(jlblEndDate22, gridBagConstraints);

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

        jlblEndDate23.setText("Payment Deadline :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFourthMonth.add(jlblEndDate23, gridBagConstraints);

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

        jlblEndDate24.setText("Payment Deadline :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFifthMonth.add(jlblEndDate24, gridBagConstraints);

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

        jlblEndDate25.setText("Payment Deadline :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSixthMonth.add(jlblEndDate25, gridBagConstraints);

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

        jlblEndDate26.setText("Payment Deadline :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSeventhMonth.add(jlblEndDate26, gridBagConstraints);

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

        jlblEndDate27.setText("Payment Deadline :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlEigthMonth.add(jlblEndDate27, gridBagConstraints);

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

        jlblEndDate28.setText("Payment Deadline :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlNinthMonth.add(jlblEndDate28, gridBagConstraints);

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

        jlblEndDate29.setText("Payment Deadline :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlTenthMonth.add(jlblEndDate29, gridBagConstraints);

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

        jmnFile.setText("File");

        jmiCreate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jmiCreate.setText("New Schedule");
        jmnFile.add(jmiCreate);

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

    
    
     private void remove_title_bar(){
        putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        ((BasicInternalFrameUI) jifPaymentSchedule.getUI()).setNorthPane(null);
        this.setBorder(null);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JInternalFrame jifPaymentSchedule;
    private javax.swing.JLabel jlblEndDate;
    private javax.swing.JLabel jlblEndDate1;
    private javax.swing.JLabel jlblEndDate16;
    private javax.swing.JLabel jlblEndDate17;
    private javax.swing.JLabel jlblEndDate18;
    private javax.swing.JLabel jlblEndDate19;
    private javax.swing.JLabel jlblEndDate20;
    private javax.swing.JLabel jlblEndDate21;
    private javax.swing.JLabel jlblEndDate22;
    private javax.swing.JLabel jlblEndDate23;
    private javax.swing.JLabel jlblEndDate24;
    private javax.swing.JLabel jlblEndDate25;
    private javax.swing.JLabel jlblEndDate26;
    private javax.swing.JLabel jlblEndDate27;
    private javax.swing.JLabel jlblEndDate28;
    private javax.swing.JLabel jlblEndDate29;
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
    private javax.swing.JScrollPane jspSemestral;
    private javax.swing.JScrollPane jspTop;
    // End of variables declaration//GEN-END:variables
}
