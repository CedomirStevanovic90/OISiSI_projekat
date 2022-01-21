package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import view.AddOrEditPredmet;
import view.GlavniProzor;

public class UkloniProfesoraSaPredmetaButtonLIstener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String [] options = {"Da", "Ne"};
		int code = JOptionPane.showOptionDialog(AddOrEditPredmet.inst, "Da li ste sigurni da zelite da uklonite profesora sa predmeta?", "Uklanjanje profesora sa predmeta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
		
		if(code == JOptionPane.YES_OPTION) {				
			AddOrEditPredmet.textProfesor.setText("Professors* ");
			AddOrEditPredmet.plus.setEnabled(true);
			AddOrEditPredmet.minus.setEnabled(false);
			AddOrEditPredmet.imaProfesora = false;
			ArrayList<String> izabraniPredmeti = new ArrayList<String>();
			izabraniPredmeti.add(AddOrEditPredmet.predmet.getSifraPredmeta());
			GlavniProzor.getControllerProfesor().ukloniPredmetKodProfesora(AddOrEditPredmet.profesor, izabraniPredmeti);
		}
	}

}
