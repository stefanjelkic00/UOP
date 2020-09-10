package Liste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Moduli.Administrator;
import Moduli.Automobil;
import Moduli.Deo;
import Moduli.Musterija;
import Moduli.Servis;
import Moduli.Serviser;
import Moduli.Servisna_knjizica;
import enumi.Marka;
import enumi.Model;
import enumi.Pol;
import enumi.Specijalizacija_servisera;
import enumi.Status_servisa;
import enumi.Vrsta_goriva;

public class Liste {
	private ArrayList<Administrator> administratori;
	private ArrayList<Musterija> musterije;
	private ArrayList<Serviser> serviseri;
	private ArrayList<Automobil> automobili;
	private ArrayList<Deo> delovi;
	private ArrayList<Servis> servisi;
	private ArrayList<Servisna_knjizica> servisne_knjizice;
	
	
	

	public ArrayList<Administrator> getAdministratori() {
		return administratori;
	}


	public void setAdministratori(ArrayList<Administrator> administratori) {
		this.administratori = administratori;
	}


	public ArrayList<Musterija> getMusterije() {
		return musterije;
	}


	public void setMusterije(ArrayList<Musterija> musterije) {
		this.musterije = musterije;
	}


	public ArrayList<Serviser> getServiseri() {
		return serviseri;
	}


	public void setServiseri(ArrayList<Serviser> serviseri) {
		this.serviseri = serviseri;
	}


	public ArrayList<Automobil> getAutomobili() {
		return automobili;
	}


	public void setAutomobili(ArrayList<Automobil> automobili) {
		this.automobili = automobili;
	}


	public ArrayList<Deo> getDelovi() {
		return delovi;
	}


	public void setDelovi(ArrayList<Deo> delovi) {
		this.delovi = delovi;
	}


	public ArrayList<Servis> getServisi() {
		return servisi;
	}


	public void setServisi(ArrayList<Servis> servisi) {
		this.servisi = servisi;
	}


	public ArrayList<Servisna_knjizica> getServisne_knjizice() {
		return servisne_knjizice;
	}


	public void setServisne_knjizice(ArrayList<Servisna_knjizica> servisne_knjizice) {
		this.servisne_knjizice = servisne_knjizice;
	}


	public Liste() {
		this.administratori = new ArrayList<Administrator>();
		this.musterije = new ArrayList<Musterija>();
		this.serviseri = new ArrayList<Serviser>();
		this.automobili = new ArrayList<Automobil>();
		this.delovi = new ArrayList<Deo>();
		this.servisi = new ArrayList<Servis>();
		this.servisne_knjizice = new ArrayList<Servisna_knjizica>();
		
}

	
	public void UcitajAdministratore(String putanja_za_fajl) {
		File fajl_in = new File(putanja_za_fajl);
		try {
			BufferedReader fajl = new BufferedReader(new FileReader(fajl_in));
			String red;
			
			while((red = fajl.readLine()) != null) {
				String[] odvojeno = red.split("\\|");
				int id = Integer.parseInt(odvojeno[0]);
				String ime = odvojeno[1];
				String prezime = odvojeno[2];
				String jmbg = odvojeno[3];
				Pol pol = Pol.valueOf(odvojeno[4]);
				String adresa = odvojeno[5];
				String broj_telefona = odvojeno[6];
				String korisnicko_ime = odvojeno[7];
				String sifra = odvojeno[8];
				String plata = odvojeno[9];
			Administrator administratori_naziv = new Administrator(id, ime, prezime, jmbg, pol, adresa, broj_telefona, korisnicko_ime , sifra, plata);
			this.administratori.add(administratori_naziv);
			}
			fajl.close();
		
		} catch (IOException e) {
			System.out.println("Nije dobro uneto u fajlu .");
		}
	}
	
