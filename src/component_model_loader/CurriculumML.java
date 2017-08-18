package component_model_loader;

import daoimpl.CurriculumDaoImpl;
import daoimpl.SubjectDaoImpl;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.curriculum.Curriculum;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.subject.Subject;

/**
 *
 * @author francisunoxx
 */
public class CurriculumML {

    CurriculumDaoImpl cdi = new CurriculumDaoImpl();
    SubjectDaoImpl sdi = new SubjectDaoImpl();

    private Object[] columnNames() {
        return new Object[]{"Code", "Subject Name", "Subject Hours", "Description", "Grade Level"};
    }

    private Object[] column() {
        return new Object[]{"Id", "Code", "Subject Name", "Grade Level"};
    }

    private Object[] headerForUpdate() {
        return new Object[]{"Id", "Code", "Subject Name", "Subject Hours", "Grade Level"};
    }

    private Object[] curriculumColumnNames() {
        return new Object[]{"Id", "Curriculum Name", "School Year", "Description", "Date Created", "Status"};
    }

    public DefaultTableModel getAllSubjectsWithGradeLevel() {
        List<Subject> list = cdi.getAllSubjectForCurriculum();
        Object[] columnObject = list.toArray();
        Object[] columnCode = new Object[list.size()];
        Object[] columnTitle = new Object[list.size()];
        Object[] columnDescription = new Object[list.size()];
        Object[] columnYearLevel = new Object[list.size()];
        Object[][] obj = new Object[list.size()][4];
        int counterCode = 0;
        int counterTitle = 0;
        int counterDescription = 0;
        int counterYearLevel = 0;
        int counterOne = 0;
        int counterTwo = 0;
        int counterThree = 0;
        int counterFour = 0;

        for (Object a : columnObject) {
            Subject aSubject = (Subject) a;
            columnCode[counterCode++] = aSubject.getSubjectCode();
            columnTitle[counterTitle++] = aSubject.getSubjectTitle();
            columnDescription[counterDescription++] = aSubject.getSubjectDescription();
            columnYearLevel[counterYearLevel++] = aSubject.gradeLevel.getLevel();
        }

        for (int row = 0; row < obj.length; row++) {                               //Sub-array
            for (int column = 0; column < obj[row].length; column++) {
                if (column == 0) {
                    obj[row][column] = columnCode[counterOne++];
                } else if (column == 1) {
                    obj[row][column] = columnTitle[counterTwo++];
                } else if (column == 2) {
                    obj[row][column] = columnDescription[counterThree++];
                } else {
                    obj[row][column] = columnYearLevel[counterFour++];
                }
            }
        }

        DefaultTableModel dtm = new DefaultTableModel(obj, columnNames()) {
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
        ;
        };
        return dtm;
    }

    public DefaultTableModel getEachSubjectsByGradeLevelId(GradeLevel aGradeLevel) {
        List<Subject> list = sdi.getEachSubjectByGradeLevelId(aGradeLevel);
        Object[] columnObject = list.toArray();
        Object[] columnId = new Object[list.size()];
        Object[] columnCode = new Object[list.size()];
        Object[] columnTitle = new Object[list.size()];
        Object[] columnYearLevel = new Object[list.size()];
        Object[][] obj = new Object[list.size()][4];
        
        int counterId = 0;
        int counterCode = 0;
        int counterTitle = 0;
        int counterYearLevel = 0;
        
        int counterOne = 0;
        int counterTwo = 0;
        int counterThree = 0;
        int counterFour = 0;

        for (Object a : columnObject) {
            Subject aSubject = (Subject) a;
            
            columnId[counterId++] = aSubject.getSubjectId();
            columnCode[counterCode++] = aSubject.getSubjectCode();
            columnTitle[counterTitle++] = aSubject.getSubjectTitle();
            columnYearLevel[counterYearLevel++] = aSubject.gradeLevel.getLevel()==0? "Kindergarten":aSubject.gradeLevel.getLevel();
        }

        for (int row = 0; row < obj.length; row++) {                               //Sub-array
            for (int column = 0; column < obj[row].length; column++) {
                if(column == 0)
                {
                    obj[row][column] = columnId[counterOne++];
                }
                else if (column == 1) {
                    obj[row][column] = columnCode[counterTwo++];
                } else if (column == 2) {
                    obj[row][column] = columnTitle[counterThree++];
                } else {
                    obj[row][column] = columnYearLevel[counterFour++];
                }
            }
        }

        DefaultTableModel dtm = new DefaultTableModel(obj, column()) {
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
        ;
        };
        return dtm;
    }

