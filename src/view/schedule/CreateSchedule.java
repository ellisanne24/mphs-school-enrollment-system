
package view.schedule;

import component_editor.ScheduleDayCellEditor;
import component_editor.ScheduleRoomCellEditor;
import component_editor.ScheduleTimeCellEditor;
import component_model_loader.RoomML;
import controller.schedule.CreateScheduleController;
import component_model_loader.SchoolYearML;
import component_renderers.ScheduleTableCellRenderer;
import controller.global.SchoolYearController;
import controller.schedule.AddRowToSchedule;
import controller.schedule.ClearScheduleFormController;
import controller.schedule.CreateScheduleController2;
import controller.schedule.DayCheckBoxStateChange;
import controller.schedule.GradeLevelStateChangeController;
import controller.schedule.LoadToSummary;
import controller.schedule.RoomStateChange;
import controller.schedule.SectionStateChange;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author John Ferdinand Antonio
 */
public class CreateSchedule extends javax.swing.JDialog {

    SchoolYearML schoolYearModelLoader = new SchoolYearML();

    public CreateSchedule(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jlblConflictInfo.setText("");
        jtblSchedule.setAutoCreateRowSorter(true);
        initializeModels();
        initializeControllers();
        initializeTableCellEditors();
        initializeRenderers();
        applyKeyBindings();
        applyCellEditorListener();
        test();
        jspScheduleSummary.getVerticalScrollBar().setUnitIncrement(40);
    }

    private void initializeControllers() {
        CreateScheduleController2 createController
                = new CreateScheduleController2(
                        jtblSchedule, jtblMonday, jtblTuesday, jtblWednesday, jtblThursday,
                        jtblFriday, jcmbSection, jcmbGradeLevel, this
                );
        jbtnCreate.addActionListener(createController);
        SchoolYearController schoolYearController = new SchoolYearController(jcmbSchoolYearFrom, jcmbSchoolYearTo);
        jcmbSchoolYearFrom.addItemListener(schoolYearController);

        jcmbGradeLevel.addItemListener(
                new GradeLevelStateChangeController(jtblSchedule, jcmbGradeLevel, jcmbSection,jbtnRemoveEntry,jcmbRoom)
        );
        jbtnAddRow.addActionListener(new AddRowToSchedule(jtblSchedule,jcmbRoom));
        
        jcmbRoom.addItemListener(new RoomStateChange(jcmbRoom, jtblSchedule));
        jbtnClearSchedule.addActionListener(new ClearScheduleFormController(jtblSchedule));
        jcmbSection.addItemListener(new SectionStateChange(jcmbSection, jtblSchedule, jcmbGradeLevel,jcmbRoom));
       
        jcbMonday.addActionListener(new DayCheckBoxStateChange(jcmbGradeLevel, jcmbRoom, jtblSchedule, jcbMonday, jcbTuesday, jcbWednesday, jcbThursday, jcbFriday));
        jcbTuesday.addActionListener(new DayCheckBoxStateChange(jcmbGradeLevel, jcmbRoom, jtblSchedule, jcbMonday, jcbTuesday, jcbWednesday, jcbThursday, jcbFriday));
        jcbWednesday.addActionListener(new DayCheckBoxStateChange(jcmbGradeLevel, jcmbRoom, jtblSchedule, jcbMonday, jcbTuesday, jcbWednesday, jcbThursday, jcbFriday));
        jcbThursday.addActionListener(new DayCheckBoxStateChange(jcmbGradeLevel, jcmbRoom, jtblSchedule, jcbMonday, jcbTuesday, jcbWednesday, jcbThursday, jcbFriday));
        jcbFriday.addActionListener(new DayCheckBoxStateChange(jcmbGradeLevel, jcmbRoom, jtblSchedule, jcbMonday, jcbTuesday, jcbWednesday,jcbThursday, jcbFriday));
        
        jbtnLoadToSummary.addActionListener(
               new LoadToSummary(jtblSchedule, jtblMonday, jtblTuesday, jtblWednesday, jtblThursday, jtblFriday)
        );
    }

    private void initializeModels() {
        jcmbSchoolYearFrom.setModel(schoolYearModelLoader.getCurrentSchoolYearFrom());
        jcmbSchoolYearTo.setModel(schoolYearModelLoader.getCurrentSchoolYearTo());
        jcmbGradeLevel.setModel(new component_model_loader.GradeLevelML().getAllGradeLevels());
        jcmbRoom.setModel(new RoomML().getRoomNames());
    }
    
