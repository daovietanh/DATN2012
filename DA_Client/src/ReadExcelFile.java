
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author VietAnh
 */
public class ReadExcelFile {

    private HSSFWorkbook workbook;
    HSSFSheet mySheet;
    InputStream ip = null;

    public void readExcel(List<Object> listClass) throws Exception {
        ip = new FileInputStream("d:/backup.xls");
        workbook = new HSSFWorkbook(ip);
        backup(listClass);
        JOptionPane.showMessageDialog(null, " Import success"); 

    }

    public void backup(List<Object> listClass) throws Exception {
        for (int i = 0; i < listClass.size(); i++) {
            Class c = (Class) listClass.get(i);
            mySheet = workbook.getSheet(c.getSimpleName());
            Iterator rowIter = mySheet.rowIterator();
            //Object obj = new Object();
            rowIter.next();
            while (rowIter.hasNext()) {
                Object obj = c.newInstance();
                Field[] f = c.getDeclaredFields();
                HSSFRow myRow = (HSSFRow) rowIter.next();
                for (int j = 0; j < f.length; j++) {
                    f[j].setAccessible(true);
                    //JOptionPane.showMessageDialog(null, myRow.getCell(j));
                    if (f[j].getType().equals(Long.class)) {
                        try {
                            //JOptionPane.showMessageDialog(null, "Long type");
                            Long idLong = Long.parseLong(myRow.getCell(j).toString());
                            f[j].set(obj, idLong);
                        } catch (NumberFormatException ex) {
                            f[j].set(obj, null);
                        }
                    } else if (f[j].getType().equals(Integer.TYPE)) {
                        try {
                            int idInteger = Integer.parseInt(myRow.getCell(j).toString().trim());
                            f[j].set(obj, idInteger);
                        } catch (NumberFormatException ex) {
                            f[j].set(obj, 0);
                        }
                    } else if (f[j].getType().equals(Double.TYPE)) {
                        try {
                            double d = Double.parseDouble(myRow.getCell(j).toString().trim());
                            f[j].set(obj, d);
                        } catch (NumberFormatException ex) {
                            f[j].set(obj, 0);
                        }
                    }
                    else if (f[j].getType().equals(Boolean.TYPE)) {
                        f[j].set(obj, myRow.getCell(j).getBooleanCellValue());
                    } else if (f[j].getType().equals(Calendar.class)) {
                        try {
                            Calendar calendar = Calendar.getInstance();
                            Date date = myRow.getCell(j).getDateCellValue();
                            calendar.setTime(date);
                            f[j].set(obj, calendar);
                        } catch(Exception ex){
                            f[j].set(obj, null);
                        }
                    } else if (f[j].getType().equals(List.class)) {
                        try {
                            String s = myRow.getCell(j).getStringCellValue();
                            List<Object> list = this.getListFromString(s);
                            f[j].set(obj, list);
                        } catch (Exception ex) {
                            f[j].set(obj, null);
                        }
//                    } else if (f[j].getType().equals(Byte.class) ) {
//                        try {
//                            String s = myRow.getCell(j).getStringCellValue();
//                            List<Object> list = this.getListFromString(s);
//                            f[j].set(obj, list);
//                        } catch (NumberFormatException ex) {
//                            f[j].set(obj, 0);
//                        }
                    } else {
                        if (myRow.getCell(j) == null) {
                            f[j].set(obj, null);
                        } else {
                            try {
                                String value = myRow.getCell(j).toString();
                                f[j].set(obj, value);
                            } catch(Exception ex){
                                f[j].set(obj, null);
                                System.out.print(ex.toString()); 
                            }
                        }
                    }
                }
                //JOptionPane.showMessageDialog(null, obj);
                if (Cl_Client.c.insertAllData(obj)) {
                    //JOptionPane.showMessageDialog(null, "success");
                } else {
                    //JOptionPane.showMessageDialog(null, "Error");
                }

            }
        }
    }

    private byte[] getByteFromString(String s){
        return s.getBytes();
    }
    private List<Object> getListFromString(String s) {
        List<Object> lst = new ArrayList<Object>();
        s = s.replace("[", "");
        s = s.replace("]", "");
        Object[] obj = s.split(", ");
        if (obj.length > 0)
        lst.addAll(Arrays.asList(obj));
        return lst;
    }
}
