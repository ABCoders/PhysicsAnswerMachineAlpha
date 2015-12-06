package main;

import javax.swing.JFrame;

import calculations.AnswerMachine;

public class PhysicsAnswerMachine {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
	    AnswerMachine model = new AnswerMachine();
	    AnswerMachineGUI view = new AnswerMachineGUI(model);
	    
	    frame.setContentPane(view);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocation(300,50);
	    frame.pack();
	}
}