    public DefaultTableModel getAllCurriculum() {
        List<Curriculum> list = cdi.getAllCurriculum();

        Object[] columnObject = list.toArray();

        Integer[] columnId = new Integer[list.size()];
        Object[] columnTitle = new Object[list.size()];
        Object[] columnSchoolYear = new Object[list.size()];
        Object[] columnDescription = new Object[list.size()];
        Object[] columnDateCreated = new Object[list.size()];
        Boolean[] columnStatus = new Boolean[list.size()];

        Object[][] obj = new Object[list.size()][6];

        int counterId = 0;
        int counterColumnTitle = 0;
        int counterSchoolYear = 0;
        int counterDescription = 0;
        int counterDateCreated = 0;
        int counterStatus = 0;
        
        int counterOne = 0;
        int counterTwo = 0;
        int counterThree = 0;
        int counterFour = 0;
        int counterFive = 0;
        int counterSix = 0;

        for (Object a : columnObject) {
            Curriculum curriculum = (Curriculum) a;

            columnId[counterId++] = curriculum.getCurriculumId();
            columnTitle[counterColumnTitle++] = curriculum.getCurriculumTitle();
            columnSchoolYear[counterSchoolYear++] = curriculum.schoolYear.getYearFrom() + " - " + curriculum.schoolYear.getYearTo();
            columnDescription[counterDescription++] = curriculum.getCurriculumDescription();
            columnDateCreated[counterDateCreated++] = curriculum.getDateCreated();

            if (curriculum.getIsActive() == 1) {
                columnStatus[counterStatus++] = true;
            } else {
                columnStatus[counterStatus++] = false;
            }
        }

        for (int row = 0; row < obj.length; row++) {
            for (int column = 0; column < obj[row].length; column++) {
                switch (column) {
                    case 0:
                        obj[row][column] = columnId[counterOne++];
                        break;
                    case 1:
                        obj[row][column] = columnTitle[counterTwo++];
                        break;
                    case 2:
                        obj[row][column] = columnSchoolYear[counterThree++];
                        break;
                    case 3:
                        obj[row][column] = columnDescription[counterFour++];
                        break;
                    case 4:
                        obj[row][column] = columnDateCreated[counterFive++];
                        break;
                    default:
                        obj[row][column] = columnStatus[counterSix++];
                        break;
                }
            }
        }

        DefaultTableModel dtm = new DefaultTableModel(obj, curriculumColumnNames()) {
            @Override
            public Class getColumnClass(int c) {
                //If column has null
                Object value = this.getValueAt(0,c);
                return (value==null?Object.class:value.getClass());
            }

            @Override
            public boolean isCellEditable(int row, int col) {
                //Note that the data/cell address is constant,
                //no matter where the cell appears onscreen.
                if (col < 6) {
                    return false;
                } else {
                    return true;
                }

            }
        };
        return dtm;
    }

    public DefaultTableModel getEachCurriculum(Curriculum aCurriculum, SchoolYear aSchoolYear) {
        List<Curriculum> list = cdi.getEachCurriculum(aCurriculum, aSchoolYear);
        Object[] columnObject = list.toArray();
        Object[] columnSchoolYear = new Object[list.size()];
        Object[] columnGradeLevel = new Object[list.size()];
        Object[] columnDescription = new Object[list.size()];
        Object[] columnDateCreated = new Object[list.size()];
        Object[][] obj = new Object[list.size()][4];

        int counterSchoolYear = 0;
        int counterGradeLevel = 0;
        int counterDescription = 0;
        int counterDateCreated = 0;
        int counterOne = 0;
        int counterTwo = 0;
        int counterThree = 0;
        int counterFour = 0;

        for (Object a : columnObject) {
            Curriculum curriculum = (Curriculum) a;
            columnSchoolYear[counterSchoolYear++] = curriculum.schoolYear.getYearFrom() + " - " + curriculum.schoolYear.getYearTo();
            columnGradeLevel[counterGradeLevel++] = curriculum.gradeLevel.getLevel();
            columnDescription[counterDescription++] = curriculum.getCurriculumDescription();
            columnDateCreated[counterDateCreated++] = curriculum.getDateCreated();
        }

        for (int row = 0; row < obj.length; row++) {
            for (int column = 0; column < obj[row].length; column++) {
                if (column == 0) {
                    obj[row][column] = columnSchoolYear[counterOne++];
                } else if (column == 1) {
                    obj[row][column] = columnGradeLevel[counterTwo++];
                } else if (column == 2) {
                    obj[row][column] = columnDescription[counterThree++];
                } else {
                    obj[row][column] = columnDateCreated[counterFour++];
                }
            }
        }

        DefaultTableModel dtm = new DefaultTableModel(obj, curriculumColumnNames()) {
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
        ;
        };
        return dtm;
    }

