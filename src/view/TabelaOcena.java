package view;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerStudent;
import model.Ocena;

public class TabelaOcena extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static ControllerStudent controller;
	public static TabelaOcena tabelaOcena;
	private static String[] nazivKolona = {"Sifra predmeta", "Naziv predmeta", "ESPB", "Ocena", "Datum"};
	static DefaultTableModel tableModel;
	
	public TabelaOcena(String index) {
		tabelaOcena = this;
		tabelaOcena.getTableHeader().setReorderingAllowed(false);
		controller = GlavniProzor.getControllerStudent();
		initializeTable(tabelaOcena);		
		updateTable(index);
	}
	
	public void initializeTable (TabelaOcena tabelaOcena) {
		tableModel = new DefaultTableModel(new Object[0][], nazivKolona);
		tableModel.setColumnIdentifiers(nazivKolona);
		tabelaOcena.setModel(tableModel);
	}
	
	public void updateTable(String index) {
		ArrayList<Ocena> listaOcena = controller.nadjiStudenta(index).getPolozeniIspiti();

		initializeTable(tabelaOcena);

		for(Ocena o : listaOcena) {
			Object[] data = { "", "", "", "", "", ""};
			data[0] = o.getPredmet().getSifraPredmeta();
			data[1] = o.getPredmet().getNazivPredmeta();
			data[2] = Integer.toString(o.getPredmet().getEspbPoeni());
			data[3] = Integer.toString(o.getBrVrednost());
			data[4] = o.getDatumPolaganja();
			
			tableModel.addRow(data);
		}
	}
}
