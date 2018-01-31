package controller.schedule;

import daoimpl.GradeLevelDaoImpl;
import daoimpl.SubjectDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.gradelevel.GradeLevel;
import model.subject.Subject;

/**
 *
 * @author John Ferdinand Antonio
 */
public class DayCheckBoxStateChange implements ActionListener{

    SubjectDaoImpl sdi = new SubjectDaoImpl();
    
    private final JCheckBox jcbMonday;
    private final JCheckBox jcbTuesday;
    private final JCheckBox jcbWednesday;
    private final JCheckBox jcbThursday;
    private final JCheckBox jcbFriday;
    private final JTable jtblSchedule;
    private final JComboBox jcmbGradeLevel;
    private final JComboBox jcmbRoom; 
    
    public DayCheckBoxStateChange(JComboBox jcmbGradeLevel, JComboBox jcmbRoom,JTable jtblSchedule,
            JCheckBox jcbMonday, JCheckBox jcbTuesday, JCheckBox jcbWednesday,JCheckBox jcbThursday,JCheckBox jcbFriday){
        this.jtblSchedule = jtblSchedule;
        this.jcbMonday = jcbMonday;
        this.jcbTuesday = jcbTuesday;
        this.jcbWednesday = jcbWednesday;
        this.jcbThursday = jcbThursday;
        this.jcbFriday = jcbFriday;
        this.jcmbGradeLevel = jcmbGradeLevel;
        this.jcmbRoom = jcmbRoom;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jcbMonday && jcbMonday.isSelected()){
            loadDaysToTable(jcbMonday);
        }else if(e.getSource() == jcbTuesday && jcbTuesday.isSelected()){
             loadDaysToTable(jcbTuesday);
        }else if(e.getSource() == jcbWednesday && jcbWednesday.isSelected()){
            loadDaysToTable(jcbWednesday);
        }else if(e.getSource() == jcbThursday && jcbThursday.isSelected()){
            loadDaysToTable(jcbThursday);
        }else if(e.getSource() == jcbFriday && jcbFriday.isSelected()){
            loadDaysToTable(jcbFriday);
        }
    }
    
    
    
    
    private int getGradeLevelId(){
        Integer gradeLevelId;
        int level = Integer.parseInt(jcmbGradeLevel.getSelectedItem().toString());
        GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
        gradeLevelId = gldi.getId(level);
        return gradeLevelId;
    }
    
    private GradeLevel getGradeLevel() {
        int level = Integer.parseInt(jcmbGradeLevel.getSelectedItem().toString());
        GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
        int gradeLevelId = gldi.getId(level);
        GradeLevel gradeLevel = new GradeLevel();
        gradeLevel.setId(gradeLevelId);
        return gradeLevel;
    }
    
    private void loadDaysToTable(JCheckBox jcbDay){
//        String day = jcbDay.getText().trim();
//        DefaultTableModel tableModel = (DefaultTableModel) jtblSchedule.getModel();
//        
//        int subjectCount = sdi.getAllSubjectsByGradeLevelId(getGradeLevel()).size();
//        List<Subject> subjectList = sdi.getAllSubjectsByGradeLevelId(getGradeLevel());
//        
//        String roomName = jcmbRoom.getSelectedItem().toString().trim();
//        
//        if (!hasDayRecord()) {
//            System.out.println("Has No Days Record");
//            tableModel.setRowCount(0);
//            for (Subject s : subjectList) {
//                tableModel.addRow(new Object[]{day, null, null, s.getSubjectCode(), null, roomName});
//            }
//        }else if(hasDayRecord() && !exists(jcbDay)){
//            System.out.println("Has Days Record.");
//            System.out.println("jcbDay is "+jcbDay.getText());
//            int lastRowIndex = tableModel.getRowCount() - 1;
//            System.out.println("Last Row Index :"+lastRowIndex);
//            for(int i = 0; i < subjectCount; i++){
//                 tableModel.addRow(new Object[]{day, null, null, subjectList.get(i).getSubjectCode(), null, roomName});
//            }
//        }
    }
    
    private boolean exists(JCheckBox jcbDay){
        boolean exists ;
        int recordCount = 0;
        for(int i = 0; i <jtblSchedule.getRowCount(); i++){
            if(jtblSchedule.getValueAt(i, 0) != null){
                String dayOnTable = jtblSchedule.getValueAt(i, 0).toString().trim();
                if(jcbDay.getText().toLowerCase().trim().equals(dayOnTable.toLowerCase().trim())){
                    recordCount++;
                }
            }
        }
        exists  = recordCount > 0;
        return exists;
    }
    
    private boolean hasDayRecord() {
//        int countOfNull = 0;
//        int level = Integer.parseInt(jcmbGradeLevel.getSelectedItem().toString());
//        GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
//        int gradeLevelId = gldi.getId(level);
//        GradeLevel gradeLevel = new GradeLevel();
//        gradeLevel.setId(gradeLevelId);
//        
//        int subjectCount = sdi.getAllSubjectsByGradeLevelId(gradeLevel).size();
//        
//        for (int i = 0; i < jtblSchedule.getRowCount(); i++) {
//            Object day = jtblSchedule.getValueAt(i, 0);
//            if (day == null) {
//                countOfNull++;
//            }else{
//                
//            }
//        }
//
        boolean hasDaySet = true;
//        System.out.println("Subject Count :"+subjectCount);
//        System.out.println("Count of Null :" + countOfNull);
//        if (countOfNull == subjectCount) {
//            System.out.println("Count of Null == SubjectCount");
//            hasDaySet = false;
//        } 
        return hasDaySet;
    }
}
