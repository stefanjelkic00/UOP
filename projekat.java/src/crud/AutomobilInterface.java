package crud;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.Automobil;

public interface AutomobilInterface {
	
	public void dodajAutomobil(Integer idMusterije, Automobil automobil) throws IOException;
	public void izmeniAutomobil(Integer id, Automobil automobil) throws FileNotFoundException, IOException;
	public void obrisiAutomobil(Integer id) throws FileNotFoundException, IOException;

}
