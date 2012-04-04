package vn.com.dva.backup;


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
public interface If_Database extends Remote{
    public Connection getConnect() throws RemoteException ;
//    public boolean Connect() throws RemoteException ;
    public boolean ConnectServer(String serverName,String userName,String password,String database,String serverChat) throws RemoteException ;
    
    
    
    
// --------------------- Table USERS ---------------------------------------    
    public boolean checkLogin(String user,String pass) throws RemoteException;
    public boolean checkUser(String user) throws RemoteException ;
    
    public Users getUserByID(Long id) throws RemoteException ;
    public Users getUserByUserName(String s) throws RemoteException ;
    public DefaultTableModel getAllUserToTable() throws RemoteException ;
    public List<Users> getAllUser() throws RemoteException;
    public boolean insertUser(Users u) throws RemoteException;
    public boolean updateUser(Users u) throws RemoteException;
    
    
//////////////////////////////////////////////////////////////////////////////////
////------------------------ Group ----------------------------------------------
    public List<GroupUser> getAllGroup() throws RemoteException;
    public GroupUser getGroupByID(Long id) throws RemoteException ;
    
    
    
//////////////////////////////////////////////////////////////////////////////////
////------------------------ Subject ---------------------------------------------- 
    public boolean checkSubject(String name) throws RemoteException ;
    
    public Subject getSubjectByID(Long id) throws RemoteException ;
    public DefaultTableModel getAllSubjectToTable() throws RemoteException ;
    public List<Subject> getAllSubject() throws RemoteException;
    public boolean insertSubject(Subject s) throws RemoteException;
    public boolean updateSubject(Subject s) throws RemoteException;
    public boolean removeSubject(Long id) throws RemoteException;
    
    
    
//////////////////////////////////////////////////////////////////////////////////
////------------------------ Level All ---------------------------------------------- 
    public boolean checkLevel(String name) throws RemoteException ;
    
