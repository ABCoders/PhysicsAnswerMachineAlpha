package layout;

//import java.util.*;

//import java.awt.image.*;
import java.awt.*;
import javax.swing.*;

import controllers.RemoveController;
import main.AnswerMachine;

public class InputPane extends JPanel {
  private AnswerMachine model;
  private int index;
  
  private JComboBox<String> inputVar;
  private JLabel equals = new JLabel(" = ");
  private JTextField inputField = new JTextField("0", 10);
  private JButton closeBtn = new JButton("X");
  
  public InputPane (AnswerMachine model, int index) {
    super();
    this.model = model;
    this.index = index;
    createComp();
    createPane();
    registerControllers();
  }
  
  public void createComp() {
    inputVar = new JComboBox<String>(model.getCalcVariables());
    inputVar.setSelectedIndex(0);
    inputVar.setSize(10,10);
    inputField.setHorizontalAlignment(JTextField.RIGHT);
    closeBtn.setSize(50,50);
  }
  
  public void createPane() {
    this.add(inputVar);
    this.add(equals);
    this.add(inputField);
    this.add(closeBtn);
    
    this.setMinimumSize(new Dimension(100,50));
    this.setMaximumSize(new Dimension(100,50));
  }
  
  public void registerControllers() {
    closeBtn.addActionListener(new RemoveController(model, index));
  }
  
  public void setVariables(String[] variables) {
    inputVar.removeAllItems();
    for (String variable:variables) {
      inputVar.addItem(variable);
    }
  }
  
  public void setIndex(int newIndex) {
    index = newIndex;
  }
  
  public String getSelectedVariable() {
    return (String)inputVar.getSelectedItem();
  }
  
  public int getIndex() {
    return index;
  }
  
  public Double getValue() {
    try {
      return Double.parseDouble(inputField.getText());
    } catch (NumberFormatException e) {
      return null;
    }
  }
  
  public static void main(String[]args) {
    JFrame frame = new JFrame();
    InputPane pane = new InputPane(new AnswerMachine(), 1);
    JPanel panel = new JPanel();
    panel.add(pane);
    
    frame.setContentPane(panel);
    frame.setVisible(true);
    frame.pack();
  }
}