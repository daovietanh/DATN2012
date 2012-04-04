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
public class Question implements Serializable {
    @Id
    private Long QuestionID;
    private String QuestionTitle;
    private Long UserID; // User created
    private int LevelID;
    private Long SubjectID; // Mon hoc

    public Long getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(Long SubjectID) {
        this.SubjectID = SubjectID;
    }
    private String Content;
    private String Answer;
    private String ChooseA;
    private String ChooseB;
    private String ChooseC;
    private String ChooseD;
    private String DateCreate;
    private byte[] Picture;

    
    public Question() {
    }

    public Question(Long id, String title, Long user, int level, Long sub, String content, String answer, String a,
            String b, String c, String d, String date, byte[] pic) {
        this.QuestionID = id;
        this.QuestionTitle = title;
        this.UserID = user;
        this.LevelID = level;
        this.SubjectID = sub;
        this.Content = content;
        this.Answer = answer;
        this.ChooseA = a;
        this.ChooseB = b;
        this.ChooseC = c;
        this.ChooseD = d;
        this.DateCreate = date;
        this.Picture = pic;
    }

    public Question(String title, Long user, int level, Long sub, String content, String answer, String a,
            String b, String c, String d, String date, byte[] pic) {
        this.QuestionTitle = title;
        this.UserID = user;
        this.LevelID = level;
        this.SubjectID = sub;
        this.Content = content;
        this.Answer = answer;
        this.ChooseA = a;
        this.ChooseB = b;
        this.ChooseC = c;
        this.ChooseD = d;
        this.DateCreate = date;
        this.Picture = pic;
    }

    public Long getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(Long id) {
        this.QuestionID = id;
    }

    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long id) {
        this.UserID = id;
    }

    public int getLevelID() {
        return LevelID;
    }

    public void setLevelID(int id) {
        this.LevelID = id;
    }

    public String getQuestionTitle() {
        return QuestionTitle;
    }

    public void setQuestionTitle(String s) {
        this.QuestionTitle = s;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String s) {
        this.Content = s;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String s) {
        this.Answer = s;
    }

    public String getChooseA() {
        return ChooseA;
    }

    public void setChooseA(String s) {
        this.ChooseA = s;
    }

    public String getChooseB() {
        return ChooseB;
    }

    public void setChooseB(String s) {
        this.ChooseB = s;
    }

    public String getChooseC() {
        return ChooseC;
    }

    public void setChooseC(String s) {
        this.ChooseC = s;
    }

    public String getChooseD() {
        return ChooseD;
    }

    public void setChooseD(String s) {
        this.ChooseD = s;
    }

    public String getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(String s) {
        this.DateCreate = s;
    }

    public byte[] getPicture() {
        return Picture;
    }

    public void setPicture(byte[] b) {
        this.Picture = b;
    }
    
    public String toString() {
        return "ID=" + QuestionID + ". " + Content ;
    }
    
}