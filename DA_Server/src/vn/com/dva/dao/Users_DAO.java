/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vn.com.dva.entities.GroupUser;
import vn.com.dva.entities.Subject;
import vn.com.dva.entities.Users;
import vn.com.dva.generic.spi.MyGeneric;

/**
 *
 * @author VietAnh
 */
public class Users_DAO {
    MyGeneric mydao = new MyGeneric();
    Group_DAO groupDao = new Group_DAO();
    public Users_DAO(){
        
    }
    
    public boolean checkLogin(String user, String pass){
        List<Object> list= new ArrayList<Object> ();
        list = mydao.getData2Field(Users.class, "UserName","Password" , user, pass);
        if (!list.isEmpty())
        {
            return true ;
        }
        return false ;
    }
    
    public boolean checkUserName(String user){
        List<Object> list= new ArrayList<Object> ();
        list = mydao.getData1Field(Users.class, "UserName", user);
        if (list.isEmpty())
        {
            return true ;
        }
        return false ;
    }
    
    
    public List<Users> getAllUser(){
        List<Object> listObject = mydao.getAllData(Subject.class);
        List<Users> list = new ArrayList<Users>();
        if (!listObject.isEmpty())
        for (int i=0;i< listObject.size() ; i++ ){
            list.add((Users) listObject.get(i));
        }
        return list;
    }
    
    
    public Users getUserByID(Long id){
        List<Object> list= new ArrayList<Object> ();
        list = mydao.getData1Field(Users.class, "UserID", id);
        if (!list.isEmpty()){
            return (Users)list.get(0);
        }
        return new Users();
    }
    
    public Users getUserByUserName(String user){
        List<Object> list= new ArrayList<Object> ();
        list = mydao.getData1Field(Users.class, "UserName", user);
        if (!list.isEmpty()){
            return (Users)list.get(0);
        }
        return new Users();
    }
    
    
    
    
    public DefaultTableModel getAllUserstoTable() {
       
       DefaultTableModel mode = new DefaultTableModel();
       mode.addColumn("ID");
       mode.addColumn("Username");
       mode.addColumn("Họ tên");
       mode.addColumn("Ngày Sinh");
       mode.addColumn("Group");
       mode.addColumn("Ngày ĐKý");
       mode.addColumn("Địa Chỉ");
       mode.addColumn("Trạng thái");
       
       List<Object> listObject = mydao.getAllData(Users.class);
       if (! listObject.isEmpty())
           for (int i=0;i< listObject.size();i++){
               Users u = (Users) listObject.get(i);
               String trangthai = null ;
               if (u.getEnable() == true) trangthai ="OK";
                    else trangthai = "Cấm";
               GroupUser group = groupDao.getGroupByID(u.getGroupUserID());
               mode.addRow(new Object[]{u.getUserID() , u.getUserName() , u.getFullName(), u.getBirthday() , group.getGroupName(), u.getJoinDate() , u.getAddress(), trangthai});
           }
       return mode; 
    }
    
    
    
    
    public boolean insertUser(Users u){
        return mydao.insertData(u);
    }
    
    public boolean updateUser(Users u){
        return mydao.updateData(u);
    }
    
}
