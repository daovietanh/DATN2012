
import java.awt.Color;
import java.awt.Rectangle;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import vn.com.dva.entities.Exam;
import vn.com.dva.entities.ResultExam;
import vn.com.dva.entities.Subject;
import vn.com.dva.entities.Users;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Pnl_ThongKe.java
 *
 * Created on 18-03-2012, 00:15:08
 */
/**
 *
 * @author VietAnh
 */
public class Pnl_ThongKe extends javax.swing.JPanel {

    private List<ResultExam> list;
    private Users user;
    ChartFrame frame = null;
    Calculate calculate = new Calculate();
    JXTable jTable ;
    /** Creates new form Pnl_ThongKe */
    public Pnl_ThongKe() {
        initComponents();
        this.user = Session.user;
        list = new ArrayList<ResultExam>();
        List<Exam> listExam = null;
        try {
            list = Cl_Client.c.getAllResultExamByID(user.getUserID());
            listExam = Cl_Client.c.getAllExam();
        } catch (RemoteException ex) {
            Logger.getLogger(Pnl_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        cbo.addItem(" Lựa chọn sô kỳ thi");
        for (int i = 1; i < list.size() + 1; i++) {
            cbo.addItem(i + "");
        }
        cboExam.addItem(" Lựa chọn kỳ thi ");
        for (Exam e : listExam) {
            cboExam.addItem(e);
        }
        rdb1.setSelected(false);
        rdb2.setSelected(false);
        cbo.setEnabled(false);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        cboExam.setEnabled(false);
        btnSelection.setEnabled(false);
        
         String header[] = {"Xếp Hạng ", "Tên Đăng Nhập", "Tên ", "Môn Thi", "Thời Gian Làm", "Ngày Thi", "Số Câu Hỏi", "Điểm"};
        DefaultTableModel model = new DefaultTableModel(header, 0);

        jTable = new JXTable(model);
    }

    private static CategoryDataset createDataset(List<ResultExam> lst, int n, boolean isDate) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int k = lst.size() - n;
        for (int i = k; i < lst.size(); i++) {
            ResultExam re = lst.get(i);
            double score = re.getScore();
            Exam e = null;
            try {
                e = Cl_Client.c.getExamByID(re.getExamID());
            } catch (RemoteException ex) {
                Logger.getLogger(Pnl_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String date = sdf.format(re.getDateTest().getTime());
            if (isDate) {
                dataset.addValue(score, "classes", i + ": " + date);
            } else {
                dataset.addValue(score, "classes", i + ": " + e.getExamName());
            }
        }
        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
// create the chart...
        JFreeChart chart = ChartFactory.createLineChart(
                " Biểu đồ điểm qua các kỳ thi ", // chart title
                "Tên", // domain axis label
                "Điểm", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                false, // include legend
                true, // tooltips
                false // urls
                );

        chart.setBackgroundPaint(Color.white);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.white);
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setShapesVisible(true);
        renderer.setDrawOutlines(true);
        renderer.setUseFillPaint(true);
        renderer.setFillPaint(Color.white);
        return chart;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        cbo = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        cboExam = new javax.swing.JComboBox();
        rdb1 = new javax.swing.JRadioButton();
        rdb2 = new javax.swing.JRadioButton();
        btnSelection = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel = new javax.swing.JPanel();

        jButton1.setText("Điểm theo Kỳ Thi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Theo Ngày Thi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cboExam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboExamItemStateChanged(evt);
            }
        });

        bg.add(rdb1);
        rdb1.setText("Biểu đồ");
        rdb1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdb1ItemStateChanged(evt);
            }
        });

        bg.add(rdb2);
        rdb2.setText("Top Điểm Cao");
        rdb2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdb2ItemStateChanged(evt);
            }
        });

        btnSelection.setText("Vi Tri");
        btnSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdb1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(rdb2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboExam, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdb1)
                    .addComponent(cbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboExam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelection)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(rdb2))
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        showChart(false);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        showChart(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cboExamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboExamItemStateChanged
        Exam exam;
        try {
            exam = (Exam) cboExam.getSelectedItem();
        } catch (Exception ex) {
            return;
        }
        String header[] = {"Xếp Hạng ", "Tên Đăng Nhập", "Tên ", "Môn Thi", "Thời Gian Làm", "Ngày Thi", "Số Câu Hỏi", "Điểm"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        List<ResultExam> lst = calculate.getTopHighScore(exam);
        for (int i = 0; i < lst.size(); i++) {
            try {
                ResultExam bean = lst.get(i);
                Users u = Cl_Client.c.getUserByID(bean.getUserID());
                Exam e = Cl_Client.c.getExamByID(bean.getExamID());
                Subject s = Cl_Client.c.getSubjectByID(e.getSubjectID());
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String date = sdf.format(bean.getDateTest().getTime());
                model.addRow(new Object[]{i + 1, u, u.getFullName(), s, bean.getTimes(), date, e.getNumberQuestion(), bean.getScore()});
            } catch (RemoteException ex) {
                Logger.getLogger(Pnl_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        jTable = new JXTable(model);
        jScrollPane1.setViewportView(jTable);
    }//GEN-LAST:event_cboExamItemStateChanged

        private void btnSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectionActionPerformed
            // TODO add your handling code here:
            Users u = Session.user;
            int selected = -1;
            for (int i = 0; i < jTable.getRowCount(); i++) {
                Users users = (Users) jTable.getValueAt(i, 1);
                if (users.getUserID().equals(u.getUserID())) {
                    selected = i;
                    break;
                }
            }

            if (selected != -1) {
                jTable.setRowSelectionInterval(selected, selected);
                jTable.scrollRectToVisible(new Rectangle(jTable.getCellRect(selected, 0, true)));
            }
    }//GEN-LAST:event_btnSelectionActionPerformed

    private void rdb1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdb1ItemStateChanged
        // TODO add your handling code here:
        if (rdb1.isSelected()) {
            cbo.setEnabled(true);
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
        } else {
            cbo.setEnabled(false);
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
        }
    }//GEN-LAST:event_rdb1ItemStateChanged

    private void rdb2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdb2ItemStateChanged
        // TODO add your handling code here
        if (rdb2.isSelected()) {
            cboExam.setEnabled(true);
            btnSelection.setEnabled(true);
        } else {
            cboExam.setEnabled(false);
            btnSelection.setEnabled(false);
        }
    }//GEN-LAST:event_rdb2ItemStateChanged

    private void showChart(boolean ok) {
        int n = cbo.getSelectedIndex();
        if (n == 0) {
            return;
        }
        JFreeChart jfc = this.createChart(createDataset(list, n, ok));
        ChartPanel chartPanel = new ChartPanel(jfc);
        jScrollPane1.setViewportView(chartPanel);

    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bg;
    private javax.swing.JButton btnSelection;
    private javax.swing.JComboBox cbo;
    private javax.swing.JComboBox cboExam;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdb1;
    private javax.swing.JRadioButton rdb2;
    // End of variables declaration//GEN-END:variables
}
