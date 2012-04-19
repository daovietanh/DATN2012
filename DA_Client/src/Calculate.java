
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vn.com.dva.entities.Exam;
import vn.com.dva.entities.LevelAll;
import vn.com.dva.entities.Question;
import vn.com.dva.entities.ResultExam;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VietAnh
 */
public class Calculate {
    public static int EASY = 1;
    public static int NORMAL = 2;
    public static int HARD = 3;
    public Calculate(){
        
    }
    
    
    
    /**
     * Random đáp án câu hỏi 
     * -> Trả về giá trị ABCD đã đổi vị trí
     * 
     */
    public String randomAnswer() {
        char[] ch = "ABCD".toCharArray();
        List<Integer> lst = new ArrayList<Integer>();
        Random r = new Random();
        while (lst.size() < 4) {
            int next = r.nextInt(4);
            if (!lst.contains(next)) {
                lst.add(next);
            }
        }
        String s = "";
        for (int i = 0; i < lst.size(); i++) {
            s += ch[lst.get(i)];
        }
        return s;
    }
    
    
    /**
     * Trả về giá trị đáp án tương ứng sau khi với câu hỏi
     * 
     */
    public String getChoose(Question q, char ch) {
        if (ch == 'A') {
            return q.getChooseA();
        }
        if (ch == 'B') {
            return q.getChooseB();
        }
        if (ch == 'C') {
            return q.getChooseC();
        }
        if (ch == 'D') {
            return q.getChooseD();
        }
        return "";
    }
    
    /**
     * Trả về giá trị đáp án đúng sau khi đã tráo đổi vị trí câu trả lời
     * 
     */
    public String getActualAnswer(Question q, String s) {
        int i = s.indexOf(q.getAnswer());
        String trueAnswer = "ABCD".charAt(i) + "";
        return trueAnswer;

    }
    
    /**
     * Trả về danh sách đã sắp xếp theo điểm của 1 kỳ thi
     * 
     */
    public List<ResultExam> getTopHighScore(Exam exam) {
        List<ResultExam> listTop = new ArrayList<ResultExam>();
        try {
            listTop = Cl_Client.c.getAllResultExamByExamIDSortScore(exam.getExamID());
        } catch (RemoteException ex) {
            Logger.getLogger(Pnl_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<ResultExam> listResult = new ArrayList<ResultExam>();
        for (int i = 0; i < listTop.size(); i++) {
            listResult.add(listTop.get(i));
        }
        return listResult;

    }
    
    
    /**
     * Hàm lấy ra danh sách n câu hỏi random theo độ khó (phần trăm độ khó )
     * @param allQuestion
     * @param n
     * @param level
     * @return 
     */
    public static List<Question> getListNQuestionByLevel(List<Question> allQuestion , int n, LevelAll level){
        List<Question> lst = new ArrayList<Question>();
        int easy = (int) (level.getPercentEasy() * n *0.01 );
        int normal = (int) (level.getPercentNormal()* n * 0.01);
        int hard = n - easy - normal ;
        JOptionPane.showMessageDialog(null, "Dễ = "+ easy + "- Tb = "+ normal + " - kHó = "+ hard); 
        lst.addAll(getListQuestionByLevel(allQuestion, easy, EASY));
        lst.addAll(getListQuestionByLevel(allQuestion, normal, NORMAL));
        lst.addAll(getListQuestionByLevel(allQuestion, hard, HARD));        
        return lst;
    }
    /**
     * Hàm lấy ra danh sách n câu hỏi random trong danh sách câu hỏi theo độ khó (dễ , tb, khó)
     * @param listQuestion
     * @param n
     * @param level dễ = 1 ; Trung bình : 2 ; Khó = 3
     * @return 
     */
    public static List<Question> getListQuestionByLevel(List<Question> listQuestion , int n , int level ){
        Random r = new Random();
        List<Question> list = new ArrayList<Question>();
        List<Integer> listRandom = new ArrayList<Integer>();
        if (listQuestion.size() < n) return null;
        int total = 0 ;
        for (Question q : listQuestion)
        if (q.getLevelID() == level ){
            total ++;
        }
        if (total < n) {
            for (int i=0;i<n;i++) list.add(listQuestion.get(i));
            return list;
        }
        while (list.size() != n ){
            int i = r.nextInt(listQuestion.size());
            if (!listRandom.contains(i) && listQuestion.get(i).getLevelID() == level){
                listRandom.add(i);
                list.add(listQuestion.get(i));
            }
        }
        return list;
    }
}
