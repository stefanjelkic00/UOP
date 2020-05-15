package model;

public class Deo {

	private Marka_auta marka;
	private Model_auta model;
	private String naziv;
	private int cena;
	
	public Deo() {
		
	}

	public Deo(Marka_auta marka, Model_auta model, String naziv, int cena) {
		super();
		this.marka = marka;
		this.model = model;
		this.naziv = naziv;
		this.cena = cena;
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

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	@Override
	public String toString() {
		return "Deo [naziv=" + naziv + "]";
	}
	
	
	
	
	
}