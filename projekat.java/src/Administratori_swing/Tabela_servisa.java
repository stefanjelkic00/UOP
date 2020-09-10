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

import Liste.Liste;
import Moduli.Administrator;
import Moduli.Servis;
import Moduli.Serviser;
import Liste.Liste;

public class Tabela_servisa extends JFrame {

	
	private JToolBar main_tool_bar = new JToolBar();
	private JButton btnAdd = new JButton("Dodaj");
	private JButton btnEdit = new JButton("Izmeni");
	private JButton btnDelete = new JButton("Obrisi");
	
	private DefaultTableModel table_model;
	private JTable servisi_tabela;
	
	private Liste listee;
	
	public Tabela_servisa(Liste listee) {
		this.listee = listee;
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

		add(main_tool_bar, BorderLayout.SOUTH);
		String[] zaglavlje = new String[] {"ID", "Auto za servis", "Serviser", "Termin" ,"Opis", "Status servisa"};
		Object[][] sadrzaj = new Object[listee.getServisi().size()][zaglavlje.length];
		
		for(int i = 0; i < listee.getServisi().size(); i ++) {
			Servis ser = listee.getServisi().get(i);
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
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int red = servisi_tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Odaberite servis koji zelite da obrisete.", "Greska!", JOptionPane.WARNING_MESSAGE);
				}else {
					int id = Integer.parseInt(table_model.getValueAt(red,  0).toString());
					Servis ser = listee.NadjiServis(id);
					int izbor = JOptionPane.showConfirmDialog(null, "Obrisi servis: " + id + "?", "Neophodna potvrda.",JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						listee.getServisi().remove(ser);
						table_model.removeRow(red);
						JOptionPane.showMessageDialog(null, "Servis " + id + " obrisan!");
						listee.upisiSvih();
					}
					
					
							
				}
				
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				dodaj_izmeni_servis fda = new dodaj_izmeni_servis(listee, null);
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
					dodaj_izmeni_servis fda = new dodaj_izmeni_servis(listee, s);
					fda.setVisible(true);
				}
				
			}
		});

		}
}
