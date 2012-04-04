/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import vn.com.dva.entities.Exam_Question;
import vn.com.dva.entities.Question;
import vn.com.dva.generic.spi.MyGeneric;

/**
 *
 * @author VietAnh
 */
public class Exam_Question_DAO {
    MyGeneric mydao = new MyGeneric();
    Exam_DAO Exam_Dao = new Exam_DAO();
    public Exam_Question_DAO(){
        
    }
 
    public List<Exam_Question> getAllExamQuestion(){
        List<Object> listObject = mydao.getAllData(Exam_Question.class);
        List<Exam_Question> list = new ArrayList<Exam_Question>();
        if (!listObject.isEmpty())
        for (int i=0;i< listObject.size() ; i++ ){
            list.add((Exam_Question) listObject.get(i));
        }
        return list;
    }
    
    public Exam_Question getExamQuestionByID(Long id){
         List<Object> list= new ArrayList<Object> ();
        list = mydao.getData1Field(Exam_Question.class, "ExamQuestionID", id);
        if (!list.isEmpty()){
            return (Exam_Question)list.get(0);
        }
        return new Exam_Question();
    }
    
    public Exam_Question getExamQuestionByExamQuestion(Long id1,Long id2){
         List<Object> list= new ArrayList<Object> ();
        list = mydao.getData2Field(Exam_Question.class, "ExamID", "QuestionID",id1,id2);
        if (!list.isEmpty()){
            return (Exam_Question)list.get(0);
        }
        return null;
    }
    
    public List<Question> getListQuestionByExam(Long id ,int n){
        List<Question> list = new ArrayList<Question>();
        Random r = new Random();
        List<Exam_Question> listQuestion = this.getAllExamQuestionByExam(id);
        List<Integer> listRandom = new ArrayList<Integer>();
        if (listQuestion.size() < n) return null;
        while (list.size() < n ){
            int i = r.nextInt(listQuestion.size()-1)+1;
            if (!listRandom.contains(i)){
                listRandom.add(i);
                list.add(new Question_DAO().getQuestionByID(listQuestion.get(i).getQuestionID()));
            }
        }
        return list;
    }
    
    
    
    public List<Question> getListQuestionBySubject(Long id , int n){
        List<Question> list = new ArrayList<Question>();
        Random r = new Random();
        List<Question> listQuestion = new Question_DAO().getAllQuestionBySubject(id);
        List<Integer> listRandom = new ArrayList<Integer>();
        if (listQuestion.size() < n) return null;
        while (list.size() != n ){
            int i = r.nextInt(listQuestion.size());
            if (!listRandom.contains(i)){
                listRandom.add(i);
                list.add(listQuestion.get(i));
            }
        }
        return list;
    }
    
    public List<Exam_Question> getAllExamQuestionByExam(Long id){
        List<Object> listObject = mydao.getData1Field(Exam_Question.class, "ExamID",id);
        List<Exam_Question> list = new ArrayList<Exam_Question>();
        if (!listObject.isEmpty())
        for (int i=0;i< listObject.size() ; i++ ){
            list.add((Exam_Question) listObject.get(i));
        }
        return list;
    }
    
    
    public boolean insertExamQuestion(Exam_Question eq){
        return mydao.insertData(eq);
    }
    
    public boolean upadateExamQuestion(Exam_Question eq){
        return mydao.updateData(eq);
    }
    
    public boolean removeExamQuestion(Long id){
        return mydao.removeData(Exam_Question.class, id);
    }
    
}
