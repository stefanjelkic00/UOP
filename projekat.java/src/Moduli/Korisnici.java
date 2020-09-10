package Moduli;

import enumi.Pol;

public abstract class Korisnici {
	public int id ; 
	public String ime;
	public String prezime;
	public String jmbg;
	public Pol pol;
	public String adresa;
	public String broj_telefona;
	public String korisnicko_ime;
	public String sifra; 
	
	public Korisnici() {
		this.id = 0;
		this.ime = "";
		this.prezime= "";
		this.jmbg="";
		this.pol = Pol.MUSKI;
		this.adresa = "";
		this.broj_telefona = "";
		this.korisnicko_ime = "";
		this.sifra = "";
		
		
	}
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
public Korisnici(int id , String ime, String prezime, String jmbg,Pol pol, String adresa, String broj_telefona,
		String korisnicko_ime, String sifra) {
	super();
	this.id = id;
	this.ime = ime;
	this.prezime = prezime;
	this.jmbg = jmbg;
	this.pol = pol;
	this.adresa = adresa;
	this.broj_telefona = broj_telefona;
	this.korisnicko_ime = korisnicko_ime;
	this.sifra = sifra;
}
@Override
public String toString() {
	return "Korisnici [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol
			+ ", adresa=" + adresa + ", broj_telefona=" + broj_telefona + ", korisnicko_ime=" + korisnicko_ime
			+ ", sifra=" + sifra + "]";
}
public String getIme() {
	return ime;
}
public void setIme(String ime) {
	this.ime = ime;
}
public String getPrezime() {
	return prezime;
}
public void setPrezime(String prezime) {
	this.prezime = prezime;
}
public String getJmbg() {
	return jmbg;
}
public void setJmbg(String jmbg) {
	this.jmbg = jmbg;
}
public Pol getPol() {
	return pol;
}
public void setPol(Pol pol) {
	this.pol = pol;
}
public String getAdresa() {
	return adresa;
}
public void setAdresa(String adresa) {
	this.adresa = adresa;
}
public String getBroj_telefona() {
	return broj_telefona;
}
public void setBroj_telefona(String broj_telefona) {
	this.broj_telefona = broj_telefona;
}
public String getKorisnicko_ime() {
	return korisnicko_ime;
}
public void setKorisnicko_ime(String korisnicko_ime) {
	this.korisnicko_ime = korisnicko_ime;
}
public String getSifra() {
	return sifra;
}
public void setSifra(String sifra) {
	this.sifra = sifra;
}
}