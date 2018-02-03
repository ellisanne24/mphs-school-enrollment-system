package model.payment;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import model.particulars.Particular;

/**
 *
 * @author Jordan
 */
public class Payment {

    private BigDecimal amountReceived;
    private BigDecimal amountCharged;
    private BigDecimal change;
    private Date dateOfPayment;
    private int orNo;
    private List<Particular> particulars;

    public BigDecimal getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(BigDecimal amountReceived) {
        this.amountReceived = amountReceived;
    }

    public BigDecimal getAmountCharged() {
        return amountCharged;
    }

    public void setAmountCharged(BigDecimal amountCharged) {
        this.amountCharged = amountCharged;
    }
    
    public List<Particular> getParticulars() {
        return particulars;
    }

    public void setParticulars(List<Particular> particulars) {
        this.particulars = particulars;
    }

    public int getOrNo() {
        return orNo;
    }

    public void setOrNo(int orNo) {
        this.orNo = orNo;
    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

}
