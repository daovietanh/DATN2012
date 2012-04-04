/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author VietAnh
 */
@Entity
public class Exam_Question implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long ExamQuestionID;
    private Long ExamID ;
    private Long QuestionID ;
   
    public Exam_Question(){}
    public Exam_Question(Long l1,Long l2,Long l3){
        this.ExamQuestionID  = l1 ;
        this.ExamID = l2 ;
        this.QuestionID = l3 ;
    }
    
    public Exam_Question(Long l2,Long l3){
        this.ExamID = l2 ;
        this.QuestionID = l3 ;
    }
    
    
    public Long getExamQuestionID() {
        return ExamQuestionID;
    }

    public void setExanQuestionID(Long id) {
        this.ExamQuestionID = id;
    }

    public Long getExamID() {
        return ExamID;
    }
    public void setExanID(Long id) {
        this.ExamID = id;
    }
    
    public Long getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(Long id) {
        this.QuestionID = id;
    }
}
