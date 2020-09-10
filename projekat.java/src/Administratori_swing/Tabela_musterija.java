package Administratori_swing;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Moduli.Automobil;
import Moduli.Musterija;
import Liste.Liste;

public class Tabela_musterija extends JFrame {

	private JToolBar main_tool_bar = new JToolBar();
	private JButton btnAdd = new JButton("Dodaj");
	private JButton btnEdit = new JButton("Izmeni");
	private JButton btnDelete = new JButton("Obrisi");
	
	private DefaultTableModel table_model;
	private JTable musterije_tabela;
	
	private Liste listee;
	
	public Tabela_musterija(Liste listee) {
		this.listee = listee;
		setTitle("Pregled musterija");
		setSize(1000, 300);
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
		String[] zaglavlje = new String[] {"Ime", "Prezime", "Korisnicko ime" ,"Adresa", "Broj Telefona", "Nagradni bodovi", "Njegovi automobili"};
		Object[][] sadrzaj = new Object[listee.getMusterije().size()][zaglavlje.length];
		
		for(int i = 0; i < listee.getMusterije().size(); i ++) {
			Musterija mus = listee.getMusterije().get(i);
			sadrzaj[i][0] = mus.getIme();
			sadrzaj[i][1] = mus.getPrezime();
			sadrzaj[i][2] = mus.getKorisnicko_ime();
			sadrzaj[i][3] = mus.getAdresa();
			sadrzaj[i][4] = mus.getBroj_telefona();
			sadrzaj[i][5] = mus.getBroj_nagradnoh_bodova();
			String za_upis = " ";
			for(Automobil a : mus.getAuti()) {
				za_upis += a.getMarka() + "-" + a.getModel() + ",";
			}
			sadrzaj[i][6] = za_upis.substring(0, za_upis.length() - 1);

		
		
		}
		
		table_model = new DefaultTableModel(sadrzaj, zaglavlje);
		musterije_tabela = new JTable(table_model);
		
		musterije_tabela.setRowSelectionAllowed(true);
		musterije_tabela.setColumnSelectionAllowed(false);
		musterije_tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		musterije_tabela.setDefaultEditor(Object.class, null);
		musterije_tabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane jsp = new JScrollPane(musterije_tabela);
		add(jsp, BorderLayout.CENTER);
	
	}
	
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int red = musterije_tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Odaberite musteriju kog zelite da obrisete.", "Greska!", JOptionPane.WARNING_MESSAGE);
				}else {
					String korisnicko_ime = table_model.getValueAt(red,  2).toString();
					Musterija mus = listee.NadjiMusteriju(korisnicko_ime);
					int izbor = JOptionPane.showConfirmDialog(null, "Obrisi korisnika: " + korisnicko_ime + "?", "Neophodna potvrda.",JOptionPane.YES_NO_OPTION);
					int iddd = 0;
					int idsk = 0;
					if(izbor == JOptionPane.YES_OPTION) {
						for(Automobil a : mus.getAuti()) {
							iddd = a.getId();
							idsk = a.getServisna_knjizica().getId(); 
						}
						listee.getAutomobili().remove(listee.NadjiAutomobil(iddd));
						listee.getMusterije().remove(mus);
						listee.getServisne_knjizice().remove(listee.NadjiServisnuKnjizicu(idsk));
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
				dodaj_izmeni_musteriju fda = new dodaj_izmeni_musteriju(listee, null);
				fda.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int red = musterije_tabela.getSelectedRow();
				if (red == -1) {
					JOptionPane.showMessageDialog(null, "Odaberite red za izmenu.", "Greska!", JOptionPane.WARNING_MESSAGE);
					
				}else {
					String korisnicko_ime = table_model.getValueAt(red, 2).toString();
					Musterija muster = listee.NadjiMusteriju(korisnicko_ime);
					dodaj_izmeni_musteriju fda = new dodaj_izmeni_musteriju(listee, muster);
					fda.setVisible(true);
				}
				
			}
		});
		
		}
}