package crud;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Administrator;

public class liste {
	public static ArrayList<Administrator> ucitajAdministratore() {
		ArrayList<Administrator> admini = new ArrayList<Administrator>();
		
		String filepath = "C:\\Users\\stefa\\git\\UOP\\projekat.java\\src\\app\\administratori.txt";
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			String linija;
			while((linija = br.readLine()) != null) {
				String[] sp = linija.split(",");
				int id = Integer.parseInt(sp[0]);
				String ime = sp[1];
				String prezime = sp[2];
				String jmbg = sp[3];
				String pol = sp[4];
				String adresa = sp[5];
				String broj = sp[6];
				String korisnicko = sp[7];
				String sifra = sp[8];
				int plata = Integer.parseInt(sp[9]);
			Administrator adm = new Administrator(id, ime, prezime, jmbg, pol, adresa, broj, korisnicko, sifra, plata);
			admini.add(adm);
			}
			br.close();
		return admini;
		
		} catch (IOException e) {
			System.out.println("Nesto nije u redu sa fajlom.");
		}
		return admini;
	
	
	
	
	
	
	}
}
