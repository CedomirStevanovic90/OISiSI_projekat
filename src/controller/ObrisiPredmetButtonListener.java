package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Student;
import view.AddOrEditStudent;
import view.ErrorDialog;
import view.GlavniProzor;
import view.TabelaPredmeti;

public class ObrisiPredmetButtonListener implements ActionListener {

	private ErrorDialog err;
	@Override
	public void actionPerformed(ActionEvent e) {
		int selectedIndex = TabelaPredmeti.nepolozeni.getSelectedRow();
		
		if(selectedIndex == -1) {
			err = new ErrorDialog("You haven't chosen any subject");
			return;
		}
		
		
		String temp = (String) TabelaPredmeti.nepolozeni.getValueAt(selectedIndex, 0);
		
		String [] options = {"Yes","No"};
		int code = JOptionPane.showOptionDialog(AddOrEditStudent.inst, "Remove the selected subject?", "Subject removing", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
		
		if(code == JOptionPane.YES_OPTION) {	
			GlavniProzor.getControllerStudent().obrisiPredmet(temp, AddOrEditStudent.student);
			TabelaPredmeti.nepolozeni.updateTable(AddOrEditStudent.student.getBrojIndeksa());
		}
		
	}
	

}
