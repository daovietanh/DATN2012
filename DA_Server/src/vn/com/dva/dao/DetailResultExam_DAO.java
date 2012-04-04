/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.dao;

import java.util.ArrayList;
import java.util.List;
import vn.com.dva.entities.DetailResultExam;
import vn.com.dva.generic.spi.MyGeneric;

/**
 *
 * @author VietAnh
 */
public class DetailResultExam_DAO {
    MyGeneric mydao = new MyGeneric();
    
    public DetailResultExam_DAO(){}
    
    public DetailResultExam getDetailResultExamByID(Long id){
        List<Object> list= new ArrayList<Object> ();
        list = mydao.getData1Field(DetailResultExam.class, "id", id);
        if (!list.isEmpty()){
            return (DetailResultExam)list.get(0);
        }
        return new DetailResultExam();
    }
    
    public DetailResultExam getDetailResultExamByResultExamID(Long id){
        List<Object> list= new ArrayList<Object> ();
        list = mydao.getData1Field(DetailResultExam.class, "ResultExamID", id);
        if (!list.isEmpty()){
            return (DetailResultExam)list.get(0);
        }
        return new DetailResultExam();
    }
    
    
    public List<DetailResultExam> getAllDetailDetailResultExam(){
        List<Object> listObject = mydao.getAllData(DetailResultExam.class);
        List<DetailResultExam> list = new ArrayList<DetailResultExam>();
        if (!listObject.isEmpty())
        for (int i=0;i< listObject.size() ; i++ ){
            list.add((DetailResultExam) listObject.get(i));
        }
        return list;
    }
    
    public boolean insertDetailResultExam(DetailResultExam u){
       return mydao.insertData(u);
    }
    
    public boolean updateDetailResultExam(DetailResultExam u){
        return mydao.updateData(u);
    }
    
    public boolean removeDetailResultExam(Long id){
        return mydao.removeData(DetailResultExam.class, id);
    }
}
