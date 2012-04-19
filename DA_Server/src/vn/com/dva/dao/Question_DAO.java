/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vn.com.dva.entities.Question;
import vn.com.dva.entities.Users;
import vn.com.dva.generic.spi.MyGeneric;

/**
 *
 * @author VietAnh
 */
public class Question_DAO {
    MyGeneric mydao = new MyGeneric();
    Users_DAO userDAO = new Users_DAO();
    Level_DAO levelDAO = new Level_DAO();
    
    public Question_DAO(){
        
    }
    
    public boolean checkQuestionName(String name){
        List<Object> list= new ArrayList<Object> ();
        list = mydao.getData1Field(Question.class, "QuestionTitle", name );
        if (list.isEmpty())
        {
            return true ;
        }
        return false ;
    }
    
    public Question getQuestionByID(Long id){
        List<Object> list= new ArrayList<Object> ();
        list = mydao.getData1Field(Question.class, "QuestionID", id);
        if (!list.isEmpty()){
            return (Question)list.get(0);
        }
        return new Question();
    }
    
    
     public List<Question> getAllQuestion(){
        List<Object> listObject = mydao.getAllData(Question.class);
        List<Question> list = new ArrayList<Question>();
        if (!listObject.isEmpty())
        for (int i=0;i< listObject.size() ; i++ ){
            list.add((Question) listObject.get(i));
        }
        return list;
    }
    
    public List<Question> getAllQuestionBySubject(Long id){
        List<Object> listObject = mydao.getData1Field(Question.class, "SubjectID", id);
        List<Question> list = new ArrayList<Question>();
        if (!listObject.isEmpty())
        for (int i=0;i< listObject.size() ; i++ ){
            list.add((Question) listObject.get(i));
        }
        return list;
    }
    
     
    public DefaultTableModel getAllQuestiontoTable() {
       DefaultTableModel mode = new DefaultTableModel();
       mode.addColumn("ID");
       mode.addColumn("Tiêu đề");
       mode.addColumn("ID Người tạo");
       mode.addColumn("Người tạo");
       mode.addColumn("Độ Khó");
       mode.addColumn("Nội dung");
       mode.addColumn("Ngày tạo");

       
       List<Object> listObject = mydao.getAllData(Question.class);
       if (! listObject.isEmpty())
           for (int i=0;i< listObject.size();i++){
               Question q = (Question) listObject.get(i);
               
               Long IdUser = q.getUserID();
               Users user = userDAO.getUserByID(IdUser);
               String nameUser = user.getUserName();
               
               String level = "Khó";
               if (q.getLevelID() == 1) level = "Dễ" ;
               else if (q.getLevelID() == 2 ) level = "Trung Bình" ;          

               mode.addRow(new Object[]{q.getQuestionID() , q.getQuestionTitle() , q.getUserID(), nameUser, level , q.getContent(), q.getDateCreate()});
           }
       return mode; 
    }
    
    public boolean insertQuestion(Question u){
        return mydao.insertData(u);
    }
    
    public boolean updateQuestion(Question u){
        return mydao.updateData(u);
    }
    
    public boolean removeQuestion(Long id){
        return mydao.removeData(Question.class, id);
    }
}
