package controller;

import java.util.ArrayList;

import model.Ocena;
import model.Predmet;
import model.Student;
import view.GlavniProzor;

public class ControllerStudent {
	
	ArrayList<Student> listaStudenti;
	
	public ControllerStudent() {
		listaStudenti = new ArrayList<Student>();
	}
	
	public ArrayList<Student> getListaStudenata(){
		return this.listaStudenti;
	}
	
	public boolean dodajStudenta(Student student) {
		if(listaStudenti.isEmpty()) {
			listaStudenti.add(student);
			return true;
		}	
		for(Student temp: listaStudenti) {
			if(temp.getBrojIndeksa().equals(student.getBrojIndeksa())) {
				return false;
			}			
		}
		listaStudenti.add(student);
		return true;
	}
	
	public Student nadjiStudenta(String index) {
		Student ret = null;
		for(Student s : listaStudenti)
			if(s.getBrojIndeksa().equals(index))
				ret = s;
		return ret;
	}
	
	public void setListaStudenti(ArrayList<Student> listaStudenti) {
		this.listaStudenti = listaStudenti;
	}

	public void obrisiStudenta(String indexStudenta) {
		// TODO Auto-generated method stub
		for(Student s : listaStudenti)
			if(s.getBrojIndeksa().equals(indexStudenta)) {
				listaStudenti.remove(s);
				break;
			}
	}

	public int ukupnoEspb(String brojIndeksa) {
		// TODO Auto-generated method stub
		Student student = nadjiStudenta(brojIndeksa);
		int espb = 0;
		for(Ocena o : student.getPolozeniIspiti()) {
			espb += o.getPredmet().getEspbPoeni();
		}
		return espb;
	}

	public boolean proveriPred(Student student, Predmet p) {
        for(Predmet pred : student.getNepolozeniIspiti())
            if(pred.equals(p))
                return true;
        
        switch(p.getGodinaIzvodjenja()) {
	        case PRVA: 
	        	break;
	        case DRUGA: 
	        	if(student.getTrenutnaGodStudija() < 2) 
	        		return true; 
	        	break;
	        case TRECA: 
	        	if(student.getTrenutnaGodStudija() < 3) 
					return true; 
				break;
			default: 
				if(student.getTrenutnaGodStudija() < 4) 
					return true; 
				break;
        }
		return false;
	}

	public void dodajNepolozenePredmete(ArrayList<String> selectedPredmeti, Student student) {
        for(String s : selectedPredmeti) {
        	Predmet p = GlavniProzor.getControllerPredmet().nadjiPredmet(s);
        	if(p != null) {
        		student.getNepolozeniIspiti().add(p);
        		p.getListaNepolozenih().add(student);
        	}
        }
	}
}
