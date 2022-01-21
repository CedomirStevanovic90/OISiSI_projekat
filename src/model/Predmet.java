package model;

import java.io.Serializable;
import java.util.ArrayList;

import enumeracije.GodinaIzvodjenja;
import enumeracije.Semestar;

public class Predmet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String sifraPredmeta;
	private String nazivPredmeta;
	private Semestar semestar;
	private GodinaIzvodjenja godinaIzvodjenja;
	private Profesor profesor;
	private int espbPoeni;
	private ArrayList<Student> listaPolozenih;
	private ArrayList<Student> listaNepolozenih;
	
	//konstruktori
	
	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, GodinaIzvodjenja godinaIzvodjenja,
			Profesor profesor, int espbPoeni, ArrayList<Student> listaPolozenih, ArrayList<Student> listaNepolozenih) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaIzvodjenja = godinaIzvodjenja;
		this.profesor = profesor;
		this.espbPoeni = espbPoeni;
		this.listaPolozenih = new ArrayList<Student>();
		this.listaNepolozenih = new ArrayList<Student>();
	}
	
	//get i set metode

	public String getSifraPredmeta() {
		return sifraPredmeta;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}


	public String getNazivPredmeta() {
		return nazivPredmeta;
	}


	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}


	public Semestar getSemestar() {
		return semestar;
	}


	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}


	public GodinaIzvodjenja getGodinaIzvodjenja() {
		return godinaIzvodjenja;
	}


	public void setGodinaIzvodjenja(GodinaIzvodjenja godinaIzvodjenja) {
		this.godinaIzvodjenja = godinaIzvodjenja;
	}


	public Profesor getProfesor() {
		return profesor;
	}


	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}


	public int getEspbPoeni() {
		return espbPoeni;
	}


	public void setEspbPoeni(int espbPoeni) {
		this.espbPoeni = espbPoeni;
	}


	public ArrayList<Student> getListaPolozenih() {
		return listaPolozenih;
	}


	public void setListaPolozenih(ArrayList<Student> listaPolozenih) {
		this.listaPolozenih = listaPolozenih;
	}


	public ArrayList<Student> getListaNepolozenih() {
		return listaNepolozenih;
	}


	public void setListaNepolozenih(ArrayList<Student> listaNepolozenih) {
		this.listaNepolozenih = listaNepolozenih;
	}

	public String outGodIzv(GodinaIzvodjenja g) {
			String out = "";
			
			switch(g) {
			case PRVA : out = "FIRST"; break;                                   
			case DRUGA : out = "SECOND"; break;                                  
			case TRECA : out = "THIRD"; break;                                  
			case CETVRTA : out = "FOURTH"; break;                                
			}
			
			return out;
		}
	}
	
	

