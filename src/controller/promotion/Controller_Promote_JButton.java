
package controller.promotion;


import daoimpl.GradeLevelDaoImpl;
import daoimpl.PromotionDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.StudentDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.gradelevel.GradeLevel;
import model.promotionInfo.PromotionInfo;
import model.schoolyear.SchoolYear;
import model.student.Student;
import view.promotion.Dialog_Promotion;

/**
 *
 * @author Jordan
 */
public class Controller_Promote_JButton implements ActionListener{
    
    private final PromotionDaoImpl promotionDaoImpl;
    private final StudentDaoImpl studentDaoImpl;
    private final GradeLevelDaoImpl gradeLevelDaoImpl;
    private final Dialog_Promotion view;
    private final SchoolYear currentSchoolYear;

    public Controller_Promote_JButton(Dialog_Promotion view, SchoolYear currentSchoolYear) {
        this.view = view;
        this.currentSchoolYear = currentSchoolYear;
        this.promotionDaoImpl = new PromotionDaoImpl();
        this.studentDaoImpl = new StudentDaoImpl();
        this.gradeLevelDaoImpl = new GradeLevelDaoImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int choice = JOptionPane.showConfirmDialog(null, "Promote passed students?", "Promotion confirmation", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION){
            if(studentsSubjectGradesComplete(getStudentsToPromote())){
//                boolean isSuccessful = promotionDaoImpl.promoteStudents(getStudentsToPromote());
//                if (isSuccessful) {
//                    JOptionPane.showMessageDialog(null, "Promotion Successful!");
//                } else {
//                    JOptionPane.showMessageDialog(null, "Encountered problems processing request. Please contact your support.");
//                }
            }else{
                JOptionPane.showMessageDialog(null,"Some students have incomplete grades.\nYou can only proceed with promotion once all subjects are graded.");
            }
            
        }
    }
    
    private List<Student> getStudentsToPromote() {
        List<Student> studentList = new ArrayList<>();
        JTable t = view.getJtblStudents();
        for (int row = 0; row < t.getRowCount(); row++) {
            Object studentNo = t.getValueAt(row, 1);
            Object grade = t.getValueAt(row, 3);
            int gradeLevelFrom = Integer.parseInt(t.getValueAt(row, 2).toString().trim());
            if(studentNo != null && grade != null){
                int gradeLevelTo = (gradeLevelFrom + 1);
                if(Integer.parseInt(grade.toString().trim()) >= 75){
                    int sNo = Integer.parseInt(studentNo.toString().trim());
                    PromotionInfo promotionInfo = new PromotionInfo();
                    promotionInfo.setPromotionGradeLevelFrom(gradeLevelFrom);
                    promotionInfo.setPromotionGradeLevelTo(gradeLevelTo);
                    promotionInfo.setSchoolYearPromoted(currentSchoolYear);
                    
                    Student student = studentDaoImpl.getStudentByStudentNo(sNo);
                    student.setPromotionInfo(promotionInfo);
                    studentList.add(student);
                }
            }
        }
        return studentList;
    }
    
    private List<Student> getStudentsForSummer() {
        List<Student> studentList = new ArrayList<>();
        return studentList;
    }
    
    /**
     * Use this method with studentssubjectGradesComplete()
     * studentssubjectGradeComplete() needs to check all students, both passed and failed
     * @return 
     */
    private List<Student> getAllStudents(){
        List<Student> studentList = new ArrayList<>();
        return studentList;
    }
    
    private boolean studentsSubjectGradesComplete(List<Student> studentList){
        boolean isComplete= false;
        List<Student> studentWithIncompleteGrades = new ArrayList<>();
        for(Student student : studentList){
            int gradeLevelNo = student.getPromotionInfo().getPromotionGradeLevelFrom();
            GradeLevel gradeLevel = new GradeLevel();
            gradeLevel.setGradeLevelID(gradeLevelDaoImpl.getId(gradeLevelNo));
            isComplete = promotionDaoImpl.areAllStudentGradePerSubjectSubmitted(student, currentSchoolYear, gradeLevel);
            JOptionPane.showMessageDialog(null,"Student: "+student.getRegistration().getLastName() +"\nIsComplete : "+isComplete);
            if(!isComplete){
                studentWithIncompleteGrades.add(student);
            }
        }
        JOptionPane.showMessageDialog(null,"Size: "+studentWithIncompleteGrades.size());
        return studentWithIncompleteGrades.size() == 0;
    }
    
}
