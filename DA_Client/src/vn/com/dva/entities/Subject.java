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
public class Subject implements Serializable {
    private Long SubjectID ;
    private String SubjectName ;
    private Long SubjectParent ;
    private String SubjectDescription ;
    private boolean SubjectState ;
    private Long UserID ;
    private String DateCreate ;
    
    public Subject(){
    }
    
    public Subject(Long id, String SN, Long idP, String description , boolean b , Long l, String date){
        this.SubjectID = id ;
        this.SubjectName = SN ;
        this.SubjectParent = idP;
        this.SubjectDescription = description;
        this.SubjectState = b;
        this.UserID = l ;
        this.DateCreate = date ;
    }
    
    public Subject(String SN, Long idP, String description , boolean b , Long l ,String date){
        this.SubjectName = SN ;
        this.SubjectParent = idP;
        this.SubjectDescription = description;
        this.SubjectState = b;
        this.UserID = l ;
        this.DateCreate = date ;
    }
    
    

    public Long getSubjecId() {
        return SubjectID;
    }

    public void setSubjectId(Long id) {
        this.SubjectID = id;
    }

    public Long getSubjectParent() {
        return SubjectParent;
    }

    public void setSubjectParent(Long id) {
        this.SubjectParent = id;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String s) {
        this.SubjectName = s;
    }
    
    public String getSubjectDescription() {
        return SubjectDescription;
    }

    public void setSubjectDescription(String s) {
        this.SubjectDescription = s;
    }
    
    public boolean getSubjectState() {
        return SubjectState;
    }

    public void setSubjectState(boolean b) {
        this.SubjectState = b;
    }
    
    public Long getUserID() {
        return UserID;
    }

    public void setUserId(Long id) {
        this.UserID = id;
    }
    
    public String getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(String s) {
        this.DateCreate = s;
    }
    

    @Override
    public String toString() {
        return ""+ SubjectName;
    }
    
}
