package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Profesor {
	
	private String prezime;
	private String ime;
	private LocalDate datumRodjenja;
	private Adresa adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private Adresa adresaKancelarije;
	private String brojLicneKarte;
	private String zvanje;
	private int godineStaza;
	private ArrayList<Predmet> spisakPredmeta;
	
	//konstruktori
	
	
	public Profesor() {
		super();
	}


	public Profesor(String prezime, String ime, LocalDate datumRodjenja, Adresa adresaStanovanja, String kontaktTelefon,
			String emailAdresa, Adresa adresaKancelarije, String brojLicneKarte, String zvanje, int godineStaza,
			ArrayList<Predmet> spisakPredmeta) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.zvanje = zvanje;
		this.godineStaza = godineStaza;
		this.spisakPredmeta = new ArrayList<Predmet>();
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


	public Adresa getAdresaKancelarije() {
		return adresaKancelarije;
	}


	public void setAdresaKancelarije(Adresa adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}


	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}


	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}


	public String getZvanje() {
		return zvanje;
	}


	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}


	public int getGodineStaza() {
		return godineStaza;
	}


	public void setGodineStaza(int godineStaza) {
		this.godineStaza = godineStaza;
	}


	public ArrayList<Predmet> getSpisakPredmeta() {
		return spisakPredmeta;
	}


	public void setSpisakPredmeta(ArrayList<Predmet> spisakPredmeta) {
		this.spisakPredmeta = spisakPredmeta;
	}
	

}
