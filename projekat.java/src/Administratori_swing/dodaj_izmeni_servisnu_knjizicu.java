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

import Moduli.Automobil;
import Moduli.Servis;
import Moduli.Servisna_knjizica;
import net.miginfocom.swing.MigLayout;
import Liste.Liste;

public class dodaj_izmeni_servisnu_knjizicu extends JFrame {

private JLabel label_automobil = new JLabel("Automobil: ");
private JComboBox<String> automobil = new JComboBox<String>();
private JButton btnOK = new JButton("OK");
private JButton btnCancel = new JButton("Cancel");

private Liste listee;
private Servisna_knjizica servisna_knjizica;

public dodaj_izmeni_servisnu_knjizicu(Liste listee, Servisna_knjizica servisna_knj) {
	this.listee = listee;
	this.servisna_knjizica = servisna_knj;
	if(servisna_knjizica == null) {
		setTitle("Nova servisna knjizica");
	}else {
		setTitle("Izmenjivanje servisne knjizice: " + servisna_knjizica.getId());
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
	MigLayout layout = new MigLayout("wrap 2", "[][]","[]25[]");
	setLayout(layout);
	
	for(Automobil autooo : listee.getAutomobili()) {
		if(autooo.getServisna_knjizica().getId() == 0) {
			automobil.addItem(String.valueOf(autooo.getId()) + "-" + autooo.getModel());
			
		}
	}
	
	
	

	add(label_automobil);
	add(automobil);
	add(btnOK, "split 2");
	add(btnCancel);
	
	}


private void InitActions() {
	
	btnCancel.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {

			dodaj_izmeni_servisnu_knjizicu.this.dispose();
			dodaj_izmeni_servisnu_knjizicu.this.setVisible(false);
			
		}
	});
	
	btnOK.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(validacija()) {
				int idd = listee.getServisne_knjizice().get(listee.getServisne_knjizice().size() - 1).getId() + 1;
				Automobil auto = listee.NadjiAutomobil(Integer.parseInt(automobil.getSelectedItem().toString().split("-")[0]));
				
				if(servisna_knjizica == null) {
					if(listee.NadjiServisnuKnjizicu(idd) == null) {
						
						Servisna_knjizica serv_knj = new Servisna_knjizica(idd, auto, new ArrayList<Servis>());
						listee.getServisne_knjizice().add(serv_knj);
						listee.upisServisnihKnjizica();
						for(Automobil auto1 : listee.getAutomobili()) {
							if(auto1.getId() == auto.getId()) {
								auto1.setServisna_knjizica(serv_knj);
							}
						}
						listee.upisiSvih();
						
					}else {
						JOptionPane.showMessageDialog(null, "Servis sa upisanim ID-jem vec postoji.");
					}
				}else {
							
					servisna_knjizica.SetId(idd);
					servisna_knjizica.setAutomobil(auto);
					
					
					for(Automobil au : listee.getAutomobili()) {
						if(au.getId() == auto.getId()) {
							au.setServisna_knjizica(servisna_knjizica);
						}
					}
				}
			
				listee.upisiSvih();
				dodaj_izmeni_servisnu_knjizicu.this.dispose();
				dodaj_izmeni_servisnu_knjizicu.this.setVisible(false);
			
			
		}
		}});
}


private boolean validacija() {
	boolean ok = true;
	String poruka = "Ispravite date greske : \n";
		

		if(ok == false) {
		JOptionPane.showMessageDialog(null, poruka, "Prazna polja", JOptionPane.WARNING_MESSAGE);
	}
	return ok;
}
}
