package Administratori_swing;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Liste.Liste;
import enumi.Marka;
import enumi.Model;
import enumi.Model;

import enumi.Vrsta_goriva;
import Moduli.Automobil;
import Moduli.Musterija;
import Moduli.Servisna_knjizica;
import net.miginfocom.swing.MigLayout;
import Liste.Liste;

public class dodaj_izmeni_automobil extends JFrame {

private JLabel label_vlasnik = new JLabel("Vlasnik: ");
private JLabel label_marka = new JLabel("Marka: ");
private JLabel label_model = new JLabel("Model: ");
private JLabel label_godiste = new JLabel("Godina proizvodnje: ");
private JLabel label_zapremina = new JLabel("Zapremina(ccm): ");
private JLabel label_snaga = new JLabel("Snaga(ks): ");
private JLabel label_vrsta_goriva = new JLabel("Vrsta goriva: ");
private JButton nova_musterija = new JButton("Nova musterija");
private JComboBox<String> vlasnik = new JComboBox<String>();
private JComboBox<Marka> marka = new JComboBox<Marka>(Marka.values());
private JComboBox<Model> model = new JComboBox<Model>(Model.values());
private JTextField godiste = new JTextField(20);
private JTextField snaga = new JTextField(20);
private JTextField zapremina = new JTextField(20);
private JComboBox<Vrsta_goriva> vrsta_goriva = new JComboBox<Vrsta_goriva>(Vrsta_goriva.values());
private JButton btnOK = new JButton("OK");
private JButton btnCancel = new JButton("Cancel");

private Liste listee;
private Automobil automobil;

public dodaj_izmeni_automobil(Liste listee, Automobil auto) {
	this.listee = listee;
	this.automobil = auto;
	if(automobil == null) {
		setTitle("Novi Automobil");
	}else {
		setTitle("Izmenjivanje Automobila: " + automobil.getId()+ ": " + automobil.getMarka() + "-" + automobil.getModel());
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
	MigLayout layout = new MigLayout("wrap 2", "[][]","[][][][][][][]25[]");
	setLayout(layout);
	
	for(Musterija musteri : listee.getMusterije()) {
		vlasnik.addItem(String.valueOf(musteri.getId()) + ":" + musteri.getKorisnicko_ime());
		
	}
	
	if(automobil != null) {
		popuniPolja();
	}
	
	add(label_vlasnik);
	add(vlasnik);
	add(label_marka);
	add(marka);
	add(label_model);
	add(model);
	add(label_godiste);
	add(godiste);
	add(label_zapremina);
	add(zapremina);
	add(label_snaga);
	add(snaga);
	add(label_vrsta_goriva);
	add(vrsta_goriva);
	add(btnOK, "split 2");
	add(btnCancel);

}

private void InitActions() {
	
	
	nova_musterija.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {

			dodaj_izmeni_musteriju musteri1 = new dodaj_izmeni_musteriju(listee, null);
			musteri1.setVisible(true);

		}
	});
	
	btnCancel.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {

			dodaj_izmeni_automobil.this.dispose();
			dodaj_izmeni_automobil.this.setVisible(false);
			
		}
	});
	
	btnOK.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(validacija()) {
				int id1 = listee.getAutomobili().get(listee.getAutomobili().size() - 1).getId() + 1;
				Musterija vlasnik1 = listee.NadjiMusteriju(Integer.parseInt(vlasnik.getSelectedItem().toString().split(":")[0]));
				Marka marka1 = Marka.valueOf(marka.getSelectedItem().toString());
				Model model1 = Model.valueOf(model.getSelectedItem().toString());
				String god1 = godiste.getText().toString();
				int snaga1 = Integer.parseInt(snaga.getText().toString());
				int zapremina1 = Integer.parseInt(zapremina.getText().toString());
				Vrsta_goriva vrsta_goriva1 = Vrsta_goriva.valueOf(vrsta_goriva.getSelectedItem().toString());
				
				if(automobil == null) {
					
					if(listee.NadjiAutomobil(id1) == null) {
						
						Automobil auticcc = new Automobil(id1, vlasnik1, marka1, model1, god1, zapremina1, snaga1, vrsta_goriva1, new Servisna_knjizica());
						for(Musterija m : listee.getMusterije()) {
							if(m.getKorisnicko_ime().equalsIgnoreCase(vlasnik1.getKorisnicko_ime())) {
								m.getAuti().add(auticcc);
							}
						}
						
						listee.upisMusterija();
						listee.getAutomobili().add(auticcc);
						listee.upisAutomobila();
						
						
					}else {
						JOptionPane.showMessageDialog(null, "Servis sa upisanim ID-jem vec postoji.");
					}
					JOptionPane.showMessageDialog(null, "Automobil je dodat .");
				}else {
							
					automobil.setId(id1);
					automobil.setVlasnik(vlasnik1);
					automobil.setMarka(marka1);
					automobil.setModel(model1);
					automobil.setGodina_proizvodnje(god1);
					automobil.setZapremina_motora(zapremina1);
					automobil.setSnaga_motora(snaga1);
					automobil.setVrsta_goriva(vrsta_goriva1);
				
					
					
					for(Musterija m : listee.getMusterije()) {
						if(m.getKorisnicko_ime().equalsIgnoreCase(vlasnik1.getKorisnicko_ime())) {
							m.getAuti().add(new Automobil(id1, vlasnik1, marka1, model1, god1, zapremina1, snaga1, vrsta_goriva1, new Servisna_knjizica()));
						}
					}
					JOptionPane.showMessageDialog(null, "Automobil je izmenjen.");
				}
				
				listee.upisiSvih();
				dodaj_izmeni_automobil.this.dispose();
				dodaj_izmeni_automobil.this.setVisible(false);
			
			
		}
		}});
}

private void popuniPolja() {
	vlasnik.setSelectedItem(String.valueOf(automobil.getVlasnik().getId() + ":" + automobil.getVlasnik().getKorisnicko_ime()));
	marka.setSelectedItem(automobil.getMarka());
	model.setSelectedItem(automobil.getModel());
	godiste.setText(automobil.getGodina_proizvodnje());
	zapremina.setText(String.valueOf(automobil.getZapremina_motora()));
	snaga.setText(String.valueOf(automobil.getSnaga_motora()));
	vrsta_goriva.setSelectedItem(automobil.getVrsta_goriva());

}

private boolean validacija() {
	boolean bool = true;
	String poruka = "Ispravite date greske : \n";
	try {
		Integer.parseInt(zapremina.getText().trim());
		Integer.parseInt(snaga.getText().trim());
	}catch(NumberFormatException e) {
		poruka += "Zapremina i snaga moraju biti broj\n";
		bool = false;
	}
		
	if(godiste.getText().trim().equals("")) {
		poruka += "-Godiste\n";
		bool = false;
	}


		if(bool == false) {
		JOptionPane.showMessageDialog(null, poruka, "Prazna polja", JOptionPane.WARNING_MESSAGE);
	}
	return bool;
}
}