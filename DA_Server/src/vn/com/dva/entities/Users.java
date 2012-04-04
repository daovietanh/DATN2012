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
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UserID;
    private String UserName ;
    private String Password ;
    private String FullName ;
    private Long GroupUserID;
    private String Birthday ;
    private String Address ;
    private String City ;
    private String Email ;
    private String Mobile ;
    private byte[] Photo ;
    private String JoinDate ;
    private String LastLoginDate ;
    private boolean Enable ;
    private String Question ;
    private String AnswerQuestion ;
    

    public Users(){
        
    }
    
    
    public Users(Long id,String u, Long group ,String p , String fname , String birthday , String add , String city , 
            String email , String mobile , byte[] b , String jdate , String LastLogin , boolean e , String q ,String answer){
        this.UserID = id ;
        this.UserName = u ;
        this.Password = p ;
        this.GroupUserID = group ;
        this.FullName = fname;
        this.Birthday = birthday;
        this.Address = add ;
        this.City = city ;
        this.Email = email ;
        this.Mobile = mobile ;
        this.Photo = b;
        this.JoinDate = jdate ;
        this.LastLoginDate = LastLogin;
        this.Enable = e ;
        this.Question = q;
        this.AnswerQuestion=  answer ;
    }
    
    public Users(String u, String p , Long group ,String fname , String birthday , String add , String city , 
            String email , String mobile , byte[] b , String jdate , String LastLogin , boolean e , String q ,String answer){
        this.UserName = u ;
        this.Password = p ;
        this.GroupUserID = group ;
        this.FullName = fname;
        this.Birthday = birthday;
        this.Address = add ;
        this.City = city ;
        this.Email = email ;
        this.Mobile = mobile ;
        this.Photo = b;
        this.JoinDate = jdate ;
        this.LastLoginDate = LastLogin;
        this.Enable = e ;
        this.Question = q;
        this.AnswerQuestion=  answer ;
    }
    
    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long id) {
        this.UserID = id;
    }
 
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String s) {
        this.UserName = s;
    }
    
    public String getPassword() {
        return Password;
    }

    public void setPassword(String s) {
        this.Password = s;
    }
    
    public Long getGroupUserID() {
        return GroupUserID;
    }

    public void setGroupUserID(Long id) {
        this.GroupUserID = id;
    }
    
    public String getFullName() {
        return FullName;
    }

    public void setFullName(String s) {
        this.FullName = s;
    }
    
    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String s) {
        this.Birthday = s;
    }
    
    public String getAddress() {
        return Address;
    }

    public void setAddress(String s) {
        this.Address = s;
    }
    
    public String getCity() {
        return City;
    }

    public void setCity(String s) {
        this.City = s;
    }
    
    
    public String getEmail() {
        return Email;
    }

    public void setEmail(String s) {
        this.Email = s;
    }
    
    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String s) {
        this.Mobile = s;
    }
    
    public String getJoinDate() {
        return JoinDate;
    }

    public void setJoinDate(String s) {
        this.JoinDate = s;
    }
    
    public byte[] getPhoto() {
        return Photo;
    }

    public void setPhoto(byte[] b) {
        this.Photo  = b;
    }
    
    public String getLastLoginDate() {
        return LastLoginDate;
    }

    public void setLastLoginDate(String s) {
        this.LastLoginDate = s;
    }
    
    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String s) {
        this.Question = s;
    }

    public String getAnserQuestion() {
        return AnswerQuestion;
    }

    public void setAnswerQuestion(String s) {
        this.AnswerQuestion = s;
    }
    
    public boolean getEnable() {
        return Enable;
    }

    public void setEnable(boolean s) {
        this.Enable = s;
    }
    

    @Override
    public String toString() {
        return this.UserName;
    }
    
}
