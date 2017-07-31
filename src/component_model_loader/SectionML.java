package component_model_loader;

import daoimpl.SectionDaoImpl;
import daoimpl.StudentDaoImpl;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.session.Session;
import model.student.Student;


public class SectionML {
    private final SectionDaoImpl sectionDaoImpl = new SectionDaoImpl();
    private StudentDaoImpl sdi = new StudentDaoImpl();
    private Object[] column = new Object[]{"Id", "Student Name", "General Average"};
    private Object[] columnStudent = new Object[]{"Id", "Student Name", "Grade Level", "General Average", "Entrance Exam Average"};
    private Object[] columnStudentBySection = new Object[]{"Id", "Student Name"};
    private SchoolYear aSchoolYear = new SchoolYear();
    private GradeLevel aGradeLevel = new GradeLevel();
    private Section aSection = new Section();
    
    public DefaultListModel getSectionForJList(){
        DefaultListModel listModel = new DefaultListModel();
        Object[] sectionList = sectionDaoImpl.getAllSections().toArray();
        for(Object o : sectionList){
            Section section = (Section)o;
            String sectionName = section.getSectionName();
            String sessionTitle = section.getSessionList().get(0).getSessionTitle();
            String gradeLevel = section.getGradeLevel().getLevel()==0?"Kindergarten":"Grade "+section.getGradeLevel().getLevel();
            String element = sectionName +" - "+sessionTitle+" ("+gradeLevel+") ";
            listModel.addElement(element);
        }
        return listModel;
    }
    
    
    
    public DefaultTableModel getAllSections() {
        Object[] obj = sectionDaoImpl.getAllSections().toArray();

        Object[] columnSectionId = new Object[sectionDaoImpl.getAllSections().size()];
        Object[] columnSectionName = new Object[sectionDaoImpl.getAllSections().size()];
        Object[] columnRequiredGrade = new Object[sectionDaoImpl.getAllSections().size()];
        Object[] columnSession = new Object[sectionDaoImpl.getAllSections().size()];
        Object[] columnSchoolYear = new Object[sectionDaoImpl.getAllSections().size()];
        Object[] columnStatus = new Object[sectionDaoImpl.getAllSections().size()];
        Object[][] data = new Object[sectionDaoImpl.getAllSections().size()][9];

        int counterSectionId = 0;
        int counterSectionName = 0;
        int counterRequiredGrade = 0;
        int counterSession = 0;
        int counterSchoolYear = 0;
        int counterStatus = 0;

        int counterOne = 0;
        int counterTwo = 0;
        int counterThree = 0;
        int counterFour = 0;
        int counterFive = 0;
        int counterSix = 0;
        
        for (Object o : obj) {
            Section aSection = (Section) o;

            columnSectionId[counterSectionId++] = aSection.getSectionId();
            columnSectionName[counterSectionName++] = aSection.getSectionName();
            columnRequiredGrade[counterRequiredGrade++] = aSection.getRequiredAverage();
            columnSession[counterSession++] = aSection.session.getSessionTitle();
            columnSchoolYear[counterSchoolYear++] = aSection.schoolYear.getYearFrom() + "-" + aSection.schoolYear.getYearTo();
            
            if (aSection.getIsActive() == 1) {
                columnStatus[counterStatus++] = true;
            } else {
                columnStatus[counterStatus++] = false;
            }

        }

        for (int row = 0; row < data.length; row++) {
            for (int column = 0; column < data[row].length; column++) {
                switch (column) {
                    case 0:
                        data[row][column] = columnSectionId[counterOne++];
                        break;
                    case 1:
                        data[row][column] = columnSectionName[counterTwo++];
                        break;
                    case 2:
                        data[row][column] = columnRequiredGrade[counterThree++];
                        break;
                    case 3:
                        data[row][column] = columnSession[counterFour++];
                        break;
                    case 4:
                        data[row][column] = columnSchoolYear[counterFive++];
                        break;
                    case 5:
                        data[row][column] = columnStatus[counterSix++];
                        break;
                }
            }
        }

        DefaultTableModel model = new DefaultTableModel(data, new Object[]{"Id","Section Name", "Required Grade", "Session", "School Year", "Status"}) {
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
                if (col < 7) {
                    return false;
                } else {
                    return true;
                }
            }
        };

