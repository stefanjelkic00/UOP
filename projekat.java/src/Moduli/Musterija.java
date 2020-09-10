package Moduli;

import java.util.ArrayList;

import enumi.Pol;

public class Musterija extends Korisnici {
	private int broj_nagradnih_bodova;
	private ArrayList<Automobil> auti;
	
public Musterija() {
	this.broj_nagradnih_bodova = 0;
}
public Musterija(int id ,String ime, String prezime, String jmbg, Pol pol, String adresa, String broj_telefona,
		String korisnicko_ime , String sifra, int broj_nagradnih_bodova, ArrayList<Automobil> auti) {
	super(id, ime, prezime, jmbg, pol, adresa, broj_telefona, korisnicko_ime, sifra);
	this.broj_nagradnih_bodova = broj_nagradnih_bodova;
	this.auti = auti;

}


@Override
public String toString() {
	return "Musterija [broj_nagradnih_bodova=" + broj_nagradnih_bodova + ", auti=" + auti + ", id=" + id + ", ime="
			+ ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", adresa=" + adresa
			+ ", broj_telefona=" + broj_telefona + ", korisnicko_ime=" + korisnicko_ime + ", sifra=" + sifra + "]";
}



public int getBroj_nagradnoh_bodova() {
	return broj_nagradnih_bodova;
}
public void setBroj_nagradnoh_bodova(int broj_nagradnoh_bodova) {
	this.broj_nagradnih_bodova = broj_nagradnoh_bodova;
	
}
public int getBroj_nagradnih_bodova() {
	return broj_nagradnih_bodova;
}
public void setBroj_nagradnih_bodova(int broj_nagradnih_bodova) {
	this.broj_nagradnih_bodova = broj_nagradnih_bodova;
}
public ArrayList<Automobil> getAuti() {
	return auti;
}
public void setAuti(ArrayList<Automobil> auti) {
	this.auti = auti;
}

}
