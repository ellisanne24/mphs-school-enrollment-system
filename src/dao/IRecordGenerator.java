/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.registration.Registration;

/**
 *
 * @author John Ferdinand Antonio
 */
public interface IRecordGenerator {
    boolean generateStudent(Registration registration);
}