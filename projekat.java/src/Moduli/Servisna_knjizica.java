package Moduli;

import java.util.ArrayList;

import Moduli.Automobil;


public class Servisna_knjizica {

	private int id;
	private Automobil automobil;
	private ArrayList<Servis> obavljeni_servisi;
	
	public Servisna_knjizica() {
		this.id = 0;
		this.automobil = null;
		this.obavljeni_servisi = new ArrayList<Servis>();
	
}

	public Servisna_knjizica(int id, Automobil automobil, ArrayList<Servis> obavljeni_servisi) {
		super();
		this.id = id;
		this.automobil = automobil;
		this.obavljeni_servisi = obavljeni_servisi;
	}
	
	public int getId() {
		return id;
	}

	public void SetId(int id) {
		this.id = id;
	}

	public Automobil getAutomobil() {
		return automobil;
	}

	public void setAutomobil(Automobil automobil) {
		this.automobil = automobil;
	}


	public ArrayList<Servis> getObavljeni_servisi() {
		return obavljeni_servisi;
	}

	public void setObavljeni_servisi(ArrayList<Servis> obavljeni_servisi) {
		this.obavljeni_servisi = obavljeni_servisi;
	}
	
	public void dodajNaListuServisa(Servis servis) {
		this.obavljeni_servisi.add(servis);
		
	}

	@Override
	public String toString() {
		return "ServisnaKnjizica [id=" + id + ", automobil=" + automobil + ", obavljeni_servisi=" + obavljeni_servisi
				+ "]";
	}

	


}