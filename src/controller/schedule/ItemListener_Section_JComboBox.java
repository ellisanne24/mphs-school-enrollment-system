package controller.schedule;

import component_editor.ScheduleTimeCellEditor;
import daoimpl.SectionDaoImpl;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import model.section.Section;
import view.schedule.Dialog_CreateSchedule;

/**
 *
 * @author John Ferdinand Antonio
 */
public class ItemListener_Section_JComboBox implements ItemListener {

    private SectionDaoImpl sectionDaoImpl;
    private Section section;
    private final Dialog_CreateSchedule view;
    private final JComboBox jcmbRoom;
    private final JComboBox jcmbSections;
    private final JTable jtblSchedule;

    public ItemListener_Section_JComboBox(Dialog_CreateSchedule view) {
        sectionDaoImpl = new SectionDaoImpl();
        this.view = view;
        this.jtblSchedule = view.getJtblSchedule();
        this.jcmbSections = view.getJcmbSection();
        this.jcmbRoom = view.getJcmbRoom();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (jcmbSections.getSelectedIndex() > -1) {
            view.getJpnlScheduleTable().repaint();
            initializeSection();//must be the first method call here
            
            loadInitialTimeValues();
            applyStartandEndTimeCellEditors(section);
            loadSectionInformationToScheduleHeader();
            loadSessionToTable();
        }
    }

    private void initializeSection() {
        Section s = (Section) jcmbSections.getSelectedItem();
        section = sectionDaoImpl.getSectionById(s.getSectionId());
    }

    private void loadSectionInformationToScheduleHeader() {
        view.getJtfSectionName().setText(section.getSectionName());
        view.getJtfAdviserName().
                setText(section.getAdviser().getLastName() + ", "
                        + section.getAdviser().getFirstName() + " "
                        + section.getAdviser().getMiddleName());
    }

    private void applyStartandEndTimeCellEditors(Section section) {
        TableColumnModel columnModel = jtblSchedule.getColumnModel();
        TableColumn startTimeCol = columnModel.getColumn(1);
        TableColumn endTimeCol = columnModel.getColumn(2);
        startTimeCol.setCellEditor(new ScheduleTimeCellEditor(jtblSchedule, section));
        endTimeCol.setCellEditor(new ScheduleTimeCellEditor(jtblSchedule, section));
    }
    
    private void loadInitialTimeValues() {
        int startTimeCol = 1;
        int endTimeCol = 2;
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm");

        int startHour = section.getSectionSession().equalsIgnoreCase("AM") ? 7
                : section.getSectionSession().equalsIgnoreCase("PM") ? 12
                : section.getSectionSession().equalsIgnoreCase("WD") ? 7 : 7;
        for (int row = 0; row < jtblSchedule.getRowCount(); row++,startHour++) {
            start.set(Calendar.HOUR_OF_DAY, startHour);
            start.set(Calendar.MINUTE, 0);
            jtblSchedule.setValueAt(dateFormatter.format(start.getTime()), row, startTimeCol);
            end.set(Calendar.HOUR_OF_DAY, startHour+1);
            end.set(Calendar.MINUTE, 0);
            jtblSchedule.setValueAt(dateFormatter.format(end.getTime()), row, endTimeCol);
        }
    }

    private void loadSessionToTable() {
        int sessionCol = 6;
        String sectionSession = section.getSectionSession();
        for (int row = 0; row < jtblSchedule.getRowCount(); row++) {
            jtblSchedule.setValueAt(sectionSession, row, sessionCol);
        }
    }
}
