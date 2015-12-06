package controllers;

import java.util.*;

import calculations.AnswerMachine;
import layout.InputPane;

//import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Check if field has number
//Check if there is double variables

public class CalculateController implements ActionListener{
  private AnswerMachine model;
  private ArrayList<InputPane> inputPanes;
  
  public CalculateController(AnswerMachine model, ArrayList<InputPane> inputPanes) {
    this.model = model;
    this.inputPanes = inputPanes;
  }
  
  public void actionPerformed(ActionEvent e) {
    boolean canCalculate = true;
    ArrayList<String> variables = new ArrayList<String>();
    ArrayList<Double> values = new ArrayList<Double>();
    for (InputPane input: inputPanes) {
      variables.add(input.getSelectedVariable());
      values.add(input.getValue());
      if (input.getValue()==null) {
        canCalculate = false;
      }
    }
    if (canCalculate) {
      model.setVariables(variables);
      model.setValues(values);
      model.calculate();
    } else {
      //Return an error
    }
  }
}