package controllers;

//import java.util.*;
import javax.swing.*;

import main.AnswerMachine;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UnitController implements ActionListener{
  private AnswerMachine model;
  
  public UnitController(AnswerMachine model) {
    this.model = model;
  }
  
  public void actionPerformed(ActionEvent e) {
    @SuppressWarnings("unchecked")
	JComboBox<String> cb = (JComboBox<String>)e.getSource();
    model.setCalculation(cb.getSelectedIndex());
  }
}