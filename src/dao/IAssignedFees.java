/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.assignedfees.AssignedFees;
import model.basicfee.BasicFee;
import model.downpayment.DownPaymentFee;
import model.miscellaneousfees.MiscellaneousFees;
import model.otherfees.OtherFees;

/**
 *
 * @author John Ferdinand Antonio
 */
public interface IAssignedFees {
    AssignedFees get(int aStudentId, int aSchoolYearId);
    MiscellaneousFees getAssignedMiscellaneous(int aStudentId, int aSchoolYearId);
    DownPaymentFee getAssignedDownPayment(int aStudentId, int aSchoolYearId);
    OtherFees getAssignedOther(int aStudentId, int aSchoolYearId);
    BasicFee getAssignedBasic(int aStudentId, int aSchoolYearId);
    boolean remove(int aStudentId, int aSchoolYearId);
}
