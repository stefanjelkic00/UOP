package crud;

import java.io.FileNotFoundException;
import java.io.IOException;



import model.Musterija;

public interface MusterijaInterface {
	
	public void dodajMusteriju(Musterija musterija) throws IOException;
	public void izmeniMusteriju(Integer id, Musterija musterija) throws FileNotFoundException, IOException;
	public void obrisiMusteriju(Integer id) throws FileNotFoundException, IOException;
	

}