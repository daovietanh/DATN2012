
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
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

/*
 * BackUpData.java
 *
 * Created on 21-03-2012, 16:55:21
 */
/**
 *
 * @author VietAnh
 */
public class BackUpExportData extends javax.swing.JFrame {

    /** Creates new form BackUpData */
    public BackUpExportData() {
        initComponents();
        Cl_Client cl = new Cl_Client();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cbxDetailResultExam = new javax.swing.JCheckBox();
        cbxDetailTrain = new javax.swing.JCheckBox();
        cbxExamQuestion = new javax.swing.JCheckBox();
        cbxExam = new javax.swing.JCheckBox();
        cbxGroupUser = new javax.swing.JCheckBox();
        cbxLevel = new javax.swing.JCheckBox();
        cbxNews = new javax.swing.JCheckBox();
        cbxSubject = new javax.swing.JCheckBox();
        cbxQuestion = new javax.swing.JCheckBox();
        cbxResultExam = new javax.swing.JCheckBox();
        cbxTrain = new javax.swing.JCheckBox();
        cbxUser = new javax.swing.JCheckBox();
        cbxAll = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("BackUp");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbxDetailResultExam.setText("Detail Result Exam");

        cbxDetailTrain.setText("Detail Train");

        cbxExamQuestion.setText("Exam Question");
        cbxExamQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxExamQuestionActionPerformed(evt);
            }
        });

        cbxExam.setText("Exam");

        cbxGroupUser.setText("Group User");

        cbxLevel.setText("Level ");

        cbxNews.setText("News");

        cbxSubject.setText("Subject");

        cbxQuestion.setText("Question");

        cbxResultExam.setText("Result Exam");

        cbxTrain.setText("Train");

        cbxUser.setText("Users");

        cbxAll.setText("Chọn/Bỏ Tất Cả");
        cbxAll.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAllItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxDetailTrain)
                    .addComponent(cbxDetailResultExam)
                    .addComponent(cbxExamQuestion)
                    .addComponent(cbxExam))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxAll)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxNews)
                            .addComponent(cbxLevel)
                            .addComponent(cbxResultExam)
                            .addComponent(cbxQuestion))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxUser)
                            .addComponent(cbxTrain)
                            .addComponent(cbxSubject)
                            .addComponent(cbxGroupUser))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxTrain)
                        .addGap(18, 18, 18)
                        .addComponent(cbxUser)
                        .addGap(18, 18, 18)
                        .addComponent(cbxSubject)
                        .addGap(18, 18, 18)
                        .addComponent(cbxGroupUser))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxLevel)
                        .addGap(18, 18, 18)
                        .addComponent(cbxNews)
                        .addGap(18, 18, 18)
                        .addComponent(cbxQuestion)
                        .addGap(18, 18, 18)
                        .addComponent(cbxResultExam))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxDetailResultExam)
                        .addGap(18, 18, 18)
                        .addComponent(cbxDetailTrain)
                        .addGap(18, 18, 18)
                        .addComponent(cbxExam)
                        .addGap(18, 18, 18)
                        .addComponent(cbxExamQuestion)))
                .addGap(18, 18, 18)
                .addComponent(cbxAll)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public List<Object> getAllClassToBackup() {
        List<Object> listClass = new ArrayList<Object>();
        if (cbxDetailResultExam.isSelected()) {
           listClass.add(DetailResultExam.class);
        }
        if (cbxDetailTrain.isSelected()) {
            listClass.add(DetailTrain.class);
        }
        if (cbxExam.isSelected()) {
            listClass.add(Exam.class);
        }
        if (cbxExamQuestion.isSelected()) {
            listClass.add(Exam_Question.class);
        }
        if (cbxGroupUser.isSelected()) {
            listClass.add(GroupUser.class);
        }
        if (cbxLevel.isSelected()) {
            listClass.add(LevelAll.class);
        }
        if (cbxNews.isSelected()) {
            listClass.add(News.class);
        }
        if (cbxQuestion.isSelected()) {
            listClass.add(Question.class);
        }
        if (cbxResultExam.isSelected()) {
            listClass.add(ResultExam.class);
        }
        if (cbxSubject.isSelected()) {
            listClass.add(Subject.class);
        }
        if (cbxTrain.isSelected()) {
            listClass.add(Train.class);
        }
        if (cbxUser.isSelected()) {
            listClass.add(Users.class);
        }
        return listClass;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        List<Object> listClass = this.getAllClassToBackup();
        new CreateExcelFile().startCreate(listClass);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbxExamQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxExamQuestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxExamQuestionActionPerformed

    private void cbxAllItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAllItemStateChanged
        // TODO add your handling code here:
        boolean b = cbxAll.isSelected();
        cbxDetailResultExam.setSelected(b);
        cbxDetailTrain.setSelected(b);
        cbxExam.setSelected(b);
        cbxExamQuestion.setSelected(b);
        cbxGroupUser.setSelected(b);
        cbxLevel.setSelected(b);
        cbxNews.setSelected(b);
        cbxQuestion.setSelected(b);
        cbxResultExam.setSelected(b);
        cbxSubject.setSelected(b);
        cbxTrain.setSelected(b);
        cbxUser.setSelected(b);
    }//GEN-LAST:event_cbxAllItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BackUpExportData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BackUpExportData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BackUpExportData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BackUpExportData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BackUpExportData().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbxAll;
    private javax.swing.JCheckBox cbxDetailResultExam;
    private javax.swing.JCheckBox cbxDetailTrain;
    private javax.swing.JCheckBox cbxExam;
    private javax.swing.JCheckBox cbxExamQuestion;
    private javax.swing.JCheckBox cbxGroupUser;
    private javax.swing.JCheckBox cbxLevel;
    private javax.swing.JCheckBox cbxNews;
    private javax.swing.JCheckBox cbxQuestion;
    private javax.swing.JCheckBox cbxResultExam;
    private javax.swing.JCheckBox cbxSubject;
    private javax.swing.JCheckBox cbxTrain;
    private javax.swing.JCheckBox cbxUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
