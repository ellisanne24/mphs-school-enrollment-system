
package model.balancebreakdownfee;

import java.math.BigDecimal;
import java.util.Date;

public class BalanceBreakDownFee {

    private int id;
    private String name; //name of breakdown e.g. Academic Fee for Quarter 1, Academic Fee for Quarter2
    private String category;
    private Date dateAssigned;
    private BigDecimal amount;
    private BigDecimal balance;
    private double totalPaid;
    private boolean isPaid;
    private boolean isPastDueDate;
    private boolean hasPenalty;
    private Date deadline;

    public boolean hasPenalty() {
        return hasPenalty;
    }

    public void setHasPenalty(boolean hasPenalty) {
        this.hasPenalty = hasPenalty;
    }
    
    public boolean getIsPastDueDate() {
        return isPastDueDate;
    }

    public void setIsPastDueDate(boolean isPastDueDate) {
        this.isPastDueDate = isPastDueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateAssigned() {
        return dateAssigned;
    }

    public void setDateAssigned(Date dateAssigned) {
        this.dateAssigned = dateAssigned;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
