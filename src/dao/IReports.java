/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.classlistreport.ClassListReport;
import model.enrolleesreport.EnrolleesReport;

/**
 *
 * @author John Ferdinand Antonio
 */
public interface IReports {
    List<EnrolleesReport> getAllEnrollees();
    List<EnrolleesReport> getAllEnrollees(int schoolyearId);
    List<EnrolleesReport> getAllEnrollees(int schoolyearId, int gradelevelId);
    List<ClassListReport> getAllClassList();
    List<ClassListReport> getClassList(int schoolYearId);
    List<ClassListReport> getAllClassList(int schoolYearId, int gradeLevelId);
    
}
