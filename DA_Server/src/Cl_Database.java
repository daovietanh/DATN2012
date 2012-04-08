
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vn.com.dva.dao.DetailResultExam_DAO;
import vn.com.dva.dao.DetailTrain_DAO;
import vn.com.dva.dao.Exam_DAO;
import vn.com.dva.dao.Exam_Question_DAO;
import vn.com.dva.dao.Group_DAO;
import vn.com.dva.dao.Level_DAO;
import vn.com.dva.dao.News_DAO;
import vn.com.dva.dao.Question_DAO;
import vn.com.dva.dao.ResultExam_DAO;
import vn.com.dva.dao.Subject_DAO;
import vn.com.dva.dao.Train_DAO;
import vn.com.dva.dao.Users_DAO;
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


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author VietAnh
 */
public class Cl_Database implements If_Database {

    private Connection conn;
    private Users_DAO userDAO = new Users_DAO();
    private Group_DAO groupDAO = new Group_DAO();
    private Subject_DAO subjectDAO = new Subject_DAO();
    private Level_DAO levelDAO = new Level_DAO();
    private Question_DAO QuestionDAO = new Question_DAO();
    private Exam_DAO examDAO = new Exam_DAO();
    private Exam_Question_DAO eqDAO = new Exam_Question_DAO();
    private Train_DAO trainDAO = new Train_DAO();
    private DetailTrain_DAO detailTrainDAO = new DetailTrain_DAO();
    private ResultExam_DAO resultExamDAO = new ResultExam_DAO();
    private DetailResultExam_DAO detailResultExamDAO = new DetailResultExam_DAO();
    private News_DAO newsDao = new News_DAO();

    @Override
    public Connection getConnect() throws RemoteException {
        return conn;
    }

    @Override
    public List<Object> getAllData(Class T) throws RemoteException {
        return subjectDAO.getAllData(T);
    }

    @Override
    public boolean insertAllData(Object o) throws RemoteException {
        return subjectDAO.insertAllData(o);
    }

    @Override
    public boolean ConnectServer(String serverName, String userName, String password, String database, String serverChat) throws RemoteException {
        try {
            String url = "jdbc:h2:tcp://" + serverName + "/" + "~/" + database;
            Class.forName("org.h2.Driver").newInstance();
            conn = (Connection) DriverManager.getConnection(url, userName, password);
            System.out.print("\n Server gui tra thong diep bao ket noi thanh cong aaaa");
        } catch (Exception e) {
            System.out.print("Server khong ket noi dc");
            return false;
        }
        return true;
    }

//    @Override
//    public boolean Connect() throws RemoteException {
//        try {
//            //String url = "jdbc:mysql://localhost:3306/tnol?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
//            String url = "jdbc:h2:tcp://localhost/~/TESTONLINE";
//            //String url = "jdbc:h2:tcp://"+serverName+"/"+"~"+ database;
//            Class.forName("org.h2.Driver").newInstance();
//            conn = (Connection) DriverManager.getConnection(url, "sa", "");
//            //conn = (Connection) DriverManager.getConnection (url,userName,password);
//            System.out.print("\n Server gui tra thong diep bao ket noi thanh cong ");
//            return true;
//        } catch (Exception e) {
//            System.out.print("Server khong ket noi dc");
//            return false;
//        }
//    }
/////////////////////////////////////////////////////////////////////////////////////////////
// --------------------------------  table User ------------------------------------------    
    @Override
    public boolean checkLogin(String user, String pass) throws RemoteException {
        return userDAO.checkLogin(user, pass);
    }

    @Override
    public boolean checkUser(String user) throws RemoteException {
        return userDAO.checkUserName(user);
    }

    @Override
    public Users getUserByID(Long id) throws RemoteException {
        return userDAO.getUserByID(id);
    }

    @Override
    public Users getUserByUserName(String s) throws RemoteException {
        return userDAO.getUserByUserName(s);
    }

    @Override
    public DefaultTableModel getAllUserToTable() throws RemoteException {
        return userDAO.getAllUserstoTable();
    }

    @Override
    public List<Users> getAllUser() throws RemoteException {
        return userDAO.getAllUser();
    }

