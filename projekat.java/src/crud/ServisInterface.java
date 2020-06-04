  
package crud;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.Servis;

public interface ServisInterface {
	
	public void dodajServis(Integer idAutomobila, Integer idServisera, Servis servis) throws IOException;
	public void izmeniServis(Integer id, Servis servis) throws FileNotFoundException, IOException;
	public void obrisiServis(Integer id) throws FileNotFoundException, IOException;
}