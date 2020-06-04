package crud;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.Administrator;

public interface AdministratorInterface {
	
	public void dodajAdministratora(Administrator administrator) throws IOException;
	public void izmeniAdministratora(Integer id, Administrator administrator) throws FileNotFoundException, IOException;
	public void obrisiAdministratora(Integer id) throws FileNotFoundException, IOException;
	

}