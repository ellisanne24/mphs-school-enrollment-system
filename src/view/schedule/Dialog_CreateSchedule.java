
package view.schedule;

import component_editor.ScheduleDayCellEditor;
import component_editor.ScheduleRoomCellEditor;
import component_editor.ScheduleTimeCellEditor;
import component_model_loader.GradeLevelJCompModelLoader;
import component_model_loader.RoomJCompModelLoader;
import component_model_loader.SchoolYearJCompModelLoader;
import component_model_loader.SectionJCompModelLoader;
import component_renderers.Renderer_Room_JComboBox;
import component_renderers.Renderer_Schedule_Conflict_JTableCell;
import component_renderers.Renderer_Schedule_GradeLevel_JComboBox;
import component_renderers.Renderer_SchoolYear_JComboBox;
import component_renderers.Renderer_Section_JComboBox;
import controller.schedule.AddRowToSchedule;
import controller.schedule.ClearScheduleFormController;
import controller.schedule.CreateScheduleController2;
import controller.schedule.DayCheckBoxStateChange;
import controller.schedule.GradeLevelStateChangeController;
import controller.schedule.LoadToSummary;
import controller.schedule.RoomStateChange;
import controller.schedule.SectionStateChange;
import controller.schedule.TableModel_Listener_ScheduleSheet_JTable;
import daoimpl.SchoolYearDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ButtonGroup;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import utility.initializer.Initializer;

/**
 *
 * @author John Ferdinand Antonio
 */
public class Dialog_CreateSchedule extends javax.swing.JDialog implements Initializer{

    private SchoolYearDaoImpl schoolYearDaoImpl;
    private SectionJCompModelLoader sectionJCompModelLoader;
    private SchoolYearJCompModelLoader schoolYearJCompModelLoader;
    private GradeLevelJCompModelLoader gradeLevelJCompModelLoader;
    private RoomJCompModelLoader roomJCompModelLoader;

    public Dialog_CreateSchedule(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        initDaoImpl();
        initJCompModelLoaders();
        initRenderers();
        initViewComponents();
        initModels();
        initControllers();
        
        
        initializeTableCellEditors();
//        applyKeyBindings();
//        applyCellEditorListener();
        
    }

    private void initializeControllers() {
//        CreateScheduleController2 createController = new CreateScheduleController2(this);
//        jbtnCreate.addActionListener(createController);
//        jbtnAddRow.addActionListener(new AddRowToSchedule(this));
//        jcmbRoom.addItemListener(new RoomStateChange(this));
//        jbtnClearSchedule.addActionListener(new ClearScheduleFormController(this));
//        jcmbSection.addItemListener(new SectionStateChange(this));
//        jbtnLoadToSummary.addActionListener(new LoadToSummary(this));
    }
    
    public static void initializeTableCellEditors() {
        TableColumnModel columnModel = jtblSchedule.getColumnModel();
        TableColumn daysCol = columnModel.getColumn(0);
        TableColumn roomsCol = columnModel.getColumn(5);
        
        daysCol.setCellEditor(new ScheduleDayCellEditor());
        roomsCol.setCellEditor(new ScheduleRoomCellEditor());
    }
    
