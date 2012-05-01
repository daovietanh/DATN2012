
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vn.com.dva.entities.DetailResultExam;
import vn.com.dva.entities.DetailTrain;
import vn.com.dva.entities.Exam;
import vn.com.dva.entities.Exam_Question;
import vn.com.dva.entities.GroupUser;
import vn.com.dva.entities.LevelAll;
import vn.com.dva.entities.News;
import vn.com.dva.entities.Question;
import vn.com.dva.entities.ResultExam;
import vn.com.dva.entities.Subject;
import vn.com.dva.entities.Train;
import vn.com.dva.entities.Users;
import vn.com.dva.entities.config;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author VietAnh
 */
public interface If_Database extends Remote {

    public Connection getConnect() throws RemoteException;
//    public boolean Connect() throws RemoteException ;

    public boolean ConnectServer(String serverName, String userName, String password, String database, String serverChat) throws RemoteException;

    public List<Object> getAllData(Class T) throws RemoteException;

    public boolean insertAllData(Object o) throws RemoteException;

// --------------------- Table USERS ---------------------------------------    
    public boolean checkLogin(String user, String pass) throws RemoteException;

    public boolean checkUser(String user) throws RemoteException;

    public boolean dropAllTable() throws RemoteException;

    public Users getUserByID(Long id) throws RemoteException;

    public Users getUserByUserName(String s) throws RemoteException;

    public DefaultTableModel getAllUserToTable() throws RemoteException;

    public List<Users> getAllUser() throws RemoteException;

    public boolean insertUser(Users u) throws RemoteException;

    public boolean updateUser(Users u) throws RemoteException;

//////////////////////////////////////////////////////////////////////////////////
////------------------------ Group ----------------------------------------------
    public List<GroupUser> getAllGroup() throws RemoteException;

    public GroupUser getGroupByID(Long id) throws RemoteException;

    public boolean checkNameGroup(String s) throws RemoteException;

    public DefaultTableModel getAllGroupUsertoTable() throws RemoteException;

    public boolean insertGroupUser(GroupUser s) throws RemoteException;

    public boolean updateGroupUser(GroupUser s) throws RemoteException;

    public boolean removeGroupUser(Long id) throws RemoteException;

//////////////////////////////////////////////////////////////////////////////////
////------------------------ Subject ---------------------------------------------- 
    public boolean checkSubject(String name) throws RemoteException;

    public Subject getSubjectByID(Long id) throws RemoteException;

    public DefaultTableModel getAllSubjectToTable() throws RemoteException;

    public List<Subject> getAllSubject() throws RemoteException;

    public boolean insertSubject(Subject s) throws RemoteException;

    public boolean updateSubject(Subject s) throws RemoteException;

    public boolean removeSubject(Long id) throws RemoteException;

//////////////////////////////////////////////////////////////////////////////////
////------------------------ Level All ---------------------------------------------- 
    public boolean checkLevel(String name) throws RemoteException;

    public LevelAll getLeveltByID(Long id) throws RemoteException;

    public DefaultTableModel getAllLevelToTable() throws RemoteException;

    public List<LevelAll> getAllLevel() throws RemoteException;

    public boolean insertLevel(LevelAll s) throws RemoteException;

    public boolean updateLevel(LevelAll s) throws RemoteException;

    public boolean removeLevel(Long id) throws RemoteException;

//////////////////////////////////////////////////////////////////////////////////
////------------------------ Question ---------------------------------------------- 
    public boolean checkQuestionName(String name) throws RemoteException;

    public Question getQuestiontByID(Long id) throws RemoteException;

    public DefaultTableModel getAllQuestionToTable() throws RemoteException;

    public List<Question> getAllQuestion() throws RemoteException;

    public List<Question> getAllQuestionBySubject(Long id) throws RemoteException;

    public boolean insertQuestion(Question s) throws RemoteException;

    public boolean updateQuestion(Question s) throws RemoteException;

    public boolean removeQuestion(Long id) throws RemoteException;

//////////////////////////////////////////////////////////////////////////////////
////------------------------ Exam ---------------------------------------------- 
    public boolean checkExamName(String name) throws RemoteException;

    public Exam getExamByID(Long id) throws RemoteException;

    public DefaultTableModel getAllExamToTable() throws RemoteException;

    public List<Exam> getAllExam() throws RemoteException;

    public List<Exam> getCurrentExam() throws RemoteException;

    public int getTotalTestOfExam(Exam e) throws RemoteException;

    public int getTotalTestExamOfUser(Exam e, Users u) throws RemoteException;

    public boolean insertExam(Exam e) throws RemoteException;

