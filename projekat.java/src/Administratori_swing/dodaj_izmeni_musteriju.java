package Administratori_swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import enumi.Pol;
import Moduli.Automobil;
import Moduli.Musterija;
import net.miginfocom.swing.MigLayout;
import Liste.Liste;

public class dodaj_izmeni_musteriju extends JFrame {

private JLabel label_ime = new JLabel("Ime: ");
private JLabel label_prezime = new JLabel("Prezime: ");
private JLabel label_jmbg = new JLabel("JMBG: ");
private JLabel label_pol = new JLabel("Pol: ");
private JLabel label_adresa = new JLabel("Adresa: ");
private JLabel label_broj_telefona = new JLabel("Broj telefona: ");
private JLabel label_korisnicko_ime = new JLabel("Korisnicko ime: ");
private JLabel label_sifra = new JLabel("Sifra: ");
private JLabel label_bodovi = new JLabel("Nagradni bodovi: ");
private JTextField ime = new JTextField(20);
private JTextField prezime = new JTextField(20);
private JTextField jmbg = new JTextField(20);
private JTextField adresa = new JTextField(20);
private JTextField broj_telefona = new JTextField(20);
private JTextField korisnicko_ime = new JTextField(20);
private JTextField sifra = new JTextField(20);
private JComboBox<Pol> pol = new JComboBox<Pol>(Pol.values());
private JTextField bodovi = new JTextField(20);
private JButton btnOK = new JButton("OK");
private JButton btnCancel = new JButton("Cancel");

private Liste listee;
private Musterija musterija;


dodaj_izmeni_musteriju(Liste listee , Musterija musteri) {
	this.listee = listee;
	this.musterija = musteri;
	if(musterija == null) {
		setTitle("Nova Musterija");
	}else {
		setTitle("Izmenjivanje Musterije: " + musterija.getPrezime());
	}
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setLocationRelativeTo(null);
	setResizable(false);
	setSize(400, 600);
	InitGUI();
	InitActions();
	pack();
}

private void InitGUI() {
	MigLayout layout = new MigLayout("wrap 2", "[][]","[][][][][][][][][]25[]");
	setLayout(layout);
	
	if(musterija != null) {
		popuniPolja();
	}
	
	add(label_ime);
	add(ime);
	add(label_prezime);
	add(prezime);
	add(label_jmbg);
	add(jmbg);
	add(label_pol);
	add(pol);
	add(label_adresa);
	add(adresa);
	add(label_broj_telefona);
	add(broj_telefona);
	add(label_korisnicko_ime);
	add(korisnicko_ime);
	add(label_sifra);
	add(sifra);
	add(label_bodovi);
	add(bodovi);
	add(btnOK, "split 2");
	add(btnCancel);

}

private void InitActions() {
	
	btnCancel.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dodaj_izmeni_musteriju.this.dispose();
			dodaj_izmeni_musteriju.this.setVisible(false);
			
		}
	});
	
	btnOK.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(validacija()) {
				int id1 = listee.getMusterije().get(listee.getMusterije().size() - 1).getId() + 1;
				String ime1 = ime.getText().trim();
				String prezime1 = prezime.getText().trim();
				String jmbg1 = jmbg.getText().trim();
				Pol pol1 = Pol.valueOf(pol.getSelectedItem().toString());
				String adresa1 = adresa.getText().trim();
				String broj1 = broj_telefona.getText().trim();
				String korisnicko_ime1 = korisnicko_ime.getText().trim();
				String sifra1 = sifra.getText().trim();
				int bodovii = Integer.parseInt(bodovi.getText().trim());
				if(musterija == null) {
					if(listee.NadjiMusteriju(id1) == null && listee.NadjiMusteriju(korisnicko_ime1) == null) {
					Musterija musterrr = new Musterija(id1, ime1, prezime1,
							jmbg1, pol1, adresa1, broj1, korisnicko_ime1, sifra1, bodovii, new ArrayList<Automobil>());
					listee.getMusterije().add(musterrr);
					JOptionPane.showMessageDialog(null, "Musterija " + korisnicko_ime1 + " je dodat .");
					}else {
						JOptionPane.showMessageDialog(null, "Korisnik sa upisanim ID-jem ili korisnickim imenom vec postoji.");
					}
				}else {
					musterija.setId(id1);
					musterija.setIme(ime1);
					musterija.setAdresa(adresa1);
					musterija.setBroj_telefona(broj1);
					musterija.setJmbg(jmbg1);
					musterija.setKorisnicko_ime(korisnicko_ime1);
					musterija.setSifra(sifra1);
					musterija.setBroj_nagradnoh_bodova(bodovii);
					musterija.setPol(pol1);
					musterija.setPrezime(prezime1);
					JOptionPane.showMessageDialog(null, "Musterija " + korisnicko_ime1 + "je izmenjena.");
				}
				
				listee.upisMusterija();
				dodaj_izmeni_musteriju.this.dispose();
				dodaj_izmeni_musteriju.this.setVisible(false);
				
			}
			
		}
	});
}

private void popuniPolja() {
	ime.setText(musterija.getIme());
	prezime.setText(musterija.getPrezime());
	jmbg.setText(musterija.getJmbg());
	pol.setSelectedItem(musterija.getPol());
	adresa.setText(musterija.getAdresa());
	broj_telefona.setText(musterija.getBroj_telefona());
	korisnicko_ime.setText(musterija.getKorisnicko_ime());
	sifra.setText(musterija.getSifra());
	bodovi.setText(String.valueOf(musterija.getBroj_nagradnoh_bodova()));


}

private boolean validacija() {
	boolean ok = true;
	String poruka = "Ispravite date greske : \n";
		
	if(ime.getText().trim().equals("")) {
		poruka += "-Ime\n";
		ok = false;
	}

	if(prezime.getText().trim().equals("")) {
		poruka += "-Prezime\n";
		ok = false;
	}

	if(jmbg.getText().trim().equals("")) {
		poruka += "-JMBG\n";
		ok = false;
	}

	if(pol.getSelectedItem().toString().equals("")) {
		poruka += "-Pol\n";
		ok = false;
	}

	if(adresa.getText().trim().equals("")) {
		poruka += "-Adresa\n";
		ok = false;
	}

	if(broj_telefona.getText().trim().equals("")) {
		poruka += "-Broj Telefona\n";
		ok = false;
	}

	if(korisnicko_ime.getText().trim().equals("")) {
		poruka += "-Korisnicko Ime\n";
		ok = false;
	}

	if(sifra.getText().trim().equals("")) {
		poruka += "-Sifra\n";
		ok = false;
	}

	try {
		
		Integer.parseInt(bodovi.getText().trim());
	}catch(NumberFormatException e) {
		poruka += "Broj bodova mora biti broj\n";
		ok = false;
	}
	if(ok == false) {
		JOptionPane.showMessageDialog(null, poruka, "Prazna polja", JOptionPane.WARNING_MESSAGE);
	}
	return ok;
}
}
