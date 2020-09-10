package Swing;

import Liste.Liste;


public class Main {

	public static void main(String[] args) {
	Liste sve_liste = new Liste();
			
			sve_liste.UcitajAdministratore("C:\\Users\\stefa\\eclipse-workspace\\Projekatjava2\\src\\Fajlovi\\Administratori.txt");
			sve_liste.ucitajMusterije("C:\\Users\\stefa\\eclipse-workspace\\Projekatjava2\\src\\Fajlovi\\Musterije.txt");
			sve_liste.ucitajServisnaKnjizice("C:\\Users\\stefa\\eclipse-workspace\\Projekatjava2\\src\\Fajlovi\\Servisne_knjizice.txt");
			sve_liste.ucitajAutomobile("C:\\Users\\stefa\\eclipse-workspace\\Projekatjava2\\src\\Fajlovi\\Automobili.txt");
			sve_liste.ucitajServisere("C:\\Users\\stefa\\eclipse-workspace\\Projekatjava2\\src\\Fajlovi\\Serviseri.txt");
			sve_liste.ucitajServise("C:\\Users\\stefa\\eclipse-workspace\\Projekatjava2\\src\\Fajlovi\\Servisi.txt");
			sve_liste.ucitajDelove("C:\\Users\\stefa\\eclipse-workspace\\Projekatjava2\\src\\Fajlovi\\Delovi.txt");
			
		
		Login_prozor login_prozor = new Login_prozor(sve_liste);
		login_prozor.setVisible(true);
		sve_liste.upisiSvih();
	}

}
