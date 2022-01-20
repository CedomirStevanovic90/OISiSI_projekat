package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import view.AddOrEditProfesor;
import view.TabelaPredmeti;

public class UkloniPredmetProfesoruButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int[] indeksiPredmeta = TabelaPredmeti.profesori.getSelectedRows();
		
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
		}
	}
}