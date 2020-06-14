package app;
import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class l extends JFrame {
	
	private JLabel lblGreeting = new JLabel("Dobrodosli. Molimo da se prijavite");
	private JLabel lblUsername = new JLabel("korisnicko ime ");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblPassword = new JLabel("Sifra");
	private JPasswordField pfPassword = new JPasswordField(20);
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	public l() {
		setTitle("Prijava");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		pack();
	}
	
	public void initGUI() {
		MigLayout nig = new MigLayout("wrap 2","[][]","[]10[][]10[]");
		setLayout(nig);
		add(lblGreeting, "span 2");
		add(lblUsername);
		add(txtKorisnickoIme);
		add(lblPassword);
		add(pfPassword);
		add(new JLabel());
		add(btnOk , "split 2");
		add(btnCancel);
		
		
	}
	public void initActions() {
		
	}
	
}