    public DefaultComboBoxModel getCurriculumSchoolYearStart(GradeLevel aGradeLevel) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] object = cdi.getCurriculumYearStartEndByGradeLevel(aGradeLevel).toArray();
        for (Object o : object) {
            SchoolYear schoolYear = (SchoolYear) o;

            model.addElement(schoolYear.getYearFrom());
        }
        return model;
    }

    public DefaultComboBoxModel getCurriculumSchoolYearEnd(GradeLevel aGradeLevel) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        Object[] object = cdi.getCurriculumYearStartEndByGradeLevel(aGradeLevel).toArray();

        for (Object o : object) {
            SchoolYear schoolYear = (SchoolYear) o;

            model.addElement(schoolYear.getYearTo());
        }

        return model;
    }

    public DefaultComboBoxModel getAllCurriculumByStartYear(SchoolYear aSchoolYear) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        Object[] object = cdi.getAllCurriculumByStartYear(aSchoolYear).toArray();

        for (Object o : object) {
            Curriculum curriculum = (Curriculum) o;

            model.addElement(curriculum.getCurriculumTitle());
        }

        return model;
    }

    public DefaultTableModel getAllSubjectsOfCurriculumByName(Curriculum aCurriculum) {
        Object[] object = cdi.getAllSubjectsOfCurriculumByName(aCurriculum).toArray();
        Object[] columnCode = new Object[cdi.getAllSubjectsOfCurriculumByName(aCurriculum).size()];
        Object[] columnTitle = new Object[cdi.getAllSubjectsOfCurriculumByName(aCurriculum).size()];
        Object[] columnHours = new Object[cdi.getAllSubjectsOfCurriculumByName(aCurriculum).size()];
        Object[] columnDescription = new Object[cdi.getAllSubjectsOfCurriculumByName(aCurriculum).size()];
        Object[] columnYearLevel = new Object[cdi.getAllSubjectsOfCurriculumByName(aCurriculum).size()];
        Object[][] data = new Object[cdi.getAllSubjectsOfCurriculumByName(aCurriculum).size()][3];

        int counterCode = 0;
        int counterTitle = 0;
        int counterHours = 0;
        int counterDescription = 0;
        int counterYearLevel = 0;

        int counterColumnOne = 0;
        int counterColumnTwo = 0;
        int counterColumnThree = 0;
        int counterColumnFour = 0;
        int counterColumnFive = 0;

        for (Object o : object) {
            Curriculum curriculum = (Curriculum) o;

            //Filling corresponding array
            //While looping counter increment also
            columnCode[counterColumnOne++] = curriculum.s.getSubjectCode();
            columnTitle[counterColumnTwo++] = curriculum.s.getSubjectTitle();
            columnHours[counterColumnThree++] = curriculum.s.getSubjectHours();
            columnDescription[counterColumnFour++] = curriculum.s.getSubjectDescription();
            columnYearLevel[counterColumnFive++] = curriculum.gradeLevel.getLevel();
        }

        //Looping through data[][] size
        for (int row = 0; row < data.length; row++) {
            for (int column = 0; column < data[row].length; column++) {
                //Filling data[][] array while looping through specified 1d array
                if (column == 0) {
                    data[row][column] = columnCode[counterCode++];
                } else if (column == 1) {
                    data[row][column] = columnTitle[counterTitle++];
                } else if (column == 2) {
                    data[row][column] = columnHours[counterHours++];
                } else if (column == 3) {
                    data[row][column] = columnDescription[counterDescription++];
                } else {
                    data[row][column] = columnYearLevel[counterYearLevel++];
                }
            }
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames()) {
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
        ;
        };
        
        return model;
    }

    public DefaultTableModel getCreatedCurriculumById(Curriculum aCurriculum) {
        Object[] object = cdi.getCreatedCurriculumById(aCurriculum).toArray();

        Object[] columnId = new Object[cdi.getCreatedCurriculumById(aCurriculum).size()];
        Object[] columnCode = new Object[cdi.getCreatedCurriculumById(aCurriculum).size()];
        Object[] columnSubject = new Object[cdi.getCreatedCurriculumById(aCurriculum).size()];
        Object[] columnHours = new Object[cdi.getCreatedCurriculumById(aCurriculum).size()];
        Object[] columnGradeLevel = new Object[cdi.getCreatedCurriculumById(aCurriculum).size()];
        
        Object[][] data = new Object[cdi.getCreatedCurriculumById(aCurriculum).size()][5];
        
        int counterId = 0;
        int counterCode = 0;
        int counterSubject = 0;
        int counterHours = 0;
        int counterGradeLevel = 0;
        
        int counterOne = 0;
        int counterTwo = 0;
        int counterThree = 0;
        int counterFour = 0;
        int counterFive = 0;
        
        for (Object o : object) {
            Curriculum curriculum = (Curriculum) o;
            
            columnId[counterOne++] = curriculum.s.getSubjectId();
            columnCode[counterTwo++] = curriculum.s.getSubjectCode();
            columnSubject[counterThree++] = curriculum.s.getSubjectTitle();
            columnHours[counterFour++] = curriculum.s.getSubjectHours();
            
            columnGradeLevel[counterFive++] = curriculum.gradeLevel.getLevel() == 0 ? "Kindergarten": curriculum.gradeLevel.getLevel();
        }

        for (int row = 0; row < data.length; row++) {
            for (int column = 0; column < data[row].length; column++) {
                switch (column) {
                    case 0:
                        data[row][column] = columnId[counterId++];
                        break;
                    case 1:
                        data[row][column] = columnCode[counterCode++];
                        break;
                    case 2:
                        data[row][column] = columnSubject[counterSubject++];
                        break;
                    case 3:
                        data[row][column] = columnHours[counterHours++];
                        break;
                    case 4:
                        data[row][column] = columnGradeLevel[counterGradeLevel++];
                        break;
                        
                }
            }
        }

        DefaultTableModel model = new DefaultTableModel(data, headerForUpdate());

        return model;
    }

    public DefaultTableModel getAllCreatedCurriculumInfo() {
        Object[] object = cdi.getAllCreatedCurriculumInfo().toArray();

        Object[] columnId = new Object[cdi.getAllCreatedCurriculumInfo().size()];
        Object[] columnCode = new Object[cdi.getAllCreatedCurriculumInfo().size()];
        Object[] columnSubjectTitle = new Object[cdi.getAllCreatedCurriculumInfo().size()];
        Object[] columnSchoolYear = new Object[cdi.getAllCreatedCurriculumInfo().size()];

        Object[][] data = new Object[cdi.getAllCreatedCurriculumInfo().size()][4];

        int counterId = 0;
        int counterCode = 0;
        int counterSubjectTitle = 0;
        int counterSchoolYear = 0;

        int columnIdCounter = 0;
        int columnCodeCounter = 0;
        int columnSubjectTitleCounter = 0;
        int columnSchoolYearCounter = 0;

        for (Object o : object) {
            Curriculum curriculum = (Curriculum) o;

            columnId[counterId++] = curriculum.getCurriculumId();
            columnCode[counterCode++] = curriculum.s.getSubjectCode();
            columnSubjectTitle[counterSubjectTitle++] = curriculum.s.getSubjectTitle();
            columnSchoolYear[counterSchoolYear++] = curriculum.schoolYear.getYearFrom() + "-" + curriculum.schoolYear.getYearTo();
        }

        for (int row = 0; row < data.length; row++) {
            for (int column = 0; column < data[row].length; column++) {
                switch (column) {
                    case 0:
                        data[row][column] = columnId[columnIdCounter++];
                        break;
                    case 1:
                        data[row][column] = columnCode[columnCodeCounter++];
                        break;
                    case 2:
                        data[row][column] = columnSubjectTitle[columnSubjectTitleCounter++];
                        break;
                    default:
                        data[row][column] = columnSchoolYear[columnSchoolYearCounter++];
                        break;
                }
            }
        }

        DefaultTableModel model = new DefaultTableModel(data, headerForUpdate());

        return model;
    }

    public DefaultComboBoxModel getAllCurriculumNameByGradeLevel(GradeLevel aGradeLevel) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] object = cdi.getAllCurriculumNameByGradeLevel(aGradeLevel).toArray();
        for (Object o : object) {
            Curriculum curriculum = (Curriculum) o;

            model.addElement(curriculum.getCurriculumTitle());
        }
        return model;
    }

}
