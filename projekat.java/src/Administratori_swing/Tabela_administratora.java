package Administratori_swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Liste.Liste;
import Moduli.Administrator;

public class Tabela_administratora extends JFrame {
	

	private JToolBar main_tool_bar = new JToolBar();
	private JButton btnAdd = new JButton("Dodaj");
	private JButton btnEdit = new JButton("Izmeni");
	private JButton btnDelete = new JButton("Obrisi");
	
	private DefaultTableModel table_model;
	private JTable administratori_tabela;
	
	private Liste listee;
	
	public Tabela_administratora(Liste listee) {
		this.listee = listee;
		setTitle("Administratori");
		setSize(600,200 );
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		
	}
	private void initGUI() {

		main_tool_bar.add(btnAdd);
		main_tool_bar.add(btnEdit);
		main_tool_bar.add(btnDelete);

		add(main_tool_bar, BorderLayout.WEST);
		String[] zaglavlje = new String[] {"Ime", "Prezime", "Korisnicko ime" ,"Adresa", "Broj telefona", "Plata"};
		Object[][] sadrzaj = new Object[listee.getAdministratori().size()][zaglavlje.length];
		
		for(int i = 0; i < listee.getAdministratori().size(); i ++) {
			Administrator admin = listee.getAdministratori().get(i);
			sadrzaj[i][0] = admin.getIme();
			sadrzaj[i][1] = admin.getPrezime();
			sadrzaj[i][2] = admin.getKorisnicko_ime();
			sadrzaj[i][3] = admin.getAdresa();
			sadrzaj[i][4] = admin.getBroj_telefona();
			sadrzaj[i][5] = admin.getPlata();
		} 
		
		table_model = new DefaultTableModel(sadrzaj, zaglavlje);
		administratori_tabela = new JTable(table_model);
		
		administratori_tabela.setRowSelectionAllowed(true);
		administratori_tabela.setColumnSelectionAllowed(false);
		administratori_tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		administratori_tabela.setDefaultEditor(Object.class, null);
		administratori_tabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane jsp = new JScrollPane(administratori_tabela);
		add(jsp, BorderLayout.CENTER);
	
	}
	
	private void initActions() {
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int red = administratori_tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Odaberite administratora kog zelite da obrisete.", "Greska!", JOptionPane.WARNING_MESSAGE);
				}else {
					String korisnicko_ime = table_model.getValueAt(red,  2).toString();
					Administrator admin = listee.nadjiAdministratora(korisnicko_ime);
					int izbor = JOptionPane.showConfirmDialog(null, "Obrisi korisnika: " + korisnicko_ime + "?", "Neophodna potvrda.",JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						listee.getAdministratori().remove(admin);
						table_model.removeRow(red);
						JOptionPane.showMessageDialog(null, "Korisnik " + korisnicko_ime + " obrisan!");
						listee.upisiSvih();
					}
					
					
							
				}
				
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				dodaj_izmeni_admina fda = new dodaj_izmeni_admina(listee, null);
				fda.setVisible(true);

				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int red = administratori_tabela.getSelectedRow();
				if (red == -1) {
					JOptionPane.showMessageDialog(null, "Odaberite red za izmenu.", "Greska!", JOptionPane.WARNING_MESSAGE);
					
				}else {
					String korisnicko_ime = table_model.getValueAt(red, 2).toString();
					Administrator admin123 = listee.nadjiAdministratora(korisnicko_ime);
					dodaj_izmeni_admina admini = new dodaj_izmeni_admina(listee, admin123);
					admini.setVisible(true);
				}
				
			}
		});

	
	}

}

