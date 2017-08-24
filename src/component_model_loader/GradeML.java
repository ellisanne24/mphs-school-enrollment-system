/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_model_loader;

import daoimpl.GradeDaoImpl;
import daoimpl.SubjectDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import model.faculty.Faculty;
import model.grade.Grade;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.section.Section;
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
    List <Object> gradingPeriodList = new ArrayList();
    List <Object> isSubmittedList = new ArrayList();
    public GradeML()
    {
    }
    
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
        Object[] obj = gdi.getAllStudentByAdviserId(aFaculty, aSchoolYear).toArray();
        DefaultListModel model = new DefaultListModel();
        for(Object o : obj)
        {
            Grade grade = (Grade) o;
            
            model.addElement("("+grade.student.getStudentId()+") " + grade.student.getFirstName() + " " + grade.student.getMiddleName() + ". " + grade.student.getLastName());
        }
        
        return model;
    }
    
    public DefaultTableModel getStudentGradeByAdviserStudentId(Faculty aFaculty, Student aStudent)
    {
        Object[] obj = gdi.getStudentGradeByAdviserStudentId(aFaculty, aStudent).toArray();
        Object[] columnSubjectId = new Object [gdi.getStudentGradeByAdviserStudentId(aFaculty, aStudent).size()];
        Object[] columnSubjectTitle = new Object [gdi.getStudentGradeByAdviserStudentId(aFaculty, aStudent).size()];
        Object[] columnGrade1st = new Object [gdi.getStudentGradeByAdviserStudentId(aFaculty, aStudent).size()];
        Object[] columnGrade2nd = new Object [gdi.getStudentGradeByAdviserStudentId(aFaculty, aStudent).size()];
        Object[] columnGrade3rd = new Object [gdi.getStudentGradeByAdviserStudentId(aFaculty, aStudent).size()];
        Object[] columnGrade4th = new Object [gdi.getStudentGradeByAdviserStudentId(aFaculty, aStudent).size()];
        Object[] columnGradeFinal = new Object [gdi.getStudentGradeByAdviserStudentId(aFaculty, aStudent).size()];
        Object[][] data = new Object[gdi.getStudentGradeByAdviserStudentId(aFaculty, aStudent).size()][7];
        
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
            
            if(grade.getFinalGrade() == 0.0)
            {
                columnGradeFinal[counterGradeFinal++] = "";
            }
            else
            {
                columnGradeFinal[counterGradeFinal++] = grade.getFinalGrade();
            }
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
                new Object[]{"Id", "Learning Areas", "1st Grading", "2nd Grading", "3rd Grading", "4th Grading", "Final Rating"})
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
    
    public DefaultTableModel getAllKinderGradeBySectionId(Section aSection, Faculty aFaculty)
    {
        Object[] obj = gdi.getAllStudentGradeBySectionId(aSection, aFaculty).toArray();
        Object[] columnSubjectId = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()];
        Object[] columnStudentId = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()];
        Object[] columnStudentName = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()];
        Object[] columnSubjectTitle = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()];
        Object[] column1st = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()];
        Object[] column2nd = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()];
        Object[] column3rd = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()];
        Object[] column4th = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()];
        
        Object[][] data = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()][9];
        
        int counterSubjectId = 0;
        int counterStudentId = 0;
        int counterStudentName = 0;
        int counterSubjectTitle = 0;
        int counter1st = 0;
        int counter2nd = 0;
        int counter3rd = 0;
        int counter4th = 0;

        int counterOne = 0;
        int counterTwo = 0;
        int counterThree = 0;
        int counterFour = 0;
        int counterFive = 0;
        int counterSix = 0;
        int counterSeven = 0;
        int counterEight = 0;
        
        for(Object o : obj)
        {
            Grade grade = (Grade) o;

            columnSubjectId[counterSubjectId++] = grade.subject.getSubjectId();
            columnSubjectTitle[counterSubjectTitle++] = grade.subject.getSubjectTitle();
            columnStudentId[counterStudentId++] = grade.student.getStudentId();
            columnStudentName[counterStudentName++] = grade.student.getFirstName() + " " + grade.student.getMiddleName() + ". " + grade.student.getLastName();

            if(grade.getFirstQtr() == "0.0")
            {
                column1st[counter1st++] = "";
            }
            else
            {
                column1st[counter1st++] = grade.getFirstQtr();
            }

            if(grade.getSecondQtr() == "0.0")
            {
                column2nd[counter2nd++] = "";
            }
            else
            {
                column2nd[counter2nd++] = grade.getSecondQtr();
            }

            if(grade.getThirdQtr() == "0.0")
            {
                column3rd[counter3rd++] = "";
            }
            else
            {
                column3rd[counter3rd++] = grade.getThirdQtr();
            }

            if(grade.getFourthQtr() == "0.0")
            {
                column4th[counter4th++] = "";
            }
            else
            {
                column4th[counter4th++] = grade.getFourthQtr();
            }
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
                        data[row][column] = columnStudentId[counterTwo++];
                        break;
                    case 2:
                        data[row][column] = columnStudentName[counterThree++];
                        break;
                    case 3:
                        data[row][column] = columnSubjectTitle[counterFour++];
                        break;
                    case 4:
                        data[row][column] = column1st[counterFive++];
                        break;
                    case 5:
                        data[row][column] = column2nd[counterSix++];
                        break;
                    case 6:
                        data[row][column] = column3rd[counterSeven++];
                        break;
                    case 7:
                        data[row][column] = column4th[counterEight++];
                        break;
                }
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(data, new Object[]{"Subject Id", "Student Id", "Student Name", "Grading Period", "1st Grading", "2nd Grading", "3rd Grading", "4th Grading"})
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                if(column == 4 || column == 5 || column == 6 || column == 7)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        };
    
        return model;
    }
    
