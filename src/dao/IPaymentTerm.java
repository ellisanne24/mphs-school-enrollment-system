/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.paymentterm.PaymentTerm;
import model.paymentterm.PaymentTermPenalty;
import model.period.Period;
import model.schoolyear.SchoolYear;

/**
 *
 * @author Acer
 */
public interface IPaymentTerm {
    List<Period> getPeriodsByPaymentTermId(int paymentTermId, int schoolYearId);
    List<PaymentTerm> getAll();
    List<PaymentTerm> getAllActive();
    List<PaymentTerm> getAllInactive();
    PaymentTerm getById(int aPaymentTermId);
    PaymentTerm getById(int aPaymentTermId, int schoolYearId);
    int getId(String aPaymentTerm);
    boolean add(PaymentTerm aPaymentTerm);
    boolean addPaymentDeadline(List<PaymentTerm> paymentTerms);
    boolean addPaymentTermPenalty(List<PaymentTerm> paymentTerms);
   
    List<SchoolYear> getSchoolYearsWithPenalty();
    List<PaymentTermPenalty> getPenaltyInformationBySchoolYearId(int schoolYearId);
}
