package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Predmet;
import model.Profesor;
import view.AddOrEditProfesor;
import view.GlavniProzor;
import view.TabelaPredmeti;

public class DodajPredmetProfesoruButtonLIstener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		addPredToProfDialog(AddOrEditProfesor.professor);
	}

	private void addPredToProfDialog(Profesor profesor) {
		JDialog addPredToProfDialog = new JDialog();
		addPredToProfDialog.setResizable(false);
		addPredToProfDialog.setSize(300, 300);
		addPredToProfDialog.setModal(true);
		addPredToProfDialog.setLocationRelativeTo(AddOrEditProfesor.inst);
		addPredToProfDialog.setTitle("Dodavanje predmeta profesoru");
		
		JPanel gore = new JPanel();
		gore.setPreferredSize(new Dimension(5, 5));
		addPredToProfDialog.add(gore, BorderLayout.NORTH);
		
		JPanel dole = new JPanel();
		JButton dodaj = new JButton("Dodaj");
		JButton odustani = new JButton("Odustani");
		dole.add(dodaj);
		dole.add(odustani);
		addPredToProfDialog.add(dole,BorderLayout.SOUTH);
		
		JPanel levo = new JPanel();
		levo.setPreferredSize(new Dimension(5, 5));
		addPredToProfDialog.add(levo, BorderLayout.WEST);
		
		JPanel desno = new JPanel();
		desno.setPreferredSize(new Dimension(5, 5));
		addPredToProfDialog.add(desno, BorderLayout.EAST);
		
		JList<String> listaPredmeta = new JList<String>();
		DefaultListModel<String> defaultListModel = new DefaultListModel<String>();
		for(Predmet predmet : GlavniProzor.getControllerPredmet().getListaPredmeta()) {
			if(!GlavniProzor.getControllerPredmet().proveriPredmet(profesor, predmet)) {
				String row = predmet.getSifraPredmeta() + " - " + predmet.getNazivPredmeta();
				defaultListModel.addElement(row);
			}
		}
		listaPredmeta.setModel(defaultListModel);
		
		
		JPanel panel = new JPanel();
		JScrollPane jScrollPane = new JScrollPane(listaPredmeta);
		jScrollPane.setPreferredSize(new Dimension(270, 200));
		panel.add(jScrollPane);
		addPredToProfDialog.add(panel, BorderLayout.CENTER);
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addPredToProfDialog.setVisible(false);
			}
		});
		dodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int idxPredmeta[] = listaPredmeta.getSelectedIndices();
				ArrayList<String> selectedPredmeti = new ArrayList<String>();
				String predmeti[];
				for(int i : idxPredmeta) {
					predmeti = defaultListModel.get(i).split(" - ");
					selectedPredmeti.add(predmeti[0]);
				}
				
				GlavniProzor.getControllerPredmet().dodajPredmeteProfesoru(selectedPredmeti, profesor);
				
				TabelaPredmeti.profesori.updateTable(profesor.getBrojLicneKarte(), 2);
				
				GlavniProzor.serialize();
				addPredToProfDialog.setVisible(false);
			}
		});
		
		addPredToProfDialog.setVisible(true);
	}

}
