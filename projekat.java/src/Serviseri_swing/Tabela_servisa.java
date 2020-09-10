package Serviseri_swing;

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
import javax.swing.table.TableModel;

import Moduli.Automobil;
import Moduli.Deo;
import Moduli.Musterija;
import Moduli.Servis;
import Moduli.Serviser;
import Serviseri_swing.dodaj_izmeni_servis;
import enumi.Status_servisa;
import Liste.Liste;

public class Tabela_servisa extends JFrame {


	
	private JToolBar main_tool_bar = new JToolBar();
	private JButton btnAdd = new JButton("Dodaj");
	private JButton btnEdit = new JButton("Izmeni");
	private JButton btnDelete = new JButton("Obrisi");
	private JButton btnZavrsi = new JButton("Zavrsi servis"); 
	private DefaultTableModel table_model;
	private JTable servisi_tabela;
	
	private Liste listee;
	private Serviser serviser;
	
	public Tabela_servisa(Liste listee, Serviser s) {
		this.listee = listee;
		this.serviser = s;
		setTitle("Pregled servisa");
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
		main_tool_bar.add(btnZavrsi);
		add(main_tool_bar, BorderLayout.SOUTH);
		String[] zaglavlje = new String[] {"Id", "Auto za servis", "Termin" ,"Opis", "Status servisa"};
		Object[][] sadrzaj = new Object[serviser.getServisi_gde_je_zaduzen().size()][zaglavlje.length];
		
		for(int i = 0; i < serviser.getServisi_gde_je_zaduzen().size(); i ++) {
			Servis ser = serviser.getServisi_gde_je_zaduzen().get(i);
			sadrzaj[i][0] = ser.getId();
			sadrzaj[i][1] = ser.getAuto_za_servis().getMarka() + "-" + ser.getAuto_za_servis().getModel();
			sadrzaj[i][2] = ser.getTermin();
			sadrzaj[i][3] = ser.getOpis();
			sadrzaj[i][4] = ser.getStatus_servisa();
			

		
		
		}
		
		table_model = new DefaultTableModel(sadrzaj, zaglavlje);
		servisi_tabela = new JTable(table_model);
		
		servisi_tabela.setRowSelectionAllowed(true);
		servisi_tabela.setColumnSelectionAllowed(false);
		servisi_tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		servisi_tabela.setDefaultEditor(Object.class, null);
		servisi_tabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane jsp = new JScrollPane(servisi_tabela);
		add(jsp, BorderLayout.CENTER);
	
	}
	
	private void initActions() {
		btnZavrsi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int red = servisi_tabela.getSelectedRow();
				if(red == -1) JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
				else {
					String oznaka = table_model.getValueAt(red,0).toString();
					Servis serv = listee.NadjiServis(Integer.parseInt(oznaka));
					if(serv.getStatus_servisa() != null) 
						if(serv.getStatus_servisa().equals(Status_servisa.izvrsen)){
							JOptionPane.showMessageDialog(null, "Ne mozete zavrsiti vec zavrsen ili otkazan servis","Greska", JOptionPane.WARNING_MESSAGE);
							
					} else {
						int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da zavrsite servis:"+serv.getOpis()+"?","Potvrda zavrsavanja",JOptionPane.YES_NO_OPTION);
						if(izbor == JOptionPane.YES_OPTION) {
							serv.setStatus_servisa(Status_servisa.izvrsen);
							Musterija must = serv.getAuto_za_servis().getVlasnik();
							int izborPopust = JOptionPane.showConfirmDialog(null, "Da li musterija zeli da iskoristi bodove ("+ must.getBroj_nagradnih_bodova()+ ") za popust za servis:" + serv.getOpis()+ "?", "Potvrda koriscenja popusta", JOptionPane.YES_NO_OPTION);
							if(izborPopust == JOptionPane.YES_OPTION) {
								String izbor1 = JOptionPane.showInputDialog("Unesite cenu");
								
								int cena_delova = 0 ;
								for(Deo d : serv.getUpotrebljeni_delovi()) {
									cena_delova += d.getCena();
								}
								int cena = (cena_delova + Integer.parseInt(izbor1))- ((cena_delova + Integer.parseInt(izbor1))*2/100)* must.getBroj_nagradnih_bodova();
								JOptionPane.showMessageDialog(null, "Cena servisa sa popustom"+ cena + "\n" , "Popust" ,JOptionPane.WARNING_MESSAGE);
								must.setBroj_nagradnih_bodova(0);
								
																
							}else {
								must.setBroj_nagradnih_bodova(must.getBroj_nagradnih_bodova()+1);
							}
						}
						listee.upisiSvih();
						Tabela_servisa.this.dispose();
						Tabela_servisa ps = new Tabela_servisa(listee,serviser);
						ps.setVisible(true);
						
					}
						
				}
				
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				dodaj_izmeni_servis sfs = new dodaj_izmeni_servis(listee, null, serviser);
				sfs.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int red = servisi_tabela.getSelectedRow();
				if (red == -1) {
					JOptionPane.showMessageDialog(null, "Odaberite red za izmenu.", "Greska!", JOptionPane.WARNING_MESSAGE);
					
				}else {
					String idd = table_model.getValueAt(red, 0).toString();
					Servis s = listee.NadjiServis(Integer.parseInt(idd));
					dodaj_izmeni_servis sfs = new dodaj_izmeni_servis(listee, s, serviser);
					sfs.setVisible(true);
				}
				
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int red = servisi_tabela.getSelectedRow();
				if (red == -1) {
					JOptionPane.showMessageDialog(null, "Odaberite red za izmenu.", "Greska!", JOptionPane.WARNING_MESSAGE);
					
				}else {
					String idd = table_model.getValueAt(red, 0).toString();
					Servis s = listee.NadjiServis(Integer.parseInt(idd));
					listee.getServisi().remove(s);
				}
			}
			
		});

		

}

}