
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import vn.com.dva.entities.Exam;
import vn.com.dva.entities.LevelAll;
import vn.com.dva.entities.Subject;
import vn.com.dva.entities.Users;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VietAnh
 */
public class Session {
    public final static int ADMIN = 1;
    public final static int TEACHER = 2;
    public final static int STUDENT = 3 ;
    
    public final static int ADMIN_ICON = 1;
    public final static int TEACHER_ICON = 2;
    public final static int STUDENT_ICON = 3;
    public final static int BAN_ICON = 4;
    
    public static Users user ;
    public static Exam kythi ;
    public static Calendar ngaythi;
    public static Subject monthi ;
    public static LevelAll dokho ;
    public static String lanthi ;
    public static int socaudung ;
    public static int socausai ;
    public static float diemso ;
    public static int socauhoi =0;
    public static String de ;
    public static String tb ;
    public static String kho ;
    public static int thoigian ;
    
    // Online
    public static List<Long> lstOnline = new ArrayList<Long>() ;
    public static List<Boolean> lstIsChat = new ArrayList<Boolean>() ;
    

}
