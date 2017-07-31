/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.assignedfees;

import java.util.Date;
import model.schoolfees.SchoolFees;

/**
 *
 * @author John Ferdinand Antonio
 */
public class AssignedFees extends SchoolFees{
    private Date dateAssigned;

    public Date getDateAssigned() {
        return dateAssigned;
    }

    public void setDateAssigned(Date dateAssigned) {
        this.dateAssigned = dateAssigned;
    }
    
    
}
