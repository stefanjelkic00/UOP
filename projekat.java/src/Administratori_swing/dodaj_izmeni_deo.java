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
import Moduli.Deo;
import Moduli.Servis;
import net.miginfocom.swing.MigLayout;
import Liste.Liste;

public class dodaj_izmeni_deo extends JFrame {

private JLabel label_marka = new JLabel("Marka: ");
private JLabel label_model = new JLabel("Model: ");
private JLabel label_naziv = new JLabel("Naziv: ");
private JLabel label_cena = new JLabel("Cena: ");
private JLabel namenjen_za_servis = new JLabel("Namenjen za servis: ");
private JComboBox<String> namenjen_za_servis_box = new JComboBox<String>();
private JComboBox<Marka> marka = new JComboBox<Marka>(Marka.values());
private JComboBox<Model> model = new JComboBox<Model>(Model.values());
private JTextField naziv = new JTextField(20);
private JTextField cena = new JTextField(20);
private JButton btnOK = new JButton("OK");
private JButton btnCancel = new JButton("Cancel");

private Liste listee;
private Deo deo;

public dodaj_izmeni_deo(Liste listee, Deo deo1) {
	this.listee = listee;
	this.deo = deo1;
	if(deo == null) {
		setTitle("Novi Deo");
	}else {
		setTitle("Izmenjivanje dela: " + deo.getId());
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
	MigLayout layout = new MigLayout("wrap 2", "[][]","[][][][]25[]");
	setLayout(layout);
	
	for(Servis servis1 : listee.getServisi()) {
		namenjen_za_servis_box.addItem(String.valueOf(servis1.getId()) + "-" + servis1.getOpis());
	}
	
	if(deo != null) {
		popuniPolja();
	}
	
	add(label_marka);
	add(marka);
	add(label_model);
	add(model);
	add(label_naziv);
	add(naziv);
	add(label_cena);
	add(cena);
	add(namenjen_za_servis);
	add(namenjen_za_servis_box);
	add(btnOK, "split 2");
	add(btnCancel);

}

private void InitActions() {
	
	btnCancel.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {

			dodaj_izmeni_deo.this.dispose();
			dodaj_izmeni_deo.this.setVisible(false);
			
		}
	});
	
	btnOK.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(validacija()) {
				int id2 = listee.getDelovi().get(listee.getDelovi().size() - 1).getId() + 1;
				Marka marka2 = Marka.valueOf(marka.getSelectedItem().toString());
				Model model2 = Model.valueOf(model.getSelectedItem().toString());
				String naziv2 = naziv.getText().toString().trim();
				int cena2 = Integer.parseInt(cena.getText().toString().trim());
				Servis servis2 = listee.NadjiServis(Integer.parseInt(namenjen_za_servis_box.getSelectedItem().toString().split("-")[0]));
				if(deo == null) {
					if(listee.NadjiDeo(id2) == null) {
						
						Deo deooo = new Deo(id2, marka2, model2, naziv2, cena2, servis2);
						listee.getDelovi().add(deooo);
						listee.upisiSvih();
						
					}else {
						JOptionPane.showMessageDialog(null, "Servis sa upisanim ID-jem vec postoji.");
					}
				}else {
							
					deo.setId(id2);
					deo.setMarka(Marka.valueOf(marka.getSelectedItem().toString()));
					deo.setModel(Model.valueOf(model.getSelectedItem().toString()));
					deo.setNaziv(naziv.getText().toString());
					deo.setCena(Integer.parseInt(cena.getText().toString()));
					deo.setNamenjen_za_servis(listee.NadjiServis(Integer.parseInt(namenjen_za_servis_box.getSelectedItem().toString().split("-")[0])));
					
				}
			
				listee.upisiSvih();
				dodaj_izmeni_deo.this.dispose();
				dodaj_izmeni_deo.this.setVisible(false);
			
			
		}
		}});
}

private void popuniPolja() {
	marka.setSelectedItem(deo.getMarka());
	model.setSelectedItem(deo.getModel());
	naziv.setText(deo.getNaziv());
	cena.setText(String.valueOf(deo.getCena()));
	namenjen_za_servis_box.setSelectedItem(deo.Namenjen_za_taj_servis().getId()+"-"+deo.Namenjen_za_taj_servis().getOpis());
}

private boolean validacija() {
	boolean ok = true;
	String poruka = "Ispravite date greske: \n";
	try {
		Integer.parseInt(cena.getText().trim());
	}catch(NumberFormatException e) {
		poruka += "cena mora biti broj\n";
		ok = false;
	}
	
	if(naziv.getText().trim().equals("")) {
		poruka += "-Naziv\n";
		ok = false;
	}
	if(cena.getText().toString().trim().equals("")) {
		poruka += "-Cena\n";
		ok = false;
	}
		

		if(ok == false) {
		JOptionPane.showMessageDialog(null, poruka, "Prazna polja", JOptionPane.WARNING_MESSAGE);
	}
	return ok;
}
}