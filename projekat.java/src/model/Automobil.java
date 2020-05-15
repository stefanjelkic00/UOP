package model;

public class Automobil {

	private Musterija vlasnik;
	private Marka_auta marka;
	private Model_auta model;
	private Integer godina_proizvodnje;
	private String zapremina_motora;
	private String snaga_motora;
	private String vrsta_goriva;
	
	public Automobil() {
		
	}

	public Automobil(Musterija vlasnik, Marka_auta marka, Model_auta model, Integer godina_proizvodnje, String zapremina_motora,
			String snaga_motora, String vrsta_goriva) {
		super();
		this.vlasnik = vlasnik;
		this.marka = marka;
		this.model = model;
		this.godina_proizvodnje = godina_proizvodnje;
		this.zapremina_motora = zapremina_motora;
		this.snaga_motora = snaga_motora;
		this.vrsta_goriva = vrsta_goriva;
	}

	public Musterija getVlasnik() {
		return vlasnik;
	}

	public void setVlasnik(Musterija vlasnik) {
		this.vlasnik = vlasnik;
	}

	public Marka_auta getMarka() {
		return marka;
	}

	public void setMarka(Marka_auta marka) {
		this.marka = marka;
	}
	
	

	public Model_auta getModel() {
		return model;
	}

	public void setModel(Model_auta model) {
		this.model = model;
	}

	public Integer getGodina_proizvodnje() {
		return godina_proizvodnje;
	}

	public void setGodina_proizvodnje(Integer godina_proizvodnje) {
		this.godina_proizvodnje = godina_proizvodnje;
	}

	public String getZapremina_motora() {
		return zapremina_motora;
	}

	public void setZapremina_motora(String zapremina_motora) {
		this.zapremina_motora = zapremina_motora;
	}

	public String getSnaga_motora() {
		return snaga_motora;
	}

	public void setSnaga_motora(String snaga_motora) {
		this.snaga_motora = snaga_motora;
	}

	public String getVrsta_goriva() {
		return vrsta_goriva;
	}

	public void setVrsta_goriva(String vrsta_goriva) {
		this.vrsta_goriva = vrsta_goriva;
	}

	@Override
	public String toString() {
		return "Automobil [vlasnik=" + vlasnik.getPrezime() + ", marka=" + marka + ", model=" + model + ", godina_proizvodnje="
				+ godina_proizvodnje + ", zapremina_motora=" + zapremina_motora + ", snaga_motora=" + snaga_motora
				+ ", vrsta_goriva=" + vrsta_goriva + "]";
	}
	
}
	
	
	