    private void applyKeyBindings() {
        InputMap im = jtblSchedule.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap am = jtblSchedule.getActionMap();

        KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

        im.put(enterKey, "Action.enter");
        am.put("Action.enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                int columnSelected = jtblSchedule.getSelectedColumn();
                jtblSchedule.changeSelection(jtblSchedule.getSelectedRow(), columnSelected+1, false, false);
                jtblSchedule.repaint();
                if (!jtblSchedule.editCellAt(jtblSchedule.getSelectedRow(), 2)) {
                    JOptionPane.showMessageDialog(jtblSchedule, "Failed to start cell editing");
                }
            }
        });
    }
    
    private void applyCellEditorListener() {
        jtblSchedule.getDefaultEditor(Object.class).addCellEditorListener(
                new CellEditorListener() {
            @Override
            public void editingCanceled(ChangeEvent e) {
                System.out.println("editingCanceled");
                int columnSelected = jtblSchedule.getSelectedColumn();
                jtblSchedule.changeSelection(jtblSchedule.getSelectedRow(), columnSelected + 1, false, false);
            }

            @Override
            public void editingStopped(ChangeEvent e) {
                System.out.println("editingStopped: apply additional action");
                 int columnSelected = jtblSchedule.getSelectedColumn();
                jtblSchedule.changeSelection(jtblSchedule.getSelectedRow(), columnSelected + 1, false, false);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jbtnGrpDays = new javax.swing.ButtonGroup();
        jpnlCreateSchedule = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jlblGradeLevel = new javax.swing.JLabel();
        jcmbGradeLevel = new javax.swing.JComboBox<>();
        jlblSection = new javax.swing.JLabel();
        jcmbSection = new javax.swing.JComboBox<>();
        jcmbSchoolYearFrom = new javax.swing.JComboBox<>();
        jlblSchoolYear = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jcmbRoom = new javax.swing.JComboBox<>();
        jpnlDaysControl = new javax.swing.JPanel();
        jlblConflictInfo = new javax.swing.JLabel();
        jcbMonday = new javax.swing.JCheckBox();
        jcbTuesday = new javax.swing.JCheckBox();
        jcbWednesday = new javax.swing.JCheckBox();
        jcbThursday = new javax.swing.JCheckBox();
        jcbFriday = new javax.swing.JCheckBox();
        jbtnEditDay = new javax.swing.JButton();
        jcbDayMonWedFri = new javax.swing.JCheckBox();
        jcbDayTueThur = new javax.swing.JCheckBox();
        jpnlScheduleTable = new javax.swing.JPanel();
        jpnlScheduleHeader = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jlblsubSection = new javax.swing.JLabel();
        jlblsubAdviser = new javax.swing.JLabel();
        jlblsubSchoolYear = new javax.swing.JLabel();
        jlblsubGradeLevel = new javax.swing.JLabel();
        jtfSectionName = new javax.swing.JTextField();
        jtfAdviserName = new javax.swing.JTextField();
        jtfSchoolYear = new javax.swing.JTextField();
        jtfGradeLevel = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jspSchedule = new javax.swing.JScrollPane();
        jtblSchedule = new javax.swing.JTable();
        jpnlScheduleSummary = new javax.swing.JPanel();
        jspScheduleSummary = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jpnlMonday = new javax.swing.JPanel();
        jspMonday = new javax.swing.JScrollPane();
        jtblMonday = new javax.swing.JTable();
        jpnlTuesday = new javax.swing.JPanel();
        jspMonday1 = new javax.swing.JScrollPane();
        jtblTuesday = new javax.swing.JTable();
        jpnlWednesday = new javax.swing.JPanel();
        jspMonday2 = new javax.swing.JScrollPane();
        jtblWednesday = new javax.swing.JTable();
        jpnlThursday = new javax.swing.JPanel();
        jspMonday3 = new javax.swing.JScrollPane();
        jtblThursday = new javax.swing.JTable();
        jpnlFriday = new javax.swing.JPanel();
        jspMonday4 = new javax.swing.JScrollPane();
        jtblFriday = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jpnlSubmitSchedule = new javax.swing.JPanel();
        jbtnAddRow = new javax.swing.JButton();
        jbtnRemoveEntry = new javax.swing.JButton();
        jbtnClearSchedule = new javax.swing.JButton();
        jbtnCreate = new javax.swing.JButton();
        jbtnLoadToSummary = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jpnlCreateSchedule.setLayout(new java.awt.GridBagLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Control"));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jlblGradeLevel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblGradeLevel.setText("Grade Level");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jlblGradeLevel, gridBagConstraints);

        jcmbGradeLevel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcmbGradeLevel.setPreferredSize(new java.awt.Dimension(150, 25));
        jcmbGradeLevel.setRenderer(new component_renderers.Renderer_GradeLevel_JComboBox());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbGradeLevel, gridBagConstraints);

        jlblSection.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblSection.setText("Section");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jlblSection, gridBagConstraints);

        jcmbSection.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcmbSection.setMinimumSize(new java.awt.Dimension(80, 26));
        jcmbSection.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbSection, gridBagConstraints);

        jcmbSchoolYearFrom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcmbSchoolYearFrom.setEnabled(false);
        jcmbSchoolYearFrom.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbSchoolYearFrom, gridBagConstraints);

        jlblSchoolYear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblSchoolYear.setText("School Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jlblSchoolYear, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Room ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jLabel1, gridBagConstraints);

        jcmbRoom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcmbRoom.setPreferredSize(new java.awt.Dimension(60, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbRoom, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateSchedule.add(jPanel5, gridBagConstraints);

        jpnlDaysControl.setLayout(new java.awt.GridBagLayout());

        jlblConflictInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblConflictInfo.setText("Conflict Details");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlDaysControl.add(jlblConflictInfo, gridBagConstraints);

        jbtnGrpDays.add(jcbMonday);
        jcbMonday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbMonday.setText("Mon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlDaysControl.add(jcbMonday, gridBagConstraints);

        jbtnGrpDays.add(jcbTuesday);
        jcbTuesday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbTuesday.setText("Tue");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlDaysControl.add(jcbTuesday, gridBagConstraints);

        jbtnGrpDays.add(jcbWednesday);
        jcbWednesday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbWednesday.setText("Wed");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlDaysControl.add(jcbWednesday, gridBagConstraints);

        jbtnGrpDays.add(jcbThursday);
        jcbThursday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbThursday.setText("Thu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlDaysControl.add(jcbThursday, gridBagConstraints);

        jbtnGrpDays.add(jcbFriday);
        jcbFriday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbFriday.setText("Fri");
        jcbFriday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFridayActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlDaysControl.add(jcbFriday, gridBagConstraints);

        jbtnEditDay.setText("Edit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlDaysControl.add(jbtnEditDay, gridBagConstraints);

        jbtnGrpDays.add(jcbDayMonWedFri);
        jcbDayMonWedFri.setText("M, W, F");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlDaysControl.add(jcbDayMonWedFri, gridBagConstraints);

        jbtnGrpDays.add(jcbDayTueThur);
        jcbDayTueThur.setText("T, TH");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlDaysControl.add(jcbDayTueThur, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateSchedule.add(jpnlDaysControl, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlCreateSchedule, gridBagConstraints);

        jpnlScheduleTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpnlScheduleTable.setMinimumSize(new java.awt.Dimension(800, 410));
        jpnlScheduleTable.setPreferredSize(new java.awt.Dimension(800, 410));
        jpnlScheduleTable.setLayout(new java.awt.GridBagLayout());

        jpnlScheduleHeader.setBorder(javax.swing.BorderFactory.createTitledBorder("Schedule Header"));
        jpnlScheduleHeader.setLayout(new java.awt.GridBagLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jlblsubSection.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblsubSection.setForeground(new java.awt.Color(0, 0, 0));
        jlblsubSection.setText("Section :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jlblsubSection, gridBagConstraints);

        jlblsubAdviser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblsubAdviser.setForeground(new java.awt.Color(0, 0, 0));
        jlblsubAdviser.setText("Adviser :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jlblsubAdviser, gridBagConstraints);

        jlblsubSchoolYear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblsubSchoolYear.setForeground(new java.awt.Color(0, 0, 0));
        jlblsubSchoolYear.setText("School Year :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jlblsubSchoolYear, gridBagConstraints);

        jlblsubGradeLevel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblsubGradeLevel.setForeground(new java.awt.Color(0, 0, 0));
        jlblsubGradeLevel.setText("Grade Level :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jlblsubGradeLevel, gridBagConstraints);

        jtfSectionName.setBackground(new java.awt.Color(255, 255, 255));
        jtfSectionName.setColumns(12);
        jtfSectionName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfSectionName.setForeground(new java.awt.Color(0, 0, 0));
        jtfSectionName.setBorder(null);
        jtfSectionName.setEnabled(false);
        jtfSectionName.setMinimumSize(new java.awt.Dimension(110, 30));
        jtfSectionName.setPreferredSize(new java.awt.Dimension(110, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jtfSectionName, gridBagConstraints);

        jtfAdviserName.setBackground(new java.awt.Color(255, 255, 255));
        jtfAdviserName.setColumns(12);
        jtfAdviserName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfAdviserName.setForeground(new java.awt.Color(0, 0, 0));
        jtfAdviserName.setBorder(null);
        jtfAdviserName.setEnabled(false);
        jtfAdviserName.setMinimumSize(new java.awt.Dimension(150, 30));
        jtfAdviserName.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jtfAdviserName, gridBagConstraints);

        jtfSchoolYear.setBackground(new java.awt.Color(255, 255, 255));
        jtfSchoolYear.setColumns(12);
        jtfSchoolYear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfSchoolYear.setForeground(new java.awt.Color(0, 0, 0));
        jtfSchoolYear.setBorder(null);
        jtfSchoolYear.setEnabled(false);
        jtfSchoolYear.setMinimumSize(new java.awt.Dimension(150, 30));
        jtfSchoolYear.setPreferredSize(new java.awt.Dimension(150, 30));
        jtfSchoolYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSchoolYearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jtfSchoolYear, gridBagConstraints);

        jtfGradeLevel.setBackground(new java.awt.Color(255, 255, 255));
        jtfGradeLevel.setColumns(12);
        jtfGradeLevel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfGradeLevel.setForeground(new java.awt.Color(0, 0, 0));
        jtfGradeLevel.setBorder(null);
        jtfGradeLevel.setEnabled(false);
        jtfGradeLevel.setMinimumSize(new java.awt.Dimension(150, 30));
        jtfGradeLevel.setPreferredSize(new java.awt.Dimension(150, 30));
        jtfGradeLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfGradeLevelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jtfGradeLevel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlScheduleHeader.add(jPanel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlScheduleTable.add(jpnlScheduleHeader, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jspSchedule.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Schedule", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jspSchedule.setMinimumSize(new java.awt.Dimension(650, 650));
        jspSchedule.setPreferredSize(new java.awt.Dimension(650, 402));

        jtblSchedule.setAutoCreateRowSorter(true);
        jtblSchedule.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtblSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Day", "Start Time", "End Time", "Subject", "Faculty", "Room", "Session"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblSchedule.setRowHeight(30);
        jtblSchedule.getTableHeader().setReorderingAllowed(false);
        jtblSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblScheduleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtblScheduleMousePressed(evt);
            }
        });
        jtblSchedule.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblScheduleKeyPressed(evt);
            }
        });
        jspSchedule.setViewportView(jtblSchedule);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jspSchedule, gridBagConstraints);

        jpnlScheduleSummary.setBorder(javax.swing.BorderFactory.createTitledBorder("Schedule Summary"));
        jpnlScheduleSummary.setLayout(new java.awt.GridBagLayout());

        jspScheduleSummary.setMinimumSize(new java.awt.Dimension(500, 600));
        jspScheduleSummary.setPreferredSize(new java.awt.Dimension(500, 600));

        jPanel2.setMinimumSize(new java.awt.Dimension(306, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(306, 600));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jpnlMonday.setMinimumSize(new java.awt.Dimension(300, 250));
        jpnlMonday.setPreferredSize(new java.awt.Dimension(300, 200));
        jpnlMonday.setLayout(new java.awt.GridBagLayout());

        jspMonday.setBorder(javax.swing.BorderFactory.createTitledBorder("Monday Schedule"));
        jspMonday.setPreferredSize(new java.awt.Dimension(400, 250));

        jtblMonday.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject", "Start Time", "End Time", "Subject", "Faculty ", "Room"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspMonday.setViewportView(jtblMonday);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlMonday.add(jspMonday, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel2.add(jpnlMonday, gridBagConstraints);

        jpnlTuesday.setMinimumSize(new java.awt.Dimension(300, 250));
        jpnlTuesday.setPreferredSize(new java.awt.Dimension(300, 200));
        jpnlTuesday.setLayout(new java.awt.GridBagLayout());

        jspMonday1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tuesday Schedule"));
        jspMonday1.setPreferredSize(new java.awt.Dimension(600, 423));

        jtblTuesday.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject", "Start Time", "End Time", "Subject", "Faculty ", "Room"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblTuesday.getTableHeader().setReorderingAllowed(false);
        jspMonday1.setViewportView(jtblTuesday);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlTuesday.add(jspMonday1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jpnlTuesday, gridBagConstraints);

        jpnlWednesday.setMinimumSize(new java.awt.Dimension(300, 250));
        jpnlWednesday.setPreferredSize(new java.awt.Dimension(300, 200));
        jpnlWednesday.setLayout(new java.awt.GridBagLayout());

        jspMonday2.setBorder(javax.swing.BorderFactory.createTitledBorder("Wednesday Schedule"));
        jspMonday2.setPreferredSize(new java.awt.Dimension(600, 423));

        jtblWednesday.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject", "Start Time", "End Time", "Subject", "Faculty ", "Room"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspMonday2.setViewportView(jtblWednesday);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlWednesday.add(jspMonday2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jpnlWednesday, gridBagConstraints);

        jpnlThursday.setMinimumSize(new java.awt.Dimension(300, 250));
        jpnlThursday.setPreferredSize(new java.awt.Dimension(300, 200));
        jpnlThursday.setLayout(new java.awt.GridBagLayout());

        jspMonday3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thursday Schedule"));
        jspMonday3.setPreferredSize(new java.awt.Dimension(600, 423));

        jtblThursday.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject", "Start Time", "End Time", "Subject", "Faculty ", "Room"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspMonday3.setViewportView(jtblThursday);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlThursday.add(jspMonday3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jpnlThursday, gridBagConstraints);

        jpnlFriday.setMinimumSize(new java.awt.Dimension(300, 250));
        jpnlFriday.setPreferredSize(new java.awt.Dimension(300, 200));
        jpnlFriday.setLayout(new java.awt.GridBagLayout());

        jspMonday4.setBorder(javax.swing.BorderFactory.createTitledBorder("Friday Schedule"));
        jspMonday4.setPreferredSize(new java.awt.Dimension(600, 423));

        jtblFriday.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject", "Start Time", "End Time", "Subject", "Faculty ", "Room"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspMonday4.setViewportView(jtblFriday);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFriday.add(jspMonday4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jpnlFriday, gridBagConstraints);

        jspScheduleSummary.setViewportView(jPanel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlScheduleSummary.add(jspScheduleSummary, gridBagConstraints);

        jLabel2.setText("Total Week Hours :");
        jPanel3.add(jLabel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlScheduleSummary.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jpnlScheduleSummary, gridBagConstraints);

        jScrollPane1.setViewportView(jPanel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlScheduleTable.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlScheduleTable, gridBagConstraints);

        jpnlSubmitSchedule.setLayout(new java.awt.GridBagLayout());

        jbtnAddRow.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnAddRow.setText("Add Row");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpnlSubmitSchedule.add(jbtnAddRow, gridBagConstraints);

        jbtnRemoveEntry.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnRemoveEntry.setText("Remove Row");
        jbtnRemoveEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRemoveEntryActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpnlSubmitSchedule.add(jbtnRemoveEntry, gridBagConstraints);

        jbtnClearSchedule.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnClearSchedule.setText("Clear Form");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpnlSubmitSchedule.add(jbtnClearSchedule, gridBagConstraints);

        jbtnCreate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnCreate.setText("Create Schedule");
        jbtnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCreateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpnlSubmitSchedule.add(jbtnCreate, gridBagConstraints);

        jbtnLoadToSummary.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnLoadToSummary.setText("Load To Summary");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jpnlSubmitSchedule.add(jbtnLoadToSummary, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlSubmitSchedule, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCreateActionPerformed
    }//GEN-LAST:event_jbtnCreateActionPerformed

    @Override
    public void initGridBagConstraints() {
    }

    @Override
    public void initJCompModelLoaders() {
        sectionJCompModelLoader = new SectionJCompModelLoader();
        schoolYearJCompModelLoader = new SchoolYearJCompModelLoader();
        gradeLevelJCompModelLoader = new GradeLevelJCompModelLoader();
        roomJCompModelLoader = new RoomJCompModelLoader();
    }

    @Override
    public void initRenderers() {
        jcmbSection.setRenderer(new Renderer_Section_JComboBox());
        jcmbGradeLevel.setRenderer(new Renderer_Schedule_GradeLevel_JComboBox());
        jcmbSchoolYearFrom.setRenderer(new Renderer_SchoolYear_JComboBox());
        jcmbRoom.setRenderer(new Renderer_Room_JComboBox());
        jtblSchedule.setDefaultRenderer(Object.class, new Renderer_Schedule_Conflict_JTableCell());
    }

    @Override
    public void initModels() {
    }

    @Override
    public void initViewComponents() {
        clearScheduleHeader();
        StringBuilder currentSy = new StringBuilder();
        currentSy.append(schoolYearDaoImpl.getCurrentSchoolYear().getYearFrom());
        currentSy.append(" - ");
        currentSy.append(schoolYearDaoImpl.getCurrentSchoolYear().getYearTo());
        jtfSchoolYear.setText(currentSy.toString());
        jcmbSchoolYearFrom.setModel(schoolYearJCompModelLoader.getCurrentSchoolYearId());
        jcmbGradeLevel.setModel(gradeLevelJCompModelLoader.getAllActiveGradeLevelId());
        jcmbRoom.setModel(roomJCompModelLoader.getAllActiveRoomId());
        jspScheduleSummary.getVerticalScrollBar().setUnitIncrement(40);
        jlblConflictInfo.setText("");
    }

    @Override
    public void initControllers() {
        jtblSchedule.getModel().addTableModelListener(new TableModel_Listener_ScheduleSheet_JTable(3));
        jcmbGradeLevel.addItemListener(new GradeLevelStateChangeController(this));
        jcmbSection.addItemListener(new SectionStateChange(this));
        jcbMonday.addActionListener(new DayCheckBoxStateChange(this));
        jcbTuesday.addActionListener(new DayCheckBoxStateChange(this));
        jcbWednesday.addActionListener(new DayCheckBoxStateChange(this));
        jcbThursday.addActionListener(new DayCheckBoxStateChange(this));
        jcbFriday.addActionListener(new DayCheckBoxStateChange(this));
    }

    @Override
    public void initDaoImpl() {
        schoolYearDaoImpl = new SchoolYearDaoImpl();
    }
    
    
    private void clearScheduleHeader(){
        jtfAdviserName.setText("");
        jtfGradeLevel.setText("");
        jtfSchoolYear.setText("");
        jtfSectionName.setText("");
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JPanel getjPanel1() {
        return jpnlScheduleSummary;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public JPanel getjPanel5() {
        return jPanel5;
    }

    public JPanel getjPanel6() {
        return jPanel6;
    }

    public JScrollPane getjScrollPane1() {
        return jspSchedule;
    }

    public JButton getJbtnAddRow() {
        return jbtnAddRow;
    }

    public JButton getJbtnClearSchedule() {
        return jbtnClearSchedule;
    }

    public JButton getJbtnCreate() {
        return jbtnCreate;
    }

    public JButton getJbtnLoadToSummary() {
        return jbtnLoadToSummary;
    }

    public JButton getJbtnRemoveEntry() {
        return jbtnRemoveEntry;
    }

    public JCheckBox getJcbFriday() {
        return jcbFriday;
    }

    public JCheckBox getJcbMonday() {
        return jcbMonday;
    }

    public JCheckBox getJcbThursday() {
        return jcbThursday;
    }

    public JCheckBox getJcbTuesday() {
        return jcbTuesday;
    }

    public JCheckBox getJcbWednesday() {
        return jcbWednesday;
    }

    public JComboBox<String> getJcmbGradeLevel() {
        return jcmbGradeLevel;
    }

    public JComboBox<String> getJcmbRoom() {
        return jcmbRoom;
    }

    public JComboBox<String> getJcmbSchoolYear() {
        return jcmbSchoolYearFrom;
    }

    public JComboBox<String> getJcmbSection() {
        return jcmbSection;
    }

    public JLabel getJlblConflictInfo() {
        return jlblConflictInfo;
    }

    public JLabel getJlblGradeLevel() {
        return jlblGradeLevel;
    }

    public JLabel getJlblSchoolYear() {
        return jlblSchoolYear;
    }

    public JLabel getJlblSection() {
        return jlblSection;
    }

    public JLabel getJlblsubAdviser() {
        return jlblsubAdviser;
    }

    public JTextField getJlblsubAdviserNameText() {
        return jtfAdviserName;
    }

    public JLabel getJlblsubGradeLevel() {
        return jlblsubGradeLevel;
    }

    public JTextField getJlblsubGradeLevelText() {
        return jtfGradeLevel;
    }

    public JLabel getJlblsubSchoolYear() {
        return jlblsubSchoolYear;
    }

    public JTextField getJlblsubSchoolYearText() {
        return jtfSchoolYear;
    }

    public JLabel getJlblsubSection() {
        return jlblsubSection;
    }

    public JTextField getJlblsubSectionNameText() {
        return jtfSectionName;
    }

    public JPanel getJpnlCreateSchedule() {
        return jpnlCreateSchedule;
    }

    public JPanel getJpnlFriday() {
        return jpnlFriday;
    }

    public JPanel getJpnlMonday() {
        return jpnlMonday;
    }

    public JPanel getJpnlScheduleHeader() {
        return jpnlScheduleHeader;
    }

    public JPanel getJpnlScheduleTable() {
        return jpnlScheduleTable;
    }

    public JPanel getJpnlSubmitSchedule() {
        return jpnlSubmitSchedule;
    }

    public JPanel getJpnlThursday() {
        return jpnlThursday;
    }

    public JPanel getJpnlTuesday() {
        return jpnlTuesday;
    }

    public JPanel getJpnlWednesday() {
        return jpnlWednesday;
    }

    public JScrollPane getJspMonday() {
        return jspMonday;
    }

    public JScrollPane getJspMonday1() {
        return jspMonday1;
    }

    public JScrollPane getJspMonday2() {
        return jspMonday2;
    }

    public JScrollPane getJspMonday3() {
        return jspMonday3;
    }

    public JScrollPane getJspMonday4() {
        return jspMonday4;
    }

    public JScrollPane getJspScheduleSummary() {
        return jspScheduleSummary;
    }

    public JTable getJtblFriday() {
        return jtblFriday;
    }

    public JTable getJtblMonday() {
        return jtblMonday;
    }

    public JTable getJtblSchedule() {
        return jtblSchedule;
    }

    public JTable getJtblThursday() {
        return jtblThursday;
    }

    public JTable getJtblTuesday() {
        return jtblTuesday;
    }

    public JTable getJtblWednesday() {
        return jtblWednesday;
    }

    public JTextField getJtfAdviserName() {
        return jtfAdviserName;
    }

    public JTextField getJtfGradeLevel() {
        return jtfGradeLevel;
    }

    public JTextField getJtfSchoolYear() {
        return jtfSchoolYear;
    }

    public JTextField getJtfSectionName() {
        return jtfSectionName;
    }
    
    

    private void jbtnRemoveEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRemoveEntryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnRemoveEntryActionPerformed

    private void jtblScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblScheduleMouseClicked
        
    }//GEN-LAST:event_jtblScheduleMouseClicked

    private void jtblScheduleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblScheduleMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtblScheduleMousePressed

    private void jtblScheduleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblScheduleKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            jpnlScheduleTable.repaint();
        }
    }//GEN-LAST:event_jtblScheduleKeyPressed

    private void jtfSchoolYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSchoolYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSchoolYearActionPerformed

    private void jtfGradeLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfGradeLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfGradeLevelActionPerformed

    private void jcbFridayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFridayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbFridayActionPerformed

    public JButton getJbtnEditDay() {
        return jbtnEditDay;
    }

    public void setJbtnEditDay(JButton jbtnEditDay) {
        this.jbtnEditDay = jbtnEditDay;
    }

    public ButtonGroup getJbtnGrpDays() {
        return jbtnGrpDays;
    }

    public void setJbtnGrpDays(ButtonGroup jbtnGrpDays) {
        this.jbtnGrpDays = jbtnGrpDays;
    }

    public JCheckBox getJcbDayMonWedFri() {
        return jcbDayMonWedFri;
    }

    public void setJcbDayMonWedFri(JCheckBox jcbDayMonWedFri) {
        this.jcbDayMonWedFri = jcbDayMonWedFri;
    }

    public JCheckBox getJcbDayTueThur() {
        return jcbDayTueThur;
    }

    public void setJcbDayTueThur(JCheckBox jcbDayTueThur) {
        this.jcbDayTueThur = jcbDayTueThur;
    }

    public JPanel getJpnlDaysControl() {
        return jpnlDaysControl;
    }

    public void setJpnlDaysControl(JPanel jpnlDaysControl) {
        this.jpnlDaysControl = jpnlDaysControl;
    }

    public JPanel getJpnlScheduleSummary() {
        return jpnlScheduleSummary;
    }

    public void setJpnlScheduleSummary(JPanel jpnlScheduleSummary) {
        this.jpnlScheduleSummary = jpnlScheduleSummary;
    }

    public JScrollPane getJspSchedule() {
        return jspSchedule;
    }

    public void setJspSchedule(JScrollPane jspSchedule) {
        this.jspSchedule = jspSchedule;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAddRow;
    private javax.swing.JButton jbtnClearSchedule;
    private javax.swing.JButton jbtnCreate;
    private javax.swing.JButton jbtnEditDay;
    private javax.swing.ButtonGroup jbtnGrpDays;
    private javax.swing.JButton jbtnLoadToSummary;
    private javax.swing.JButton jbtnRemoveEntry;
    private javax.swing.JCheckBox jcbDayMonWedFri;
    private javax.swing.JCheckBox jcbDayTueThur;
    private javax.swing.JCheckBox jcbFriday;
    private javax.swing.JCheckBox jcbMonday;
    private javax.swing.JCheckBox jcbThursday;
    private javax.swing.JCheckBox jcbTuesday;
    private javax.swing.JCheckBox jcbWednesday;
    private javax.swing.JComboBox<String> jcmbGradeLevel;
    private javax.swing.JComboBox<String> jcmbRoom;
    private javax.swing.JComboBox<String> jcmbSchoolYearFrom;
    public static javax.swing.JComboBox<String> jcmbSection;
    private javax.swing.JLabel jlblConflictInfo;
    private javax.swing.JLabel jlblGradeLevel;
    private javax.swing.JLabel jlblSchoolYear;
    private javax.swing.JLabel jlblSection;
    private javax.swing.JLabel jlblsubAdviser;
    private javax.swing.JLabel jlblsubGradeLevel;
    private javax.swing.JLabel jlblsubSchoolYear;
    private javax.swing.JLabel jlblsubSection;
    private javax.swing.JPanel jpnlCreateSchedule;
    private javax.swing.JPanel jpnlDaysControl;
    private javax.swing.JPanel jpnlFriday;
    private javax.swing.JPanel jpnlMonday;
    private javax.swing.JPanel jpnlScheduleHeader;
    private javax.swing.JPanel jpnlScheduleSummary;
    private javax.swing.JPanel jpnlScheduleTable;
    private javax.swing.JPanel jpnlSubmitSchedule;
    private javax.swing.JPanel jpnlThursday;
    private javax.swing.JPanel jpnlTuesday;
    private javax.swing.JPanel jpnlWednesday;
    private javax.swing.JScrollPane jspMonday;
    private javax.swing.JScrollPane jspMonday1;
    private javax.swing.JScrollPane jspMonday2;
    private javax.swing.JScrollPane jspMonday3;
    private javax.swing.JScrollPane jspMonday4;
    private javax.swing.JScrollPane jspSchedule;
    private javax.swing.JScrollPane jspScheduleSummary;
    private javax.swing.JTable jtblFriday;
    private javax.swing.JTable jtblMonday;
    public static javax.swing.JTable jtblSchedule;
    private javax.swing.JTable jtblThursday;
    private javax.swing.JTable jtblTuesday;
    private javax.swing.JTable jtblWednesday;
    private javax.swing.JTextField jtfAdviserName;
    private javax.swing.JTextField jtfGradeLevel;
    private javax.swing.JTextField jtfSchoolYear;
    private javax.swing.JTextField jtfSectionName;
    // End of variables declaration//GEN-END:variables
}
