
package dao;

import model.student.Student;


public interface IStudent {
    Student getStudentByStudentId(int studentId);
    Student getStudentByStudentNo(int studentNo);
    boolean studentExist(int studentNo);
    boolean hasTuitionRecord(int studentNo, int schoolyearId);
}
