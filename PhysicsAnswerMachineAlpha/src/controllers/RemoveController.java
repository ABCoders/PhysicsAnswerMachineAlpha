package controllers;

//import java.util.*;
//import javax.swing.*;
import java.awt.event.ActionListener;

import main.AnswerMachine;

import java.awt.event.ActionEvent;

public class RemoveController implements ActionListener{
  private AnswerMachine model;
  private int index;
  
  public RemoveController(AnswerMachine model, int index) {
    this.model = model;
    this.index = index;
  }
  
  public void actionPerformed(ActionEvent e) {
    model.removeInput();
  }
}