/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vn.com.dva.entities.Subject;
import vn.com.dva.entities.Users;
import vn.com.dva.generic.spi.MyGeneric;

/**
 *
 * @author VietAnh
 */
public class Subject_DAO {
    MyGeneric mydao = new MyGeneric();
    Users_DAO User_Dao = new Users_DAO();
    public Subject_DAO(){
        
    }
    
    public List<Object> getAllData(Class T){
        return mydao.getAllData(T);
    }
    
    public boolean insertAllData(Object o){
        return mydao.insertData(o);
    }
    
    
    
    public boolean checkSubjectName(String name){
        List<Object> list= new ArrayList<Object> ();
        list = mydao.getData1Field(Subject.class, "SubjectName", name );
        if (list.isEmpty())
        {
            return true ;
        }
        return false ;
    }
    
    public Subject getSubjectByID(Long id){
        List<Object> list= new ArrayList<Object> ();
        list = mydao.getData1Field(Subject.class, "SubjectID", id);
        if (!list.isEmpty()){
            return (Subject)list.get(0);
        }
        return new Subject();
    }
    
    
     public List<Subject> getAllSubject(){
        List<Object> listObject = mydao.getAllData(Subject.class);
        List<Subject> list = new ArrayList<Subject>();
        if (!listObject.isEmpty())
        for (int i=0;i< listObject.size() ; i++ ){
            list.add((Subject) listObject.get(i));
        }
        return list;
    }
    
    
    public DefaultTableModel getAllSubjecttoTable() {
       
       DefaultTableModel mode = new DefaultTableModel();
       mode.addColumn("ID");
       mode.addColumn("Tên Môn Học");
       mode.addColumn("Tên Nhóm Môn Học");
       mode.addColumn("Ngày Tạo");
       mode.addColumn("Mã Người Tạo");
       mode.addColumn("Người Tạo");
       mode.addColumn("Trạng Thái");

       
       List<Object> listObject = mydao.getAllData(Subject.class);
       if (! listObject.isEmpty())
           for (int i=0;i< listObject.size();i++){
               Subject s = (Subject) listObject.get(i);
               Users u ;
               try {
                   Long idUser = s.getUserID() ;
                   u = User_Dao.getUserByID(idUser);
               } catch(Exception ex){
                   u = new Users();
                   u.setUserID(0L);
                   u.setUserName("");
               }
               Long idSubjectParent;
               String p ="";
               try {
                   idSubjectParent = s.getSubjectParent();
                   if (idSubjectParent != null) {
                       p = (this.getSubjectByID(idSubjectParent)).getSubjectName() ;
                   }
                } catch(Exception e){
                   p = "Ko";
                }
               String trangthai = "Chưa Duyệt";
               if (s.getSubjectState()) trangthai = "Đã Duyệt";
               mode.addRow(new Object[]{s.getSubjecId() , s.getSubjectName() , p , s.getDateCreate() , u.getUserID() , u.getUserName() , trangthai});
           }
       return mode; 
    }
    
    public boolean insertUser(Subject u){
        return mydao.insertData(u);
    }
    
    public boolean updateUser(Subject u){
        return mydao.updateData(u);
    }
    
    public boolean removeUser(Long id){
        return mydao.removeData(Subject.class, id);
    }
    
}

