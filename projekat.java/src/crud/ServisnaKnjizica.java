package crud;

import java.io.FileNotFoundException;
import java.io.IOException;


import model.Servisna_knjizica;

public interface ServisnaKnjizica {
	public void dodajServisnuKnjizicu(Servisna_knjizica knjizica) throws IOException;
	public void izmeniServisnuKnjizicu(Integer id,Servisna_knjizica knjizica) throws FileNotFoundException, IOException;
	public void obrisiServisnuKnjizicu(Integer id) throws FileNotFoundException, IOException;
}
