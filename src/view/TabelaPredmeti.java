package view;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerPredmet;
import model.Predmet;
import model.Profesor;

public class TabelaPredmeti extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static ControllerPredmet controller;
	
	public static TabelaPredmeti tabelaPredmeti;
	private static String[] nazivKolona = {"Subject ID", "Subject name", "ECTS", "Year", "Semester"};
	static DefaultTableModel tableModel;
	
	public TabelaPredmeti () {
		tabelaPredmeti = this;
		tabelaPredmeti.getTableHeader().setReorderingAllowed(false);
		Table(tabelaPredmeti);
	}

	private void Table(TabelaPredmeti tabelaPredmeti) {
		tableModel = new DefaultTableModel(new Object[0][], nazivKolona);
		tableModel.setColumnIdentifiers(nazivKolona);
		tabelaPredmeti.setModel(tableModel);
	}
	public void initializeTable (TabelaPredmeti tabelaPredmeti) {
		tableModel = new DefaultTableModel(new Object[0][], nazivKolona);
		tableModel.setColumnIdentifiers(nazivKolona);
		tabelaPredmeti.setModel(tableModel);
	}
	
	public void updateTable() {
//		ArrayList<Predmet> listaPredmeta = controller.getListaPredmeta();
//		
//		initializeTable(tabelaPredmeti);
//		
//		for(Predmet p : listaPredmeta) {
//			Object[] data = { "", "", "", "", ""};
//			data[0] = p.getIme();
//			data[1] = p.getPrezime();
//			data[2] = p.getZvanje();
//			data[3] = p.getEmailAdresa();
//			tableModel.addRow(data);
//		}
	}
}
