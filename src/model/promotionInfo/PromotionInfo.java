/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.promotionInfo;

import java.util.Date;
import model.schoolyear.SchoolYear;
import model.user.User;

/**
 *
 * @author Jordan
 */
public class PromotionInfo {
    private int studentId;
    private int promotionGradeLevelFrom;
    private int promotionGradeLevelTo;
    private SchoolYear schoolYearPromoted;
    private Date datePromoted;
    private User promotedByUser;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getPromotionGradeLevelFrom() {
        return promotionGradeLevelFrom;
    }

    public void setPromotionGradeLevelFrom(int promotionGradeLevelFrom) {
        this.promotionGradeLevelFrom = promotionGradeLevelFrom;
    }

    public int getPromotionGradeLevelTo() {
        return promotionGradeLevelTo;
    }

    public void setPromotionGradeLevelTo(int promotionGradeLevelTo) {
        this.promotionGradeLevelTo = promotionGradeLevelTo;
    }

    public SchoolYear getSchoolYearPromoted() {
        return schoolYearPromoted;
    }

    public void setSchoolYearPromoted(SchoolYear schoolYearPromoted) {
        this.schoolYearPromoted = schoolYearPromoted;
    }

    public Date getDatePromoted() {
        return datePromoted;
    }

    public void setDatePromoted(Date datePromoted) {
        this.datePromoted = datePromoted;
    }

    public User getPromotedByUser() {
        return promotedByUser;
    }

    public void setPromotedByUser(User promotedByUser) {
        this.promotedByUser = promotedByUser;
    }
    
    
}
