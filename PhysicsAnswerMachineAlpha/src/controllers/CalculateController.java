package controllers;

import java.util.*;

import layout.InputPane;
import main.AnswerMachine;

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
		//Gets values and variables from input
		for (InputPane input: inputPanes) {
			variables.add(input.getSelectedVariable());
			values.add(input.getValue());
			if (input.getValue()==null) {

				canCalculate = false;
			}
		}
		//Check if variables are selected twice
		for (int i=0;i<variables.size();i++) {
			String variable = variables.get(i);
			for (int k=i+1;k<variables.size();k++) {
				if (variable.equals(variables.get(k))) {
					canCalculate = false;
				}
			}
		}
		if (canCalculate) {
			model.setVariables(variables);
			model.setValues(values);
			model.calculate();
		} else {
			System.err.println("Error!");
			//Return an error
		}
	}
}