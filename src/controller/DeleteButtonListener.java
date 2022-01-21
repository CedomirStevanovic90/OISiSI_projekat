package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.GlavniProzor;
import view.TabelaPredmeti;
import view.TabelaProfesori;
import view.TabelaStudenti;

public class DeleteButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int tab = GlavniProzor.getTabbedPane().getSelectedIndex();
		String[] options = {"Da", "Ne"};
		
		switch(tab) {
		case 0 :
			int Student = TabelaStudenti.tabelaStudenti.getSelectedRow();
			
			if(Student != -1) {
				int code = JOptionPane.showOptionDialog(GlavniProzor.getGlavniProzor(), "Da li ste sigurni da zelite da obisete studenta: " + TabelaStudenti.tabelaStudenti.getValueAt(Student, 0), "Brisanje studenta?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
			
				if(code == JOptionPane.YES_OPTION) {
					String indexStudenta = (String) TabelaStudenti.tabelaStudenti.getValueAt(Student, 0);
					GlavniProzor.getControllerStudent().obrisiStudenta(indexStudenta);
					TabelaStudenti.tabelaStudenti.updateTable();
					GlavniProzor.serialize();
				}
			}
			break;
		case 1:
			int Profesor = TabelaProfesori.tabelaProfesori.getSelectedRow();

			if(Profesor != -1) {
				int code = JOptionPane.showOptionDialog(GlavniProzor.getGlavniProzor(), "Da li ste sigurni da zelite da obisete profesora: " + TabelaProfesori.tabelaProfesori.getValueAt(Profesor, 0) + " " + TabelaProfesori.tabelaProfesori.getValueAt(Profesor, 1), "Brisanje profesora?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

				if(code == JOptionPane.YES_OPTION) {
					String brojLicneKarte = (String) TabelaProfesori.tabelaProfesori.getProfesor(Profesor).getBrojLicneKarte();
					GlavniProzor.getControllerProfesor().obrisiProfesora(brojLicneKarte);
					TabelaProfesori.tabelaProfesori.updateTable();
					GlavniProzor.serialize();
				}
			}
			break;
		case 2:
			int Predmet = TabelaPredmeti.tabelaPredmeti.getSelectedRow();

			if(Predmet != -1) {
				int code = JOptionPane.showOptionDialog(GlavniProzor.getGlavniProzor(), "Da li ste sigurni da zelite da obisete predmet: " + TabelaPredmeti.tabelaPredmeti.getValueAt(Predmet, 0), "Brisanje predmeta?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
			
				if(code == JOptionPane.YES_OPTION) {
					String sifraPredmeta = (String) TabelaPredmeti.tabelaPredmeti.getValueAt(Predmet, 0);
					GlavniProzor.getControllerPredmet().obrisiPredmet(sifraPredmeta);
					TabelaPredmeti.tabelaPredmeti.updateTable();
					GlavniProzor.serialize();
				}
			}
			break;
		}
	}

}
