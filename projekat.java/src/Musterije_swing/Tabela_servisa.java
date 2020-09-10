package Musterije_swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

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
import Moduli.Automobil;
import Moduli.Musterija;
import Moduli.Servis;
import Moduli.Serviser;
import Liste.Liste;

public class Tabela_servisa extends JFrame {

	
	private JToolBar main_tool_bar = new JToolBar();
	private JButton btnAdd = new JButton("Dodaj");
	private JButton btnEdit = new JButton("Izmeni");
	
	private DefaultTableModel table_model;
	private JTable servisi_tabela;
	
	private Liste listee;
	private Musterija musterija;
	
	public Tabela_servisa(Liste listee,Musterija musterija) {
		this.listee = listee;
		this.musterija = musterija;
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

		ArrayList<Servis> njegovi = new ArrayList<Servis>();
		for(Automobil a : musterija.getAuti()) {
			for(Servis s : listee.getServisi()) {
				if(s.getAuto_za_servis().getId() == a.getId()) {
					njegovi.add(s);
				}
			}
		}
		
		add(main_tool_bar, BorderLayout.SOUTH);
		String[] zaglavlje = new String[] {"ID", "Auto za servis", "Serviser", "Termin" ,"Opis", "Status servisa"};
		Object[][] sadrzaj = new Object[njegovi.size()][zaglavlje.length];
		
		for(int i = 0; i < njegovi.size(); i ++) {
			Servis ser = njegovi.get(i);
			sadrzaj[i][0] = ser.getId();
			sadrzaj[i][1] = ser.getAuto_za_servis().getMarka() + "-" + ser.getAuto_za_servis().getModel();
			sadrzaj[i][2] = ser.getServiser().getPrezime();
			sadrzaj[i][3] = ser.getTermin();
			sadrzaj[i][4] = ser.getOpis();
			sadrzaj[i][5] = ser.getStatus_servisa();
			

		
		
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
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				dodaj_izmeni_servis fda = new dodaj_izmeni_servis(listee, null, musterija);
				fda.setVisible(true);
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
					dodaj_izmeni_servis fda = new dodaj_izmeni_servis(listee, s, musterija);
					fda.setVisible(true);
				}
				
			}
		});

	}
}