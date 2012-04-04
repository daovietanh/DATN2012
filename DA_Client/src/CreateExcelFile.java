/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileOutputStream;
import java.lang.Object;
import java.lang.reflect.Field;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author VietAnh
 */
public class CreateExcelFile {

    HSSFWorkbook hwb;
    HSSFSheet sheet;

    public void startCreate(List<Object> listClass) {
        String filename = "d:/backup.xls";
        hwb = new HSSFWorkbook();

        backup(listClass);

        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            hwb.write(fileOut);
            fileOut.close();
        } catch (Exception ex) {
        }
        JOptionPane.showMessageDialog(null, " Backup is success");
    }

    public void createARowSheet(List<String> lst, int cs) {
        HSSFRow row = sheet.createRow((short) cs);
        for (int i = 0; i < lst.size(); i++) {
            row.createCell((short) i).setCellValue(lst.get(i));
        }
    }

    public void createHeaderSheet(Class T) {
        HSSFRow row = sheet.createRow((short) 0);
        Field[] f = T.getDeclaredFields();
        for (int i = 0; i < f.length; i++) {
            row.createCell((short) i).setCellValue(f[i].getName());
        }
    }

    public void backup(List<Object> listClass) {
        for (int i = 0; i < listClass.size(); i++) {
            Class c = (Class) listClass.get(i);
            List<Object> lst = new ArrayList<Object>();
            // Lấy tất cả dữ liệu của 1 bảng của đối tượng c
            try {
                lst = Cl_Client.c.getAllData(c);
            } catch (RemoteException ex) {
                Logger.getLogger(CreateExcelFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Tạo mới 1 sheet
            sheet = hwb.createSheet(c.getSimpleName());
            // Tạo 1 dòng header
            this.createHeaderSheet(c);
            if (lst.size() > 0) {
                for (int cs = 0; cs < lst.size(); cs++) {
                    Object obj = lst.get(cs);
                    Class cl = obj.getClass();
                    Field[] f = cl.getDeclaredFields();
                    HSSFRow row = sheet.createRow((short) cs + 1);
                    for (int j = 0; j < f.length; j++) {
                        try {
                            f[j].setAccessible(true);
                            if (f[j].getType().equals(Calendar.class)) {
                                Calendar c1 = (Calendar) f[j].get(obj);
                                row.createCell((short) j).setCellValue(c1);
                            } else if (f[j].getType().equals(byte[].class)) {
                                Object s = f[j].get(obj);
                                if (s instanceof byte[]){
                                    byte[] bs= (byte[]) s;
                                    String str = new String(bs);
                                    row.createCell((short) j).setCellValue(str);
                                }
                            } else if (f[j].getType().equals(Boolean.TYPE)) {
                                boolean b = (boolean) f[j].getBoolean(obj);
                                row.createCell((short) j).setCellValue(b);
                            } else {
                                row.createCell((short) j).setCellValue(f[j].get(obj) + "");
                            }
                        } catch (Exception ex) {
                            System.out.print("\n" + ex.toString());
                        }
                    }
                }
            }

        }
    }
}
