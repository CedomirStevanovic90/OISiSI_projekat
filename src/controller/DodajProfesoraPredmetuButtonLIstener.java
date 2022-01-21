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
import view.AddOrEditPredmet;
import view.AddOrEditProfesor;
import view.GlavniProzor;

public class DodajProfesoraPredmetuButtonLIstener implements ActionListener {

	ArrayList<String> listaBrojevaLicnih;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		addProfToPredDialog(AddOrEditPredmet.predmet);
	}

	private void addProfToPredDialog(Predmet predmet) {
		JDialog addProfToPredDialog = new JDialog();
		addProfToPredDialog.setResizable(false);
		addProfToPredDialog.setSize(300, 300);
		addProfToPredDialog.setModal(true);
		addProfToPredDialog.setLocationRelativeTo(AddOrEditProfesor.inst);
		addProfToPredDialog.setTitle("Dodavanje profesora predmetu");
		
		JPanel gore = new JPanel();
		gore.setPreferredSize(new Dimension(5, 5));
		addProfToPredDialog.add(gore, BorderLayout.NORTH);
		
		JPanel dole = new JPanel();
		JButton dodaj = new JButton("Dodaj");
		JButton odustani = new JButton("Odustani");
		dole.add(dodaj);
		dole.add(odustani);
		addProfToPredDialog.add(dole,BorderLayout.SOUTH);
		
		JPanel levo = new JPanel();
		levo.setPreferredSize(new Dimension(5, 5));
		addProfToPredDialog.add(levo, BorderLayout.WEST);
		
		JPanel desno = new JPanel();
		desno.setPreferredSize(new Dimension(5, 5));
		addProfToPredDialog.add(desno, BorderLayout.EAST);
		
		JList<String> listaProfesora = new JList<String>();
		listaBrojevaLicnih = new ArrayList<String>();
		DefaultListModel<String> defaultListModel = new DefaultListModel<String>();
		for(Profesor profesor : GlavniProzor.getControllerProfesor().getListaProfesora()) {
			if(predmet != null) {
				if(!GlavniProzor.getControllerPredmet().proveriPredmet(predmet)) {
					String row = profesor.getIme() + " " + profesor.getPrezime();
					listaBrojevaLicnih.add(profesor.getBrojLicneKarte());
					defaultListModel.addElement(row);
				}
			}else {
				String row = profesor.getIme() + " " + profesor.getPrezime();
				listaBrojevaLicnih.add(profesor.getBrojLicneKarte());
				defaultListModel.addElement(row);
			}
		}
		listaProfesora.setModel(defaultListModel);
		
		
		JPanel panel = new JPanel();
		JScrollPane jScrollPane = new JScrollPane(listaProfesora);
		jScrollPane.setPreferredSize(new Dimension(270, 200));
		panel.add(jScrollPane);
		addProfToPredDialog.add(panel, BorderLayout.CENTER);
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addProfToPredDialog.setVisible(false);
			}
		});
		dodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listaProfesora.getSelectedIndex() != -1) {
					int index = listaProfesora.getSelectedIndex();
					Profesor profesor = GlavniProzor.getControllerProfesor().nadjiProfesora(listaBrojevaLicnih.get(index));
					AddOrEditPredmet.profesor = profesor;
					AddOrEditPredmet.textProfesor.setText(profesor.getIme() + " " + profesor.getPrezime());
					
					addProfToPredDialog.setVisible(false);
					AddOrEditPredmet.minus.setEnabled(true);
					AddOrEditPredmet.plus.setEnabled(false);
					AddOrEditPredmet.imaProfesora = true;
					
					GlavniProzor.serialize();
				}
			}
		});
		addProfToPredDialog.setVisible(true);
	}

}