    @Override
    public boolean insertUser(Users u) throws RemoteException {
        return userDAO.insertUser(u);
    }

    @Override
    public boolean updateUser(Users u) throws RemoteException {
        return userDAO.updateUser(u);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// --------------------------------  table Group ------------------------------------------    
    @Override
    public List<GroupUser> getAllGroup() throws RemoteException {
        return groupDAO.getAllGroup();
    }
    
    
    @Override
    public DefaultTableModel getAllGroupUsertoTable() throws RemoteException {
        return groupDAO.getAllGroupUsertoTable();
    }

    @Override
    public GroupUser getGroupByID(Long id) throws RemoteException {
        return groupDAO.getGroupByID(id);
    }
    
    @Override
    public boolean checkNameGroup(String s) throws RemoteException {
        return groupDAO.checkNameGroup(s);
    }
    
        @Override
    public boolean insertGroupUser(GroupUser s) throws RemoteException {
        return groupDAO.insertGroupUser(s);
    }
    
    @Override
    public boolean updateGroupUser(GroupUser s) throws RemoteException {
        return groupDAO.updateGroupUser(s);
    }



    @Override
    public boolean removeGroupUser(Long id) throws RemoteException {
        return groupDAO.removeGroupUser(id);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// --------------------------------  table Subject  ------------------------------------------      
    @Override
    public boolean checkSubject(String name) throws RemoteException {
        return subjectDAO.checkSubjectName(name);
    }

    @Override
    public Subject getSubjectByID(Long id) throws RemoteException {
        return subjectDAO.getSubjectByID(id);
    }

    @Override
    public DefaultTableModel getAllSubjectToTable() throws RemoteException {
        return subjectDAO.getAllSubjecttoTable();
    }

    @Override
    public boolean insertSubject(Subject s) throws RemoteException {
        return subjectDAO.insertUser(s);
    }

    @Override
    public boolean updateSubject(Subject s) throws RemoteException {
        return subjectDAO.updateUser(s);
    }

    @Override
    public List<Subject> getAllSubject() throws RemoteException {
        return subjectDAO.getAllSubject();
    }

    @Override
    public boolean removeSubject(Long id) throws RemoteException {
        return subjectDAO.removeUser(id);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// --------------------------------  table  Level All  ------------------------------------------        
    @Override
    public boolean checkLevel(String name) throws RemoteException {
        return levelDAO.checkLevelName(name);
    }

    @Override
    public LevelAll getLeveltByID(Long id) throws RemoteException {
        return levelDAO.getLevelByID(id);
    }

    @Override
    public DefaultTableModel getAllLevelToTable() throws RemoteException {
        return levelDAO.getAllLeveltoTable();
    }

    @Override
    public List<LevelAll> getAllLevel() throws RemoteException {
        return levelDAO.getAllLevel();
    }

    @Override
    public boolean insertLevel(LevelAll s) throws RemoteException {
        return levelDAO.insertLevel(s);
    }

    @Override
    public boolean updateLevel(LevelAll s) throws RemoteException {
        return levelDAO.updateLevel(s);
    }

    @Override
    public boolean removeLevel(Long id) throws RemoteException {
        return levelDAO.removeLevel(id);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// --------------------------------  table Question  ------------------------------------------        
    @Override
    public boolean checkQuestionName(String name) throws RemoteException {
        return QuestionDAO.checkQuestionName(name);
    }

    @Override
    public Question getQuestiontByID(Long id) throws RemoteException {
        return QuestionDAO.getQuestionByID(id);
    }

    @Override
    public DefaultTableModel getAllQuestionToTable() throws RemoteException {
        return QuestionDAO.getAllQuestiontoTable();
    }

    @Override
    public List<Question> getAllQuestion() throws RemoteException {
        return QuestionDAO.getAllQuestion();
    }

    @Override
    public List<Question> getAllQuestionBySubject(Long id) throws RemoteException {
        return QuestionDAO.getAllQuestionBySubject(id);
    }

    @Override
    public boolean insertQuestion(Question s) throws RemoteException {
        return QuestionDAO.insertQuestion(s);
    }

    @Override
    public boolean updateQuestion(Question s) throws RemoteException {
        return QuestionDAO.updateQuestion(s);
    }

    @Override
    public boolean removeQuestion(Long id) throws RemoteException {
        return QuestionDAO.removeQuestion(id);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// --------------------------------  table Exam  ------------------------------------------        
    @Override
    public boolean checkExamName(String name) throws RemoteException {
        return examDAO.checkExamName(name);
    }

    @Override
    public Exam getExamByID(Long id) throws RemoteException {
        return examDAO.getExamByID(id);
    }

    @Override
    public DefaultTableModel getAllExamToTable() throws RemoteException {
        return examDAO.getAllSubjecttoTable();
    }

    @Override
    public List<Exam> getAllExam() throws RemoteException {
        return examDAO.getAllExam();
    }

    @Override
    public List<Exam> getCurrentExam() throws RemoteException {
        return examDAO.getCurrentExam();
    }

    @Override
    public boolean insertExam(Exam e) throws RemoteException {
        return examDAO.insertExam(e);
    }

    @Override
    public boolean updateExam(Exam s) throws RemoteException {
        return examDAO.updateExam(s);
    }

    @Override
    public boolean removeExam(Long id) throws RemoteException {
        return examDAO.removeExam(id);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// --------------------------------  table Exam Question  ------------------------------------------        
    @Override
    public List<Exam_Question> getAllExamQuestion() throws RemoteException {
        return eqDAO.getAllExamQuestion();
    }

    @Override
    public Exam_Question getExamQuestionByID(Long id) throws RemoteException {
        return eqDAO.getExamQuestionByID(id);
    }

    @Override
    public Exam_Question getExamQuestionByExamQuestion(Long id1, Long id2) {
        return eqDAO.getExamQuestionByExamQuestion(id1, id2);
    }

    @Override
    public List<Exam_Question> getAllExamQuestionByExam(Long id) throws RemoteException {
        return eqDAO.getAllExamQuestionByExam(id);
    }

    @Override
    public List<Question> getListQuestionByExam(Long id, int n) throws RemoteException {
        return eqDAO.getListQuestionByExam(id, n);
    }

    @Override
    public List<Question> getListQuestionBySubject(Long id, int n) throws RemoteException {
        return eqDAO.getListQuestionBySubject(id, n);
    }

    @Override
    public boolean insertExamQuestion(Exam_Question eq) throws RemoteException {
        return eqDAO.insertExamQuestion(eq);
    }

    @Override
    public boolean upadateExamQuestion(Exam_Question eq) throws RemoteException {
        return eqDAO.upadateExamQuestion(eq);
    }

    @Override
    public boolean removeExamQuestion(Long id) throws RemoteException {
        return eqDAO.removeExamQuestion(id);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// --------------------------------  table Train  ------------------------------------------ 
    @Override
    public Train getTrainByID(Long id) throws RemoteException {
        return trainDAO.getTrainByID(id);
    }

    @Override
    public DefaultTableModel getAllTraintoTableByIdUser(Long id) throws RemoteException {
        return trainDAO.getAllTraintoTableByIdUser(id);
    }

    @Override
    public DefaultTableModel getAllTrainToTable() throws RemoteException {
        return trainDAO.getAllTraintoTableByIdUser(null);
    }

    @Override
    public List<Train> getAllTrain() throws RemoteException {
        return trainDAO.getAllTrain();
    }

    @Override
    public boolean insertTrain(Train t) throws RemoteException {
        return trainDAO.insertTrain(t);
    }

    @Override
    public Train insertTrainGetId(Train t) throws RemoteException {
        return trainDAO.insertTrainGetId(t);
    }

    @Override
    public boolean updateTrain(Train t) throws RemoteException {
        return trainDAO.updateTrain(t);
    }

    @Override
    public boolean removeTrain(Long id) throws RemoteException {
        return trainDAO.removeTrain(id);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// --------------------------------  table Detail Train  ------------------------------------------ 
    @Override
    public DetailTrain getDetailTrainByID(Long id) throws RemoteException {
        return detailTrainDAO.getDetailTrainByID(id);
    }

    @Override
    public DetailTrain getDetailTrainByTrainID(Long id) throws RemoteException {
        return detailTrainDAO.getDetailTrainByTrainID(id);
    }

    @Override
    public List<DetailTrain> getAllDetailTrain() throws RemoteException {
        return detailTrainDAO.getAllDetailTrain();
    }

    @Override
    public boolean insertDetailTrain(DetailTrain e) throws RemoteException {
        return detailTrainDAO.insertDetailTrain(e);
    }

    @Override
    public boolean updateDetailTrain(DetailTrain s) throws RemoteException {
        return detailTrainDAO.updateDetailTrain(s);
    }

    @Override
    public boolean removeDetailTrain(Long id) throws RemoteException {
        return detailTrainDAO.removeDetailTrain(id);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// --------------------------------  table Result Exam  ------------------------------------------ 
    @Override
    public ResultExam getResultExamByID(Long id) throws RemoteException {
        return resultExamDAO.getResultExamByID(id);
    }

    @Override
    public ResultExam getResultExamByExam(Long id) throws RemoteException {
        return resultExamDAO.getResultExamByExam(id);
    }

    @Override
    public List<ResultExam> getAllResultExamByExamID(Long id) throws RemoteException {
        return resultExamDAO.getAllResultExamByExamID(id);
    }

    public List<ResultExam> getAllResultExamByExamIDSortScore(Long id) throws RemoteException {
        return resultExamDAO.getAllResultExamByExamIDSortScore(id);
    }

    @Override
    public DefaultTableModel getAllExamtoTableByIdUser(Long id) throws RemoteException {
        return resultExamDAO.getAllExamtoTableByIdUser(id);
    }

    @Override
    public List<ResultExam> getAllResultExam() throws RemoteException {
        return resultExamDAO.getAllResultExam();
    }

    public List<ResultExam> getAllResultExamByID(Long id) throws RemoteException {
        return resultExamDAO.getAllResultExamByUserID(id);
    }

    @Override
    public ResultExam insertResultExam(ResultExam t) throws RemoteException {
        return resultExamDAO.insertResultExam(t);
    }

    @Override
    public boolean updateResultExam(ResultExam t) throws RemoteException {
        return resultExamDAO.updateResultExam(t);
    }

    @Override
    public boolean removeResultExam(Long id) throws RemoteException {
        return resultExamDAO.removeResultExam(id);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// --------------------------------  table Detail Result Exam  ------------------------------------------ 
    @Override
    public DetailResultExam getDetailResultExamByID(Long id) throws RemoteException {
        return detailResultExamDAO.getDetailResultExamByID(id);
    }

    @Override
    public DetailResultExam getDetailResultExamByResultExamID(Long id) throws RemoteException {
        return detailResultExamDAO.getDetailResultExamByResultExamID(id);
    }

    @Override
    public List<DetailResultExam> getAllDetailResultExam() throws RemoteException {
        return detailResultExamDAO.getAllDetailDetailResultExam();
    }

    @Override
    public boolean insertDetailResultExam(DetailResultExam t) throws RemoteException {
        return detailResultExamDAO.insertDetailResultExam(t);
    }

    @Override
    public boolean updateDetailResultExam(DetailResultExam t) throws RemoteException {
        return detailResultExamDAO.updateDetailResultExam(t);
    }

    @Override
    public boolean removeDetailResultExam(Long id) throws RemoteException {
        return detailResultExamDAO.removeDetailResultExam(id);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// --------------------------------  table New  ------------------------------------------ 
    @Override
    public List<News> getListNews(int n) throws RemoteException {
        return newsDao.getListNews(n);
    }

    @Override
    public List<News> getAllNews() throws RemoteException {
        return newsDao.getAllNews();
    }

    @Override
    public boolean insertNews(News n) throws RemoteException {
        return newsDao.insertNews(n);
    }

    @Override
    public boolean updateNews(News n) throws RemoteException {
        return newsDao.updateNews(n);
    }

    @Override
    public boolean removeNews(Long id) throws RemoteException {
        return newsDao.removeNews(id);
    }
/////////////////////////////////////////////////////////////////////////////////////////////
// --------------------------------  table New  ------------------------------------------ 
}