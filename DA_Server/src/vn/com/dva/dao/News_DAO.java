/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.dao;

import java.util.ArrayList;
import java.util.List;
import vn.com.dva.entities.News;
import vn.com.dva.generic.spi.MyGeneric;

/**
 *
 * @author VietAnh
 */
public class News_DAO {
    MyGeneric mydao = new MyGeneric();
    Users_DAO User_Dao = new Users_DAO();

    public News_DAO() {
    }
    
    public List<News> getListNews(int n){
        List<News> list = new ArrayList<News>();
        List<Object> lstObj = mydao.getAllData(News.class);
        if (lstObj.size() < n) return null;
        for (int i = lstObj.size()-n ; i< lstObj.size();i++){
            list.add((News)lstObj.get(i));
        }
        return list ;
    }
    
    public List<News> getAllNews(){
        List<Object> listObject = mydao.getAllData(News.class);
        List<News> list = new ArrayList<News>();
        if (!listObject.isEmpty())
        for (int i=0;i< listObject.size() ; i++ ){
            list.add((News) listObject.get(i));
        }
        return list;
    }
    
    public boolean insertNews(News u){
        return mydao.insertData(u);
    }
    
    public boolean updateNews(News u){
        return mydao.updateData(u);
    }
    
    public boolean removeNews(Long id){
        return mydao.removeData(News.class, id);
    }
}
