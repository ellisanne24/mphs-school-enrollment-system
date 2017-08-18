/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_model_loader;

import daoimpl.GradeDaoImpl;
import daoimpl.SubjectDaoImpl;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import model.faculty.Faculty;
import model.grade.Grade;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.student.Student;
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
    
    public DefaultTableModel getAllStudentRemarksByGradeLevelId(GradeLevel gradeLevel, SchoolYear aSchoolYear)
    {
        Object[] obj = gdi.getAllStudentRemarksByGradeLevelId(gradeLevel, aSchoolYear).toArray();
        
        Object[] columnStudentId = new Object[gdi.getAllStudentRemarksByGradeLevelId(gradeLevel, aSchoolYear).size()];
        Object[] columnStudentName = new Object[gdi.getAllStudentRemarksByGradeLevelId(gradeLevel, aSchoolYear).size()];
        Object[] columnGradeLevel = new Object[gdi.getAllStudentRemarksByGradeLevelId(gradeLevel, aSchoolYear).size()];
        Object[] columnGWA = new Object[gdi.getAllStudentRemarksByGradeLevelId(gradeLevel, aSchoolYear).size()];
        Object[] columnStatus = new Object[gdi.getAllStudentRemarksByGradeLevelId(gradeLevel, aSchoolYear).size()];
                
        Object[][] data = new Object[gdi.getAllStudentRemarksByGradeLevelId(gradeLevel, aSchoolYear).size()][5];
        
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
    
    public DefaultTableModel getAllPromotedStudent(SchoolYear aSchoolYear)
    {
        Object[] obj = gdi.getAllPromotedStudent(aSchoolYear).toArray();
        Object[] columnStudentId = new Object[gdi.getAllPromotedStudent(aSchoolYear).size()];
        Object[] columnStudentName = new Object[gdi.getAllPromotedStudent(aSchoolYear).size()];
        Object[] columnLevel = new Object[gdi.getAllPromotedStudent(aSchoolYear).size()];
        Object[][] data = new Object[gdi.getAllPromotedStudent(aSchoolYear).size()][3];
        
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
            columnLevel[counterLevel++] = grade.gradeLevel.getLevel() == 0? "Kindergarten" : grade.gradeLevel.getLevel();
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
    
    public DefaultTableModel getAllSummerStudent()
    {
        Object[] obj = gdi.getAllSummerStudent().toArray();
        Object[] columnStudentId = new Object[gdi.getAllSummerStudent().size()];
        Object[] columnStudentName = new Object[gdi.getAllSummerStudent().size()];
        Object[] columnLevel = new Object[gdi.getAllSummerStudent().size()];
        Object[][] data = new Object[gdi.getAllSummerStudent().size()][3];
        
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
            columnLevel[counterLevel++] = grade.gradeLevel.getLevel() == 0 ? "Kindergarten":grade.gradeLevel.getLevel();
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
        
        
        DefaultTableModel model = new DefaultTableModel(data, new Object[]{"Student Number", "Student Name", "Grade Level", "Remarks"})
        {
            @Override
            public boolean isCellEditable(int row, int col) {
                //Note that the data/cell address is constant,
                //no matter where the cell appears onscreen.
                if (col < 4) {
                    return false;
                } else {
                    return true;
                }

            }
        };
        
        return model;
    }
    
    public DefaultTableModel getAllStudentGradeByStudentId(Student aStudent)
    {
        Object[] obj = gdi.getAllStudentGradeByStudentId(aStudent).toArray();
        Object[] columnSubjectId = new Object [gdi.getAllStudentGradeByStudentId(aStudent).size()];
        Object[] columnSubjectTitle = new Object [gdi.getAllStudentGradeByStudentId(aStudent).size()];
        Object[] columnGrade1st = new Object [gdi.getAllStudentGradeByStudentId(aStudent).size()];
        Object[] columnGrade2nd = new Object [gdi.getAllStudentGradeByStudentId(aStudent).size()];
        Object[] columnGrade3rd = new Object [gdi.getAllStudentGradeByStudentId(aStudent).size()];
        Object[] columnGrade4th = new Object [gdi.getAllStudentGradeByStudentId(aStudent).size()];
        Object[] columnGradeFinal = new Object [gdi.getAllStudentGradeByStudentId(aStudent).size()];
        Object[][] data = new Object[gdi.getAllStudentGradeByStudentId(aStudent).size()][7];
        
        int counterSubjectId = 0;
        int counterSubjectTitle = 0;
        int counterGrade1st = 0;
        int counterGrade2nd = 0;
        int counterGrade3rd = 0;
        int counterGrade4th = 0;
        int counterGradeFinal = 0;
        
        int counterOne = 0;
        int counterTwo = 0;
        int counterThree = 0;
        int counterFour = 0;
        int counterFive = 0;
        int counterSix = 0;
        int counterSeven = 0;
        
        for(Object o : obj)
        {
            Grade grade = (Grade)o;
            
            columnSubjectId[counterSubjectId++] = grade.subject.getSubjectId();
            columnSubjectTitle[counterSubjectTitle++] = grade.subject.getSubjectTitle();
            columnGrade1st[counterGrade1st++] = grade.getFirstQtr();
            columnGrade2nd[counterGrade2nd++] = grade.getSecondQtr();
            columnGrade3rd[counterGrade3rd++] = grade.getThirdQtr();
            columnGrade4th[counterGrade4th++] = grade.getFourthQtr();
            columnGradeFinal[counterGradeFinal++] = grade.getFinalGrade();
        }
        
        for(int row = 0; row < data.length; row++)
        {
            for(int column = 0; column < data[row].length; column++)
            {
                switch(column)
                {
                    case 0:
                        data[row][column] = columnSubjectId[counterOne++];
                        break;
                    case 1:
                        data[row][column] = columnSubjectTitle[counterTwo++];
                        break;
                    case 2:
                        data[row][column] = columnGrade1st[counterThree++];
                        break;
                    case 3:
                        data[row][column] = columnGrade2nd[counterFour++];
                        break;
                    case 4:
                        data[row][column] = columnGrade3rd[counterFive++];
                        break;
                    case 5:
                        data[row][column] = columnGrade4th[counterSix++];
                        break;
                    case 6:
                        data[row][column] = columnGradeFinal[counterSeven++];
                        break;
                }
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(data, new String[]{"Id", "Grading Period", "1st Grading", "2nd Grading",
        "3rd Grading", "4th Grading", "Final Rating"})
        {
            @Override
            public Class getColumnClass(int column) 
            {
                //If column has null
                Object value = this.getValueAt(0,column);
                return (value==null?Object.class:value.getClass());
            }
            
            @Override
            public boolean isCellEditable(int row, int col) {
                //Note that the data/cell address is constant,
                //no matter where the cell appears onscreen.
                if (col == 1 || col == 6) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        
        return model;
    }
    
    public DefaultListModel getAllStudentByAdviserSectionId(Faculty aFaculty, SchoolYear aSchoolYear)
    {
        Object[] obj = gdi.getAllStudentByAdviserSectionId(aFaculty, aSchoolYear).toArray();
        DefaultListModel model = new DefaultListModel();
        for(Object o : obj)
        {
            Grade grade = (Grade) o;
            
            model.addElement("("+grade.student.getStudentId()+") " + grade.student.getFirstName() + " " + grade.student.getMiddleName() + ". " + grade.student.getLastName());
        }
        
        return model;
    }
    
    public DefaultTableModel getStudentGradeByFacultyStudentId(Faculty aFaculty, Student aStudent)
    {
        Object[] obj = gdi.getStudentGradeByFacultyStudentId(aFaculty, aStudent).toArray();
        Object[] columnSubjectId = new Object [gdi.getStudentGradeByFacultyStudentId(aFaculty, aStudent).size()];
        Object[] columnSubjectTitle = new Object [gdi.getStudentGradeByFacultyStudentId(aFaculty, aStudent).size()];
        Object[] columnGrade1st = new Object [gdi.getStudentGradeByFacultyStudentId(aFaculty, aStudent).size()];
        Object[] columnGrade2nd = new Object [gdi.getStudentGradeByFacultyStudentId(aFaculty, aStudent).size()];
        Object[] columnGrade3rd = new Object [gdi.getStudentGradeByFacultyStudentId(aFaculty, aStudent).size()];
        Object[] columnGrade4th = new Object [gdi.getStudentGradeByFacultyStudentId(aFaculty, aStudent).size()];
        Object[] columnGradeFinal = new Object [gdi.getStudentGradeByFacultyStudentId(aFaculty, aStudent).size()];
        Object[][] data = new Object[gdi.getStudentGradeByFacultyStudentId(aFaculty, aStudent).size()][7];
        
        int counterSubjectId = 0;
        int counterSubjectTitle = 0;
        int counterGrade1st = 0;
        int counterGrade2nd = 0;
        int counterGrade3rd = 0;
        int counterGrade4th = 0;
        int counterGradeFinal = 0;
        
        int counterOne = 0;
        int counterTwo = 0;
        int counterThree = 0;
        int counterFour = 0;
        int counterFive = 0;
        int counterSix = 0;
        int counterSeven = 0;
        
        for(Object o : obj)
        {
            Grade grade = (Grade)o;
            
            columnSubjectId[counterSubjectId++] = grade.subject.getSubjectId();
            columnSubjectTitle[counterSubjectTitle++] = grade.subject.getSubjectTitle();
            columnGrade1st[counterGrade1st++] = grade.getFirstQtr();
            columnGrade2nd[counterGrade2nd++] = grade.getSecondQtr();
            columnGrade3rd[counterGrade3rd++] = grade.getThirdQtr();
            columnGrade4th[counterGrade4th++] = grade.getFourthQtr();
            columnGradeFinal[counterGradeFinal++] = grade.getFinalGrade();
        }
        
        for(int row = 0; row < data.length; row++)
        {
            for(int column = 0; column < data[row].length; column++)
            {
                switch(column)
                {
                    case 0:
                        data[row][column] = columnSubjectId[counterOne++];
                        break;
                    case 1:
                        data[row][column] = columnSubjectTitle[counterTwo++];
                        break;
                    case 2:
                        data[row][column] = columnGrade1st[counterThree++];
                        break;
                    case 3:
                        data[row][column] = columnGrade2nd[counterFour++];
                        break;
                    case 4:
                        data[row][column] = columnGrade3rd[counterFive++];
                        break;
                    case 5:
                        data[row][column] = columnGrade4th[counterSix++];
                        break;
                    case 6:
                        data[row][column] = columnGradeFinal[counterSeven++];
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
                if (col == 1 || col == 6) {
                    return false;
                } else {
                    return true;
                }

            }
        };
        
        return model;
    }
    
    public DefaultTableModel getStudentFailedSubjectById(Student aStudent)
    {
        Object[] obj = gdi.getStudentFailedSubjectById(aStudent).toArray();
        Object[] columnSubjectId = new Object [gdi.getStudentFailedSubjectById(aStudent).size()];
        Object[] columnSubjectTitle = new Object [gdi.getStudentFailedSubjectById(aStudent).size()];
        Object[][] data = new Object[gdi.getStudentFailedSubjectById(aStudent).size()][3];
        
        int counterSubjectId = 0;
        int counterSubjectTitle = 0;
        
        int counterOne = 0;
        int counterTwo = 0;
        
        for(Object o : obj)
        {
            Grade grade = (Grade)o;
            
            columnSubjectId[counterSubjectId++] = grade.subject.getSubjectId();
            columnSubjectTitle[counterSubjectTitle++] = grade.subject.getSubjectTitle();
        }
        
        for(int row = 0; row < data.length; row++)
        {
            for(int column = 0; column < data[row].length; column++)
            {
                switch(column)
                {
                    case 0:
                        data[row][column] = columnSubjectId[counterOne++];
                        break;
                    case 1:
                        data[row][column] = columnSubjectTitle[counterTwo++];
                        break;
                    
                }
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(data, 
                new Object[]{"Id", "Subjects", "Grade"})
        {
            @Override
            public boolean isCellEditable(int row, int col) {
                //Note that the data/cell address is constant,
                //no matter where the cell appears onscreen.
                if (col == 2) {
                    return true;
                } else {
                    return false;
                }

            }
        };
        
        return model;
    }
}
