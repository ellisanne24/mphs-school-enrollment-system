
package dao;

import model.tuitionfee.Tuition;

/**
 *
 * @author John Ferdinand Antonio
 */
public interface ITuitionFee{
    boolean add(Tuition tuitionFee);
    Tuition get(int studentId, int schoolyearId);
    boolean pay(Tuition tuitionFee);
    int getBalanceBreakDownId(String balancebreakdownName, int studentId, int schoolyearId);
}
