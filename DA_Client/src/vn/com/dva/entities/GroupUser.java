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
public class GroupUser implements Serializable {
    private Long GroupID;
    private String GroupName ;
    private String GroupDescription ;
    private boolean Status ;
    private int AccessManager ;

    public GroupUser(){
        
    }

    public int getAccessManager() {
        return AccessManager;
    }

    public void setAccessManager(int AccessManager) {
        this.AccessManager = AccessManager;
    }

    public String getGroupDescription() {
        return GroupDescription;
    }

    public void setGroupDescription(String GroupDescription) {
        this.GroupDescription = GroupDescription;
    }

    public Long getGroupID() {
        return GroupID;
    }

    public void setGroupID(Long GroupID) {
        this.GroupID = GroupID;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    @Override
    public String toString(){
        return this.GroupName;
    }
    
}
