package Moduli;

import java.util.ArrayList;

import enumi.Pol;
import enumi.Specijalizacija_servisera;

public class Serviser extends Korisnici {
	private String plata;
	private Specijalizacija_servisera specijalizacija;
	private ArrayList<Servis> servisi_gde_je_zaduzen;

	
	public Serviser() {
		super();
		this.plata = "";
		this.specijalizacija = Specijalizacija_servisera.Autoelektricar;
		this.servisi_gde_je_zaduzen = new ArrayList<Servis>();	}
	
	public Serviser(int id, String ime, String prezime, String jmbg, Pol pol, String adresa, String broj_telefona,
			String korisnicko_ime, String sifra, String plata, Specijalizacija_servisera specijalizacija,ArrayList<Servis> servisi_gde_je_zaduzen) {
		super(id,ime, prezime, jmbg, pol, adresa, broj_telefona, korisnicko_ime, sifra);
		this.plata = plata;
		this.specijalizacija = specijalizacija;
		this.servisi_gde_je_zaduzen = servisi_gde_je_zaduzen;
	}

	public ArrayList<Servis> getServisi_gde_je_zaduzen() {
		return servisi_gde_je_zaduzen;
	}

	public void setServisi_gde_je_zaduzen(ArrayList<Servis> servisi_gde_je_zaduzen) {
		this.servisi_gde_je_zaduzen = servisi_gde_je_zaduzen;
	}

	

	

	@Override
	public String toString() {
		return "Serviser [plata=" + plata + ", specijalizacija=" + specijalizacija + ", servisi_gde_je_zaduzen="
				+ servisi_gde_je_zaduzen + ", id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg
				+ ", pol=" + pol + ", adresa=" + adresa + ", broj_telefona=" + broj_telefona + ", korisnicko_ime="
				+ korisnicko_ime + ", sifra=" + sifra + "]";
	}

	public String getPlata() {
		return plata;
	}

	public void setPlata(String plata) {
		this.plata = plata;
	}

	public Specijalizacija_servisera getSpecijalizacija() {
		return specijalizacija;
	}

	public void setSpecijalizacija(Specijalizacija_servisera specijalizacija) {
		this.specijalizacija = specijalizacija;
	}

}