//    private void getCurrentPeriodByStudentId(Grade aGrade)
//    {
//        Object[] obj = gdi.getCurrentPeriodByStudentId(aGrade).toArray();
//        
//        for(Object o : obj)
//        {
//            Grade grade = (Grade) o;
//            
//            gradingPeriodList.add(grade.gradingPeriod.getGradingPeriod());
//            isSubmittedList.add(grade.getIsSubmitted());
//        }
//    }
    
    public DefaultTableModel getAllGradeSchGradeBySectionId(Section aSection, Faculty aFaculty, Grade aGrade)
    {
        Object[] obj = gdi.getAllStudentGradeBySectionId(aSection, aFaculty).toArray();
        Object[] columnSubjectId = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()];
        Object[] columnStudentId = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()];
        Object[] columnGradingId = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()];
        Object[] columnStudentName = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()];
        Object[] columnSubjectTitle = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()];
        Object[] column1st = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()];
        Object[] column2nd = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()];
        Object[] column3rd = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()];
        Object[] column4th = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()];
        Object[] columnFinal = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()];
        
        Object[][] data = new Object[gdi.getAllStudentGradeBySectionId(aSection, aFaculty).size()][10];
        
        int counterSubjectId = 0;
        int counterStudentId = 0;
        int counterGradingId = 0;
        int counterStudentName = 0;
        int counterSubjectTitle = 0;
        int counter1st = 0;
        int counter2nd = 0;
        int counter3rd = 0;
        int counter4th = 0;
        int counterFinal = 0;
        
        int counterOne = 0;
        int counterTwo = 0;
        int counterThree = 0;
        int counterFour = 0;
        int counterFive = 0;
        int counterSix = 0;
        int counterSeven = 0;
        int counterEight = 0;
        int counterNine = 0;
        int counterTen = 0;
        
        for(Object o : obj)
        {
            Grade grade = (Grade) o;
            aGrade.subject.setSubjectId(grade.subject.getSubjectId());
            aGrade.gradingPeriod.setId(grade.gradingPeriod.getId());
            columnSubjectId[counterSubjectId++] = grade.subject.getSubjectId();
            columnGradingId[counterGradingId++] = grade.gradingPeriod.getId();
            columnSubjectTitle[counterSubjectTitle++] = grade.subject.getSubjectTitle();
            columnStudentId[counterStudentId++] = grade.student.getStudentId();
            columnStudentName[counterStudentName++] = grade.student.getFirstName() + " " + grade.student.getMiddleName() + ". " + grade.student.getLastName();

//            if(grade.getFirstQtr() == "0.0")
//            {
//                column1st[counter1st++] = "";
//            }
            if(grade.getFirstQtr() == "0.0")
            {
                column1st[counter1st++] = "";
            }
            else
            {
                column1st[counter1st++] = grade.getFirstQtr();
            }

            if(grade.getSecondQtr() == "0.0")
            {
                column2nd[counter2nd++] = "";
            }
            else
            {
                column2nd[counter2nd++] = grade.getSecondQtr();
            }

            if(grade.getThirdQtr() == "0.0")
            {
                column3rd[counter3rd++] = "";
            }
            else
            {
                column3rd[counter3rd++] = grade.getThirdQtr();
            }

            if(grade.getFourthQtr() == "0.0")
            {
                column4th[counter4th++] = "";
            }
            else
            {
                column4th[counter4th++] = grade.getFourthQtr();
            }

            if(grade.getFinalGrade() == 0.0)
            {
                columnFinal[counterFinal++] = "";
            }
            else
            {
                columnFinal[counterFinal++] = grade.getFinalGrade();
            }
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
                        data[row][column] = columnStudentId[counterTwo++];
                        break;
                    case 2:
                        data[row][column] = columnGradingId[counterThree++];
                        break;
                    case 3:
                        data[row][column] = columnStudentName[counterFour++];
                        break;
                    case 4:
                        data[row][column] = columnSubjectTitle[counterFive++];
                        break;
                    case 5:
                        data[row][column] = column1st[counterSix++];
                        break;
                    case 6:
                        data[row][column] = column2nd[counterSeven++];
                        break;
                    case 7:
                        data[row][column] = column3rd[counterEight++];
                        break;
                    case 8:
                        data[row][column] = column4th[counterNine++];
                        break;
                    case 9:
                        data[row][column] = columnFinal[counterTen++];
                        break;
                }
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(data, new Object[]{"Subject Id", "Student Id", "Grading Id", "Student Name", "Grading Period", "1st Grading", "2nd Grading", "3rd Grading", "4th Grading", "Final Rating"})
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                if(column == 5 || column == 6 || column == 7 || column == 8)
                {
                    return true;
                }
