/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.schoolyear.SchoolYear;
import model.quarter.Quarter;

/**
 *
 * @author Acer
 */
public interface IQuarter {
    List<Quarter> getAllQuarters();
    List<Quarter> getQuarterBySchoolYear(SchoolYear aSchoolYear);
    boolean addQuarter(Quarter aQuarter);
}
