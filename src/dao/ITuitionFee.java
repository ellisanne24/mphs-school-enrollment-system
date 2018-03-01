
package dao;

import model.tuitionfee.Tuition;

/**
 *
 * @author John Ferdinand Antonio
 */
public interface ITuitionFee{
    boolean add(Tuition tuitionFee);
    Tuition getBy(int studentId, int schoolyearId);
    boolean pay(Tuition tuition);
    boolean payPrimary(Tuition tuition);
    boolean paySummerFees(Tuition tuitionFee);
    int getBalanceBreakDownId(String balancebreakdownName, int studentId, int schoolyearId);
}
