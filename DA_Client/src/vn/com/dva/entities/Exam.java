/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Temporal;


/**
 *
 * @author VietAnh
 */
public class Exam implements Serializable {
    private Long ExamID;
    private String ExamName ;
    private Long LevelID ;
    private Long UserID ;
    private Long SubjectID ;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar DateStart ;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar DateEnd ;
    private int Times ;
    private int TotalOfTest ; // Tổng số lượt đã làm
    private int NumberOfTest; // Số lần được làm 1 người
     private int numberQuestion ; // So cau hoi 1 ky thi
    
    public Exam(){
        
    }

    public Long getUserID() {
        return UserID;
    }

    public Calendar getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(Calendar DateEnd) {
        this.DateEnd = DateEnd;
    }

    public Calendar getDateStart() {
        return DateStart;
    }

    public void setDateStart(Calendar DateStart) {
        this.DateStart = DateStart;
    }

    public void setUserID(Long UserID) {
        this.UserID = UserID;
    }
    
    public Exam( String name ,Long idLevel, Long idUser ,Long idS, Calendar dateS, Calendar dateE, int t , int n , int total, int nq){
        this.ExamName = name ;
        this.LevelID = idLevel ;
        this.UserID = idUser ;
        this.SubjectID = idS;
        this.DateStart = dateS ;
        this.DateEnd = dateE ;
        this.Times = t ;
        this.TotalOfTest = total ;
        this.NumberOfTest = n ;
        this.numberQuestion = nq ;
    }
    
    
    public Long getExamID() {
        return ExamID;
    }

    public void setExamID(Long id) {
        this.ExamID = id;
    }
    
    public String getExamName() {
        return ExamName;
    }

    public void setExamName(String s) {
        this.ExamName = s;
    }
    
    public Long getLevelID() {
        return LevelID;
    }

    public void setLevelID(Long id) {
        this.LevelID = id;
    }

    public Long getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(Long id) {
        this.SubjectID = id;
    }
    
    
    public int getTimes(){
        return Times;
    }
    public void setTimes(int i){
        this.Times = i ;
    }
     
    public int getTotalOfTest(){
        return TotalOfTest;
    }
    public void setTotalOfTest(int i){
        this.TotalOfTest = i ;
    }
    
     
    public int getNumberOfTest(){
        return NumberOfTest;
    }
    public void setNumberOfTest(int i){
        this.NumberOfTest = i ;
    }

    @Override
    public String toString() {
        return this.ExamName;
    }

    public int getNumberQuestion() {
        return numberQuestion;
    }

    public void setNumberQuestion(int numberQuestion) {
        this.numberQuestion = numberQuestion;
    }
}
