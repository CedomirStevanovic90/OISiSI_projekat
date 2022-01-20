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

	public void obrisiPredmet(String sifraPredmeta) {
		// TODO Auto-generated method stub
				for(Predmet p : listaPredmeta)
					if(p.getSifraPredmeta().equals(sifraPredmeta)) {
						listaPredmeta.remove(p);
						break;
					}
	}

	public Predmet nadjiPredmet(String sifraPredmeta) {
		Predmet ret = null;
		for(Predmet p : listaPredmeta)
			if(p.getSifraPredmeta().equals(sifraPredmeta))
				ret = p;
		return ret;
	}

	public ArrayList<String> pretraziPredmete(String[] searchText) {
		ArrayList<String> searchSifraPredmeta = new ArrayList<String>();
		if(searchText.length == 1) {
			for(Predmet predmet : listaPredmeta) {
				if(predmet.getSifraPredmeta().toLowerCase().indexOf(searchText[0].trim()) != -1)
					searchSifraPredmeta.add(predmet.getSifraPredmeta());
			}
		}else if(searchText.length == 2) {
			for(Predmet predmet : listaPredmeta)
				if(predmet.getNazivPredmeta().toLowerCase().indexOf(searchText[0].trim()) != -1)
					if(predmet.getSifraPredmeta().toLowerCase().indexOf(searchText[1].trim()) != -1)
						searchSifraPredmeta.add(predmet.getSifraPredmeta());
		}
		
		return searchSifraPredmeta;
	}
	
}
