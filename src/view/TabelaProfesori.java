package view;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerProfesor;
import model.Profesor;

public class TabelaProfesori extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static ControllerProfesor controller;
	
	public static TabelaProfesori tabelaProfesori;
	private static String[] nazivKolona = {"Name", "Surname", "Faculty title", "E-mail adress"};
	static DefaultTableModel tableModel;
	
	public TabelaProfesori () {
		tabelaProfesori = this;
		tabelaProfesori.getTableHeader().setReorderingAllowed(false);
		controller = GlavniProzor.getControllerProfesor();
		initializeTable(tabelaProfesori);
		updateTable();
	}
	
	public void initializeTable (TabelaProfesori tabelaProfesori) {
		tableModel = new DefaultTableModel(new Object[0][], nazivKolona);
		tableModel.setColumnIdentifiers(nazivKolona);
		tabelaProfesori.setModel(tableModel);
	}
	
	public void updateTable() {
		ArrayList<Profesor> listaProfesora = controller.getListaProfesora();
		
		initializeTable(tabelaProfesori);
		
		for(Profesor p : listaProfesora) {
			Object[] data = { "", "", "", ""};
			data[0] = p.getIme();
			data[1] = p.getPrezime();
			data[2] = p.getZvanje();
			data[3] = p.getEmailAdresa();
			tableModel.addRow(data);
		}
	}

	public Profesor getProfesor(int profesor) {
		// TODO Auto-generated method stub
		ArrayList<Profesor> listaProfesora = controller.getListaProfesora();
		
		return listaProfesora.get(profesor);
	}
}