    public static void initializeTableCellEditors() {
        TableColumnModel columnModel = jtblSchedule.getColumnModel();
        TableColumn daysCol = columnModel.getColumn(0);
        TableColumn startTimeCol = columnModel.getColumn(1);
        TableColumn endTimeCol = columnModel.getColumn(2);
        TableColumn roomsCol = columnModel.getColumn(5);
        
        startTimeCol.setCellEditor(new ScheduleTimeCellEditor(jtblSchedule));
        endTimeCol.setCellEditor(new ScheduleTimeCellEditor(jtblSchedule));
        daysCol.setCellEditor(new ScheduleDayCellEditor());
        roomsCol.setCellEditor(new ScheduleRoomCellEditor());
    }
    
    private void initializeRenderers(){
        jtblSchedule.setDefaultRenderer(Object.class, new ScheduleTableCellRenderer(jlblConflictInfo));
        
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
    
    private void test(){
        jtblSchedule.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                jtblSchedule.repaint();
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

        jpnlCreateSchedule = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jlblGradeLevel = new javax.swing.JLabel();
        jcmbGradeLevel = new javax.swing.JComboBox<>();
        jlblSection = new javax.swing.JLabel();
        jcmbSection = new javax.swing.JComboBox<>();
        jcmbSchoolYearFrom = new javax.swing.JComboBox<>();
        jlblSchoolYear = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jcmbSchoolYearTo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jcmbRoom = new javax.swing.JComboBox<>();
        jlblConflictInfo = new javax.swing.JLabel();
        jcbMonday = new javax.swing.JCheckBox();
        jcbTuesday = new javax.swing.JCheckBox();
        jcbWednesday = new javax.swing.JCheckBox();
        jcbThursday = new javax.swing.JCheckBox();
        jcbFriday = new javax.swing.JCheckBox();
        jpnlScheduleTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblSchedule = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
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

        jlblGradeLevel.setText("Grade Level");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jlblGradeLevel, gridBagConstraints);

        jcmbGradeLevel.setRenderer(new component_renderers.GradeLevelJComboBoxRenderer());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbGradeLevel, gridBagConstraints);