//                if(column == 5)
//                {
//                    if(gdi.getCurrentPeriodBySubjectId(aGrade) == 0 && 
//                       gdi.getPeriodStatusByGradingPeriodId(aGrade) == 0 ||
//                       gdi.getCurrentPeriodBySubjectId(aGrade) == 1 &&
//                       gdi.getPeriodStatusByGradingPeriodId(aGrade) == 0)
//                    {
//                        return true;
//                        
//                        
//                    }
//                }
//                else if(column == 6)
//                {
//                    if(gdi.getCurrentPeriodBySubjectId(aGrade) == 1 && 
//                       gdi.getPeriodStatusByGradingPeriodId(aGrade) == 1)
//                    {
//                        return true;
//                    }
//                    else if(gdi.getCurrentPeriodBySubjectId(aGrade) == 2 && 
//                            gdi.getPeriodStatusByGradingPeriodId(aGrade) == 0)
//                    {
//                        return true;
//                    }
//                }
//                else if(column == 7)
//                {
//                    if(gdi.getCurrentPeriodBySubjectId(aGrade) == 2 && 
//                       gdi.getPeriodStatusByGradingPeriodId(aGrade) == 1)
//                    {
//                        return true;
//                    }
//                    else if(gdi.getCurrentPeriodBySubjectId(aGrade) == 3 &&
//                            gdi.getPeriodStatusByGradingPeriodId(aGrade) == 0)
//                    {
//                        return true;
//                    }
//                }
//                else if(column == 8)
//                {
//                    if(gdi.getCurrentPeriodBySubjectId(aGrade) == 3 &&
//                       gdi.getPeriodStatusByGradingPeriodId(aGrade) == 1)
//                    {
//                        return true;
//                    }
//                    else if(gdi.getCurrentPeriodBySubjectId(aGrade) == 4 &&
//                            gdi.getPeriodStatusByGradingPeriodId(aGrade) == 0)
//                    {
//                        return true;
//                    }
//                }
                
                return false;
            }
        };
           
        return model;
        
    }
    
    public DefaultTableModel getAttendanceModel()
    {
        Object[][] data = new Object[3][12];
        
        for(int row = 0; row < data.length; row++)
        {
            for(int column = 0; column < data[row].length; column++)
            {
                if(row == 0)
                {
                    if(column == 0)
                    {
                        data[row][column] = "No. of School Days";
                    }
                }
                else if(row == 1)
                {
                    if(column == 0)
                    {
                        data[row][column] = "No. of Days Present";
                    }
                }
                else if(row == 2)
                {
                    if(column == 0)
                    {
                        data[row][column] = "No. of Days Absent";
                    }
                }
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(data, new Object[]{"", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec", "Jan", "Feb", "Mar", "Total"})
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                if(column == 0 || column == 12)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
        };
    
        return model;
    }
    
    public DefaultTableModel getAllKinderCharBuilding(GradeLevel aGradeLevel, Section aSection)
    {
        Object[][] data = new Object[4][5];
        
        
        for(int row = 0; row < data.length; row++)
        {
            for(int column = 0; column < data[row].length; column++)
            {
                if(row == 0)
                {
                    if(column == 0)
                    {
                        data[row][column] = "Makadiyos";
                    }
                }
                else if(row == 1)
                {
                    if(column == 0)
                    {
                        data[row][column] = "Makatao";
                    }
                }
                else if(row == 2)
                {
                    if(column == 0)
                    {
                        data[row][column] = "Makakalikasan";
                    }
                }
                else
                {
                    if(column == 0)
                    {
                        data[row][column] = "Makabansa";
                    }
                }
            }   
        }
        
        DefaultTableModel model = new DefaultTableModel(data, new Object[]{"Core Values", "1st Grading", "2nd Grading", "3rd Grading", "4th Grading"})
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                if(column == 1 || column == 2 || column == 3 || column == 4)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        };
        
        return model;
    }
    
    public DefaultTableModel getAllGradeSchCharBuilding(GradeLevel aGradeLevel, Section aSection)
    {
        Object[][] data = new Object[7][6];
       
        for(int row = 0; row < data.length; row++)
        {
            for(int column = 0; column < data[row].length; column++)
            {
                if(row == 0)
                {
                    if(column == 0)
                    {
                        data[row][column] = "Makadiyos";
                    }
                    else if(column == 1)
                    {
                        data[row][column] = "Expresses one's spiritual beliefs while respecting"
                                + " the spiritual beliefs of others";
                    }
                }
                else if(row == 1)
                {
                    if(column == 1)
                    {
                        data[row][column] = "Shows adherence to ethical principles by"
                                + " upholding the truth in all undertakings";
                    }
                }
                else if(row == 2)
                {
                    if(column == 0)
                    {
                        data[row][column] = "Makatao";
                    }
                    else if(column == 1)
                    {
                        data[row][column] = "Is sensitive to individual social and cultural"
                                + " differences; resists stereotyping people";
                    }
                }
                else if(row == 3)
                {
                    if(column == 1)
                    {
                        data[row][column] = "Demonstrates contributions toward solidarity";
                    }
                }
                else if(row == 4)
                {
                    if(column == 0)
                    {
                        data[row][column] = "Maka-kalikasan";
                    }
                    else if(column == 1)
                    {
                        data[row][column] = "Cares for the enviroment and utilizes resources"
                                + " wisely, judiciously, and economically";
                    }
                }
                else if(row == 5)
                {
                    if(column == 0)
                    {
                        data[row][column] = "Makabansa";
                    }
                    else if(column == 1)
                    {
                        data[row][column] = "Demonstrates pride in being a Filipino; exercises"
                                + " the rights and responsibilities of a Filipino citizen";
                    }
                }
                else if(row == 6)
                {
                    if(column == 1)
                    {
                        data[row][column] = "Demonstrates appropriate behavior in carrying out activities"
                            + " in the school, community, and country";
                    }
                }
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(data, new Object[]{"Core Values", "Behavior Statements", "1st Grading", "2nd Grading", "3rd Grading", "4th Grading"})
        {
//            @Override
//            public boolean isCellEditable(int row, int column)
//            {
//                if(gdi.getCurrentPeriodOfCharacterBldng(aGrade) == 0)
//                {
//                    
//                }
//            }
        };
        
        return model;
    }
    
    public Object[][] getCharBuildingByStudentId(Grade aGrade)
    {
        Object[] obj = gdi.getCharBuildingByStudentId(aGrade).toArray();
        Object[] column1st = new Object[gdi.getCharBuildingByStudentId(aGrade).size()];
        Object[] column2nd = new Object[gdi.getCharBuildingByStudentId(aGrade).size()];
        Object[] column3rd = new Object[gdi.getCharBuildingByStudentId(aGrade).size()];
        Object[] column4th = new Object[gdi.getCharBuildingByStudentId(aGrade).size()];
        Object[][] data = new Object[gdi.getCharBuildingByStudentId(aGrade).size()][4];
        
        int counter1st = 0;
        int counter2nd = 0;
        int counter3rd = 0;
        int counter4th = 0;
        
        int counterOne = 0;
        int counterTwo = 0;
        int counterThree = 0;
        int counterFour = 0;
        int counterFive = 0;
        int counterSix = 0;
        
        for(Object o : obj)
        {
            Grade grade = (Grade) o;
            
            column1st[counter1st++] = grade.getFirstQtr();
            column2nd[counter2nd++] = grade.getSecondQtr();
            column3rd[counter3rd++] = grade.getThirdQtr();
            column4th[counter4th++] = grade.getFourthQtr();
        }
        
        for(int row = 0; row < data.length; row++)
        {
            for(int column = 0; column < data[row].length; column++)
            {
                switch(column)
                {
                    case 0:
                        data[row][column] = column1st[counterThree++];
                        break;
                    case 1:
                        data[row][column] = column2nd[counterFour++];
                        break;
                    case 2:
                        data[row][column] = column3rd[counterFive++];
                        break;
                    case 3:
                        data[row][column] = column4th[counterSix++];
                        break;
                }
            }
        }
        
//        DefaultTableModel model = new DefaultTableModel(data, new String[]{"Core Values", "Behavior Statements", "1st Grading", "2nd Grading", "3rd Grading", "4th Grading"});
        
        
//        return model;

        return data;
    }
    
    public Object[][] getAllStudentAttendanceByStudentId(Grade aGrade)
    {
        Object[] obj = gdi.getStudentAttendanceBySchoolDays(aGrade).toArray();
        Object[] columnJun = new Object[gdi.getStudentAttendanceBySchoolDays(aGrade).size()];
        Object[] columnJul = new Object[gdi.getStudentAttendanceBySchoolDays(aGrade).size()];
        Object[] columnAug = new Object[gdi.getStudentAttendanceBySchoolDays(aGrade).size()];
        Object[] columnSept = new Object[gdi.getStudentAttendanceBySchoolDays(aGrade).size()];
        Object[] columnOct = new Object[gdi.getStudentAttendanceBySchoolDays(aGrade).size()];
        Object[] columnNov = new Object[gdi.getStudentAttendanceBySchoolDays(aGrade).size()];
        Object[] columnDec = new Object[gdi.getStudentAttendanceBySchoolDays(aGrade).size()];
        Object[] columnJan = new Object[gdi.getStudentAttendanceBySchoolDays(aGrade).size()];
        Object[] columnFeb = new Object[gdi.getStudentAttendanceBySchoolDays(aGrade).size()];
        Object[] columnMar = new Object[gdi.getStudentAttendanceBySchoolDays(aGrade).size()];
        
        Object[][] data = new Object[gdi.getCharBuildingByStudentId(aGrade).size()][12];
        
        int counterJun = 0;
        int counterJul = 0;
        int counterAug = 0;
        int counterSept = 0;
        int counterOct= 0;
        int counterNov = 0;
        int counterDec = 0;
        int counterJan = 0;        
        int counterFeb = 0;
        int counterMar = 0;
        
        int counterOne = 0;
        int counterTwo = 0;
        int counterThree = 0;
        int counterFour = 0;
        int counterFive = 0;
        int counterSix = 0;
        int counterSeven = 0;
        int counterEight = 0;
        int counterNine = 0;
        int counterTen = 0;
        
        
        for(Object o : obj)
        {
//            Grade grade = (Grade) o;
//            
//            columnJun[counterJun++] = grade.attendance.getJun();
//            columnJul[counterJul++] = grade.attendance.getJul();
//            columnAug[counterAug++] = grade.attendance.getAug();
//            columnSept[counterSept++] = grade.attendance.getSept();
//            columnOct[counterOct++] = grade.attendance.getOct();
//            columnNov[counterNov++] = grade.attendance.getNov();
//            columnDec[counterDec++] = grade.attendance.getDec();
//            columnJan[counterJan++] = grade.attendance.getJan();
//            columnFeb[counterFeb++] = grade.attendance.getFeb();
//            columnMar[counterMar++] = grade.attendance.getMar();
        }
        
        
        for(int row = 0; row < data.length; row++)
        {
            for(int column = 1; column < data[row].length; column++)
            {
                switch(column)
                {
                    case 0:
                        data[row][column] = columnJun[counterOne++];
                        break;
                    case 1:
                        data[row][column] = columnJul[counterTwo++];
                        break;
                    case 2:
                        data[row][column] = columnAug[counterThree++];
                        break;
                    case 3:
                        data[row][column] = columnSept[counterFour++];
                        break;
                    case 4:
                        data[row][column] = columnOct[counterFive++];
                        break;
                    case 5:
                        data[row][column] = columnNov[counterSix++];
                        break;
                    case 6:
                        data[row][column] = columnDec[counterSeven++];
                        break;
                    case 7:
                        data[row][column] = columnJan[counterEight++];
                        break;
                    case 8:
                        data[row][column] = columnFeb[counterNine++];
                        break;
                    case 9:
                        data[row][column] = columnMar[counterTen++];
                        break;
                }
            }
        }
        
        return data;
        
    }
    
    public DefaultTableModel getReportCardByStudentId(Grade aGrade)
    {
        Object[] obj = gdi.getReportCardByStudentId(aGrade).toArray();
        Object[] columnTitle = new Object[gdi.getReportCardByStudentId(aGrade).size()];
        Object[] column1st = new Object[gdi.getReportCardByStudentId(aGrade).size()];
        Object[] column2nd = new Object[gdi.getReportCardByStudentId(aGrade).size()];
        Object[] column3rd = new Object[gdi.getReportCardByStudentId(aGrade).size()];
        Object[] column4th = new Object[gdi.getReportCardByStudentId(aGrade).size()];
        Object[] columnFinal = new Object[gdi.getReportCardByStudentId(aGrade).size()];
        Object[] columnGWA = new Object[gdi.getReportCardByStudentId(aGrade).size()];
        Object[][] data = new Object[gdi.getReportCardByStudentId(aGrade).size()][6];
        
        int counterTitle = 0;
        int counter1st = 0;
        int counter2nd = 0;
        int counter3rd = 0;
        int counter4th = 0;
        int counterFinal = 0;
        int counterGWA = 0;
        
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
            
            columnTitle[counterTitle++] = grade.subject.getSubjectTitle();
            column1st[counter1st++] = grade.getFirstQtr();
            column2nd[counter2nd++] = grade.getSecondQtr();
            column3rd[counter3rd++] = grade.getThirdQtr();
            column4th[counter4th++] = grade.getFourthQtr();
            columnFinal[counterFinal++] = grade.getFinalGrade();
            columnGWA[counterGWA++] = grade.getGwa();
            
        }
        
        
        for(int row = 0; row < data.length; row++)
        {
            for(int column = 0; column < data[row].length; column++)
            {
                switch(column)
                {
                    case 0:
                        data[row][column] = columnTitle[counterOne++];
                        break;
                    case 1:
                        data[row][column] = column1st[counterTwo++];
                        break;
                    case 2:
                        data[row][column] = column2nd[counterThree++];
                        break;
                    case 3:
                        data[row][column] = column3rd[counterFour++];
                        break;
                    case 4:
                        data[row][column] = column4th[counterFive++];
                        break;
                    case 5:
                        data[row][column] = columnFinal[counterSix++];
                        break;
                    case 6:
                        data[row][column] = columnGWA[counterSix++];
                        break;
                }
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(data, new String[]{"Learning Areas", "1st Grading", "2nd Grading", "3rd Grading", "4th Grading", "Final Rating"});
    
        return model;
    }
    
}