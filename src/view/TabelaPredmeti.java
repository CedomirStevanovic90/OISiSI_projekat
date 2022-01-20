package view;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerPredmet;
import controller.ControllerProfesor;
import controller.ControllerStudent;
import model.Predmet;

public class TabelaPredmeti extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static ControllerPredmet controllerPR;
	static ControllerStudent controllerST;
	static ControllerProfesor controllerP;
	
	public static TabelaPredmeti tabelaPredmeti;
	private static String[] nazivKolona = {"Subject ID", "Subject name", "ECTS", "Year", "Semester"};
	private static String[] nazivKolonaProfesor = {"Subject ID", "Subject name", "Year", "Semester"};
	static DefaultTableModel tableModel;
	public static TabelaPredmeti nepolozeni;
	public static TabelaPredmeti profesori;
	
	public TabelaPredmeti () {
		tabelaPredmeti = this;
		tabelaPredmeti.getTableHeader().setReorderingAllowed(false);
		tabelaPredmeti.setAutoCreateRowSorter(true);
		controllerPR = GlavniProzor.getControllerPredmet();
		initializeTable(tabelaPredmeti);
		updateTable();
	}
	
	public TabelaPredmeti(String brIndeksa) {
		nepolozeni = this;
		nepolozeni.getTableHeader().setReorderingAllowed(false);
		controllerST = GlavniProzor.getControllerStudent();
		initializeTable(nepolozeni);
		updateTable(brIndeksa);
	}

	public TabelaPredmeti(String brLicne, int i) {
		profesori = this;
		profesori.getTableHeader().setReorderingAllowed(false);
		controllerP = GlavniProzor.getControllerProfesor();
		initializeTable(profesori, i);
		updateTable(brLicne, i);
	}

	public void updateTable(String brLicne, int i) {
		ArrayList<Predmet> listaPredmeta = controllerP.nadjiProfesora(brLicne).getSpisakPredmeta();
		
		initializeTable(tabelaPredmeti, i);
		
		for(Predmet p : listaPredmeta) {
			Object[] data = { "", "", "", "", ""};
			data[0] = p.getSifraPredmeta();
			data[1] = p.getNazivPredmeta();
			data[2] = p.getGodinaIzvodjenja();
			data[3] = p.getSemestar();
			tableModel.addRow(data);
		}
		
	}

	private void initializeTable(TabelaPredmeti tabelaPredmeti, int i) {
		tableModel = new DefaultTableModel(new Object[0][], nazivKolonaProfesor);
		tableModel.setColumnIdentifiers(nazivKolonaProfesor);
		tabelaPredmeti.setModel(tableModel);
	}

	public void initializeTable (TabelaPredmeti tabelaPredmeti) {
		tableModel = new DefaultTableModel(new Object[0][], nazivKolona);
		tableModel.setColumnIdentifiers(nazivKolona);
		tabelaPredmeti.setModel(tableModel);
	}

	public void updateTable() {
		ArrayList<Predmet> listaPredmeta = controllerPR.getListaPredmeta();
		
		initializeTable(tabelaPredmeti);
		
		for(Predmet p : listaPredmeta) {
			Object[] data = { "", "", "", "", ""};
			data[0] = p.getSifraPredmeta();
			data[1] = p.getNazivPredmeta();
			data[2] = p.getEspbPoeni();
			data[3] = p.getGodinaIzvodjenja();
			data[4] = p.getSemestar();
			tableModel.addRow(data);
		}
	}
	

	public void updateTable(String brIndeksa) {
		ArrayList<Predmet> listaPredmeta = controllerST.nadjiStudenta(brIndeksa).getNepolozeniIspiti();

        initializeTable(nepolozeni);

        for(Predmet p : listaPredmeta) {
        	Object[] data = { "", "", "", "", ""};
			data[0] = p.getSifraPredmeta();
			data[1] = p.getNazivPredmeta();
			data[2] = p.getEspbPoeni();
			data[3] = p.getGodinaIzvodjenja();
			data[4] = p.getSemestar();
			tableModel.addRow(data);
        }
	}

	public void updateTable(ArrayList<String> nadjeniPredmeti) {
		ArrayList<Predmet> listaPredmeta = controllerPR.getListaPredmeta();
		
		initializeTable(tabelaPredmeti);
		
		for(Predmet p : listaPredmeta) {
			for(String p1 : nadjeniPredmeti) {
				if(p.getSifraPredmeta().equals(p1)) {
					Object[] data = { "", "", "", "", ""};
					data[0] = p.getSifraPredmeta();
					data[1] = p.getNazivPredmeta();
					data[2] = p.getEspbPoeni();
					data[3] = p.getGodinaIzvodjenja();
					data[4] = p.getSemestar();
					tableModel.addRow(data);
				}
			}
		}
	}
}
