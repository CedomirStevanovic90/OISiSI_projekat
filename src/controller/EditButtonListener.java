package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddOrEditDialog;
import view.GlavniProzor;
import view.TabelaPredmeti;
import view.TabelaProfesori;
import view.TabelaStudenti;

public class EditButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		int tab = GlavniProzor.getTabbedPane().getSelectedIndex();
		AddOrEditDialog aoed;
		
		int rowCheckProf, rowCheckStud, rowCheckPred;
		rowCheckProf = TabelaProfesori.tabelaProfesori.getSelectedRow();
		rowCheckStud = TabelaStudenti.tabelaStudenti.getSelectedRow();
		rowCheckPred = TabelaPredmeti.tabelaPredmeti.getSelectedRow();
		if(rowCheckProf == -1 && rowCheckStud == -1 && rowCheckPred == -1)
			return;
		
		switch(tab) {
		case 0:
			//Edit za studenta
			if(rowCheckStud != -1) {
				aoed = new AddOrEditDialog(AddOrEditDialog.editMode);
				aoed.setVisible(true);
			}
			break;
		case 1:
			//Edit za profesore
			if(rowCheckProf != -1) {
				aoed = new AddOrEditDialog(AddOrEditDialog.editMode);
				aoed.setVisible(true);
			}
			break;
		case 2:
			//Edit za predmete
			if(rowCheckPred != -1) {
				aoed = new AddOrEditDialog(AddOrEditDialog.editMode);
				aoed.setVisible(true);
			}
			break;
		}
		
	}

}
