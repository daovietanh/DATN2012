/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.entities;

import java.io.Serializable;

/**
 *
 * @author VietAnh
 */

public class Train implements Serializable {
    private Long TrainID;
    private Long SubjectID ;
    private Long LevelID ;
    private Long UserID ;
    private int TotalQuestion ;
    private int Times ;
    private double Score ;
    private String Date_Train ;

    public Train() {
    }

    
    
    public String getDate_Train() {
        return Date_Train;
    }

    public void setDate_Train(String Date_Train) {
        this.Date_Train = Date_Train;
    }

    public Long getLevelID() {
        return LevelID;
    }

    public void setLevelID(Long LevelID) {
        this.LevelID = LevelID;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double Score) {
        this.Score = Score;
    }

    public Long getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(Long SubjectID) {
        this.SubjectID = SubjectID;
    }

    public int getTimes() {
        return Times;
    }

    public void setTimes(int Times) {
        this.Times = Times;
    }

    public int getTotalQuestion() {
        return TotalQuestion;
    }

    public void setTotalQuestion(int TotalQuestion) {
        this.TotalQuestion = TotalQuestion;
    }

    public Long getTrainID() {
        return TrainID;
    }

    public void setTrainID(Long TrainID) {
        this.TrainID = TrainID;
    }

    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long UserID) {
        this.UserID = UserID;
    }

    public Train(Long SubjectID, Long LevelID, Long UserID, int TotalQuestion, int Times, double Score, String Date_Train) {
        this.SubjectID = SubjectID;
        this.LevelID = LevelID;
        this.UserID = UserID;
        this.TotalQuestion = TotalQuestion;
        this.Times = Times;
        this.Score = Score;
        this.Date_Train = Date_Train;
    }

    

    @Override
    public String toString() {
        return TrainID+"";
    }
    
    
}
