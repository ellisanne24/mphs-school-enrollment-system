
package dao;

/**
 *
 * @author Jordan
 */
public interface IOrNo {
    String getNextAvailableOrNoForPaymentBySchoolYearId(int schoolyearId);
    int getIdByOrNo(int orNo);
    boolean markOrNoAsUsed(int orNo);
}
