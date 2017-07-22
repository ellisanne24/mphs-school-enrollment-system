/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_model_loader;

import daoimpl.ScheduleDaoImpl;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.schedule.Schedule;

/**
 *
 * @author John Ferdinand Antonio
 */
public class ScheduleML {
    ScheduleDaoImpl scheduleDaoImpl = new ScheduleDaoImpl();
    public DefaultTableModel getAllBySchoolYearId(int aSchoolYearId, JTable jtable){
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        model.setRowCount(0);
        Object[] scheduleList = scheduleDaoImpl.getAll(aSchoolYearId).toArray();
        for(Object o : scheduleList){
            Schedule s = (Schedule)o;
            model.addRow(new Object[]{
                s.getScheduleId(),s.getDay(),s.getStartTime(),s.getEndTime(),s.getSectionName(),
                s.getSubjectName(), s.getRoomName()
            });
        }
        return model;
    }
    
    public DefaultTableModel getAll(int aSubjectId, int aSchoolYearId, JTable jtable){
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        model.setRowCount(0);
        Object[] scheduleList = scheduleDaoImpl.getAll(aSubjectId, aSchoolYearId).toArray();
        for(Object o : scheduleList){
            Schedule s = (Schedule)o;
            model.addRow(new Object[]{
                s.getScheduleId(),s.getDay(),s.getStartTime(),s.getEndTime(),s.getSectionName(),
                s.getSubjectName(), s.getRoomName()
            });
        }
        return model;
    }
}
