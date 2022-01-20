package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;

import view.GlavniProzor;
import view.TabelaProfesori;
import view.TabelaStudenti;
import view.ToolBar;

public class SearchButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int tab = GlavniProzor.getTabbedPane().getSelectedIndex();
		
		switch(tab) {
		case 0:
			searchStudente();
			break;
		case 1:
			searchProfesore();
			break;
		case 2:
			searchPredmete();
			break;
		}

	}

	private void searchPredmete() {
		
	}

	private void searchProfesore() {
		String searchText[] = ToolBar.searchField.getText().trim().toLowerCase().split(",");
		ArrayList<String> nadjeniProfesori = new ArrayList<String>();
		nadjeniProfesori = GlavniProzor.getControllerProfesor().pretraziProfesore(searchText);
		if(nadjeniProfesori.size() == 0)
			ToolBar.searchField.setBorder(BorderFactory.createLineBorder(Color.RED));
		else
			if(searchText[0].isEmpty())
				ToolBar.searchField.setBorder(null);
			else
				ToolBar.searchField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		TabelaProfesori.tabelaProfesori.updateTable(nadjeniProfesori);
	}

	private void searchStudente() {
		String searchText[] = ToolBar.searchField.getText().trim().toLowerCase().split(",");
		ArrayList<String> nadjeniStudenti = new ArrayList<String>();
		nadjeniStudenti = GlavniProzor.getControllerStudent().pretraziStudente(searchText);
		if(nadjeniStudenti.size() == 0)
			ToolBar.searchField.setBorder(BorderFactory.createLineBorder(Color.RED));
		else
			if(searchText[0].isEmpty())
				ToolBar.searchField.setBorder(null);
			else
				ToolBar.searchField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		TabelaStudenti.tabelaStudenti.updateTable(nadjeniStudenti);
	}

}
