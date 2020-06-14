package app;


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


public class ServisAplikacija {

	public static void main(String[] args) throws IOException {
		
		Administrator admin = new Administrator();
		admin.setIme("Gini");
		admin.setPrezime("Wijnaldum");
		admin.setKorisnicko_ime("gini");
		admin.setLozinka("mid");
		admin.setAdresa("Anfield Road 30");
		admin.setJMBG("5446464684767");
		admin.setBroj_telefona("104564305");
		admin.setPlata(2000);
		admin.setPol("muski");
		
//		admin.dodajAdministratora(admin);
//		Integer id = 3;
//		admin.izmeniAdministratora(id, admin);
//		admin.obrisiAdministratora(id);
		
		Musterija musterija = new Musterija();
		musterija.setPrezime("Firmino");
		
		Automobil automobil = new Automobil();
		automobil.setVlasnik(musterija);
		automobil.setMarka(Marka_auta.VOLKSWAGEN);
		automobil.setModel(Model_auta.GOLF7);
		automobil.setGodina_proizvodnje(2019);
		automobil.setZapremina_motora("36");
		automobil.setSnaga_motora("250");
		automobil.setVrsta_goriva("dizel");
		
//		Integer idMusterije = 3;		
//		automobil.dodajAutomobil(automobil);
		
//		Integer idZaIzmenu = 2;
		
//		automobil.izmeniAutomobil(idZaIzmenu, automobil);
		
		automobil.obrisiAutomobil(2);
		
		List<Deo> delovi = new ArrayList<>();
		Deo prviDeo = new Deo();
		Deo drugiDeo = new Deo();
		prviDeo.setNaziv("vrata");
		drugiDeo.setNaziv("motor");
		delovi.add(prviDeo);
		delovi.add(drugiDeo);
		
		
		
		Servis servis = new Servis();
		servis.setTermin("10:00");
		servis.setOpis("opis novih kola");
		servis.setDelovi(delovi);
		servis.setStatus_servisa("prosao");
		
//		servis.dodajServis(2, 2, servis);
		
		
	}

}