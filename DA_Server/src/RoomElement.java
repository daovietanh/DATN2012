/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author freeloop
 */
public class RoomElement extends Thread {
    private String my_Name;
    private Socket sock;
    private PrintWriter writer;
    private BufferedReader reader;
    private Room masterRoom;
    public RoomElement(Room room, Socket Sock,String My_Name){
        my_Name = My_Name;
        masterRoom = room;
        sock = Sock;
        try {
            reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()), true);
            this.start();
        } catch (IOException ex) {
            room.removeElement(this);
            try {
                sock.close();
            } catch (IOException ex1) {

            }
            this.stop();
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                String Command = CriticalStream.ReaderStream(reader);
                if (Command.startsWith("CHAT:")){
                    broadcastMessage(Command);
                }
                
            } catch (IOException ex) {
               masterRoom.removeElement(this);
                try {
                    sock.close();
                } catch (IOException ex1) {

                }
                this.stop();
            }
        }
    }
    
    private void broadcastMessage(String Message){

        long ID_User_send_Message = this.getId();
        masterRoom.Chatting(ID_User_send_Message, Message);
    }
    public void giveMessage(String Message){
        CriticalStream.WriterStream(writer,Message);
    }
    public String getNameElement(){
        return my_Name;
    }
}
