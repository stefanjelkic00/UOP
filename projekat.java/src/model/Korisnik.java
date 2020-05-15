package model;

public abstract class Korisnik {
	
	protected String ime;
	protected String prezime;
	protected String JMBG;
	protected String pol;
	protected String adresa;
	protected String broj_telefona;
	protected String korisnicko_ime;
	protected String lozinka;
	
	
	public Korisnik() {
		
	}


	public Korisnik(String ime, String prezime, String JMBG, String pol, String adresa, String broj_telefona,
			String korisnicko_ime, String lozinka) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.JMBG = JMBG;
		this.pol = pol;
		this.adresa = adresa;
		this.broj_telefona = broj_telefona;
		this.korisnicko_ime = korisnicko_ime;
		this.lozinka = lozinka;
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


	public String getJMBG() {
		return JMBG;
	}


	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}


	public String getPol() {
		return pol;
	}


	public void setPol(String pol) {
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


	public String getLozinka() {
		return lozinka;
	}


	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}


	@Override
	public String toString() {
		return "Korisnik [ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", pol=" + pol + ", adresa="
				+ adresa + ", broj_telefona=" + broj_telefona + ", korisnicko_ime=" + korisnicko_ime + ", lozinka="
				+ lozinka + "]";
	}
	
	
	
	
	
	
	
	

}