        jlblSection.setText("Section");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jlblSection, gridBagConstraints);

        jcmbSection.setEnabled(false);
        jcmbSection.setMinimumSize(new java.awt.Dimension(80, 26));
        jcmbSection.setPreferredSize(new java.awt.Dimension(80, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbSection, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbSchoolYearFrom, gridBagConstraints);

        jlblSchoolYear.setText("School Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jlblSchoolYear, gridBagConstraints);

        jLabel9.setText("to");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jLabel9, gridBagConstraints);

        jcmbSchoolYearTo.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jcmbSchoolYearTo, gridBagConstraints);

        jLabel1.setText("Room ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jLabel1, gridBagConstraints);

        jcmbRoom.setEnabled(false);
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

        jlblConflictInfo.setText("Conflict Details");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateSchedule.add(jlblConflictInfo, gridBagConstraints);

        jcbMonday.setText("Mon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        jpnlCreateSchedule.add(jcbMonday, gridBagConstraints);

        jcbTuesday.setText("Tue");
        jpnlCreateSchedule.add(jcbTuesday, new java.awt.GridBagConstraints());

        jcbWednesday.setText("Wed");
        jpnlCreateSchedule.add(jcbWednesday, new java.awt.GridBagConstraints());

        jcbThursday.setText("Thu");
        jpnlCreateSchedule.add(jcbThursday, new java.awt.GridBagConstraints());

        jcbFriday.setText("Fri");
        jpnlCreateSchedule.add(jcbFriday, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlCreateSchedule, gridBagConstraints);

        jpnlScheduleTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpnlScheduleTable.setMinimumSize(new java.awt.Dimension(800, 410));
        jpnlScheduleTable.setPreferredSize(new java.awt.Dimension(800, 410));
        jpnlScheduleTable.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setMinimumSize(new java.awt.Dimension(700, 402));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(700, 402));

        jtblSchedule.setAutoCreateRowSorter(true);
        jtblSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Day", "Start Time", "End Time", "Subject", "Faculty", "Room"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblSchedule.setEnabled(false);
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
        jScrollPane1.setViewportView(jtblSchedule);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlScheduleTable.add(jScrollPane1, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Schedule Summary"));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jspScheduleSummary.setPreferredSize(new java.awt.Dimension(1867, 4000));

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jpnlMonday.setLayout(new java.awt.GridBagLayout());

        jspMonday.setBorder(javax.swing.BorderFactory.createTitledBorder("Monday Schedule"));
        jspMonday.setPreferredSize(new java.awt.Dimension(600, 423));

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

        jpnlTuesday.setLayout(new java.awt.GridBagLayout());

        jspMonday1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tuesday Schedule"));
        jspMonday1.setPreferredSize(new java.awt.Dimension(600, 423));

        jtblTuesday.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Day", "Start Time", "End Time", "Subject", "Faculty ", "Room"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
        jPanel1.add(jspScheduleSummary, gridBagConstraints);

        jLabel2.setText("Total Week Hours :");
        jPanel3.add(jLabel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlScheduleTable.add(jPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlScheduleTable, gridBagConstraints);

        jpnlSubmitSchedule.setLayout(new java.awt.GridBagLayout());

        jbtnAddRow.setText("Add Row");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSubmitSchedule.add(jbtnAddRow, gridBagConstraints);

        jbtnRemoveEntry.setText("Remove Row");
        jbtnRemoveEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRemoveEntryActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSubmitSchedule.add(jbtnRemoveEntry, gridBagConstraints);

        jbtnClearSchedule.setText("Clear Form");
        jbtnClearSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClearScheduleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSubmitSchedule.add(jbtnClearSchedule, gridBagConstraints);

        jbtnCreate.setText("Create Schedule");
        jbtnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCreateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSubmitSchedule.add(jbtnCreate, gridBagConstraints);

        jbtnLoadToSummary.setText("Load To Summary");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
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
//        int choice = JOptionPane.showConfirmDialog(null, "Add Schedule","Add Schedule?",JOptionPane.YES_NO_OPTION);
//        if(choice == JOptionPane.YES_OPTION){
//            boolean isSuccessful = true;
//            for(int i=0; i < jtblSchedule.getRowCount(); i++){
//                for(int j = 0; j < jtblSchedule.getColumnCount(); j++){
//                    String startTime = (String) jtblSchedule.getValueAt(i,1);
//                    String[] startTimeParts = startTime.split(":") ;
//                    startTimeINT = Integer.parseInt(startTimeParts[0]+startTimeParts[1]);
//
//                    String endTime = (String) jtblSchedule.getValueAt(i,2);
//                    String[] endTimeParts = endTime.split(":") ;
//                    endTimeINT = Integer.parseInt(endTimeParts[0]+endTimeParts[1]);
//
//                    myGradeLevel = (String) jtblSchedule.getValueAt(i, 5);
//                    myRoom = (String) jtblSchedule.getValueAt(i, 3);
//                    mySectionName = (String) jtblSchedule.getValueAt(i, 6);
//                    mySubject = (String) jtblSchedule.getValueAt(i, 4);
//                    myDay = (String) jtblSchedule.getValueAt(i,0);
//                }
//            }
//        }
    }//GEN-LAST:event_jbtnCreateActionPerformed

    private void jbtnClearScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnClearScheduleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnClearScheduleActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAddRow;
    private javax.swing.JButton jbtnClearSchedule;
    private javax.swing.JButton jbtnCreate;
    private javax.swing.JButton jbtnLoadToSummary;
    private javax.swing.JButton jbtnRemoveEntry;
    private javax.swing.JCheckBox jcbFriday;
    private javax.swing.JCheckBox jcbMonday;
    private javax.swing.JCheckBox jcbThursday;
    private javax.swing.JCheckBox jcbTuesday;
    private javax.swing.JCheckBox jcbWednesday;
    private javax.swing.JComboBox<String> jcmbGradeLevel;
    private javax.swing.JComboBox<String> jcmbRoom;
    private javax.swing.JComboBox<String> jcmbSchoolYearFrom;
    private javax.swing.JComboBox<String> jcmbSchoolYearTo;
    public static javax.swing.JComboBox<String> jcmbSection;
    private javax.swing.JLabel jlblConflictInfo;
    private javax.swing.JLabel jlblGradeLevel;
    private javax.swing.JLabel jlblSchoolYear;
    private javax.swing.JLabel jlblSection;
    private javax.swing.JPanel jpnlCreateSchedule;
    private javax.swing.JPanel jpnlFriday;
    private javax.swing.JPanel jpnlMonday;
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
    private javax.swing.JScrollPane jspScheduleSummary;
    private javax.swing.JTable jtblFriday;
    private javax.swing.JTable jtblMonday;
    public static javax.swing.JTable jtblSchedule;
    private javax.swing.JTable jtblThursday;
    private javax.swing.JTable jtblTuesday;
    private javax.swing.JTable jtblWednesday;
    // End of variables declaration//GEN-END:variables
}
