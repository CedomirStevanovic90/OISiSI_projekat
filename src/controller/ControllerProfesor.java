package controller;

import java.util.ArrayList;

import model.Profesor;

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

	public Profesor nadjiProfesora(String editProfBrLic) {
		Profesor ret = null;
		for(Profesor s : listaProfesora)
			if(s.getBrojLicneKarte().equals(editProfBrLic))
				ret = s;
		return ret;
	}
	
}