	public void ucitajMusterije(String putanja_za_fajl) {
		File fajl_in = new File(putanja_za_fajl);
		try {
			BufferedReader fajl = new BufferedReader(new FileReader(fajl_in));
			String red;
			
			while((red = fajl.readLine()) != null) {
				String[] odvojeno = red.split("\\|");
				int id = Integer.parseInt(odvojeno[0]);
				String ime = odvojeno[1];
				String prezime = odvojeno[2];
				String jmbg = odvojeno[3];
				Pol pol = Pol.valueOf(odvojeno[4]);
				String adresa = odvojeno[5];
				String broj = odvojeno[6];
				String korisnicko = odvojeno[7];
				String sifra = odvojeno[8];
				int broj_nagradnih_bodova = Integer.parseInt(odvojeno[9]);
				
				ArrayList<Automobil> lista_automobila = new ArrayList<Automobil>();


			Musterija musterija = new Musterija(id, ime, prezime, jmbg, pol, adresa, broj, korisnicko, sifra, broj_nagradnih_bodova, lista_automobila);
			this.musterije.add(musterija);
			}
			fajl.close();
		
		} catch (IOException e) {
			System.out.println("Nije dobro uneto u fajlu .");
		}
		
		
		
	}
	public void ucitajServisnaKnjizice(String putanja_za_fajl) {
		File fajl_in = new File(putanja_za_fajl);
		try {
			BufferedReader fajl = new BufferedReader(new FileReader(fajl_in));
			String red;
			while((red = fajl.readLine()) != null) {
				String[] odvojeno = red.split("\\|");
				
				int id = Integer.parseInt(odvojeno[0]);
				ArrayList<Servis> servisi1 = new ArrayList<Servis>();
				Automobil auto = new Automobil();
				
			Servisna_knjizica servisna_knjizica1 = new Servisna_knjizica(id, auto, servisi1);
			this.servisne_knjizice.add(servisna_knjizica1);
			}
			fajl.close();
		
		} catch (IOException e) {
			System.out.println("Nije dobro uneto u fajlu .");
		}
	}
	
	
	public void ucitajAutomobile(String putanja_za_fajl) {
		File fajl_in = new File(putanja_za_fajl);
		try {
			BufferedReader br = new BufferedReader(new FileReader(fajl_in));
			String red;
			
			while((red = br.readLine()) != null) {
				String[] odvojeno = red.split("\\|");
				int id = Integer.parseInt(odvojeno[0]);
				Musterija vlasnik = new Musterija();
				Marka marka = Marka.valueOf(odvojeno[2]);
				Model model = Model.valueOf(odvojeno[3]);
				String godina_proizvodnje = odvojeno[4];
				
				int zapremina = Integer.parseInt(odvojeno[5]);
				int snaga = Integer.parseInt(odvojeno[6]);
				Vrsta_goriva vrsta_goriva = Vrsta_goriva.valueOf(odvojeno[7]);
				Servisna_knjizica servisna_knjizica = new Servisna_knjizica();
				servisna_knjizica.SetId(Integer.parseInt(odvojeno[8]));
				for(Musterija musterija1 : musterije) {
					if(odvojeno[1].equalsIgnoreCase(musterija1.getIme())) {
						vlasnik = musterija1;
						Automobil automobil = new Automobil(id, vlasnik, marka, model, godina_proizvodnje, zapremina, snaga, vrsta_goriva, servisna_knjizica);
						musterija1.getAuti().add(automobil);	
					}	
				}
				for(Servisna_knjizica ser_knjizica : servisne_knjizice) {
					if(ser_knjizica.getId() == servisna_knjizica.getId()) {
						ser_knjizica.setAutomobil(new Automobil(id, vlasnik, marka, model, godina_proizvodnje, zapremina, snaga,
					vrsta_goriva, servisna_knjizica));
					}
				}


			Automobil automobil = new Automobil(id, vlasnik, marka, model, godina_proizvodnje, zapremina, snaga,
					vrsta_goriva, servisna_knjizica);
			this.automobili.add(automobil);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Nije dobro uneto u fajlu .");
		}
	}
	
	
	public void ucitajServisere(String putanja_za_fajl) {
		File fajl_in = new File(putanja_za_fajl);
		try {
			BufferedReader fajl = new BufferedReader(new FileReader(fajl_in));
			String linija;
			while((linija = fajl.readLine()) != null) {
				String[] odvojeno = linija.split("\\|");
				int id = Integer.parseInt(odvojeno[0]);
				String ime = odvojeno[1];
				String prezime = odvojeno[2];
				String jmbg = odvojeno[3];
				Pol pol = Pol.valueOf(odvojeno[4]);
				String adresa = odvojeno[5];
				String broj = odvojeno[6];
				String korisnicko_ime = odvojeno[7];
				String sifra = odvojeno[8];
				String plata = odvojeno[9];
				Specijalizacija_servisera specijalizacija = Specijalizacija_servisera.valueOf(odvojeno[10]);
				ArrayList<Servis> servisi_gde_treba_da_radi = new ArrayList<Servis>();
				
			
			Serviser servis1 = new Serviser(id, ime, prezime, jmbg, pol, adresa, broj, korisnicko_ime, sifra, plata, specijalizacija, servisi_gde_treba_da_radi);
			this.serviseri.add(servis1);
			}
			fajl.close();

		} catch (IOException e) {
			System.out.println("Nije dobro uneto u fajlu .");
		}
	}
	
	
	
	
	public void ucitajServise(String putanja_za_fajl) {
		File fajl_in = new File(putanja_za_fajl);
		try {
			BufferedReader fajl = new BufferedReader(new FileReader(fajl_in));
			String red;
			while((red = fajl.readLine()) != null) {
				String[] odvojeno = red.split("\\|");
				int id = Integer.parseInt(odvojeno[0]);
				Serviser serviser = new Serviser();
				serviser.setId(Integer.parseInt(odvojeno[2]));
				String termin = odvojeno[3];
				String opis = odvojeno[4];
				ArrayList<Deo> delovi = new ArrayList<Deo>();
				Status_servisa status_servisa = Status_servisa.valueOf(odvojeno[5]);
				Automobil automobil = new Automobil();
				automobil.setId(Integer.parseInt(odvojeno[1]));
				Servis servis = new Servis(id, automobil, serviser, termin, opis, delovi, status_servisa);

					for(Servisna_knjizica servisna_knjizica : servisne_knjizice) {
						if(servis.getAuto_za_servis().getId() == servisna_knjizica.getAutomobil().getId()) {
							servisna_knjizica.getObavljeni_servisi().add(servis);
							servis.setAuto_za_servis(servisna_knjizica.getAutomobil());
						}
				}
				for(Serviser serviser1 : serviseri) {
					if(serviser1.getId() == serviser.getId()) {
						serviser1.getServisi_gde_je_zaduzen().add(servis);
						servis.setServiser(serviser1);
					}
				}
				
				
			this.servisi.add(servis);
			}
			fajl.close();
		
		} catch (IOException e) {
			System.out.println("Nije dobro uneto u fajlu .");
		}
	}
	
	
	
	
	
	public void ucitajDelove(String putanja_za_fajl) {
		File fajl_in = new File(putanja_za_fajl);
		try {
			BufferedReader fajl = new BufferedReader(new FileReader(fajl_in));
			String linija;
			while((linija = fajl.readLine()) != null) {
				String[] odvojeno = linija.split("\\|");
				int id = Integer.parseInt(odvojeno[0]);
				Marka marka = Marka.valueOf(odvojeno[1]);
				Model model = Model.valueOf(odvojeno[2]);
				String naziv = odvojeno[3];
				int cena = Integer.parseInt(odvojeno[4]);
				Servis namenjen_za = new Servis();
				Deo deo1 = new Deo(id, marka, model, naziv, cena, namenjen_za);

				for(Servis servis1 : servisi) {
					if(servis1.getId() == Integer.parseInt(odvojeno[5])){
						deo1.setNamenjen_za_servis(servis1);
						servis1.getUpotrebljeni_delovi().add(deo1);
					}
				}
			this.delovi.add(deo1);
			
			}
			fajl.close();
		
		} catch (IOException e) {
			System.out.println("Nije dobro uneto u fajlu .");
		}
	}
	

	
	
	public Administrator NadjiAdministratora(int id) {
		for(Administrator admin : this.administratori) {
			if (admin.getId() == id) {
				return admin;
			}
		}
		return null;
	}
	
	public Musterija NadjiMusteriju(int id) {
		for(Musterija musterija : this.musterije) {
			if (musterija.getId() == id) {
				return musterija;
			}
		}
		return null;
	}
	
	public Serviser NadjiServisera(int id) {
		for(Serviser serviser : this.serviseri) {
			if (serviser.getId() == id) {
				return serviser;
			}
		}
		return null;
	}
	
	public Automobil NadjiAutomobil(int id) {
		for(Automobil automobil : this.automobili) {
			if (automobil.getId() == id) {
				return automobil;
			}
		}
		return null;
	}
	public Servis NadjiServis(int id) {
		for(Servis servis : this.servisi) {
			if (servis.getId() == id) {
				return servis;
			}
		}
		return null;
	}
	
	public Deo NadjiDeo(int id) {
		for(Deo deo : this.delovi) {
			if (deo.getId() == id) {
				return deo;
			}
		}
		return null;
	}
	
	
	
	public Servisna_knjizica NadjiServisnuKnjizicu(int id) {
		for(Servisna_knjizica servisna_knjizica : this.servisne_knjizice) {
			if (servisna_knjizica.getId() == id) {
				return servisna_knjizica;
			}
		}
		return null;
	}
	
	public Administrator nadjiAdministratora(String korisnicko_ime) {
		for(Administrator administrator : this.administratori) {
			if (administrator.getKorisnicko_ime() == korisnicko_ime) {
				return administrator;
			}
		}
		return null;
	}
	
	public Musterija NadjiMusteriju(String korisnicko_ime) {
		for(Musterija musterija : this.musterije) {
			if (musterija.getKorisnicko_ime() == korisnicko_ime) {
				return musterija;
			}
		}
		return null;
	}
	
	public Serviser NadjiServisera(String korisnicko_ime) {
		for(Serviser serviser : this.serviseri) {
			if (serviser.getKorisnicko_ime() == korisnicko_ime) {
				return serviser;
			}
		}return null;
	}
	
	public Serviser NadjiServiseraPoPrezimenu(String prezime) {
		for(Serviser serviser : this.serviseri) {
			if (serviser.getPrezime() == prezime) {
				return serviser;
			}
		}return null;
	}
	
	
	public void upisAdministratora() {
		
		
		File fajl_out = new File("C:\\Users\\stefa\\eclipse-workspace\\Projekatjava2\\src\\Fajlovi\\Administratori.txt");
		
		try {
			BufferedWriter fajl = new BufferedWriter(new FileWriter(fajl_out));
			for(Administrator administrator : this.administratori) {
			String upisani_red = 
					String.valueOf(administrator.getId()) + 
					"|" + administrator.getIme() + 
					"|" + administrator.getPrezime() + 
					"|" + administrator.getJmbg() + 
					"|" + administrator.getPol() + 
					"|" + administrator.getAdresa() + 
					"|" + administrator.getBroj_telefona() + 
					"|" + administrator.getKorisnicko_ime() + 
					"|" + administrator.getSifra() +
					"|" + administrator.getPlata() + "\n" ;
			
			fajl.write(upisani_red);
			}
			fajl.close();
			
		} catch (IOException e) {
			
			System.out.println("Nije dobro uneto u fajlu .");
		}
		
		}
	
	public void upisMusterija() {
		
		
		File fajl_out = new File("C:\\Users\\stefa\\eclipse-workspace\\Projekatjava2\\src\\Fajlovi\\Musterije.txt");
		
		try {
			BufferedWriter fajl = new BufferedWriter(new FileWriter(fajl_out));
			for(Musterija musterija : this.musterije) {
			
			String upisani_red =
					String.valueOf(musterija.getId()) +
					"|"  + musterija.getIme() + 
					"|" + musterija.getPrezime() + 
					"|" + musterija.getJmbg() + 
					"|" +musterija.getPol() + 
					"|" + musterija.getAdresa() + 
					"|" + musterija.getBroj_telefona() + 
					"|" + musterija.getKorisnicko_ime() + 
					"|" + musterija.getSifra() + 
					"|" +  String.valueOf(musterija.getBroj_nagradnoh_bodova()) + "\n" ;

			fajl.write(upisani_red);
			}
			fajl.close();
			
		} catch (IOException e) {
			
			System.out.println("Nije dobro uneto u fajlu .");
		}
		
		}
	
	public void upisServisera() {
		
		
		File fajl_out = new File("C:\\Users\\stefa\\eclipse-workspace\\Projekatjava2\\src\\Fajlovi\\Serviseri.txt");
		
		try {
			BufferedWriter fajl = new BufferedWriter(new FileWriter(fajl_out));
			for(Serviser serviser : this.serviseri) {
				
			String upisani_red =
			String.valueOf(serviser.getId()) + "|"
			+ serviser.getIme() + "|"
			+ serviser.getPrezime() + "|" 
			+ serviser.getJmbg() + "|" 
			+ serviser.getPol() + "|"
			+ serviser.getAdresa() + "|" 
			+ serviser.getBroj_telefona() + "|" 
			+ serviser.getKorisnicko_ime() + "|" 
			+ serviser.getSifra() + "|" 
			+ serviser.getPlata() + "|" 
			+ serviser.getSpecijalizacija() + "\n" ;
			
			fajl.write(upisani_red);
			}
			fajl.close();
			
		} catch (IOException e) {
			
			System.out.println("Nije dobro uneto u fajlu .");
		}
		
		}

	public void upisAutomobila() {
	
		
		File fajl_out = new File("C:\\Users\\stefa\\eclipse-workspace\\Projekatjava2\\src\\Fajlovi\\Automobili.txt");
		
		try {
			BufferedWriter fajl = new BufferedWriter(new FileWriter(fajl_out));
			for(Automobil automobil : this.automobili) {
			String upisani_red = String.valueOf(automobil.getId())+ "|" 
			+ automobil.getVlasnik().getIme() + "|" 
			+ automobil.getMarka() + "|" 
			+ automobil.getModel() + "|" 
			+ automobil.getGodina_proizvodnje() + "|"
			+String.valueOf(automobil.getZapremina_motora()) + "|"
			+ String.valueOf(automobil.getSnaga_motora()) + "|" 
			+ automobil.getVrsta_goriva() + "|"
			+ String.valueOf(automobil.getServisna_knjizica().getId()) + "\n";
			
			fajl.write(upisani_red);
			}
			fajl.close();
		
		} 
		catch (IOException e) {
			
			System.out.println("Nije dobro uneto u fajlu .");
		}
		
		}
	
	
	public void upisDelova() {
		
		
		File fajl_out = new File("C:\\Users\\stefa\\eclipse-workspace\\Projekatjava2\\src\\Fajlovi\\Delovi.txt");
		
		try {
			BufferedWriter fajl = new BufferedWriter(new FileWriter(fajl_out));
			for(Deo deo : this.delovi) {
			String upisani_red = String.valueOf(deo.getId()) +
					"|" + deo.getMarka() + 
					"|" + deo.getModel() + 
					"|" + deo.getNaziv() + 
					"|" + String.valueOf(deo.getCena())+ 
					"|" + String.valueOf(deo.Namenjen_za_taj_servis().getId()) + "\n";
			
			fajl.write(upisani_red);
			}
			fajl.close();
			
		} catch (IOException e) {
			
			System.out.println("Nije dobro uneto u fajlu .");
		}
		
		}

	
	
	public void upisServisa() {
			
			
			File fajl_out = new File("C:\\Users\\stefa\\eclipse-workspace\\Projekatjava2\\src\\Fajlovi\\Servisi.txt");
			
			try {
				BufferedWriter fajl = new BufferedWriter(new FileWriter(fajl_out));
				for(Servis servis : this.servisi) {
				
				String linija_za_upis = String.valueOf(servis.getId()) + "|" + 
				String.valueOf(servis.getAuto_za_servis().getId()) + "|" + 
				String.valueOf(servis.getServiser().getId()) + "|" 
				+ servis.getTermin() + "|" 
				+ servis.getOpis() + "|" + 
				servis.getStatus_servisa() +"\n";
				
				fajl.write(linija_za_upis);
				}
				fajl.close();
				
			} catch (IOException e) {
				
				System.out.println("Nije dobro uneto u fajlu .");
			}
		}

	
	

	public void upisServisnihKnjizica() {
		
		
		File fajl_out = new File("C:\\Users\\stefa\\eclipse-workspace\\Projekatjava2\\src\\Fajlovi\\Servisne_knjizice.txt");
		
		try {
			BufferedWriter fajl = new BufferedWriter(new FileWriter(fajl_out));
			for(Servisna_knjizica servisna_knjizica : servisne_knjizice) {
			
			String linija_za_upis = String.valueOf(servisna_knjizica.getId()) +"\n";
			
			fajl.write(linija_za_upis);
			}
			fajl.close();
			
		} catch (IOException e) {
			
			System.out.println("Nije dobro uneto u fajlu .");
		}
}

	public void upisiSvih() {
		upisAdministratora();
		upisMusterija();
		upisServisera();
		upisAutomobila();
		upisDelova();
		upisServisa();
		upisServisnihKnjizica();
		
	}
	public Administrator login_a(String KorisnickoIme , String sifra) {
		for(Administrator admin : administratori) {
			if(admin.getKorisnicko_ime().equalsIgnoreCase(KorisnickoIme) &&
					admin.getSifra().equals(sifra)) {
				return admin;
			}
		} 
		return null;
	
	}
	
	public Musterija login_m(String KorisnickoIme , String sifra) {
		for(Musterija musterijaa : musterije) {
			if(musterijaa.getKorisnicko_ime().equalsIgnoreCase(KorisnickoIme) &&
					musterijaa.getSifra().equals(sifra)) {
				return musterijaa;
			}
		} 
		return null;
	
	}
	
	public Serviser login_s(String KorisnickoIme , String sifra) {
		for(Serviser serviserr : serviseri) {
			if(serviserr.getKorisnicko_ime().equalsIgnoreCase(KorisnickoIme) &&
					serviserr.getSifra().equals(sifra)) {
				return serviserr;
			}
		} 
		return null;
	
	}
	
	
	
	
}
