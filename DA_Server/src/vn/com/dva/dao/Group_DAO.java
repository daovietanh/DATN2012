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
import vn.com.dva.generic.spi.MyGeneric;

/**
 *
 * @author VietAnh
 */
public class Group_DAO {
    private final String ADMIN = "Admin";
    private final String TEACHER = "Giáo Viên";
    private final String STUDENT = "Sinh Viên";
    MyGeneric mydao = new MyGeneric();
    
    public Group_DAO(){
        
    }
    
    public List<GroupUser> getAllGroup(){
        List<Object> listObject = mydao.getAllData(GroupUser.class);
        List<GroupUser> list = new ArrayList<GroupUser>();
        if (!listObject.isEmpty())
        for (int i=0;i< listObject.size() ; i++ ){
            list.add((GroupUser) listObject.get(i));
        }
        return list;
    }
    
    public boolean checkNameGroup(String s) {
        List<GroupUser> list = this.getAllGroup();
        for (GroupUser bean : list){
            if (bean.getGroupName().equals(s))
                return false ;
        }
        return true;
    }
    
    public DefaultTableModel getAllGroupUsertoTable() {
       
       DefaultTableModel mode = new DefaultTableModel();
       mode.addColumn("ID");
       mode.addColumn("Tên Nhóm");
       mode.addColumn("Mô Tả Nhóm");
       mode.addColumn("Trạng Thái");
       mode.addColumn("Quyền Hạn");
       List<Object> listObject;
       listObject = mydao.getAllData(GroupUser.class);
       if (! listObject.isEmpty())
           for (int i=0;i< listObject.size();i++){
               GroupUser e = (GroupUser) listObject.get(i);
               String manager = STUDENT;
               if (e.getAccessManager() == 1)  manager =ADMIN ;
               else if (e.getAccessManager() == 2)  manager =TEACHER ;
               mode.addRow(new Object[]{e.getGroupID(), e, e.getGroupDescription() , e.isStatus() , manager });
           }
       return mode; 
    }
    
    
    
    public GroupUser getGroupByID(Long id ){
        List<Object> listObject = mydao.getData1Field(GroupUser.class, "GroupID", id);
        if (!listObject.isEmpty()){
            return (GroupUser) listObject.get(0);
        }
        return new GroupUser();      
    }
    
    public boolean insertGroupUser(GroupUser u){
        return mydao.insertData(u);
    }
    
    public boolean updateGroupUser(GroupUser u){
        return mydao.updateData(u);
    }
    
    public boolean removeGroupUser(Long id){
        return mydao.removeData(GroupUser.class, id);
    }
    
}
