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
import Moduli.Automobil;
import Moduli.Servis;
import Liste.Liste;

public class Tabela_automobila extends JFrame {


	private JToolBar main_tool_bar = new JToolBar();
	private JButton btnAdd = new JButton("Dodaj");
	private JButton btnEdit = new JButton("Izmeni");
	private JButton btnDelete = new JButton("Obrisi");
	
	private DefaultTableModel table_model;
	private JTable automobili_tabela;
	
	private Liste listee;
	
	public Tabela_automobila(Liste listee) {
		this.listee = listee;
		setTitle("Pregled automobila");
		setSize(800, 300);
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
		String[] zaglavlje = new String[] {"ID", "Vlasnik", "Marka", "Model" ,"Godiste", "Zapremina u cm", "Snaga u ks", "Vrsta goriva"};
		Object[][] sadrzaj = new Object[listee.getAutomobili().size()][zaglavlje.length];
		
		for(int i = 0; i < listee.getAutomobili().size(); i ++) {
			Automobil aut = listee.getAutomobili().get(i);
			sadrzaj[i][0] = aut.getId();
			sadrzaj[i][1] = aut.getVlasnik().getKorisnicko_ime();
			sadrzaj[i][2] = aut.getMarka();
			sadrzaj[i][3] = aut.getModel();
			sadrzaj[i][4] = aut.getGodina_proizvodnje();
			sadrzaj[i][5] = aut.getZapremina_motora();
			sadrzaj[i][6] = aut.getSnaga_motora();
			sadrzaj[i][7] = aut.getVrsta_goriva();

		
		
		}
		
		table_model = new DefaultTableModel(sadrzaj, zaglavlje);
		automobili_tabela = new JTable(table_model);
		
		automobili_tabela.setRowSelectionAllowed(true);
		automobili_tabela.setColumnSelectionAllowed(false);
		automobili_tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		automobili_tabela.setDefaultEditor(Object.class, null);
		automobili_tabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane jsp = new JScrollPane(automobili_tabela);
		add(jsp, BorderLayout.CENTER);
	
	}
	
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int red = automobili_tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Odaberite automobil koji zelite da obrisete.", "Greska!", JOptionPane.WARNING_MESSAGE);
				}else {
					int id = Integer.parseInt(table_model.getValueAt(red,  0).toString());
					Automobil auto = listee.NadjiAutomobil(id);
					int idvlasnika = auto.getVlasnik().getId();
					int idsk = auto.getServisna_knjizica().getId();
					int izbor = JOptionPane.showConfirmDialog(null, "Obrisi automobil: " + id + "?", "Neophodna potvrda.",JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						listee.getMusterije().remove(listee.NadjiMusteriju(idvlasnika));
						listee.getServisne_knjizice().remove(listee.NadjiServisnuKnjizicu(idsk));
						listee.getAutomobili().remove(auto);
						table_model.removeRow(red);
						JOptionPane.showMessageDialog(null, "Automobil sa ID: " + id + " obrisan!");
						listee.upisiSvih();
					}
					
					
							
				}
				
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				dodaj_izmeni_automobil fda = new dodaj_izmeni_automobil(listee, null);
				fda.setVisible(true);
				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int red = automobili_tabela.getSelectedRow();
				if (red == -1) {
					JOptionPane.showMessageDialog(null, "Odaberite red za izmenu.", "Greska!", JOptionPane.WARNING_MESSAGE);
					
				}else {
					String idd = table_model.getValueAt(red, 0).toString();
					Automobil s = listee.NadjiAutomobil(Integer.parseInt(idd));
					dodaj_izmeni_automobil fda = new dodaj_izmeni_automobil(listee, s);
					fda.setVisible(true);
				}
				
			}
		});

		}
}