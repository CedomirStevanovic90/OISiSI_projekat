package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;

import view.GlavniProzor;
import view.TabelaPredmeti;
import view.TabelaProfesori;
import view.TabelaStudenti;
import view.ToolBar;

public class SearchButtonListener implements ActionListener {
	private String searchText[];
	ArrayList<String> nadjeni;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int tab = GlavniProzor.getTabbedPane().getSelectedIndex();
		searchText = ToolBar.searchField.getText().trim().toLowerCase().split(",");
		nadjeni = new ArrayList<String>();
		
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
		nadjeni = GlavniProzor.getControllerPredmet().pretraziPredmete(searchText);
		if(nadjeni.size() == 0)
			ToolBar.searchField.setBorder(BorderFactory.createLineBorder(Color.RED));
		else
			if(searchText[0].isEmpty())
				ToolBar.searchField.setBorder(null);
			else
				ToolBar.searchField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		TabelaPredmeti.tabelaPredmeti.updateTable(nadjeni);
	}

	private void searchProfesore() {
		nadjeni = GlavniProzor.getControllerProfesor().pretraziProfesore(searchText);
		if(nadjeni.size() == 0)
			ToolBar.searchField.setBorder(BorderFactory.createLineBorder(Color.RED));
		else
			if(searchText[0].isEmpty())
				ToolBar.searchField.setBorder(null);
			else
				ToolBar.searchField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		TabelaProfesori.tabelaProfesori.updateTable(nadjeni);
	}

	private void searchStudente() {
		nadjeni = GlavniProzor.getControllerStudent().pretraziStudente(searchText);
		if(nadjeni.size() == 0)
			ToolBar.searchField.setBorder(BorderFactory.createLineBorder(Color.RED));
		else
			if(searchText[0].isEmpty())
				ToolBar.searchField.setBorder(null);
			else
				ToolBar.searchField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		TabelaStudenti.tabelaStudenti.updateTable(nadjeni);
	}

}
