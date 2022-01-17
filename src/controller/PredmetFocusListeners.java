package controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import view.AddOrEditPredmet;

public class PredmetFocusListeners implements FocusListener {

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
		
		AddOrEditPredmet.potvrdi.setEnabled(AddOrEditPredmet.brTacnihPolja());
	}
	
	private boolean regularInput(String name, String input) {
		
		if(name.equals("Subject ID* "))
			return Checker.isSubjectID(input);
		if(name.equals("Name* "))
			return Checker.isNameOrSurename(input);
		if(name.equals("ECTS* "))
			return Checker.isValidECTS(input);
		
		return false;
	}


}
