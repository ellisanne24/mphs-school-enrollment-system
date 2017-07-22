/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.holiday.Holiday;

/**
 *
 * @author John Ferdinand Antonio
 */
public interface IHoliday {
    boolean add(Holiday holiday);
    boolean update(Holiday holiday);
    List<Holiday> get();
    int getId(String holidayName);
}
