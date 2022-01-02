package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import enumeracije.StatusStudenta;

public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String prezime;
	private String ime;
	private LocalDate datumRodjenja;
	private Adresa adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String brojIndeksa;
	private String godinaUpisa;
	private int trenutnaGodStudija;
	private StatusStudenta status;
	private double prosecnaOcena;
	private ArrayList<Ocena> polozeniIspiti;
	private ArrayList<Predmet> nepolozeniIspiti;
	
	//konstruktori
	
	public Student(String prezime, String ime, LocalDate datumRodjenja, Adresa adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String brojIndeksa, String godinaUpisa, int trenutnaGodStudija, StatusStudenta status,
			double prosecnaOcena) {
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodStudija = trenutnaGodStudija;
		this.status = status;
		this.prosecnaOcena = prosecnaOcena;
		this.polozeniIspiti = new ArrayList<Ocena>();
		this.nepolozeniIspiti = new ArrayList<Predmet>();
	}
	
	
	//get i set metode



	public String getPrezime() {
		return prezime;
	}



	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}



	public String getIme() {
		return ime;
	}



	public void setIme(String ime) {
		this.ime = ime;
	}



	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}



	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}



	public Adresa getAdresaStanovanja() {
		return adresaStanovanja;
	}



	public void setAdresaStanovanja(Adresa adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}



	public String getKontaktTelefon() {
		return kontaktTelefon;
	}



	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}



	public String getEmailAdresa() {
		return emailAdresa;
	}



	public void setEmailAdresa(String emailAdresa) {
		this.emailAdresa = emailAdresa;
	}



	public String getBrojIndeksa() {
		return brojIndeksa;
	}



	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}



	public String getGodinaUpisa() {
		return godinaUpisa;
	}



	public void setGodinaUpisa(String godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}



	public int getTrenutnaGodStudija() {
		return trenutnaGodStudija;
	}



	public void setTrenutnaGodStudija(int trenutnaGodStudija) {
		this.trenutnaGodStudija = trenutnaGodStudija;
	}



	public StatusStudenta getStatus() {
		return status;
	}



	public void setStatus(StatusStudenta status) {
		this.status = status;
	}



	public double getProsecnaOcena() {
		return prosecnaOcena;
	}



	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}



	public ArrayList<Ocena> getPolozeniIspiti() {
		return polozeniIspiti;
	}



	public void setPolozeniIspiti(ArrayList<Ocena> polozeniIspiti) {
		this.polozeniIspiti = polozeniIspiti;
	}



	public ArrayList<Predmet> getNepolozeniIspiti() {
		return nepolozeniIspiti;
	}



	public void setNepolozeniIspiti(ArrayList<Predmet> nepolozeniIspiti) {
		this.nepolozeniIspiti = nepolozeniIspiti;
	}
	
	
	

}
