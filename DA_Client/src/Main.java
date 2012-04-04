/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VietAnh
 */
public class Main {

    public static Cl_Client client = new Cl_Client();

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                runApp();

            }
        });
    }

    public static void runApp() {
        if (client.checkConnect()) {
            new FrmLogon().setVisible(true);
        }
    }
}
