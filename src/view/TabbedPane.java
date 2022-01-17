package view;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TabbedPane(){
		
		TabelaStudenti tabelaStudenti = new TabelaStudenti();
		JScrollPane tabelaStudentPane = new JScrollPane(tabelaStudenti);
		this.addTab("Students", tabelaStudentPane);
		
		TabelaProfesori tabelaProfesori = new TabelaProfesori();
		JScrollPane tabelaProfesorPane = new JScrollPane(tabelaProfesori);
		this.addTab("Professors", tabelaProfesorPane);
		
		TabelaPredmeti tabelaPredmeti = new TabelaPredmeti();
		JScrollPane tabelaPredmetPane = new JScrollPane(tabelaPredmeti);
		this.addTab("Subjects", tabelaPredmetPane);
		
	}
}
