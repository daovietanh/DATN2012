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
public class config implements Serializable {
    private int id;
    private String serverName;
    private String userName ;
    private String password ;
    private String databaseName ;
    private String serverNameChat ;

    @Override
    public String toString() {
        return ""+id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerNameChat() {
        return serverNameChat;
    }

    public void setServerNameChat(String serverNameChat) {
        this.serverNameChat = serverNameChat;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public config() {
    }
    
}
