/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vn.com.dva.entities.LevelAll;
import vn.com.dva.entities.Subject;
import vn.com.dva.entities.Train;
import vn.com.dva.generic.spi.MyGeneric;

/**
 *
 * @author VietAnh
 */
public class Train_DAO {
    MyGeneric mydao = new MyGeneric();
    Users_DAO User_Dao = new Users_DAO();
    Subject_DAO Subject_Dao = new Subject_DAO();
    Level_DAO level_Dao = new Level_DAO();
    
    public Train_DAO(){
    }
    
    public Train getTrainByID(Long id){
        List<Object> list= new ArrayList<Object> ();
        list = mydao.getData1Field(Train.class, "TrainID", id);
        if (!list.isEmpty()){
            return (Train)list.get(0);
        }
        return new Train();
    }
    
    
    public List<Train> getAllTrain(){
        List<Object> listObject = mydao.getAllData(Train.class);
        List<Train> list = new ArrayList<Train>();
        if (!listObject.isEmpty())
        for (int i=0;i< listObject.size() ; i++ ){
            list.add((Train) listObject.get(i));
        }
        return list;
    }
    
    public DefaultTableModel getAllTraintoTableByIdUser(Long id) {
       
       DefaultTableModel mode = new DefaultTableModel();
       mode.addColumn("ID");
       mode.addColumn("Môn Thi");
       mode.addColumn("Độ Khó");
       mode.addColumn("Tổng Số Câu Hỏi");
       mode.addColumn("Thời Gian Thi");
       mode.addColumn("Ngày Làm");
       mode.addColumn("Điểm");
       List<Object> listObject;
       if (id == null) listObject = mydao.getAllData(Train.class);
       else listObject = mydao.getData1Field(Train.class,"UserID",id);
       if (! listObject.isEmpty())
           for (int i=0;i< listObject.size();i++){
               Train e = (Train) listObject.get(i);
               Subject s = (Subject) Subject_Dao.getSubjectByID(e.getSubjectID());
               LevelAll l = (LevelAll) level_Dao.getLevelByID(e.getLevelID());
               mode.addRow(new Object[]{e, s , l , e.getTotalQuestion() , e.getTimes() , e.getDate_Train() , e.getScore() });
           }
       return mode; 
    }
     
    public Train insertTrainGetId(Train t){
        if (mydao.insertData(t)) return t ;
        else return null ;
    }
    public boolean insertTrain(Train u){
        return mydao.insertData(u);
    }
    
    public boolean updateTrain(Train u){
        return mydao.updateData(u);
    }
    
    public boolean removeTrain(Long id){
        return mydao.removeData(Train.class, id);
    }
}
