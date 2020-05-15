package model;

public class Musterija extends Korisnik {

	private String broj_sakupljenih_nagradnih_bodova;

	public Musterija() {
		super();
	}

	public Musterija(String ime, String prezime, String JMBG, String pol, String adresa, String broj_telefona,
			String korisnicko_ime, String lozinka, String broj_sakupljenih_nagradnih_bodova) {
		super(ime, prezime, JMBG, pol, adresa, broj_telefona, korisnicko_ime, lozinka);
		this.broj_sakupljenih_nagradnih_bodova = broj_sakupljenih_nagradnih_bodova;
	}

	public String getBroj_sakupljenih_nagradnih_bodova() {
		return broj_sakupljenih_nagradnih_bodova;
	}

	public void setBroj_sakupljenih_nagradnih_bodova(String broj_sakupljenih_nagradnih_bodova) {
		this.broj_sakupljenih_nagradnih_bodova = broj_sakupljenih_nagradnih_bodova;
	}

	@Override
	public String toString() {
		return "Musterija [broj_sakupljenih_nagradnih_bodova=" + broj_sakupljenih_nagradnih_bodova + ", ime=" + ime
				+ ", prezime=" + prezime + ", JMBG=" + JMBG + ", pol=" + pol + ", adresa=" + adresa + ", broj_telefona="
				+ broj_telefona + ", korisnicko_ime=" + korisnicko_ime + ", lozinka=" + lozinka + "]";
	}
	
	
	
}