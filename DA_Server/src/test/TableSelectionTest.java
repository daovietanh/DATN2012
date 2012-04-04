/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EventObject;
import java.util.Hashtable;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author VietAnh
 */
public class TableSelectionTest extends JFrame  {

class CheckBoxRenderer extends JCheckBox implements TableCellRenderer {

  CheckBoxRenderer() {
    setHorizontalAlignment(JLabel.CENTER);
  }

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(table.getBackground());
    }
    setSelected((value != null && ((Boolean) value).booleanValue()));
    return this;
  }
}

Action action = new AbstractAction("CheckBox") {
    
    public void actionPerformed(ActionEvent evt) {
        
        JCheckBox cb = (JCheckBox)evt.getSource();

        boolean isSel = cb.isSelected();
        if (isSel) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
};



  public TableSelectionTest() {
    super("MultiComponent Table");

    DefaultTableModel dm = new DefaultTableModel() {
      public boolean isCellEditable(int row, int column) {
        if (column == 0) {
          return true;
        }
        return false;
      }
    };
    
    
    //Table Data
    dm.setDataVector(new Object[][] {
                        { new Boolean(false), "Franky", "50%", createBar(50, "50%")},
                        { new Boolean(false), "Joe", "60%", createBar(60, "60%") } }, 
                    new Object[] {
                        "CheckBox", "String", "Percentage", "Progress" });
    
    

    CheckBoxRenderer checkBoxRenderer = new CheckBoxRenderer();
    EachRowRenderer rowRenderer = new EachRowRenderer();
    
    rowRenderer.add(0, checkBoxRenderer);
    rowRenderer.add(1, checkBoxRenderer);
    
    
    JCheckBox checkBox = new JCheckBox(action);
    checkBox.setHorizontalAlignment(JLabel.CENTER);
    
    
    DefaultCellEditor checkBoxEditor = new DefaultCellEditor(checkBox);
    JTable table = new JTable(dm);


    EachRowEditor rowEditor = new EachRowEditor(table);
    
    rowEditor.setEditorAt(0, checkBoxEditor);
    rowEditor.setEditorAt(1, checkBoxEditor);


    table.getColumn("CheckBox").setCellRenderer(rowRenderer);
    table.getColumn("CheckBox").setCellEditor(rowEditor);


    
    JScrollPane scroll = new JScrollPane(table);
    getContentPane().add(scroll);
    setSize(400, 160);
    setVisible(true);
    
    
    table.getColumn("Progress").setCellRenderer(new ProgRenderer());
    
    
   
   
  }

   
  
  
  public static void main(String[] args) {
      TableSelectionTest frame = new TableSelectionTest();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
  
  public JProgressBar createBar(int percentDone, String text){
        JProgressBar progressBar = new JProgressBar(0, 100);
                
        progressBar.setStringPainted(true);
        progressBar.setValue(percentDone);
        progressBar.setString(text);
        
        return progressBar;
    }
}



class ProgRenderer implements TableCellRenderer{
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        return (JProgressBar)value;
    }
    
}

class EachRowRenderer implements TableCellRenderer {
  protected Hashtable renderers;

  protected TableCellRenderer renderer, defaultRenderer;

  public EachRowRenderer() {
    renderers = new Hashtable();
    defaultRenderer = new DefaultTableCellRenderer();
  }

  public void add(int row, TableCellRenderer renderer) {
    renderers.put(new Integer(row), renderer);
  }

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
      
    renderer = (TableCellRenderer) renderers.get(new Integer(row));
    if (renderer == null) {
      renderer = defaultRenderer;
    }
    return renderer.getTableCellRendererComponent(table, value, isSelected,
        hasFocus, row, column);
  }
}

class EachRowEditor implements TableCellEditor {
  protected Hashtable editors;

  protected TableCellEditor editor, defaultEditor;

  JTable table;

  
  public EachRowEditor(JTable table) {
    this.table = table;
    editors = new Hashtable();
    defaultEditor = new DefaultCellEditor(new JTextField());
  }

    public void setEditorAt(int row, TableCellEditor editor) {
    editors.put(new Integer(row), editor);
  }

  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    //editor = (TableCellEditor)editors.get(new Integer(row));
    //if (editor == null) {
    //  editor = defaultEditor;
    //}
    return editor.getTableCellEditorComponent(table, value, isSelected,
        row, column);
  }

  public Object getCellEditorValue() {
    return editor.getCellEditorValue();
  }

  public boolean stopCellEditing() {
    return editor.stopCellEditing();
  }

  public void cancelCellEditing() {
    editor.cancelCellEditing();
  }

  public boolean isCellEditable(EventObject anEvent) {
    selectEditor((MouseEvent) anEvent);
    return editor.isCellEditable(anEvent);
  }

  public void addCellEditorListener(CellEditorListener l) {
    editor.addCellEditorListener(l);
  }

  public void removeCellEditorListener(CellEditorListener l) {
    editor.removeCellEditorListener(l);
  }

  public boolean shouldSelectCell(EventObject anEvent) {
    selectEditor((MouseEvent) anEvent);
    return editor.shouldSelectCell(anEvent);
  }

  protected void selectEditor(MouseEvent e) {
    int row;
    if (e == null) {
      row = table.getSelectionModel().getAnchorSelectionIndex();
    } else {
      row = table.rowAtPoint(e.getPoint());
    }
    editor = (TableCellEditor) editors.get(new Integer(row));
    if (editor == null) {
      editor = defaultEditor;
    }
  }
}