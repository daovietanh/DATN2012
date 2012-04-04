/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import vn.com.dva.entities.DetailTrain;
import vn.com.dva.generic.spi.MyGeneric;

/**
 *
 * @author VietAnh
 */
public class DetailTrain_DAO {
    MyGeneric mydao = new MyGeneric();
    
    public DetailTrain_DAO(){}
    
    public DetailTrain getDetailTrainByID(Long id){
        List<Object> list= new ArrayList<Object> ();
        list = mydao.getData1Field(DetailTrain.class, "DetailTrainID", id);
        if (!list.isEmpty()){
            return (DetailTrain)list.get(0);
        }
        return new DetailTrain();
    }
    
    public DetailTrain getDetailTrainByTrainID(Long id){
        List<Object> list= new ArrayList<Object> ();
        list = mydao.getData1Field(DetailTrain.class, "TrainID", id);
        if (!list.isEmpty()){
            return (DetailTrain)list.get(0);
        }
        return new DetailTrain();
    }
    
    
    public List<DetailTrain> getAllDetailTrain(){
        List<Object> listObject = mydao.getAllData(DetailTrain.class);
        List<DetailTrain> list = new ArrayList<DetailTrain>();
        if (!listObject.isEmpty())
        for (int i=0;i< listObject.size() ; i++ ){
            list.add((DetailTrain) listObject.get(i));
        }
        return list;
    }
    
    public boolean insertDetailTrain(DetailTrain u){
        return mydao.insertData(u);
    }
    
    public boolean updateDetailTrain(DetailTrain u){
        return mydao.updateData(u);
    }
    
    public boolean removeDetailTrain(Long id){
        return mydao.removeData(DetailTrain.class, id);
    }
}
