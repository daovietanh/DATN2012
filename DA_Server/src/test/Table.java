/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author VietAnh
 */

public class Table extends JFrame {
  JPanel contentPane;
  JPanel jPanel1 = new JPanel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable jTable1 = new JTable(50,12);
  BorderLayout borderLayout1 = new BorderLayout();

  //Construct the frame
  public Table() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception  {
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(null);
    this.setSize(new Dimension(521, 458));
    this.setTitle("Frame Title");
    TableColumn includeColumn = jTable1.getColumnModel().getColumn(0);
            includeColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()));



    
    jPanel1.setBorder(BorderFactory.createEtchedBorder());
    jPanel1.setBounds(new Rectangle(71, 93, 390, 215));
    jPanel1.setLayout(borderLayout1);
    jScrollPane1.setAutoscrolls(true);
    contentPane.add(jPanel1, null);
    
      jScrollPane1.getViewport().add(jTable1, null);
    jPanel1.add(jScrollPane1, BorderLayout.CENTER);
    
    
  
   jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
  }

  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }

  
  public static void main(String args[]) {
      new Table().show();
  }
}