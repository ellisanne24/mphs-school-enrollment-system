/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.specialization.Specialization;

/**
 *
 * @author John Ferdinand Antonio
 */
public interface ISpecialization {
    boolean add(Specialization specialization);
    List<Specialization> getAll();
    Specialization getById(int specializationId);
    boolean update(Specialization specialization);
    int getId(String specializationName);
}
