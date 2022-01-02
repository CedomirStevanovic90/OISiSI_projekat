package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddOrEditDialog;
import view.GlavniProzor;

public class AddButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int tab = GlavniProzor.getTabbedPane().getSelectedIndex();
		
		switch(tab) {
		case 0:
			//Add za studente
			AddOrEditDialog dialogStud = new AddOrEditDialog(AddOrEditDialog.addMode);
			dialogStud.pack();
			dialogStud.setVisible(true);
			break;
		case 1:
			//Add za profesore
			AddOrEditDialog dialogProf = new AddOrEditDialog(AddOrEditDialog.addMode);
			dialogProf.pack();
			dialogProf.setVisible(true);
			break;
		case 2:
			//Add za predmete
			AddOrEditDialog dialogPred = new AddOrEditDialog(AddOrEditDialog.addMode);
			dialogPred.pack();
			dialogPred.setVisible(true);
			break;
		}
	}

}
