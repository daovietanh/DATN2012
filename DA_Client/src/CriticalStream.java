/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Manager stream transfer, synchronous and security data in the line
 * @author freeloop
 */
public class CriticalStream {
    /**
     * Give Obj_Reader into synchronized and wait obj until read to finish. And return String transmit
     * @param Obj_Reader
     * @return String read from Obj_Reader
     * @throws IOException . Programmer solve by yourself
     */
    public static String ReaderStream(BufferedReader Obj_Reader) throws IOException{
        String temp = "";
            synchronized (Obj_Reader) {
                temp = Obj_Reader.readLine();
                //logger.WriteLogger("READ:"+temp);
                return temp;

            }
    }
    /**
     * Write String into Obj_writer. (Obj_writer will block(with other function need to use) until this function finish
     * @param OutputStream
     * @param string_write
     */
    public static void WriterStream(PrintWriter Obj_writer, String string_write){
        try {
            synchronized (Obj_writer) {
                // syntax transmit in line
                String syntax = string_write;
                Obj_writer.println(syntax);
            }
        } catch (Exception e) {
        }
    }
    /**
     * Write data into Obj_writer have structure. (Obj_writer will block(with other function need to use) until this function finish
     * @param Obj_writer
     * @param Command
     * @param data
     */
    public static void WriterStream(PrintWriter Obj_writer, String Command, String data){
        try {
            synchronized (Obj_writer) {
                //syntax transmit in line
                String syntax = Command + data;
                Obj_writer.println(syntax);
                //logger.WriteLogger("WRITE:"+syntax);
            }
        } catch (Exception e) {
        }
    }
}
