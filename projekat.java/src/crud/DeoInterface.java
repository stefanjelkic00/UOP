  
package crud;

import java.io.FileNotFoundException;
import java.io.IOException;


import model.Deo;

public interface DeoInterface {
	public void dodajDeo(Deo deo) throws IOException;
	public void izmeniDeo(Integer id,Deo deo) throws FileNotFoundException, IOException;
	public void obrisiDeo(Integer id) throws FileNotFoundException, IOException;
}