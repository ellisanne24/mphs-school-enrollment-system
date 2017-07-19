/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.GradingPeriod;

/**
 *
 * @author John Ferdinand Antonio
 */
public interface IGradingPeriod {
    GradingPeriod get(int gradingPeriodId);
    List<GradingPeriod> get();
    int getId(int gradingPeriod);
}
