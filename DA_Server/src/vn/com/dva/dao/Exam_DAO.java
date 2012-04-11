/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vn.com.dva.entities.Exam;
import vn.com.dva.entities.ResultExam;
import vn.com.dva.entities.Subject;
import vn.com.dva.entities.Users;
import vn.com.dva.generic.spi.MyGeneric;

/**
 *
 * @author VietAnh
 */
public class Exam_DAO {
    MyGeneric mydao = new MyGeneric();
    Users_DAO User_Dao = new Users_DAO();
    Subject_DAO Subject_Dao = new Subject_DAO();
    public Exam_DAO(){
        
    }
    
    public boolean checkExamName(String name){
         List<Object> list= new ArrayList<Object> ();
        list = mydao.getData1Field(Exam.class, "ExamName", name );
        if (list.isEmpty())
        {
            return true ;
        }
        return false ;
    }
    
    
     public Exam getExamByID(Long id){
        List<Object> list= new ArrayList<Object> ();
        list = mydao.getData1Field(Exam.class, "ExamID", id);
        if (!list.isEmpty()){
            return (Exam)list.get(0);
        }
        return new Exam();
    }
    
     
     public List<Exam> getAllExam(){
        List<Object> listObject = mydao.getAllData(Exam.class);
        List<Exam> list = new ArrayList<Exam>();
        if (!listObject.isEmpty())
        for (int i=0;i< listObject.size() ; i++ ){
            list.add((Exam) listObject.get(i));
        }
        return list;
    }
     
     
    public List<Exam> getCurrentExam(){
        List<Object> listObject = mydao.getAllData(Exam.class);
        List<Exam> list = new ArrayList<Exam>();
        if(!listObject.isEmpty())
        {
            Calendar c = Calendar.getInstance();
            for (int i =0 ; i< listObject.size() ; i++){
                Exam e = (Exam) listObject.get(i);
                Calendar dateStart = e.getDateStart() ;
                Calendar dateEnd = e.getDateEnd() ;
                if (c.after(dateStart) && c.before(dateEnd))
                    list.add(e);
            }
        }
        return list;
    }
     
     
     public DefaultTableModel getAllSubjecttoTable() {
       
       DefaultTableModel mode = new DefaultTableModel();
       mode.addColumn("ID");
       mode.addColumn("Tên Kỳ Thi");       
       mode.addColumn("Môn Thi");
       mode.addColumn("Ngày Bắt Đầu");
       mode.addColumn("Ngày Kết Thúc");
       mode.addColumn("Số Câu Hỏi") ;
       mode.addColumn("Thời Gian Thi");
       mode.addColumn("Số Lần Được Làm");
       mode.addColumn("Số Lượt Đã Thi");
       SimpleDateFormat sdf =   new SimpleDateFormat("dd-MM-yyyy");
       List<Object> listObject = mydao.getAllData(Exam.class);
       if (! listObject.isEmpty())
           for (int i=0;i< listObject.size();i++){
               Exam e = (Exam) listObject.get(i);
               Subject s = (Subject) Subject_Dao.getSubjectByID(e.getSubjectID());
               mode.addRow(new Object[]{e.getExamID(), e.getExamName() , s , sdf.format((e.getDateStart()).getTime()) , sdf.format((e.getDateEnd()).getTime()) , e.getNumberQuestion() ,e.getTimes() , e.getNumberOfTest() , e.getTotalOfTest()});
           }
       return mode; 
    }     
     
     
     
    public int getTotalTestOfExam(Exam e){
        List<Object> lst = mydao.getData1Field(ResultExam.class, "ExamID", e.getExamID());
        if (! lst.isEmpty())
           return lst.size();
        return 0;
    }
     
    public int getTotalTestExamOfUser(Exam e, Users u){
        List<ResultExam> lst = mydao.getData2Field(ResultExam.class, "ExamID", "UserID", e.getExamID(), u.getUserID());
        return lst.size();
    }
    
    public boolean insertExam(Exam u){
        return mydao.insertData(u);
    }
    
    public boolean updateExam(Exam u){
        return mydao.updateData(u);
    }
    
    public boolean removeExam(Long id){
        return mydao.removeData(Exam.class, id);
    }
     
}
