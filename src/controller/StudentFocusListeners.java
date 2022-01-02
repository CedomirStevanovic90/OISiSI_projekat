package controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class StudentFocusListeners implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
				JTextField txt = (JTextField) e.getComponent();
				
				txt.setForeground(Color.BLACK);
				txt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		JTextField txt = (JTextField) e.getComponent();
		
		String name = txt.getName();
		String input = txt.getText().trim();
		
		if(!regularInput(name, input)) {
			txt.setBorder(BorderFactory.createLineBorder(Color.RED));
			txt.setForeground(Color.RED);
		} else {
			txt.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		}
	}

	public static boolean regularInput(String name, String input) {

		if(name.equals("Name* ") || name.equals("Surname* "))
			return Checker.isNameOrSurename(input);
		if(name.equals("Date of birth* "))
			return Checker.isValidDate(input);
		if(name.equals("Address* "))
			return Checker.isValidAdrress(input);
		if(name.equals("Phone number* "))
			return Checker.isValidNumber(input);
		if(name.equals("E-mail* "))
			return Checker.isValidEmail(input);
		if(name.equals("Student ID* "))
			return Checker.isValidIndex(input);
		if(name.equals("Enrollment year* "))
			return Checker.isValidYear(input);
		
		return false;
	}
}
