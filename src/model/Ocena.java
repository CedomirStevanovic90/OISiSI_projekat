package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Ocena implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student polozioIspit;
	private Predmet predmet;
	private int brVrednost;
	private LocalDate datumPolaganja;
	
	//konstruktori
	
	
	public Ocena() {
		super();
	}


	public Ocena(Student polozioIspit, Predmet predmet, int brVrednost, LocalDate datumPolaganja) {
		super();
		this.polozioIspit = polozioIspit;
		this.predmet = predmet;
		this.brVrednost = brVrednost;
		this.datumPolaganja = datumPolaganja;
	}
	
	//get i set metode


	public Student getPolozioIspit() {
		return polozioIspit;
	}


	public void setPolozioIspit(Student polozioIspit) {
		this.polozioIspit = polozioIspit;
	}


	public Predmet getPredmet() {
		return predmet;
	}


	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}


	public int getBrVrednost() {
		return brVrednost;
	}


	public void setBrVrednost(int brVrednost) {
		if(brVrednost >= 6 && brVrednost <= 10)
			this.brVrednost = brVrednost;
		else
			throw new IllegalArgumentException("Vrednost nije unutar intervala!");
	}


	public LocalDate getDatumPolaganja() {
		return datumPolaganja;
	}


	public void setDatumPolaganja(LocalDate datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}
	
	
	
	
	
	

}
