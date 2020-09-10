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

import Moduli.Servis;
import Moduli.Servisna_knjizica;
import Liste.Liste;

public class Tabela_servisnih_knjizica extends JFrame {

	
	
	private JToolBar main_tool_bar = new JToolBar();
	private JButton btnAdd = new JButton("Dodaj");
	private JButton btnDelete = new JButton("Obrisi");
	
	private DefaultTableModel table_model;
	private JTable servisne_knjizice_tabela;
	
	private Liste listee;
	
	public Tabela_servisnih_knjizica(Liste listee) {
		this.listee = listee;
		setTitle("Pregled Servisnih Knjizica");
		setSize(500, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		
	}
	private void initGUI() {

		
		
		main_tool_bar.add(btnAdd);
		main_tool_bar.add(btnDelete);

		add(main_tool_bar, BorderLayout.SOUTH);
		String[] zaglavlje = new String[] {"ID", "Automobil", "Obavljeni servisi"};
		Object[][] sadrzaj = new Object[listee.getServisne_knjizice().size()][zaglavlje.length];
		
		for(int i = 0; i < listee.getServisne_knjizice().size(); i ++) {
			Servisna_knjizica sk = listee.getServisne_knjizice().get(i);
			sadrzaj[i][0] = sk.getId();
			sadrzaj[i][1] = sk.getAutomobil().getMarka() + "-" + sk.getAutomobil().getModel();
			String obavljeni = " ";
			for(Servis s : sk.getObavljeni_servisi()) {
				obavljeni += s.getOpis() + ",";
			}
			sadrzaj[i][2] = obavljeni.substring(0, obavljeni.length() - 1);	
		
		}
		
		table_model = new DefaultTableModel(sadrzaj, zaglavlje);
		servisne_knjizice_tabela = new JTable(table_model);
		
		servisne_knjizice_tabela.setRowSelectionAllowed(true);
		servisne_knjizice_tabela.setColumnSelectionAllowed(false);
		servisne_knjizice_tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		servisne_knjizice_tabela.setDefaultEditor(Object.class, null);
		servisne_knjizice_tabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane jsp = new JScrollPane(servisne_knjizice_tabela);
		add(jsp, BorderLayout.CENTER);
	
	}
	
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int red = servisne_knjizice_tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Odaberite servisnu knjizicu koju zelite da obrisete.", "Greska!", JOptionPane.WARNING_MESSAGE);
				}else {
					int id = Integer.parseInt(table_model.getValueAt(red,  0).toString());
					Servisna_knjizica ser_knj = listee.NadjiServisnuKnjizicu(id);
					int idauta = 0;
					int idmusterije = 0;
					int izbor = JOptionPane.showConfirmDialog(null, "Obrisi servisnu knjizicu?: " + id + "?", "Neophodna potvrda.",JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						idauta = ser_knj.getAutomobil().getId();
						idmusterije = ser_knj.getAutomobil().getVlasnik().getId();
						listee.getServisne_knjizice().remove(ser_knj);
						listee.getMusterije().remove(listee.NadjiMusteriju(idmusterije));
						listee.getAutomobili().remove(listee.NadjiAutomobil(idauta));
						table_model.removeRow(red);
						JOptionPane.showMessageDialog(null, "Servisna knjizica " + id + " obrisana!");
						listee.upisiSvih();
					}
					
					
							
				}
				
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
					dodaj_izmeni_servisnu_knjizicu fda = new dodaj_izmeni_servisnu_knjizicu(listee,null);
					fda.setVisible(true);
					
			
				}
			
		});
		

		
	}
}
