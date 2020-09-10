package Moduli;

import enumi.Pol;

public class Administrator extends Korisnici {
	public String  plata;
	
	public Administrator() {
		super();
		this.plata = "";
		
	}
public Administrator( int id , String ime, String prezime, String jmbg, Pol pol, String adresa, String broj_telefona,
		String korisnicko_ime, String sifra, String plata) {
	super(id , ime, prezime, jmbg, pol, adresa, broj_telefona, korisnicko_ime, sifra);
	this.plata = plata;
}

@Override
public String toString() {
	return "Administrator [plata=" + plata + ", id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg
			+ ", pol=" + pol + ", adresa=" + adresa + ", broj_telefona=" + broj_telefona + ", korisnicko_ime="
			+ korisnicko_ime + ", sifra=" + sifra + "]";
}

public String getPlata() {
	return plata;
}
public void setPlata(String plata) {
	this.plata = plata;
}


}

