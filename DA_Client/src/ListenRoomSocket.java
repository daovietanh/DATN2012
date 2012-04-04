
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyleContext;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VietAnh
 */
public class ListenRoomSocket extends Thread {
    private String my_Name ;
    private Socket sock_Listen ;
    private BufferedReader reader;
    private PrintWriter writer;
    private String Command;
    private JTextPane TxtpanelView = null;
    public ListenRoomSocket(String My_Name)
    {
        my_Name = My_Name ;
        try {
            //JOptionPane.showMessageDialog(null, "listen"+ my_Name);
            sock_Listen = new Socket("localhost", 1990);
            reader = new BufferedReader(new InputStreamReader(sock_Listen.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(sock_Listen.getOutputStream()),true);
            //String reply = CriticalStream.ReaderStream(reader);
            CriticalStream.WriterStream(writer, "Login", User.username);
            this.start();


        } catch (UnknownHostException ex) {
            Logger.getLogger(ListenRoomSocket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListenRoomSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void Chatting(String Messages)
    {
        String[] m = Messages.split("\n");
        for (String s : m)
        {
            CriticalStream.WriterStream(writer, "CHAT:", my_Name+
                    "#" +s);
        }
    }

    @Override
    public void run()
    {
        while(true)
        {
            try {
                Command = CriticalStream.ReaderStream(reader);
                workJobs();
            } catch (IOException ex) {
                Logger.getLogger(ListenRoomSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void writeMessage_on_panelView(String fromUser, String Message){

        try {
            TxtpanelView.getDocument().insertString(
                    TxtpanelView.getDocument().getLength(),
                    fromUser + ": "+ Message,
                    TxtpanelView.getStyle(StyleContext.DEFAULT_STYLE));
        } catch (BadLocationException ex) {
        }
        //addStyleText(TxtpanelView, Message, 0);
        try {
            TxtpanelView.getDocument().insertString(
                    TxtpanelView.getDocument().getLength(),
                    "\n",
                    TxtpanelView.getStyle(StyleContext.DEFAULT_STYLE));
        } catch (BadLocationException ex) {
        }
    }
    private void receiverChatting(String fromUser, String Message){
        try{
            if (!Message.equals("")){
                writeMessage_on_panelView(fromUser, Message);
            }
        }catch(Exception e){

        }

    }

//--------------------------------------
    public void workJobs()
    {
        if (Command.startsWith("CHAT:"))
        {
            int index = Command.indexOf("#");
            String name_User = Command.substring("CHAT:".length(), index);
            String message = Command.substring(index +1);
            receiverChatting(name_User,message);
        }
        else
            if (Command.startsWith("Login"))
            {
                receiverChatting("<<Hệ Thống>>",Command.substring(5));
            }
    }

    public void writeMessage_on_panelView(String Message){
        addStyleText(TxtpanelView, Message);
    }

    private void addStyleText(JTextPane pane, String sequence ) {
        try {
            pane.getDocument().insertString(pane.getDocument().getLength(), sequence, pane.getStyle(StyleContext.DEFAULT_STYLE));
        } catch (BadLocationException ex) {
            Logger.getLogger(ListenRoomSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setTextPanelView(JTextPane textPane){
        TxtpanelView = textPane;
    }
}
