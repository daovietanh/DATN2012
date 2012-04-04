/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.dva.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vn.com.dva.entities.Exam;
import vn.com.dva.entities.LevelAll;
import vn.com.dva.entities.ResultExam;
import vn.com.dva.entities.Subject;
import vn.com.dva.generic.spi.MyGeneric;

/**
 *
 * @author VietAnh
 */
public class ResultExam_DAO {

    MyGeneric mydao = new MyGeneric();
    Users_DAO User_Dao = new Users_DAO();
    Exam_DAO Exam_Dao = new Exam_DAO();
    Subject_DAO Subject_Dao = new Subject_DAO();
    Level_DAO level_Dao = new Level_DAO();

    public ResultExam_DAO() {
    }

    public ResultExam getResultExamByID(Long id) {
        List<Object> list = new ArrayList<Object>();
        list = mydao.getData1Field(ResultExam.class, "id", id);
        if (!list.isEmpty()) {
            return (ResultExam) list.get(0);
        }
        return new ResultExam();
    }

    public ResultExam getResultExamByExam(Long id) {
        List<Object> list = new ArrayList<Object>();
        list = mydao.getData1Field(ResultExam.class, "ExamID", id);
        if (!list.isEmpty()) {
            return (ResultExam) list.get(0);
        }
        return new ResultExam();
    }

    public List<ResultExam> getAllResultExamByExamID(Long id) {
        List<Object> listObject = mydao.getData1Field(ResultExam.class, "ExamID", id);
        List<ResultExam> list = new ArrayList<ResultExam>();
        if (!listObject.isEmpty()) {
            for (int i = 0; i < listObject.size(); i++) {
                list.add((ResultExam) listObject.get(i));
            }
        }
        return list;
    }

    public List<ResultExam> getAllResultExam() {
        List<Object> listObject = mydao.getAllData(ResultExam.class);
        List<ResultExam> list = new ArrayList<ResultExam>();
        if (!listObject.isEmpty()) {
            for (int i = 0; i < listObject.size(); i++) {
                list.add((ResultExam) listObject.get(i));
            }
        }
        return list;
    }

    public List<ResultExam> getAllResultExamByExamIDSortScore(Long id) {
        Object[] listObject =mydao.getData1Field(ResultExam.class, "ExamID", id).toArray();
        ResultExam a[];
        List<ResultExam> list = new ArrayList<ResultExam>();
        if (listObject.length > 0) {
            int n = listObject.length;
            a = new ResultExam[n];
            for (int i = 0; i < n; i++) {
                a[i] = (ResultExam) listObject[i];
            }
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (a[i].getScore() < a[j].getScore()) {
                        ResultExam tg = a[i] ;
                        a[i] = a[j];
                        a[j] = tg ;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                list.add(a[i]);
            }
        }
        return list;
    }

    public List<ResultExam> getAllResultExamByUserID(Long id) {
        List<Object> listObject = mydao.getData1Field(ResultExam.class, "UserID", id);
        List<ResultExam> list = new ArrayList<ResultExam>();
        if (!listObject.isEmpty()) {
            for (int i = 0; i < listObject.size(); i++) {
                list.add((ResultExam) listObject.get(i));
            }
        }
        return list;
    }

    // Lay Tat ca cac ky thi theo User
    public DefaultTableModel getAllExamtoTableByIdUser(Long id) {
        DefaultTableModel mode = new DefaultTableModel();
        mode.addColumn("ID");
        mode.addColumn("Kỳ Thi");
        mode.addColumn("Môn Thi");
        mode.addColumn("Độ Khó");
        mode.addColumn("Tổng Số Câu Hỏi");
        mode.addColumn("Thời Gian Thi");
        mode.addColumn("Ngày Làm");
        mode.addColumn("Điểm");
        List<Object> listObject = new ArrayList<Object>();
        listObject = mydao.getData1Field(ResultExam.class, "UserID", id);
        if (!listObject.isEmpty()) {
            for (int i = 0; i < listObject.size(); i++) {
                ResultExam re = (ResultExam) listObject.get(i);
                Exam e = (Exam) Exam_Dao.getExamByID(re.getExamID());
                Subject s = (Subject) Subject_Dao.getSubjectByID(e.getSubjectID());
                LevelAll l = (LevelAll) level_Dao.getLevelByID(e.getLevelID());
                String date;
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                date = sdf.format(re.getDateTest().getTime());
                mode.addRow(new Object[]{re, e, s, l, e.getNumberQuestion(), e.getTimes(), date, re.getScore()});
            }
        }
        return mode;
    }

    public ResultExam insertResultExam(ResultExam u) {
        mydao.insertData(u);
        return u;
    }

    public boolean updateResultExam(ResultExam u) {
        return mydao.updateData(u);
    }

    public boolean removeResultExam(Long id) {
        return mydao.removeData(ResultExam.class, id);
    }
}