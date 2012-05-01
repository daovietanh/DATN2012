/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.com.dva.dao.Users_DAO;
import vn.com.dva.entities.Users;

/**
 *
 * @author freeloop
 */
public class Room extends Thread{
    ArrayList<RoomElement> element = new ArrayList<RoomElement>();
    private ServerSocket serverSockRoom;
    //Hashtable<String, RoomElement> element = new Hashtable<String, RoomElement>();
    public Room(){
        try {
            serverSockRoom = new ServerSocket(1990, 100);
            this.start();
        } catch (IOException ex) {
            System.out.println("Don't create server sock room.");
        }
    }
    void addElement(Socket Sock, String My_Name){
        element.add(new RoomElement(this, Sock, My_Name));
        String name = My_Name;
        if(My_Name==null) name="Guest";
        Chatting(-1, "Login" +"User "+name + " joined to room ");
        //element.put(My_Name,new RoomElement(this, Sock, My_Name);
        addUserOnline (My_Name);
    }
    public void removeElement(RoomElement obj){
        if (element.remove(obj)){
            // broadcast account leave room
            Broadcast_State_OutRoom(obj, obj.getNameElement());
        }
    }
    private void Broadcast_State_OutRoom(RoomElement User_OutRoom,String Name_User ){
        String Message = "Login" +"User "+ Name_User + " sign out";
        for (int i =0 ; i<element.size();i++) {
            if (element.get(i).getId() != User_OutRoom.getId()){
                element.get(i).giveMessage(Message);
            }
        }
        element.remove(User_OutRoom);
        removeUserOnline(Name_User);
    }
    public void Chatting(long ID_User_Chatting, String Message){
        for (int i =0 ; i<element.size();i++) {
            if (element.get(i).getId() != ID_User_Chatting){
                element.get(i).giveMessage(Message);
            }
        }
    }
    @Override
    public void run() {
        while (true){
            try {
                Socket accept = serverSockRoom.accept();
                synchronized(accept){
                    BufferedReader reader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                    PrintWriter writer = new PrintWriter(new OutputStreamWriter(accept.getOutputStream() ),true);
                    String message = CriticalStream.ReaderStream(reader);
                    if (message.startsWith("Login")){
                        // checking exist this room
                        String subMessage = message.replaceFirst("Login", "");
                        this.addElement(accept, subMessage);

                    }else{
                        //do something else
                    }

                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    
        private void removeUserOnline(String Name_User) {
        Users_DAO dao = new Users_DAO();
        Cl_Database cl = new Cl_Database();
        Long id = null;
        try{
            Users u = dao.getUserByUserName(Name_User);
            id = u.getUserID();
        } catch(Exception ex){
            id=null ;
        }
        
        if (id != null){
            try {
                cl.removeUserOnline(id);
            } catch (RemoteException ex) {
                Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void addUserOnline(String My_Name) {
        Users_DAO dao = new Users_DAO();
        Cl_Database cl = new Cl_Database();
        Long id = null;
        try{
            Users u = dao.getUserByUserName(My_Name);
            id = u.getUserID();
        } catch(Exception ex){
            id=null ;
        }
        
        if (id != null){
            try {
                cl.addUserOnline(id);
            } catch (RemoteException ex) {
                Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
}
