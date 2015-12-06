package controllers;

import java.util.*;
import javax.swing.*;

import calculations.AnswerMachine;
import layout.InputPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddController implements ActionListener{
  private AnswerMachine model;
  private InputPane input;
  
  public AddController(AnswerMachine model) {
    this.model = model;
  }
  
  public void actionPerformed(ActionEvent e) {
    model.addInput();
  }
}