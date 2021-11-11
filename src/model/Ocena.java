package model;

public class Ocena {
	
	private Student polozioIspit;
	private Predmet predmet;
	private int brVrednost;
	private String datumPolaganja;
	
	//konstruktori
	
	
	public Ocena() {
		super();
	}


	public Ocena(Student polozioIspit, Predmet predmet, int brVrednost, String datumPolaganja) {
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


	public String getDatumPolaganja() {
		return datumPolaganja;
	}


	public void setDatumPolaganja(String datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}
	
	
	
	
	
	

}
