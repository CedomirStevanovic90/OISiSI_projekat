package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import view.AddOrEditProfesor;
import view.ErrorDialog;
import view.GlavniProzor;
import view.TabelaPredmeti;

public class UkloniPredmetProfesoruButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int[] indeksiPredmeta = TabelaPredmeti.profesori.getSelectedRows();
		
		if(indeksiPredmeta.length == 0) {
			@SuppressWarnings("unused")
			ErrorDialog error;
			error = new ErrorDialog("Greska pri izboru predmeta!");
			return;
		}
		
		ArrayList<String> izabraniPredmeti = new ArrayList<String>();
		String temp;
		for(int i : indeksiPredmeta) {
			temp = (String) TabelaPredmeti.profesori.getValueAt(i, 0);
			izabraniPredmeti.add(temp);
		}
		
		String [] options = {"Ukloni", "Odustani"};
		int code = JOptionPane.showOptionDialog(AddOrEditProfesor.inst, "Da li ste sigurni da zelite da uklonite predmet profesoru?", "Uklanjanje predmeta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
		if(code == JOptionPane.YES_OPTION) {
			AddOrEditProfesor.controller.ukloniPredmetKodProfesora(AddOrEditProfesor.professor, izabraniPredmeti);
			TabelaPredmeti.profesori.updateTable(AddOrEditProfesor.professor.getBrojLicneKarte(), 2);
			GlavniProzor.serialize();
		}
	}
}