    public LevelAll getLeveltByID(Long id) throws RemoteException ;
    public DefaultTableModel getAllLevelToTable() throws RemoteException ;
    public List<LevelAll> getAllLevel() throws RemoteException;
    public boolean insertLevel(LevelAll s) throws RemoteException;
    public boolean updateLevel(LevelAll s) throws RemoteException;
    public boolean removeLevel(Long id) throws RemoteException;
    
    
   
    
//////////////////////////////////////////////////////////////////////////////////
////------------------------ Question ---------------------------------------------- 
    public boolean checkQuestionName(String name) throws RemoteException ;    
    public Question getQuestiontByID(Long id) throws RemoteException ;
    public DefaultTableModel getAllQuestionToTable() throws RemoteException ;
    public List<Question> getAllQuestion() throws RemoteException;
    public List<Question> getAllQuestionBySubject(Long id) throws RemoteException;
    public boolean insertQuestion(Question s) throws RemoteException;
    public boolean updateQuestion(Question s) throws RemoteException;
    public boolean removeQuestion(Long id) throws RemoteException;
    
    
    
//////////////////////////////////////////////////////////////////////////////////
////------------------------ Exam ---------------------------------------------- 
    public boolean checkExamName(String name) throws RemoteException ;    
    public Exam getExamByID(Long id) throws RemoteException ;
    public DefaultTableModel getAllExamToTable() throws RemoteException ;
    public List<Exam> getAllExam() throws RemoteException;
    public List<Exam> getCurrentExam() throws RemoteException ;
    public boolean insertExam(Exam e) throws RemoteException;
    public boolean updateExam(Exam s) throws RemoteException;
    public boolean removeExam(Long id) throws RemoteException;    
    
//////////////////////////////////////////////////////////////////////////////////
////------------------------  Exam Question ----------------------------------------------     
    public List<Exam_Question> getAllExamQuestion() throws RemoteException;
    public Exam_Question getExamQuestionByID(Long id) throws RemoteException ;
    public Exam_Question getExamQuestionByExamQuestion(Long id1,Long id2) throws RemoteException ;
    public List<Exam_Question> getAllExamQuestionByExam(Long id) throws RemoteException;
    public List<Question> getListQuestionByExam(Long id ,int n) throws RemoteException;
    public List<Question> getListQuestionBySubject(Long id , int n) throws RemoteException;
    public boolean insertExamQuestion(Exam_Question eq) throws RemoteException ;
    public boolean upadateExamQuestion(Exam_Question eq) throws RemoteException ;
    public boolean removeExamQuestion(Long id) throws RemoteException ;
    
    
//////////////////////////////////////////////////////////////////////////////////
////------------------------ Train ---------------------------------------------- 
    public Train getTrainByID(Long id) throws RemoteException ;
    public DefaultTableModel getAllTrainToTable() throws RemoteException ;
    public DefaultTableModel getAllTraintoTableByIdUser(Long id) throws RemoteException;
    public List<Train> getAllTrain() throws RemoteException;
    public boolean insertTrain(Train t) throws RemoteException;
    public Train insertTrainGetId(Train t) throws RemoteException;
    public boolean updateTrain(Train t) throws RemoteException;
    public boolean removeTrain(Long id) throws RemoteException;    
    
    
//////////////////////////////////////////////////////////////////////////////////
////------------------------ DetailTrain ---------------------------------------------- 
    public DetailTrain getDetailTrainByID(Long id) throws RemoteException ;
    public DetailTrain getDetailTrainByTrainID(Long id) throws RemoteException ;
    public List<DetailTrain> getAllDetailTrain() throws RemoteException;
    public boolean insertDetailTrain(DetailTrain t) throws RemoteException;
    public boolean updateDetailTrain(DetailTrain t) throws RemoteException;
    public boolean removeDetailTrain(Long id) throws RemoteException;    
            
//////////////////////////////////////////////////////////////////////////////////
////------------------------ ResultExam ---------------------------------------------- 
    public ResultExam getResultExamByID(Long id) throws RemoteException ;
    public ResultExam getResultExamByExam(Long id) throws RemoteException ;    
    public List<ResultExam> getAllResultExamByExamID(Long id) throws RemoteException ;
    public List<ResultExam> getAllResultExamByExamIDSortScore(Long id)  throws RemoteException ;
    public DefaultTableModel getAllExamtoTableByIdUser(Long id) throws RemoteException;
    public List<ResultExam> getAllResultExam() throws RemoteException;
    public List<ResultExam> getAllResultExamByID(Long id) throws RemoteException;
    public ResultExam insertResultExam(ResultExam t) throws RemoteException;
    public boolean updateResultExam(ResultExam t) throws RemoteException;
    public boolean removeResultExam(Long id) throws RemoteException;        
    
    
//////////////////////////////////////////////////////////////////////////////////
////------------------------ DetailResultExam ---------------------------------------------- 
    public DetailResultExam getDetailResultExamByID(Long id) throws RemoteException ;
    public DetailResultExam getDetailResultExamByResultExamID(Long id) throws RemoteException ;
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
     
    
    
         
     
     
     
     
     
     
 // Lay ra tên môn học khi co mã môn học
    public String getMonHoc(String id) throws RemoteException ;
    // Lay ra user name khi co id
    public String getUser(String id) throws RemoteException;
    //Lấy ra nguyên bảng môn học
     public DefaultTableModel getMonHoctoTable(int limit) throws RemoteException;
    // Lấy ra nguyên bảng câu hỏi
     public DefaultTableModel getCauHoitoTable(int limit) throws RemoteException ;
    // Lấy ra danh sách ky thi
    public DefaultTableModel getKyThitoTable(int limit) throws RemoteException ;
    // Lấy ra danh sách độ khó
    public DefaultTableModel getDoKhotoTable (int limit) throws RemoteException ;
    // Lấy ra danh sach cac tài khoản
    public DefaultTableModel getTaiKhoanAdmintoTable(int limit) throws RemoteException ;
    public DefaultTableModel getTaiKhoanGiaVientoTable(int limit) throws RemoteException ;
    public DefaultTableModel getTaiKhoanSinhVientoTable(int limit) throws RemoteException ;
    // Lay ket qua thi
     public DefaultTableModel getLichSuThi(String id) throws RemoteException ;



    
    public String getIDUser(String username) throws RemoteException ;
    public String getIdMonHoc(String tenmonhoc) throws RemoteException;
    // Them mon hoc
    public boolean checkMonHoc(String name) throws RemoteException ;
    public boolean addMonHoc(String name, String status) throws RemoteException ;
    //Chức năng sửa tên môn học, đầu là id môn
     public boolean editMon(String id, String newMon,String trangthai)throws RemoteException;
    // Duyet mon hoc
     public boolean approveMon(String id ,String status) throws RemoteException ;
     // Xoa mon hoc
     public boolean deleteMon(String id) throws RemoteException ;
     // Thêm kỳ thi
     public boolean addKyThi(String tenkythi,String idDoKho ,String ngaybd ,String thoigian, String ngaykt,String idMonHoc,String soluotlam)throws RemoteException ;
     // Sửa Kỳ thi
     public boolean editKyThi(String id, String tenkythi,String idDoKho ,String ngaybd ,String thoigian, String ngaykt,String idMonHoc,String soluotlam)throws RemoteException ;
     // Xóa kỳ thi
     public boolean deleteKyThi(String id) throws RemoteException ;
     // Thêm độ khó
     public boolean addDoKho(String tendokho,String de,String tb, String kho) throws RemoteException;
     // Sửa độ khó
     public boolean editDoKho (String id , String tendokho ,String de , String tb ,String kho) throws RemoteException;
     // Xóa độ khó
     public boolean deleteDoKho (String id) throws RemoteException ;
     // Them tai khoan nguoi dung
     public boolean addTaiKhoan(String user,String pass ,String quyenhan,String ok,String hoten,String ngaysinh,String diachi,String lop) throws RemoteException ;
     public boolean addTaiKhoanFull(String user,String pass ,String quyenhan,String ok,String hoten,String ngaysinh,String diachi,String lop,String cauhoi,String traloi) throws RemoteException ;
     // Sua thong tin nguoi dung
     public boolean editTaiKhoan(String id,String user,String pass ,String quyenhan,String ok,String hoten,String ngaysinh,String diachi,String lop) throws RemoteException ;
     // Xoa tai khoan
     public boolean deleteTaiKhoan(String id) throws RemoteException ;
     // Doi trang thai tai khoan
     public boolean updateTrangThaiTK(String id) throws RemoteException ;
     // Kiem tra cau hoi bí mật
     public boolean checkCauHoiBiMat(String id , String cauhoi,String traloi) throws RemoteException ;
     // doi mat khau cho tk
     public boolean changeMatKhau(String id ,String mk) throws RemoteException ;

