/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VietAnh
 */
public class config_DAO {

    private String SERVERNAME = "localhost";
    private String USERNAME = "sa";
    private String PASSWORD = "";
    private String DATABASE = "TESTONLINE";
    private String SERVERCHAT = "localhost";

    public config getConfig() {
        return openFile();
    }

    public boolean updateconfig(config c) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("config.txt", false);
            PrintWriter pw = new PrintWriter(fos);
            pw.println("ServerName=" + c.getServerName());
            pw.println("Username=" + c.getUserName());
            pw.println("Password=" + c.getPassword());
            pw.println("Database=" + c.getDatabaseName());
            pw.println("ServerChat=" + c.getServerNameChat());
            pw.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(config_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(config_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setDefaultConfig() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("config.txt", false);
            PrintWriter pw = new PrintWriter(fos);
            pw.println("ServerName=" + SERVERNAME);
            pw.println("Username=" + USERNAME);
            pw.println("Password=" + PASSWORD);
            pw.println("Database=" + DATABASE);
            pw.println("ServerChat=" + SERVERCHAT);
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(config_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(config_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public boolean isFileExists(String fileName) {
        File file = new File(fileName);

        if (file.exists()) {
            return true;
        } else {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(config_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

    private config openFile() {
        config bean = new config();
        try {
            if (!this.isFileExists("config.txt")) {
                FileOutputStream fos = new FileOutputStream("config.txt", false);
                PrintWriter pw = new PrintWriter(fos);
                pw.println("ServerName=" + SERVERNAME);
                pw.println("Username=" + USERNAME);
                pw.println("Password=" + PASSWORD);
                pw.println("Database=" + DATABASE);
                pw.println("ServerChat=" + SERVERCHAT);
                pw.close();
            }
            FileReader fr = new FileReader("config.txt");
            BufferedReader input = new BufferedReader(fr);
            try {
                String serverName = input.readLine();
                serverName = serverName.replace("ServerName=", "");
                String userName = input.readLine();
                userName = userName.replace("Username=", "");
                String password = input.readLine();
                password = password.replace("Password=", "");
                String database = input.readLine();
                database = database.replace("Database=", "");
                String serverChat = input.readLine();
                serverChat = serverChat.replace("ServerChat=", "");
                bean.setServerName(serverName);
                bean.setUserName(userName);
                bean.setPassword(password);
                bean.setDatabaseName(database);
                bean.setServerNameChat(serverChat);
            } catch (IOException ex) {
                Logger.getLogger(config_DAO.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(config_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bean;
    }
}
