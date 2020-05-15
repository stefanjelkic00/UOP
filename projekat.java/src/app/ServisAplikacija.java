package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Administrator;
import model.Automobil;
import model.Deo;
import model.Marka_auta;
import model.Model_auta;
import model.Musterija;
import model.Servis;
import model.Serviser;

public class ServisAplikacija {

	public static void main(String[] args) throws IOException {
		
		FileReader frAdmin = new FileReader("C:\\Users\\hrle9\\eclipse-workspace\\ServisApplication\\src\\app\\administratori");
		BufferedReader brAdmin = new BufferedReader(frAdmin);

		try {
		String fileLine = null;
		
		while ((fileLine =  brAdmin.readLine()) != null) {
			String[] fields = fileLine.split(",");
				
			Administrator admin = new Administrator();
			admin.setIme(fields[0]);
			admin.setPrezime(fields[1]);
			admin.setKorisnicko_ime(fields[2]);
			admin.setLozinka(fields[3]);
			admin.setAdresa(fields[4]);
			admin.setBroj_telefona(fields[5]);
			admin.setJMBG(fields[6]);
			admin.setPlata(Integer.parseInt(fields[7]));
			admin.setPol(fields[8]);
			
			System.out.println(admin);
		}
		} finally {
			brAdmin.close();
		}
		
		
		FileReader frMus = new FileReader("C:\\Users\\hrle9\\eclipse-workspace\\ServisApplication\\src\\app\\musterije");
		BufferedReader brMus = new BufferedReader(frMus);

		try {
		String fileLine = null;
		
		while ((fileLine =  brMus.readLine()) != null) {
			String[] fields = fileLine.split(",");
				
			Musterija musterija = new Musterija();
			musterija.setIme(fields[0]);
			musterija.setPrezime(fields[1]);
			musterija.setKorisnicko_ime(fields[2]);
			musterija.setLozinka(fields[3]);
			musterija.setAdresa(fields[4]);
			musterija.setBroj_telefona(fields[5]);
			musterija.setJMBG(fields[6]);
			musterija.setBroj_sakupljenih_nagradnih_bodova(fields[7]);
			musterija.setPol(fields[8]);
			
			System.out.println(musterija);
		}
		} finally {
			brMus.close();
		}
		
		FileReader frAuto = new FileReader("C:\\Users\\hrle9\\eclipse-workspace\\ServisApplication\\src\\app\\automobili");
		BufferedReader brAuto = new BufferedReader(frAuto);

		try {
		String fileLine = null;
		
		while ((fileLine =  brAuto.readLine()) != null) {
			String[] fields = fileLine.split(",");
				
			
			Musterija vlasnik = new Musterija();
			vlasnik.setPrezime(fields[0]);
			
			Automobil auto = new Automobil();
			auto.setVlasnik(vlasnik);
			auto.setMarka(Marka_auta.valueOf(fields[1]));
			auto.setModel(Model_auta.valueOf(fields[2]));
			auto.setGodina_proizvodnje(Integer.parseInt(fields[3]));
			auto.setZapremina_motora(fields[4]);
			auto.setSnaga_motora(fields[5]);
			auto.setVrsta_goriva(fields[6]);
			
			System.out.println(auto);
		}
		} finally {
			brAuto.close();
		}
		
		FileReader frServis = new FileReader("C:\\Users\\hrle9\\eclipse-workspace\\ServisApplication\\src\\app\\servisi");
		BufferedReader brServis = new BufferedReader(frServis);

		try {
		String fileLine = null;
		
		while ((fileLine =  brServis.readLine()) != null) {
			String[] fields = fileLine.split(",");
				
			Servis servis = new Servis();
			
			Automobil auto = new Automobil();
			auto.setMarka(Marka_auta.valueOf(fields[0]));
			auto.setModel(Model_auta.valueOf(fields[1]));
			
			Serviser serviser = new Serviser();
			serviser.setPrezime(fields[2]);
			
			List<Deo> delovi = new ArrayList<>();
			Deo prviDeo = new Deo();
			Deo drugiDeo = new Deo();
			prviDeo.setNaziv(fields[5]);
			drugiDeo.setNaziv(fields[6]);
			delovi.add(prviDeo);
			delovi.add(drugiDeo);
			
			servis.setAuto_za_servis(auto);
			servis.setServiser(serviser);
			servis.setTermin(fields[3]);
			servis.setOpis(fields[4]);
			servis.setDelovi(delovi);
			servis.setStatus_servisa(fields[7]);
			
			System.out.println(servis);
		}
		} finally {
			brServis.close();
		}
		
	}

}