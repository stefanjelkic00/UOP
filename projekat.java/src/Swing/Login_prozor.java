package Swing;

import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Administratori_swing.Glavni_meni_a;
import Liste.Liste;
import Moduli.Administrator;
import Moduli.Musterija;
import Moduli.Servis;
import Moduli.Serviser;
import Musterije_swing.Glavni_meni_m;
import Serviseri_swing.Glavni_meni_s;
import net.miginfocom.swing.MigLayout;

public class Login_prozor extends JFrame {
	private JLabel lblGreeting = new JLabel("Dobrodosli,molimo da se prijavite.");

	private JLabel lblUsername = new JLabel("Korisnicko ime");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblPassword = new JLabel("Sifra");
	private JPasswordField pfPassword = new JPasswordField(20);
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private Liste sve_liste ;
	
	public Login_prozor(Liste sve_liste) {
		this.sve_liste = sve_liste;
		setTitle("Prijava");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		pack();

	}
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2","[][]","[]10[][]10[]");
		setLayout(mig);
		
		add(lblGreeting ,"span2");
		add(lblUsername );
		add(txtKorisnickoIme);
		add(lblPassword);
		add(pfPassword);
		add(new JLabel());
		add(btnOk,"split2");
		add(btnCancel);
		
		getRootPane().setDefaultButton(btnOk);
		
	}
	public void initActions() {
		 btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Login_prozor.this.dispose();
				Login_prozor.this.setVisible(false);
				
			}
		});
		 
		 btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String korisnickoIme = txtKorisnickoIme.getText().trim();
				String sifra = new String(pfPassword.getPassword()).trim();
				
				
				if(korisnickoIme.equals("") || sifra.contentEquals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke za prijavu !", "Greska" , JOptionPane.WARNING_MESSAGE);	
				
				
				
				
				
				}

				
				else {
					Musterija musterijaa = sve_liste.login_m(korisnickoIme, sifra);
					Administrator admin = sve_liste.login_a(korisnickoIme, sifra);
					Serviser serviserr  = sve_liste.login_s(korisnickoIme, sifra);
					if (admin != null) {
						Glavni_meni_a glavni_prozor = new Glavni_meni_a(sve_liste,admin);
						glavni_prozor.setVisible(true);
						Login_prozor.this.dispose();
						Login_prozor.this.setVisible(false);
					}
					else if (musterijaa != null) {
						Glavni_meni_m glavni_prozor = new Glavni_meni_m(sve_liste,musterijaa);
						glavni_prozor.setVisible(true);
						Login_prozor.this.dispose();
						Login_prozor.this.setVisible(false);
					}
					else if (serviserr != null) {
						Glavni_meni_s glavni_prozor = new Glavni_meni_s(sve_liste,serviserr);
						glavni_prozor.setVisible(true);
						Login_prozor.this.dispose();
						Login_prozor.this.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Niste uneli dobro korisnicko ime ili lozinku !", "Greska", JOptionPane.WARNING_MESSAGE);
					}
					
					
					
				}
			}
		});
	}
}

