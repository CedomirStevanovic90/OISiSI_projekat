package view;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabelaProfesori extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static TabelaProfesori tabelaProfesori;
	private static String[] nazivKolona = {"Name", "Surname", "Faculty title", "E-mail adress"};
	static DefaultTableModel tableModel;
	
	public TabelaProfesori () {
		tabelaProfesori = this;
		tabelaProfesori.getTableHeader().setReorderingAllowed(false);
		Table(tabelaProfesori);
	}
	
	public void Table (TabelaProfesori tabelaProfesori) {
		tableModel = new DefaultTableModel(new Object[0][], nazivKolona);
		tableModel.setColumnIdentifiers(nazivKolona);
		tabelaProfesori.setModel(tableModel);
	}
	
}