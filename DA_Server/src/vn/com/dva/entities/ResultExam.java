/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author VietAnh
 */
@Entity
public class ResultExam implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long ExamID ;
    private Long UserID ;
    private double Score ;    
    private int times ;         // Thoi gian da lam trong tong so thoi gian
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar DateTest ; // Ngay lam
    private String comments ;   // Comment moi cau
    private int star ;

    public ResultExam() {
    }

    public ResultExam(Long ExamID, Long UserID, double Score, int times, Calendar DateTest, String comments, int star) {
        this.ExamID = ExamID;
        this.UserID = UserID;
        this.Score = Score;
        this.times = times;
        this.DateTest = DateTest;
        this.comments = comments;
        this.star = star;
    }

    
    public Calendar getDateTest() {
        return DateTest;
    }

    public void setDateTest(Calendar DateTest) {
        this.DateTest = DateTest;
    }

    public Long getExamID() {
        return ExamID;
    }

    public void setExamID(Long ExamID) {
        this.ExamID = ExamID;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double Score) {
        this.Score = Score;
    }

    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long UserID) {
        this.UserID = UserID;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
    
    
    
    @Override
    public String toString() {
        return "id=" + id ;
    }
    
}
