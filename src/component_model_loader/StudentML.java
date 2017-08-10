package component_model_loader;

import daoimpl.GradeLevelDaoImpl;
import daoimpl.StudentDaoImpl;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.gradelevel.GradeLevel;
import model.student.Student;

public class StudentML {

    StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
    GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();

    public DefaultTableModel getAllStudentByKeyword(JTable aJtable, String aKeyword) {
        DefaultTableModel aJtableModel = (DefaultTableModel) aJtable.getModel();
        aJtableModel.setRowCount(0);
        Object[] studentList = studentDaoImpl.get(aKeyword).toArray();

        String[] columnNames = {
            "Student ID",
            "Registration ID",
            "Student Type",
            "Last Name",
            "First Name",
            "Middle Name",
            "Status",
            "Graduated",
            "Admission",
            "Current"
        };
        DefaultTableModel jTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTableModel.setColumnIdentifiers(columnNames);

        for (Object o : studentList) {
            Student s = (Student) o;
            Object[] rowData = {
                s.getStudentId(),
                s.getRegistration().getRegistrationId(),
                s.getStudentType() == 0 ? "Old" : "New",
                s.getRegistration().getLastName(),
                s.getRegistration().getFirstName(),
                s.getRegistration().getMiddleName(),
                s.isActive() == true ? "Active" : "Inactive",
                s.getIsGraduated() == true ? "Yes" : "No",
                s.getAdmission().getGradeLevel() == 0 ? "Kindergarten" : "Grade " + s.getAdmission().getGradeLevel(),
                s.getCurrentGradeLevel().getLevel() == 0 ? "Kindergarten" : "Grade" + s.getCurrentGradeLevel().getLevel()
            };
            jTableModel.addRow(rowData);
        }
        return jTableModel;
    }

    public DefaultTableModel getAllStudents(JTable table) {
        DefaultTableModel aJtableModel = (DefaultTableModel) table.getModel();
        aJtableModel.setRowCount(0);
        Object[] studentList = studentDaoImpl.get().toArray();

        String[] columnNames = {
            "Student ID",
            "Registration ID",
            "Student Type",
            "Last Name",
            "First Name",
            "Middle Name",
            "Status",
            "Graduated",
            "Admission",
            "Current"
        };
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableModel.setColumnIdentifiers(columnNames);

        for (Object o : studentList) {
            Student s = (Student) o;
            Object[] rowData = {
                s.getStudentId(),
                s.getRegistration().getRegistrationId(),
                s.getStudentType() == 0 ? "Old" : "New",
                s.getRegistration().getLastName(),
                s.getRegistration().getFirstName(),
                s.getRegistration().getMiddleName(),
                s.isActive() == true ? "Active" : "Inactive",
                s.getIsGraduated() == true ? "Yes" : "No",
                s.getAdmission().getGradeLevel() == 0 ? "Kindergarten" : "Grade " + s.getAdmission().getGradeLevel(),
                s.getCurrentGradeLevel().getLevel() == 0 ? "Kindergarten" : "Grade" + s.getCurrentGradeLevel().getLevel()
            };
            tableModel.addRow(rowData);
        }
        return tableModel;
    }

    public DefaultTableModel getAllInactiveStudents(JTable aJtable) {
        DefaultTableModel aJtableModel = (DefaultTableModel) aJtable.getModel();
        aJtableModel.setRowCount(0);
        Object[] studentList = studentDaoImpl.getInactive().toArray();

        String[] columnNames = {
            "Student ID",
            "Registration ID",
            "Student Type",
            "Last Name",
            "First Name",
            "Middle Name",
            "Status",
            "Graduated",
            "Admission",
            "Current"
        };
        DefaultTableModel jTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTableModel.setColumnIdentifiers(columnNames);

        for (Object o : studentList) {
            Student s = (Student) o;

            Object[] rowData = {
                s.getStudentId(),
                s.getRegistration().getRegistrationId(),
                s.getStudentType() == 0 ? "Old" : "New",
                s.getRegistration().getLastName(),
                s.getRegistration().getFirstName(),
                s.getRegistration().getMiddleName(),
                s.isActive() == true ? "Active" : "Inactive",
                s.getIsGraduated() == true ? "Yes" : "No",
                s.getAdmission().getGradeLevel() == 0 ? "Kindergarten" : "Grade " + s.getAdmission().getGradeLevel(),
                s.getCurrentGradeLevel().getLevel() == 0 ? "Kindergarten" : "Grade" + s.getCurrentGradeLevel().getLevel()
            };
            jTableModel.addRow(rowData);
        }
        return jTableModel;
    }

    public DefaultTableModel getAllActiveStudentsOfCurrentSchoolYear(JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        Object[] studentList = studentDaoImpl.getActiveOfCurrentSchoolYear().toArray();

        String[] columnNames = {
            "Student ID",
            "Registration ID",
            "Student Type",
            "Last Name",
            "First Name",
            "Middle Name",
            "Status",
            "Graduated",
            "Admission",
            "Current"
        };
        DefaultTableModel jTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTableModel.setColumnIdentifiers(columnNames);

        for (Object o : studentList) {
            Student s = (Student) o;
            Object[] rowData = {
                s.getStudentId(),
                s.getRegistration().getRegistrationId(),
                s.getStudentType() == 0 ? "Old" : "New",
                s.getRegistration().getLastName(),
                s.getRegistration().getFirstName(),
                s.getRegistration().getMiddleName(),
                s.isActive() == true ? "Active" : "Inactive",
                s.getIsGraduated() == true ? "Yes" : "No",
                s.getAdmission().getGradeLevel() == 0 ? "Kindergarten" : "Grade " + s.getAdmission().getGradeLevel(),
                s.getCurrentGradeLevel().getLevel() == 0 ? "Kindergarten" : "Grade" + s.getCurrentGradeLevel().getLevel()
            };
            jTableModel.addRow(rowData);
        }
        return jTableModel;
    }

    public DefaultComboBoxModel getStudentNameByGradeLevelId(GradeLevel aGradeLevel) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] obj = gldi.getStudentNameByGradeLevelId(aGradeLevel).toArray();
        for (Object o : obj) {
            Student student = (Student) o;
            model.addElement(student.getFirstName() + " " + student.getMiddleName() + ", " + student.getLastName());
        }
        return model;
    }
    
    public DefaultListModel getAllStudent() {
        DefaultListModel model = new DefaultListModel();
        Object[] obj = studentDaoImpl.getAllStudent().toArray();
        for (Object o : obj) {
            Student student = (Student) o;
            model.addElement("(" + student.getStudentId() + ") " + student.getFirstName() + " " + student.getMiddleName() + ". " + student.getLastName());
        }
        return model;
    }

}
