package daoimpl;


import dao.IPromotion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.gradelevel.GradeLevel;
import model.promotionInfo.PromotionInfo;
import model.schoolyear.SchoolYear;
import model.student.Student;
import utility.database.DBType;
import utility.database.DBUtil;


/**
 *
 * @author Jordan
 */

public class PromotionDaoImpl implements IPromotion{

    @Override
    public boolean promoteStudents(List<Student> studentsToPromote) {
        boolean isSuccessful = false;
        GradeLevelDaoImpl gradeLevelDaoImpl = new GradeLevelDaoImpl();
        String SQLa = "{CALL markStudentGradeLevelAsPassed(?,?,?)}";
        String SQLb = "{CALL addPromotionRecord(?,?,?,?)}";
        String SQLc = "{CALL addStudentGradeLevelRecord(?,?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            con.setAutoCommit(false);
            try (CallableStatement csa = con.prepareCall(SQLa);
                    CallableStatement csb = con.prepareCall(SQLb);
                    CallableStatement csc = con.prepareCall(SQLc);) {
                for (Student s : studentsToPromote) {
                    PromotionInfo p = s.getPromotionInfo();
                    int studentId = s.getStudentId();
                    int gradeLevelFromId = gradeLevelDaoImpl.getId(p.getPromotionGradeLevelFrom());
                    int gradeLevelToId = gradeLevelDaoImpl.getId(p.getPromotionGradeLevelTo());
                    int yearPromotedSchoolYearId = p.getSchoolYearPromoted().getSchoolYearId();
                    csa.setInt(1, studentId);
                    csa.setInt(2, gradeLevelFromId);
                    csa.setInt(3, yearPromotedSchoolYearId);
                    csa.executeUpdate();
                    
                    csb.setInt(1, studentId);
                    csb.setInt(2, gradeLevelFromId);
                    csb.setInt(3,gradeLevelToId);
                    csb.setInt(4, yearPromotedSchoolYearId);
                    csb.executeUpdate();
                    
                    csc.setInt(1, yearPromotedSchoolYearId);
                    csc.setInt(2, studentId);
                    csc.setInt(3, gradeLevelToId);
                    csc.executeUpdate();
                }
                con.commit();
                isSuccessful = true;
            } catch (SQLException e) {
                con.rollback();
                con.setAutoCommit(true);
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccessful;
    }

    @Override
    public boolean areAllStudentGradePerSubjectSubmitted(Student student, SchoolYear schoolYear, GradeLevel gradeLevel) {
        boolean areAllGradesSubmitted = false;
        String SQL = "{CALL areAllStudentGradePerSubjectSubmitted(?,?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, student.getStudentId());
            cs.setInt(2, schoolYear.getSchoolYearId());
            cs.setInt(3, gradeLevel.getGradeLevelId());
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    areAllGradesSubmitted = rs.getBoolean("all_student_subjects_grade_complete");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return areAllGradesSubmitted;
    }
    
}
