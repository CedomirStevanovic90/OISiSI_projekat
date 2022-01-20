package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import view.AddOrEditStudent;
import view.ErrorDialog;
import view.GlavniProzor;
import view.TabelaOcena;
import view.TabelaPredmeti;
import view.TabelaStudenti;

public class PonistiOcenuButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int selectedIndex = TabelaOcena.tabelaOcena.getSelectedRow();
		
		if(selectedIndex == -1) {
			@SuppressWarnings("unused")
			ErrorDialog err;
			err = new ErrorDialog("You haven't chosen any grade");
			return;
		}
		
		String temp = (String) TabelaOcena.tabelaOcena.getValueAt(selectedIndex, 0);
		ArrayList<String> temps = new ArrayList<String>();
		temps.add(temp);
		String [] options = {"Yes", "No"};
		int code = JOptionPane.showOptionDialog(AddOrEditStudent.inst, "Cancel the selected grade?", "Grade canceling", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
		
		if(code == JOptionPane.YES_OPTION) {
			GlavniProzor.getControllerStudent().obrisiOcenuIzListePolozenih(temp, AddOrEditStudent.student);
			TabelaOcena.tabelaOcena.updateTable(AddOrEditStudent.student.getBrojIndeksa());
			GlavniProzor.getControllerStudent().dodajNepolozenePredmete(temps, AddOrEditStudent.student);
			TabelaPredmeti.tabelaPredmeti.updateTable(AddOrEditStudent.student.getBrojIndeksa());
			GlavniProzor.getControllerStudent().prosecnaOcena(AddOrEditStudent.student);
			AddOrEditStudent.inst.updateEspbAndProsek(AddOrEditStudent.student);
			TabelaStudenti.tabelaStudenti.updateTable();
			GlavniProzor.serialize();
		}

	}

}
