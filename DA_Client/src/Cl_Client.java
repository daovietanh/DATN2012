
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import vn.com.dva.entities.config;
import vn.com.dva.entities.config_DAO;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VietAnh
 */
public class Cl_Client {
    public static If_Database c;
    public static String userlogin ;

    public Cl_Client(){
    }
    
    public boolean checkConnect(){
        try
        {
            FactoryService service = (FactoryService) Naming.lookup("rmi://localhost/service");
            c = service.CreateDatabase();
            config bean = new config_DAO().getConfig();
            boolean k = c.ConnectServer(bean.getServerName(),bean.getUserName(),bean.getPassword(),bean.getDatabaseName(),bean.getServerNameChat());
            if (k == false) {
                JOptionPane.showConfirmDialog(null, "Không Thể Kết Nối CSDL, liên hệ với quản trị server.", "Error Connect Server", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE);
                new Pnl_CauHinh().setVisible(true);
                return false;
            }
        }
        catch(Exception e)
        {
            System.out.print("Loi:  "+e);
            return false;
        }
        return true;
    }

    // Kiem tra dang nhap
    public void logon(String user, String pass)
    {
        

    }

    //Hàm dùng để hiển thị thông báo thành công, đầu vào là thông báo cần hiển thị
    public  static void ShowSuccess(String mess){
        JOptionPane.showConfirmDialog(null, mess,"SUCCESSFULLY",JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE);
    }
    //Hàm để hiền thị thông báo lỗi, đầu vào là thông báo lổi
    public static  void ShowError(String mess){
        JOptionPane.showConfirmDialog(null, mess,"ERROR",JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE );
    }
    //Hàm lấy ra ID của hàng đang chọn trong một table, đưa vào talbe cần lấy!
    public  String getID(JTable table){
        int row = table.getSelectedRow();
        return ""+ table.getValueAt(row, 0);
    }
    
    public  Long getIDTable(JTable table){
        int row = table.getSelectedRow();
        return (Long) table.getValueAt(row, 0);
    }

}
