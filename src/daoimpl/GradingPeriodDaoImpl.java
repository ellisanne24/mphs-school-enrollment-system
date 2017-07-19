/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.IGradingPeriod;
import java.util.List;
import model.GradingPeriod;

/**
 *
 * @author John Ferdinand Antonio
 */
public class GradingPeriodDaoImpl implements IGradingPeriod{

    @Override
    public GradingPeriod get(int gradingPeriodId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    /**
     * <b><code>get()</code></b>  method returns a list of <b>ALL</b> <code> GradingPeriod </code>
     * record from the database;
     */
    public List<GradingPeriod> get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    /**
     * <b>getId()</b> method returns the <code>GradingPeriod</code> <b>id</b>
     * <b><code>id</code></b> that it returns will represent the database column <b><code>gradingperiod_id</code></b>
     * of database table named <b><code>gradingperiod_mt</code></b>
     */
    public int getId(int gradingPeriod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
