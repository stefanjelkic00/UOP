package crud;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import model.Deo;
import model.Servis;

public interface ServisInterface {
	
	public void dodajServis(Integer idAutomobila, Integer idServisera, List<Deo> delovi, Servis servis) throws IOException;
	public void izmeniServis(Integer id, Servis servis) throws FileNotFoundException, IOException;
	public void obrisiServis(Integer id) throws FileNotFoundException, IOException;

}