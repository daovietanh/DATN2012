/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.entities;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author VietAnh
 */
public class DetailResultExam implements Serializable {
    private Long id;
    private Long ResultExamID ;         // Ket qua ky thi
    private List<Long> listIdQuestion ; 
    private List<String> listIdAnswer ;
    private List<String> listAnswerRandom ;

    public Long getResultExamID() {
        return ResultExamID;
    }

    public void setResultExamID(Long ResultExamID) {
        this.ResultExamID = ResultExamID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getListAnswerRandom() {
        return listAnswerRandom;
    }

    public void setListAnswerRandom(List<String> listAnswerRandom) {
        this.listAnswerRandom = listAnswerRandom;
    }

    public List<String> getListIdAnswer() {
        return listIdAnswer;
    }

    public void setListIdAnswer(List<String> listIdAnswer) {
        this.listIdAnswer = listIdAnswer;
    }

    public List<Long> getListIdQuestion() {
        return listIdQuestion;
    }

    public void setListIdQuestion(List<Long> listIdQuestion) {
        this.listIdQuestion = listIdQuestion;
    }
    
   
    @Override
    public String toString() {
        return "id=" + id ;
    }
    
}
