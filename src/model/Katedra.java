package model;

import java.util.ArrayList;

public class Katedra {
	
	private String sifraKatedre;
	private String nazivKatedre;
	private Profesor sefKatedre;
	private ArrayList<Profesor> spisakProfesora;
	
	//konstruktori
	
	
	public Katedra() {
		super();
	}


	public Katedra(String sifraKatedre, String nazivKatedre, Profesor sefKatedre, ArrayList<Profesor> spisakProfesora) {
		super();
		this.sifraKatedre = sifraKatedre;
		this.nazivKatedre = nazivKatedre;
		this.sefKatedre = sefKatedre;
		this.spisakProfesora = new ArrayList<Profesor>();
	}
	
	//get i set metode


	public String getSifraKatedre() {
		return sifraKatedre;
	}


	public void setSifraKatedre(String sifraKatedre) {
		this.sifraKatedre = sifraKatedre;
	}


	public String getNazivKatedre() {
		return nazivKatedre;
	}


	public void setNazivKatedre(String nazivKatedre) {
		this.nazivKatedre = nazivKatedre;
	}


	public Profesor getSefKatedre() {
		return sefKatedre;
	}


	public void setSefKatedre(Profesor sefKatedre) {
		this.sefKatedre = sefKatedre;
	}


	public ArrayList<Profesor> getSpisakProfesora() {
		return spisakProfesora;
	}


	public void setSpisakProfesora(ArrayList<Profesor> spisakProfesora) {
		this.spisakProfesora = spisakProfesora;
	}
	
	
	
	
	
	

}
