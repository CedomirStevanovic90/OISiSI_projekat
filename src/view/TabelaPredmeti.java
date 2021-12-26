package view;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabelaPredmeti extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
}
