
package dao;

import model.student.Student;


public interface IStudent {
    
    Student getStudentByStudentNo(int studentNo);
    
    boolean studentExist(int studentNo);
}
