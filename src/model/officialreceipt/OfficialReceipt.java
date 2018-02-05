
package model.officialreceipt;

import java.util.Date;

/**
 *
 * @author Jordan
 */
public class OfficialReceipt {
    private int id;
    private int orNo;
    private boolean isUsed;
    private Date dateGenerated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrNo() {
        return orNo;
    }

    public void setOrNo(int orNo) {
        this.orNo = orNo;
    }

    public boolean isIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public Date getDateGenerated() {
        return dateGenerated;
    }

    public void setDateGenerated(Date dateGenerated) {
        this.dateGenerated = dateGenerated;
    }
    
    
}
