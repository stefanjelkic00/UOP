package model;

public class Serviser extends Korisnik {
	
	private int plata;
	private Specijalizacija specijalizacija;
	
	public Serviser() {
		super();
	}

	public Serviser(String ime, String prezime, String JMBG, String pol, String adresa, String broj_telefona,
			String korisnicko_ime, String lozinka, int plata, Specijalizacija specijalizacija) {
		super(ime, prezime, JMBG, pol, adresa, broj_telefona, korisnicko_ime, lozinka);
		this.plata = plata;
		this.specijalizacija = specijalizacija;
	}

	public int getPlata() {
		return plata;
	}

	public void setPlata(int plata) {
		this.plata = plata;
	}

	public Specijalizacija getSpecijalizacija() {
		return specijalizacija;
	}

	public void setSpecijalizacija(Specijalizacija specijalizacija) {
		this.specijalizacija = specijalizacija;
	}

	@Override
	public String toString() {
		return "Serviser [plata=" + plata + ", specijalizacija=" + specijalizacija + ", ime=" + ime + ", prezime="
				+ prezime + ", JMBG=" + JMBG + ", pol=" + pol + ", adresa=" + adresa + ", broj_telefona="
				+ broj_telefona + ", korisnicko_ime=" + korisnicko_ime + ", lozinka=" + lozinka + "]";
	}
	
	
	
	

}