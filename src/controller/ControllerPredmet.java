package controller;

import java.util.ArrayList;

import model.Predmet;

public class ControllerPredmet {

	private ArrayList<Predmet> listaPredmeta;
	
	public ControllerPredmet() {
		listaPredmeta = new ArrayList<Predmet>();
	}
	
	public ArrayList<Predmet> getListaPredmeta(){
		return this.listaPredmeta;
	}

	public boolean dodajPredmet(Predmet predmet) {
		if(listaPredmeta.isEmpty()) {
			listaPredmeta.add(predmet);
			return true;
		}
		for(Predmet temp : listaPredmeta)
			if(temp.getSifraPredmeta().equals(predmet.getSifraPredmeta()) || temp.getNazivPredmeta().equals(predmet.getNazivPredmeta()))
				return false;
		listaPredmeta.add(predmet);		
		return true;
	}

	public void setListaPredmeti(ArrayList<Predmet> listaPredmeta) {
		this.listaPredmeta = listaPredmeta;
	}
	
}