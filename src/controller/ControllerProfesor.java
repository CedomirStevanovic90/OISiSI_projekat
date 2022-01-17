package controller;

import java.util.ArrayList;

import model.Profesor;
import model.Student;

public class ControllerProfesor {

	private ArrayList<Profesor> listaProfesora;
	
	public ControllerProfesor() {
		listaProfesora = new ArrayList<Profesor>();
	}
	
	public ArrayList<Profesor> getListaProfesora(){
		return this.listaProfesora;
	}

	public boolean dodajProfesora(Profesor profesor) {
		if(listaProfesora.isEmpty()) {
			listaProfesora.add(profesor);
			return true;
		}
		for(Profesor temp : listaProfesora)
			if(temp.getBrojLicneKarte().equals(profesor.getBrojLicneKarte()) || temp.getEmailAdresa().equals(profesor.getEmailAdresa()))
				return false;
		listaProfesora.add(profesor);		
		return true;
	}

	public void setListaProfesori(ArrayList<Profesor> listaProfesora) {
		this.listaProfesora = listaProfesora;
	}
	
	public Profesor nadjiProfesora(String brojLicneKarte) {
		Profesor ret = null;
		for(Profesor p : listaProfesora)
			if(p.getBrojLicneKarte().equals(brojLicneKarte))
				ret = p;
		return ret;
	}

	public void obrisiProfesora(String brojLicneKarte) {
		// TODO Auto-generated method stub
		for(Profesor p : listaProfesora)
			if(p.getBrojLicneKarte().equals(brojLicneKarte)) {
				listaProfesora.remove(p);
				break;
			}
	}
	
}