     // Lay ten cac mon hoc
     public String[] getMonHoc() throws RemoteException ;
     // Lay do kho
     public String[] getDoKho() throws RemoteException ;
     // Lay ti le cau hoi tu do kho
     public String getItemDoKho(String name, int item) throws RemoteException ;
     public String getItemDoKhoID(String id, int item) throws RemoteException ;
     // Lay thong tin bang ky thi
     public String getItemKyThiID(String id, int item) throws RemoteException ;
     public String getItemKyThi(String name, int item) throws RemoteException ;
     // Lay thong tin bang mon hoc
     public String getItemMonHoc(String name, int item) throws RemoteException;
     public String getItemMonHocID(String id, int item) throws RemoteException;
     // lay thong tin bang dang nhap, ho so
     public String getItemDangNhapID(String id, int item) throws RemoteException;
     public String getItemHoSoIDUser(String id, int item) throws RemoteException;
     public String getItemCauHoiID(String id , int item) throws RemoteException ;
     public boolean checkUsername(String user) throws RemoteException ;
     // Lay thong tin bang kythi-cauhoi
     public int getCountCauHoiFromKyThi(String id) throws RemoteException ;

     // Them 1 cau hoi
     public boolean addCauHoi(String username ,String monhoc , int dokho, String noidung , String dapan , String caua,String caub,String cauc, String caud) throws RemoteException;


     // Cau hoi
     public String[] getCauHoiToArray(int item) throws RemoteException ;
     public String[] getCauHoiMonHocToArray(String idMonHoc,int item) throws RemoteException ;
     public String[] getIdCauHoi(String idMon ,int limit) throws RemoteException ;
     public String[] getIdCauHoiKyThi(String id) throws RemoteException ;
     
     public String[] getMonHocToArray(int item) throws RemoteException ;

     // Thong tin ky thi
     public String[] getKyThiToArray(int item) throws RemoteException ;
     public String[] getItemKyThiDienRa(int item) throws RemoteException ;
     public String[] getKyThiCauHoiID(String id,int item) throws RemoteException ;
     public String getItemKyThiCauHoiID(String id,int item) throws RemoteException ;
     // Ky thi cau hoi
     public boolean checkKyThiCauHoi(String idKyThi, String idCauHoi) throws RemoteException ;
     public boolean addKyThiCauHoi(String idKyThi, String idCauHoi) throws RemoteException ;
     public boolean deleteKyThiCauHoi(String id) throws RemoteException ;
}
