package Moduli;

import enumi.Marka;
import enumi.Model;
public class Deo {
	private int id;
	private Marka marka;
	private Model model;
	private String naziv;
	private int cena;
	private Servis namenjen_za_taj_servis;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Servis Namenjen_za_taj_servis() {
		return namenjen_za_taj_servis;
	}
	public void setNamenjen_za_servis(Servis namenjen_za_taj_servis) {
		this.namenjen_za_taj_servis = namenjen_za_taj_servis;
	}
	public Deo() {
		this.id = 0;
		this.marka = Marka.BMW;
		this.model = Model.X5;
		this.naziv = "";
		this.cena = 0;
		this.namenjen_za_taj_servis = null;
	}
	public Deo(int id, Marka marka, Model model, String naziv, int cena, Servis namenjen_za_servis) {
		super();
		this.id = id;
		this.marka = marka;
		this.model = model;
		this.naziv = naziv;
		this.cena = cena;
		this.namenjen_za_taj_servis = namenjen_za_servis;
	}
	@Override
	public String toString() {
		return "Deo [id=" + id + ", marka=" + marka + ", model=" + model + ", naziv=" + naziv + ", cena=" + cena
				+ ", namenjen_za_servis=" + namenjen_za_taj_servis.getOpis() + "]";
	}

}