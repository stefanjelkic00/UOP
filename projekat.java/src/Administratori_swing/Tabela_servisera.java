package Administratori_swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Moduli.Administrator;
import Moduli.Musterija;
import Moduli.Servis;
import Moduli.Serviser;
import Liste.Liste;

public class Tabela_servisera extends JFrame {

	
	private JToolBar main_tool_bar = new JToolBar();
	private JButton btnAdd = new JButton("Dodaj");
	private JButton btnEdit = new JButton("Izmeni");
	private JButton btnDelete = new JButton("Obrisi");
	
	private DefaultTableModel table_model;
	private JTable serviseri_tabela;
	
	private Liste listee;
	
	public Tabela_servisera(Liste listee) {
		this.listee = listee;
		setTitle("Pregled servisera");
		setSize(850, 300);
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

		add(main_tool_bar, BorderLayout.SOUTH);
		String[] zaglavlje = new String[] {"Ime", "Prezime", "Korisnicko ime" ,"Adresa", "Broj Telefona", "Plata", "Specijalizacija"};
		Object[][] sadrzaj = new Object[listee.getServiseri().size()][zaglavlje.length];
		
		for(int i = 0; i < listee.getServiseri().size(); i ++) {
			Serviser ser = listee.getServiseri().get(i);
			sadrzaj[i][0] = ser.getIme();
			sadrzaj[i][1] = ser.getPrezime();
			sadrzaj[i][2] = ser.getKorisnicko_ime();
			sadrzaj[i][3] = ser.getAdresa();
			sadrzaj[i][4] = ser.getBroj_telefona();
			sadrzaj[i][5] = ser.getPlata();
			sadrzaj[i][6] = ser.getSpecijalizacija();

		
		
		}
		
		table_model = new DefaultTableModel(sadrzaj, zaglavlje);
		serviseri_tabela = new JTable(table_model);
		
		serviseri_tabela.setRowSelectionAllowed(true);
		serviseri_tabela.setColumnSelectionAllowed(false);
		serviseri_tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		serviseri_tabela.setDefaultEditor(Object.class, null);
		serviseri_tabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane jsp = new JScrollPane(serviseri_tabela);
		add(jsp, BorderLayout.CENTER);
	
	}
	
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int red = serviseri_tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Odaberite servisera kog zelite da obrisete.", "Greska!", JOptionPane.WARNING_MESSAGE);
				}else {
					String korisnicko_ime = table_model.getValueAt(red,  2).toString();
					Serviser ser = listee.NadjiServisera(korisnicko_ime);
					int izbor = JOptionPane.showConfirmDialog(null, "Obrisi korisnika: " + ser.getIme() + ser.getPrezime() + "?", "Neophodna potvrda.",JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						for(Servis s : ser.getServisi_gde_je_zaduzen()) {
							listee.getServisi().remove(s);
						}
						listee.getServiseri().remove(ser);
						listee.upisiSvih();
						table_model.removeRow(red);
						JOptionPane.showMessageDialog(null, "Korisnik " + korisnicko_ime + " obrisan!");
					}
					
					
							
				}
				
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				dodaj_izmeni_servisera fds = new dodaj_izmeni_servisera(listee, null);
				fds.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = serviseri_tabela.getSelectedRow();
				if (red == -1) {
					JOptionPane.showMessageDialog(null, "Odaberite red za izmenu.", "jGreska!", JOptionPane.WARNING_MESSAGE);
					
				}else {
					String korisnicko_ime = table_model.getValueAt(red, 2).toString();
					Serviser serv = listee.NadjiServisera(korisnicko_ime);
					dodaj_izmeni_servisera fds = new dodaj_izmeni_servisera(listee, serv);
					fds.setVisible(true);		
					}
			}
		});
		

		}
}
