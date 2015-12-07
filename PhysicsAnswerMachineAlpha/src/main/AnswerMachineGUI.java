package main;

import java.util.*;
import java.util.Arrays;

import java.awt.*;
import javax.swing.*;

import controllers.*;
import layout.InputPane;

/* To do List:
 * remove button removes proper inputPane
 * not Allow empty fields
 */

public class AnswerMachineGUI extends JPanel {
	private AnswerMachine model;

	private JLabel unitLabel = new JLabel("UNIT:");
	private JComboBox<String> unitCBox = new JComboBox<String>(AnswerMachine.UNITS);
	private JLabel answerLabel = new JLabel("Answer:");
	private JComboBox<String> answerCBox = new JComboBox<String>();
	private JTextField answerField = new JTextField(10);

	private ArrayList<InputPane> inputs = new ArrayList<InputPane>();

	private JButton addBtn = new JButton("Add");
	private JButton calcBtn = new JButton("Calculate");


	public AnswerMachineGUI (AnswerMachine model) {
		super();
		this.model = model;
		createAnswerComp();
		createAnswerPane();
		model.setGUI(this);
		registerControllers();
	}

	public void createAnswerComp() {
		answerField.setEnabled(false);
		answerField.setHorizontalAlignment(JTextField.RIGHT);
	}

	public void createAnswerPane() {
		JPanel unitPane = new JPanel();
		unitPane.add(unitLabel);
		unitPane.add(unitCBox);
		JPanel answerPane = new JPanel();
		answerPane.add(answerLabel);
		answerPane.add(answerCBox);
		answerPane.add(answerField);
		JPanel calcPane = new JPanel();
		calcPane.add(addBtn);
		calcPane.add(calcBtn);

		this.setLayout(new GridLayout(3+inputs.size(),1));
		this.add(unitPane);
		this.add(answerPane);
		this.add(calcPane);
		this.setPreferredSize(new Dimension(500, 300));
	}

	public void registerControllers() {
		unitCBox.addActionListener(new UnitController(model));
		addBtn.addActionListener(new AddController(model));
		calcBtn.addActionListener(new CalculateController(model, inputs));
	}

	public void update() {
		//Update number of Inputs
		System.out.println(Arrays.toString(model.getCalcVariables()));
		if (inputs.size()>model.getNumInputs()) {
			inputs.remove(inputs.size()-1);
			this.remove(2+inputs.size()-1);
		} else if (inputs.size()<model.getNumInputs()&&inputs.size()<model.getMaxInputs()) {
			inputs.add(new InputPane(model, inputs.size()));
			this.add(inputs.get(inputs.size()-1), 1+inputs.size());
		}
		System.out.println(inputs.size());
		//Update variables in AnswerBox
		try {
			answerCBox.removeAllItems();
			for (String variable: model.getCalcVariables())
				answerCBox.addItem(variable);
		} catch (NullPointerException e) {}
		//Update variables in inputs
		try {
			for (InputPane inputBox:inputs) {
				inputBox.setVariables(model.getCalcVariables());
			}
		} catch (NullPointerException e) {}
		this.setLayout(new GridLayout(3+inputs.size(),1));
	}
}