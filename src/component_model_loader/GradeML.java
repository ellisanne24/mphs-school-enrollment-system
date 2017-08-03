/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_model_loader;

import daoimpl.GradeDaoImpl;
import daoimpl.SubjectDaoImpl;
import javax.swing.table.DefaultTableModel;
import model.grade.Grade;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.subject.Subject;

/**
 *
 * @author francisunoxx
 */
public class GradeML 
{
    SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
    GradeDaoImpl gdi = new GradeDaoImpl();
    
   
    
    public DefaultTableModel getAllSubjectNameByGradeLevelId(GradeLevel gl)
    {
        Object[] obj = subjectDaoImpl.getAllSubjectsByGradeLevelId(gl).toArray();
        
        Object[] columnId = new Object[subjectDaoImpl.getAllSubjectsByGradeLevelId(gl).size()];
        Object[] columnTitle = new Object[subjectDaoImpl.getAllSubjectsByGradeLevelId(gl).size()];
        
        Object[][] data = new Object[subjectDaoImpl.getAllSubjectsByGradeLevelId(gl).size()][5];
        
        int counterId = 0;
        int counterTitle = 0;
        
        int counterOne = 0;
        int counterTwo = 0;
        
        for(Object o : obj)
        {
            Subject subject = (Subject)o;
            
            columnId[counterId++] = subject.getSubjectId();
            columnTitle[counterTitle++] = subject.getSubjectTitle();
        }
        
        for(int row = 0; row < data.length; row++)
        {
            for(int column = 0; column < data[row].length; column++)
            {
                switch(column)
                {
                    case 0:
                        data[row][column] = columnId[counterOne++];
                        break;
                    case 1:
                        data[row][column] = columnTitle[counterTwo++];
                        break;
                }
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(data, 
                new Object[]{"Id", "Grading Period", "1st Grading", "2nd Grading", "3rd Grading", "4th Grading", "Final Rating"})
        {
            @Override
            public boolean isCellEditable(int row, int col) {
                //Note that the data/cell address is constant,
                //no matter where the cell appears onscreen.
                if (col == 6) {
                    return false;
                } else {
                    return true;
                }

            }
        };
        
        return model;
    }
    
    public DefaultTableModel getAllStudentGradeByGradeLevelId(GradeLevel gradeLevel, SchoolYear aSchoolYear)
    {
        Object[] obj = gdi.getAllStudentGradeByGradeLevelId(gradeLevel, aSchoolYear).toArray();
        
        Object[] columnStudentId = new Object[gdi.getAllStudentGradeByGradeLevelId(gradeLevel, aSchoolYear).size()];
        Object[] columnStudentName = new Object[gdi.getAllStudentGradeByGradeLevelId(gradeLevel, aSchoolYear).size()];
        Object[] columnGradeLevel = new Object[gdi.getAllStudentGradeByGradeLevelId(gradeLevel, aSchoolYear).size()];
        Object[] columnGWA = new Object[gdi.getAllStudentGradeByGradeLevelId(gradeLevel, aSchoolYear).size()];
        Object[] columnStatus = new Object[gdi.getAllStudentGradeByGradeLevelId(gradeLevel, aSchoolYear).size()];
                
        Object[][] data = new Object[gdi.getAllStudentGradeByGradeLevelId(gradeLevel, aSchoolYear).size()][5];
        
        int counterStudentId = 0;
        int counterStudentName = 0;
        int counterGradeLevel = 0;
        int counterGWA = 0;
        int counterStatus = 0;
        
        int counterOne = 0;
        int counterTwo = 0;
        int counterThree = 0;
        int counterFour = 0;
        int counterFive = 0;
        
        for(Object o : obj)
        {
            Grade grade = (Grade)o;
            
            columnStudentId[counterStudentId++] = grade.student.getStudentId();
            columnStudentName[counterStudentName++] = grade.student.getFirstName() + " " + grade.student.getMiddleName() + ". " + grade.student.getLastName();
            columnGradeLevel[counterGradeLevel++] = grade.gradeLevel.getLevel();
            columnGWA[counterGWA++] = grade.getGwa();
            
            if(grade.getGwa() >= 75)
            {
                columnStatus[counterStatus++] = "Passed";
            }
            else
            {
                columnStatus[counterStatus++] = "Failed";
            }
        }
        
        for(int row = 0; row < data.length; row++)
        {
            for(int column = 0; column < data[row].length; column++)
            {
                switch(column)
                {
                    case 0:
                        data[row][column] = columnStudentId[counterOne++];
                        break;
                    case 1:
                        data[row][column] = columnStudentName[counterTwo++];
                        break;
                    case 2:
                        data[row][column] = columnGradeLevel[counterThree++];
                        break;
                    case 3:
                        data[row][column] = columnGWA[counterFour++];
                        break;
                    default:
                        data[row][column] = columnStatus[counterFive++];
                        break;
                        
                }
            }
        }
        
        
        DefaultTableModel model = new DefaultTableModel(data, new Object[]{"Student Number", "Student Name", "Grade Level", "General Average", "Remarks"})
        {
            @Override
            public boolean isCellEditable(int row, int col) {
                //Note that the data/cell address is constant,
                //no matter where the cell appears onscreen.
                if (col < 5) {
                    return false;
                } else {
                    return true;
                }

            }
        };
        
        return model;
    }
    
    public DefaultTableModel getAllPromotedBySchoolYearId(SchoolYear aSchoolYear)
    {
        Object[] obj = gdi.getAllPromotedBySchoolYearId(aSchoolYear).toArray();
        Object[] columnStudentId = new Object[gdi.getAllPromotedBySchoolYearId(aSchoolYear).size()];
        Object[] columnStudentName = new Object[gdi.getAllPromotedBySchoolYearId(aSchoolYear).size()];
        Object[] columnLevel = new Object[gdi.getAllPromotedBySchoolYearId(aSchoolYear).size()];
        Object[][] data = new Object[gdi.getAllPromotedBySchoolYearId(aSchoolYear).size()][3];
        
        int counterStudentId = 0;
        int counterStudentName = 0;
        int counterLevel = 0;
        
        int counterOne = 0;
        int counterTwo = 0;
        int counterThree = 0;
        
        for(Object o : obj)
        {
            Grade grade = (Grade)o;
            
            columnStudentId[counterStudentId++] = grade.student.getStudentId();
            columnStudentName[counterStudentName++] = grade.student.getFirstName() + " " + grade.student.getMiddleName() + ". " + grade.student.getLastName();
            columnLevel[counterLevel++] = grade.gradeLevel.getLevel();
        }
        
        for(int row = 0; row < data.length; row++)
        {
            for(int column = 0; column < data[row].length; column++)
            {
                switch(column)
                {
                    case 0:
                        data[row][column] = columnStudentId[counterOne++];
                        break;
                    case 1:
                        data[row][column] = columnStudentName[counterTwo++];
                        break;
                    case 2:
                        data[row][column] = columnLevel[counterThree++];
                        break;
                }
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(data, new Object[]{"Student Number", "Student Name", "Grade Level"})
        {
            @Override
            public boolean isCellEditable(int row, int col) {
                //Note that the data/cell address is constant,
                //no matter where the cell appears onscreen.
                if (col < 3) {
                    return false;
                } else {
                    return true;
                }

            }
        };
        
        return model;
    }
    
    public DefaultTableModel getAllPromotedStudent()
    {
        Object[] obj = gdi.getAllPromotedStudent().toArray();
        Object[] columnStudentId = new Object[gdi.getAllPromotedStudent().size()];
        Object[] columnStudentName = new Object[gdi.getAllPromotedStudent().size()];
        Object[] columnLevel = new Object[gdi.getAllPromotedStudent().size()];
        Object[][] data = new Object[gdi.getAllPromotedStudent().size()][3];
        
        int counterStudentId = 0;
        int counterStudentName = 0;
        int counterLevel = 0;
        
        int counterOne = 0;
        int counterTwo = 0;
        int counterThree = 0;
        
        for(Object o : obj)
        {
            Grade grade = (Grade)o;
            
            columnStudentId[counterStudentId++] = grade.student.getStudentId();
            columnStudentName[counterStudentName++] = grade.student.getFirstName() + " " + grade.student.getMiddleName() + ". " + grade.student.getLastName();
            columnLevel[counterLevel++] = grade.gradeLevel.getLevel();
        }
        
        for(int row = 0; row < data.length; row++)
        {
            for(int column = 0; column < data[row].length; column++)
            {
                switch(column)
                {
                    case 0:
                        data[row][column] = columnStudentId[counterOne++];
                        break;
                    case 1:
                        data[row][column] = columnStudentName[counterTwo++];
                        break;
                    case 2:
                        data[row][column] = columnLevel[counterThree++];
                        break;
                }
            }
        }
        
        
        DefaultTableModel model = new DefaultTableModel(data, new Object[]{"Student Number", "Student Name", "Current Level"})
        {
            @Override
            public boolean isCellEditable(int row, int col) {
                //Note that the data/cell address is constant,
                //no matter where the cell appears onscreen.
                if (col < 3) {
                    return false;
                } else {
                    return true;
                }

            }
        };
        
        return model;
    }
}
