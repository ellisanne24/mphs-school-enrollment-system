
package component_model_loader;

import daoimpl.SubjectDaoImpl;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.subject.Subject;

/**
 *
 * @author Jordan
 */
public class SubjectJCompModelLoader {

    private final SubjectDaoImpl subjectDaoImpl;
    
    public SubjectJCompModelLoader(){
        subjectDaoImpl = new SubjectDaoImpl();
    }
    
   public DefaultTableModel getAllSubjectsInfo(JTable jTable){
       DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
       tableModel.setRowCount(0);
       Object[] subjectList = subjectDaoImpl.getAllSubjectsInfo().toArray();
       for(Object o : subjectList){
           Subject s  = (Subject)o;
           Object[] rowData = {
               s.getSubjectId(), s.getSubjectTitle(), 
               s.getSubjectCode(), s.getSubjectDescription(),
               s.isIsActive()==true? "Yes":"No",s.getGradeLevel().getLevelNo()
           };
           tableModel.addRow(rowData);
       }
       return tableModel;
   }
   
   public DefaultTableModel getSubjectInfoByWildCard(JTable jTable, JTextField jtfSearchBox){
       DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
       tableModel.setRowCount(0);
       Object[] subjectList = subjectDaoImpl.getSubjectInfoByWildCard(jtfSearchBox.getText()).toArray();
       for(Object o : subjectList){
           Subject s  = (Subject)o;
           Object[] rowData = {
               s.getSubjectId(), s.getSubjectTitle(), 
               s.getSubjectCode(), s.getSubjectDescription(),
               s.isIsActive()==true? "Yes":"No",s.getGradeLevel().getLevelNo()
           };
           tableModel.addRow(rowData);
       }
       return tableModel;
   }
}
