package controllers;

import java.util.*;
import javax.swing.*;

import layout.InputPane;
import main.AnswerMachine;

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