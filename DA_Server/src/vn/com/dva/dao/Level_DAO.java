/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vn.com.dva.entities.LevelAll;
import vn.com.dva.generic.spi.MyGeneric;

/**
 *
 * @author VietAnh
 */
public class Level_DAO {
    MyGeneric mydao = new MyGeneric();
    Users_DAO User_Dao = new Users_DAO();
    public Level_DAO(){
        
    }
    
    public boolean checkLevelName(String name){
        List<Object> list= new ArrayList<Object> ();
        list = mydao.getData1Field(LevelAll.class, "SubjectName", name );
        if (list.isEmpty())
        {
            return true ;
        }
        return false ;
    }
    
    public LevelAll getLevelByID(Long id){
        List<Object> list= new ArrayList<Object> ();
        list = mydao.getData1Field(LevelAll.class, "LevelAllID", id);
        if (!list.isEmpty()){
            return (LevelAll)list.get(0);
        }
        return new LevelAll();
    }
    
    
     public List<LevelAll> getAllLevel(){
        List<Object> listObject = mydao.getAllData(LevelAll.class);
        List<LevelAll> list = new ArrayList<LevelAll>();
        if (!listObject.isEmpty())
        for (int i=0;i< listObject.size() ; i++ ){
            list.add((LevelAll) listObject.get(i));
        }
        return list;
    }
    
    
    public DefaultTableModel getAllLeveltoTable() {
       
       DefaultTableModel mode = new DefaultTableModel();
       mode.addColumn("ID");
       mode.addColumn("Tên Độ Khó");
       mode.addColumn("Mô tả Ngắn");
       mode.addColumn("Tỉ Lệ Dễ");
       mode.addColumn("Tỉ Lệ Thường");
       mode.addColumn("Tỉ Lệ Khó");

       
       List<Object> listObject = mydao.getAllData(LevelAll.class);
       if (! listObject.isEmpty())
           for (int i=0;i< listObject.size();i++){
               LevelAll s = (LevelAll) listObject.get(i);
               String description ="";
//               if (s.getLevelDescription().length() > 25) {
//                   description = s.getLevelDescription().substring(0, 25);
//                   description += " ...";
//               }else 
               description = s.getLevelDescription();
               
               mode.addRow(new Object[]{s.getLevelAllID() , s.getLevelName() , description, s.getPercentEasy(), s.getPercentNormal() , s.getPercentHard()});
           }
       return mode; 
    }
    
    public boolean insertLevel(LevelAll u){
        return mydao.insertData(u);
    }
    
    public boolean updateLevel(LevelAll u){
        return mydao.updateData(u);
    }
    
    public boolean removeLevel(Long id){
        return mydao.removeData(LevelAll.class, id);
    }
}
