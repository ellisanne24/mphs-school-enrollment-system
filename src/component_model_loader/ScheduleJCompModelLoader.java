
package component_model_loader;

import daoimpl.ScheduleDaoImpl;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.schedule.Schedule;
import utility.component.TableUtility;

/**
 *
 * @author John Ferdinand Antonio
 */
public class ScheduleJCompModelLoader {
    ScheduleDaoImpl scheduleDaoImpl = new ScheduleDaoImpl();
    public DefaultTableModel getAllBySchoolYearId(int aSchoolYearId, JTable jtable){
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        model.setRowCount(0);
        Object[] scheduleList = scheduleDaoImpl.getAll(aSchoolYearId).toArray();
        for (Object o : scheduleList) {
            Schedule s = (Schedule) o;
            model.addRow(new Object[]{
//                s.getScheduleId(), s.getDay(), s.getStartTime(), s.getEndTime(), s.getSectionName(),
//                s.getSubjectCode(), s.getRoomName(),
//                s.getFaculty().getLastName() == null ? "None assigned" : s.getFaculty().getLastName()
//                + ", "
//                + s.getFaculty().getFirstName() == null ? "" :  s.getFaculty().getFirstName()
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
//                s.getScheduleId(),s.getDay(),s.getStartTime(),s.getEndTime(),s.getSectionName(),
//                s.getSubjectCode(), s.getRoomName(),s.getFaculty().getLastName()+", "+s.getFaculty().getFirstName()
            });
        }
        return model;
    }
    
    public DefaultTableModel getByFacultyId(int aFacultyId, int aSchoolYearId, JTable jtable){
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        model.setRowCount(0);
        Object[] scheduleList = scheduleDaoImpl.getByFacultyId(aFacultyId, aSchoolYearId).toArray();
        for(Object o : scheduleList){
            Schedule s = (Schedule)o;
            model.addRow(new Object[]{
//                s.getScheduleId(),
//                s.getDay(),
//                intToTimeFormat(s.getStartTime()),
//                intToTimeFormat(s.getEndTime()),
//                s.getSectionName(),
//                s.getSubjectCode(), 
//                s.getRoomName(),
//                s.getFaculty().getLastName()+", "+s.getFaculty().getFirstName()
            });
        }
        return model;
    }
    
    private String intToTimeFormat(int time) {
        int hours = time/100;
        int minutes = time%100 * 100;
        String str = String.format("%02d%s%02d", hours,":",minutes);
        return str;
    }
    
    
}
