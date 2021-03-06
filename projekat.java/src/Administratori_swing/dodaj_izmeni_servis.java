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

import enumi.Status_servisa;
import Moduli.Automobil;
import Moduli.Deo;
import Moduli.Servis;
import Moduli.Serviser;
import Moduli.Servisna_knjizica;
import net.miginfocom.swing.MigLayout;
import Liste.Liste;

public class dodaj_izmeni_servis extends JFrame {

private JLabel label_auto = new JLabel("Auto za servis: ");
private JLabel label_serviser = new JLabel("Serviser: ");
private JLabel label_termin = new JLabel("Termin: ");
private JLabel label_opis = new JLabel("Opis: ");
private JLabel label_status = new JLabel("Status servisa: ");
private JComboBox<String> auto = new JComboBox<String>();
private JComboBox<String> serviser = new JComboBox<String>();
private JTextField termin = new JTextField(20);
private JTextField opis = new JTextField(20);
private JComboBox<Status_servisa> status = new JComboBox<Status_servisa>(Status_servisa.values());
private JButton btnOK = new JButton("OK");
private JButton btnCancel = new JButton("Cancel");

private Liste listee;
private Servis servis;

public dodaj_izmeni_servis(Liste listee, Servis serviss) {
	this.listee = listee;
	this.servis = serviss;
	if(servis == null) {
		setTitle("Novi Servis");
	}else {
		setTitle("Izmenjivanje Servisa: " + servis.getId());
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
	MigLayout layout = new MigLayout("wrap 2", "[][]","[][][][][]25[]");
	setLayout(layout);
	
	for(Automobil auto1 : listee.getAutomobili()) {
		auto.addItem(String.valueOf(auto1.getId()) + ":" + auto1.getModel());
	}
	for(Serviser serviser1 : listee.getServiseri()) {
		serviser.addItem(serviser1.getPrezime());
	}
	
	if(servis != null) {
		popuniPolja();
	}
	
	add(label_auto);
	add(auto);
	add(label_serviser);
	add(serviser);
	add(label_termin);
	add(termin);
	add(label_opis);
	add(opis);
	
	add(label_status);
	add(status);
	
	add(btnOK, "split 2");
	add(btnCancel);

}

private void InitActions() {
	
	btnCancel.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {

			dodaj_izmeni_servis.this.dispose();
			dodaj_izmeni_servis.this.setVisible(false);
			
		}
	});
	
	btnOK.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(validacija()) {
				int idd = listee.getServisi().get(listee.getServisi().size() - 1).getId() + 1;
				
				String autoo = auto.getSelectedItem().toString();
				int id2 = Integer.parseInt(autoo.split(":")[0]);
				Automobil autoooo = listee.NadjiAutomobil(id2);
				
				String serviserr = serviser.getSelectedItem().toString();
				
				Serviser serviserrr = listee.NadjiServiseraPoPrezimenu(serviserr);
				
				String terminn = termin.getText().trim();
				String opiss = opis.getText().trim();
				Status_servisa statuss = Status_servisa.valueOf(status.getSelectedItem().toString());
				
				if(servis == null) {
					
					if(listee.NadjiServis(idd) == null) {
					
						Servis servviss = new Servis(idd, autoooo, serviserrr, terminn, opiss, new ArrayList<Deo>(), statuss);
						for(Servisna_knjizica sk : listee.getServisne_knjizice()) {
							if(sk.getAutomobil().getId() == autoooo.getId()) {
								sk.getObavljeni_servisi().add(servviss);
								listee.upisiSvih();
							}
						}
						listee.getServisi().add(servviss);
						for(Serviser s : listee.getServiseri()) {
							if(s.getKorisnicko_ime().equals(serviserrr.getKorisnicko_ime())) {
								s.getServisi_gde_je_zaduzen().add(servviss);
							}
						}
						for(Automobil a : listee.getAutomobili()) {
							if(a.getId() == id2) {
								a.getServisna_knjizica().getObavljeni_servisi().add(servviss);
							}
						}
					}else {
						JOptionPane.showMessageDialog(null, "Servis sa upisanim ID-jem vec postoji.");
					}
					JOptionPane.showMessageDialog(null, "Servis je dodat . ");
				}
				else {
					servis.SetId(idd);
					servis.setAuto_za_servis(autoooo);
					servis.setServiser(serviserrr);
					servis.setTermin(terminn);
					servis.setOpis(opiss);
					servis.setStatus_servisa(statuss);
					JOptionPane.showMessageDialog(null, "Servis je izmenjen . ");
				}
				listee.upisiSvih();
				dodaj_izmeni_servis.this.dispose();
				dodaj_izmeni_servis.this.setVisible(false);
			}
			
		}
	});
}

private void popuniPolja() {
	auto.setSelectedItem(String.valueOf(servis.getAuto_za_servis().getId())+ ":" + servis.getAuto_za_servis().getModel());
	serviser.setSelectedItem(servis.getServiser().getPrezime());
	termin.setText(servis.getTermin());
	opis.setText(servis.getOpis());
	status.setSelectedItem(servis.getStatus_servisa());


}

private boolean validacija() {
	boolean ok = true;
	String poruka = "Ispravite datu gresku : \n";
		
	if(termin.getText().trim().equals("")) {
		poruka += "-Termin\n";
		ok = false;
	}

	if(opis.getText().trim().equals("")) {
		poruka += "-Opis\n";
		ok = false;
	}

		if(ok == false) {
		JOptionPane.showMessageDialog(null, poruka, "Prazna polja", JOptionPane.WARNING_MESSAGE);
	}
	return ok;
}
}