        return model;
    }

    public DefaultTableModel getAllSectionsByGradeLevelId(GradeLevel aGradeLevel) {
        Object[] obj = sectionDaoImpl.getAllSectionsByGradeLevelId(aGradeLevel).toArray();

        Object[] columnSectionId = new Object[sectionDaoImpl.getAllSectionsByGradeLevelId(aGradeLevel).size()];
        Object[] columnSectionName = new Object[sectionDaoImpl.getAllSectionsByGradeLevelId(aGradeLevel).size()];
        Object[] columnRequiredGrade = new Object[sectionDaoImpl.getAllSectionsByGradeLevelId(aGradeLevel).size()];
        Object[] columnSession = new Object[sectionDaoImpl.getAllSectionsByGradeLevelId(aGradeLevel).size()];
        Object[] columnSchoolYear = new Object[sectionDaoImpl.getAllSectionsByGradeLevelId(aGradeLevel).size()];
        Object[] columnStatus = new Object[sectionDaoImpl.getAllSectionsByGradeLevelId(aGradeLevel).size()];
        Object[][] data = new Object[sectionDaoImpl.getAllSectionsByGradeLevelId(aGradeLevel).size()][7];

        int counterSectionId = 0;
        int counterSectionName = 0;
        int counterRequiredGrade = 0;
        int counterSession = 0;
        int counterSchoolYear = 0;
        int counterStatus = 0;

        int counterOne = 0;
        int counterTwo = 0;
        int counterThree = 0;
        int counterFour = 0;
        int counterFive = 0;
        int counterSix = 0;
        
        for (Object o : obj) {
            Section aSection = (Section) o;

            columnSectionId[counterSectionId++] = aSection.getSectionId();
            columnSectionName[counterSectionName++] = aSection.getSectionName();
            columnRequiredGrade[counterRequiredGrade++] = aSection.getRequiredAverage();
            columnSession[counterSession++] = aSection.session.getSessionTitle();
            columnSchoolYear[counterSchoolYear++] = aSection.schoolYear.getYearFrom() + "-" + aSection.schoolYear.getYearTo();
            
            if (aSection.getIsActive() == 1) {
                columnStatus[counterStatus++] = true;
            } else {
                columnStatus[counterStatus++] = false;
            }

        }

        for (int row = 0; row < data.length; row++) {
            for (int column = 0; column < data[row].length; column++) {
                switch (column) {
                    case 0:
                        data[row][column] = columnSectionId[counterOne++];
                        break;
                    case 1:
                        data[row][column] = columnSectionName[counterTwo++];
                        break;
                    case 2:
                        data[row][column] = columnRequiredGrade[counterThree++];
                        break;
                    case 3:
                        data[row][column] = columnSession[counterFour++];
                        break;
                    case 4:
                        data[row][column] = columnSchoolYear[counterFive++];
                        break;
                    case 5:
                        data[row][column] = columnStatus[counterSix++];
                        break;
                }
            }
        }

        DefaultTableModel model = new DefaultTableModel(data, new Object[]{"Id","Section Name", "Required Grade", "Session", "School Year", "Status"}) {
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
                if (col < 7) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        return model;
    }
    
    
    public DefaultTableModel getAllRegisteredStudentsByGradeId(GradeLevel aGradeLevel)
    {
        Object[] obj = sdi.getAllRegisteredStudentsByGradeId(aGradeLevel).toArray();
        
        Object[] columnId = new Object[sdi.getAllRegisteredStudentsByGradeId(aGradeLevel).size()];
        Object[] columnFullName = new Object[sdi.getAllRegisteredStudentsByGradeId(aGradeLevel).size()];
        Object[] columnGradeLevel = new Object[sdi.getAllRegisteredStudentsByGradeId(aGradeLevel).size()];
        Object[][] data = new Object[sdi.getAllRegisteredStudentsByGradeId(aGradeLevel).size()][4];
        
        
        int counterId = 0;
        int counterFullName = 0;
        int counterGradeLevel = 0;
        
        int counterOne = 0;
        int counterTwo = 0;
        int counterThree = 0;
        
        for(Object o : obj)
        {
            Student student = (Student)o;
            
            columnId[counterId++] = student.getStudentId();
            columnFullName[counterFullName++] = student.getFirstName() + " " + student.getMiddleName() + " " + student.getLastName();
            columnGradeLevel[counterGradeLevel++] = student.gradeLevel.getLevel();
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
                        data[row][column] = columnFullName[counterTwo++];
                        break;
                    case 2:
                        data[row][column] = columnGradeLevel[counterThree++];
                        break;
                }
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(data, columnStudent)
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
    
    public DefaultTableModel getAllStudentsBySection(Session aSession, Section aSection, GradeLevel aGradeLevel)
    {
        Object[] obj = sectionDaoImpl.getAllStudentsBySection(aSession, aSection, aGradeLevel).toArray();
        Object[] columnId = new Object[sectionDaoImpl.getAllStudentsBySection(aSession, aSection, aGradeLevel).size()];
        Object[] columnFullName = new Object[sectionDaoImpl.getAllStudentsBySection(aSession, aSection, aGradeLevel).size()];
        Object[][] data = new Object[sectionDaoImpl.getAllStudentsBySection(aSession, aSection, aGradeLevel).size()][2];
        
        int counterId = 0;
        int counterFullName = 0;
        
        int counterOne = 0;
        int counterTwo = 0;
        
        for(Object o : obj)
        {
            Student student = (Student)o;
        
            columnId[counterId++] = student.getStudentId();
            columnFullName[counterFullName++] = student.getFirstName() + " " + student.getMiddleName() + " " + student.getLastName();
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
                        data[row][column] = columnFullName[counterTwo++];
                        break;
                }
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(data, columnStudentBySection)
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
    
    public DefaultComboBoxModel getAllSectionName()
    {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] obj = sectionDaoImpl.getAllSections().toArray();
        
        for(Object o : obj)
        {
            Section section = (Section)o;
        
            model.addElement(section.getSectionName());
        }
        
        return model;
    }
    
    public DefaultTableModel getAllNewStudentsByGradeLevelId(GradeLevel aGradeLevel)
    {
        Object[] obj = sectionDaoImpl.getAllNewStudentsByGradeLevelId(aGradeLevel).toArray();
        
        Object[] columnId = new Object[sectionDaoImpl.getAllNewStudentsByGradeLevelId(aGradeLevel).size()];
        Object[] columnStudentName = new Object[sectionDaoImpl.getAllNewStudentsByGradeLevelId(aGradeLevel).size()];
        Object[] columnGWA = new Object[sectionDaoImpl.getAllNewStudentsByGradeLevelId(aGradeLevel).size()];
        
        Object[][] data = new Object[sectionDaoImpl.getAllNewStudentsByGradeLevelId(aGradeLevel).size()][3];
        
        int counterColumnId = 0;
        int counterColumnStudentName = 0;
        int counterColumnGWA = 0;
        
        int counterOne = 0;
        int counterTwo = 0;
        int counterThree = 0;
        
        for(Object o : obj)
        {
            Section section = (Section)o;
            
            columnId[counterColumnId++] = section.student.getStudentId();
            columnStudentName[counterColumnStudentName++] = section.student.getLastName() + " " + section.student.getMiddleName() + ". " + section.student.getLastName();
            columnGWA[counterColumnGWA++] = section.grade.getGwa();
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
                        data[row][column] = columnStudentName[counterTwo++];
                        break;
                    case 2:
                        data[row][column] = columnGWA[counterThree++];
                        break;
                }
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(data, column)
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
    
    public DefaultComboBoxModel getAllSectionByGradeLevelId(GradeLevel aGradeLevel)
    {
        Object[] obj = sectionDaoImpl.getAllSectionsByGradeLevelId(aGradeLevel).toArray();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        for(Object o : obj)
        {
            Section section = (Section)o;
            
            model.addElement(section.getSectionName());
        }
        
        
        return model;
    }
    
    public DefaultTableModel getAllOldStudentsByGradeLevelId(GradeLevel aGradeLevel)
    {
        Object[] obj = sectionDaoImpl.getAllOldStudentsByGradeLevelId(aGradeLevel).toArray();
        
        Object[] columnId = new Object[sectionDaoImpl.getAllOldStudentsByGradeLevelId(aGradeLevel).size()];
        Object[] columnStudentName = new Object[sectionDaoImpl.getAllOldStudentsByGradeLevelId(aGradeLevel).size()];
        Object[] columnGWA = new Object[sectionDaoImpl.getAllOldStudentsByGradeLevelId(aGradeLevel).size()];
        
        Object[][] data = new Object[sectionDaoImpl.getAllOldStudentsByGradeLevelId(aGradeLevel).size()][3];
        
        int counterColumnId = 0;
        int counterColumnStudentName = 0;
        int counterColumnGWA = 0;
        
        int counterOne = 0;
        int counterTwo = 0;
        int counterThree = 0;
        
        for(Object o : obj)
        {
            Section section = (Section)o;
            
            columnId[counterColumnId++] = section.student.getStudentId();
            columnStudentName[counterColumnStudentName++] = section.student.getLastName() + " " + section.student.getMiddleName() + ". " + section.student.getLastName();
            columnGWA[counterColumnGWA++] = section.grade.getGwa();
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
                        data[row][column] = columnStudentName[counterTwo++];
                        break;
                    case 2:
                        data[row][column] = columnGWA[counterThree++];
                        break;
                }
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(data, column)
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