    public boolean updateExam(Exam s) throws RemoteException;

    public boolean removeExam(Long id) throws RemoteException;

//////////////////////////////////////////////////////////////////////////////////
////------------------------  Exam Question ----------------------------------------------     
    public List<Exam_Question> getAllExamQuestion() throws RemoteException;

    public Exam_Question getExamQuestionByID(Long id) throws RemoteException;

    public Exam_Question getExamQuestionByExamQuestion(Long id1, Long id2) throws RemoteException;

    public List<Exam_Question> getAllExamQuestionByExam(Long id) throws RemoteException;

    public List<Question> getListQuestionByExam(Long id, int n) throws RemoteException;

    public List<Question> getListQuestionBySubject(Long id, int n) throws RemoteException;

    public boolean insertExamQuestion(Exam_Question eq) throws RemoteException;

    public boolean upadateExamQuestion(Exam_Question eq) throws RemoteException;

    public boolean removeExamQuestion(Long id) throws RemoteException;

//////////////////////////////////////////////////////////////////////////////////
////------------------------ Train ---------------------------------------------- 
    public Train getTrainByID(Long id) throws RemoteException;

    public DefaultTableModel getAllTrainToTable() throws RemoteException;

    public DefaultTableModel getAllTraintoTableByIdUser(Long id) throws RemoteException;

    public List<Train> getAllTrain() throws RemoteException;

    public boolean insertTrain(Train t) throws RemoteException;

    public Train insertTrainGetId(Train t) throws RemoteException;

    public boolean updateTrain(Train t) throws RemoteException;

    public boolean removeTrain(Long id) throws RemoteException;

//////////////////////////////////////////////////////////////////////////////////
////------------------------ DetailTrain ---------------------------------------------- 
    public DetailTrain getDetailTrainByID(Long id) throws RemoteException;

    public DetailTrain getDetailTrainByTrainID(Long id) throws RemoteException;

    public List<DetailTrain> getAllDetailTrain() throws RemoteException;

    public boolean insertDetailTrain(DetailTrain t) throws RemoteException;

    public boolean updateDetailTrain(DetailTrain t) throws RemoteException;

    public boolean removeDetailTrain(Long id) throws RemoteException;

//////////////////////////////////////////////////////////////////////////////////
////------------------------ ResultExam ---------------------------------------------- 
    public ResultExam getResultExamByID(Long id) throws RemoteException;

    public ResultExam getResultExamByExam(Long id) throws RemoteException;

    public List<ResultExam> getAllResultExamByExamID(Long id) throws RemoteException;

    public List<ResultExam> getAllResultExamByExamIDSortScore(Long id) throws RemoteException;

    public DefaultTableModel getAllExamtoTableByIdUser(Long id) throws RemoteException;

    public List<ResultExam> getAllResultExam() throws RemoteException;

    public List<ResultExam> getAllResultExamByID(Long id) throws RemoteException;

    public ResultExam insertResultExam(ResultExam t) throws RemoteException;

    public boolean updateResultExam(ResultExam t) throws RemoteException;

    public boolean removeResultExam(Long id) throws RemoteException;

//////////////////////////////////////////////////////////////////////////////////
////------------------------ DetailResultExam ---------------------------------------------- 
    public DetailResultExam getDetailResultExamByID(Long id) throws RemoteException;

    public DetailResultExam getDetailResultExamByResultExamID(Long id) throws RemoteException;

    public List<DetailResultExam> getAllDetailResultExam() throws RemoteException;

    public boolean insertDetailResultExam(DetailResultExam t) throws RemoteException;

    public boolean updateDetailResultExam(DetailResultExam t) throws RemoteException;

    public boolean removeDetailResultExam(Long id) throws RemoteException;

//////////////////////////////////////////////////////////////////////////////////
////------------------------ News ---------------------------------------------- 
    public List<News> getListNews(int n) throws RemoteException;

    public List<News> getAllNews() throws RemoteException;

    public boolean insertNews(News n) throws RemoteException;

    public boolean updateNews(News n) throws RemoteException;

    public boolean removeNews(Long id) throws RemoteException;
 
//////////////////////////////////////////////////////////////////////////////////
////------------------------ Online ----------------------------------------------    
    
    public void addUserOnline(Long id) throws RemoteException ;
    
    public void removeUserOnline(Long id) throws RemoteException ;
    
    public List<Long> getAllUserOnline() throws RemoteException ;
    
    public List<Boolean> getAllIsChat() throws RemoteException ;    
    
    public void banChat(Long id) throws RemoteException ;
    
    public void allowChat(Long id) throws RemoteException ;
}
