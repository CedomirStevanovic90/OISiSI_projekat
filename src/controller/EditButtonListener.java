package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddOrEditDialog;
import view.GlavniProzor;
import view.TabelaProfesori;
import view.TabelaStudenti;

public class EditButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		int tab = GlavniProzor.getTabbedPane().getSelectedIndex();
		AddOrEditDialog aoed;
		
		int rowCheck, rowCheckStud;
		rowCheck = TabelaProfesori.tabelaProfesori.getSelectedRow();
		rowCheckStud = TabelaStudenti.tabelaStudenti.getSelectedRow();
		if(rowCheck == -1 && rowCheckStud == -1)
			return;
		
		switch(tab) {
		case 0:
			//Edit za studenta
			if(rowCheckStud != -1) {
				aoed = new AddOrEditDialog(AddOrEditDialog.editMode);
				aoed.pack();
				aoed.setVisible(true);
			}
			break;
		case 1:
			//Edit za profesore
			if(rowCheck != -1) {
				aoed = new AddOrEditDialog(AddOrEditDialog.editMode);
				aoed.setVisible(true);
			}
			break;
		
		}
		
	}

}
