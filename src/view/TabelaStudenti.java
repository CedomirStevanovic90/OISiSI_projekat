package view;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerStudent;
import model.Student;

public class TabelaStudenti extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static ControllerStudent controller;
	
	public static TabelaStudenti tabelaStudenti;
	private static String[] nazivKolona = {"Index", "Name", "Surname", "Year of study", "Status", "Average"};
	static DefaultTableModel tableModel;
	
	public TabelaStudenti () {
		tabelaStudenti = this;
		tabelaStudenti.getTableHeader().setReorderingAllowed(false);
		controller = GlavniProzor.getControllerStudent();
		initializeTable(tabelaStudenti);
		updateTable();
	}
	
	public void initializeTable (TabelaStudenti tabelaStudenti) {
		tableModel = new DefaultTableModel(new Object[0][], nazivKolona);
		tableModel.setColumnIdentifiers(nazivKolona);
		tabelaStudenti.setModel(tableModel);
	}
	
	public void updateTable() {
		ArrayList<Student> listaStudenata = controller.getListaStudenata();
		
		initializeTable(tabelaStudenti);
		
		for(Student s : listaStudenata) {
			Object[] data = { "", "", "", "", "", ""};
			data[0] = s.getBrojIndeksa();
			data[1] = s.getIme();
			data[2] = s.getPrezime();
			data[3] = Integer.toString(s.getTrenutnaGodStudija());
			data[4] = s.getStatus();
			data[5] = Math.round(s.getProsecnaOcena() * 100.0) / 100.0;
			tableModel.addRow(data);
		}
	}
}
