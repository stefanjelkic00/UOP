package Serviseri_swing;


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
import Moduli.Musterija;
import Moduli.Servis;
import Moduli.Serviser;
import Moduli.Servisna_knjizica;
import net.miginfocom.swing.MigLayout;
import Liste.Liste;

public class dodaj_izmeni_servis extends JFrame {

private JLabel label_auto = new JLabel("Auto za servis: ");
private JLabel label_termin = new JLabel("Termin: ");
private JLabel label_opis = new JLabel("Opis: ");
private JLabel label_status = new JLabel("Status servisa: ");
private JComboBox<String> auto_jcb = new JComboBox<String>();
private JTextField termin = new JTextField(20);
private JTextField opis = new JTextField(20);
private JComboBox<Status_servisa> status_servisa_jcb = new JComboBox<Status_servisa>(Status_servisa.values());
private JButton btnOK = new JButton("OK");
private JButton btnCancel = new JButton("Cancel");

private Liste listee;
private Servis servis;
private Serviser serviser;

public dodaj_izmeni_servis(Liste listee, Servis serviss, Serviser serviser) {
	this.listee = listee;
	this.servis = serviss;
	this.serviser = serviser;
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
	MigLayout layout = new MigLayout("wrap 2", "[][]","[][][][][][]");
	setLayout(layout);
	
	for(Automobil a : listee.getAutomobili()) {
		auto_jcb.addItem(String.valueOf(a.getId()) + ":" + a.getMarka() + "-" + a.getModel());
	}
	
	if(servis != null) {
		popuniPolja();
	}
	
	add(label_auto);
	add(auto_jcb);
	add(label_termin);
	add(termin);
	add(label_opis);
	add(opis);
	if(servis != null) {
	add(label_status);
	add(status_servisa_jcb);
	}
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
				
				String autoo = auto_jcb.getSelectedItem().toString();
				int id2 = Integer.parseInt(autoo.split(":")[0]);
				Automobil autic = listee.NadjiAutomobil(id2);
				
				String terminn = termin.getText().trim();
				String opiss = opis.getText().trim();
				Status_servisa statuss = Status_servisa.valueOf(status_servisa_jcb.getSelectedItem().toString());
				
				if(servis == null) {
					if(listee.NadjiServis(idd) == null) {
					
						Servis servviss = new Servis(idd, autic, serviser, terminn, opiss, new ArrayList<Deo>(), statuss);
						for(Servisna_knjizica serv_knj : listee.getServisne_knjizice()) {
							if(serv_knj.getAutomobil().getId() == autic.getId()) {
								serv_knj.getObavljeni_servisi().add(servviss);
								listee.upisiSvih();
							}
						}
						listee.getServisi().add(servviss);
						for(Serviser serviserrr : listee.getServiseri()) {
							if(serviserrr.getKorisnicko_ime().equals(serviser.getKorisnicko_ime())) {
								serviserrr.getServisi_gde_je_zaduzen().add(servviss);
							}
						}
						for(Automobil autooo : listee.getAutomobili()) {
							if(autooo.getId() == id2) {
								autooo.getServisna_knjizica().getObavljeni_servisi().add(servviss);
							}
						}
					}else {
						JOptionPane.showMessageDialog(null, "Servis sa upisanim ID-jem vec postoji.");
					}
				}else {
					servis.SetId(idd);
					servis.setAuto_za_servis(autic);
					servis.setServiser(serviser);
					servis.setTermin(terminn);
					servis.setOpis(opiss);
					servis.setStatus_servisa(statuss);
					
				}
				listee.upisiSvih();
				dodaj_izmeni_servis.this.dispose();
				dodaj_izmeni_servis.this.setVisible(false);
			}
			
		}
	});
}

private void popuniPolja() {
	auto_jcb.setSelectedItem(String.valueOf(servis.getAuto_za_servis().getId())+ ":" + servis.getAuto_za_servis().getMarka() + "-" + servis.getAuto_za_servis().getModel());
	termin.setText(servis.getTermin());
	opis.setText(servis.getOpis());
	status_servisa_jcb.setSelectedItem(servis.getStatus_servisa());


}

private boolean validacija() {
	boolean ok = true;
	String poruka = "Molimo ispravite sledece greske u unosu: \n";
		
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


