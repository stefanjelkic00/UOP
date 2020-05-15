package model;

import java.util.List;

public class Servisna_knjizica {

	private Automobil auto;
	private List<Servis> servisi;
	
	public Servisna_knjizica() {
		
	}

	public Servisna_knjizica(Automobil auto, List<Servis> servisi) {
		super();
		this.auto = auto;
		this.servisi = servisi;
	}

	public Automobil getAuto() {
		return auto;
	}

	public void setAuto(Automobil auto) {
		this.auto = auto;
	}

	public List<Servis> getServisi() {
		return servisi;
	}

	public void setServisi(List<Servis> servisi) {
		this.servisi = servisi;
	}

	@Override
	public String toString() {
		return "Servisna_knjizica [auto=" + auto + ", servisi=" + servisi + "]";
	}
	
	
}
	
	
	
	
