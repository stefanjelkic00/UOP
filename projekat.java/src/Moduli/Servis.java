package Moduli;

import java.util.ArrayList;

import enumi.Status_servisa;
import Moduli.Automobil;
import Moduli.Deo;
import Moduli.Serviser;



public class Servis {
	private int id;
	private Automobil auto_za_servis;
	private Serviser serviser;
	private String termin;
	private String opis;
	private ArrayList<Deo> upotrebljeni_delovi;
	private Status_servisa status_servisa;
	
	
	public Servis() {
		this.id = 0;
		this.auto_za_servis = null;
		this.serviser = null;
		this.termin = "";
		this.opis = "";
		this.upotrebljeni_delovi = null;
		this.status_servisa = Status_servisa.zakazan;
	}

	public Servis(int id, Automobil auto_za_servis, Serviser serviser, String termin, String opis, ArrayList<Deo> upotrebljeni_delovi,
			Status_servisa status_servisa) {
		super();
		this.id = id;
		this.auto_za_servis = auto_za_servis;
		this.serviser = serviser;
		this.termin = termin;
		this.opis = opis;
		this.upotrebljeni_delovi = upotrebljeni_delovi;
		this.status_servisa = status_servisa;
	}
	
	

	public int getId() {
		return id;
	}

	public void SetId(int id) {
		this.id = id;
	}

	public Automobil getAuto_za_servis() {
		return auto_za_servis;
	}

	public void setAuto_za_servis(Automobil auto_za_servis) {
		this.auto_za_servis = auto_za_servis;
	}

	public Serviser getServiser() {
		return serviser;
	}

	public void setServiser(Serviser serviser) {
		this.serviser = serviser;
	}

	public String getTermin() {
		return termin;
	}

	public void setTermin(String termin) {
		this.termin = termin;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public ArrayList<Deo> getUpotrebljeni_delovi() {
		return upotrebljeni_delovi;
	}

	public void setUpotrebljeni_delovi(ArrayList<Deo> upotrebljeni_delovi) {
		this.upotrebljeni_delovi = upotrebljeni_delovi;
	}



	public Status_servisa getStatus_servisa() {
		return status_servisa;
	}

	public void setStatus_servisa(Status_servisa status_servisa) {
		this.status_servisa = status_servisa;
	}

	@Override
	public String toString() {
		return "Servis [id=" + id + ", auto_za_servis=" + auto_za_servis.getId() + ", serviser=" + serviser.getId() + ", termin="
				+ termin + ", opis=" + opis + ", upotrebljeni_delovi=" + upotrebljeni_delovi + ", status_servisa="
				+ status_servisa + "]";
	}

	



	

	
}