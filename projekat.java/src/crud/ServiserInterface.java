package crud;

import java.io.FileNotFoundException;
import java.io.IOException;


import model.Serviser;

public interface ServiserInterface {
		
		public void dodajServisera(Serviser serviser) throws IOException;
		public void izmeniServisera(Integer id, Serviser serviser) throws FileNotFoundException, IOException;
		public void obrisiServisera(Integer id) throws FileNotFoundException, IOException;
		

	
}
