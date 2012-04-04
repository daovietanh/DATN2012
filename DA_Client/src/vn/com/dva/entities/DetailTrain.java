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

public class DetailTrain implements Serializable {
     private Long DetailTrainID;
    private Long TrainID ;
    private List<Long> listIdQuestion ;
    private List<String> listIdAnswer ;
    private List<String> listAnswerRandom ;

    public DetailTrain() {
    }

    
    
    public Long getDetailTrainID() {
        return DetailTrainID;
    }

    public void setDetailTrainID(Long DetailTrainID) {
        this.DetailTrainID = DetailTrainID;
    }

    public Long getTrainID() {
        return TrainID;
    }

    public void setTrainID(Long TrainID) {
        this.TrainID = TrainID;
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

    public List<String> getListAnswerRandom() {
        return listAnswerRandom;
    }

    public void setListAnswerRandom(List<String> listAnswerRandom) {
        this.listAnswerRandom = listAnswerRandom;
    }

    
    
    
    
    @Override
    public String toString() {
        return ""+TrainID;
    }
    
}
