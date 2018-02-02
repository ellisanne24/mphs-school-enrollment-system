/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.student.Student;
import model.tuitionfee.Tuition;

/**
 *
 * @author John Ferdinand Antonio
 */
public interface ITuitionFee{
    boolean add(Tuition tuitionFee);
    Tuition get(int studentId, int schoolyearId);
    boolean pay(Tuition tuitionFee);
}
