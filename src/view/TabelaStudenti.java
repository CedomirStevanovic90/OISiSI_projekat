package view;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabelaStudenti extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static TabelaStudenti tabelaStudenti;
	private static String[] nazivKolona = {"Index", "Name", "Surname", "Year of study", "Status", "Average"};
	static DefaultTableModel tableModel;
	
	public TabelaStudenti () {
		tabelaStudenti = this;
		tabelaStudenti.getTableHeader().setReorderingAllowed(false);
		Table(tabelaStudenti);
	}
	
	public void Table (TabelaStudenti tabelaStudenti) {
		tableModel = new DefaultTableModel(new Object[0][], nazivKolona);
		tableModel.setColumnIdentifiers(nazivKolona);
		tabelaStudenti.setModel(tableModel);
	}
	
}
