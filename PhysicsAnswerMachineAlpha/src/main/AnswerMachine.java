package main;

import java.util.*;

import calculations.Calculation;
import calculations.DynamicsCalculation;
import calculations.KinematicsCalculation;

public class AnswerMachine {
	public static final String[] UNITS = new String[] {"Kinematics", "Dynamics", "Circular Motion", 
			"Work and Energy", "Momentum and Collisions",
			"Gravitation and Celestial Mechanics", "Electric Charges and Electric Fields"};

	private AnswerMachineGUI view;
	private Calculation calc;
	private int maxInputs;
	private int numInputs;

	private ArrayList<String> variables = new ArrayList<String>();
	private ArrayList<Double> values = new ArrayList<Double>();

	public AnswerMachine () {
		calc = new KinematicsCalculation();
		maxInputs = calc.getVariables().length;
		numInputs = 1;
	}

	public void setGUI(AnswerMachineGUI view) {
		this.view = view;
		updateView();
	}

	public void setCalculation(int calcType) {
		if (calcType==Calculation.KINEMATICS)
			calc = new KinematicsCalculation();
		else if (calcType==Calculation.DYNAMICS)
			calc = new DynamicsCalculation();
		updateView();
	}

	public void addInput() {
		if (numInputs<maxInputs)
			numInputs++;
		updateView();
	}

	public void removeInput() {
		if (numInputs>1)
			numInputs--;
		updateView();
	}

	public void calculate() {
		System.out.println(Arrays.toString(variables.toArray()));
		System.out.println(Arrays.toString(values.toArray()));
	}

	public void setVariables(ArrayList<String> newVariables) {
		variables = new ArrayList<String>(newVariables);
	}

	public void setValues(ArrayList<Double> newValues) {
		values = new ArrayList<Double>(newValues);
	}

	public Calculation getCalculation() {
		return calc;
	}

	public String[] getCalcVariables() {
		return calc.getVariables();
	}

	public int getNumInputs() {
		return numInputs;
	}

	public int getMaxInputs() {
		return maxInputs;
	}

	public void updateView(){
		view.update();
	}
}