package Moduli;

import enumi.Marka;
import enumi.Model;
import enumi.Vrsta_goriva;

public class Automobil {
	private int id;
	private Musterija vlasnik;
	private Marka marka;
	private Model model;
	private String godina_proizvodnje;
	private int zapremina_motora;
	private int snaga_motora;
	private Vrsta_goriva vrsta_goriva;
	private Servisna_knjizica servisna_knjizica;
	
	
	
	
	public Automobil () {
		this.id = 0;
		this.vlasnik = null;
		this.marka = null;
		this.model = null;
		this.godina_proizvodnje = "";
		this.zapremina_motora = 0;
		this.snaga_motora = 0;
		this.vrsta_goriva = Vrsta_goriva.DIZEL;
		this.servisna_knjizica = null;
		
	}
	public Automobil(int id, Musterija vlasnik, Marka marka, Model model, String godina_proizvodnje,
			int zapremina_motora, int snaga_motora, Vrsta_goriva vrsta_goriva, Servisna_knjizica servisna_knjizica) {
		super();
		this.id = id;
		this.vlasnik = vlasnik;
		this.marka = marka;
		this.model = model;
		this.godina_proizvodnje = godina_proizvodnje;
		this.zapremina_motora = zapremina_motora;
		this.snaga_motora = snaga_motora;
		this.vrsta_goriva = vrsta_goriva;
		this.servisna_knjizica = servisna_knjizica;
	}
	
	@Override
	public String toString() {
		return "Automobil [id=" + id + ", vlasnik=" + vlasnik.getIme() + ", marka=" + marka + ", model=" + model
				+ ", godina_proizvodnje=" + godina_proizvodnje + ", zapremina_motora=" + zapremina_motora
				+ ", snaga_motora=" + snaga_motora + ", vrsta_goriva=" + vrsta_goriva + ", servisna_knjizica="
				+ servisna_knjizica.getId() + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Musterija getVlasnik() {
		return vlasnik;
	}
	public void setVlasnik(Musterija vlasnik) {
		this.vlasnik = vlasnik;
	}
	public Marka getMarka() {
		return marka;
	}
	public void setMarka(Marka marka) {
		this.marka = marka;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public String getGodina_proizvodnje() {
		return godina_proizvodnje;
	}
	public void setGodina_proizvodnje(String godina_proizvodnje) {
		this.godina_proizvodnje = godina_proizvodnje;
	}
	public int getZapremina_motora() {
		return zapremina_motora;
	}
	public void setZapremina_motora(int zapremina_motora) {
		this.zapremina_motora = zapremina_motora;
	}
	public int getSnaga_motora() {
		return snaga_motora;
	}
	public void setSnaga_motora(int snaga_motora) {
		this.snaga_motora = snaga_motora;
	}
	public Vrsta_goriva getVrsta_goriva() {
		return vrsta_goriva;
	}
	public void setVrsta_goriva(Vrsta_goriva vrsta_goriva) {
		this.vrsta_goriva = vrsta_goriva;
	}
	public Servisna_knjizica getServisna_knjizica() {
		return servisna_knjizica;
	}
	public void setServisna_knjizica(Servisna_knjizica servisna_knjizica) {
		this.servisna_knjizica = servisna_knjizica;
	}

}
