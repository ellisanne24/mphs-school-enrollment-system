package daoimpl;

import model.admission.Admission;
import dao.IAdmission;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import utility.database.DBType;
import utility.database.DBUtil;

public class AdmissionDaoImpl implements IAdmission {

    private final GradeLevelDaoImpl gradeLevelDaoImpl;
    private final SchoolYearDaoImpl schoolYearDaoImpl;
    
    public AdmissionDaoImpl(){
        gradeLevelDaoImpl = new GradeLevelDaoImpl();
        schoolYearDaoImpl = new SchoolYearDaoImpl();
    }
    
    
    @Override
    public boolean completeAdmission(Admission admission) {
        boolean isSuccessful = false;
        String SQLa = "{CALL addAdmission(?,?,?,?)}";
//        String SQLb = "{CALL addStudent(?,?,?)}";
//        String SQLc = "{CALL addSchoolYearStudent(?,?,?)}";
        int registrationId = admission.getRegistration().getRegistrationId();
        int gradeLevelId = gradeLevelDaoImpl.getId(admission.getRegistration().getGradeLevelNo());
        int schoolYearId = schoolYearDaoImpl.getCurrentSchoolYearId();
        
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);){
            con.setAutoCommit(false);
            try (CallableStatement csa = con.prepareCall(SQLa);){
                csa.setInt(1, registrationId);
                csa.setInt(2, gradeLevelId);
                csa.setInt(3, schoolYearId);
                csa.registerOutParameter(4, Types.INTEGER);
                csa.executeUpdate();
                
//                int admissionId = csa.getInt(4);
//                String studentType = admission.getRegistration().getStudentType().trim();
//                csb.setInt(1, admissionId);
//                csb.setString(2, studentType);
//                csb.registerOutParameter(3, Types.INTEGER);
//                csb.executeUpdate();
//                
//                int studentId = csb.getInt(3);
//                csc.setInt(1, schoolYearId);
//                csc.setInt(2,studentId);
//                csc.setInt(3, gradeLevelId);
//                csc.executeUpdate();
                
                con.commit();
                isSuccessful = true;
            } catch (SQLException e) {
                con.rollback();
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isSuccessful;
    }

}
