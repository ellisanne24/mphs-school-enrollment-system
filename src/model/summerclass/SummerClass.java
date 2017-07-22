/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.summerclass;

import model.summerclassschedule.SummerClassSchedule;
import java.util.List;
import model.student.Student;

/**
 *
 * @author John Ferdinand Antonio
 */
public class SummerClass {
    // A SummerClass has a List of student records
    // A SummerClass has a SummerClassSchedule
    
    private SummerClassSchedule summerClassSchedule;
    private List<Student> students;

    public SummerClassSchedule getSummerClassSchedule() {
        return summerClassSchedule;
    }

    public void setSummerClassSchedule(SummerClassSchedule summerClassSchedule) {
        this.summerClassSchedule = summerClassSchedule;
    }
    
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
