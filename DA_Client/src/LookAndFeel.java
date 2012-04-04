
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manthang
 */

//Lua chon kieu giao dien cho chuong trinh
public class LookAndFeel {

    public static void Windows () {
    String a ;
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
    }
}
